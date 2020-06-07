package com.test.leetcode.editor.cn;

//给定一个可包含重复数字的序列，返回所有不重复的全排列。
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution47 {
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        deal(nums, new boolean[nums.length], new LinkedList<>(),);
        return lists;
    }

    public void deal(int[] nums, boolean[] bool, LinkedList<Integer> list) {
        if (list.size() == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //其次，我们已经选择过的不需要再放进去了
            if(bool[i]) continue;
            //接下来，如果当前节点与他的前一个节点一样，并其他的前一个节点已经被遍历过了，那我们也就不需要了。
            if(i>0 && nums[i] == nums[i-1] && bool[i-1]) break;
            //做出选择
            list.add(nums[i]);
            bool[i] = true;
            deal(nums,bool,list);
            //撤销选择
            list.removeLast();
            bool[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
