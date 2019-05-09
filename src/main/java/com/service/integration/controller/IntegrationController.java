package com.service.integration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.integration.config.CommonConfigurations;
import com.service.integration.config.ConfigService;

@RestController
public class IntegrationController {
	
	@Autowired
	private ConfigService configService;
	
	
	@RequestMapping("/header")
	public @ResponseBody CommonConfigurations checkHeader(@RequestHeader(value="service_type",required=true) String service_type) {
		CommonConfigurations commonConfigurations=null;
		if(configService.getServicemapper().containsKey(service_type))
		{
			commonConfigurations=configService.getServicemapper().get(service_type);
		}
		return commonConfigurations;
	}

}
