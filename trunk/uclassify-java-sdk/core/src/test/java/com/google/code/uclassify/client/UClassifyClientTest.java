/**
 *
 */
package com.google.code.uclassify.client;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import com.google.code.uclassify.client.constant.TestConstants;

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
    	assertNotNull(String.format(RESOURCE_MISSING_MESSAGE, "Read Key"), TestConstants.UCLASSIFY_TEST_READ_KEY);
    	assertNotNull(String.format(RESOURCE_MISSING_MESSAGE, "Write Key"), TestConstants.UCLASSIFY_TEST_WRITE_KEY);
    	factory =
            UClassifyClientFactory.newInstance(TestConstants.UCLASSIFY_TEST_READ_KEY,
                TestConstants.UCLASSIFY_TEST_WRITE_KEY);
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
	protected static void assertNotNullOrEmpty(String message, String value) {
		assertNotNull(message, value);
		assertFalse(message, "".equals(value));
	}
}
