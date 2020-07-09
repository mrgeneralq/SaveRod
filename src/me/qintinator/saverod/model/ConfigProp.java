package me.qintinator.saverod.model;

import me.qintinator.saverod.enums.ConfigProperty;

public class ConfigProp {
	
	
	private ConfigProperty property;
	private Object type;
	private String path;
	
	
	public ConfigProp(ConfigProperty property, String path) {
		this.property = property;
		this.path = path;
	}


	public ConfigProperty getProperty() {
		return property;
	}


	public Object getType() {
		return type;
	}


	public String getPath() {
		return path;
	}
	

}
