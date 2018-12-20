package builderpattern;

import org.relaxng.datatype.DatatypeBuilder;

public class BuilderTest {
    public static void main(String [] args){
        MyDate myDate = new MyDate();
        DateBuilder db1 = new DateBuilder1(myDate).buildDate(2018,12,19);
        System.out.println(db1.getDate());
        DateBuilder db2 = new DateBuilder2(myDate).buildDate(2018,12,19);
        System.out.println(db2.getDate());
    }
}
/*
何时使用：

    当系统准备为用户提供一个内部结构复杂的对象，而且在构造方法中编写创建该对象的代码无法满足用户需求时，就可以使用生成器模式老构造这样的对象。
    当某些系统要求对象的构造过程必须独立于创建该对象的类时。
    优点：

    生成器模式将对象的构造过程封装在具体的生成器中，用户使用不同的具体生成器就可以得到该对象的不同表示。
    生成器模式将对象的构造过程从创建该对象的类中分离出来，使用户无须了解该对象的具体组件。
    可以更加精细有效的控制对象的构造过程。生成器将对象的构造过程分解成若干步骤，这就是程序可以更加精细，有效的控制整个对象的构造。
    生成器模式将对象的构造过程与创建该对象类解耦，是对象的创建更加灵活有弹性。
    当增加新的具体的生成器是，不必修改指挥者的代码，即该模式满足开-闭原则。
    模式的重心在于分离构建算法和具体的构造实现，从而使构建算法可以重用。

    比如我们要得到一个日期，可以有不同的格式，然后我们就使用不同的生成器来实现。
 */