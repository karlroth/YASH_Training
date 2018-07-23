package com.yash.strassignment.util;
import java.lang.StringBuilder;
import com.yash.strassignment.model.*;

public class JSonUtil {

	
	public void jsonToObject(String json) {
		
		User user = new User();
		String[] elements = json.split(",");
		
		String element = ""; //TODO: add logic to get element name
		
		if(element == "first_name") {
			user.setFirstName("");
		} else if (element == "last_name") {
			user.setLastName("");
		} else if (element == "")
		
		
		
		
		
		
		
	}
	
	public String objectToJSon(Object object) {
		StringBuilder output = new StringBuilder("{");
		
		
		
	}
}
