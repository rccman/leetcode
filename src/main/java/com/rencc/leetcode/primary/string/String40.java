package com.rencc.leetcode.primary.string;

/**
 * @Description:最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 * @Author: renchaochao
 * @Date: 2019/8/1 15:43
 **/
public class String40 {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        int length = strs.length;
        //取数组第一个，依次遍历
        char[] chars = strs[0].toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            int j = 1;
            for (; j < length; j++) {
                //当有字符串长度没有了，或者，不匹配时即终止，返回
                if(strs[j].length()<= i || strs[j].charAt(i) != chars[i]){
                    return stringBuilder.toString();
                }
            }
            //证明数组的每个字符串前缀都是，符合公共前缀
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String[] str = {"flower","flow","flight"};
        String s = new String40().longestCommonPrefix(str);
        System.out.println(s);
    }
}
