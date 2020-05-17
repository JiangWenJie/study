package com.jwj.csapp.hex;

/**
 * @ClassName Hex
 * @Description 进制转换
 * @Author 11597
 * @Date 2020/5/17 15:24
 * @Version 1.0
 */
public class Hex {
    public static void main(String[] args) {
//        System.out.println(hexToBinary("0xABC"));
//        System.out.println(binaryToHex("01010"));
//        System.out.println(decimalToHex("314156"));
        System.out.println(hexToDecimal("0x7AF"));
    }

    /**
     * 16进制转进制
     * @param hex
     * @return
     */
    static String hexToBinary(String hex){
        String binary="";
        if (!hex.startsWith("0x")){
            return "不是16进制";
        }
        hex=hex.substring(2);
        char[] charArray=hex.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            binary+=HexEnum.hexToBinary(String.valueOf(charArray[i]));
            binary+=" ";
        }
        return binary;
    }

    /**
     * 2进制转16进制
     * @param binary
     * @return
     */
    static String binaryToHex(String binary){
        String hex="";
        int length=4-binary.length()%4;
        for (int i = 0; i < length; i++) {
            binary="0"+binary;
        }
        for (int i = 0; i < binary.length()/4; i++) {
            String subBinary=HexEnum.binaryToHex(binary.substring(i*4,(i+1)*4));
            hex+=subBinary;
        }
        hex="0x"+hex;
        return hex;
    }

    /**
     * 10进制转16进制
     * @param decimal
     * @return
     */
    static String decimalToHex(String decimal){
        String hex="";
        int t=Integer.valueOf(decimal);
        hex=decimalToHexSub(t,"");
        return "0x"+hex;
    }

    /**
     * 16进制转10进制
     * @param hex
     * @return
     */
    static String hexToDecimal(String hex){
        int decimal=0;
        hex=hex.substring(2);
        char[] charArray=hex.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int a=Integer.valueOf(HexEnum.hexToDecimal(String.valueOf(charArray[i])));
            decimal+=a*Math.pow(16,charArray.length-i-1);
        }
        return String.valueOf(decimal);
    }

    static String decimalToHexSub(int decimal,String result){
        if (decimal!=0){
            int a=decimal/16;
            result=HexEnum.decimalToHex(String.valueOf(decimal%16))+result;
            return decimalToHexSub(a,result);
        }
        return result;
    }

}
