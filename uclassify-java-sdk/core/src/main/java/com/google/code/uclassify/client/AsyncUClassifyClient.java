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
	public Future<Map<String, Classification>> classify(String classifierName, List<String> texts);
	public Future<Map<String, Classification>> classify(String classifierName, InputStream texts);
	public Future<Map<String, Classification>> classify(String userName, String classifierName, List<String> texts);
	public Future<Map<String, Classification>> classify(String userName, String classifierName, InputStream texts);
	public Future<List<ClassInformation>> getInformation(String classifierName);
	public Future<List<ClassInformation>> getInformation(String userName, String classifierName);
	public Future<?> createClassifier(String classifierName);
	public Future<?> removeClassifier(String classifierName);
	public Future<?> addClass(String classifierName, String className);
	public Future<?> removeClass(String classifierName, String className);
	public Future<?> train(String classifierName, Map<String, String> trainingTexts);
	public Future<?> train(String classifierName, InputStream trainingTexts);
	public Future<?> untrain(String classifierName, Map<String, String> trainingTexts);
	public Future<?> untrain(String classifierName, InputStream trainingTexts);
}
