package com.tieto.ws.dotnet;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

import javax.xml.namespace.QName;

import junit.framework.TestCase;

import org.apache.axiom.soap.SOAP11Constants;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;

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

  public void testJdkInvoke() throws AxisFault
  {
    String address = "http://webservice.webxml.com.cn/WebServices/WeatherWebService.asmx";
    EndpointReference refence = new EndpointReference(address);
    RPCServiceClient client = new RPCServiceClient();

    Options option = client.getOptions();
    option.setSoapVersionURI(SOAP11Constants.SOAP_ENVELOPE_NAMESPACE_URI);
    option.setProperty(HTTPConstants.CHUNKED, Boolean.FALSE);
    option.setAction("http://WebXml.com.cn/getSupportCity");
    option.setTransportInProtocol(org.apache.axis2.Constants.TRANSPORT_HTTP);
    option.setTo(refence);
    QName qname = new QName("http://WebXml.com.cn/", "getSupportCity");
    Object[] result = client.invokeBlocking(qname, new Object[] {}, new Class< ? >[] { String[].class });
    System.out.println(Arrays.toString(result));
  }
}
