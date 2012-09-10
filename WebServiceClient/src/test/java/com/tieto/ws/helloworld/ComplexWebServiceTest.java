package com.tieto.ws.helloworld;

import junit.framework.TestCase;

import com.tieto.ws.bean.User;
import com.tieto.ws.common.WebServiceHelper;

public class ComplexWebServiceTest extends TestCase
{

  public void testQueryUser()
  {
    User user = WebServiceHelper.newInstance()
        .setTarget("http://localhost:8080/WebServiceServer/services/ComplexWebService")
        .createQname("http://helloworld.ws.tieto.com", "queryUser")
        .setArgAndReturnType(new Object[] {}, new Class< ? >[] { User.class }).invoke();
    System.out.println(user);
  }
}
