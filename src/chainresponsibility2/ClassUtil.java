package chainresponsibility2;

public class ClassUtil {
    public static Class<?> loadClassByName(String name) throws ClassNotFoundException {
        Class<?> clazz = Thread.currentThread().getContextClassLoader().loadClass(name);
        System.out.println("---被装在的类---"+name);
        return clazz;
    }
}
