/**
 *
 */
package com.google.code.uclassify.schema.xml;

import java.io.IOException;
import java.util.Properties;

/**
 * @author Nabeel Mukhtar
 *
 */
public final class TestXMLFiles {

    /** Field description */
    public static final String TEST_XML_FILES = "TestXMLFiles.properties";

    /** Field description */
    private static final Properties testXmlFiles = new Properties();

    static {
        try {
            testXmlFiles.load(TestXMLFiles.class.getResourceAsStream(TEST_XML_FILES));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** Field description */
    public static final String LINKED_IN_SCHEMA_UPDATE_STATUS_XML =
        testXmlFiles.getProperty("com.google.code.linkedinapi.schema.xml.updateCurrentStatus");

    /** Field description */
    public static final String LINKED_IN_SCHEMA_UPDATE_NETWORK_UPDATE_XML =
        testXmlFiles.getProperty("com.google.code.linkedinapi.schema.xml.updateNetworkUpdate");

    /** Field description */
    public static final String LINKED_IN_SCHEMA_UPDATE_COMMENT_XML =
        testXmlFiles.getProperty("com.google.code.linkedinapi.schema.xml.updateComment");

    /** Field description */
    public static final String LINKED_IN_SCHEMA_SEND_MESSAGE_XML =
        testXmlFiles.getProperty("com.google.code.linkedinapi.schema.xml.sendMessage");

    /** Field description */
    public static final String LINKED_IN_SCHEMA_SEND_INVITE_XML =
        testXmlFiles.getProperty("com.google.code.linkedinapi.schema.xml.sendInvite");

    /** Field description */
    public static final String LINKED_IN_SCHEMA_SEARCH_XML =
        testXmlFiles.getProperty("com.google.code.linkedinapi.schema.xml.search");

    /** Field description */
    public static final String LINKED_IN_SCHEMA_PROFILE_XML =
        testXmlFiles.getProperty("com.google.code.linkedinapi.schema.xml.profile");

    /** Field description */
    public static final String LINKED_IN_SCHEMA_NETWORK_UPDATES_XML =
        testXmlFiles.getProperty("com.google.code.linkedinapi.schema.xml.networkUpdates");

    /** Field description */
    public static final String LINKED_IN_SCHEMA_CONNECTIONS_XML =
        testXmlFiles.getProperty("com.google.code.linkedinapi.schema.xml.connections");

    /**
     * Constructs ...
     *
     */
    private TestXMLFiles() {}
}
