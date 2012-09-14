package org.tony.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ParseClassFile
{
  static Map<String, CI> cies      = new HashMap<String, CI>();
  static
  {

  }

  private InputStream    fis;
  private int            readCount = 0;

  public ParseClassFile(InputStream fis)
  {
    this.fis = fis;
  }

  public void parse() throws IOException
  {
    parseMagicNum();
    parseVersion();
    parseConstantInfo();
    if (fis != null)
    {
      try
      {
        fis.close();
      }
      catch (IOException e)
      {
      }
    }
  }

  protected void parseMagicNum() throws IOException
  {
    System.out.print("魔数信息：");
    byte[] temp = new byte[4];
    int len = fis.read(temp);
    if (len != -1)
    {
      readCount += len;
      System.out.println(Util.byteArraytoHexString(temp));
    }
    else
    {
      throw new RuntimeException("解析错误");
    }
  }

  protected void parseVersion() throws IOException
  {
    System.out.print("版本号信息：");
    int len = 0;
    int minor = 0;
    int major = 0;
    byte[] temp = new byte[2];
    len = fis.read(temp);
    if (len != -1)
    {
      readCount += len;
      minor = Integer.parseInt(Util.byteArraytoHexString(temp), 16);
    }

    len = fis.read(temp);
    if (len != -1)
    {
      readCount += len;
      major = Integer.parseInt(Util.byteArraytoHexString(temp), 16);
    }
    System.out.println(major + "." + minor);
  }

  protected void parseConstantInfo() throws IOException
  {
    System.out.print("常量池长度：");
    int count = 0;
    byte[] temp;
    int len = 0;
    temp = new byte[2];
    len = fis.read(temp);
    if (len != -1)
    {
      readCount += len;
      count = Integer.parseInt(Util.byteArraytoHexString(temp), 16);
      System.out.println(count);
    }

    for (int i = 1; i <= count; i++)
    {
      temp = new byte[1];
      int tag = 0;
      len = fis.read(temp);
      if (len != -1)
      {
        readCount += len;
        tag = Util.byteToHex(temp[0]);
        switch (tag)
        {
          case IFC.CONSTANT_Class:
            temp = new byte[2];
            len = fis.read(temp);
            if (len != -1)
            {
              readCount += len;
              print("\tConstant Info:%s,attrIndex:%d", "CONSTANT_Class", Util.byteArrayToInt(temp));
            }
            break;
          case IFC.CONSTANT_Fieldref:
            temp = new byte[4];
            fis.read(temp);
            if (len != -1)
            {
              readCount += len;
              int classIndex = Util.byteArrayToInt(Arrays.copyOfRange(temp, 0, 1));
              int nameAndTypeIndex = Util.byteArrayToInt(Arrays.copyOfRange(temp, 2, 3));
              print("\tConstant Info:%s,classIndex:%d,nameAndTypeIndex:%d", "CONSTANT_Fieldref", classIndex,
                  nameAndTypeIndex);
            }
            break;
          case IFC.CONSTANT_Methodref:
            temp = new byte[4];
            fis.read(temp);
            if (len != -1)
            {
              readCount += len;
              int classIndex = Util.byteArrayToInt(Arrays.copyOfRange(temp, 0, 1));
              int nameAndTypeIndex = Util.byteArrayToInt(Arrays.copyOfRange(temp, 2, 3));
              print("\tConstant Info:%s,classIndex:%d,nameAndTypeIndex:%d", "CONSTANT_Methodref", classIndex,
                  nameAndTypeIndex);
            }
            break;
          case IFC.CONSTANT_InterfaceMethodref:
            temp = new byte[4];
            fis.read(temp);
            if (len != -1)
            {
              readCount += len;
              int classIndex = Util.byteArrayToInt(Arrays.copyOfRange(temp, 0, 1));
              int nameAndTypeIndex = Util.byteArrayToInt(Arrays.copyOfRange(temp, 2, 3));
              print("\tConstant Info:%s,classIndex:%d,nameAndTypeIndex:%d", "CONSTANT_InterfaceMethodref",
                  classIndex, nameAndTypeIndex);
            }
            break;
          case IFC.CONSTANT_String:
            temp = new byte[2];
            len = fis.read(temp);
            if (len != -1)
            {
              readCount += len;
              print("\tConstant Info:%s,String_index:%d", "CONSTANT_String", Util.byteArrayToInt(temp));
            }
            break;
          case IFC.CONSTANT_Integer:
            temp = new byte[4];
            fis.read(temp);
            if (len != -1)
            {
              readCount += len;
              print("\tConstant Info:%s,Value:%d", "CONSTANT_Integer", Util.byteArrayToInt(temp));
            }
            break;
          case IFC.CONSTANT_Float:
            temp = new byte[4];
            fis.read(temp);
            if (len != -1)
            {
              readCount += len;
              print("\tConstant Info:%s,Value:%d", "CONSTANT_Float", Util.byteArraytoHexString(temp));
            }
            break;
          case IFC.CONSTANT_Long:
            temp = new byte[8];
            fis.read(temp);
            if (len != -1)
            {
              readCount += len;
              print("\tConstant Info:%s,Value:%d", "CONSTANT_Long", Util.byteArraytoHexString(temp));
            }
            break;
          case IFC.CONSTANT_Double:
            temp = new byte[8];
            fis.read(temp);
            if (len != -1)
            {
              readCount += len;
              print("\tConstant Info:%s,Value:%d", "CONSTANT_Double", Util.byteArraytoHexString(temp));
            }
            break;
          case IFC.CONSTANT_NameAndType:
            temp = new byte[4];
            fis.read(temp);
            if (len != -1)
            {
              readCount += len;
              int nameIndex = Util.byteArrayToInt(Arrays.copyOfRange(temp, 0, 1));
              int descriptor_index = Util.byteArrayToInt(Arrays.copyOfRange(temp, 2, 3));
              print("\tConstant Info:%s,classIndex:%d,nameAndTypeIndex:%d", "CONSTANT_InterfaceMethodref",
                  nameIndex, descriptor_index);
            }
            break;
          case IFC.CONSTANT_Utf8:
            temp = new byte[2];
            len = fis.read(temp);
            if (len != -1)
            {
              readCount += len;
              int byteLen = Util.byteArrayToInt(temp);
              temp = new byte[byteLen];
              System.out.println();
              len = fis.read(temp);
              if (len != -1)
              {
                readCount += len;
              }
              String tempStr = new String(temp);
              print("\tConstant Info:%s,value Byte Length:%d,Value:%s ", "CONSTANT_Utf8", byteLen, tempStr);
            }
            break;
          case IFC.CONSTANT_MethodHandle:
            temp = new byte[3];
            fis.read(temp);
            if (len != -1)
            {
              readCount += len;
              int reference_kind = Util.byteToHex(temp[0]);
              int reference_index = Util.byteArrayToInt(Arrays.copyOfRange(temp, 1, 2));
              print("\tConstant Info:%s,reference_kind:%d,reference_index:%d", "CONSTANT_MethodHandle",
                  reference_kind, reference_index);
            }
            break;
          case IFC.CONSTANT_MethodType:
            temp = new byte[2];
            len = fis.read(temp);
            if (len != -1)
            {
              readCount += len;
              print("\tConstant Info:%s,descriptor_index:%d", "CONSTANT_MethodType",
                  Util.byteArrayToInt(temp));
            }
            break;
          case IFC.CONSTANT_InvokeDynamic:
            temp = new byte[4];
            fis.read(temp);
            if (len != -1)
            {
              readCount += len;
              int bootstrap_method_attr_index = Util.byteArrayToInt(Arrays.copyOfRange(temp, 0, 1));
              int name_and_type_index = Util.byteArrayToInt(Arrays.copyOfRange(temp, 2, 3));
              print("\tConstant Info:%s,bootstrap_method_attr_index:%d,nameAndTypeIndex:%d",
                  "CONSTANT_InterfaceMethodref", bootstrap_method_attr_index, name_and_type_index);
            }
            break;
          default:
            break;
        }
      }
    }
  }

  static void print(String str, Object... args)
  {
    System.out.println(String.format(str, args));
  }
}
