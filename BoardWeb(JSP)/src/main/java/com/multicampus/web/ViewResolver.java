package com.multicampus.web;

public class ViewResolver {

	private String prefix;
	private String suffix;

	public ViewResolver(String prefix, String suffix) {
		this.prefix = prefix;
		this.suffix = suffix;
	}

	public String getView(String viewName) {
		return prefix + viewName + suffix;
	}

}