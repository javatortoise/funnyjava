package org.tony.demo;

public enum FieldAccFlag {

  ACC_PUBLIC(0x0001, "public"),
  ACC_PRIVATE(0X0002,"private"),
  ACC_PROTECTED(0X0004,"protected"),
  ACC_STATIC(0x0008,"static"),
  ACC_FINAL(0x0010,"final"),
  ACC_VOLATILE(0x0040,"volatile"),
  ACC_TRANSIENT(0x0080,"transient"),
  ACC_SYNTHETIC(0x1000,"generate by compiler"),
  ACC_ENUM(0x4000,"enum");

  private FieldAccFlag(int v, String l)
  {
    this.value = v;
    this.label = l;
  }

  public int    value;
  public String label;
}
