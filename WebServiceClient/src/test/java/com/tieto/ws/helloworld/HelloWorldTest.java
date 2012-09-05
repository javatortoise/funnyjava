package com.tieto.ws.helloworld;

import junit.framework.TestCase;

import org.apache.axis2.AxisFault;

import com.tieto.ws.common.WebServiceHelper;

public class HelloWorldTest extends TestCase
{
  public void testSayHello() throws AxisFault
  {
    /**RPCServiceClient client = new RPCServiceClient();
    Options option = client.getOptions();
    String address = "http://localhost:8080/WebServiceServer/services/HelloWorld";
    EndpointReference refence = new EndpointReference(address);
    option.setTo(refence);
    QName qname = new QName("http://helloworld.ws.tieto.com", "sayHello");
    Object[] result = client.invokeBlocking(qname, new Object[] {}, new Class< ? >[] { String.class });*/

    Object[] result = WebServiceHelper.newInstance()
        .setTarget("http://localhost:8080/WebServiceServer/services/HelloWorld")
        .createQname("http://helloworld.ws.tieto.com", "sayHello")
        .setArgAndReturnType(new Object[] {}, new Class< ? >[] { String.class }).invokingBlock();
    System.out.println(result[0]);
  }
}
