# openJDK_SourceCode_Learning
JDK源码学习

## 0318
- 完成项目初步构建
- java.io.Serializable->序列化接口
- java.lang.annotation->元注解、部分注解
- java.lang->从Object开始实现类加载器
- java.lang->从Throwable开始实现Exception
- java.util.function->函数式接口
- java.util->集合、抽象集合及对应集合接口实现

## 0319
- 实现System.arraycopy()->native方法
- 实现Arrays.copyOf()/copyOfRange()
- 回溯各类toString()实现方法缺失->String构造方法

## 0321
- 补完各类toString实现方法->各类之间的实现方法
- 回到ClassLoader实现上来

## 0322
- 关注WeakHashMap实现
- 涉及java.lang.ref中引用Reference、弱引用WeakReference以及引用队列ReferenceQueue相关
- 涉及虚拟机引用计数相关(sun.misc.VM -> FinalRefCount)

## 0323
- ClassLoader->ConcurrentHashMap->ConcurrentMap->Map实现链
- 补全Map中的default方法
- 关注ConcurrentHashMap的实现

## 0324
- ConcurrentHashMap->Class.getGenericInterfaces()->sun.reflect.*
- 反射机制实现链
- 签名机制(Signature)->各类签名(sun.reflect.tree.*Signature)
- ClassRepository

## 0326
- sun.reflect.generics.visitor.Reilfier->StringBuilder
- StringBuilder的具体实现