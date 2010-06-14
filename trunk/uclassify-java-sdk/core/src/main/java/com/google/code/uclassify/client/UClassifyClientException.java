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
public class UClassifyClientException extends RuntimeException {
	private int statusCode;
	private String errorCode;
	private Date timestamp;

    /**
	 *
	 */
	private static final long serialVersionUID = -4345556572105572685L;

	/**
     * Constructs ...
     *
     */
    public UClassifyClientException() {
        super();
    }

    /**
     * Constructs ...
     *
     *
     * @param message
     */
    public UClassifyClientException(String message) {
        super(message);
    }

    /**
     * Constructs ...
     *
     *
     * @param cause
     */
    public UClassifyClientException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs ...
     *
     *
     * @param message
     * @param cause
     */
    public UClassifyClientException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs ...
     *
     *
     * @param message
     * @param cause
     */
    public UClassifyClientException(String message, int statusCode , String errorCode, Date timestamp) {
        super(message);
        this.statusCode = statusCode;
        this.errorCode = errorCode;
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
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
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
