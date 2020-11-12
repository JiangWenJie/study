package actual.combat.ch3;

import java.util.Vector;

/**
 * @author jwj
 * @date 2020/11/9 14:44
 * @description 堆溢出
 * @since 0.1
 */
public class DumpOOM {
    public static void main(String[] args) {
        Vector v=new Vector();
        for (int i = 0; i < 25; i++) {
            v.add(new byte[1*1024*1024]);
        }
    }
}
