package com.example.demo.calculate;

public class DoublePointerDay04 {

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        System.err.println(new String(s));
        char[] s2 = {'H','a','n','n','a','h'};
        reverseString(s2);
        System.err.println(new String(s2));
        System.out.println(reverseWords("Let's take LeetCode contest"));
        System.out.println(reverseWords2("Let's take LeetCode contest"));
    }
    /**
     * 344. 反转字符串
编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。

不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。

你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。

 

示例 1：

输入：['h','e','l','l','o']
输出：['o','l','l','e','h']
示例 2：

输入：['H','a','n','n','a','h']
输出：['h','a','n','n','a','H']
     */
    
    public static void reverseString(char[] s) {
      for (int i = 0, j = s.length -1; i < j; i++, j--) {
         char tmp = s[i];
         s[i] = s[j];
         s[j] = tmp;
      }
    }
    
    /**
     * 557. 反转字符串中的单词 III
给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

 

示例：

输入："Let's take LeetCode contest"
输出："s'teL ekat edoCteeL tsetnoc"
 

提示：

在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
     */
    public static String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (String str : split) {
            char[] cs = str.toCharArray();
            for (int i = 0, j = cs.length -1; i < j; i++, j--) {
                char tmp = cs[i];
                cs[i] = cs[j];
                cs[j] = tmp;
            }
            builder.append(cs).append(" ");
        }
        return builder.substring(0, builder.length() -1);
    }
    public static String reverseWords2(String s) {
        char[] cs = s.toCharArray();
        int fromIndex = 0;
        s = s + " ";
        while (true) {
            int indexOf = s.indexOf(" ", fromIndex);
            if (indexOf == -1) {
                return new String(cs);
            }
            for (int i = fromIndex, j = indexOf -1; i < j; i++, j--) {
                char tmp = cs[i];
                cs[i] = cs[j];
                cs[j] = tmp;
            }
            fromIndex = indexOf +1;
        }
    }
}
