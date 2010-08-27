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

package com.uclassify.api._1.requestschema.impl;

import javax.xml.bind.annotation.XmlRegistry;
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
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.uclassify.api._1.requestschema.impl package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.uclassify.api._1.requestschema.impl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link WriteCallList }
     * 
     */
    public WriteCallListImpl createWriteCallList() {
        return new WriteCallListImpl();
    }

    /**
     * Create an instance of {@link AddClass }
     * 
     */
    public AddClassImpl createAddClass() {
        return new AddClassImpl();
    }

    /**
     * Create an instance of {@link Uclassify }
     * 
     */
    public UclassifyImpl createUclassify() {
        return new UclassifyImpl();
    }

    /**
     * Create an instance of {@link ReadCallList }
     * 
     */
    public ReadCallListImpl createReadCallList() {
        return new ReadCallListImpl();
    }

    /**
     * Create an instance of {@link Train }
     * 
     */
    public TrainImpl createTrain() {
        return new TrainImpl();
    }

    /**
     * Create an instance of {@link Create }
     * 
     */
    public CreateImpl createCreate() {
        return new CreateImpl();
    }

    /**
     * Create an instance of {@link TextBase64 }
     * 
     */
    public TextBase64Impl createTextBase64() {
        return new TextBase64Impl();
    }

    /**
     * Create an instance of {@link GetInformation }
     * 
     */
    public GetInformationImpl createGetInformation() {
        return new GetInformationImpl();
    }

    /**
     * Create an instance of {@link WebReadCallList }
     * 
     */
    public WebReadCallListImpl createWebReadCallList() {
        return new WebReadCallListImpl();
    }

    /**
     * Create an instance of {@link Classify }
     * 
     */
    public ClassifyImpl createClassify() {
        return new ClassifyImpl();
    }

    /**
     * Create an instance of {@link Untrain }
     * 
     */
    public UntrainImpl createUntrain() {
        return new UntrainImpl();
    }

    /**
     * Create an instance of {@link TextList }
     * 
     */
    public TextListImpl createTextList() {
        return new TextListImpl();
    }

    /**
     * Create an instance of {@link Remove }
     * 
     */
    public RemoveImpl createRemove() {
        return new RemoveImpl();
    }

    /**
     * Create an instance of {@link WebWriteCallList }
     * 
     */
    public WebWriteCallListImpl createWebWriteCallList() {
        return new WebWriteCallListImpl();
    }

    /**
     * Create an instance of {@link RemoveClass }
     * 
     */
    public RemoveClassImpl createRemoveClass() {
        return new RemoveClassImpl();
    }

}
