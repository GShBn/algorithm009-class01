package com.test.leetcode.editor.cn;

//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法


import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

        // 特判
        if (n <= 0 || k <= 0 || n < k) {
            return lists;
        }

        deal(n, k, 1, new Stack<>());
        return lists;
    }

    public void deal(int n, int k, int begin, Stack<Integer> stack) {

        if (k == 0) {
            lists.add(new ArrayList<>(stack));
            return;
        }

        for (int i = begin; i <= n; i++) {
            stack.add(i);
            deal(n,k-1, i+1, stack);
            stack.pop();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
