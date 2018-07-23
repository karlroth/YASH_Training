package com.yash.pojofactory.main;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.yash.controller.ApplicationController;
import com.yash.pojo.Application;
import com.yash.pojofactory.exception.DOMParserException;
import com.yash.pojofactory.factory.PojoFactory;
import com.yash.pojofactory.factory.XMLPojoFactory;
import com.yash.service.ApplicationService;

public class StartUp {
	
	public static void main(String[] args) {
		
		PojoFactory pojoFactory;
		try {
			pojoFactory = new XMLPojoFactory("pojos.xml");
			Application application = (Application) pojoFactory.getPojo("application");
			application.display();
			
			ApplicationController appCtrl = (ApplicationController) pojoFactory.getPojo("appCtrl");
			appCtrl.display();
			
			ApplicationService appService = (ApplicationService) pojoFactory.getPojo("appService");
			appService.display();
			
		} catch (ParserConfigurationException | SAXException | IOException | InstantiationException | IllegalAccessException | ClassNotFoundException | DOMParserException e) {
			e.getMessage();
		}
		
		
	}
}
