package factorymethod;

public class FactoryTest {
    public static void main(String[] args){
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i=0;i<8;i++){
            arrayList.add(i);
            linkedList.add(i);
        }
        Iterator ai = arrayList.iterator();
        Iterator li = linkedList.iterator();
        while(ai.hasNext()){
            System.out.print(ai.next());
        }
        System.out.println("...");
        while(li.hasNext()){
            System.out.print(li.next());
        }
    }

}

/*
工厂模式主要就涉及上面介绍的三种：

    简单工厂模式是由一个具体的类去创建其他类的实例，父类是相同的，父类是具体的。
    工厂方法模式是有一个抽象的父类定义公共接口，子类负责生成具体的对象，这样做的目的是将类的实例化操作延迟到子类中完成。
    抽象工厂模式提供一个创建一系列相关或相互依赖对象的接口，而无须指定他们具体的类。它针对的是有多个产品的等级结构。而工厂方法模式针对的是一个产品的等级结构
 */