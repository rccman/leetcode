package com.rencc.leetcode.primary.array;

import java.util.Arrays;

/**
 * @title 移动零
 *
 *给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 */
public class Array28 {
    public void moveZeroes(int[] nums) {
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                for (int j = i+tmp; j < nums.length; j++) {
                    if(nums[j]!=0){
                        nums[i] = nums[j];
                        nums[j] = 0;
                        tmp = j-i;
                        break;
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,0,0,7,3,0,0,0,5};
        new Array28().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
