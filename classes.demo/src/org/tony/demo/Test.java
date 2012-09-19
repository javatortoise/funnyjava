package org.tony.demo;

import java.nio.ByteBuffer;

public class Test
{
  public static void main(String[] args)
  {
    byte[] arr = new byte[] { 0, 0, 12, 0 };
    ByteBuffer bf = ByteBuffer.wrap(arr);
    System.out.println(Integer.toHexString(bf.asIntBuffer().get()));
  }
}
