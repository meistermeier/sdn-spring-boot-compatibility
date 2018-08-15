package org.neo4j.sdn.springboot.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class User {

  // Explicit define the id with annotations
  @Id
  @GeneratedValue
  private Long id;

  private String name;

  private Address address;

  private List<Hobby> hobbies;

  public String getName() {
	return name;
  }

  public void setAddress(Address address) {
	this.address = address;
  }

  public List<Hobby> getHobbies() {
	return hobbies;
  }

  public void addHobby(Hobby hobby) {
	if (hobbies == null) {
	  hobbies = new ArrayList<>();
	}

	hobbies.add(hobby);

  }

  public void setName(String name) {
	this.name = name;
  }

  // stupid implementation for simpler tests
  @Override
  public boolean equals(Object o) {
	if (this == o)
	  return true;
	if (o == null || getClass() != o.getClass())
	  return false;
	User user = (User) o;
	return Objects.equals(name, user.name);
  }

  @Override
  public int hashCode() {
	return Objects.hash(name);
  }
}
