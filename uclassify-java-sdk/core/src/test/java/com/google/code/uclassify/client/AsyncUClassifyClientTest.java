/**
 * 
 */
package com.google.code.uclassify.client;


/**
 * @author Nabeel Mukhtar
 *
 */
public class AsyncUClassifyClientTest extends UClassifyClientTest {
	private AsyncUClassifyClient client;
	
	/** 
	 * @see com.google.code.uclassify.client.UClassifyClientTest#setUp()
	 */
	public void setUp() throws Exception {
		super.setUp();
		client = factory.createAsyncLinkedInApiClient();
	}

	/**
	 * @see com.google.code.uclassify.client.UClassifyClientTest#tearDown()
	 */
	public void tearDown() throws Exception {
		super.tearDown();
		client = null;
	}
}
