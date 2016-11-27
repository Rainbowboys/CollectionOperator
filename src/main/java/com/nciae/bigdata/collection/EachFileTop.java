package com.nciae.bigdata.collection;

import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by Rainbow on 2016/11/27.
 * 分解后的文件中的第一个  求全部的最大访问量
 */
public class EachFileTop {


    public static void main(String[] args) throws IOException {
        TreeMap<Integer, String> resultMap = new TreeMap<Integer, String>();
        for (int i=0;i<8;i++){
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("I://outresult//part-m-00"+i)));
            String line = "";
            TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
            while (StringUtils.isNotEmpty(line = br.readLine())) {
                if (treeMap.containsKey(line)) {
                    treeMap.put(line, treeMap.get(line) + 1);
                } else {
                    treeMap.put(line, 1);
                }
            }
            //找最大 value 对应的key
            Set<String> keySet = treeMap.keySet();
            int MaxV = 0;
            String MaxK = "";
            for (String key : keySet) {
                if (treeMap.get(key) > MaxV) {
                    MaxV = treeMap.get(key);
                    MaxK = key;
                }
            }

            resultMap.put(MaxV,MaxK);

        }
        System.out.println(resultMap.lastEntry());
    }
}
