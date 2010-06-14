/**
 * 
 */
package com.google.code.uclassify.client;

import com.google.code.uclassify.client.impl.UClassifyXppClient;

/**
 * @author Nabeel Mukhtar
 *
 */
public class UClassifyXppClientTest extends UClassifyClientTest {
	private UClassifyClient client;
	
	/** 
	 * @see com.google.code.uclassify.client.UClassifyClientTest#setUp()
	 */
	public void setUp() throws Exception {
		super.setUp();
		client = factory.createLinkedInApiClient(UClassifyXppClient.class);
	}

	/**
	 * @see com.google.code.uclassify.client.UClassifyClientTest#tearDown()
	 */
	public void tearDown() throws Exception {
		super.tearDown();
		client = null;
	}
}
