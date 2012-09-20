package com.tieto.ws.common;

import java.util.Iterator;
import java.util.Map;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.soap.SOAP11Constants;
import org.apache.axis2.AxisFault;
import org.apache.axis2.Constants;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.databinding.utils.BeanUtil;
import org.apache.axis2.engine.DefaultObjectSupplier;
import org.apache.axis2.transport.http.HTTPConstants;

public class AxisHelper
{
  private Options       option;
  private OMElement     method;
  private OMFactory     factory;
  private OMNamespace   namespace;
  private ServiceClient client;
  private Object[]      retType;

  public AxisHelper()
  {
    factory = OMAbstractFactory.getOMFactory();
    try
    {
      client = new ServiceClient();
    }
    catch (AxisFault e)
    {
      throw new RuntimeException(e);
    }
  }

  public static AxisHelper buildInstance()
  {
    return new AxisHelper();
  }

  public AxisHelper buildNamespace(String uri, String prefix)
  {
    this.namespace = factory.createOMNamespace(uri, prefix);
    return this;
  }

  /**
   * 
   * @param address
   * @param action
   * @return
   */
  public AxisHelper buildOptions(String address, String action)
  {
    option = new Options();
    option.setSoapVersionURI(SOAP11Constants.SOAP_ENVELOPE_NAMESPACE_URI);
    option.setTo(new EndpointReference(address));
    option.setTransportInProtocol(Constants.TRANSPORT_HTTP);
    option.setProperty(HTTPConstants.CHUNKED, "false");//设置不受限制.
    option.setProperty(Constants.Configuration.HTTP_METHOD, HTTPConstants.HTTP_METHOD_POST);
    option.setAction(action);
    return this;
  }

  /**
   * 
   * @param params
   * @return
   */
  public AxisHelper buildMthodAndParams(String methodName, Map<String, String> params)
  {
    if (params != null && !params.isEmpty())
    {
      this.method = factory.createOMElement(methodName, namespace);
      for (Iterator<String> keyIter = params.keySet().iterator(); keyIter.hasNext();)
      {
        String key = keyIter.next();
        OMElement inner = factory.createOMElement(key, namespace);
        inner.setText(params.get(key));
        this.method.addChild(inner);
      }
    }
    return this;
  }

  public AxisHelper buildReturnValueType(Class< ? > clazz)
  {
    this.retType = new Object[] { clazz };
    return this;
  }

  /**
   * 调用目标方法
   * @return
   */
  @SuppressWarnings("unchecked")
  public <T> T invoke()
  {
    try
    {
      client.setOptions(option);
      OMElement response = client.sendReceive(method);
      Object[] obj = BeanUtil.deserialize(response, retType, new DefaultObjectSupplier());
      return (T)obj[0];
    }
    catch (AxisFault e)
    {
      throw new RuntimeException(e.getMessage());
    }
  }
}
