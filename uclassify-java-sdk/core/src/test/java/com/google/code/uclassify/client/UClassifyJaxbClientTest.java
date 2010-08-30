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

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.code.uclassify.client.constant.TestConstants;
import com.google.code.uclassify.client.impl.UClassifyJaxbClient;
import com.uclassify.api._1.responseschema.ClassInformation;
import com.uclassify.api._1.responseschema.Classification;

/**
 * The Class UClassifyJaxbClientTest.
 * 
 * @author Nabeel Mukhtar
 */
public class UClassifyJaxbClientTest extends UClassifyClientTest {
	
	/** The client. */
	private UClassifyClient client;
	
	/**
	 * Sets the up.
	 * 
	 * @throws Exception the exception
	 * 
	 * @see com.google.code.uclassify.client.UClassifyClientTest#setUp()
	 */
	public void setUp() throws Exception {
		super.setUp();
		client = factory.createUClassifyClient(UClassifyJaxbClient.class);
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Classifier Name"), TestConstants.TEST_CLASSIFIER_NAME);
		client.createClassifier(TestConstants.TEST_CLASSIFIER_NAME);
	}

	/**
	 * Tear down.
	 * 
	 * @throws Exception the exception
	 * 
	 * @see com.google.code.uclassify.client.UClassifyClientTest#tearDown()
	 */
	public void tearDown() throws Exception {
		super.tearDown();
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Classifier Name"), TestConstants.TEST_CLASSIFIER_NAME);
		client.removeClassifier(TestConstants.TEST_CLASSIFIER_NAME);
		client = null;
	}
	
	/**
	 * Test add class.
	 */
	@Test
	public void testAddClass() {
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Classifier Name"), TestConstants.TEST_CLASSIFIER_NAME);
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Class Name"), TestConstants.TEST_CLASS_NAME);
		client.addClass(TestConstants.TEST_CLASSIFIER_NAME, TestConstants.TEST_CLASS_NAME);
	}

	/**
	 * Test classify string list of string.
	 */
	@Test
	public void testClassifyStringListOfString() {
		// fail("Not yet implemented");
	}

	/**
	 * Test classify string input stream.
	 */
	@Test
	public void testClassifyStringInputStream() {
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Classifier Name"), TestConstants.TEST_CLASSIFIER_NAME);
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Texts"), TestConstants.CLASSIFICATION_TEXTS_FILE);
		Map<String, Classification> classifications = client.classify(TestConstants.TEST_CLASSIFIER_NAME, getClass().getResourceAsStream(TestConstants.CLASSIFICATION_TEXTS_FILE));
		assertNotNullOrEmpty("Classifications must not be null or empty.", classifications);
	}

	/**
	 * Test classify string string list of string.
	 */
	@Test
	public void testClassifyStringStringListOfString() {
		// fail("Not yet implemented");
	}

	/**
	 * Test classify string string input stream.
	 */
	@Test
	public void testClassifyStringStringInputStream() {
		fail("Not yet implemented");
	}

	/**
	 * Test create classifier.
	 */
	@Test
	public void testCreateClassifier() {
		// No op
	}

	/**
	 * Test get information.
	 */
	@Test
	public void testGetInformation() {
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Classifier Name"), TestConstants.TEST_CLASSIFIER_NAME);
		List<ClassInformation> information = client.getInformation(TestConstants.TEST_CLASSIFIER_NAME);
		assertNotNullOrEmpty("Information should not be null or empty.", information);
	}

	/**
	 * Test remove class.
	 */
	@Test
	public void testRemoveClass() {
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Classifier Name"), TestConstants.TEST_CLASSIFIER_NAME);
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Class Name"), TestConstants.TEST_CLASS_NAME);
		client.removeClass(TestConstants.TEST_CLASSIFIER_NAME, TestConstants.TEST_CLASS_NAME);
	}

	/**
	 * Test remove classifier.
	 */
	@Test
	public void testRemoveClassifier() {
		// No op
	}

	/**
	 * Test train string map of string string.
	 */
	@Test
	public void testTrainStringMapOfStringString() {
//		fail("Not yet implemented");
	}

	/**
	 * Test train string input stream.
	 */
	@Test
	public void testTrainStringInputStream() {
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Classifier Name"), TestConstants.TEST_CLASSIFIER_NAME);
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Training Texts"), TestConstants.TRAINING_TEXTS_FILE);
		client.train(TestConstants.TEST_CLASSIFIER_NAME, getClass().getResourceAsStream(TestConstants.TRAINING_TEXTS_FILE));
	}

	/**
	 * Test untrain string map of string string.
	 */
	@Test
	public void testUntrainStringMapOfStringString() {
//		fail("Not yet implemented");
	}

	/**
	 * Test untrain string input stream.
	 */
	@Test
	public void testUntrainStringInputStream() {
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Classifier Name"), TestConstants.TEST_CLASSIFIER_NAME);
		assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Training Texts"), TestConstants.TRAINING_TEXTS_FILE);
		client.untrain(TestConstants.TEST_CLASSIFIER_NAME, getClass().getResourceAsStream(TestConstants.TRAINING_TEXTS_FILE));
	}
}
