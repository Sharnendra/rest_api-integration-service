package com.service.integration.controller;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IntegrationController {
	
	@RequestMapping("/header")
	public String checkHeader(@RequestHeader(value="service_type",required=true) String service_type) {
		return "Hearder Requred";
	}

}
