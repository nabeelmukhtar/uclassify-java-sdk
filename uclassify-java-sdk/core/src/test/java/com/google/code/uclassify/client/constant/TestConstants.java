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
package com.google.code.uclassify.client.constant;
import java.io.IOException;
import java.util.Properties;

/**
 * The Class TestConstants.
 * 
 * @author Nabeel Mukhtar
 */
public final class TestConstants {

    /** Field description. */
    public static final String TEST_CONSTANTS_FILE = "TestConstants.properties";

    /** Field description. */
    private static final Properties testConstants = new Properties();

    static {
        try {
            testConstants.load(TestConstants.class.getResourceAsStream(TEST_CONSTANTS_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /** Field description. */
    public static final String UCLASSIFY_TEST_READ_KEY =
        testConstants.getProperty("com.google.code.uclassify.client.readApiKey");

    /** Field description. */
    public static final String UCLASSIFY_TEST_WRITE_KEY =
        testConstants.getProperty("com.google.code.uclassify.client.writeApiKey");

	public static final String TEST_CLASSIFIER_NAME = 
		testConstants.getProperty("com.google.code.uclassify.client.classifierName");

	public static final String TEST_CLASS_NAME = 
		testConstants.getProperty("com.google.code.uclassify.client.className");
    
	public static final String CLASSIFICATION_TEXTS_FILE = 
		testConstants.getProperty("com.google.code.uclassify.client.classificationTexts");
	
	public static final String TRAINING_TEXTS_FILE = 
		testConstants.getProperty("com.google.code.uclassify.client.trainingTexts");
	
    /**
     * Constructs ...
     */
    private TestConstants() {}
}
