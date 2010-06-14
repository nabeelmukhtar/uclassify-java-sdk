package com.google.code.uclassify.client;

import java.io.Serializable;

public class UClassifyConsumer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3469932939653397548L;
	private String readApiKey;
	private String writeApiKey;
	
	public UClassifyConsumer(String apiKey) {
		this.readApiKey = apiKey;
		this.writeApiKey = apiKey;
	}
	
	public UClassifyConsumer(String readApiKey, String writeApiKey) {
		this.readApiKey = readApiKey;
		this.writeApiKey = writeApiKey;
	}
	
	/**
	 * @return the readApiKey
	 */
	public String getReadApiKey() {
		return readApiKey;
	}
	/**
	 * @param readApiKey the readApiKey to set
	 */
	public void setReadApiKey(String readApiKey) {
		this.readApiKey = readApiKey;
	}
	/**
	 * @return the writeApiKey
	 */
	public String getWriteApiKey() {
		return writeApiKey;
	}
	/**
	 * @param writeApiKey the writeApiKey to set
	 */
	public void setWriteApiKey(String writeApiKey) {
		this.writeApiKey = writeApiKey;
	}
}
