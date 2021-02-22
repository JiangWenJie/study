package actual.combat.loader;

/**
 * TODO
 *
 * @author jiangwenjie
 * @since 1.0
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        MyCustomClassLoader myCustomClassLoader=new MyCustomClassLoader();
        Class clazz=myCustomClassLoader.loadClass("actual.combat.loader.TestBean");
        System.out.println(clazz.getClassLoader());
    }
}
