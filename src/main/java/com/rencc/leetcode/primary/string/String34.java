package com.rencc.leetcode.primary.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 */
public class String34 {
    /**
     * 暴力穷举
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        if(s.length() == 0){
            return -1;
        }
        char[] chars = s.toCharArray();
        Map<String,Boolean> map = new HashMap<>(chars.length);
        for (int i = 0; i < chars.length; i++) {
            boolean flag = true;
            if(map.get(String.valueOf(chars[i]))!=null){
                continue;
            }
            for (int j = i+1; j < chars.length; j++) {
                if(chars[i] == chars[j]){
                    map.put(String.valueOf(chars[i]),true);
                    flag = false;
                    break;
                }
            }
            if(i<chars.length && flag){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "ccw";
        System.out.println(new String34().firstUniqChar(s));
    }

    /**
     * 利用哈希表
     * @param s
     * @return
     */
    public int firstUniqChar2(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

}
