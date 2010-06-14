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
public enum NetworkUpdateType implements FieldEnum {

    /**
     * A connection has answered a question posed on LinkedIn Answers.
     */
    ANSWER_UPDATE("ANSW"),

    /**
     * An action that occurred in a partner application either by a connection or by an application itself. The contents of the update will be HTML entity encoded.
     */
    APPLICATION_UPDATE("APPS"),

    /**
     * These updates cover aspects of connections made on LinkedIn. They cover both the user connecting and the user's connections making connections (second degree connections).
     */
    CONNECTION_UPDATE("CONN"),

    /**
     * A connection has posted a job posting on LinkedIn
     */
    JOB_UPDATE("JOBS"),

    /**
     * A connection has joined a group.
     */
    GROUP_UPDATE("JGRP"),

    /**
     * A connection has updated their profile picture.
     */
    PICTURE_UPDATE("PICT"),

    /**
     * A connection was recommended
     */
    RECOMMENDATION_UPDATE("RECU"),

    /**
     * A connection has updated their profile. This does not include picture updates, which are covered under PICT type.
     */
    PROFILE_UPDATE("PRFU"),

    /**
     * A connection has asked a question on LinkedIn Answers.
     */
    QUESTION_UPDATE("QSTN"),

    /**
     * A connection has updated their status.
     */
    STATUS_UPDATE("STAT");
    
    /**
     * Field Description.
     */
	private static final Map<String, NetworkUpdateType> stringToEnum = new HashMap<String, NetworkUpdateType>();

	static { // Initialize map from constant name to enum constant
		for (NetworkUpdateType op : values()) {
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
    NetworkUpdateType(String name) {
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
	 * @return Returns NetworkUpdateType for string, or null if string is invalid
	 */
	public static NetworkUpdateType fromString(String symbol) {
		return stringToEnum.get(symbol);
	}
}
