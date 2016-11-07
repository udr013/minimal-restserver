package com.udr013.minimalrestserver.filters;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class LoggingFilter implements ContainerRequestFilter, ContainerResponseFilter {

	String s = " now changed";

	@Override
	public void filter(ContainerRequestContext containerRequestContext) throws IOException {
		System.out.println("Request: " + containerRequestContext.getHeaders().keySet().toString());
		System.out.println("Request: " + containerRequestContext.getHeaders().values());
		System.out.println("Request: " + containerRequestContext.getHeaders());
		System.out.println("Request: " + containerRequestContext.getEntityStream());
	}


	@Override
	public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
		System.out.println("Response: " + containerResponseContext.getHeaders().keySet().toString());
		System.out.println("Response: " + containerResponseContext.getHeaders().values());
		System.out.println("Response: " + containerResponseContext.getHeaders());          //
		System.out.println("Response: " + containerResponseContext.getAllowedMethods());
		System.out.println("Response: " + containerResponseContext.getEntityClass());
		System.out.println("Response: " + containerResponseContext.getEntity());
		containerResponseContext.setEntity(s);
		System.out.println("Response: " + containerResponseContext.getEntity());
		System.out.println("Response: " + containerResponseContext.getStringHeaders());     //

	}
}
