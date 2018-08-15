package org.neo4j.sdn.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories(basePackages = "org.neo4j.sdn.springboot.user")
@EntityScan(basePackages = "org.neo4j.sdn.springboot.user")
public class SdnWithSpringBoot {

  public static void main(String[] args) {
	SpringApplication.run(SdnWithSpringBoot.class, args);
  }
}
