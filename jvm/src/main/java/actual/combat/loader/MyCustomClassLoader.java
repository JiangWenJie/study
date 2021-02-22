package actual.combat.loader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * TODO
 *
 * @author jiangwenjie
 * @since 1.0
 */
public class MyCustomClassLoader extends ClassLoader {
    String clazzName="actual.combat.loader.TestBean";

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (clazzName.equals(name)){
            return findClass(name);
        }
        return super.loadClass(name);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] clazzByte=new byte[256];
        try {
            FileInputStream in=new FileInputStream("/Users/jiangwenjie/IdeaProjects/study/jvm/target/classes/actual/combat/loader/TestBean.class");
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int size = 0;
            while ((size = in.read(clazzByte)) != -1) {
                out.write(clazzByte, 0, size);
            }
            clazzByte=out.toByteArray();
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defineClass(clazzName,clazzByte,0,clazzByte.length);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        MyCustomClassLoader myCustomClassLoader=new MyCustomClassLoader();
        Class clazz=myCustomClassLoader.loadClass("actual.combat.loader.TestBean");
        System.out.println(clazz.getClassLoader());
    }
}
