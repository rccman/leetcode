package com.rencc.leetcode.primary.array;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @title 两个数组的交集 II
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class Array26 {
    /**
     * 双重循环，比对重复，记录已使用过的索引，避免重复比对
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0){
            return new int[0];
        }
        //优化1：确保小的数组在循环的外层
        if(nums1.length>nums2.length){
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        //优化2： 先排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int end = 0;
        //记录重复比对的索引
        boolean[] tmpIndx = new boolean[nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                //判断避免重复比对
                if(tmpIndx[j]){
                    continue;
                }
                // 优化2：已排序，当内层循环的值大于外层，内层就不用再循环了
                if(nums1[i]<nums2[j]){
                    break;
                }
                if(nums1[i] == nums2[j]){
                    nums1[end] = nums1[i];
                    end++;
                    tmpIndx[j] = true;
                    break;
                }
            }
        }
        return Arrays.copyOf(nums1,end);
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2};
        int[] intersect = new Array26().intersect(nums1, nums2);
        System.out.println(Arrays.toString(intersect));
    }
}
