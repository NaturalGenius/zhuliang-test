package com.example.demo.calculate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 滑动窗口
 * @author MSI-PC
 *
 */
public class SlidingWindow06 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(""));
        System.out.println(lengthOfLongestSubstring("au"));
        
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("ab", "eidboaoo"));
        System.out.println(checkInclusion("abc", "abc"));
        System.out.println(checkInclusion("hello", "ooolleoooleh"));
    }
    /**
     * 3. 无重复字符的最长子串
给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。

 

示例 1:

输入: s = "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
示例 4:

输入: s = ""
输出: 0
     */
    
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int length =0;
        for (int left = 0; left < s.length() - 1; left++) {
            Set<Character> characters = new HashSet<>();
            characters.add(s.charAt(left));
            for (int rigt = left + 1; rigt < s.length(); rigt++) {
                char charAt = s.charAt(rigt);
                if (characters.contains(charAt)) {
                    break;
                }
                characters.add(charAt);
            }
            if (length < characters.size()) {
                length = characters.size();
            }
            
        }
        return length;
    }
    
    /**
     * 567. 字符串的排列
给你两个字符串 s1 和 s2 ，
写一个函数来判断 s2 是否包含 s1 的排列。

换句话说，s1 的排列之一是 s2 的 子串 。
示例 1：
输入：s1 = "ab" s2 = "eidbaooo"
输出：true
解释：s2 包含 s1 的排列之一 ("ba").
示例 2：
输入：s1= "ab" s2 = "eidboaoo"
输出：false
     */
    
    public static boolean checkInclusion(String s1, String s2) {
        if (s2.length() == 0) {
            return false;
        }
        if (s2.length() == 1) {
            return s2.equals(s1);
        }
        char[] charArray = s1.toCharArray();
        Arrays.sort(charArray);
        String tmp = new String(charArray);
        for (int left = 0; left <= s2.length() - s1.length(); left++) {
            String sub = s2.substring(left, left + s1.length());
            char[] subChar = sub.toCharArray();
            Arrays.sort(subChar);
            if (new String(subChar).equals(tmp)) {
                return true;
            }
        }
        return false;   
    }
}
