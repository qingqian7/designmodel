package chainresponsibility2;

import java.io.File;
import java.util.*;

public class HandlerContext implements Context {
    private Class injectType;
    private static List<File> listFiles;
    private static Map<String,Object> objectFactory = new HashMap<>();
    private static Map<Integer,Object> handlerMap = new LinkedHashMap<>();
    @Override
    public void initContext() throws ClassNotFoundException {
        injectType = Class.forName("chainresponsibility2.Hand");  //等会儿要扫描的注解的类型
        String filePath = this.getClass().getResource("/chainresponsibility2/handler").getFile();
        listFiles = FileUtil.getCurrentPathAlFile(filePath);
        for(File file : listFiles){
            String fileName = FileUtil.getClassNameByFile(file);
            Class<?> clazz = ClassUtil.loadClassByName(fileName);
            if(!clazz.isInterface()){
                autowire(clazz);
            }
        }
    }

    private void autowire(Class<?> clazz)  {
        try {
            Object object = null;
            if (clazz.isAnnotationPresent(injectType)) {  //如果被@hand注解
                if (lookupDependency(clazz) == null) {  //若果没被实例化，就实例化一个，并且添加到LinkedHashMap中去  按照order排序
                    object = clazz.newInstance();
                    objectFactory.put(clazz.getName(),object);
                    Hand hand = clazz.getAnnotation(Hand.class);  //获取注解
                    int order = hand.order();  //获取注解的属性
                    handlerMap.put(order,object);
                }
            }
        }catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        handlerChain();  //将map中的handler 做成handler链
    }

    private Object lookupDependency(Class<?> keyClass){
        return objectFactory.get(keyClass.getName());
    }

    private void handlerChain(){
        Handler handler1 = null;
        Handler handler = null;
        Iterator iter = handlerMap.entrySet().iterator();
        if(iter.hasNext()){
            Map.Entry entry = (Map.Entry) iter.next();
            handler = (Handler) entry.getValue();
        }
        while(iter.hasNext()){
            Map.Entry entry = (Map.Entry) iter.next();
            handler1 = (Handler) entry.getValue();
            handler.setNext(handler1);
            handler = handler1;
        }
    }
    public Handler getHandler(){
        Handler handler = null;
        Iterator iter = handlerMap.entrySet().iterator();
        if(iter.hasNext()){
            Map.Entry entry = (Map.Entry) iter.next();
            handler = (Handler) entry.getValue();
        }
        return handler;
    }
}
