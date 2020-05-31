package com.test.leetcode.editor.cn;

//给定一个二叉树，返回它的中序 遍历。
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        //递归
        //时间复杂度 n
//        List<Integer> list = new ArrayList<>();
//        deal(root, list);
//        return list;

        //迭代
//        List<Integer> list = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//
//        TreeNode cur = root;
//        while (cur != null || !stack.isEmpty()) {
//            while (cur != null) {
//                stack.add(cur);
//                cur = root.left;
//            }
//
//            cur = stack.pop();
//            list.add(cur.val);
//            cur = cur.right;
//        }
//        return list;

        //颜色标记法
        if(root == null) {
            return new ArrayList<Integer>();
        }

        List<Integer> list = new ArrayList<>();
        Stack<ColorNode> colorNodes = new Stack<>();

        colorNodes.add(new ColorNode(root, "WHITE"));

        while (!colorNodes.empty()) {

            ColorNode colorNode = colorNodes.pop();

            if (colorNode.color == "WHITE") {
                if (colorNode.node.right != null) {
                    colorNodes.push(new ColorNode(colorNode.node.right, "WHITE"));
                }
                colorNodes.push(new ColorNode(colorNode.node, "GRAY"));
                if (colorNode.node.left != null) {
                    colorNodes.push(new ColorNode(colorNode.node.left, "WHITE"));
                }
            }else {
                list.add(colorNode.node.val);
            }
        }

        return list;
    }

    class ColorNode {
        TreeNode node;
        String color;

        public ColorNode(TreeNode node,String color){
            this.node = node;
            this.color = color;
        }
    }

    public void deal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        deal(node.left, list);
        list.add(node.val);
        deal(node.right, list);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
