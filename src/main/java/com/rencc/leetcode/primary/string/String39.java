package com.rencc.leetcode.primary.string;

/**
 * @Description:报数
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 *
 * 注意：整数顺序将表示为一个字符串。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 *
 * 输入: 4
 * 输出: "1211"
 * @Author: renchaochao
 * @Date: 2019/8/1 15:04
 **/
public class String39 {
    public String countAndSay(int n) {
        String str = "";
        if(n <= 0){
            return str;
        }
        //循环次数依次计算
        for (int i = 0; i < n; i++) {
            str = this.solution(str);
        }
        return str;
    }

    private String solution(String str) {
        //首次输出 1
        if("".equals(str)){
            return "1";
        }
        char[] chars = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
             char c = chars[i];
            //连续数字的基数
            int n = 1;
            if(i+1<chars.length){
                //循环判断几个连续
                while (chars[i]==chars[i+1]){
                    n++;
                    i++;
                    if(i+1 == chars.length){
                        break;
                    }
                }
            }
            stringBuilder.append(n);
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int n = 6;
        String s = new String39().countAndSay(n);
        System.out.println(s);
    }
}
