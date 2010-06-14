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
public enum SearchParameter implements FieldEnum {

    /**
     * Returns members who have keywords anywhere in their profile. Multiple words should be separated by a plus (+) sign. Boolean logic isn't supported in this parameter.
     */
    KEYWORDS("keywords"),

    /**
     * Returns all members with a name matching the one specified in the parameter. If only one name is provided, it's assumed to be the last name (surname). Multiple words must be separated by a plus (+) sign. Boolean logic isn't supported.
     */
    NAME("name"),

    /**
     * Returns members who have a particular company name on their profile. company works with the current-company parameter which specifies whether the company must be a current company or whether it can be anywhere on a profile.
     */
    COMPANY("company"),

    /**
     * Valid values are true or false.
     */
    CURRENT_COMPANY("current-company"),

    /**
     * Returns members who have a particular title on their profile
     */
    TITLE("title"),

    /**
     * Valid values are true or false.
     */
    CURRENT_TITLE("current-title"),

    /**
     * Returns members within a specific industry.
     */
    INDUSTRY_CODE("industry-code"),

    /**
     * To search within a country or postal code, use I. To do a general search either leave this parameter off or use Y.
     */
    SEARCH_LOCATION_TYPE("search-location-type"),

    /**
     * Returns members within a specific country.
     */
    COUNTRY_CODE("country-code"),

    /**
     * Returns members within a specific postal code.
     */
    POSTAL_CODE("postal-code"),

    /**
     * Valid values are in or out.
     */
    NETWORK("network");
    
    /**
     * Field Description.
     */
	private static final Map<String, SearchParameter> stringToEnum = new HashMap<String, SearchParameter>();

	static { // Initialize map from constant name to enum constant
		for (SearchParameter op : values()) {
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
    SearchParameter(String name) {
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
	 * @return Returns SearchParameter for string, or null if string is invalid
	 */
	public static SearchParameter fromString(String symbol) {
		return stringToEnum.get(symbol);
	}
}
