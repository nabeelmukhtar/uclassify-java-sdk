
package com.uclassify.api._1.responseschema.impl;

import javax.xml.bind.annotation.XmlRegistry;
import com.uclassify.api._1.responseschema.AddClass;
import com.uclassify.api._1.responseschema.Class;
import com.uclassify.api._1.responseschema.ClassInformation;
import com.uclassify.api._1.responseschema.Classes;
import com.uclassify.api._1.responseschema.Classification;
import com.uclassify.api._1.responseschema.Classify;
import com.uclassify.api._1.responseschema.Create;
import com.uclassify.api._1.responseschema.GetInformation;
import com.uclassify.api._1.responseschema.Remove;
import com.uclassify.api._1.responseschema.RemoveClass;
import com.uclassify.api._1.responseschema.ResponseReadCallList;
import com.uclassify.api._1.responseschema.ResponseWriteCallList;
import com.uclassify.api._1.responseschema.Status;
import com.uclassify.api._1.responseschema.Train;
import com.uclassify.api._1.responseschema.Uclassify;
import com.uclassify.api._1.responseschema.Untrain;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.uclassify.api._1.responseschema.impl package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.uclassify.api._1.responseschema.impl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Uclassify }
     * 
     */
    public UclassifyImpl createUclassify() {
        return new UclassifyImpl();
    }

    /**
     * Create an instance of {@link Classify }
     * 
     */
    public ClassifyImpl createClassify() {
        return new ClassifyImpl();
    }

    /**
     * Create an instance of {@link Classes }
     * 
     */
    public ClassesImpl createClasses() {
        return new ClassesImpl();
    }

    /**
     * Create an instance of {@link Untrain }
     * 
     */
    public UntrainImpl createUntrain() {
        return new UntrainImpl();
    }

    /**
     * Create an instance of {@link Status }
     * 
     */
    public StatusImpl createStatus() {
        return new StatusImpl();
    }

    /**
     * Create an instance of {@link ResponseReadCallList }
     * 
     */
    public ResponseReadCallListImpl createResponseReadCallList() {
        return new ResponseReadCallListImpl();
    }

    /**
     * Create an instance of {@link ResponseWriteCallList }
     * 
     */
    public ResponseWriteCallListImpl createResponseWriteCallList() {
        return new ResponseWriteCallListImpl();
    }

    /**
     * Create an instance of {@link Train }
     * 
     */
    public TrainImpl createTrain() {
        return new TrainImpl();
    }

    /**
     * Create an instance of {@link AddClass }
     * 
     */
    public AddClassImpl createAddClass() {
        return new AddClassImpl();
    }

    /**
     * Create an instance of {@link Classification }
     * 
     */
    public ClassificationImpl createClassification() {
        return new ClassificationImpl();
    }

    /**
     * Create an instance of {@link Remove }
     * 
     */
    public RemoveImpl createRemove() {
        return new RemoveImpl();
    }

    /**
     * Create an instance of {@link ClassInformation }
     * 
     */
    public ClassInformationImpl createClassInformation() {
        return new ClassInformationImpl();
    }

    /**
     * Create an instance of {@link GetInformation }
     * 
     */
    public GetInformationImpl createGetInformation() {
        return new GetInformationImpl();
    }

    /**
     * Create an instance of {@link Create }
     * 
     */
    public CreateImpl createCreate() {
        return new CreateImpl();
    }

    /**
     * Create an instance of {@link Class }
     * 
     */
    public ClassImpl createClass() {
        return new ClassImpl();
    }

    /**
     * Create an instance of {@link RemoveClass }
     * 
     */
    public RemoveClassImpl createRemoveClass() {
        return new RemoveClassImpl();
    }

}
