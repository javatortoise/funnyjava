package com.tieto.ws.common;

import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.rpc.client.RPCServiceClient;

public class WebServiceHelper
{
  private RPCServiceClient client;
  private QName            qname;
  private Object[]         args;
  private Class< ? >[]     returnTypes;

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
    this.client.getOptions().setTo(new EndpointReference(address));
    return this;
  }

  public WebServiceHelper createQname(String namespace, String methodName)
  {
    qname = new QName(namespace, methodName);
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
      return this.client.invokeBlocking(qname, args, returnTypes);
    }
    catch (AxisFault e)
    {
      throw new RuntimeException(e);
    }
  }

}
