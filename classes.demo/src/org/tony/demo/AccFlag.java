package org.tony.demo;

public enum AccFlag {

  ACC_PUBLIC(0x0001, "ACC_PUBLIC"), ACC_FINAL(0x0010, "ACC_FINAL"), ACC_SUPER(0x0020, "ACC_SUPER"), ACC_INTERFACE(
      0x0200, "ACC_INTERFACE"), ACC_ABSCRACT(0x0400, "ACC_ABSCRACT"), ACC_SYNTHETIC(0x1000, "ACC_SYNTHETIC"), ACC_ANNOTATION(
      0x2000, "ACC_ANNOTATION"), ACC_ENUM(0x4000, "ACC_ENUM");

  private AccFlag(int value, String label)
  {
    this.value = value;
    this.label = label;
  }

  int    value;
  String label;

  public int getAccValue()
  {
    return this.value;
  }

  public String getLabel()
  {
    return this.label;
  }
}
