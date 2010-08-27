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
package com.google.code.uclassify.client.impl;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import com.google.code.uclassify.client.AsyncUClassifyClient;
import com.google.code.uclassify.client.UClassifyClient;
import com.google.code.uclassify.client.UClassifyConsumer;
import com.uclassify.api._1.responseschema.ClassInformation;
import com.uclassify.api._1.responseschema.Classification;

/**
 * The Class AsyncUClassifyClientAdapter.
 * 
 * @author Nabeel Mukhtar
 */
public class AsyncUClassifyClientAdapter implements AsyncUClassifyClient {

    /** Field description. */
    private UClassifyClient client;
    
    /** Field description. */
    private ExecutorService taskExecutor;
    
    /**
     * Field description.
     * 
     * @param client the client
     * @param taskExecutor the task executor
     */

    /**
     * Constructs ...
     *
     *
     * @param client
     */
    public AsyncUClassifyClientAdapter(UClassifyClient client, ExecutorService taskExecutor) {
        this.client  = client;
        this.taskExecutor = taskExecutor;
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
     * Method description.
     * 
     * @param task the task
     * 
     * @return the future
     */
    @SuppressWarnings("unchecked")
	protected Future execute(Runnable task) {
        return taskExecutor.submit(task);
    }

    /**
     * Method description.
     * 
     * @param task the task
     * 
     * @return the future< t>
     */
    protected <T> Future<T> execute(Callable<T> task) {
        return taskExecutor.submit(task);
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
    
	/* (non-Javadoc)
	 * @see com.google.code.uclassify.client.AsyncUClassifyClient#addClass(java.lang.String, java.lang.String)
	 */
	@Override
	public Future<?> addClass(final String classifierName, final String className) {
		return execute(new Runnable() {
            @Override
            public void run() {
                client.addClass(classifierName, className);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.uclassify.client.AsyncUClassifyClient#classify(java.lang.String, java.util.List)
	 */
	@Override
	public Future<Map<String, Classification>> classify(final String classifierName,
			final List<String> texts) {
		return execute(new Callable<Map<String, Classification>>() {
            @Override
            public Map<String, Classification> call() throws Exception {
                return client.classify(classifierName, texts);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.uclassify.client.AsyncUClassifyClient#classify(java.lang.String, java.io.InputStream)
	 */
	@Override
	public Future<Map<String, Classification>> classify(final String classifierName,
			final InputStream texts) {
		return execute(new Callable<Map<String, Classification>>() {
            @Override
            public Map<String, Classification> call() throws Exception {
                return client.classify(classifierName, texts);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.uclassify.client.AsyncUClassifyClient#classify(java.lang.String, java.lang.String, java.util.List)
	 */
	@Override
	public Future<Map<String, Classification>> classify(final String userName,
			final String classifierName, final List<String> texts) {
		return execute(new Callable<Map<String, Classification>>() {
            @Override
            public Map<String, Classification> call() throws Exception {
                return client.classify(userName, classifierName, texts);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.uclassify.client.AsyncUClassifyClient#classify(java.lang.String, java.lang.String, java.io.InputStream)
	 */
	@Override
	public Future<Map<String, Classification>> classify(final String userName,
			final String classifierName, final InputStream texts) {
		return execute(new Callable<Map<String, Classification>>() {
            @Override
            public Map<String, Classification> call() throws Exception {
                return client.classify(userName, classifierName, texts);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.uclassify.client.AsyncUClassifyClient#createClassifier(java.lang.String)
	 */
	@Override
	public Future<?> createClassifier(final String classifierName) {
		return execute(new Runnable() {
            @Override
            public void run() {
                client.createClassifier(classifierName);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.uclassify.client.AsyncUClassifyClient#getInformation(java.lang.String)
	 */
	@Override
	public Future<List<ClassInformation>> getInformation(final String classifierName) {
		return execute(new Callable<List<ClassInformation>>() {
            @Override
            public List<ClassInformation> call() throws Exception {
                return client.getInformation(classifierName);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.uclassify.client.AsyncUClassifyClient#getInformation(java.lang.String, java.lang.String)
	 */
	@Override
	public Future<List<ClassInformation>> getInformation(final String userName, final String classifierName) {
		return execute(new Callable<List<ClassInformation>>() {
            @Override
            public List<ClassInformation> call() throws Exception {
                return client.getInformation(userName, classifierName);
            }
        });
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.uclassify.client.AsyncUClassifyClient#removeClass(java.lang.String, java.lang.String)
	 */
	@Override
	public Future<?> removeClass(final String classifierName, final String className) {
		return execute(new Runnable() {
            @Override
            public void run() {
                client.removeClass(classifierName, className);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.uclassify.client.AsyncUClassifyClient#removeClassifier(java.lang.String)
	 */
	@Override
	public Future<?> removeClassifier(final String classifierName) {
		return execute(new Runnable() {
            @Override
            public void run() {
                client.removeClassifier(classifierName);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.uclassify.client.AsyncUClassifyClient#train(java.lang.String, java.util.Map)
	 */
	@Override
	public Future<?> train(final String classifierName,
			final Map<String, String> trainingTexts) {
		return execute(new Runnable() {
            @Override
            public void run() {
                client.train(classifierName, trainingTexts);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.uclassify.client.AsyncUClassifyClient#train(java.lang.String, java.io.InputStream)
	 */
	@Override
	public Future<?> train(final String classifierName, final InputStream trainingTexts) {
		return execute(new Runnable() {
            @Override
            public void run() {
                client.train(classifierName, trainingTexts);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.uclassify.client.AsyncUClassifyClient#untrain(java.lang.String, java.util.Map)
	 */
	@Override
	public Future<?> untrain(final String classifierName,
			final Map<String, String> trainingTexts) {
		return execute(new Runnable() {
            @Override
            public void run() {
                client.untrain(classifierName, trainingTexts);
            }
        });
	}

	/* (non-Javadoc)
	 * @see com.google.code.uclassify.client.AsyncUClassifyClient#untrain(java.lang.String, java.io.InputStream)
	 */
	@Override
	public Future<?> untrain(final String classifierName, final InputStream trainingTexts) {
		return execute(new Runnable() {
            @Override
            public void run() {
                client.untrain(classifierName, trainingTexts);
            }
        });
	}
}
