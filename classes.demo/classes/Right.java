package org.tony.test;

import java.io.Serializable;

/**
 * 这是一个测试的
 * @author tangilin
 *
 */
public abstract class Right
    implements Serializable
{
  private static final long serialVersionUID = 1L;
  public static final int   R                = 1;
  public static final int   W                = 2;
  public static final int   X                = 3;

  private int               right            = 0;

  public Right(int r, int w, int x)
  {
    this.right |= r;
    this.right |= w;
    this.right |= x;
  }

  public boolean readable()
  {
    return (this.right & R) == R;
  }

  public boolean writable()
  {
    return (this.right & W) == W;
  }

  public boolean executable()
  {
    return (this.right & X) == X;
  }

}
