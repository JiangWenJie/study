package actual.combat.ch3;

/**
 * @author jwj
 * @date 2020/11/9 13:51
 * @description 最大堆和初始堆的设置
 * -Xmx20m -Xms5m -XX:+PrintCommandLineFlags -XX:+PrintGCDetails -XX:+UseSerialGC
 * @since 0.1
 */
public class HeapAlloc {
    public static void main(String[] args) {
        printMemoryDetail();

        byte[] b=new byte[1*1024*1024];
        System.out.println("分配了1M空间给数组");
        printMemoryDetail();

        b=new byte[4*1024*1024];
        System.out.println("分配了4M空间给数组");
        printMemoryDetail();

    }

    public static void printMemoryDetail(){
        System.out.print("maxMemory=");
        System.out.println(Runtime.getRuntime().maxMemory()+ " bytes,约="+Runtime.getRuntime().maxMemory()/1024/1024+"M");
        System.out.print("freeMemory=");
        System.out.println(Runtime.getRuntime().freeMemory()+ " bytes,约="+Runtime.getRuntime().freeMemory()/1024/1024+"M");
        System.out.print("totalMemory=");
        System.out.println(Runtime.getRuntime().totalMemory()+ " bytes,约="+Runtime.getRuntime().totalMemory()/1024/1024+"M");
    }
}
