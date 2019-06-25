package com.rencc.leetcode.primary.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 存在重复
 *
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class Array24 {
    /**
     * 利用排序
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        if(nums.length<2){
            return false;
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }

    /**
     * 利用Set去重（效率低）
     * @param nums
     * @return
     */
    public boolean containsDuplicate2(int[] nums) {
        if(nums.length<2){
            return false;
        }
        Set<Integer> res = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            res.add(nums[i]);
        }
        return res.size()<nums.length?true:false;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        boolean duplicate = new Array24().containsDuplicate(nums);
        boolean duplicate2 = new Array24().containsDuplicate2(nums);
        System.out.println(duplicate);
        System.out.println(duplicate2);
    }
}
