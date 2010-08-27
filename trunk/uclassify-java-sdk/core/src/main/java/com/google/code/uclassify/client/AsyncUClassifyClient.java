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
import java.util.concurrent.Future;

import com.uclassify.api._1.responseschema.ClassInformation;
import com.uclassify.api._1.responseschema.Classification;


/**
 * The Interface AsyncUClassifyClient. This interface can be used for asynchronous invocation of API methods.
 * 
 * @author Nabeel Mukhtar
 */
public interface AsyncUClassifyClient extends UClassifyAuthenticationClient {
	
	/**
	 * Classify.
	 * 
	 * @param classifierName the classifier name
	 * @param texts the texts
	 * 
	 * @return the future< map< string, classification>>
	 */
	public Future<Map<String, Classification>> classify(String classifierName, List<String> texts);
	
	/**
	 * Classify.
	 * 
	 * @param classifierName the classifier name
	 * @param texts the texts
	 * 
	 * @return the future< map< string, classification>>
	 */
	public Future<Map<String, Classification>> classify(String classifierName, InputStream texts);
	
	/**
	 * Classify.
	 * 
	 * @param userName the user name
	 * @param classifierName the classifier name
	 * @param texts the texts
	 * 
	 * @return the future< map< string, classification>>
	 */
	public Future<Map<String, Classification>> classify(String userName, String classifierName, List<String> texts);
	
	/**
	 * Classify.
	 * 
	 * @param userName the user name
	 * @param classifierName the classifier name
	 * @param texts the texts
	 * 
	 * @return the future< map< string, classification>>
	 */
	public Future<Map<String, Classification>> classify(String userName, String classifierName, InputStream texts);
	
	/**
	 * Gets the information.
	 * 
	 * @param classifierName the classifier name
	 * 
	 * @return the information
	 */
	public Future<List<ClassInformation>> getInformation(String classifierName);
	
	/**
	 * Gets the information.
	 * 
	 * @param userName the user name
	 * @param classifierName the classifier name
	 * 
	 * @return the information
	 */
	public Future<List<ClassInformation>> getInformation(String userName, String classifierName);
	
	/**
	 * Creates the classifier.
	 * 
	 * @param classifierName the classifier name
	 * 
	 * @return the future<?>
	 */
	public Future<?> createClassifier(String classifierName);
	
	/**
	 * Removes the classifier.
	 * 
	 * @param classifierName the classifier name
	 * 
	 * @return the future<?>
	 */
	public Future<?> removeClassifier(String classifierName);
	
	/**
	 * Adds the class.
	 * 
	 * @param classifierName the classifier name
	 * @param className the class name
	 * 
	 * @return the future<?>
	 */
	public Future<?> addClass(String classifierName, String className);
	
	/**
	 * Removes the class.
	 * 
	 * @param classifierName the classifier name
	 * @param className the class name
	 * 
	 * @return the future<?>
	 */
	public Future<?> removeClass(String classifierName, String className);
	
	/**
	 * Train.
	 * 
	 * @param classifierName the classifier name
	 * @param trainingTexts the training texts
	 * 
	 * @return the future<?>
	 */
	public Future<?> train(String classifierName, Map<String, String> trainingTexts);
	
	/**
	 * Train.
	 * 
	 * @param classifierName the classifier name
	 * @param trainingTexts the training texts
	 * 
	 * @return the future<?>
	 */
	public Future<?> train(String classifierName, InputStream trainingTexts);
	
	/**
	 * Untrain.
	 * 
	 * @param classifierName the classifier name
	 * @param trainingTexts the training texts
	 * 
	 * @return the future<?>
	 */
	public Future<?> untrain(String classifierName, Map<String, String> trainingTexts);
	
	/**
	 * Untrain.
	 * 
	 * @param classifierName the classifier name
	 * @param trainingTexts the training texts
	 * 
	 * @return the future<?>
	 */
	public Future<?> untrain(String classifierName, InputStream trainingTexts);
}
