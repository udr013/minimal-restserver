package com.udr013.jaxrsdemo.filters;


import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider //Register the filter to rs
public class PoweredByResponseFilter implements ContainerResponseFilter{
	@Override
	public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
		containerResponseContext.getHeaders().add("PoweredBy", "Udr013");
	}
}
