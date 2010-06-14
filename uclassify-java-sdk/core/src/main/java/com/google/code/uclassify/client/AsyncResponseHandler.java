/**
 *
 */
package com.google.code.uclassify.client;

import java.util.concurrent.Future;

import com.uclassify.api._1.responseschema.ResponseEntity;

/**
 * The Abstract class AsyncResponseHandler.
 *
 * @author nmukhtar
 *
 * @param <T>
 */
public abstract class AsyncResponseHandler<T extends ResponseEntity> {
	
	private Future<T> future;
	
    /**
     * Set future
     *
     * @param future the future
     */
	public void setFuture(Future<T> future) {
		this.future = future;
	}
	
    /**
     * Get a reference to the future.
     *
     */
	public Future<T> getFuture() {
		return future;
	}

    /**
     * Handle response.
     *
     * @param response the response
     */
    public abstract void handleResponse(T response);
}
