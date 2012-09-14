package org.tony.demo;

public interface IFC
{

  /***访问控制符***/
  int ACC_PUBLIC                  = 0x0001; //public
  int ACC_FINAL                   = 0x0010; //final修饰符
  int ACC_SUPER                   = 0x0020; //超类
  int ACC_INTERFACE               = 0x0200; //标识接口
  int ACC_ABSCRACT                = 0x0400; //抽象类或者方法
  int ACC_SYNTHETIC               = 0x1000; //非java代码
  int ACC_ANNOTATION              = 0x2000; //注解
  int ACC_ENUM                    = 0x4000; //枚举
  /***访问控制符***/

  /****Tag********/
  int CONSTANT_Class              = 7;
  int CONSTANT_Fieldref           = 9;
  int CONSTANT_Methodref          = 10;
  int CONSTANT_InterfaceMethodref = 11;
  int CONSTANT_String             = 8;
  int CONSTANT_Integer            = 3;
  int CONSTANT_Float              = 4;
  int CONSTANT_Long               = 5;
  int CONSTANT_Double             = 6;
  int CONSTANT_NameAndType        = 12;
  int CONSTANT_Utf8               = 1;
  int CONSTANT_MethodHandle       = 15;
  int CONSTANT_MethodType         = 16;
  int CONSTANT_InvokeDynamic      = 18;

}
