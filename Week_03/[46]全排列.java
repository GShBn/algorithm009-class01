package com.test.leetcode.editor.cn;

//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        deal(nums, 0, new LinkedList<>());
        return lists;
    }

    public void deal(int[] nums, int level, LinkedList<Integer> list) {

        //判断条件
        if (level == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }

            //这层逻辑
            list.add(nums[i]);
            //进入下一层
            deal(nums, level + 1, list);
            //取消选择
            list.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
