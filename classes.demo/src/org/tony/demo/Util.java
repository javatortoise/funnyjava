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

}
