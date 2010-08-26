/**
 *
 */
package com.google.code.uclassify.client.constant;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.code.uclassify.client.enumeration.FieldEnum;

/**
 * The Class LinkedInApiUrls.
 */
public final class UClassifyUrls {

    /** The Constant API_URLS_FILE. */
    public static final String API_URLS_FILE = "LinkedInApiUrls.properties";

    /** The static logger. */
    private static final Logger LOG = Logger.getLogger(UClassifyUrls.class.getCanonicalName());
    
    /** The Constant linkedInApiUrls. */
    private static final Properties linkedInApiUrls = new Properties();

    static {
        try {
            linkedInApiUrls.load(UClassifyUrls.class.getResourceAsStream(API_URLS_FILE));
        } catch (IOException e) {
        	LOG.log(Level.SEVERE, "An error occurred while loading urls.", e);
        }
    }

    /** The Constant GET_PROFILE_FOR_CURRENT_USER. */
    public static final String GET_PROFILE_FOR_CURRENT_USER =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.getProfileForCurrentUser");

    /** The Constant GET_PROFILE_BY_ID. */
    public static final String GET_PROFILE_BY_ID =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.getProfileById");

    /** The Constant GET_PROFILE_BY_URL. */
    public static final String GET_PROFILE_BY_URL =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.getProfileByUrl");

    /** The Constant SEARCH_PEOPLE. */
    public static final String SEARCH_PEOPLE =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.searchPeople");

    /** The Constant POST_UPDATE. */
    public static final String POST_UPDATE =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.postUpdate");

    /** The Constant POST_STATUS. */
    public static final String POST_STATUS =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.postStatus");

    /** The Constant POST_COMMENT. */
    public static final String POST_COMMENT =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.postComment");

    /** The Constant SEND_MESSAGE. */
    public static final String SEND_MESSAGE =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.sendMessage");


    /** The Constant LINKED_IN_OAUTH_REQUEST_TOKEN_URL. */
    public static final String LINKED_IN_OAUTH_REQUEST_TOKEN_URL =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.oauth.requestToken");

    /** The Constant LINKED_IN_OAUTH_AUTHORIZE_URL. */
    public static final String LINKED_IN_OAUTH_AUTHORIZE_URL =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.oauth.authorize");

    /** The Constant LINKED_IN_OAUTH_ACCESS_TOKEN_URL. */
    public static final String LINKED_IN_OAUTH_ACCESS_TOKEN_URL =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.oauth.accessToken");

    /** The Constant LINKED_IN_OAUTH_ACCESS_TOKEN_URL. */
    public static final String LINKED_IN_OAUTH_INVALIDATE_TOKEN_URL =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.oauth.invalidateToken");
    
    /** The Constant NETWORK_UPDATES. */
    public static final String NETWORK_UPDATES =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.networkUpdates");
    
    /** The Constant NETWORK_UPDATE_COMMENTS. */
    public static final String NETWORK_UPDATE_COMMENTS =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.networkUpdateComments");
    
    /** The Constant GET_CONNECTIONS_FOR_CURRENT_USER. */
    public static final String GET_CONNECTIONS_FOR_CURRENT_USER =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.getConnectionsForCurrentUser");

    /** The Constant GET_CONNECTIONS_BY_ID. */
    public static final String GET_CONNECTIONS_BY_ID =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.getConnectionsById");

    /** The Constant GET_CONNECTIONS_BY_EMAIL. */
    public static final String GET_CONNECTIONS_BY_EMAIL =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.getConnectionsByEmail");

    /** The Constant GET_CONNECTIONS_BY_URL. */
    public static final String GET_CONNECTIONS_BY_URL =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.getConnectionsByUrl");

    /** The Constant SEND_MESSAGE_PERSON_PATH. */
    public static final String SEND_MESSAGE_PERSON_PATH =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.messagePersonPath");

    /** The Constant SEND_INVITE_ID_PERSON_PATH. */
    public static final String SEND_INVITE_ID_PERSON_PATH =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.inviteIdPersonPath");

    /** The Constant SEND_INVITE_EMAIL_PERSON_PATH. */
    public static final String SEND_INVITE_EMAIL_PERSON_PATH =
        linkedInApiUrls.getProperty("com.google.code.linkedinapi.client.inviteEmailPersonPath");
    
    /**
     * Instantiates a new linked in api urls.
     */
    private UClassifyUrls() {}

    /**
     * The Class LinkedInApiUrlBuilder.
     */
    public static class UClassifyUrlBuilder {
        
        /** The Constant API_URLS_PLACEHOLDER_START. */
        private static final char API_URLS_PLACEHOLDER_START = '{';

        /** The Constant API_URLS_PLACEHOLDER_END. */
        private static final char API_URLS_PLACEHOLDER_END = '}';
        
        /** The Constant QUERY_PARAMETERS_PLACEHOLDER. */
        private static final String QUERY_PARAMETERS_PLACEHOLDER = "queryParameters";
    	
    	/** The url format. */
	    private String urlFormat;
    	
	    /** The url type. */
	    @SuppressWarnings("unused")
		private String urlType;
    	
    	/** The parameters map. */
	    private Map<String, Collection<String>> parametersMap = new HashMap<String, Collection<String>>();
    	
	    /** The fields map. */
	    private Map<String, String> fieldsMap = new HashMap<String, String>();
    	
    	/**
	     * Instantiates a new linked in api url builder.
	     * 
	     * @param urlFormat the url format
	     */
	    public UClassifyUrlBuilder(String urlFormat) {
    		this.urlFormat = urlFormat;    		
    	}
    	
    	/**
	     * Instantiates a new linked in api url builder.
	     * 
	     * @param urlFormat the url format
	     * @param urlType the url type
	     */
	    public UClassifyUrlBuilder(String urlFormat, String urlType) {
    		this.urlFormat = urlFormat;
    		this.urlType = urlType;
    	}
    	
    	/**
	     * With parameter.
	     * 
	     * @param name the name
	     * @param value the value
	     * 
	     * @return the linked in api url builder
	     */
	    public UClassifyUrlBuilder withParameter(String name, String value) {
	    	if (value != null && value.length() > 0) {
	    		parametersMap.put(name, Collections.singleton(encodeUrl(value)));
	    	}
    		
    		return this;
    	}
    	
    	/**
	     * With parameters.
	     * 
	     * @param name the name
	     * @param values the values
	     * 
	     * @return the linked in api url builder
	     */
	    public UClassifyUrlBuilder withParameters(String name, Collection<String> values) {
	    	List<String> encodedValues = new ArrayList<String>(values.size());
	    	for (String value : values) {
	    		encodedValues.add(encodeUrl(value));
	    	}
    		parametersMap.put(name, encodedValues);
    		
    		return this;
    	}
    	
    	/**
	     * With parameter enum set.
	     * 
	     * @param name the name
	     * @param enumSet the enum set
	     * 
	     * @return the linked in api url builder
	     */
	    public UClassifyUrlBuilder withParameterEnumSet(String name, Set<? extends FieldEnum> enumSet) {
	    	Set<String> values = new HashSet<String>(enumSet.size());
	    	
	    	for (FieldEnum fieldEnum : enumSet) {
	    		values.add(encodeUrl(fieldEnum.fieldName()));
	    	}
	    	
    		parametersMap.put(name, values);
    		
    		return this;
    	}
	    
    	/**
	     * With parameter enum.
	     * 
	     * @param name the name
	     * @param value the value
	     * 
	     * @return the linked in api url builder
	     */
	    public UClassifyUrlBuilder withParameterEnum(String name, FieldEnum value) {
	    	withParameter(name, value.fieldName());
    		
    		return this;
    	}
    	
    	/**
	     * With parameter enum map.
	     * 
	     * @param enumMap the enum map
	     * 
	     * @return the linked in api url builder
	     */
	    public UClassifyUrlBuilder withParameterEnumMap(Map<? extends FieldEnum, String> enumMap) {
	    	for (FieldEnum parameter : enumMap.keySet()) {
	    		withParameter(parameter.fieldName(), enumMap.get(parameter));
	    	}
    		
    		return this;
    	}
	    
    	/**
	     * With empty field.
	     * 
	     * @param name the name
	     * 
	     * @return the linked in api url builder
	     */
	    public UClassifyUrlBuilder withEmptyField(String name) {
    		fieldsMap.put(name, "");
    		
    		return this;
    	}
	    
    	/**
	     * With field.
	     * 
	     * @param name the name
	     * @param value the value
	     * 
	     * @return the linked in api url builder
	     */
	    public UClassifyUrlBuilder withField(String name, String value) {
	    	withField(name, value, false);
    		
    		return this;
    	}
	    
    	/**
	     * With field.
	     * 
	     * @param name the name
	     * @param value the value
	     * 
	     * @return the linked in api url builder
	     */
	    public UClassifyUrlBuilder withField(String name, String value, boolean escape) {
	    	if (escape) {
	    		fieldsMap.put(name, encodeUrl(value));
	    	} else {
	    		fieldsMap.put(name, value);
	    	}
    		
    		return this;
    	}
	    
    	/**
	     * With field enum.
	     * 
	     * @param name the name
	     * @param value the value
	     * 
	     * @return the linked in api url builder
	     */
	    public UClassifyUrlBuilder withFieldEnum(String name, FieldEnum value) {
	    	if (value.fieldName() == null || value.fieldName().length() == 0) {
	    		fieldsMap.put(name, "");
	    	} else {
	    		fieldsMap.put(name, ":" + value.fieldName());
	    	}
    		
    		return this;
    	}
    	
    	/**
	     * With field enum set.
	     * 
	     * @param name the name
	     * @param enumSet the enum set
	     * 
	     * @return the linked in api url builder
	     */
	    public UClassifyUrlBuilder withFieldEnumSet(String name, Set<? extends FieldEnum> enumSet) {
	    	StringBuilder builder = new StringBuilder();
	    	if (!enumSet.isEmpty()) {
	        	builder.append(":");
	    		Iterator<? extends FieldEnum> iter = enumSet.iterator();
	        	builder.append("(");
	    		while (iter.hasNext()) {
	    			FieldEnum fieldEnum = iter.next();
	    			builder.append(fieldEnum.fieldName());
	    			if (iter.hasNext()) {
	    				builder.append(",");
	    			}
	    		}
	        	builder.append(")");
	    	}
    		
    		fieldsMap.put(name, builder.toString());
    		
    		return this;
    	}
    	
    	/**
	     * Builds the url.
	     * 
	     * @return the string
	     */
		public String buildUrl() {
        	StringBuilder urlBuilder = new StringBuilder();
        	StringBuilder placeHolderBuilder = new StringBuilder();
        	boolean placeHolderFlag = false;
        	for (int i = 0; i < urlFormat.length(); i++) {
        		if (urlFormat.charAt(i) == API_URLS_PLACEHOLDER_START) {
        			placeHolderBuilder = new StringBuilder();
        			placeHolderFlag = true;
        		} else if (placeHolderFlag && urlFormat.charAt(i) == API_URLS_PLACEHOLDER_END) {
        			String placeHolder = placeHolderBuilder.toString();
        			if (fieldsMap.containsKey(placeHolder)) {
        				urlBuilder.append(fieldsMap.get(placeHolder));
        			} else if (QUERY_PARAMETERS_PLACEHOLDER.equals(placeHolder)) {
    			    	StringBuilder builder = new StringBuilder();
    			    	if (!parametersMap.isEmpty()) {
    			        	builder.append("?");
    			    		Iterator<String> iter = parametersMap.keySet().iterator();
    			    		while (iter.hasNext()) {
    			    			String name = iter.next();
			    				Collection<String> parameterValues = parametersMap.get(name);
			    				Iterator<String> iterParam = parameterValues.iterator();
			    				while (iterParam.hasNext()) {
    			    				builder.append(name);
    			    				builder.append("=");
    			    				builder.append(iterParam.next());
    			    				if (iterParam.hasNext()) {
        			    				builder.append("&");
    			    				}
			    				}
    			    			if (iter.hasNext()) {
    			    				builder.append("&");
    			    			}
    			    		}
    			    	}
    			    	urlBuilder.append(builder.toString());
        			} else {
        				// we did not find a binding for the placeholder.
        				// append it as it is.
        				urlBuilder.append(API_URLS_PLACEHOLDER_START);
        				urlBuilder.append(placeHolder);
        				urlBuilder.append(API_URLS_PLACEHOLDER_END);
        			}
        			placeHolderFlag = false;
        		} else if (placeHolderFlag) {
        			placeHolderBuilder.append(urlFormat.charAt(i));
        		} else {
        			urlBuilder.append(urlFormat.charAt(i));
        		}
        	}

        	return urlBuilder.toString();
    	}
    	
        /**
         * Encode url.
         * 
         * @param original the original
         * @param encoding the encoding
         * 
         * @return the string
         */
        private static String encodeUrl(String original) {
        	try {
    			return URLEncoder.encode(original, ApplicationConstants.CONTENT_ENCODING);
    		} catch (UnsupportedEncodingException e) {
    			// should never be here..
    			return original;
    		}
        }
    }
}
