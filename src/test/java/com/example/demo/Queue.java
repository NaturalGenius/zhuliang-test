package com.example.demo;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Queue {
    /**
     * 部门年会  一个部门的n个人站成一排，每一个人有一编号i（1≤i≤n），
     * 从左向右“1、2、1、2、...”报数，数到1的人出列，数到2的人立即站到队伍的最右端。
     * 报数过程反复进行，直到n个人都出列为止。已知n个人的原来的顺序，请写出他们的出列顺序。
     */
    public static void main(String[] args) {
        String message = MessageFormat.format("您已成功创建该用户【{0}】线索并约课成功", "dd");
        System.out.println(message);
//        人员集合
        List<Integer> arrays = Arrays.asList(1, 2, 3, 4, 5);
//        总人数
        int n = arrays.size();
        // 输出集合
        List<Integer> outlist = new ArrayList<>();
        // 读指针
        int r = 1;
        while (true){
            if (outlist.size() == n) {
                break;
            }
            Integer a = arrays.get(r-1);
            if (r % 2 == 1) {
                outlist.add(a);
            } else {
//                将数据放到集合最后
                arrays = addLast(arrays, a);
            }
            r++;
        }
        outlist.forEach(System.out::println);
    }

    /**
     * 将元素添加到原始集合末尾
     */
    private static List<Integer> addLast(List<Integer> list, Integer a) {
        List<Integer> runlist = new ArrayList<>();
        runlist.addAll(list);
        runlist.add(a);
        return runlist;
    }
}
