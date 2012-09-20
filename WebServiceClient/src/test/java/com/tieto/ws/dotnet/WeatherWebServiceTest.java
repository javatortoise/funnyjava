package com.tieto.ws.dotnet;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;

import junit.framework.TestCase;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.soap.SOAP11Constants;
import org.apache.axiom.soap.SOAP12Constants;
import org.apache.axis2.AxisFault;
import org.apache.axis2.Constants;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;

import com.tieto.ws.common.AxisHelper;
import com.tieto.ws.common.WebServiceHelper;

public class WeatherWebServiceTest extends TestCase
{

  @Override
  protected void setUp() throws Exception
  {
    System.getProperties().put("http.proxyHost", "10.32.235.41");
    System.getProperties().put("http.proxyPort", "8080");
  }

  public void testGetMyIpInformation()
  {

    String[] returnValue = WebServiceHelper.newInstance()
        .setTarget("http://webservice.webxml.com.cn/WebServices/WeatherWebService.asmx")
        .createQname("", "getSupportCity")
        .setArgAndReturnType(new Object[] {}, new Class< ? >[] { String[].class }).invoke();
    System.out.println(Arrays.toString(returnValue));
  }

  public void testPing() throws IOException
  {
    URL url = new URL("http://www.163.com");
    URLConnection conn = url.openConnection();
    conn.connect();
    InputStream uis = conn.getInputStream();
    byte[] buffer = new byte[1024];
    while ((uis.read(buffer)) != -1)
    {
      System.out.println(new String(buffer));
    }
    uis.close();
  }

  public void testGetWeather()
  {
    String address = "http://webservice.webxml.com.cn/WebServices/WeatherWebService.asmx";
    RPCServiceClient client;
    try
    {
      client = new RPCServiceClient();
      //      client.addStringHeader(new QName("http://WebXml.com.cn/", "SOAPAction"),
      //          "http://WebXml.com.cn/getSupportCity");
      Options option = client.getOptions();

      EndpointReference refence = new EndpointReference(address);
      option.setTo(refence);
      QName qname = new QName("http://WebXml.com.cn/", "getSupportCity");
      option.setAction("http://WebXml.com.cn/getSupportCity");
      option.setSoapVersionURI(SOAP11Constants.SOAP_ENVELOPE_NAMESPACE_URI);
      Object[] result = client.invokeBlocking(qname, new Object[] {}, new Class< ? >[] { String.class });
      System.out.println(Arrays.toString(result));
    }
    catch (AxisFault e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  public void testGetWeather1()
  {
    try
    {
      String address = "http://webservice.webxml.com.cn/WebServices/WeatherWebService.asmx";
      String action = "http://WebXml.com.cn/getSupportCity";
      ServiceClient client = new ServiceClient();
      OMFactory factory = OMAbstractFactory.getOMFactory();
      OMNamespace ns = factory.createOMNamespace("http://WebXml.com.cn/", "tns");
      Options op = builOptions(address, action);
      OMElement el = buildParam("getSupportCity", new String[] { "byProvinceName" }, new String[] { "" },
          factory, ns);
      client.setOptions(op);
      System.out.println(el);
      OMElement result = client.sendReceive(el);
      System.out.println(result);
    }
    catch (AxisFault e)
    {
      e.printStackTrace();
    }
  }

  public void testGetWeather2()
  {
    String address = "http://webservice.webxml.com.cn/WebServices/WeatherWebService.asmx";
    String action = "http://WebXml.com.cn/getSupportCity";
    String method = "getSupportCity";
    String uri = "http://WebXml.com.cn/";
    String prefix = "tns";
    Map<String, String> param = new HashMap<String, String>();
    param.put("byProvinceName", "ALL");

    String[] str = AxisHelper.buildInstance().buildNamespace(uri, prefix).buildOptions(address, action)
        .buildMthodAndParams(method, param).buildReturnValueType(String[].class).invoke();
    System.out.println(Arrays.toString(str));
  }

  static OMElement buildParam(String method, String[] arg, String[] val, OMFactory fac, OMNamespace ns)
  {
    OMElement data = fac.createOMElement(method, ns);
    for (int i = 0; i < arg.length; i++)
    {
      OMElement inner = fac.createOMElement(arg[i], ns);
      inner.setText(val[i]);
      data.addChild(inner);
    }
    return data;

  }

  static Options builOptions(String target, String action)
  {
    Options options = new Options();
    options.setSoapVersionURI(SOAP12Constants.SOAP_ENVELOPE_NAMESPACE_URI);
    options.setTo(new EndpointReference(target));
    options.setTransportInProtocol(Constants.TRANSPORT_HTTP);
    options.setProperty(HTTPConstants.CHUNKED, "false");//设置不受限制.
    options.setProperty(Constants.Configuration.HTTP_METHOD, HTTPConstants.HTTP_METHOD_POST);
    options.setAction(action);
    return options;
  }

  public void testJdkInvoke() throws AxisFault
  {
    String address = "http://webservice.webxml.com.cn/WebServices/WeatherWebService.asmx";
    EndpointReference refence = new EndpointReference(address);
    RPCServiceClient client = new RPCServiceClient();

    Options option = client.getOptions();
    //    option.setSoapVersionURI(SOAP11Constants.SOAP_ENVELOPE_NAMESPACE_URI);
    option.setTransportInProtocol(Constants.TRANSPORT_HTTP);
    option.setProperty(HTTPConstants.CHUNKED, "false");//设置不受限制.
    option.setProperty(HTTPConstants.CHUNKED, Boolean.FALSE);
    option.setAction("http://WebXml.com.cn/getSupportCity");
    option.setTransportInProtocol(org.apache.axis2.Constants.TRANSPORT_HTTP);
    option.setTo(refence);
    QName qname = new QName("", "getSupportCity");
    Object[] result = client.invokeBlocking(qname, new Object[] {}, new Class< ? >[] { String[].class });
    System.out.println(Arrays.toString(result));
  }
}
