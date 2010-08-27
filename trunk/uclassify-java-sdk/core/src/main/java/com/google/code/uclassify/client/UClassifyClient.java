/**
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
	public void createClassifier(String classifierName);
	public void removeClassifier(String classifierName);
	public void addClass(String classifierName, String className);
	public void removeClass(String classifierName, String className);
	public void train(String classifierName, Map<String, String> trainingTexts);
	public void train(String classifierName, InputStream trainingTexts);
	public void untrain(String classifierName, Map<String, String> trainingTexts);
	public void untrain(String classifierName, InputStream trainingTexts);
}
