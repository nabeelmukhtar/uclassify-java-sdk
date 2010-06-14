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
public enum ProfileType implements FieldEnum {

    /**
     * standard profile.
     */
    STANDARD(""),

    /**
     * public profile.
     */
    PUBLIC("public");
    
    /**
     * Field Description.
     */
	private static final Map<String, ProfileType> stringToEnum = new HashMap<String, ProfileType>();

	static { // Initialize map from constant name to enum constant
		for (ProfileType op : values()) {
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
    ProfileType(String name) {
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
	 * @return Returns ProfileType for string, or null if string is invalid
	 */
	public static ProfileType fromString(String symbol) {
		return stringToEnum.get(symbol);
	}
}
