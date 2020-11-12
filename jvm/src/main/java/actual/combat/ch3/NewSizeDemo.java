package actual.combat.ch3;

/**
 * @author jwj
 * @date 2020/11/9 14:05
 * @description 新生代的配置
 * -Xmx20m -Xms20m -Xmn1m -XX:SurvivorRatio=2 -XX:+PrintGCDetails
 * -Xmx20m -Xms20m -Xmn15m -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 * -Xmx20m -Xms20m -XX:NewRatio=2 -XX:+PrintGCDetails
 * @since 0.1
 */
public class NewSizeDemo {
    public static void main(String[] args) {
        byte[] b=null;
        for (int i = 0; i < 10; i++) {
            b=new byte[1*1024*1024];
        }
    }
}
