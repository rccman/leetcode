package com.rencc.leetcode.primary.string;

/**
 * @Description:验证回文字符串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * @Author: renchaochao
 * @Date: 2019/7/29 16:28
 **/
public class String36 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().trim();
        for (int i = 0,j = s.length()-1; i < j; ) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if(!((ci >= 'a' && ci <= 'z')|| (ci >= '0' && ci <= '9'))){
                i++;
                continue;
            }
            if(!((cj >= 'a' && cj <= 'z')|| (cj >= '0' && cj <= '9'))){
                j--;
                continue;
            }
            if(ci != cj){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean palindrome = new String36().isPalindrome(s);
        System.out.println(palindrome);
    }

}
