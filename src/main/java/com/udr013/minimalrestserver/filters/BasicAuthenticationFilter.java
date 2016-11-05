package com.udr013.minimalrestserver.filters;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

@Provider
public class BasicAuthenticationFilter implements ContainerRequestFilter{
	@Override
	public void filter(ContainerRequestContext containerRequestContext) throws IOException {

		List<String> authHeaders = containerRequestContext.getHeaders().get("authorization");

		if (authHeaders.size() != 0) {
			System.out.println("AuthHeaders size: " + authHeaders.size());
			System.out.println("AuthHeader at index 0: " + authHeaders.get(0));
			String decoded = org.glassfish.jersey.internal.util.Base64.decodeAsString(authHeaders.get(0).replace("Basic ", ""));
			// the decoded string is the combination "name:password" Base64is in no way secure it's just because name
			// and password can contain characters that are not suitable far a url
			System.out.println("decoded: " + decoded);
			StringTokenizer token = new StringTokenizer(decoded,":");
			System.out.println("count tokens" + token.countTokens());
			String name = token.nextToken();
			System.out.println(name);
			System.out.println("count tokens" + token.countTokens());
			String password = token.nextToken();
			System.out.println(password);
			System.out.println("count tokens" + token.countTokens());

			if(!name.equals("mark") || !password.equals("test")){
//				Response.status(Response.Status.UNAUTHORIZED).entity("Your not Authorized").build();
				containerRequestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity("You are not " +
						"Authorized!").build());

			}else{
				System.out.println(" i Know it's you :)");
			}

		}
	}
}
