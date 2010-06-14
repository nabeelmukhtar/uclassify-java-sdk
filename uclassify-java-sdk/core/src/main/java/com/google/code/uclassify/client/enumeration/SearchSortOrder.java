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
public enum SearchSortOrder implements FieldEnum {
	
    /**
     * Orders the returns by number of ensorsers each of the search returns has.
     */
    NUMBER_OF_RECOMMENDERS("recommenders"),

    /**
     * Orders the returns based on the ascending degree of separation within a member's network, with first degree connections first.
     */
    DISTANCE("distance"),

    /**
     * Orders the returns based on relevance for the keywords provided.
     */
    RELEVANCE("relevance");
    
    /**
     * Field Description.
     */
	private static final Map<String, SearchSortOrder> stringToEnum = new HashMap<String, SearchSortOrder>();

	static { // Initialize map from constant name to enum constant
		for (SearchSortOrder op : values()) {
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
    SearchSortOrder(String name) {
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
	 * @return Returns SearchSortOrder for string, or null if string is invalid
	 */
	public static SearchSortOrder fromString(String symbol) {
		return stringToEnum.get(symbol);
	}
}
