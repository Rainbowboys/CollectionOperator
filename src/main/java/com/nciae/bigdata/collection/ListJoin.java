package com.nciae.bigdata.collection;

import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.util.*;

public class ListJoin {

    public static void main(String[] args) throws IOException {

        List<String> list1 = new ArrayList<String>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("a");
        list1.add("a");
        list1.add("b");

        // list new set  接收一个Collection
        // Set<String> listToSet = new HashSet<String>(list1);

        // for (String num : listToSet) {
        // System.out.println(num);
        // }

        // list
        List<String> list2 = new ArrayList<String>();
        list2.add("a");
        list2.add("b");
        list2.add("c");
        list2.add("e");
        list2.add("f");
        list2.add("d");

        List<String> list3 = new ArrayList<String>();

        list1.retainAll(list2);
        /*
		 * int index = 0; for (String num : list1) { index++; if (index > 3) {
		 * return; } System.out.println(num); }
		 */

        TreeSet<String> treeSet = new TreeSet<String>(list1);
        for (String elem : treeSet) {
            System.out.println(elem);
        }


        TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("I://UrlCount//part-r-00000")));

        String line = "";
        while (StringUtils.isNotEmpty(line = br.readLine())){
            String[] fields = line.split("\t");

            //使用hash 分解大文件 成多个小文件
            treeMap.put(Integer.parseInt(fields[1]), fields[0]);
            if(treeMap.size()>10){
                treeMap.remove(treeMap.lastKey());
            }
        }

        Set<Integer> integers = treeMap.keySet();
        for (Integer key:integers){
            System.out.println(key);
        }
        System.exit(0);
    }

}
