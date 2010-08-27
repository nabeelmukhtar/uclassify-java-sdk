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
	public Map<String, Classification> classify(String classifierName, List<String> texts);
	public Map<String, Classification> classify(String classifierName, InputStream texts);
	public Map<String, Classification> classify(String userName, String classifierName, List<String> texts);
	public Map<String, Classification> classify(String userName, String classifierName, InputStream texts);
	public List<ClassInformation> getInformation(String classifierName);
	public List<ClassInformation> getInformation(String userName, String classifierName);
	public void createClassifier(String classifierName);
	public void removeClassifier(String classifierName);
	public void addClass(String classifierName, String className);
	public void removeClass(String classifierName, String className);
	public void train(String classifierName, Map<String, String> trainingTexts);
	public void train(String classifierName, InputStream trainingTexts);
	public void untrain(String classifierName, Map<String, String> trainingTexts);
	public void untrain(String classifierName, InputStream trainingTexts);
	
}
