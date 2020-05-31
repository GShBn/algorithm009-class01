package com.test.leetcode.editor.cn;

//给定一个二叉树，返回它的 前序 遍历。
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
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树


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
class Solution144 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);

        root.right = a;
        a.left = b;

        preorderTraversal(root);

    }

    public static List<Integer> preorderTraversal(TreeNode root) {

        //迭代
        List<Integer> output = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) {
            return output;
        }

        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            output.add(treeNode.val);
            if (treeNode.right != null) {
                stack.add(treeNode.right);
            }

            if (treeNode.left != null) {
                stack.add(treeNode.left);
            }
        }

        return output;

        //递归
//        List<Integer> list = new ArrayList<>();
//        deal(root, list);
//        return list;

        //颜色标记法
//        List<Integer> list = new ArrayList<>();
//        Stack<ColorNode> stack = new Stack<>();
//
//        stack.add(new ColorNode(root, "WHITE"));
//
//        while (!stack.empty()) {
//            ColorNode colorNode = stack.pop();
//            if (colorNode.color != "WHITE") {
//                if (colorNode.node.right != null) {
//                    stack.push(new ColorNode(colorNode.node.right, "WHITE"));
//                }
//                if (colorNode.node.left != null) {
//                    stack.push(new ColorNode(colorNode.node.left, "WHITE"));
//                }
//                stack.push(new ColorNode(colorNode.node, "GARY"));
//            }else {
//                list.add(colorNode.node.val);
//            }
//        }
//
//        return list;
    }

    class ColorNode {
        TreeNode node;
        String color;

        public ColorNode(TreeNode node, String color) {
            this.node = node;
            this.color = color;
        }
    }

    public void deal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        list.add(node.val);
        deal(node.left, list);
        deal(node.right, list);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
