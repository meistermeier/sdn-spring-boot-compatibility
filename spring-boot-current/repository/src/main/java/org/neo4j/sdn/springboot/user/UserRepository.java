package org.neo4j.sdn.springboot.user;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface UserRepository extends Neo4jRepository<User, Long> {

  List<User> findByName(String name);

  User findByAddressAddressString(String addressValue);
}
