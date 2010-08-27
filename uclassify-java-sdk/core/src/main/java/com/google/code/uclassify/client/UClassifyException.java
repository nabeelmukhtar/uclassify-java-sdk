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

import java.util.Date;

/**
 * Class description.
 */
public class UClassifyException extends RuntimeException {
	
	/** The status code. */
	private int statusCode;
	
	/** The timestamp. */
	private Date timestamp;

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4345556572105572685L;

	/**
	 * Constructs ...
	 */
    public UClassifyException() {
        super();
    }

    /**
     * Constructs ...
     * 
     * @param message the message
     */
    public UClassifyException(String message) {
        super(message);
    }

    /**
     * Constructs ...
     * 
     * @param cause the cause
     */
    public UClassifyException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs ...
     * 
     * @param message the message
     * @param cause the cause
     */
    public UClassifyException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs ...
     * 
     * @param message the message
     * @param statusCode the status code
     * @param timestamp the timestamp
     */
    public UClassifyException(String message, int statusCode, Date timestamp) {
        super(message);
        this.statusCode = statusCode;
        this.timestamp = timestamp;
    }
    
	/**
	 * Gets the status code.
	 * 
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * Sets the status code.
	 * 
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * Gets the timestamp.
	 * 
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * Sets the timestamp.
	 * 
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}
