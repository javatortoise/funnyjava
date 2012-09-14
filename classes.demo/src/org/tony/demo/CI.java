package org.tony.demo;

public class CI
{
  String label;
  int    tag;
  int    totalBit;

  public CI(String label, int totalBit, int tag)
  {
    super();
    this.tag = tag;
    this.label = label;
    this.totalBit = totalBit;
  }

  public byte[] newArray()
  {
    return new byte[totalBit];
  }
}
