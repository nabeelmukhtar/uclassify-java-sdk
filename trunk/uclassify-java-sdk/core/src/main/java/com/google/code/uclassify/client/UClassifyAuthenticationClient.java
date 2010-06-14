/**
 *
 */
package com.google.code.uclassify.client;


/**
 * @author Nabeel Mukhtar
 *
 */
public interface UClassifyAuthenticationClient extends UClassifyCommunicationClient {

    /**
     * Method description
     *
     *
     * @param apiConsumer
     */
    public void setApiConsumer(UClassifyConsumer apiConsumer);

    /**
     * Method description
     *
     *
     * @return
     */
    public UClassifyConsumer getApiConsumer();
}
