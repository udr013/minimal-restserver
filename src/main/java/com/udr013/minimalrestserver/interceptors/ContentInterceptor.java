package com.udr013.minimalrestserver.interceptors;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;
import java.io.IOException;

@Provider
public class ContentInterceptor implements WriterInterceptor {

	String s = "We intercept the request";

	@Override
	public void aroundWriteTo(WriterInterceptorContext writerInterceptorContext) throws IOException, WebApplicationException {

		System.out.println("getEntity: " + writerInterceptorContext.getEntity());
		System.out.println("getHeaders:" + writerInterceptorContext.getHeaders());
		System.out.println("getOutputStream: "+ writerInterceptorContext.getOutputStream().toString());
		System.out.println(writerInterceptorContext.getPropertyNames());
		System.out.println(writerInterceptorContext.getGenericType());
		System.out.println(writerInterceptorContext.getGenericType().getTypeName());
		System.out.println(writerInterceptorContext.getAnnotations().toString());
		System.out.println(writerInterceptorContext.getMediaType());
		writerInterceptorContext.setEntity(s);
//		buildContext(writerInterceptorContext)
//				.setResponseEntity(writerInterceptorContext.getEntity())
//				.build();
		System.out.println("getEntitytoString: " + writerInterceptorContext.getEntity().toString());

		System.out.println(writerInterceptorContext.getMediaType());
		System.out.println(writerInterceptorContext);
		System.out.println(writerInterceptorContext.getMediaType());

	}
}
