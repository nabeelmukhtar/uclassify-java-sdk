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

public interface SchemaElementFactory {

	/**
	 * Create an instance of {@link WriteCallList }
	 * 
	 */
	public WriteCallList createWriteCallList();

	/**
	 * Create an instance of {@link AddClass }
	 * 
	 */
	public AddClass createAddClass();

	/**
	 * Create an instance of {@link Uclassify }
	 * 
	 */
	public Uclassify createUclassify();

	/**
	 * Create an instance of {@link ReadCallList }
	 * 
	 */
	public ReadCallList createReadCallList();

	/**
	 * Create an instance of {@link Train }
	 * 
	 */
	public Train createTrain();

	/**
	 * Create an instance of {@link Create }
	 * 
	 */
	public Create createCreate();

	/**
	 * Create an instance of {@link TextBase64 }
	 * 
	 */
	public TextBase64 createTextBase64();

	/**
	 * Create an instance of {@link GetInformation }
	 * 
	 */
	public GetInformation createGetInformation();

	/**
	 * Create an instance of {@link WebReadCallList }
	 * 
	 */
	public WebReadCallList createWebReadCallList();

	/**
	 * Create an instance of {@link Classify }
	 * 
	 */
	public Classify createClassify();

	/**
	 * Create an instance of {@link Untrain }
	 * 
	 */
	public Untrain createUntrain();

	/**
	 * Create an instance of {@link TextList }
	 * 
	 */
	public TextList createTextList();

	/**
	 * Create an instance of {@link Remove }
	 * 
	 */
	public Remove createRemove();

	/**
	 * Create an instance of {@link WebWriteCallList }
	 * 
	 */
	public WebWriteCallList createWebWriteCallList();

	/**
	 * Create an instance of {@link RemoveClass }
	 * 
	 */
	public RemoveClass createRemoveClass();

}