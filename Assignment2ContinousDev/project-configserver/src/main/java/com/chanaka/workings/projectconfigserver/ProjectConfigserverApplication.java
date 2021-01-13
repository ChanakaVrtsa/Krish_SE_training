package com.chanaka.workings.projectconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ProjectConfigserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectConfigserverApplication.class, args);
	}

}
