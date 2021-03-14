package com.jwj.study.guava.event.bus;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author jiangwenjie
 * @since 1.0
 */
public class FileMain {
    public static void main(String[] args) throws IOException {
        File file=new File("/Users/jiangwenjie/Downloads/问题.htm");
        File result=new File("/Users/jiangwenjie/Downloads/结果.md");
        if (!result.exists()){
            result.createNewFile();
        }
        byte[] bytes=Files.readAllBytes(file.toPath());
        String content=new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
        String[] persons={"[汤琪]","[李笑宇]","[谢海波]","[姜文杰]"};
        List<String> stringList=new ArrayList<>();
        getSubString(stringList,0,content);
        List<String> stringResult=new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {
            String item=stringList.get(i);
            item="### "+persons[i%4]+" "+item;
            stringResult.add(item);
            stringResult.add("- [ ] 完成");
        }
        Files.write(result.toPath(),stringResult);
    }

    public static void getSubString(List<String> result,int startIndex,String content){
        if (-1==startIndex){
            return;
        }
        int begin=content.indexOf("<span class=\"facet-name\">(Java)",startIndex);
        if (begin==-1){
            return;
        }
        begin=begin+25;
        int end=content.indexOf("</span>",begin);
        if (end==-1){
            return;
        }
        result.add(content.substring(begin,end));
        getSubString(result,end,content);
    }
}
