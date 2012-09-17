package org.tony.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Demo
{
  public static void main(String[] args) throws IOException
  {
    ParseClassFile p = new ParseClassFile(new FileInputStream(new File("classes/Right.class")));
    p.parse();
  }
}
