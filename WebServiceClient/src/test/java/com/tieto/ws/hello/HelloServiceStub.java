/**
 * HelloServiceStub.java This file was auto-generated from WSDL by the Apache Axis2
 * version: 1.6.2 Built on : Apr 17, 2012 (05:33:49 IST)
 */
package com.tieto.ws.hello;

/*
 * HelloServiceStub java implementation
 */

public class HelloServiceStub extends org.apache.axis2.client.Stub
{
  protected org.apache.axis2.description.AxisOperation[] _operations;

  //hashmaps to keep the fault mapping
  private java.util.HashMap                              faultExceptionNameMap      = new java.util.HashMap();
  private java.util.HashMap                              faultExceptionClassNameMap = new java.util.HashMap();
  private java.util.HashMap                              faultMessageMap            = new java.util.HashMap();

  private static int                                     counter                    = 0;

  private static synchronized java.lang.String getUniqueSuffix()
  {
    // reset the counter if it is greater than 99999
    if (counter > 99999)
    {
      counter = 0;
    }
    counter = counter + 1;
    return java.lang.Long.toString(java.lang.System.currentTimeMillis()) + "_" + counter;
  }

  private void populateAxisService() throws org.apache.axis2.AxisFault
  {

    //creating the Service with a unique name
    _service = new org.apache.axis2.description.AxisService("HelloService" + getUniqueSuffix());
    addAnonymousOperations();

    //creating the operations
    org.apache.axis2.description.AxisOperation __operation;

    _operations = new org.apache.axis2.description.AxisOperation[2];

    __operation = new org.apache.axis2.description.OutInAxisOperation();

    __operation.setName(new javax.xml.namespace.QName("http://ws.tieto.com/", "setName"));
    _service.addOperation(__operation);

    _operations[0] = __operation;

    __operation = new org.apache.axis2.description.OutInAxisOperation();

    __operation.setName(new javax.xml.namespace.QName("http://ws.tieto.com/", "upload"));
    _service.addOperation(__operation);

    _operations[1] = __operation;

  }

  //populates the faults
  private void populateFaults()
  {

  }

  /**
    *Constructor that takes in a configContext
    */

  public HelloServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext,
      java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault
  {
    this(configurationContext, targetEndpoint, false);
  }

  /**
    * Constructor that takes in a configContext  and useseperate listner
    */
  public HelloServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext,
      java.lang.String targetEndpoint, boolean useSeparateListener) throws org.apache.axis2.AxisFault
  {
    //To populate AxisService
    populateAxisService();
    populateFaults();

    _serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext, _service);

    _serviceClient.getOptions().setTo(new org.apache.axis2.addressing.EndpointReference(targetEndpoint));
    _serviceClient.getOptions().setUseSeparateListener(useSeparateListener);

  }

  /**
   * Default Constructor
   */
  public HelloServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext)
      throws org.apache.axis2.AxisFault
  {

    this(configurationContext, "http://10.80.41.70:8080/hello");

  }

  /**
   * Default Constructor
   */
  public HelloServiceStub() throws org.apache.axis2.AxisFault
  {

    this("http://10.80.41.70:8080/hello");

  }

  /**
   * Constructor taking the target endpoint
   */
  public HelloServiceStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault
  {
    this(null, targetEndpoint);
  }

  /**
   * Auto generated method signature
   * 
   * @see com.tieto.ws.hello.HelloService#setName
   * @param setName0
  
   */

  public com.tieto.ws.hello.HelloServiceStub.SetNameResponseE setName(

  com.tieto.ws.hello.HelloServiceStub.SetNameE setName0)

  throws java.rmi.RemoteException

  {
    org.apache.axis2.context.MessageContext _messageContext = null;
    try
    {
      org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0]
          .getName());
      _operationClient.getOptions().setAction("abc");
      _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

      addPropertyToOperationClient(_operationClient,
          org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");

      // create a message context
      _messageContext = new org.apache.axis2.context.MessageContext();

      // create SOAP envelope with that payload
      org.apache.axiom.soap.SOAPEnvelope env = null;

      env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), setName0,
          optimizeContent(new javax.xml.namespace.QName("http://ws.tieto.com/", "setName")),
          new javax.xml.namespace.QName("http://ws.tieto.com/", "setName"));

      //adding SOAP soap_headers
      _serviceClient.addHeadersToEnvelope(env);
      // set the message context with that soap envelope
      _messageContext.setEnvelope(env);

      // add the message contxt to the operation client
      _operationClient.addMessageContext(_messageContext);

      //execute the operation client
      _operationClient.execute(true);

      org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient
          .getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
      org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

      java.lang.Object object = fromOM(_returnEnv.getBody().getFirstElement(),
          com.tieto.ws.hello.HelloServiceStub.SetNameResponseE.class, getEnvelopeNamespaces(_returnEnv));

      return (com.tieto.ws.hello.HelloServiceStub.SetNameResponseE)object;

    }
    catch (org.apache.axis2.AxisFault f)
    {

      org.apache.axiom.om.OMElement faultElt = f.getDetail();
      if (faultElt != null)
      {
        if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),
            "setName")))
        {
          //make the fault by reflection
          try
          {
            java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap
                .get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "setName"));
            java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
            java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
            java.lang.Exception ex = (java.lang.Exception)constructor.newInstance(f.getMessage());
            //message class
            java.lang.String messageClassName = (java.lang.String)faultMessageMap
                .get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "setName"));
            java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
            java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
            java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                new java.lang.Class[] { messageClass });
            m.invoke(ex, new java.lang.Object[] { messageObject });

            throw new java.rmi.RemoteException(ex.getMessage(), ex);
          }
          catch (java.lang.ClassCastException e)
          {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          }
          catch (java.lang.ClassNotFoundException e)
          {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          }
          catch (java.lang.NoSuchMethodException e)
          {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          }
          catch (java.lang.reflect.InvocationTargetException e)
          {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          }
          catch (java.lang.IllegalAccessException e)
          {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          }
          catch (java.lang.InstantiationException e)
          {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          }
        }
        else
        {
          throw f;
        }
      }
      else
      {
        throw f;
      }
    }
    finally
    {
      if (_messageContext.getTransportOut() != null)
      {
        _messageContext.getTransportOut().getSender().cleanup(_messageContext);
      }
    }
  }

  /**
  * Auto generated method signature for Asynchronous Invocations
  * 
  * @see com.tieto.ws.hello.HelloService#startsetName
      * @param setName0
  
  */
  public void startsetName(

  com.tieto.ws.hello.HelloServiceStub.SetNameE setName0,

  final com.tieto.ws.hello.HelloServiceCallbackHandler callback)

  throws java.rmi.RemoteException
  {

    org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0]
        .getName());
    _operationClient.getOptions().setAction("abc");
    _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

    addPropertyToOperationClient(_operationClient,
        org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");

    // create SOAP envelope with that payload
    org.apache.axiom.soap.SOAPEnvelope env = null;
    final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

    //Style is Doc.

    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), setName0,
        optimizeContent(new javax.xml.namespace.QName("http://ws.tieto.com/", "setName")),
        new javax.xml.namespace.QName("http://ws.tieto.com/", "setName"));

    // adding SOAP soap_headers
    _serviceClient.addHeadersToEnvelope(env);
    // create message context with that soap envelope
    _messageContext.setEnvelope(env);

    // add the message context to the operation client
    _operationClient.addMessageContext(_messageContext);

    _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
      public void onMessage(org.apache.axis2.context.MessageContext resultContext)
      {
        try
        {
          org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

          java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
              com.tieto.ws.hello.HelloServiceStub.SetNameResponseE.class, getEnvelopeNamespaces(resultEnv));
          callback.receiveResultsetName((com.tieto.ws.hello.HelloServiceStub.SetNameResponseE)object);

        }
        catch (org.apache.axis2.AxisFault e)
        {
          callback.receiveErrorsetName(e);
        }
      }

      public void onError(java.lang.Exception error)
      {
        if (error instanceof org.apache.axis2.AxisFault)
        {
          org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault)error;
          org.apache.axiom.om.OMElement faultElt = f.getDetail();
          if (faultElt != null)
          {
            if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(
                faultElt.getQName(), "setName")))
            {
              //make the fault by reflection
              try
              {
                java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap
                    .get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "setName"));
                java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                java.lang.Exception ex = (java.lang.Exception)constructor.newInstance(f.getMessage());
                //message class
                java.lang.String messageClassName = (java.lang.String)faultMessageMap
                    .get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "setName"));
                java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                    new java.lang.Class[] { messageClass });
                m.invoke(ex, new java.lang.Object[] { messageObject });

                callback.receiveErrorsetName(new java.rmi.RemoteException(ex.getMessage(), ex));
              }
              catch (java.lang.ClassCastException e)
              {
                // we cannot intantiate the class - throw the original Axis fault
                callback.receiveErrorsetName(f);
              }
              catch (java.lang.ClassNotFoundException e)
              {
                // we cannot intantiate the class - throw the original Axis fault
                callback.receiveErrorsetName(f);
              }
              catch (java.lang.NoSuchMethodException e)
              {
                // we cannot intantiate the class - throw the original Axis fault
                callback.receiveErrorsetName(f);
              }
              catch (java.lang.reflect.InvocationTargetException e)
              {
                // we cannot intantiate the class - throw the original Axis fault
                callback.receiveErrorsetName(f);
              }
              catch (java.lang.IllegalAccessException e)
              {
                // we cannot intantiate the class - throw the original Axis fault
                callback.receiveErrorsetName(f);
              }
              catch (java.lang.InstantiationException e)
              {
                // we cannot intantiate the class - throw the original Axis fault
                callback.receiveErrorsetName(f);
              }
              catch (org.apache.axis2.AxisFault e)
              {
                // we cannot intantiate the class - throw the original Axis fault
                callback.receiveErrorsetName(f);
              }
            }
            else
            {
              callback.receiveErrorsetName(f);
            }
          }
          else
          {
            callback.receiveErrorsetName(f);
          }
        }
        else
        {
          callback.receiveErrorsetName(error);
        }
      }

      public void onFault(org.apache.axis2.context.MessageContext faultContext)
      {
        org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils
            .getInboundFaultFromMessageContext(faultContext);
        onError(fault);
      }

      public void onComplete()
      {
        try
        {
          _messageContext.getTransportOut().getSender().cleanup(_messageContext);
        }
        catch (org.apache.axis2.AxisFault axisFault)
        {
          callback.receiveErrorsetName(axisFault);
        }
      }
    });

    org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
    if (_operations[0].getMessageReceiver() == null && _operationClient.getOptions().isUseSeparateListener())
    {
      _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
      _operations[0].setMessageReceiver(_callbackReceiver);
    }

    //execute the operation client
    _operationClient.execute(false);

  }

  /**
   * Auto generated method signature
   * 
   * @see com.tieto.ws.hello.HelloService#upload
   * @param upload2
  
   */

  public com.tieto.ws.hello.HelloServiceStub.UploadResponseE upload(

  com.tieto.ws.hello.HelloServiceStub.UploadE upload2)

  throws java.rmi.RemoteException

  {
    org.apache.axis2.context.MessageContext _messageContext = null;
    try
    {
      org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1]
          .getName());
      _operationClient.getOptions().setAction("abc");
      _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

      addPropertyToOperationClient(_operationClient,
          org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");

      // create a message context
      _messageContext = new org.apache.axis2.context.MessageContext();

      // create SOAP envelope with that payload
      org.apache.axiom.soap.SOAPEnvelope env = null;

      env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), upload2,
          optimizeContent(new javax.xml.namespace.QName("http://ws.tieto.com/", "upload")),
          new javax.xml.namespace.QName("http://ws.tieto.com/", "upload"));

      //adding SOAP soap_headers
      _serviceClient.addHeadersToEnvelope(env);
      // set the message context with that soap envelope
      _messageContext.setEnvelope(env);

      // add the message contxt to the operation client
      _operationClient.addMessageContext(_messageContext);

      //execute the operation client
      _operationClient.execute(true);

      org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient
          .getMessageContext(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
      org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

      java.lang.Object object = fromOM(_returnEnv.getBody().getFirstElement(),
          com.tieto.ws.hello.HelloServiceStub.UploadResponseE.class, getEnvelopeNamespaces(_returnEnv));

      return (com.tieto.ws.hello.HelloServiceStub.UploadResponseE)object;

    }
    catch (org.apache.axis2.AxisFault f)
    {

      org.apache.axiom.om.OMElement faultElt = f.getDetail();
      if (faultElt != null)
      {
        if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),
            "upload")))
        {
          //make the fault by reflection
          try
          {
            java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap
                .get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "upload"));
            java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
            java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
            java.lang.Exception ex = (java.lang.Exception)constructor.newInstance(f.getMessage());
            //message class
            java.lang.String messageClassName = (java.lang.String)faultMessageMap
                .get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "upload"));
            java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
            java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
            java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                new java.lang.Class[] { messageClass });
            m.invoke(ex, new java.lang.Object[] { messageObject });

            throw new java.rmi.RemoteException(ex.getMessage(), ex);
          }
          catch (java.lang.ClassCastException e)
          {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          }
          catch (java.lang.ClassNotFoundException e)
          {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          }
          catch (java.lang.NoSuchMethodException e)
          {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          }
          catch (java.lang.reflect.InvocationTargetException e)
          {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          }
          catch (java.lang.IllegalAccessException e)
          {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          }
          catch (java.lang.InstantiationException e)
          {
            // we cannot intantiate the class - throw the original Axis fault
            throw f;
          }
        }
        else
        {
          throw f;
        }
      }
      else
      {
        throw f;
      }
    }
    finally
    {
      if (_messageContext.getTransportOut() != null)
      {
        _messageContext.getTransportOut().getSender().cleanup(_messageContext);
      }
    }
  }

  /**
  * Auto generated method signature for Asynchronous Invocations
  * 
  * @see com.tieto.ws.hello.HelloService#startupload
      * @param upload2
  
  */
  public void startupload(

  com.tieto.ws.hello.HelloServiceStub.UploadE upload2,

  final com.tieto.ws.hello.HelloServiceCallbackHandler callback)

  throws java.rmi.RemoteException
  {

    org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1]
        .getName());
    _operationClient.getOptions().setAction("abc");
    _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

    addPropertyToOperationClient(_operationClient,
        org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");

    // create SOAP envelope with that payload
    org.apache.axiom.soap.SOAPEnvelope env = null;
    final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

    //Style is Doc.

    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), upload2,
        optimizeContent(new javax.xml.namespace.QName("http://ws.tieto.com/", "upload")),
        new javax.xml.namespace.QName("http://ws.tieto.com/", "upload"));

    // adding SOAP soap_headers
    _serviceClient.addHeadersToEnvelope(env);
    // create message context with that soap envelope
    _messageContext.setEnvelope(env);

    // add the message context to the operation client
    _operationClient.addMessageContext(_messageContext);

    _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
      public void onMessage(org.apache.axis2.context.MessageContext resultContext)
      {
        try
        {
          org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

          java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
              com.tieto.ws.hello.HelloServiceStub.UploadResponseE.class, getEnvelopeNamespaces(resultEnv));
          callback.receiveResultupload((com.tieto.ws.hello.HelloServiceStub.UploadResponseE)object);

        }
        catch (org.apache.axis2.AxisFault e)
        {
          callback.receiveErrorupload(e);
        }
      }

      public void onError(java.lang.Exception error)
      {
        if (error instanceof org.apache.axis2.AxisFault)
        {
          org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault)error;
          org.apache.axiom.om.OMElement faultElt = f.getDetail();
          if (faultElt != null)
          {
            if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(
                faultElt.getQName(), "upload")))
            {
              //make the fault by reflection
              try
              {
                java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap
                    .get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "upload"));
                java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                java.lang.Exception ex = (java.lang.Exception)constructor.newInstance(f.getMessage());
                //message class
                java.lang.String messageClassName = (java.lang.String)faultMessageMap
                    .get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(), "upload"));
                java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                java.lang.Object messageObject = fromOM(faultElt, messageClass, null);
                java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                    new java.lang.Class[] { messageClass });
                m.invoke(ex, new java.lang.Object[] { messageObject });

                callback.receiveErrorupload(new java.rmi.RemoteException(ex.getMessage(), ex));
              }
              catch (java.lang.ClassCastException e)
              {
                // we cannot intantiate the class - throw the original Axis fault
                callback.receiveErrorupload(f);
              }
              catch (java.lang.ClassNotFoundException e)
              {
                // we cannot intantiate the class - throw the original Axis fault
                callback.receiveErrorupload(f);
              }
              catch (java.lang.NoSuchMethodException e)
              {
                // we cannot intantiate the class - throw the original Axis fault
                callback.receiveErrorupload(f);
              }
              catch (java.lang.reflect.InvocationTargetException e)
              {
                // we cannot intantiate the class - throw the original Axis fault
                callback.receiveErrorupload(f);
              }
              catch (java.lang.IllegalAccessException e)
              {
                // we cannot intantiate the class - throw the original Axis fault
                callback.receiveErrorupload(f);
              }
              catch (java.lang.InstantiationException e)
              {
                // we cannot intantiate the class - throw the original Axis fault
                callback.receiveErrorupload(f);
              }
              catch (org.apache.axis2.AxisFault e)
              {
                // we cannot intantiate the class - throw the original Axis fault
                callback.receiveErrorupload(f);
              }
            }
            else
            {
              callback.receiveErrorupload(f);
            }
          }
          else
          {
            callback.receiveErrorupload(f);
          }
        }
        else
        {
          callback.receiveErrorupload(error);
        }
      }

      public void onFault(org.apache.axis2.context.MessageContext faultContext)
      {
        org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils
            .getInboundFaultFromMessageContext(faultContext);
        onError(fault);
      }

      public void onComplete()
      {
        try
        {
          _messageContext.getTransportOut().getSender().cleanup(_messageContext);
        }
        catch (org.apache.axis2.AxisFault axisFault)
        {
          callback.receiveErrorupload(axisFault);
        }
      }
    });

    org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
    if (_operations[1].getMessageReceiver() == null && _operationClient.getOptions().isUseSeparateListener())
    {
      _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
      _operations[1].setMessageReceiver(_callbackReceiver);
    }

    //execute the operation client
    _operationClient.execute(false);

  }

  /**
   *  A utility method that copies the namepaces from the SOAPEnvelope
   */
  private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env)
  {
    java.util.Map returnMap = new java.util.HashMap();
    java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
    while (namespaceIterator.hasNext())
    {
      org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace)namespaceIterator.next();
      returnMap.put(ns.getPrefix(), ns.getNamespaceURI());
    }
    return returnMap;
  }

  private javax.xml.namespace.QName[] opNameArray = null;

  private boolean optimizeContent(javax.xml.namespace.QName opName)
  {

    if (opNameArray == null)
    {
      return false;
    }
    for (int i = 0; i < opNameArray.length; i++)
    {
      if (opName.equals(opNameArray[i]))
      {
        return true;
      }
    }
    return false;
  }

  //http://10.80.41.70:8080/hello
  public static class UploadResponse
      implements org.apache.axis2.databinding.ADBBean
  {
    /* This type was generated from the piece of schema that had
            name = uploadResponse
            Namespace URI = http://ws.tieto.com/
            Namespace Prefix = ns1
            */

    /**
    * field for _return
    */

    protected java.lang.String local_return;

    /*  This tracker boolean wil be used to detect whether the user called the set method
    *   for this attribute. It will be used to determine whether to include this field
    *   in the serialized XML
    */
    protected boolean          local_returnTracker = false;

    public boolean is_returnSpecified()
    {
      return local_returnTracker;
    }

    /**
    * Auto generated getter method
    * @return java.lang.String
    */
    public java.lang.String get_return()
    {
      return local_return;
    }

    /**
       * Auto generated setter method
       * @param param _return
       */
    public void set_return(java.lang.String param)
    {
      local_returnTracker = param != null;

      this.local_return = param;

    }

    /**
    *
    * @param parentQName
    * @param factory
    * @return org.apache.axiom.om.OMElement
    */
    public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
        final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException
    {

      org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
          parentQName);
      return factory.createOMElement(dataSource, parentQName);

    }

    public void serialize(final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException,
        org.apache.axis2.databinding.ADBException
    {
      serialize(parentQName, xmlWriter, false);
    }

    public void serialize(final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException
    {

      java.lang.String prefix = null;
      java.lang.String namespace = null;

      prefix = parentQName.getPrefix();
      namespace = parentQName.getNamespaceURI();
      writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

      if (serializeType)
      {

        java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://ws.tieto.com/");
        if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0))
        {
          writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix
              + ":uploadResponse", xmlWriter);
        }
        else
        {
          writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "uploadResponse",
              xmlWriter);
        }

      }
      if (local_returnTracker)
      {
        namespace = "";
        writeStartElement(null, namespace, "return", xmlWriter);

        if (local_return == null)
        {
          // write the nil attribute

          throw new org.apache.axis2.databinding.ADBException("return cannot be null!!");

        }
        else
        {

          xmlWriter.writeCharacters(local_return);

        }

        xmlWriter.writeEndElement();
      }
      xmlWriter.writeEndElement();

    }

    private static java.lang.String generatePrefix(java.lang.String namespace)
    {
      if (namespace.equals("http://ws.tieto.com/"))
      {
        return "ns1";
      }
      return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    /**
     * Utility method to write an element start tag.
     */
    private void writeStartElement(java.lang.String prefix, java.lang.String namespace,
        java.lang.String localPart, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null)
      {
        xmlWriter.writeStartElement(namespace, localPart);
      }
      else
      {
        if (namespace.length() == 0)
        {
          prefix = "";
        }
        else if (prefix == null)
        {
          prefix = generatePrefix(namespace);
        }

        xmlWriter.writeStartElement(prefix, localPart, namespace);
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
    }

    /**
     * Util method to write an attribute with the ns prefix
     */
    private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
        java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {
      if (xmlWriter.getPrefix(namespace) == null)
      {
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      xmlWriter.writeAttribute(namespace, attName, attValue);
    }

    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeAttribute(java.lang.String namespace, java.lang.String attName,
        java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {
      if (namespace.equals(""))
      {
        xmlWriter.writeAttribute(attName, attValue);
      }
      else
      {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(namespace, attName, attValue);
      }
    }

    /**
      * Util method to write an attribute without the ns prefix
      */
    private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
        javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {

      java.lang.String attributeNamespace = qname.getNamespaceURI();
      java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
      if (attributePrefix == null)
      {
        attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
      }
      java.lang.String attributeValue;
      if (attributePrefix.trim().length() > 0)
      {
        attributeValue = attributePrefix + ":" + qname.getLocalPart();
      }
      else
      {
        attributeValue = qname.getLocalPart();
      }

      if (namespace.equals(""))
      {
        xmlWriter.writeAttribute(attName, attributeValue);
      }
      else
      {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(namespace, attName, attributeValue);
      }
    }

    /**
     *  method to handle Qnames
     */

    private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {
      java.lang.String namespaceURI = qname.getNamespaceURI();
      if (namespaceURI != null)
      {
        java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
        if (prefix == null)
        {
          prefix = generatePrefix(namespaceURI);
          xmlWriter.writeNamespace(prefix, namespaceURI);
          xmlWriter.setPrefix(prefix, namespaceURI);
        }

        if (prefix.trim().length() > 0)
        {
          xmlWriter.writeCharacters(prefix + ":"
              + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        }
        else
        {
          // i.e this is the default namespace
          xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        }

      }
      else
      {
        xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
      }
    }

    private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {

      if (qnames != null)
      {
        // we have to store this data until last moment since it is not possible to write any
        // namespace data after writing the charactor data
        java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
        java.lang.String namespaceURI = null;
        java.lang.String prefix = null;

        for (int i = 0; i < qnames.length; i++)
        {
          if (i > 0)
          {
            stringToWrite.append(" ");
          }
          namespaceURI = qnames[i].getNamespaceURI();
          if (namespaceURI != null)
          {
            prefix = xmlWriter.getPrefix(namespaceURI);
            if ((prefix == null) || (prefix.length() == 0))
            {
              prefix = generatePrefix(namespaceURI);
              xmlWriter.writeNamespace(prefix, namespaceURI);
              xmlWriter.setPrefix(prefix, namespaceURI);
            }

            if (prefix.trim().length() > 0)
            {
              stringToWrite.append(prefix).append(":")
                  .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
            }
            else
            {
              stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
                  .convertToString(qnames[i]));
            }
          }
          else
          {
            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
          }
        }
        xmlWriter.writeCharacters(stringToWrite.toString());
      }

    }

    /**
     * Register a namespace prefix
     */
    private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
        java.lang.String namespace) throws javax.xml.stream.XMLStreamException
    {
      java.lang.String prefix = xmlWriter.getPrefix(namespace);
      if (prefix == null)
      {
        prefix = generatePrefix(namespace);
        javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
        while (true)
        {
          java.lang.String uri = nsContext.getNamespaceURI(prefix);
          if (uri == null || uri.length() == 0)
          {
            break;
          }
          prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      return prefix;
    }

    /**
    * databinding method to get an XML representation of this object
    *
    */
    public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
        throws org.apache.axis2.databinding.ADBException
    {

      java.util.ArrayList elementList = new java.util.ArrayList();
      java.util.ArrayList attribList = new java.util.ArrayList();

      if (local_returnTracker)
      {
        elementList.add(new javax.xml.namespace.QName("", "return"));

        if (local_return != null)
        {
          elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(local_return));
        }
        else
        {
          throw new org.apache.axis2.databinding.ADBException("return cannot be null!!");
        }
      }

      return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
          elementList.toArray(), attribList.toArray());

    }

    /**
     *  Factory class that keeps the parse method
     */
    public static class Factory
    {

      /**
      * static method to create the object
      * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
      *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
      * Postcondition: If this object is an element, the reader is positioned at its end element
      *                If this object is a complex type, the reader is positioned at the end element of its outer element
      */
      public static UploadResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception
      {
        UploadResponse object = new UploadResponse();

        int event;
        java.lang.String nillableValue = null;
        java.lang.String prefix = "";
        java.lang.String namespaceuri = "";
        try
        {

          while (!reader.isStartElement() && !reader.isEndElement())
            reader.next();

          if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null)
          {
            java.lang.String fullTypeName = reader.getAttributeValue(
                "http://www.w3.org/2001/XMLSchema-instance", "type");
            if (fullTypeName != null)
            {
              java.lang.String nsPrefix = null;
              if (fullTypeName.indexOf(":") > -1)
              {
                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
              }
              nsPrefix = nsPrefix == null ? "" : nsPrefix;

              java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

              if (!"uploadResponse".equals(type))
              {
                //find namespace for the prefix
                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                return (UploadResponse)ExtensionMapper.getTypeObject(nsUri, type, reader);
              }

            }

          }

          // Note all attributes that were handled. Used to differ normal attributes
          // from anyAttributes.
          java.util.Vector handledAttributes = new java.util.Vector();

          reader.next();

          while (!reader.isStartElement() && !reader.isEndElement())
            reader.next();

          if (reader.isStartElement() && new javax.xml.namespace.QName("", "return").equals(reader.getName()))
          {

            nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
            if ("true".equals(nillableValue) || "1".equals(nillableValue))
            {
              throw new org.apache.axis2.databinding.ADBException("The element: " + "return"
                  + "  cannot be null");
            }

            java.lang.String content = reader.getElementText();

            object.set_return(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

            reader.next();

          } // End of if for expected property start element

          else
          {

          }

          while (!reader.isStartElement() && !reader.isEndElement())
            reader.next();

          if (reader.isStartElement())
            // A start element we are not expecting indicates a trailing invalid property
            throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());

        }
        catch (javax.xml.stream.XMLStreamException e)
        {
          throw new java.lang.Exception(e);
        }

        return object;
      }

    }//end of factory class

  }

  public static class UploadResponseE
      implements org.apache.axis2.databinding.ADBBean
  {

    public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                                                               "http://ws.tieto.com/", "uploadResponse",
                                                               "ns1");

    /**
    * field for UploadResponse
    */

    protected UploadResponse                      localUploadResponse;

    /**
    * Auto generated getter method
    * @return UploadResponse
    */
    public UploadResponse getUploadResponse()
    {
      return localUploadResponse;
    }

    /**
       * Auto generated setter method
       * @param param UploadResponse
       */
    public void setUploadResponse(UploadResponse param)
    {

      this.localUploadResponse = param;

    }

    /**
    *
    * @param parentQName
    * @param factory
    * @return org.apache.axiom.om.OMElement
    */
    public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
        final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException
    {

      org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
          MY_QNAME);
      return factory.createOMElement(dataSource, MY_QNAME);

    }

    public void serialize(final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException,
        org.apache.axis2.databinding.ADBException
    {
      serialize(parentQName, xmlWriter, false);
    }

    public void serialize(final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException
    {

      //We can safely assume an element has only one type associated with it

      if (localUploadResponse == null)
      {
        throw new org.apache.axis2.databinding.ADBException("uploadResponse cannot be null!");
      }
      localUploadResponse.serialize(MY_QNAME, xmlWriter);

    }

    private static java.lang.String generatePrefix(java.lang.String namespace)
    {
      if (namespace.equals("http://ws.tieto.com/"))
      {
        return "ns1";
      }
      return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    /**
     * Utility method to write an element start tag.
     */
    private void writeStartElement(java.lang.String prefix, java.lang.String namespace,
        java.lang.String localPart, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null)
      {
        xmlWriter.writeStartElement(namespace, localPart);
      }
      else
      {
        if (namespace.length() == 0)
        {
          prefix = "";
        }
        else if (prefix == null)
        {
          prefix = generatePrefix(namespace);
        }

        xmlWriter.writeStartElement(prefix, localPart, namespace);
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
    }

    /**
     * Util method to write an attribute with the ns prefix
     */
    private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
        java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {
      if (xmlWriter.getPrefix(namespace) == null)
      {
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      xmlWriter.writeAttribute(namespace, attName, attValue);
    }

    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeAttribute(java.lang.String namespace, java.lang.String attName,
        java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {
      if (namespace.equals(""))
      {
        xmlWriter.writeAttribute(attName, attValue);
      }
      else
      {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(namespace, attName, attValue);
      }
    }

    /**
      * Util method to write an attribute without the ns prefix
      */
    private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
        javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {

      java.lang.String attributeNamespace = qname.getNamespaceURI();
      java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
      if (attributePrefix == null)
      {
        attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
      }
      java.lang.String attributeValue;
      if (attributePrefix.trim().length() > 0)
      {
        attributeValue = attributePrefix + ":" + qname.getLocalPart();
      }
      else
      {
        attributeValue = qname.getLocalPart();
      }

      if (namespace.equals(""))
      {
        xmlWriter.writeAttribute(attName, attributeValue);
      }
      else
      {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(namespace, attName, attributeValue);
      }
    }

    /**
     *  method to handle Qnames
     */

    private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {
      java.lang.String namespaceURI = qname.getNamespaceURI();
      if (namespaceURI != null)
      {
        java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
        if (prefix == null)
        {
          prefix = generatePrefix(namespaceURI);
          xmlWriter.writeNamespace(prefix, namespaceURI);
          xmlWriter.setPrefix(prefix, namespaceURI);
        }

        if (prefix.trim().length() > 0)
        {
          xmlWriter.writeCharacters(prefix + ":"
              + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        }
        else
        {
          // i.e this is the default namespace
          xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        }

      }
      else
      {
        xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
      }
    }

    private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {

      if (qnames != null)
      {
        // we have to store this data until last moment since it is not possible to write any
        // namespace data after writing the charactor data
        java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
        java.lang.String namespaceURI = null;
        java.lang.String prefix = null;

        for (int i = 0; i < qnames.length; i++)
        {
          if (i > 0)
          {
            stringToWrite.append(" ");
          }
          namespaceURI = qnames[i].getNamespaceURI();
          if (namespaceURI != null)
          {
            prefix = xmlWriter.getPrefix(namespaceURI);
            if ((prefix == null) || (prefix.length() == 0))
            {
              prefix = generatePrefix(namespaceURI);
              xmlWriter.writeNamespace(prefix, namespaceURI);
              xmlWriter.setPrefix(prefix, namespaceURI);
            }

            if (prefix.trim().length() > 0)
            {
              stringToWrite.append(prefix).append(":")
                  .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
            }
            else
            {
              stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
                  .convertToString(qnames[i]));
            }
          }
          else
          {
            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
          }
        }
        xmlWriter.writeCharacters(stringToWrite.toString());
      }

    }

    /**
     * Register a namespace prefix
     */
    private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
        java.lang.String namespace) throws javax.xml.stream.XMLStreamException
    {
      java.lang.String prefix = xmlWriter.getPrefix(namespace);
      if (prefix == null)
      {
        prefix = generatePrefix(namespace);
        javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
        while (true)
        {
          java.lang.String uri = nsContext.getNamespaceURI(prefix);
          if (uri == null || uri.length() == 0)
          {
            break;
          }
          prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      return prefix;
    }

    /**
    * databinding method to get an XML representation of this object
    *
    */
    public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
        throws org.apache.axis2.databinding.ADBException
    {

      //We can safely assume an element has only one type associated with it
      return localUploadResponse.getPullParser(MY_QNAME);

    }

    /**
     *  Factory class that keeps the parse method
     */
    public static class Factory
    {

      /**
      * static method to create the object
      * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
      *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
      * Postcondition: If this object is an element, the reader is positioned at its end element
      *                If this object is a complex type, the reader is positioned at the end element of its outer element
      */
      public static UploadResponseE parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception
      {
        UploadResponseE object = new UploadResponseE();

        int event;
        java.lang.String nillableValue = null;
        java.lang.String prefix = "";
        java.lang.String namespaceuri = "";
        try
        {

          while (!reader.isStartElement() && !reader.isEndElement())
            reader.next();

          // Note all attributes that were handled. Used to differ normal attributes
          // from anyAttributes.
          java.util.Vector handledAttributes = new java.util.Vector();

          while (!reader.isEndElement())
          {
            if (reader.isStartElement())
            {

              if (reader.isStartElement()
                  && new javax.xml.namespace.QName("http://ws.tieto.com/", "uploadResponse").equals(reader
                      .getName()))
              {

                object.setUploadResponse(UploadResponse.Factory.parse(reader));

              } // End of if for expected property start element

              else
              {
                // A start element we are not expecting indicates an invalid parameter was passed
                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement "
                    + reader.getName());
              }

            }
            else
            {
              reader.next();
            }
          } // end of while loop

        }
        catch (javax.xml.stream.XMLStreamException e)
        {
          throw new java.lang.Exception(e);
        }

        return object;
      }

    }//end of factory class

  }

  public static class SetNameResponseE
      implements org.apache.axis2.databinding.ADBBean
  {

    public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                                                               "http://ws.tieto.com/", "setNameResponse",
                                                               "ns1");

    /**
    * field for SetNameResponse
    */

    protected SetNameResponse                     localSetNameResponse;

    /**
    * Auto generated getter method
    * @return SetNameResponse
    */
    public SetNameResponse getSetNameResponse()
    {
      return localSetNameResponse;
    }

    /**
       * Auto generated setter method
       * @param param SetNameResponse
       */
    public void setSetNameResponse(SetNameResponse param)
    {

      this.localSetNameResponse = param;

    }

    /**
    *
    * @param parentQName
    * @param factory
    * @return org.apache.axiom.om.OMElement
    */
    public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
        final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException
    {

      org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
          MY_QNAME);
      return factory.createOMElement(dataSource, MY_QNAME);

    }

    public void serialize(final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException,
        org.apache.axis2.databinding.ADBException
    {
      serialize(parentQName, xmlWriter, false);
    }

    public void serialize(final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException
    {

      //We can safely assume an element has only one type associated with it

      if (localSetNameResponse == null)
      {
        throw new org.apache.axis2.databinding.ADBException("setNameResponse cannot be null!");
      }
      localSetNameResponse.serialize(MY_QNAME, xmlWriter);

    }

    private static java.lang.String generatePrefix(java.lang.String namespace)
    {
      if (namespace.equals("http://ws.tieto.com/"))
      {
        return "ns1";
      }
      return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    /**
     * Utility method to write an element start tag.
     */
    private void writeStartElement(java.lang.String prefix, java.lang.String namespace,
        java.lang.String localPart, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null)
      {
        xmlWriter.writeStartElement(namespace, localPart);
      }
      else
      {
        if (namespace.length() == 0)
        {
          prefix = "";
        }
        else if (prefix == null)
        {
          prefix = generatePrefix(namespace);
        }

        xmlWriter.writeStartElement(prefix, localPart, namespace);
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
    }

    /**
     * Util method to write an attribute with the ns prefix
     */
    private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
        java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {
      if (xmlWriter.getPrefix(namespace) == null)
      {
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      xmlWriter.writeAttribute(namespace, attName, attValue);
    }

    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeAttribute(java.lang.String namespace, java.lang.String attName,
        java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {
      if (namespace.equals(""))
      {
        xmlWriter.writeAttribute(attName, attValue);
      }
      else
      {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(namespace, attName, attValue);
      }
    }

    /**
      * Util method to write an attribute without the ns prefix
      */
    private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
        javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {

      java.lang.String attributeNamespace = qname.getNamespaceURI();
      java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
      if (attributePrefix == null)
      {
        attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
      }
      java.lang.String attributeValue;
      if (attributePrefix.trim().length() > 0)
      {
        attributeValue = attributePrefix + ":" + qname.getLocalPart();
      }
      else
      {
        attributeValue = qname.getLocalPart();
      }

      if (namespace.equals(""))
      {
        xmlWriter.writeAttribute(attName, attributeValue);
      }
      else
      {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(namespace, attName, attributeValue);
      }
    }

    /**
     *  method to handle Qnames
     */

    private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {
      java.lang.String namespaceURI = qname.getNamespaceURI();
      if (namespaceURI != null)
      {
        java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
        if (prefix == null)
        {
          prefix = generatePrefix(namespaceURI);
          xmlWriter.writeNamespace(prefix, namespaceURI);
          xmlWriter.setPrefix(prefix, namespaceURI);
        }

        if (prefix.trim().length() > 0)
        {
          xmlWriter.writeCharacters(prefix + ":"
              + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        }
        else
        {
          // i.e this is the default namespace
          xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        }

      }
      else
      {
        xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
      }
    }

    private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {

      if (qnames != null)
      {
        // we have to store this data until last moment since it is not possible to write any
        // namespace data after writing the charactor data
        java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
        java.lang.String namespaceURI = null;
        java.lang.String prefix = null;

        for (int i = 0; i < qnames.length; i++)
        {
          if (i > 0)
          {
            stringToWrite.append(" ");
          }
          namespaceURI = qnames[i].getNamespaceURI();
          if (namespaceURI != null)
          {
            prefix = xmlWriter.getPrefix(namespaceURI);
            if ((prefix == null) || (prefix.length() == 0))
            {
              prefix = generatePrefix(namespaceURI);
              xmlWriter.writeNamespace(prefix, namespaceURI);
              xmlWriter.setPrefix(prefix, namespaceURI);
            }

            if (prefix.trim().length() > 0)
            {
              stringToWrite.append(prefix).append(":")
                  .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
            }
            else
            {
              stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
                  .convertToString(qnames[i]));
            }
          }
          else
          {
            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
          }
        }
        xmlWriter.writeCharacters(stringToWrite.toString());
      }

    }

    /**
     * Register a namespace prefix
     */
    private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
        java.lang.String namespace) throws javax.xml.stream.XMLStreamException
    {
      java.lang.String prefix = xmlWriter.getPrefix(namespace);
      if (prefix == null)
      {
        prefix = generatePrefix(namespace);
        javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
        while (true)
        {
          java.lang.String uri = nsContext.getNamespaceURI(prefix);
          if (uri == null || uri.length() == 0)
          {
            break;
          }
          prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      return prefix;
    }

    /**
    * databinding method to get an XML representation of this object
    *
    */
    public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
        throws org.apache.axis2.databinding.ADBException
    {

      //We can safely assume an element has only one type associated with it
      return localSetNameResponse.getPullParser(MY_QNAME);

    }

    /**
     *  Factory class that keeps the parse method
     */
    public static class Factory
    {

      /**
      * static method to create the object
      * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
      *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
      * Postcondition: If this object is an element, the reader is positioned at its end element
      *                If this object is a complex type, the reader is positioned at the end element of its outer element
      */
      public static SetNameResponseE parse(javax.xml.stream.XMLStreamReader reader)
          throws java.lang.Exception
      {
        SetNameResponseE object = new SetNameResponseE();

        int event;
        java.lang.String nillableValue = null;
        java.lang.String prefix = "";
        java.lang.String namespaceuri = "";
        try
        {

          while (!reader.isStartElement() && !reader.isEndElement())
            reader.next();

          // Note all attributes that were handled. Used to differ normal attributes
          // from anyAttributes.
          java.util.Vector handledAttributes = new java.util.Vector();

          while (!reader.isEndElement())
          {
            if (reader.isStartElement())
            {

              if (reader.isStartElement()
                  && new javax.xml.namespace.QName("http://ws.tieto.com/", "setNameResponse").equals(reader
                      .getName()))
              {

                object.setSetNameResponse(SetNameResponse.Factory.parse(reader));

              } // End of if for expected property start element

              else
              {
                // A start element we are not expecting indicates an invalid parameter was passed
                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement "
                    + reader.getName());
              }

            }
            else
            {
              reader.next();
            }
          } // end of while loop

        }
        catch (javax.xml.stream.XMLStreamException e)
        {
          throw new java.lang.Exception(e);
        }

        return object;
      }

    }//end of factory class

  }

  public static class UploadE
      implements org.apache.axis2.databinding.ADBBean
  {

    public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                                                               "http://ws.tieto.com/", "upload", "ns1");

    /**
    * field for Upload
    */

    protected Upload                              localUpload;

    /**
    * Auto generated getter method
    * @return Upload
    */
    public Upload getUpload()
    {
      return localUpload;
    }

    /**
       * Auto generated setter method
       * @param param Upload
       */
    public void setUpload(Upload param)
    {

      this.localUpload = param;

    }

    /**
    *
    * @param parentQName
    * @param factory
    * @return org.apache.axiom.om.OMElement
    */
    public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
        final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException
    {

      org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
          MY_QNAME);
      return factory.createOMElement(dataSource, MY_QNAME);

    }

    public void serialize(final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException,
        org.apache.axis2.databinding.ADBException
    {
      serialize(parentQName, xmlWriter, false);
    }

    public void serialize(final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException
    {

      //We can safely assume an element has only one type associated with it

      if (localUpload == null)
      {
        throw new org.apache.axis2.databinding.ADBException("upload cannot be null!");
      }
      localUpload.serialize(MY_QNAME, xmlWriter);

    }

    private static java.lang.String generatePrefix(java.lang.String namespace)
    {
      if (namespace.equals("http://ws.tieto.com/"))
      {
        return "ns1";
      }
      return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    /**
     * Utility method to write an element start tag.
     */
    private void writeStartElement(java.lang.String prefix, java.lang.String namespace,
        java.lang.String localPart, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null)
      {
        xmlWriter.writeStartElement(namespace, localPart);
      }
      else
      {
        if (namespace.length() == 0)
        {
          prefix = "";
        }
        else if (prefix == null)
        {
          prefix = generatePrefix(namespace);
        }

        xmlWriter.writeStartElement(prefix, localPart, namespace);
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
    }

    /**
     * Util method to write an attribute with the ns prefix
     */
    private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
        java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {
      if (xmlWriter.getPrefix(namespace) == null)
      {
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      xmlWriter.writeAttribute(namespace, attName, attValue);
    }

    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeAttribute(java.lang.String namespace, java.lang.String attName,
        java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {
      if (namespace.equals(""))
      {
        xmlWriter.writeAttribute(attName, attValue);
      }
      else
      {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(namespace, attName, attValue);
      }
    }

    /**
      * Util method to write an attribute without the ns prefix
      */
    private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
        javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {

      java.lang.String attributeNamespace = qname.getNamespaceURI();
      java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
      if (attributePrefix == null)
      {
        attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
      }
      java.lang.String attributeValue;
      if (attributePrefix.trim().length() > 0)
      {
        attributeValue = attributePrefix + ":" + qname.getLocalPart();
      }
      else
      {
        attributeValue = qname.getLocalPart();
      }

      if (namespace.equals(""))
      {
        xmlWriter.writeAttribute(attName, attributeValue);
      }
      else
      {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(namespace, attName, attributeValue);
      }
    }

    /**
     *  method to handle Qnames
     */

    private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {
      java.lang.String namespaceURI = qname.getNamespaceURI();
      if (namespaceURI != null)
      {
        java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
        if (prefix == null)
        {
          prefix = generatePrefix(namespaceURI);
          xmlWriter.writeNamespace(prefix, namespaceURI);
          xmlWriter.setPrefix(prefix, namespaceURI);
        }

        if (prefix.trim().length() > 0)
        {
          xmlWriter.writeCharacters(prefix + ":"
              + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        }
        else
        {
          // i.e this is the default namespace
          xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        }

      }
      else
      {
        xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
      }
    }

    private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {

      if (qnames != null)
      {
        // we have to store this data until last moment since it is not possible to write any
        // namespace data after writing the charactor data
        java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
        java.lang.String namespaceURI = null;
        java.lang.String prefix = null;

        for (int i = 0; i < qnames.length; i++)
        {
          if (i > 0)
          {
            stringToWrite.append(" ");
          }
          namespaceURI = qnames[i].getNamespaceURI();
          if (namespaceURI != null)
          {
            prefix = xmlWriter.getPrefix(namespaceURI);
            if ((prefix == null) || (prefix.length() == 0))
            {
              prefix = generatePrefix(namespaceURI);
              xmlWriter.writeNamespace(prefix, namespaceURI);
              xmlWriter.setPrefix(prefix, namespaceURI);
            }

            if (prefix.trim().length() > 0)
            {
              stringToWrite.append(prefix).append(":")
                  .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
            }
            else
            {
              stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
                  .convertToString(qnames[i]));
            }
          }
          else
          {
            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
          }
        }
        xmlWriter.writeCharacters(stringToWrite.toString());
      }

    }

    /**
     * Register a namespace prefix
     */
    private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
        java.lang.String namespace) throws javax.xml.stream.XMLStreamException
    {
      java.lang.String prefix = xmlWriter.getPrefix(namespace);
      if (prefix == null)
      {
        prefix = generatePrefix(namespace);
        javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
        while (true)
        {
          java.lang.String uri = nsContext.getNamespaceURI(prefix);
          if (uri == null || uri.length() == 0)
          {
            break;
          }
          prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      return prefix;
    }

    /**
    * databinding method to get an XML representation of this object
    *
    */
    public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
        throws org.apache.axis2.databinding.ADBException
    {

      //We can safely assume an element has only one type associated with it
      return localUpload.getPullParser(MY_QNAME);

    }

    /**
     *  Factory class that keeps the parse method
     */
    public static class Factory
    {

      /**
      * static method to create the object
      * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
      *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
      * Postcondition: If this object is an element, the reader is positioned at its end element
      *                If this object is a complex type, the reader is positioned at the end element of its outer element
      */
      public static UploadE parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception
      {
        UploadE object = new UploadE();

        int event;
        java.lang.String nillableValue = null;
        java.lang.String prefix = "";
        java.lang.String namespaceuri = "";
        try
        {

          while (!reader.isStartElement() && !reader.isEndElement())
            reader.next();

          // Note all attributes that were handled. Used to differ normal attributes
          // from anyAttributes.
          java.util.Vector handledAttributes = new java.util.Vector();

          while (!reader.isEndElement())
          {
            if (reader.isStartElement())
            {

              if (reader.isStartElement()
                  && new javax.xml.namespace.QName("http://ws.tieto.com/", "upload").equals(reader.getName()))
              {

                object.setUpload(Upload.Factory.parse(reader));

              } // End of if for expected property start element

              else
              {
                // A start element we are not expecting indicates an invalid parameter was passed
                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement "
                    + reader.getName());
              }

            }
            else
            {
              reader.next();
            }
          } // end of while loop

        }
        catch (javax.xml.stream.XMLStreamException e)
        {
          throw new java.lang.Exception(e);
        }

        return object;
      }

    }//end of factory class

  }

  public static class ExtensionMapper
  {

    public static java.lang.Object getTypeObject(java.lang.String namespaceURI, java.lang.String typeName,
        javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception
    {

      if ("http://ws.tieto.com/".equals(namespaceURI) && "setName".equals(typeName))
      {

        return SetName.Factory.parse(reader);

      }

      if ("http://ws.tieto.com/".equals(namespaceURI) && "setNameResponse".equals(typeName))
      {

        return SetNameResponse.Factory.parse(reader);

      }

      if ("http://ws.tieto.com/".equals(namespaceURI) && "uploadResponse".equals(typeName))
      {

        return UploadResponse.Factory.parse(reader);

      }

      if ("http://ws.tieto.com/".equals(namespaceURI) && "upload".equals(typeName))
      {

        return Upload.Factory.parse(reader);

      }

      throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
    }

  }

  public static class SetName
      implements org.apache.axis2.databinding.ADBBean
  {
    /* This type was generated from the piece of schema that had
            name = setName
            Namespace URI = http://ws.tieto.com/
            Namespace Prefix = ns1
            */

    /**
    * field for Name
    */

    protected java.lang.String localName;

    /*  This tracker boolean wil be used to detect whether the user called the set method
    *   for this attribute. It will be used to determine whether to include this field
    *   in the serialized XML
    */
    protected boolean          localNameTracker = false;

    public boolean isNameSpecified()
    {
      return localNameTracker;
    }

    /**
    * Auto generated getter method
    * @return java.lang.String
    */
    public java.lang.String getName()
    {
      return localName;
    }

    /**
       * Auto generated setter method
       * @param param Name
       */
    public void setName(java.lang.String param)
    {
      localNameTracker = param != null;

      this.localName = param;

    }

    /**
    *
    * @param parentQName
    * @param factory
    * @return org.apache.axiom.om.OMElement
    */
    public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
        final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException
    {

      org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
          parentQName);
      return factory.createOMElement(dataSource, parentQName);

    }

    public void serialize(final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException,
        org.apache.axis2.databinding.ADBException
    {
      serialize(parentQName, xmlWriter, false);
    }

    public void serialize(final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException
    {

      java.lang.String prefix = null;
      java.lang.String namespace = null;

      prefix = parentQName.getPrefix();
      namespace = parentQName.getNamespaceURI();
      writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

      if (serializeType)
      {

        java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://ws.tieto.com/");
        if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0))
        {
          writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix
              + ":setName", xmlWriter);
        }
        else
        {
          writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "setName", xmlWriter);
        }

      }
      if (localNameTracker)
      {
        namespace = "";
        writeStartElement(null, namespace, "name", xmlWriter);

        if (localName == null)
        {
          // write the nil attribute

          throw new org.apache.axis2.databinding.ADBException("name cannot be null!!");

        }
        else
        {

          xmlWriter.writeCharacters(localName);

        }

        xmlWriter.writeEndElement();
      }
      xmlWriter.writeEndElement();

    }

    private static java.lang.String generatePrefix(java.lang.String namespace)
    {
      if (namespace.equals("http://ws.tieto.com/"))
      {
        return "ns1";
      }
      return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    /**
     * Utility method to write an element start tag.
     */
    private void writeStartElement(java.lang.String prefix, java.lang.String namespace,
        java.lang.String localPart, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null)
      {
        xmlWriter.writeStartElement(namespace, localPart);
      }
      else
      {
        if (namespace.length() == 0)
        {
          prefix = "";
        }
        else if (prefix == null)
        {
          prefix = generatePrefix(namespace);
        }

        xmlWriter.writeStartElement(prefix, localPart, namespace);
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
    }

    /**
     * Util method to write an attribute with the ns prefix
     */
    private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
        java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {
      if (xmlWriter.getPrefix(namespace) == null)
      {
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      xmlWriter.writeAttribute(namespace, attName, attValue);
    }

    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeAttribute(java.lang.String namespace, java.lang.String attName,
        java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {
      if (namespace.equals(""))
      {
        xmlWriter.writeAttribute(attName, attValue);
      }
      else
      {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(namespace, attName, attValue);
      }
    }

    /**
      * Util method to write an attribute without the ns prefix
      */
    private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
        javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {

      java.lang.String attributeNamespace = qname.getNamespaceURI();
      java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
      if (attributePrefix == null)
      {
        attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
      }
      java.lang.String attributeValue;
      if (attributePrefix.trim().length() > 0)
      {
        attributeValue = attributePrefix + ":" + qname.getLocalPart();
      }
      else
      {
        attributeValue = qname.getLocalPart();
      }

      if (namespace.equals(""))
      {
        xmlWriter.writeAttribute(attName, attributeValue);
      }
      else
      {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(namespace, attName, attributeValue);
      }
    }

    /**
     *  method to handle Qnames
     */

    private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {
      java.lang.String namespaceURI = qname.getNamespaceURI();
      if (namespaceURI != null)
      {
        java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
        if (prefix == null)
        {
          prefix = generatePrefix(namespaceURI);
          xmlWriter.writeNamespace(prefix, namespaceURI);
          xmlWriter.setPrefix(prefix, namespaceURI);
        }

        if (prefix.trim().length() > 0)
        {
          xmlWriter.writeCharacters(prefix + ":"
              + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        }
        else
        {
          // i.e this is the default namespace
          xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        }

      }
      else
      {
        xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
      }
    }

    private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {

      if (qnames != null)
      {
        // we have to store this data until last moment since it is not possible to write any
        // namespace data after writing the charactor data
        java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
        java.lang.String namespaceURI = null;
        java.lang.String prefix = null;

        for (int i = 0; i < qnames.length; i++)
        {
          if (i > 0)
          {
            stringToWrite.append(" ");
          }
          namespaceURI = qnames[i].getNamespaceURI();
          if (namespaceURI != null)
          {
            prefix = xmlWriter.getPrefix(namespaceURI);
            if ((prefix == null) || (prefix.length() == 0))
            {
              prefix = generatePrefix(namespaceURI);
              xmlWriter.writeNamespace(prefix, namespaceURI);
              xmlWriter.setPrefix(prefix, namespaceURI);
            }

            if (prefix.trim().length() > 0)
            {
              stringToWrite.append(prefix).append(":")
                  .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
            }
            else
            {
              stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
                  .convertToString(qnames[i]));
            }
          }
          else
          {
            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
          }
        }
        xmlWriter.writeCharacters(stringToWrite.toString());
      }

    }

    /**
     * Register a namespace prefix
     */
    private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
        java.lang.String namespace) throws javax.xml.stream.XMLStreamException
    {
      java.lang.String prefix = xmlWriter.getPrefix(namespace);
      if (prefix == null)
      {
        prefix = generatePrefix(namespace);
        javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
        while (true)
        {
          java.lang.String uri = nsContext.getNamespaceURI(prefix);
          if (uri == null || uri.length() == 0)
          {
            break;
          }
          prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      return prefix;
    }

    /**
    * databinding method to get an XML representation of this object
    *
    */
    public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
        throws org.apache.axis2.databinding.ADBException
    {

      java.util.ArrayList elementList = new java.util.ArrayList();
      java.util.ArrayList attribList = new java.util.ArrayList();

      if (localNameTracker)
      {
        elementList.add(new javax.xml.namespace.QName("", "name"));

        if (localName != null)
        {
          elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localName));
        }
        else
        {
          throw new org.apache.axis2.databinding.ADBException("name cannot be null!!");
        }
      }

      return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
          elementList.toArray(), attribList.toArray());

    }

    /**
     *  Factory class that keeps the parse method
     */
    public static class Factory
    {

      /**
      * static method to create the object
      * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
      *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
      * Postcondition: If this object is an element, the reader is positioned at its end element
      *                If this object is a complex type, the reader is positioned at the end element of its outer element
      */
      public static SetName parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception
      {
        SetName object = new SetName();

        int event;
        java.lang.String nillableValue = null;
        java.lang.String prefix = "";
        java.lang.String namespaceuri = "";
        try
        {

          while (!reader.isStartElement() && !reader.isEndElement())
            reader.next();

          if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null)
          {
            java.lang.String fullTypeName = reader.getAttributeValue(
                "http://www.w3.org/2001/XMLSchema-instance", "type");
            if (fullTypeName != null)
            {
              java.lang.String nsPrefix = null;
              if (fullTypeName.indexOf(":") > -1)
              {
                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
              }
              nsPrefix = nsPrefix == null ? "" : nsPrefix;

              java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

              if (!"setName".equals(type))
              {
                //find namespace for the prefix
                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                return (SetName)ExtensionMapper.getTypeObject(nsUri, type, reader);
              }

            }

          }

          // Note all attributes that were handled. Used to differ normal attributes
          // from anyAttributes.
          java.util.Vector handledAttributes = new java.util.Vector();

          reader.next();

          while (!reader.isStartElement() && !reader.isEndElement())
            reader.next();

          if (reader.isStartElement() && new javax.xml.namespace.QName("", "name").equals(reader.getName()))
          {

            nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
            if ("true".equals(nillableValue) || "1".equals(nillableValue))
            {
              throw new org.apache.axis2.databinding.ADBException("The element: " + "name"
                  + "  cannot be null");
            }

            java.lang.String content = reader.getElementText();

            object.setName(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

            reader.next();

          } // End of if for expected property start element

          else
          {

          }

          while (!reader.isStartElement() && !reader.isEndElement())
            reader.next();

          if (reader.isStartElement())
            // A start element we are not expecting indicates a trailing invalid property
            throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());

        }
        catch (javax.xml.stream.XMLStreamException e)
        {
          throw new java.lang.Exception(e);
        }

        return object;
      }

    }//end of factory class

  }

  public static class SetNameResponse
      implements org.apache.axis2.databinding.ADBBean
  {
    /* This type was generated from the piece of schema that had
            name = setNameResponse
            Namespace URI = http://ws.tieto.com/
            Namespace Prefix = ns1
            */

    /**
    *
    * @param parentQName
    * @param factory
    * @return org.apache.axiom.om.OMElement
    */
    public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
        final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException
    {

      org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
          parentQName);
      return factory.createOMElement(dataSource, parentQName);

    }

    public void serialize(final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException,
        org.apache.axis2.databinding.ADBException
    {
      serialize(parentQName, xmlWriter, false);
    }

    public void serialize(final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException
    {

      java.lang.String prefix = null;
      java.lang.String namespace = null;

      prefix = parentQName.getPrefix();
      namespace = parentQName.getNamespaceURI();
      writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

      if (serializeType)
      {

        java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://ws.tieto.com/");
        if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0))
        {
          writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix
              + ":setNameResponse", xmlWriter);
        }
        else
        {
          writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "setNameResponse",
              xmlWriter);
        }

      }

      xmlWriter.writeEndElement();

    }

    private static java.lang.String generatePrefix(java.lang.String namespace)
    {
      if (namespace.equals("http://ws.tieto.com/"))
      {
        return "ns1";
      }
      return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    /**
     * Utility method to write an element start tag.
     */
    private void writeStartElement(java.lang.String prefix, java.lang.String namespace,
        java.lang.String localPart, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null)
      {
        xmlWriter.writeStartElement(namespace, localPart);
      }
      else
      {
        if (namespace.length() == 0)
        {
          prefix = "";
        }
        else if (prefix == null)
        {
          prefix = generatePrefix(namespace);
        }

        xmlWriter.writeStartElement(prefix, localPart, namespace);
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
    }

    /**
     * Util method to write an attribute with the ns prefix
     */
    private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
        java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {
      if (xmlWriter.getPrefix(namespace) == null)
      {
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      xmlWriter.writeAttribute(namespace, attName, attValue);
    }

    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeAttribute(java.lang.String namespace, java.lang.String attName,
        java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {
      if (namespace.equals(""))
      {
        xmlWriter.writeAttribute(attName, attValue);
      }
      else
      {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(namespace, attName, attValue);
      }
    }

    /**
      * Util method to write an attribute without the ns prefix
      */
    private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
        javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {

      java.lang.String attributeNamespace = qname.getNamespaceURI();
      java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
      if (attributePrefix == null)
      {
        attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
      }
      java.lang.String attributeValue;
      if (attributePrefix.trim().length() > 0)
      {
        attributeValue = attributePrefix + ":" + qname.getLocalPart();
      }
      else
      {
        attributeValue = qname.getLocalPart();
      }

      if (namespace.equals(""))
      {
        xmlWriter.writeAttribute(attName, attributeValue);
      }
      else
      {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(namespace, attName, attributeValue);
      }
    }

    /**
     *  method to handle Qnames
     */

    private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {
      java.lang.String namespaceURI = qname.getNamespaceURI();
      if (namespaceURI != null)
      {
        java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
        if (prefix == null)
        {
          prefix = generatePrefix(namespaceURI);
          xmlWriter.writeNamespace(prefix, namespaceURI);
          xmlWriter.setPrefix(prefix, namespaceURI);
        }

        if (prefix.trim().length() > 0)
        {
          xmlWriter.writeCharacters(prefix + ":"
              + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        }
        else
        {
          // i.e this is the default namespace
          xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        }

      }
      else
      {
        xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
      }
    }

    private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {

      if (qnames != null)
      {
        // we have to store this data until last moment since it is not possible to write any
        // namespace data after writing the charactor data
        java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
        java.lang.String namespaceURI = null;
        java.lang.String prefix = null;

        for (int i = 0; i < qnames.length; i++)
        {
          if (i > 0)
          {
            stringToWrite.append(" ");
          }
          namespaceURI = qnames[i].getNamespaceURI();
          if (namespaceURI != null)
          {
            prefix = xmlWriter.getPrefix(namespaceURI);
            if ((prefix == null) || (prefix.length() == 0))
            {
              prefix = generatePrefix(namespaceURI);
              xmlWriter.writeNamespace(prefix, namespaceURI);
              xmlWriter.setPrefix(prefix, namespaceURI);
            }

            if (prefix.trim().length() > 0)
            {
              stringToWrite.append(prefix).append(":")
                  .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
            }
            else
            {
              stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
                  .convertToString(qnames[i]));
            }
          }
          else
          {
            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
          }
        }
        xmlWriter.writeCharacters(stringToWrite.toString());
      }

    }

    /**
     * Register a namespace prefix
     */
    private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
        java.lang.String namespace) throws javax.xml.stream.XMLStreamException
    {
      java.lang.String prefix = xmlWriter.getPrefix(namespace);
      if (prefix == null)
      {
        prefix = generatePrefix(namespace);
        javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
        while (true)
        {
          java.lang.String uri = nsContext.getNamespaceURI(prefix);
          if (uri == null || uri.length() == 0)
          {
            break;
          }
          prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      return prefix;
    }

    /**
    * databinding method to get an XML representation of this object
    *
    */
    public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
        throws org.apache.axis2.databinding.ADBException
    {

      java.util.ArrayList elementList = new java.util.ArrayList();
      java.util.ArrayList attribList = new java.util.ArrayList();

      return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
          elementList.toArray(), attribList.toArray());

    }

    /**
     *  Factory class that keeps the parse method
     */
    public static class Factory
    {

      /**
      * static method to create the object
      * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
      *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
      * Postcondition: If this object is an element, the reader is positioned at its end element
      *                If this object is a complex type, the reader is positioned at the end element of its outer element
      */
      public static SetNameResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception
      {
        SetNameResponse object = new SetNameResponse();

        int event;
        java.lang.String nillableValue = null;
        java.lang.String prefix = "";
        java.lang.String namespaceuri = "";
        try
        {

          while (!reader.isStartElement() && !reader.isEndElement())
            reader.next();

          if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null)
          {
            java.lang.String fullTypeName = reader.getAttributeValue(
                "http://www.w3.org/2001/XMLSchema-instance", "type");
            if (fullTypeName != null)
            {
              java.lang.String nsPrefix = null;
              if (fullTypeName.indexOf(":") > -1)
              {
                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
              }
              nsPrefix = nsPrefix == null ? "" : nsPrefix;

              java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

              if (!"setNameResponse".equals(type))
              {
                //find namespace for the prefix
                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                return (SetNameResponse)ExtensionMapper.getTypeObject(nsUri, type, reader);
              }

            }

          }

          // Note all attributes that were handled. Used to differ normal attributes
          // from anyAttributes.
          java.util.Vector handledAttributes = new java.util.Vector();

          reader.next();

          while (!reader.isStartElement() && !reader.isEndElement())
            reader.next();

          if (reader.isStartElement())
            // A start element we are not expecting indicates a trailing invalid property
            throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());

        }
        catch (javax.xml.stream.XMLStreamException e)
        {
          throw new java.lang.Exception(e);
        }

        return object;
      }

    }//end of factory class

  }

  public static class Upload
      implements org.apache.axis2.databinding.ADBBean
  {
    /* This type was generated from the piece of schema that had
            name = upload
            Namespace URI = http://ws.tieto.com/
            Namespace Prefix = ns1
            */

    /**
    * field for FileName
    */

    protected java.lang.String localFileName;

    /*  This tracker boolean wil be used to detect whether the user called the set method
    *   for this attribute. It will be used to determine whether to include this field
    *   in the serialized XML
    */
    protected boolean          localFileNameTracker = false;

    public boolean isFileNameSpecified()
    {
      return localFileNameTracker;
    }

    /**
    * Auto generated getter method
    * @return java.lang.String
    */
    public java.lang.String getFileName()
    {
      return localFileName;
    }

    /**
       * Auto generated setter method
       * @param param FileName
       */
    public void setFileName(java.lang.String param)
    {
      localFileNameTracker = param != null;

      this.localFileName = param;

    }

    /**
    *
    * @param parentQName
    * @param factory
    * @return org.apache.axiom.om.OMElement
    */
    public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
        final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException
    {

      org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
          parentQName);
      return factory.createOMElement(dataSource, parentQName);

    }

    public void serialize(final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException,
        org.apache.axis2.databinding.ADBException
    {
      serialize(parentQName, xmlWriter, false);
    }

    public void serialize(final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException
    {

      java.lang.String prefix = null;
      java.lang.String namespace = null;

      prefix = parentQName.getPrefix();
      namespace = parentQName.getNamespaceURI();
      writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

      if (serializeType)
      {

        java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://ws.tieto.com/");
        if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0))
        {
          writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix
              + ":upload", xmlWriter);
        }
        else
        {
          writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "upload", xmlWriter);
        }

      }
      if (localFileNameTracker)
      {
        namespace = "";
        writeStartElement(null, namespace, "fileName", xmlWriter);

        if (localFileName == null)
        {
          // write the nil attribute

          throw new org.apache.axis2.databinding.ADBException("fileName cannot be null!!");

        }
        else
        {

          xmlWriter.writeCharacters(localFileName);

        }

        xmlWriter.writeEndElement();
      }
      xmlWriter.writeEndElement();

    }

    private static java.lang.String generatePrefix(java.lang.String namespace)
    {
      if (namespace.equals("http://ws.tieto.com/"))
      {
        return "ns1";
      }
      return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    /**
     * Utility method to write an element start tag.
     */
    private void writeStartElement(java.lang.String prefix, java.lang.String namespace,
        java.lang.String localPart, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null)
      {
        xmlWriter.writeStartElement(namespace, localPart);
      }
      else
      {
        if (namespace.length() == 0)
        {
          prefix = "";
        }
        else if (prefix == null)
        {
          prefix = generatePrefix(namespace);
        }

        xmlWriter.writeStartElement(prefix, localPart, namespace);
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
    }

    /**
     * Util method to write an attribute with the ns prefix
     */
    private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
        java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {
      if (xmlWriter.getPrefix(namespace) == null)
      {
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      xmlWriter.writeAttribute(namespace, attName, attValue);
    }

    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeAttribute(java.lang.String namespace, java.lang.String attName,
        java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {
      if (namespace.equals(""))
      {
        xmlWriter.writeAttribute(attName, attValue);
      }
      else
      {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(namespace, attName, attValue);
      }
    }

    /**
      * Util method to write an attribute without the ns prefix
      */
    private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
        javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {

      java.lang.String attributeNamespace = qname.getNamespaceURI();
      java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
      if (attributePrefix == null)
      {
        attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
      }
      java.lang.String attributeValue;
      if (attributePrefix.trim().length() > 0)
      {
        attributeValue = attributePrefix + ":" + qname.getLocalPart();
      }
      else
      {
        attributeValue = qname.getLocalPart();
      }

      if (namespace.equals(""))
      {
        xmlWriter.writeAttribute(attName, attributeValue);
      }
      else
      {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(namespace, attName, attributeValue);
      }
    }

    /**
     *  method to handle Qnames
     */

    private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {
      java.lang.String namespaceURI = qname.getNamespaceURI();
      if (namespaceURI != null)
      {
        java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
        if (prefix == null)
        {
          prefix = generatePrefix(namespaceURI);
          xmlWriter.writeNamespace(prefix, namespaceURI);
          xmlWriter.setPrefix(prefix, namespaceURI);
        }

        if (prefix.trim().length() > 0)
        {
          xmlWriter.writeCharacters(prefix + ":"
              + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        }
        else
        {
          // i.e this is the default namespace
          xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        }

      }
      else
      {
        xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
      }
    }

    private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {

      if (qnames != null)
      {
        // we have to store this data until last moment since it is not possible to write any
        // namespace data after writing the charactor data
        java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
        java.lang.String namespaceURI = null;
        java.lang.String prefix = null;

        for (int i = 0; i < qnames.length; i++)
        {
          if (i > 0)
          {
            stringToWrite.append(" ");
          }
          namespaceURI = qnames[i].getNamespaceURI();
          if (namespaceURI != null)
          {
            prefix = xmlWriter.getPrefix(namespaceURI);
            if ((prefix == null) || (prefix.length() == 0))
            {
              prefix = generatePrefix(namespaceURI);
              xmlWriter.writeNamespace(prefix, namespaceURI);
              xmlWriter.setPrefix(prefix, namespaceURI);
            }

            if (prefix.trim().length() > 0)
            {
              stringToWrite.append(prefix).append(":")
                  .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
            }
            else
            {
              stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
                  .convertToString(qnames[i]));
            }
          }
          else
          {
            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
          }
        }
        xmlWriter.writeCharacters(stringToWrite.toString());
      }

    }

    /**
     * Register a namespace prefix
     */
    private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
        java.lang.String namespace) throws javax.xml.stream.XMLStreamException
    {
      java.lang.String prefix = xmlWriter.getPrefix(namespace);
      if (prefix == null)
      {
        prefix = generatePrefix(namespace);
        javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
        while (true)
        {
          java.lang.String uri = nsContext.getNamespaceURI(prefix);
          if (uri == null || uri.length() == 0)
          {
            break;
          }
          prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      return prefix;
    }

    /**
    * databinding method to get an XML representation of this object
    *
    */
    public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
        throws org.apache.axis2.databinding.ADBException
    {

      java.util.ArrayList elementList = new java.util.ArrayList();
      java.util.ArrayList attribList = new java.util.ArrayList();

      if (localFileNameTracker)
      {
        elementList.add(new javax.xml.namespace.QName("", "fileName"));

        if (localFileName != null)
        {
          elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFileName));
        }
        else
        {
          throw new org.apache.axis2.databinding.ADBException("fileName cannot be null!!");
        }
      }

      return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName,
          elementList.toArray(), attribList.toArray());

    }

    /**
     *  Factory class that keeps the parse method
     */
    public static class Factory
    {

      /**
      * static method to create the object
      * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
      *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
      * Postcondition: If this object is an element, the reader is positioned at its end element
      *                If this object is a complex type, the reader is positioned at the end element of its outer element
      */
      public static Upload parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception
      {
        Upload object = new Upload();

        int event;
        java.lang.String nillableValue = null;
        java.lang.String prefix = "";
        java.lang.String namespaceuri = "";
        try
        {

          while (!reader.isStartElement() && !reader.isEndElement())
            reader.next();

          if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null)
          {
            java.lang.String fullTypeName = reader.getAttributeValue(
                "http://www.w3.org/2001/XMLSchema-instance", "type");
            if (fullTypeName != null)
            {
              java.lang.String nsPrefix = null;
              if (fullTypeName.indexOf(":") > -1)
              {
                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
              }
              nsPrefix = nsPrefix == null ? "" : nsPrefix;

              java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

              if (!"upload".equals(type))
              {
                //find namespace for the prefix
                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                return (Upload)ExtensionMapper.getTypeObject(nsUri, type, reader);
              }

            }

          }

          // Note all attributes that were handled. Used to differ normal attributes
          // from anyAttributes.
          java.util.Vector handledAttributes = new java.util.Vector();

          reader.next();

          while (!reader.isStartElement() && !reader.isEndElement())
            reader.next();

          if (reader.isStartElement()
              && new javax.xml.namespace.QName("", "fileName").equals(reader.getName()))
          {

            nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
            if ("true".equals(nillableValue) || "1".equals(nillableValue))
            {
              throw new org.apache.axis2.databinding.ADBException("The element: " + "fileName"
                  + "  cannot be null");
            }

            java.lang.String content = reader.getElementText();

            object.setFileName(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

            reader.next();

          } // End of if for expected property start element

          else
          {

          }

          while (!reader.isStartElement() && !reader.isEndElement())
            reader.next();

          if (reader.isStartElement())
            // A start element we are not expecting indicates a trailing invalid property
            throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());

        }
        catch (javax.xml.stream.XMLStreamException e)
        {
          throw new java.lang.Exception(e);
        }

        return object;
      }

    }//end of factory class

  }

  public static class SetNameE
      implements org.apache.axis2.databinding.ADBBean
  {

    public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                                                               "http://ws.tieto.com/", "setName", "ns1");

    /**
    * field for SetName
    */

    protected SetName                             localSetName;

    /**
    * Auto generated getter method
    * @return SetName
    */
    public SetName getSetName()
    {
      return localSetName;
    }

    /**
       * Auto generated setter method
       * @param param SetName
       */
    public void setSetName(SetName param)
    {

      this.localSetName = param;

    }

    /**
    *
    * @param parentQName
    * @param factory
    * @return org.apache.axiom.om.OMElement
    */
    public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
        final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException
    {

      org.apache.axiom.om.OMDataSource dataSource = new org.apache.axis2.databinding.ADBDataSource(this,
          MY_QNAME);
      return factory.createOMElement(dataSource, MY_QNAME);

    }

    public void serialize(final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException,
        org.apache.axis2.databinding.ADBException
    {
      serialize(parentQName, xmlWriter, false);
    }

    public void serialize(final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter, boolean serializeType)
        throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException
    {

      //We can safely assume an element has only one type associated with it

      if (localSetName == null)
      {
        throw new org.apache.axis2.databinding.ADBException("setName cannot be null!");
      }
      localSetName.serialize(MY_QNAME, xmlWriter);

    }

    private static java.lang.String generatePrefix(java.lang.String namespace)
    {
      if (namespace.equals("http://ws.tieto.com/"))
      {
        return "ns1";
      }
      return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    /**
     * Utility method to write an element start tag.
     */
    private void writeStartElement(java.lang.String prefix, java.lang.String namespace,
        java.lang.String localPart, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {
      java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null)
      {
        xmlWriter.writeStartElement(namespace, localPart);
      }
      else
      {
        if (namespace.length() == 0)
        {
          prefix = "";
        }
        else if (prefix == null)
        {
          prefix = generatePrefix(namespace);
        }

        xmlWriter.writeStartElement(prefix, localPart, namespace);
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
    }

    /**
     * Util method to write an attribute with the ns prefix
     */
    private void writeAttribute(java.lang.String prefix, java.lang.String namespace,
        java.lang.String attName, java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {
      if (xmlWriter.getPrefix(namespace) == null)
      {
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      xmlWriter.writeAttribute(namespace, attName, attValue);
    }

    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeAttribute(java.lang.String namespace, java.lang.String attName,
        java.lang.String attValue, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {
      if (namespace.equals(""))
      {
        xmlWriter.writeAttribute(attName, attValue);
      }
      else
      {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(namespace, attName, attValue);
      }
    }

    /**
      * Util method to write an attribute without the ns prefix
      */
    private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
        javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {

      java.lang.String attributeNamespace = qname.getNamespaceURI();
      java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
      if (attributePrefix == null)
      {
        attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
      }
      java.lang.String attributeValue;
      if (attributePrefix.trim().length() > 0)
      {
        attributeValue = attributePrefix + ":" + qname.getLocalPart();
      }
      else
      {
        attributeValue = qname.getLocalPart();
      }

      if (namespace.equals(""))
      {
        xmlWriter.writeAttribute(attName, attributeValue);
      }
      else
      {
        registerPrefix(xmlWriter, namespace);
        xmlWriter.writeAttribute(namespace, attName, attributeValue);
      }
    }

    /**
     *  method to handle Qnames
     */

    private void writeQName(javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {
      java.lang.String namespaceURI = qname.getNamespaceURI();
      if (namespaceURI != null)
      {
        java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
        if (prefix == null)
        {
          prefix = generatePrefix(namespaceURI);
          xmlWriter.writeNamespace(prefix, namespaceURI);
          xmlWriter.setPrefix(prefix, namespaceURI);
        }

        if (prefix.trim().length() > 0)
        {
          xmlWriter.writeCharacters(prefix + ":"
              + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        }
        else
        {
          // i.e this is the default namespace
          xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        }

      }
      else
      {
        xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
      }
    }

    private void writeQNames(javax.xml.namespace.QName[] qnames, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException
    {

      if (qnames != null)
      {
        // we have to store this data until last moment since it is not possible to write any
        // namespace data after writing the charactor data
        java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
        java.lang.String namespaceURI = null;
        java.lang.String prefix = null;

        for (int i = 0; i < qnames.length; i++)
        {
          if (i > 0)
          {
            stringToWrite.append(" ");
          }
          namespaceURI = qnames[i].getNamespaceURI();
          if (namespaceURI != null)
          {
            prefix = xmlWriter.getPrefix(namespaceURI);
            if ((prefix == null) || (prefix.length() == 0))
            {
              prefix = generatePrefix(namespaceURI);
              xmlWriter.writeNamespace(prefix, namespaceURI);
              xmlWriter.setPrefix(prefix, namespaceURI);
            }

            if (prefix.trim().length() > 0)
            {
              stringToWrite.append(prefix).append(":")
                  .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
            }
            else
            {
              stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil
                  .convertToString(qnames[i]));
            }
          }
          else
          {
            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
          }
        }
        xmlWriter.writeCharacters(stringToWrite.toString());
      }

    }

    /**
     * Register a namespace prefix
     */
    private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter,
        java.lang.String namespace) throws javax.xml.stream.XMLStreamException
    {
      java.lang.String prefix = xmlWriter.getPrefix(namespace);
      if (prefix == null)
      {
        prefix = generatePrefix(namespace);
        javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
        while (true)
        {
          java.lang.String uri = nsContext.getNamespaceURI(prefix);
          if (uri == null || uri.length() == 0)
          {
            break;
          }
          prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      return prefix;
    }

    /**
    * databinding method to get an XML representation of this object
    *
    */
    public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
        throws org.apache.axis2.databinding.ADBException
    {

      //We can safely assume an element has only one type associated with it
      return localSetName.getPullParser(MY_QNAME);

    }

    /**
     *  Factory class that keeps the parse method
     */
    public static class Factory
    {

      /**
      * static method to create the object
      * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
      *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
      * Postcondition: If this object is an element, the reader is positioned at its end element
      *                If this object is a complex type, the reader is positioned at the end element of its outer element
      */
      public static SetNameE parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception
      {
        SetNameE object = new SetNameE();

        int event;
        java.lang.String nillableValue = null;
        java.lang.String prefix = "";
        java.lang.String namespaceuri = "";
        try
        {

          while (!reader.isStartElement() && !reader.isEndElement())
            reader.next();

          // Note all attributes that were handled. Used to differ normal attributes
          // from anyAttributes.
          java.util.Vector handledAttributes = new java.util.Vector();

          while (!reader.isEndElement())
          {
            if (reader.isStartElement())
            {

              if (reader.isStartElement()
                  && new javax.xml.namespace.QName("http://ws.tieto.com/", "setName")
                      .equals(reader.getName()))
              {

                object.setSetName(SetName.Factory.parse(reader));

              } // End of if for expected property start element

              else
              {
                // A start element we are not expecting indicates an invalid parameter was passed
                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement "
                    + reader.getName());
              }

            }
            else
            {
              reader.next();
            }
          } // end of while loop

        }
        catch (javax.xml.stream.XMLStreamException e)
        {
          throw new java.lang.Exception(e);
        }

        return object;
      }

    }//end of factory class

  }

  private org.apache.axiom.om.OMElement toOM(com.tieto.ws.hello.HelloServiceStub.SetNameE param,
      boolean optimizeContent) throws org.apache.axis2.AxisFault
  {

    try
    {
      return param.getOMElement(com.tieto.ws.hello.HelloServiceStub.SetNameE.MY_QNAME,
          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
    }
    catch (org.apache.axis2.databinding.ADBException e)
    {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }

  }

  private org.apache.axiom.om.OMElement toOM(com.tieto.ws.hello.HelloServiceStub.SetNameResponseE param,
      boolean optimizeContent) throws org.apache.axis2.AxisFault
  {

    try
    {
      return param.getOMElement(com.tieto.ws.hello.HelloServiceStub.SetNameResponseE.MY_QNAME,
          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
    }
    catch (org.apache.axis2.databinding.ADBException e)
    {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }

  }

  private org.apache.axiom.om.OMElement toOM(com.tieto.ws.hello.HelloServiceStub.UploadE param,
      boolean optimizeContent) throws org.apache.axis2.AxisFault
  {

    try
    {
      return param.getOMElement(com.tieto.ws.hello.HelloServiceStub.UploadE.MY_QNAME,
          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
    }
    catch (org.apache.axis2.databinding.ADBException e)
    {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }

  }

  private org.apache.axiom.om.OMElement toOM(com.tieto.ws.hello.HelloServiceStub.UploadResponseE param,
      boolean optimizeContent) throws org.apache.axis2.AxisFault
  {

    try
    {
      return param.getOMElement(com.tieto.ws.hello.HelloServiceStub.UploadResponseE.MY_QNAME,
          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
    }
    catch (org.apache.axis2.databinding.ADBException e)
    {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }

  }

  private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
      com.tieto.ws.hello.HelloServiceStub.SetNameE param, boolean optimizeContent,
      javax.xml.namespace.QName methodQName) throws org.apache.axis2.AxisFault
  {

    try
    {

      org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
      emptyEnvelope.getBody().addChild(
          param.getOMElement(com.tieto.ws.hello.HelloServiceStub.SetNameE.MY_QNAME, factory));
      return emptyEnvelope;
    }
    catch (org.apache.axis2.databinding.ADBException e)
    {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }

  }

  /* methods to provide back word compatibility */

  private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
      com.tieto.ws.hello.HelloServiceStub.UploadE param, boolean optimizeContent,
      javax.xml.namespace.QName methodQName) throws org.apache.axis2.AxisFault
  {

    try
    {

      org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
      emptyEnvelope.getBody().addChild(
          param.getOMElement(com.tieto.ws.hello.HelloServiceStub.UploadE.MY_QNAME, factory));
      return emptyEnvelope;
    }
    catch (org.apache.axis2.databinding.ADBException e)
    {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }

  }

  /* methods to provide back word compatibility */

  /**
  *  get the default envelope
  */
  private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory)
  {
    return factory.getDefaultEnvelope();
  }

  private java.lang.Object fromOM(org.apache.axiom.om.OMElement param, java.lang.Class type,
      java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault
  {

    try
    {

      if (com.tieto.ws.hello.HelloServiceStub.SetNameE.class.equals(type))
      {

        return com.tieto.ws.hello.HelloServiceStub.SetNameE.Factory.parse(param
            .getXMLStreamReaderWithoutCaching());

      }

      if (com.tieto.ws.hello.HelloServiceStub.SetNameResponseE.class.equals(type))
      {

        return com.tieto.ws.hello.HelloServiceStub.SetNameResponseE.Factory.parse(param
            .getXMLStreamReaderWithoutCaching());

      }

      if (com.tieto.ws.hello.HelloServiceStub.UploadE.class.equals(type))
      {

        return com.tieto.ws.hello.HelloServiceStub.UploadE.Factory.parse(param
            .getXMLStreamReaderWithoutCaching());

      }

      if (com.tieto.ws.hello.HelloServiceStub.UploadResponseE.class.equals(type))
      {

        return com.tieto.ws.hello.HelloServiceStub.UploadResponseE.Factory.parse(param
            .getXMLStreamReaderWithoutCaching());

      }

    }
    catch (java.lang.Exception e)
    {
      throw org.apache.axis2.AxisFault.makeFault(e);
    }
    return null;
  }

}
