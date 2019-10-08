package com.concurrent.demo.java8_TEST;

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

    public static void main(String[] args) {
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

        PersonFactory<Person> personFactory = test::new;
        Person person = personFactory.create("名称", "性别");
        System.out.println(person.getClass());
        person.showInfo();

        Person pp = new test();
        System.err.println(pp.getClass());

    }

}

class SomeThing{
    String startsWith(String s){
        return String.valueOf(s.charAt(0));
    }
}




abstract class Person{
    private String name;
    private String sex;

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

interface PersonFactory<P extends Person>{
    P create(String name,String sex);
}
