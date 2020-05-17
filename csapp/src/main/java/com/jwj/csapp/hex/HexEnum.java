package com.jwj.csapp.hex;

public enum HexEnum {
    _0("0","0","0000"),
    _1("1","1","0001"),
    _2("2","2","0010"),
    _3("3","3","0011"),
    _4("4","4","0100"),
    _5("5","5","0101"),
    _6("6","6","0110"),
    _7("7","7","0111"),
    _8("8","8","1000"),
    _9("9","9","1001"),
    _10("A","10","1010"),
    _11("B","11","1011"),
    _12("C","12","1100"),
    _13("D","13","1101"),
    _14("E","14","1110"),
    _15("F","15","1111");

    private String hex;
    private String decimal;
    private String binary;

    public static String hexToBinary(String hex){
        for (HexEnum e:HexEnum.values()){
            if (e.getHex().equals(hex)){
                return e.getBinary();
            }
        }
        return null;
    }

    public static String binaryToHex(String binary){
        for (HexEnum e:HexEnum.values()){
            if (e.getBinary().equals(binary)){
                return e.getHex();
            }
        }
        return null;
    }

    public static String decimalToHex(String decimal){
        for (HexEnum e:HexEnum.values()){
            if (e.getDecimal().equals(decimal)){
                return e.getHex();
            }
        }
        return null;
    }

    public static String hexToDecimal(String hex){
        for (HexEnum e:HexEnum.values()){
            if (e.getHex().equals(hex)){
                return e.getDecimal();
            }
        }
        return null;
    }
    HexEnum(String hex, String decimal, String binary) {
        this.hex = hex;
        this.decimal = decimal;
        this.binary = binary;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public String getBinary() {
        return binary;
    }

    public void setBinary(String binary) {
        this.binary = binary;
    }

    public String getDecimal() {
        return decimal;
    }

    public void setDecimal(String decimal) {
        this.decimal = decimal;
    }
}
