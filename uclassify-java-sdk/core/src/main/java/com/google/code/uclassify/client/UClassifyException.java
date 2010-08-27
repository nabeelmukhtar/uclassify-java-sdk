/**
 *
 */
package com.google.code.uclassify.client;

import java.util.Date;

/**
 * Class description
 *
 *
 */
public class UClassifyException extends RuntimeException {
	private int statusCode;
	private Date timestamp;

    /**
	 *
	 */
	private static final long serialVersionUID = -4345556572105572685L;

	/**
     * Constructs ...
     *
     */
    public UClassifyException() {
        super();
    }

    /**
     * Constructs ...
     *
     *
     * @param message
     */
    public UClassifyException(String message) {
        super(message);
    }

    /**
     * Constructs ...
     *
     *
     * @param cause
     */
    public UClassifyException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs ...
     *
     *
     * @param message
     * @param cause
     */
    public UClassifyException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs ...
     *
     *
     * @param message
     * @param cause
     */
    public UClassifyException(String message, int statusCode, Date timestamp) {
        super(message);
        this.statusCode = statusCode;
        this.timestamp = timestamp;
    }
    
	/**
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
}
