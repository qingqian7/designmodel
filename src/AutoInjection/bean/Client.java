package AutoInjection.bean;

import AutoInjection.AbstractInjection;
import AutoInjection.ClassLoaderContext;
import AutoInjection.Context;

public class Client {
    @AbstractInjection(value= TestAnnotation.class)
    private static TestAnnotation testAnnotation;
    @AbstractInjection(value= SoupCommand.class)
    private static Command command;
    public static void main(String [] args) throws ClassNotFoundException {
        Context context = new ClassLoaderContext();
        context.initContext();
        System.out.println("延迟加载");
        testAnnotation.getExecutor().executor(command);  //此处的executor对应的Kitchinner 不是延迟加载进来的
    }
}
