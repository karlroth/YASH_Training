package com.yash.pojofactory.factory;

import com.yash.pojofactory.exception.DOMParserException;

public interface PojoFactory {

	public Object getPojo(String id) throws InstantiationException, IllegalAccessException, ClassNotFoundException, DOMParserException;
}
