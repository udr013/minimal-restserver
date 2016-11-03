package com.udr013.minimalrestserver;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/blabla")
public class Resource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String testMethod(){
		return " here we go!";
	}
}
