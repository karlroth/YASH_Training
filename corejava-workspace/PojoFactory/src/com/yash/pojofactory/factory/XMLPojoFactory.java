package com.yash.pojofactory.factory;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.yash.pojofactory.exception.DOMParserException;

import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;

public class XMLPojoFactory implements PojoFactory {

	private Document doc;
	private NodeList nList;
	
	public XMLPojoFactory(String filename) throws ParserConfigurationException, SAXException, IOException {
		File fXmlFile = new File(filename);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		doc = dBuilder.parse(fXmlFile);
		nList = doc.getElementsByTagName("pojo");
	}
	
	@Override
	public Object getPojo(String id) throws InstantiationException, IllegalAccessException, ClassNotFoundException, DOMParserException {
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Element pojoElem = (Element) nList.item(temp);		
			if (pojoElem.getAttribute("id").equals(id)) {			
				String className = pojoElem.getAttribute("class");
				return Class.forName(className).newInstance();
			}
		}
		throw new DOMParserException("The id: "+id+" does not exist");
		
	}

}
