package org.tony.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ParseClassFile
{
  static Map<String, CI>     cies      = new HashMap<String, CI>();
  static Map<String, String> accflag   = new HashMap<String, String>();
  static
  {
    accflag.put("0x0001", "ACC_PUBLIC");
    accflag.put("0x0010", "ACC_FINAL");
    accflag.put("0x0020", "ACC_SUPER");
    accflag.put("0x0200", "ACC_INTERFACE");
    accflag.put("0x0400", "ACC_ABSCRACT");
    accflag.put("0x1000", "ACC_SYNTHETIC");
    accflag.put("0x2000", "ACC_ANNOTATION");
    accflag.put("0x4000", "ACC_ENUM");
  }

  private InputStream        fis;
  private int                readCount = 0;

  public ParseClassFile(InputStream fis)
  {
    this.fis = fis;
  }

  public void parse() throws IOException
  {
    parseMagicNum();
    parseVersion();
    parseConstantInfo();
    parseAccessFlag();
    parseThisClass();
    parseSuperClass();
    parseInterfaces();
    parseFields();
    parseMethods();
    //    parseAttributes();
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
    System.out.print("常量个数：");
    int count = 0;
    byte[] temp;
    int len = 0;
    temp = new byte[2];
    len = fis.read(temp);
    if (len != -1)
    {
      readCount += len;
      count = Util.byteArrayToInt(temp);
      count = count - 1;
      System.out.println(count);
    }

    for (int i = 1; i < count; i++)
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
              fmt("\t%s,Index:%d", "CONSTANT_Class", Util.byteArrayToInt(temp));
            }
            break;
          case IFC.CONSTANT_Fieldref:
            temp = new byte[4];
            len = fis.read(temp);
            if (len != -1)
            {
              readCount += len;
              int classIndex = Util.byteArrayToInt(Arrays.copyOfRange(temp, 0, 2));
              int nameAndTypeIndex = Util.byteArrayToInt(Arrays.copyOfRange(temp, 2, 4));
              fmt("\t%s,classIndex:%d,nameAndTypeIndex:%d", "CONSTANT_Fieldref", classIndex, nameAndTypeIndex);
            }
            break;
          case IFC.CONSTANT_Methodref:
            temp = new byte[4];
            len = fis.read(temp);
            if (len != -1)
            {
              readCount += len;
              int classIndex = Util.byteArrayToInt(Arrays.copyOfRange(temp, 0, 2));
              int nameAndTypeIndex = Util.byteArrayToInt(Arrays.copyOfRange(temp, 2, 4));
              fmt("\t%s,classIndex:%d,nameAndTypeIndex:%d", "CONSTANT_Methodref", classIndex,
                  nameAndTypeIndex);
            }
            break;
          case IFC.CONSTANT_InterfaceMethodref:
            temp = new byte[4];
            len = fis.read(temp);
            if (len != -1)
            {
              readCount += len;
              int classIndex = Util.byteArrayToInt(Arrays.copyOfRange(temp, 0, 2));
              int nameAndTypeIndex = Util.byteArrayToInt(Arrays.copyOfRange(temp, 2, 4));
              fmt("\t%s,classIndex:%d,nameAndTypeIndex:%d", "CONSTANT_InterfaceMethodref", classIndex,
                  nameAndTypeIndex);
            }
            break;
          case IFC.CONSTANT_String:
            temp = new byte[2];
            len = fis.read(temp);
            if (len != -1)
            {
              readCount += len;
              fmt("\t%s,Index:%d", "CONSTANT_String", Util.byteArrayToInt(temp));
            }
            break;
          case IFC.CONSTANT_Integer:
            temp = new byte[4];
            len = fis.read(temp);
            if (len != -1)
            {
              readCount += len;
              fmt("\t%s,Value:%d", "CONSTANT_Integer", Util.byteArrayToInt(temp));
            }
            break;
          case IFC.CONSTANT_Float:
            temp = new byte[4];
            len = fis.read(temp);
            if (len != -1)
            {
              readCount += len;
              fmt("\t%s,Value:%s", "CONSTANT_Float", Util.byteArrToHexStringWithFill(temp));
            }
            break;
          case IFC.CONSTANT_Long:
            temp = new byte[8];
            len = fis.read(temp);
            if (len != -1)
            {
              readCount += len;
              fmt("\t%s,Value:%s", "CONSTANT_Long", Util.byteArrToHexStringWithFill(temp));
            }
            break;
          case IFC.CONSTANT_Double:
            temp = new byte[8];
            len = fis.read(temp);
            if (len != -1)
            {
              readCount += len;
              fmt("\t%s,Value:%s", "CONSTANT_Double", Util.byteArraytoHexString(temp));
            }
            break;
          case IFC.CONSTANT_NameAndType:
            temp = new byte[4];
            len = fis.read(temp);
            if (len != -1)
            {
              readCount += len;
              int nameIndex = Util.byteArrayToInt(Arrays.copyOfRange(temp, 0, 1));
              int descriptor_index = Util.byteArrayToInt(Arrays.copyOfRange(temp, 2, 3));
              fmt("\t%s,classIndex:%d,nameAndTypeIndex:%d", "CONSTANT_InterfaceMethodref", nameIndex,
                  descriptor_index);
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
              len = fis.read(temp);
              //              byte[] itemp = new byte[1];
              //              for (int j = 0; j < byteLen;)
              //              {
              //                len += fis.read(itemp);
              //                int tempByte = Util.byteToHex(itemp[0]);
              //                if ((tempByte != 0) && !(tempByte > 0xf0 && tempByte < 0xff))
              //                {
              //                  temp[j] = itemp[0];
              //                  j++;
              //                }
              //              }

              readCount += len;
              fmt("\t%s,Value:%s ", "CONSTANT_Utf8", new String(temp));
            }
            break;
          case IFC.CONSTANT_MethodHandle:
            temp = new byte[3];
            len = fis.read(temp);
            if (len != -1)
            {
              readCount += len;
              int reference_kind = Util.byteToHex(temp[0]);
              int reference_index = Util.byteArrayToInt(Arrays.copyOfRange(temp, 1, 2));
              fmt("\t%s,reference_kind:%d,reference_index:%d", "CONSTANT_MethodHandle", reference_kind,
                  reference_index);
            }
            break;
          case IFC.CONSTANT_MethodType:
            temp = new byte[2];
            len = fis.read(temp);
            if (len != -1)
            {
              readCount += len;
              fmt("\t%s,descriptor_index:%d", "CONSTANT_MethodType", Util.byteArrayToInt(temp));
            }
            break;
          case IFC.CONSTANT_InvokeDynamic:
            temp = new byte[4];
            len = fis.read(temp);
            if (len != -1)
            {
              readCount += len;
              int bootstrap_method_attr_index = Util.byteArrayToInt(Arrays.copyOfRange(temp, 0, 1));
              int name_and_type_index = Util.byteArrayToInt(Arrays.copyOfRange(temp, 2, 3));
              fmt("\t%s,bootstrap_method_attr_index:%d,nameAndTypeIndex:%d", "CONSTANT_InterfaceMethodref",
                  bootstrap_method_attr_index, name_and_type_index);
            }
            break;
          default:
            break;
        }
      }
    }
  }

  protected void parseAccessFlag() throws IOException
  {
    System.out.print("访问标记:");
    byte[] temp = new byte[2];
    int len = fis.read(temp);
    if (len != -1)
    {
      readCount += len;
      int value = Util.byteArrayToInt(temp);
      System.out.print(Util.byteArrToHexStringWithFill(temp) + " ");
      AccFlag[] flags = AccFlag.values();
      for (AccFlag flag : flags)
      {
        if ((value & flag.getAccValue()) == flag.getAccValue())
        {
          System.out.print(flag.getLabel() + " ");
        }
      }
    }
  }

  protected void parseThisClass() throws IOException
  {
    byte[] temp = new byte[2];
    int len = fis.read(temp);
    if (len != -1)
    {
      readCount += len;
      System.out.println("\nThis class: Hex Value:" + Util.byteArrToHexStringWithFill(temp)
          + " , Constant Pool Index:" + Util.byteArrayToInt(temp));
    }
  }

  protected void parseSuperClass() throws IOException
  {
    byte[] temp = new byte[2];
    int len = fis.read(temp);
    if (len != -1)
    {
      readCount += len;
      fmt("Super Class: Constant Pool Index -> %d (%s)", Util.byteArrayToInt(temp),
          Util.byteArrToHexStringWithFill(temp));
    }
  }

  protected void parseInterfaces() throws IOException
  {
    byte[] temp = new byte[2];
    int len = fis.read(temp);
    if (len != -1)
    {
      readCount += len;
      int count = Util.byteArrayToInt(temp);
      fmt("接口数量:%d", count);
      for (int i = 0; i < count; i++)
      {
        len = fis.read(temp);
        readCount += len;
        fmt("\t接口(%d),Constant Pool Index:(%d)", (i + 1), Util.byteArrayToInt(temp));
      }
    }
  }

  protected void parseFields() throws IOException
  {
    byte[] temp = new byte[2];
    int len = fis.read(temp);
    if (len != -1)
    {
      readCount += len;
      int count = Util.byteArrayToInt(temp);
      fmt("类中字段数量:%d", count);
      for (int i = 0; i < count; i++)
      {
        temp = new byte[8];
        len = fis.read(temp);
        if (len != -1)
        {
          StringBuilder sb = new StringBuilder("字段(%d)信息[访问标记:");
          readCount += len;
          FieldAccFlag[] flags = FieldAccFlag.values();
          int iflag = Util.byteArrayToInt(Arrays.copyOfRange(temp, 0, 2));
          for (FieldAccFlag flag : flags)
          {
            if ((flag.value & iflag) == flag.value)
            {
              sb.append(flag.label + " ");
            }
          }

          int nameIndex = Util.byteArrayToInt(Arrays.copyOfRange(temp, 2, 4));
          int descriptorIndex = Util.byteArrayToInt(Arrays.copyOfRange(temp, 4, 6));
          int attrCount = Util.byteArrayToInt(Arrays.copyOfRange(temp, 6, 8));
          sb.append(",name index:%d,descriptor index:%d,attribute count:%d,\n\t\t\tattrbutes:[");

          for (int j = 0; j < attrCount; j++)
          {
            String info = parseAttributes();
            if (info != null)
            {
              sb.append("\n\t\t\t\t" + info + ",");
            }
          }
          sb.append("\n\t\t\t]\n\t  ]");
          fmt(sb.toString(), (i + 1), nameIndex, descriptorIndex, attrCount);
        }
      }
    }
  }

  protected void parseMethods() throws IOException
  {
    byte[] temp = new byte[2];
    int len = fis.read(temp);
    if (len != -1)
    {
      readCount += len;
      int mCount = Util.byteArrayToInt(temp);
      fmt("方法数量:%d", mCount);
    }

  }

  protected String parseAttributes() throws IOException
  {
    StringBuilder sb = new StringBuilder("attribute[name index:%d,attribute length:%d,attribute info:");
    byte[] temp = new byte[6];
    int len = fis.read(temp);
    if (len != -1)
    {
      readCount += len;
      int nameIndex = Util.byteArrayToInt(Arrays.copyOfRange(temp, 0, 2));
      int length = Util.byteArrayToInt(Arrays.copyOfRange(temp, 2, 6));
      if (length > 0)
      {
        temp = new byte[length];
        len = fis.read(temp);
        if (len != -1)
        {
          readCount += len;
          sb.append("info lenth:" + len + "]");
        }
      }

      return String.format(sb.toString(), nameIndex, length);
    }
    return null;
  }

  static void fmt(String str, Object... args)
  {
    System.out.println(String.format(str, args).replaceAll("\r\n\r\n", "\r\n"));
  }
}
