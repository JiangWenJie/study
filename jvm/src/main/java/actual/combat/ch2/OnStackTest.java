package actual.combat.ch2;

/**
 * @author jwj
 * @date 2020/10/27 16:23
 * @description 对栈上的逃逸对象进行分析
 * @since V0.1
 */
public class OnStackTest {
    public static class User{
        public int id=0;
        public String name="";
    }

    public static void alloc(){
        User u=new User();
        u.id=5;
        u.name="geym";
    }

    public static void main(String[] args) {
        long b=System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            alloc();
        }
        long e=System.currentTimeMillis();
        System.out.println(e-b);
    }
}
