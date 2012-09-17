package com.tieto.ws.hello;

import java.rmi.RemoteException;

public class Main
{
  public static void main(String[] args) throws RemoteException
  {
    HelloServiceStub stub = new HelloServiceStub();
    HelloServiceStub.UploadE setName = new HelloServiceStub.UploadE();
    HelloServiceStub.Upload param = new HelloServiceStub.Upload();
    param.setFileName("fuck.txt");
    setName.setUpload(param);
    stub.upload(setName);
  }
}
