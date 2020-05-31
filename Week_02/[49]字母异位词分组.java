package com.test.leetcode.editor.cn;

//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        //时间复杂度：n
        //把排序去掉了
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = new char[26];
            for (char c : s.toCharArray()) chars[c - 'a']++;

//            char[] chars = s.toCharArray();
//            Arrays.sort(chars);

            String value = String.valueOf(chars);
            if (!map.containsKey(value)) {
                map.put(value, new ArrayList<>());
            }
            map.get(value).add(s);
        }

        return new ArrayList(map.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
