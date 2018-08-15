package org.neo4j.sdn.springboot.user;

import java.util.Objects;

// @NodeEntity implicit find not annotated classes
public class Hobby {

  // implicit id definition
  private Long id;

  private String description;

  public void setDescription(String description) {
	this.description = description;
  }

  public String getDescription() {
	return description;
  }

  // stupid implementation for simpler tests
  @Override
  public boolean equals(Object o) {
	if (this == o)
	  return true;
	if (o == null || getClass() != o.getClass())
	  return false;
	Hobby hobby = (Hobby) o;
	return Objects.equals(description, hobby.description);
  }

  @Override
  public int hashCode() {
	return Objects.hash(description);
  }
}
