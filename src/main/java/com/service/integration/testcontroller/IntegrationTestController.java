package com.service.integration.testcontroller;

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.service.integration.service.JSONValidationService;

@RestController
public class IntegrationTestController {
	
	@Autowired
	private JSONValidationService jsonValidationService;
	
	@GetMapping("/validateJson")
	public String data() throws ProcessingException, IOException, AddressException, MessagingException{
		File schemaFile = ResourceUtils.getFile("classpath:input-schema/schema.json");
	    String jsonFile = "{\r\n" + 
	    		"    \"id\": 1,\r\n" + 
	    		"    \"name\": \"A green door\",\r\n" + 
	    		"    \"price\": 12.50,\r\n" + 
	    		"    \"tags\": [\"home\", \"green\"]\r\n" + 
	    		"}";
	    	
	    if (jsonValidationService.isJsonValid(schemaFile, jsonFile)){
	    	System.out.println("Valid! ");
	    	return "Valid!";
	    }else{
	    	System.out.println("NOT valid! ");
	    	return "NOT valid!";
	    }
    }
}
