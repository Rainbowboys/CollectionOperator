package com.nciae.bigdata.collection;

import org.apache.commons.lang.StringUtils;

import java.io.*;

/**
 * Created by Rainbow on 2016/11/27.
 */
public class DealTopK {

    public static void main(String[] args) throws IOException {

        //读取单个大文件 对处理对象哈希散列取模 分成多个小文件
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("I://SogouQ.reduced")));
        BufferedWriter bw = null;

        String line = "";
        while (StringUtils.isNotEmpty(line = br.readLine())) {
            String[] fields = line.split("\t");
            int i = fields[4].hashCode() & Integer.MAX_VALUE % 1000;
            bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("I://outresult//part-m-00"+i,true)));
            bw.write(fields[4]);
            bw.newLine();
            bw.flush();
        }

        bw.close();
        br.close();
        System.out.println("Ok");

    }

}
