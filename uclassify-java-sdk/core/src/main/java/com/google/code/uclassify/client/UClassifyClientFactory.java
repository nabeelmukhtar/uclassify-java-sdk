/**
 *
 */
package com.google.code.uclassify.client;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.code.uclassify.client.impl.AsyncUClassifyClientAdapter;
import com.google.code.uclassify.client.util.ApplicationConstants;

/**
 * A factory for creating LinkedInApiClient objects.
 * 
 * @author Nabeel Mukhtar
 */
public class UClassifyClientFactory {

    /** The Constant factoriesMap. */
    private static final Map<UClassifyConsumer, UClassifyClientFactory> factoriesMap =
        new ConcurrentHashMap<UClassifyConsumer, UClassifyClientFactory>();
    
    /** The task executor. */
    private ExecutorService taskExecutor = Executors.newCachedThreadPool();

    /** The api consumer. */
    private UClassifyConsumer apiConsumer;

    /** The default client impl. */
    private Constructor<? extends UClassifyClient> defaultClientImpl;
    
    /**
     * Instantiates a new linked in api client factory.
     * 
     * @param apiConsumer the api consumer
     */
	private UClassifyClientFactory(UClassifyConsumer apiConsumer) {
        this.apiConsumer = apiConsumer;
    }
	
    /**
     * Sets the task executor to be used for asynchronous API calls. 
     * 
     * @param taskExecutor the task executor
     */
	public void setTaskExecutor(ExecutorService taskExecutor) {
        this.taskExecutor = taskExecutor;
	}

    /**
     * New instance.
     * 
     * @param consumerKey the consumer key
     * @param consumerSecret the consumer secret
     * 
     * @return the linked in api client factory
     */
    public static UClassifyClientFactory newInstance(String consumerKey, String consumerSecret) {
        return newInstance(new UClassifyConsumer(consumerKey, consumerSecret));
    }

    /**
     * New instance.
     * 
     * @param apiConsumer the api consumer
     * 
     * @return the linked in api client factory
     */
    public static synchronized UClassifyClientFactory newInstance(UClassifyConsumer apiConsumer) {
        UClassifyClientFactory factory = factoriesMap.get(apiConsumer);

        if (factory == null) {
            factory = new UClassifyClientFactory(apiConsumer);
            factoriesMap.put(apiConsumer, factory);
        }

        return factory;
    }

    /**
     * Creates a new LinkedInApiClient object.
     * 
     * @param accessToken the access token
     * 
     * @return the linked in api client
     */
    @SuppressWarnings("unchecked")
	public UClassifyClient createUClassifyClient() {
    	try {
    		if (defaultClientImpl == null) {
        		Class<? extends UClassifyClient> clazz = (Class<? extends UClassifyClient>) Class.forName(ApplicationConstants.CLIENT_DEFAULT_IMPL);
        		
        		defaultClientImpl = clazz.getConstructor(String.class, String.class);
    		}
			
			final UClassifyClient client = defaultClientImpl.newInstance(apiConsumer.getReadApiKey(), apiConsumer.getWriteApiKey());

	        return client;
		} catch (Exception e) {
			throw new UClassifyException(e);
		}
    }

    /**
     * Creates a new LinkedInApiClient object.
     * 
     * @param accessToken the access token
     * 
     * @return the linked in api client
     */
	public UClassifyClient createUClassifyClient(Class<? extends UClassifyClient> implClass) {
    	try {
			final UClassifyClient client = implClass.getConstructor(String.class, String.class).newInstance(apiConsumer.getReadApiKey(), apiConsumer.getWriteApiKey());

	        return client;
		} catch (Exception e) {
			throw new UClassifyException(e);
		}
    }
    
    /**
     * Creates a new LinkedInApiClient object.
     * 
     * @param accessToken the access token
     * 
     * @return the async linked in api client
     */
    public AsyncUClassifyClient createAsyncUClassifyClient() {
        final UClassifyClient client = createUClassifyClient();

        return new AsyncUClassifyClientAdapter(client, taskExecutor);
    }
    
    /**
     * Creates a new LinkedInApiClient object.
     * 
     * @param token the token
     * @param tokenSecret the token secret
     * 
     * @return the linked in api client
     */
    public UClassifyClient createUClassifyClient(String token, String tokenSecret) {
        return createUClassifyClient();
    }
    
    /**
     * Creates a new LinkedInApiClient object.
     * 
     * @param token the token
     * @param tokenSecret the token secret
     * 
     * @return the async linked in api client
     */
    public AsyncUClassifyClient createAsyncUClassifyClient(String token, String tokenSecret) {
        return createAsyncUClassifyClient();
    }
}
