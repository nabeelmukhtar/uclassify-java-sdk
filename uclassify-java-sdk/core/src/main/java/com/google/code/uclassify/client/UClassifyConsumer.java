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
package com.google.code.uclassify.client;

import java.io.Serializable;

/**
 * The Class UClassifyConsumer.
 */
public class UClassifyConsumer implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3469932939653397548L;
	
	/** The read api key. */
	private String readApiKey;
	
	/** The write api key. */
	private String writeApiKey;
	
	/**
	 * Instantiates a new u classify consumer.
	 * 
	 * @param apiKey the api key
	 */
	public UClassifyConsumer(String apiKey) {
		this.readApiKey = apiKey;
		this.writeApiKey = apiKey;
	}
	
	/**
	 * Instantiates a new u classify consumer.
	 * 
	 * @param readApiKey the read api key
	 * @param writeApiKey the write api key
	 */
	public UClassifyConsumer(String readApiKey, String writeApiKey) {
		this.readApiKey = readApiKey;
		this.writeApiKey = writeApiKey;
	}
	
	/**
	 * Gets the read api key.
	 * 
	 * @return the readApiKey
	 */
	public String getReadApiKey() {
		return readApiKey;
	}
	
	/**
	 * Sets the read api key.
	 * 
	 * @param readApiKey the readApiKey to set
	 */
	public void setReadApiKey(String readApiKey) {
		this.readApiKey = readApiKey;
	}
	
	/**
	 * Gets the write api key.
	 * 
	 * @return the writeApiKey
	 */
	public String getWriteApiKey() {
		return writeApiKey;
	}
	
	/**
	 * Sets the write api key.
	 * 
	 * @param writeApiKey the writeApiKey to set
	 */
	public void setWriteApiKey(String writeApiKey) {
		this.writeApiKey = writeApiKey;
	}
}
