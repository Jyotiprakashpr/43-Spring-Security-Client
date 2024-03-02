package com.ashokit;

import java.util.Base64;
import java.util.Base64.Encoder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		RestTemplate rt = new RestTemplate();
		String Url = "http://localhost:9090/welcome";
		String unamePwd = "admin:admin@123";
		Encoder encoder = Base64.getEncoder();
		String encodeUnamePwd = encoder.encodeToString(unamePwd.getBytes());
		System.out.println("EncodeUnamePwd ::"+encodeUnamePwd);
	   String authHeaderValue   =	"Basic"+encodeUnamePwd;
	   String authHeader = "Authorization";
	   
	   HttpHeaders headers = new HttpHeaders();
	   headers.add("Authorization", "Basic YWRtaW46YWRtaW5AMTIz");
	   headers.add(authHeader, authHeaderValue);
	   HttpEntity entity = new HttpEntity<>(headers);
	   ResponseEntity<String>responseEntity = rt.exchange(Url, HttpMethod.GET, entity, String.class);
	   
	 Integer statusCode= responseEntity.getStatusCodeValue();
	 String body = responseEntity.getBody();
	 System.out.println("Status Code ::"+statusCode);
	 System.out.println("Response Body::"+body);
	}

}
