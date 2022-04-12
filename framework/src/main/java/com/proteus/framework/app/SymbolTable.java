package com.proteus.framework.app;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SymbolTable {
	
	protected static final Logger L = LoggerFactory.getLogger(SymbolTable.class);

  private Map<String,AbstractBaseExtendedContext> map;

	public SymbolTable(){
		map = new HashMap<String,AbstractBaseExtendedContext>();
	}

	public void put(String key, AbstractBaseExtendedContext value){
		map.put(key,value);
	}

	public boolean contains(String key){
		return map.containsKey(key);
	}

	public void remove(String key) {
		map.remove(key);
	}

	//get("chain.group.element.field")
	public AbstractBaseExtendedContext get(String key){
			return map.get(key);
	}

}
