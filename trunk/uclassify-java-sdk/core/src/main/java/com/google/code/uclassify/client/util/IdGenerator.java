/**
 * 
 */
package com.google.code.uclassify.client.util;

/**
 * @author nmukhtar
 *
 */
public class IdGenerator {
	private IdGenerator() {}
	
	public static IdGenerator newInstance() {
		return new IdGenerator();
	}
	public String generateId() {
		return "";
	}
	public String generateId(String prefix) {
		return prefix + generateId();
	}
}
