package com.tieto.ws.bean;

import java.io.Serializable;
import java.util.Date;

public class User
    implements Serializable
{

  private static final long serialVersionUID = 1L;

  private int               id;
  private String            name;
  private Boolean           gender;
  private Date              birthday;

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public Boolean getGender()
  {
    return gender;
  }

  public void setGender(Boolean gender)
  {
    this.gender = gender;
  }

  public Date getBirthday()
  {
    return birthday;
  }

  public void setBirthday(Date birthday)
  {
    this.birthday = birthday;
  }

  @Override
  public String toString()
  {
    return "User [id=" + id + ", name=" + name + ", gender=" + gender + ", birthday=" + birthday + "]";
  }
}
