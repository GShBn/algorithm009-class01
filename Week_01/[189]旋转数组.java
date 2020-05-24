package com.test.leetcode.editor.cn;

//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
//
// 示例 1: 
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 说明: 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 要求使用空间复杂度为 O(1) 的 原地 算法。 
// 
// Related Topics 数组


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        rotate(nums, 3);
    }

    public static void rotate(int[] nums, int k) {
        //暴力解法
        //时间复杂度：n^2
        //空间复杂度：1
//        int tmp, pre;
//        for (int i = 0; i < k; i++) {
//            pre = nums[nums.length - 1];
//            for (int j = 0; j < nums.length; j++) {
//                tmp = nums[j];
//                nums[j] = pre;
//                pre = tmp;
//            }
//        }

        //使用额外数组
        //时间复杂度：n
        //空间复杂度：1
//        int[] tmp = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            tmp[(i + k) % nums.length] = nums[i];
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = tmp[i];
//        }

        //使用环状替换
        int len = nums.length;
        k = k % len;
        int count = 0;         // 记录交换位置的次数，n个同学一共需要换n次
        for (int i = 0; count < len; i++) {
            int cur = i;       // 从0位置开始换位子
            int pre = nums[cur];
            do {
                int next = (cur + k) % len;
                int temp = nums[next];    // 来到角落...
                nums[next] = pre;
                pre = temp;
                cur = next;
                count++;
            } while (i != cur);     // 循环暂停，回到起始位置，角落无人
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
