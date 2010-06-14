/**
 *
 */
package com.google.code.uclassify.client.impl;

import java.util.Map;
import java.util.concurrent.ExecutorService;

import com.google.code.uclassify.client.AsyncUClassifyClient;
import com.google.code.uclassify.client.AsyncResponseHandler;
import com.google.code.uclassify.client.UClassifyClient;
import com.google.code.uclassify.client.UClassifyConsumer;
import com.uclassify.api._1.responseschema.ResponseEntity;

/**
 * @author Nabeel Mukhtar
 *
 */
public class AsyncUClassifyClientAdapter implements AsyncUClassifyClient {

    /** Field description */
    private AsyncHandlerUClassifyClientAdapter client;
    
    /** Field description */

    /**
     * Constructs ...
     *
     *
     * @param client
     */
    public AsyncUClassifyClientAdapter(UClassifyClient client, ExecutorService taskExecutor) {
        this.client  = new AsyncHandlerUClassifyClientAdapter(client, taskExecutor);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UClassifyConsumer getApiConsumer() {
        return client.getApiConsumer();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setApiConsumer(UClassifyConsumer apiConsumer) {
    	client.setApiConsumer(apiConsumer);
    }
    
    /**
     * Sets the request headers.
     *
     * @param requestHeaders the request headers
     */
    public void setRequestHeaders(Map<String, String> requestHeaders) {
    	client.setRequestHeaders(requestHeaders);
    }

    /**
     * Gets the request headers.
     *
     * @return the request headers
     */
    public Map<String, String> getRequestHeaders() {
        return client.getRequestHeaders();
    }

    /**
     * Adds the request header.
     *
     * @param headerName the header name
     * @param headerValue the header value
     */
    public void addRequestHeader(String headerName, String headerValue) {
        client.addRequestHeader(headerName, headerValue);
    }

    /**
     * Removes the request header.
     *
     * @param headerName the header name
     */
    public void removeRequestHeader(String headerName) {
        client.removeRequestHeader(headerName);
    }
    
    private static class NullResponseHandler<T extends ResponseEntity> extends AsyncResponseHandler<T> {
		@Override
		public void handleResponse(T response) {
			// No-Op
		} 
    }
}
