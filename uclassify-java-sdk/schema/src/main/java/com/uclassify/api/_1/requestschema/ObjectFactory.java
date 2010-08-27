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

package com.uclassify.api._1.requestschema;

import javax.xml.bind.annotation.XmlRegistry;
import com.uclassify.api._1.requestschema.impl.AddClassImpl;
import com.uclassify.api._1.requestschema.impl.ClassifyImpl;
import com.uclassify.api._1.requestschema.impl.CreateImpl;
import com.uclassify.api._1.requestschema.impl.GetInformationImpl;
import com.uclassify.api._1.requestschema.impl.ReadCallListImpl;
import com.uclassify.api._1.requestschema.impl.RemoveClassImpl;
import com.uclassify.api._1.requestschema.impl.RemoveImpl;
import com.uclassify.api._1.requestschema.impl.TextBase64Impl;
import com.uclassify.api._1.requestschema.impl.TextListImpl;
import com.uclassify.api._1.requestschema.impl.TrainImpl;
import com.uclassify.api._1.requestschema.impl.UclassifyImpl;
import com.uclassify.api._1.requestschema.impl.UntrainImpl;
import com.uclassify.api._1.requestschema.impl.WebReadCallListImpl;
import com.uclassify.api._1.requestschema.impl.WebWriteCallListImpl;
import com.uclassify.api._1.requestschema.impl.WriteCallListImpl;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.uclassify.api._1.requestschema package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static Void _useJAXBProperties = null;

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.uclassify.api._1.requestschema
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link WriteCallList }
     * 
     */
    public WriteCallList createWriteCallList() {
        return new WriteCallListImpl();
    }

    /**
     * Create an instance of {@link AddClass }
     * 
     */
    public AddClass createAddClass() {
        return new AddClassImpl();
    }

    /**
     * Create an instance of {@link Uclassify }
     * 
     */
    public Uclassify createUclassify() {
        return new UclassifyImpl();
    }

    /**
     * Create an instance of {@link ReadCallList }
     * 
     */
    public ReadCallList createReadCallList() {
        return new ReadCallListImpl();
    }

    /**
     * Create an instance of {@link Train }
     * 
     */
    public Train createTrain() {
        return new TrainImpl();
    }

    /**
     * Create an instance of {@link Create }
     * 
     */
    public Create createCreate() {
        return new CreateImpl();
    }

    /**
     * Create an instance of {@link TextBase64 }
     * 
     */
    public TextBase64 createTextBase64() {
        return new TextBase64Impl();
    }

    /**
     * Create an instance of {@link GetInformation }
     * 
     */
    public GetInformation createGetInformation() {
        return new GetInformationImpl();
    }

    /**
     * Create an instance of {@link WebReadCallList }
     * 
     */
    public WebReadCallList createWebReadCallList() {
        return new WebReadCallListImpl();
    }

    /**
     * Create an instance of {@link Classify }
     * 
     */
    public Classify createClassify() {
        return new ClassifyImpl();
    }

    /**
     * Create an instance of {@link Untrain }
     * 
     */
    public Untrain createUntrain() {
        return new UntrainImpl();
    }

    /**
     * Create an instance of {@link TextList }
     * 
     */
    public TextList createTextList() {
        return new TextListImpl();
    }

    /**
     * Create an instance of {@link Remove }
     * 
     */
    public Remove createRemove() {
        return new RemoveImpl();
    }

    /**
     * Create an instance of {@link WebWriteCallList }
     * 
     */
    public WebWriteCallList createWebWriteCallList() {
        return new WebWriteCallListImpl();
    }

    /**
     * Create an instance of {@link RemoveClass }
     * 
     */
    public RemoveClass createRemoveClass() {
        return new RemoveClassImpl();
    }

}
