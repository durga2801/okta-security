package com.durgendra.okta;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

@Service
public class JWTRequestFilter extends OncePerRequestFilter{

	@Value("${okta.client.provider.issuer-uri}")
	private String issuerUri;
	
	@Value("${okta.client.registration.client-id}")
	private String clientId;
	
	@Value("${okta.client.registration.client-secret}")
	private String clientSecret;
	
	RestTemplate restTemplate = new RestTemplate();
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = request.getHeader("Authorization");
		if(!validate(token)) {
			response.sendError(401);
		}
		filterChain.doFilter(request, response);
	}
	
	private boolean validate(String token) {
		String uri = issuerUri+"/v1/introspect?client_id="+clientId+"&client_secret="+clientSecret;
		uri = uri+"&token="+token.replace("Bearer ", "");
		System.out.println(uri);
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE.toString(), MediaType.APPLICATION_FORM_URLENCODED.toString());
		HttpEntity httpEntity = new HttpEntity<String>(headers);
		ResponseEntity<HashMap> response = restTemplate.postForEntity(uri, httpEntity, HashMap.class);
		Map<String, Object> responseBody = response.getBody();
		System.out.println(responseBody);
		return (boolean) responseBody.get("active");
	}
	
}
