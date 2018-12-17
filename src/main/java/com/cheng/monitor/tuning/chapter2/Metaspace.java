package com.cheng.monitor.tuning.chapter2;


import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.ArrayList;
import java.util.List;

/**
 * http://blog.csdn.net/bolg_hero/article/details/78189621
 * 继承 ClassLoader 是为了方便调用 defineClass 方法，因为该方法的定义为 protected
 *
 * @author cheng
 *         2018/12/17 18:10
 */
public class Metaspace extends ClassLoader {

    public static List<Class<?>> createClass() {

        // 类持有
        List<Class<?>> classes = new ArrayList<>();
        // 循环 1000w 次生成 1000w 个不同的类
        for (int i = 0; i < 1000000; i++) {
            ClassWriter classWriter = new ClassWriter(0);

            // 定义一个类名称为 Class{i}，它的访问域为 public，父类为 java.lang.Object，不实现任何接口
            classWriter.visit(Opcodes.V1_1, Opcodes.ACC_PUBLIC, "Class" + i, null,
                    "java/lang/Object", null);
            // 定义构造函数 <init> 方法
            MethodVisitor methodVisitor = classWriter.visitMethod(Opcodes.ACC_PRIVATE, "<init>",
                    "()V", null, null);
            // 第一个指令为加载 this
            methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
            // 第二个指令为调用父类 Object 的构造函数
            methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object",
                    "<init>", "()V", false);
            // 第三条指令为 return
            methodVisitor.visitInsn(Opcodes.RETURN);
            methodVisitor.visitMaxs(1, 1);
            methodVisitor.visitEnd();

            Metaspace test = new Metaspace();
            byte[] code = classWriter.toByteArray();

            // 定义类
            Class<?> exampleClass = test.defineClass("Class" + i, code, 0, code.length);
            classes.add(exampleClass);
        }

        return classes;
    }
}
