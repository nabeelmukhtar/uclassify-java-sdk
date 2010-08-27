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

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import com.uclassify.api._1.responseschema.ClassInformation;
import com.uclassify.api._1.responseschema.Classification;


/**
 * The Interface UClassifyClient. It acts as a facade for the whole UClassify API.
 * 
 * @author Nabeel Mukhtar
 */
public interface UClassifyClient extends UClassifyAuthenticationClient {
	
	/**
	 * Classify.
	 * 
	 * @param classifierName the classifier name
	 * @param texts the texts
	 * 
	 * @return the map< string, classification>
	 */
	public Map<String, Classification> classify(String classifierName, List<String> texts);
	
	/**
	 * Classify.
	 * 
	 * @param classifierName the classifier name
	 * @param texts the texts
	 * 
	 * @return the map< string, classification>
	 */
	public Map<String, Classification> classify(String classifierName, InputStream texts);
	
	/**
	 * Classify.
	 * 
	 * @param userName the user name
	 * @param classifierName the classifier name
	 * @param texts the texts
	 * 
	 * @return the map< string, classification>
	 */
	public Map<String, Classification> classify(String userName, String classifierName, List<String> texts);
	
	/**
	 * Classify.
	 * 
	 * @param userName the user name
	 * @param classifierName the classifier name
	 * @param texts the texts
	 * 
	 * @return the map< string, classification>
	 */
	public Map<String, Classification> classify(String userName, String classifierName, InputStream texts);
	
	/**
	 * Gets the information.
	 * 
	 * @param classifierName the classifier name
	 * 
	 * @return the information
	 */
	public List<ClassInformation> getInformation(String classifierName);
	
	/**
	 * Gets the information.
	 * 
	 * @param userName the user name
	 * @param classifierName the classifier name
	 * 
	 * @return the information
	 */
	public List<ClassInformation> getInformation(String userName, String classifierName);
	
	/**
	 * Creates the classifier.
	 * 
	 * @param classifierName the classifier name
	 */
	public void createClassifier(String classifierName);
	
	/**
	 * Removes the classifier.
	 * 
	 * @param classifierName the classifier name
	 */
	public void removeClassifier(String classifierName);
	
	/**
	 * Adds the class.
	 * 
	 * @param classifierName the classifier name
	 * @param className the class name
	 */
	public void addClass(String classifierName, String className);
	
	/**
	 * Removes the class.
	 * 
	 * @param classifierName the classifier name
	 * @param className the class name
	 */
	public void removeClass(String classifierName, String className);
	
	/**
	 * Train.
	 * 
	 * @param classifierName the classifier name
	 * @param trainingTexts the training texts
	 */
	public void train(String classifierName, Map<String, String> trainingTexts);
	
	/**
	 * Train.
	 * 
	 * @param classifierName the classifier name
	 * @param trainingTexts the training texts
	 */
	public void train(String classifierName, InputStream trainingTexts);
	
	/**
	 * Untrain.
	 * 
	 * @param classifierName the classifier name
	 * @param trainingTexts the training texts
	 */
	public void untrain(String classifierName, Map<String, String> trainingTexts);
	
	/**
	 * Untrain.
	 * 
	 * @param classifierName the classifier name
	 * @param trainingTexts the training texts
	 */
	public void untrain(String classifierName, InputStream trainingTexts);
	
}
