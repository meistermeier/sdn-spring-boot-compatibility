package org.neo4j.sdn.springboot.user;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Address {

  private Long id;

  private String addressString;

  public Address(String addressString) {
	this.addressString = addressString;
  }

  public String getAddressString() {
	return addressString;
  }
}
