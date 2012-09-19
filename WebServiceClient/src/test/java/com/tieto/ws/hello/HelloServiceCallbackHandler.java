/**
 * HelloServiceCallbackHandler.java This file was auto-generated from WSDL by the Apache
 * Axis2 version: 1.6.2 Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.tieto.ws.hello;

/**
 *  HelloServiceCallbackHandler Callback class, Users can extend this class and implement
 *  their own receiveResult and receiveError methods.
 */
public abstract class HelloServiceCallbackHandler
{

  protected Object clientData;

  /**
  * User can pass in any object that needs to be accessed once the NonBlocking
  * Web service call is finished and appropriate method of this CallBack is called.
  * @param clientData Object mechanism by which the user can pass in user data
  * that will be avilable at the time this callback is called.
  */
  public HelloServiceCallbackHandler(Object clientData)
  {
    this.clientData = clientData;
  }

  /**
  * Please use this constructor if you don't want to set any clientData
  */
  public HelloServiceCallbackHandler()
  {
    this.clientData = null;
  }

  /**
   * Get the client data
   */

  public Object getClientData()
  {
    return clientData;
  }

  /**
   * auto generated Axis2 call back method for setName method
   * override this method for handling normal response from setName operation
   */
  public void receiveResultsetName(com.tieto.ws.hello.HelloServiceStub.SetNameResponseE result)
  {
  }

  /**
   * auto generated Axis2 Error handler
   * override this method for handling error response from setName operation
   */
  public void receiveErrorsetName(java.lang.Exception e)
  {
  }

  /**
   * auto generated Axis2 call back method for upload method
   * override this method for handling normal response from upload operation
   */
  public void receiveResultupload(com.tieto.ws.hello.HelloServiceStub.UploadResponseE result)
  {
  }

  /**
   * auto generated Axis2 Error handler
   * override this method for handling error response from upload operation
   */
  public void receiveErrorupload(java.lang.Exception e)
  {
  }

}
