package org.tony.demo;

public enum MethodAccFlag
{
    ACC_PUBLIC(0x0001, "public"),
    ACC_PRIVATE(0X0002, "private"),
    ACC_PROTECTED(0X0004, "protected"),
    ACC_STATIC(0x0008, "static"),
    ACC_FINAL(0x0010, "final"),
    ACC_SYNCHRONIZED(0x0020, "synchronized"),
    ACC_BRIDGE(0x0040, "bridge"),
    ACC_VARARGS(0x0080, "var args"),
    ACC_NATIVE(0x0100, "native"),
    ACC_ABSTRACT(0x0400, "abstract"),
    ACC_STRICT(0x0800, "strictfp"),
    ACC_SYNTHETIC(0x1000, "geneated by compiler");

  private MethodAccFlag(int v, String l)
  {
    this.value = v;
    this.label = l;
  }

  public int    value;
  public String label;
}
