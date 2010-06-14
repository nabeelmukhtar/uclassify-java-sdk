/**
 *
 */
package com.google.code.uclassify.client.impl;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import com.google.code.uclassify.client.AsyncHandlerUClassifyClient;
import com.google.code.uclassify.client.UClassifyClient;
import com.google.code.uclassify.client.UClassifyConsumer;

/**
 * @author Nabeel Mukhtar
 *
 */
public class AsyncHandlerUClassifyClientAdapter implements AsyncHandlerUClassifyClient {

    /** Field description */
    private UClassifyClient client;

    /** Field description */
    private ExecutorService taskExecutor;

    /**
     * Constructs ...
     *
     *
     * @param client
     */
    public AsyncHandlerUClassifyClientAdapter(UClassifyClient client, ExecutorService taskExecutor) {
        this.client  = client;
        this.taskExecutor = taskExecutor;
    }

    /**
     * Method description
     *
     *
     * @param task
     *
     * @return
     */
    @SuppressWarnings("unchecked")
	protected Future execute(Runnable task) {
        return taskExecutor.submit(task);
    }

    /**
     * Method description
     *
     *
     * @param task
     * @param <T>
     *
     * @return
     */
    protected <T> Future<T> execute(Callable<T> task) {
        return taskExecutor.submit(task);
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
}
