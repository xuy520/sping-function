package com.xy.javassist;

import javassist.*;
import javassist.bytecode.AccessFlag;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class JavassistTest {
    public static void main(String[] args) {
//        try {
//            ClassPool pool = ClassPool.getDefault();
//            CtClass ct = pool.makeClass("com.xy.GenerateClass");//创建类
//            ct.setSuperclass(new CtClass[]{pool.makeClass("com.xy.model.User")}[0]);//让类继承User
//            CtField f = new CtField(CtClass.intType, "id", ct);//获得一个类型为int，名称为id的字段
//            f.setModifiers(AccessFlag.PUBLIC);//将字段设置为public
//            ct.addField(f);//将字段设置到类上
//            //添加构造函数
//            CtConstructor constructor = CtNewConstructor.make("public GeneratedClass(int pId){System.out.println(\"动态生成的方法\");}", ct);
//            ct.addConstructor(constructor);
//            //添加方法
//            CtMethod helloM = CtNewMethod.make("public void hello(String des){ System.out.println(des);}", ct);
//            ct.addMethod(helloM);
//
//            ct.writeFile();//将生成的.class文件保存到磁盘
//
//            //下面的代码为验证代码
//            Field[] fields = ct.toClass().getFields();
//            System.out.println("属性名称：" + fields[0].getName() + "  属性类型：" + fields[0].getType());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        ClassPool pool = ClassPool.getDefault();
        try {
            CtClass ct = pool.getCtClass("com.xy.model.User");
            CtMethod m = ct.getDeclaredMethod("toString");
            m.insertBefore("{ System.out.print(\"新增功能\"); System.out.println(\"dy:\");}");
            m.insertAfter("{System.out.println(this.userId); System.out.println(this.userName);}");
            ct.writeFile();
            Class pc = ct.toClass();
            Method move = pc.getMethod("toString");
            Constructor<?> con = pc.getConstructor();
            move.invoke(con.newInstance());
        } catch (Exception e) {
            System.out.printf(e.getMessage());
        }


    }
}
