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
