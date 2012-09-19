package org.tony.demo;

public class Util
{
  public static int byteToHex(byte b)
  {
    return (b >> 32) & 0xff;
  }

  public static String byteArraytoHexString(byte[] bytes)
  {
    if (bytes.length == 0)
    {
      return "";
    }
    StringBuilder hexStr = new StringBuilder();
    for (byte temp : bytes)
    {
      hexStr.append(Integer.toHexString(byteToHex(temp)).toUpperCase());
    }
    return hexStr.toString();
  }

  public static int byteArrayToInt(byte[] array)
  {
    return Integer.parseInt(byteArraytoHexString(array), 16);
  }

  public static String byteArrToHexStringWithFill(byte[] bytes)
  {
    if (bytes.length == 0)
    {
      return "";
    }
    StringBuilder hexStr = new StringBuilder("0x ");
    for (byte temp : bytes)
    {
      if (temp == 0)
      {
        hexStr.append("00 ");
        continue;
      }
      String str = Integer.toHexString(byteToHex(temp));
      if (str.length() == 1)
      {
        str = "0" + str;
      }
      hexStr.append(str.toUpperCase() + " ");
    }
    return hexStr.toString();
  }
}
