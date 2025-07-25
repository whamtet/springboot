package io.simpleui.springpoint;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import clojure.java.api.Clojure;
import clojure.lang.IFn;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@SpringBootApplication
public class SpringpointApplication {

	private static IFn handler;
	
	static {
		IFn loadString = Clojure.var("clojure.core", "load-string");
		loadString.invoke("(require 'springpoint.core)");
		handler = Clojure.var("springpoint.core", "handler");
	}

	@RequestMapping("/**")
	String home(HttpServletRequest request, HttpServletResponse response) {
		return (String) handler.invoke(request, response);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringpointApplication.class, args);
	}

}
