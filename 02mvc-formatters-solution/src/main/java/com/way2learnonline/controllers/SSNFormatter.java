package com.way2learnonline.controllers;

import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;
import com.way2learnonline.entity.SocialSecurityNumber;
	
	public class SSNFormatter implements Formatter<SocialSecurityNumber> {
		
	
		@Override
		public String print(SocialSecurityNumber ssn, Locale locale) {
			
			return ssn.getArea()+"-"+ssn.getGroup()+"-"+ssn.getSerial();
		}
	
		@Override
		public SocialSecurityNumber parse(String text, Locale locale)
				throws ParseException {
			SocialSecurityNumber ssn= new SocialSecurityNumber();
			ssn.setArea(text.substring(0,3));
			ssn.setGroup(text.substring(4,6));
			ssn.setSerial(text.substring(7,11));
			return ssn;
		}
	
	}
