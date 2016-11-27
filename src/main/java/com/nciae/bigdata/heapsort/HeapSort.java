package com.nciae.bigdata.heapsort;

import org.apache.commons.lang.StringUtils;

import java.io.*;

/**
 * Created by Rainbow on 2016/11/27.
 * <p>
 * 堆排序   堆排序仅需一个记录大小交换用的辅助存储空间 海量数据Top K 很有效果
 */
public class HeapSort {

    /**
     * 排序
     *
     * @param data
     */
    public static void heapSort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            createHeap(data, data.length - 1 - i);
            swap(data, 0, data.length - 1 - i);
           // print(data);
        }
    }


    //建初始堆

    public static void createHeap(int[] data, int lastIndex) {
        /**
         * Ki<=K(2i)
         * Ki<=K(2i+1)
         * 找出数组中最后的一个元素 与你
         */
        for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
            /*保存当前节点的位置*/
            int k = i;
            /*判断当前节点是否还有孩子节点*/
            while (2 * k + 1 <= lastIndex) {
                /* biggerIndex总是记录较大节点的值,先赋值为当前判断节点的左子节点 */
                int biggerIndex = 2 * k + 1;
                if (biggerIndex < lastIndex) {
                    if (data[biggerIndex] > data[biggerIndex + 1]) {
                    /*有节点大于左节点*/
                        biggerIndex++;
                    }
                }
                 /*比较当前节点和其较大的一个子节点的大小*/

                if (data[k] > data[biggerIndex]) {
                    /*交换位置*/
                    swap(data, k, biggerIndex);
                    k = biggerIndex;
                } else {
                    break;
                }
            }
        }
    }


    private static void swap(int[] data, int i, int j) {
        if (i == j) {
            return;
        }

        /*交换算法  这里不用中间变量*/
//        data[k] = data[k] + data[biggerIndex];
//        data[biggerIndex] = data[k] - data[biggerIndex];
//        data[k] = data[k] - data[biggerIndex];
        data[i] = data[i] + data[j];
        data[j] = data[i] - data[j];
        data[i] = data[i] - data[j];
    }

    /**
     * 输出数组
     *
     * @param data
     */
    public static void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {

        // int[] data5 = new int[] { 5, 3, 6, 2, 1, 9, 4, 8, 7 ,10};
        int[] data5 = new int[10];
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("I://UrlCount//part-r-00000")));
        String line = "";
        int index = 0;
        while (StringUtils.isNotEmpty(line = br.readLine())) {
            String[] fields = line.split("\t");

            if (index < 10) {
                data5[index] = Integer.parseInt(fields[1]);
                if (index == 9) {
                    heapSort(data5);
                }
                index++;
            } else {
                if (Integer.parseInt(fields[1]) > data5[9]) {
                    data5[9] = Integer.parseInt(fields[1]);
                    heapSort(data5);
                }
            }
        }

        print(data5);
    }
}
