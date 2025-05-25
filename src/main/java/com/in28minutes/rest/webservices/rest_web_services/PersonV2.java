package com.in28minutes.rest.webservices.rest_web_services;

import org.springframework.stereotype.Component;


public class PersonV2 {
private Name name;

public PersonV2(Name name) {
	super();
	this.name = name;
}


public Name getName() {
	return name;
}


@Override
public String toString() {
	return "PersonV2 [name=" + name + "]";
}

}
