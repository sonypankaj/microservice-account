package com.pankajsoni.microservice.servicecommunication;

import javax.inject.Named;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

	@Named
	static class JerseyConfig extends ResourceConfig {
		public JerseyConfig() {
			this.packages("com.pankajsoni.microservice.servicecommunication.rest");
			this.packages("com.pankajsoni.microservice.servicecommunication.service");

		}
	}

}