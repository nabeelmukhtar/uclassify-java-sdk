/**
 *
 */
package com.google.code.uclassify.client.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nabeel Mukhtar
 *
 */
public enum EducationsField implements FieldEnum {

    /**
     * a unique identifier for this member's education entry.
     */
    ID("id"),

    /**
     * the name of the school, as indicated by the member
     */
    SCHOOL_NAME("school-name"),

    /**
     * the field of study at the school, as indicated by the member
     */
    FIELD_OF_STUDY("field-of-study"),

    /**
     * the degree of study obtained at the school, as indicated by the member
     */
    DEGREE("degree"),

    /**
     * the activities at the school, as indicated by the member
     */
    ACTIVITIES("activities"),

    /**
     * a structured object a year field indicating when the education began
     */
    START_DATE("start-date"),

    /**
     * a structured object with a year field indicating when the education ended.
     */
    END_DATE("end-date");
    
    /**
     * Field Description.
     */
	private static final Map<String, EducationsField> stringToEnum = new HashMap<String, EducationsField>();

	static { // Initialize map from constant name to enum constant
		for (EducationsField op : values()) {
			stringToEnum.put(op.fieldName(), op);
		}
	}
    
    /** Field description */
    private final String fieldName;

    /**
     * Constructs ...
     *
     *
     * @param name
     */
    EducationsField(String name) {
        this.fieldName = name;
    }

    /**
     * @return the name of the field
     */
    public String fieldName() {
        return this.fieldName;
    }

    /**
     * Method description
     *
     *
     * @return
     */
    @Override
    public String toString() {
        return fieldName();
    }

	/**
	 *
	 * @return Returns EducationsField for string, or null if string is invalid
	 */
	public static EducationsField fromString(String symbol) {
		return stringToEnum.get(symbol);
	}
}
