package AutoInjection;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    private static List<File> fileList = new ArrayList<>();
    public static boolean isClassFile(File file){
        return file.getName().endsWith(".class");
    }

    public static String getClassNameByFile(File file){
        String filePath = file.getAbsolutePath().replace("\\","/");
        System.out.println(filePath);
        String className = filePath.split("designmodel/")[2].replaceAll("/",".").replaceAll(".class","");
        return className;
    }

    public static List<File> getCurrentPathAlFile(String rootpath){
        File [] files = new File(rootpath).listFiles();
        for(File file : files){
            if(file.isDirectory()){
                getCurrentPathAlFile(file.getAbsolutePath());
            }else if(isClassFile(file)){
                fileList.add(file);
            }
        }
        return fileList;
    }
}
