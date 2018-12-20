package AutoInjection;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassLoaderContext implements Context {
    private Class injectType;  //要扫描的注解类型
    private static List<File> fileList;  //用来装在所有的class文件
    private static Map<String,Object> objectFactory = new HashMap<>();   //对象工厂
    @Override
    public void initContext() throws ClassNotFoundException {
        injectType = Class.forName("AutoInjection.AbstractInjection");
        String filePath = this.getClass().getResource("/AutoInjection/bean").getFile(); //生成的class文件的存放路径
        fileList = FileUtil.getCurrentPathAlFile(filePath);
        for(File file : fileList){
            String className = FileUtil.getClassNameByFile(file);
            Class<?> clazz =ClassUtil.loadClassByName(className);
            if(!clazz.isInterface()){
                autowire(clazz);
            }
        }
    }

    public void autowire(Class<?> clazz){
        try{
            Object obj = null;
            if(lookupDependency(clazz) != null){
                obj = objectFactory.get(clazz.getName());
            }else{
                obj = clazz.newInstance();
            }
            Field[] fields = clazz.getDeclaredFields();
            for(Field field : fields){
                if(!field.isAccessible()){
                    field.setAccessible(true);  //设置私有属性为可访问的
                }
                AbstractInjection annotation = (AbstractInjection) field.getAnnotation(injectType);  //获取被指定类型所注解的属性
                if(annotation != null){
                    Method[] methods = annotation.annotationType().getMethods();  //获取注解中所有的方法
                    for (Method method : methods){
                        Class<?> keyClass = field.getType();
                        Class<?> instanceClass = (Class<?>) annotation.value();  //获取注解中声明的类型

                        Object object = null;
                        if(lookupDependency(keyClass) == null){
                            object = instanceClass.newInstance();
                            System.out.println("被注入的类型为：" + instanceClass);
                            objectFactory.put(keyClass.getName(),object);
                        }else{
                            object = objectFactory.get(keyClass.getName());
                        }
                        field.set(obj,object);
                    }

                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
    /*
    用于查找依赖
     */
    public Object lookupDependency(Class<?> keyClass){
        return objectFactory.get(keyClass.getName());
    }
}
