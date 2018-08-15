package org.neo4j.sdn.springboot;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.After;
import org.junit.Assume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.ogm.testutil.MultiDriverTestClass;
import org.neo4j.sdn.springboot.user.Address;
import org.neo4j.sdn.springboot.user.Hobby;
import org.neo4j.sdn.springboot.user.User;
import org.neo4j.sdn.springboot.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SdnWithSpringBootTest extends MultiDriverTestClass {

  @Value("${ogm.version}")
  private String ogmVersion;

  @Autowired
  private UserRepository userRepository;

  @After
  public void clearUsers() {
	userRepository.deleteAll();
  }

  @Test
  public void contextLoads() {
	assertThat(userRepository).isNotNull();
  }

  @Test
  public void findUserByNameDerivedQuery() {
	List<User> users = userRepository.findByName("test");
	assertThat(users).hasSize(0);
  }

  @Test
  public void findUserByProvidedFindAll() {
	Iterable<User> users = userRepository.findAll();
	assertThat(users).hasSize(0);
  }

  @Test
  public void createUserWithHobbies() {
	String userName = "test";
	User user = new User();
	user.setName(userName);

	Hobby football = new Hobby();
	football.setDescription("Football");
	Hobby baseball = new Hobby();
	football.setDescription("Baseball");

	user.addHobby(football);
	user.addHobby(baseball);

	userRepository.save(user);

	List<User> users = userRepository.findByName(userName);

	assertThat(users).hasSize(1);
	User userFromDb = users.get(0);
	assertThat(userFromDb).isEqualTo(user);
	assertThat(userFromDb.getHobbies()).contains(football, baseball);
  }

  @Test
  public void findUserByAddressNestedProperty() {
	// the test will work with 3.0.4 and 3.1.1 (once the later is released)
	assertThat(ogmVersion).isNotNull();
	Assume.assumeTrue(!ogmVersion.startsWith("3.1.0"));
	String userName = "test";
	User user = new User();
	user.setName(userName);
	String addressValue = "Somewhere over the rainbow";
	Address address = new Address();
	address.setAddressString(addressValue);
	user.setAddress(address);
	userRepository.save(user);

	User userFromDb = userRepository.findByAddressAddressString(addressValue);
	assertThat(userFromDb).isNotNull();

  }

}
