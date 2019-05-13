package com.service.integration.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.service.integration.constraint.Roles;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Aspect
@Component
public class ServiceAspect {

	//@After(value = "execution(* com.service.security.jwtsecurity.aspect.EmployeeService.*(..)) and args(name,empId,ls) && @annotation(com.service.security.jwtsecurity.constraint.Roles)")
	@After(value = "execution(* com.service.integration.controller.*.*(..)) and args(httpServletRequest)")
	public void afterAdvice(JoinPoint joinPoint,HttpServletRequest httpServletRequest) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        if (method.isAnnotationPresent(Roles.class)) 
        {
        	Annotation annotation = method.getAnnotation(Roles.class);
            Roles roles = (Roles) annotation;
            Boolean authorize= false;
            
            String header = httpServletRequest.getHeader("Authorization");
            Claims body = Jwts.parser()
                    .setSigningKey("#21@365")
                    .parseClaimsJws(header)
                    .getBody();
            
    		System.out.println("Value :"+body);
    		for (String tag : roles.value()) 
    		{ 
    			if(tag.equalsIgnoreCase((String)body.get("role")))
    			{
    				authorize=true;
    			} 
    		}
    		if(!authorize)
    		{
    			throw new RuntimeException("USER IS NOT AUTHORIZED TO ACCESS THIS METHOD!!");
    		}
        }
	}
	
}
