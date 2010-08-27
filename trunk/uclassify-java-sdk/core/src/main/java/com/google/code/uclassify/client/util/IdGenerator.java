/**
 * 
 */
package com.google.code.uclassify.client.util;

/**
 * @author nmukhtar
 *
 */
public class IdGenerator {
	int counter;
	
	private IdGenerator() {}
	
	public static IdGenerator newInstance() {
		return new IdGenerator();
	}
	public String generateId() {
		return String.valueOf(counter++);
	}
	public String generateId(String prefix) {
		return prefix + generateId();
	}
}
