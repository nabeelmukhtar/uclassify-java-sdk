/**
 *
 */
package com.google.code.uclassify.client.constant;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Nabeel Mukhtar
 *
 */
public final class TestConstants {

    /** Field description */
    public static final String TEST_CONSTANTS_FILE = "TestConstants.properties";

    /** Field description */
    private static final Properties testConstants = new Properties();

    static {
        try {
            testConstants.load(TestConstants.class.getResourceAsStream(TEST_CONSTANTS_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /** Field description */
    public static final String UCLASSIFY_TEST_READ_KEY =
        testConstants.getProperty("com.google.code.uclassify.client.readApiKey");

    /** Field description */
    public static final String UCLASSIFY_TEST_WRITE_KEY =
        testConstants.getProperty("com.google.code.uclassify.client.writeApiKey");
    
    /**
     * Constructs ...
     *
     */
    private TestConstants() {}
}
