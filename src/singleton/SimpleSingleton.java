package singleton;

public class SimpleSingleton{
    private static volatile SimpleSingleton instance;
    private SimpleSingleton(){}
    public static SimpleSingleton getInstance(){  //不使用同步方法的方法，因为同步方法的话，如果多个线程同时请求，就会排队，但实际上只需要将instance实例化一次，没必要排队，应该是这个方法只执行一次，后面的直接return就行
        if(instance == null){
            synchronized (SimpleSingleton.class){
                if(instance == null){  //双重检查  避免会有两个线程同时进入下面的代码然后创建一个instance 这样后来的只实例化一次
                    return new SimpleSingleton();
                }
            }
        }
        return instance;
    }
}

//静态内部类方法实现单例模式
/*
//这是借助静态内部类只会在第一次加载类时才初始化，也就是说这个SingletonInstance只会在SimpleSingleton被加载时才初始化一次，所以instance也只实例化一次，在类进行初始化时别的线程是不能进去的
public class SimpleSingleton{
    private SimpleSingleton(){}
    private static class SingletonInstance{
        private static final SimpleSingleton instance = new SimpleSingleton();
    }
    public static SimpleSingleton getInstance(){
       return SingletonInstance.instance;
    }
}
 */

//枚举  借助jdk1.5中加入的枚举类型来实现单例，避免线程同步，还能防止反序列化重新创建对象
/*
public enum Singleton{
    INSTANCE;
    public void someMethod(){
        ....
    }
}
 */