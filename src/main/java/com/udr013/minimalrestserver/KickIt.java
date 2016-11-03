package com.udr013.minimalrestserver;

// this is the application class for jaxrs
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

//this annotation looks for all resources with @Path and expose them on this path
@ApplicationPath("webapi")
public class KickIt extends Application {
}
