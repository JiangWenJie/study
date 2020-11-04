package actual.combat.ch2;

/**
 * @author jwj
 * @date 2020/10/27 14:31
 * @description 测试GC,-XX:+PrintGC
 * @since V0.1
 */
public class LocalVarGC {
    public void localVarGc1(){
        byte[] a=new byte[6*1024*1024];
        System.gc();
    }

    public void localVarGc2(){
        byte[] a=new byte[6*1024*1024];
        a=null;
        System.gc();
    }

    public void localVarGc3(){
        {
            byte[] a = new byte[6 * 1024 * 1024];
        }
        System.gc();
    }

    public void localVarGc4(){
        {
            byte[] a = new byte[6 * 1024 * 1024];
        }
        int c=10;
        System.gc();
    }

    public void localVarGc5(){
        localVarGc1();
        System.gc();
    }

    public static void main(String[] args) {
        LocalVarGC ins=new LocalVarGC();
        ins.localVarGc4();
    }
}
