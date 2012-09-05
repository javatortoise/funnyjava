package com.tieto.ws.helloworld;

import java.util.Date;

import com.tieto.ws.bean.User;

public class ComplexWebService
{
  private static int ID = 1;

  public User queryUser()
  {
    User user = new User();
    user.setId(ID++);
    user.setName("New User " + ID);
    user.setGender(true);
    user.setBirthday(new Date());
    return user;
  }
}
