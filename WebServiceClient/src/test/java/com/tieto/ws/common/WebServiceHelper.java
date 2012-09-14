package com.tieto.ws.common;

import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;

public class WebServiceHelper
{
  private RPCServiceClient  client;
  private QName             qname;
  private Object[]          args;
  private Class< ? >[]      returnTypes;
  String                    soaction;
  private EndpointReference enpoint;

  public static WebServiceHelper newInstance()
  {
    WebServiceHelper helper = new WebServiceHelper();
    try
    {
      helper.client = new RPCServiceClient();
    }
    catch (AxisFault e)
    {
      throw new RuntimeException(e);
    }
    return helper;
  }

  public WebServiceHelper setTarget(String address)
  {
    enpoint = new EndpointReference(address);
    //this.client.getOptions().setTo();
    return this;
  }

  public WebServiceHelper createQname(String namespace, String methodName)
  {
    qname = new QName(namespace, methodName);
    soaction = "http://WebXml.com.cn/" + methodName;
    return this;
  }

  public WebServiceHelper setArgAndReturnType(Object[] args, Class< ? >[] returnTypes)
  {
    this.args = args;
    this.returnTypes = returnTypes;
    return this;
  }

  public Object[] invokingBlock()
  {
    try
    {
      Options op = this.client.getOptions();
      op.setAction(soaction);
      op.setTo(enpoint);
      op.setProperty(HTTPConstants.CHUNKED, "false");
      this.client.setOptions(op);

      return this.client.invokeBlocking(qname, args, returnTypes);
    }
    catch (AxisFault e)
    {
      throw new RuntimeException(e);
    }
  }

  public String returnString()
  {
    return (String)invokingBlock()[0];
  }

  public int returnInt()
  {
    return (Integer)invokingBlock()[0];
  }

  public boolean returnBoolean()
  {
    return (Boolean)invokingBlock()[0];
  }

  @SuppressWarnings("unchecked")
  public <T> T invoke()
  {
    return (T)invokingBlock()[0];
  }

}
