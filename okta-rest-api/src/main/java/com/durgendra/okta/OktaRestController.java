package com.durgendra.okta;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OktaRestController {
	
	@GetMapping("/welcome")
	public String sampleAPI() {
		return "welcome";
	}

}
