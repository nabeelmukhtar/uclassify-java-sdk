
package com.uclassify.api._1.responseschema;

import javax.xml.bind.annotation.XmlRegistry;
import com.uclassify.api._1.responseschema.impl.AddClassImpl;
import com.uclassify.api._1.responseschema.impl.ClassImpl;
import com.uclassify.api._1.responseschema.impl.ClassInformationImpl;
import com.uclassify.api._1.responseschema.impl.ClassesImpl;
import com.uclassify.api._1.responseschema.impl.ClassificationImpl;
import com.uclassify.api._1.responseschema.impl.ClassifyImpl;
import com.uclassify.api._1.responseschema.impl.CreateImpl;
import com.uclassify.api._1.responseschema.impl.GetInformationImpl;
import com.uclassify.api._1.responseschema.impl.RemoveClassImpl;
import com.uclassify.api._1.responseschema.impl.RemoveImpl;
import com.uclassify.api._1.responseschema.impl.ResponseReadCallListImpl;
import com.uclassify.api._1.responseschema.impl.ResponseWriteCallListImpl;
import com.uclassify.api._1.responseschema.impl.StatusImpl;
import com.uclassify.api._1.responseschema.impl.TrainImpl;
import com.uclassify.api._1.responseschema.impl.UclassifyImpl;
import com.uclassify.api._1.responseschema.impl.UntrainImpl;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.uclassify.api._1.responseschema package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.uclassify.api._1.responseschema
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Uclassify }
     * 
     */
    public Uclassify createUclassify() {
        return new UclassifyImpl();
    }

    /**
     * Create an instance of {@link Classify }
     * 
     */
    public Classify createClassify() {
        return new ClassifyImpl();
    }

    /**
     * Create an instance of {@link Classes }
     * 
     */
    public Classes createClasses() {
        return new ClassesImpl();
    }

    /**
     * Create an instance of {@link Untrain }
     * 
     */
    public Untrain createUntrain() {
        return new UntrainImpl();
    }

    /**
     * Create an instance of {@link Status }
     * 
     */
    public Status createStatus() {
        return new StatusImpl();
    }

    /**
     * Create an instance of {@link ResponseReadCallList }
     * 
     */
    public ResponseReadCallList createResponseReadCallList() {
        return new ResponseReadCallListImpl();
    }

    /**
     * Create an instance of {@link ResponseWriteCallList }
     * 
     */
    public ResponseWriteCallList createResponseWriteCallList() {
        return new ResponseWriteCallListImpl();
    }

    /**
     * Create an instance of {@link Train }
     * 
     */
    public Train createTrain() {
        return new TrainImpl();
    }

    /**
     * Create an instance of {@link AddClass }
     * 
     */
    public AddClass createAddClass() {
        return new AddClassImpl();
    }

    /**
     * Create an instance of {@link Classification }
     * 
     */
    public Classification createClassification() {
        return new ClassificationImpl();
    }

    /**
     * Create an instance of {@link Remove }
     * 
     */
    public Remove createRemove() {
        return new RemoveImpl();
    }

    /**
     * Create an instance of {@link ClassInformation }
     * 
     */
    public ClassInformation createClassInformation() {
        return new ClassInformationImpl();
    }

    /**
     * Create an instance of {@link GetInformation }
     * 
     */
    public GetInformation createGetInformation() {
        return new GetInformationImpl();
    }

    /**
     * Create an instance of {@link Create }
     * 
     */
    public Create createCreate() {
        return new CreateImpl();
    }

    /**
     * Create an instance of {@link Class }
     * 
     */
    public Class createClass() {
        return new ClassImpl();
    }

    /**
     * Create an instance of {@link RemoveClass }
     * 
     */
    public RemoveClass createRemoveClass() {
        return new RemoveClassImpl();
    }

}
