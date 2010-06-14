/**
 *
 */
package com.google.code.uclassify.client;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import com.google.code.uclassify.client.constant.TestConstants;
import com.google.code.uclassify.client.enumeration.SearchParameter;

/**
 * @author Nabeel Mukhtar
 *
 */
public abstract class UClassifyClientTest extends TestCase {

    /** Field description */
    protected UClassifyClientFactory factory;

    /** Field description */
	protected static final String RESOURCE_MISSING_MESSAGE = "Please define a test %s in TestConstants.properties file."; 
    

    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {}

    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {}

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    	assertNotNull(String.format(RESOURCE_MISSING_MESSAGE, "Consumer Key"), TestConstants.LINKED_IN_TEST_CONSUMER_KEY);
    	assertNotNull(String.format(RESOURCE_MISSING_MESSAGE, "Consumer Secret"), TestConstants.LINKED_IN_TEST_CONSUMER_SECRET);
    	factory =
            UClassifyClientFactory.newInstance(TestConstants.LINKED_IN_TEST_CONSUMER_KEY,
                TestConstants.LINKED_IN_TEST_CONSUMER_SECRET);
    	assertNotNull(String.format(RESOURCE_MISSING_MESSAGE, "Access Token Key"), TestConstants.LINKED_IN_TEST_ACCESS_TOKEN_KEY);
    	assertNotNull(String.format(RESOURCE_MISSING_MESSAGE, "Access Token Secret"), TestConstants.LINKED_IN_TEST_ACCESS_TOKEN_SECRET);
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    	factory = null;
    }
    
	/**
	 * 
	 */
	protected Date getCurrentDate() {
		return new Date();
	}

	/**
	 * 
	 */
	protected Date getLastWeekDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -7);
		return calendar.getTime();
	}

	/**
	 * 
	 */
	protected Map<SearchParameter, String> getSearchParametersMap(String searchParameters) {
		Map<SearchParameter, String> map = new EnumMap<SearchParameter, String>(SearchParameter.class);
		String[] entries = searchParameters.split(",");
		for (String entry : entries) {
			String[] tuple = entry.split("=");
			if (tuple.length == 2) {
				map.put(SearchParameter.fromString(tuple[0]), tuple[1]);
			}
						
		}
		return map;
	}

	/**
	 * 
	 */
	protected List<String> getRecepientIdsList(String messageRecepients) {
		return Arrays.asList(messageRecepients.split(","));
	}
	
	/**
	 * 
	 */
	protected static void assertNotNullOrEmpty(String message, String value) {
		assertNotNull(message, value);
		assertFalse(message, "".equals(value));
	}
}
