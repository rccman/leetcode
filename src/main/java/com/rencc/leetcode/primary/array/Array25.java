package com.rencc.leetcode.primary.array;

import java.util.Arrays;

/**
 * @title 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class Array25 {
    /**
     * 原始思路（效率低）
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length;i+=2) {
            if(i == nums.length-1){
                result = nums[i];
                break;
            }
            if(nums[i] != nums[i+1]){
                result = nums[i];
                break;
            }
        }
        return result;
    }

    /**
     * 高手思路
     * ^= 异或 先转换为二进制相同异或为 0，不同异或为 1
     * 整体不分先后，相同的异或最后都会抵消掉，留下唯一不同的
     * @param nums
     * @return
     */
    public  int singleNumber2(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^=num;
        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,5};
        int singleNumber = new Array25().singleNumber(nums);
        int singleNumber2 = new Array25().singleNumber2(nums);
        System.out.println(singleNumber);
        System.out.println(singleNumber2);
    }
}
