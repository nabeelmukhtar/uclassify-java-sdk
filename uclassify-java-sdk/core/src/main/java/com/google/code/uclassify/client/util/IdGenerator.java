/*
 * Copyright 2010 Nabeel Mukhtar 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 */
package com.google.code.uclassify.client.util;

/**
 * The Class IdGenerator.
 * 
 * @author nmukhtar
 */
public class IdGenerator {
	
	/** The counter. */
	int counter;
	
	/**
	 * Instantiates a new id generator.
	 */
	private IdGenerator() {}
	
	/**
	 * New instance.
	 * 
	 * @return the id generator
	 */
	public static IdGenerator newInstance() {
		return new IdGenerator();
	}
	
	/**
	 * Generate id.
	 * 
	 * @return the string
	 */
	public String generateId() {
		return String.valueOf(counter++);
	}
	
	/**
	 * Generate id.
	 * 
	 * @param prefix the prefix
	 * 
	 * @return the string
	 */
	public String generateId(String prefix) {
		return prefix + generateId();
	}
}
