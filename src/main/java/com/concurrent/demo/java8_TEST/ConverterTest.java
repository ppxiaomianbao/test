package com.concurrent.demo.java8_TEST;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ProjectName: demo
 * @Package: com.concurrent.demo.java8_TEST
 * @ClassName: ConverterTest
 * @Author: limingxing
 * @Description: todo java8函数式接口测试
 * @Date: 2019/10/8 20:26
 * @Version: 1.0
 */
public class ConverterTest {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        //todo 两个测试例子的参数类型不同，返回值也不同
        Converter<Integer,String> converterInteger = ((from) -> Math.abs(from) + "");
        Converter<String,Double> converterString = ((from) -> Math.ceil(Double.valueOf(from)));

        //todo 最终调用的是同一个接口，lambda函数式接口只允许有且只有一个抽象方法
        String convert = converterInteger.convert(-5);
        Double convert1 = converterString.convert("3.12");
        System.out.println("converterInteger " + convert);
        System.out.println("converterString " + convert1);
        //todo 测试函数式接口里的默认方法
        converterInteger.defaultTest();

        // todo ==============此处分割线=================Java8允许你通过::关键字获取方法或者构造函数的的引用

        //todo 下面的例子就演示了如何引用一个静态方法
        Converter<String,Integer> converterString1 = Integer::valueOf;
        System.err.println(converterString1.convert("123") + 1);

        //todo 我们还可以对一个对象的方法进行引用，以下是例子
        SomeThing someThing = new SomeThing();
        Converter<String,String> converterObject = someThing::startsWith;
        String china = converterObject.convert("china");
        System.out.println("converterObject " + china);

        // todo============= 让我们看看如何使用::关键字引用构造函数。首先我们定义一个示例bean，包含不同的构造方法：

        Class<test> aClass = (Class<test>) Class.forName("com.concurrent.demo.java8_TEST.test");
        Constructor<test> constructor = aClass.getConstructor();
        test test = constructor.newInstance();
        System.out.println("test : " + test.getClass().getSimpleName());
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("名称", "性别");
        System.out.println(person.getClass());
        Class clazz = person.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field fiel : declaredFields){
            String name = fiel.getName();
            name = name.substring(0,1).toUpperCase() + name.substring(1);
            name = "get" + name;
            Method method = clazz.getMethod(name);
            Object invoke = method.invoke(person);
            System.err.println("class : " + name + "   invoke : " + invoke);

        }
        person.showInfo();

        Person pp = new test();
        System.err.println(pp.getClass());

        System.out.println(Thread.currentThread());

    }

}

class SomeThing{
    String startsWith(String s){
        return String.valueOf(s.charAt(0));
    }
}



 class Person{
    private String name;
    private String sex;

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public String getSex() {
         return sex;
     }

     public void setSex(String sex) {
         this.sex = sex;
     }

     public Person() {
    }

    public Person(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public void showInfo(){
        System.out.println("当前对象的名称： " + this.name);
    }
}

class test extends Person{
    public test(String name, String sex) {
        super(name, sex);
    }

    public test() {
    }

    /*@Override
    public String toString() {
        return "test{}";
    }*/
}

@FunctionalInterface
interface PersonFactory<P extends Person>{
    P create(String name,String sex);
}
