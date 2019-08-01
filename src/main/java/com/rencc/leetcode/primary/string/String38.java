package com.rencc.leetcode.primary.string;

/**
 * @Description:实现strStr()
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * @Author: renchaochao
 * @Date: 2019/8/1 14:05
 **/
public class String38 {
    public int strStr(String haystack, String needle) {
        //空值等判断
        if(haystack == null || "".equals(haystack)){
            if(needle == null || "".equals(needle)){
                return 0;
            }
            return -1;
        }
        //后者为空，直接返回0
        if(needle == null || "".equals(needle)){
            return 0;
        }
        //后者长度大于前者，直接返回-1
        if(needle.length() > haystack.length()){
            return -1;
        }
        char[] chars = needle.toCharArray();
        char[] chars1 = haystack.toCharArray();
        int index = -1;
        int j = -1;
        //递归调用
        return this.solution(chars,chars1,j,index);
    }

    private int solution(char[] chars, char[] chars1, int j, int index) {
        //char 数组双层循环
        for (char aChar : chars) {
            for (int i = j+1; i < chars1.length; i++) {
                //首字符“寻址”
                if(index==-1){
                    //找到首字符位置后，跳出内层循环
                    if(chars1[i] == aChar){
                        j = i;
                        index = i;
                        break;
                    }
                }else{
                    //首字符后循环，必须保证连续一致,
                    if(chars1[i] != aChar){
                        j = index;
                        index = -1;
                        return this.solution(chars,chars1,j,index);
                    }
                    //匹配一致就跳出，且移动指针
                    j++;
                    break;
                }
            }
            //未找到首字符
            if(index == -1){
                break;
            }else if(chars1.length - index < chars.length){
                //找到首字符索引，但是剩余长度已小于匹配字符的长度
                return -1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "pi";
        int i = new String38().strStr(haystack, needle);
        System.out.println(i);
    }
}
