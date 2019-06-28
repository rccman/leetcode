package com.rencc.leetcode.primary.array;

import java.util.Arrays;

/**
 * @title 加一
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class Array27 {
    /**
     * 倒序循环，先最末尾加一，判断是否需要进位，若进位依次循环，若不需要进位，跳出循环中止即可。若首位还需要循环，则数组需要扩容
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0; i--) {
            //判断是否需要进位
            if(digits[i]+1 > 9){
                digits[i] = 0;
                if(i > 0){
                    continue;
                }
                int[] result = new int[digits.length+1];
                result[0] = 1;
                System.arraycopy(digits, 0,result, 1, digits.length);
                /*for (int j = 0; j < digits.length; j++) {
                    result[j+1] = digits[j];
                }*/
                return result;
            }else{
                digits[i] = digits[i]+1;
                break;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = {9};
        int[] plusOne = new Array27().plusOne(digits);
        System.out.println(Arrays.toString(plusOne));
    }
}
