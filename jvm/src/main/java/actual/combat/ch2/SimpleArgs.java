package actual.combat.ch2;

/**
 * @author jwj
 * @date 2020/10/27 09:56
 * @description 设置虚拟机参数
 * @since V0.1
 */
public class SimpleArgs {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("参数"+(i+1)+":"+args[i]);
        }
        System.out.println("-Xmx"+Runtime.getRuntime().maxMemory()/1000/1000+"M");
    }
}
