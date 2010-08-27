/**
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
	public Future<?> createClassifier(String classifierName);
	public Future<?> removeClassifier(String classifierName);
	public Future<?> addClass(String classifierName, String className);
	public Future<?> removeClass(String classifierName, String className);
	public Future<?> train(String classifierName, Map<String, String> trainingTexts);
	public Future<?> train(String classifierName, InputStream trainingTexts);
	public Future<?> untrain(String classifierName, Map<String, String> trainingTexts);
	public Future<?> untrain(String classifierName, InputStream trainingTexts);
}
