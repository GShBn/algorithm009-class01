package com.test.leetcode.editor.cn;

//根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//    3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return deal(preorder, inorder, 0, preorder.length, 0, inorder.length, map);
    }

    public TreeNode deal(int[] preorder, int[] inorder,
                         int preLeft, int preRight, int inLeft, int inRight,
                         HashMap<Integer, Integer> map) {
        if (preLeft == preRight) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preLeft]);
        int inRootVal = map.get(preorder[preLeft]);

        int leftNum = inRootVal - inLeft;

        TreeNode left = deal(preorder, inorder, preLeft + 1, preLeft + leftNum + 1, inLeft, inRootVal, map);
        TreeNode right = deal(preorder, inorder, preLeft + leftNum + 1, preRight , inRootVal + 1, inRight, map);

        root.left = left;
        root.right = right;

        return root;
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
