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

import com.uclassify.api._1.requestschema.AddClass;
import com.uclassify.api._1.requestschema.Classify;
import com.uclassify.api._1.requestschema.Create;
import com.uclassify.api._1.requestschema.GetInformation;
import com.uclassify.api._1.requestschema.ReadCallList;
import com.uclassify.api._1.requestschema.Remove;
import com.uclassify.api._1.requestschema.RemoveClass;
import com.uclassify.api._1.requestschema.TextBase64;
import com.uclassify.api._1.requestschema.TextList;
import com.uclassify.api._1.requestschema.Train;
import com.uclassify.api._1.requestschema.Uclassify;
import com.uclassify.api._1.requestschema.Untrain;
import com.uclassify.api._1.requestschema.WebReadCallList;
import com.uclassify.api._1.requestschema.WebWriteCallList;
import com.uclassify.api._1.requestschema.WriteCallList;

/**
 * A factory for creating SchemaElement objects.
 */
public interface SchemaElementFactory {

	/**
	 * Create an instance of {@link WriteCallList }.
	 * 
	 * @return the write call list
	 */
	public WriteCallList createWriteCallList();

	/**
	 * Create an instance of {@link AddClass }.
	 * 
	 * @return the adds the class
	 */
	public AddClass createAddClass();

	/**
	 * Create an instance of {@link Uclassify }.
	 * 
	 * @return the uclassify
	 */
	public Uclassify createUclassify();

	/**
	 * Create an instance of {@link ReadCallList }.
	 * 
	 * @return the read call list
	 */
	public ReadCallList createReadCallList();

	/**
	 * Create an instance of {@link Train }.
	 * 
	 * @return the train
	 */
	public Train createTrain();

	/**
	 * Create an instance of {@link Create }.
	 * 
	 * @return the creates the
	 */
	public Create createCreate();

	/**
	 * Create an instance of {@link TextBase64 }.
	 * 
	 * @return the text base64
	 */
	public TextBase64 createTextBase64();

	/**
	 * Create an instance of {@link GetInformation }.
	 * 
	 * @return the gets the information
	 */
	public GetInformation createGetInformation();

	/**
	 * Create an instance of {@link WebReadCallList }.
	 * 
	 * @return the web read call list
	 */
	public WebReadCallList createWebReadCallList();

	/**
	 * Create an instance of {@link Classify }.
	 * 
	 * @return the classify
	 */
	public Classify createClassify();

	/**
	 * Create an instance of {@link Untrain }.
	 * 
	 * @return the untrain
	 */
	public Untrain createUntrain();

	/**
	 * Create an instance of {@link TextList }.
	 * 
	 * @return the text list
	 */
	public TextList createTextList();

	/**
	 * Create an instance of {@link Remove }.
	 * 
	 * @return the removes the
	 */
	public Remove createRemove();

	/**
	 * Create an instance of {@link WebWriteCallList }.
	 * 
	 * @return the web write call list
	 */
	public WebWriteCallList createWebWriteCallList();

	/**
	 * Create an instance of {@link RemoveClass }.
	 * 
	 * @return the removes the class
	 */
	public RemoveClass createRemoveClass();

}