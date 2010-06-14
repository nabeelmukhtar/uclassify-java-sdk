/**
 *
 */
package com.google.code.uclassify.client;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.code.uclassify.client.ApplicationConstants;
import com.google.code.uclassify.client.AsyncUClassifyClient;
import com.google.code.uclassify.client.oauth.LinkedInAccessToken;
import com.google.code.uclassify.client.oauth.LinkedInApiConsumer;

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
    	validateConsumerKey(apiConsumer);
    	
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
	public UClassifyClient createLinkedInApiClient() {
    	try {
    		if (defaultClientImpl == null) {
        		Class<? extends UClassifyClient> clazz = (Class<? extends UClassifyClient>) Class.forName(ApplicationConstants.CLIENT_DEFAULT_IMPL);
        		
        		defaultClientImpl = clazz.getConstructor(String.class, String.class);
    		}
			
			final UClassifyClient client = defaultClientImpl.newInstance(apiConsumer.getConsumerKey(), apiConsumer.getConsumerSecret());

	        return client;
		} catch (Exception e) {
			throw new UClassifyClientException(e);
		}
    }

    /**
     * Creates a new LinkedInApiClient object.
     * 
     * @param accessToken the access token
     * 
     * @return the linked in api client
     */
	public UClassifyClient createLinkedInApiClient(Class<? extends UClassifyClient> implClass) {
    	try {
			final UClassifyClient client = implClass.getConstructor(String.class, String.class).newInstance(apiConsumer.getReadApiKey(), apiConsumer.getWriteApiKey());

	        return client;
		} catch (Exception e) {
			throw new UClassifyClientException(e);
		}
    }
    
    /**
     * Creates a new LinkedInApiClient object.
     * 
     * @param accessToken the access token
     * 
     * @return the async linked in api client
     */
    public AsyncUClassifyClient createAsyncLinkedInApiClient() {
        final UClassifyClient client = createLinkedInApiClient();

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
    public UClassifyClient createLinkedInApiClient(String token, String tokenSecret) {
        return createLinkedInApiClient(new LinkedInAccessToken(token, tokenSecret));
    }
    
    /**
     * Creates a new LinkedInApiClient object.
     * 
     * @param token the token
     * @param tokenSecret the token secret
     * 
     * @return the async linked in api client
     */
    public AsyncUClassifyClient createAsyncLinkedInApiClient(String token, String tokenSecret) {
        return createAsyncLinkedInApiClient(new LinkedInAccessToken(token, tokenSecret));
    }
    
    /**
     * 
     */
	private static void validateConsumerKey(UClassifyConsumer apiConsumer) {
		if (apiConsumer == null) {
    		throw new IllegalArgumentException("api consumer cannot be null.");
    	}
    	if (apiConsumer.getConsumerKey() == null || apiConsumer.getConsumerKey().length() == 0) {
    		throw new IllegalArgumentException("consumer key cannot be null or empty.");
    	}
    	if (apiConsumer.getConsumerSecret() == null || apiConsumer.getConsumerSecret().length() == 0) {
    		throw new IllegalArgumentException("consumer secret cannot be null or empty.");
    	}
	}
    
    /**
     * 
     */
	private void validateAccessToken(LinkedInAccessToken accessToken) {
		if (accessToken == null) {
    		throw new IllegalArgumentException("access token cannot be null.");
    	}
    	if (accessToken.getToken() == null || accessToken.getToken().length() == 0) {
    		throw new IllegalArgumentException("access token cannot be null or empty.");
    	}
    	if (accessToken.getTokenSecret() == null || accessToken.getTokenSecret().length() == 0) {
    		throw new IllegalArgumentException("access token secret cannot be null or empty.");
    	}
	}
}
