/**
 * 
 */
package com.google.code.uclassify.client;

import org.junit.Test;

import com.google.code.uclassify.client.impl.UClassifyJaxbClient;

/**
 * @author Nabeel Mukhtar
 *
 */
public class UClassifyJaxbClientTest extends UClassifyClientTest {
	private UClassifyClient client;
	
	/** 
	 * @see com.google.code.uclassify.client.UClassifyClientTest#setUp()
	 */
	public void setUp() throws Exception {
		super.setUp();
		client = factory.createUClassifyClient(UClassifyJaxbClient.class);
	}

	/**
	 * @see com.google.code.uclassify.client.UClassifyClientTest#tearDown()
	 */
	public void tearDown() throws Exception {
		super.tearDown();
		client = null;
	}
	
	@Test
	public void testAddClass() {
		fail("Not yet implemented");
	}

	@Test
	public void testClassifyStringListOfString() {
		fail("Not yet implemented");
	}

	@Test
	public void testClassifyStringInputStream() {
		fail("Not yet implemented");
	}

	@Test
	public void testClassifyStringStringListOfString() {
		fail("Not yet implemented");
	}

	@Test
	public void testClassifyStringStringInputStream() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateClassifier() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetInformation() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveClass() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveClassifier() {
		fail("Not yet implemented");
	}

	@Test
	public void testTrainStringMapOfStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testTrainStringInputStream() {
		fail("Not yet implemented");
	}

	@Test
	public void testUntrainStringMapOfStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testUntrainStringInputStream() {
		fail("Not yet implemented");
	}
}
