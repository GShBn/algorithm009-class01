## 学习笔记

### Hash table

```
哈希表（Hash table），也叫散列表，是根据关键码值（Keyvalue）而直接进行访问的数据结构。它通过把关键码值映射到表中一个位置来访问记录，以加快查找的速度。这个映射函数叫作散列函数（Hash Function），存放记录的数组叫作哈希表（或散列表）。

• Map：key-value对，key不重复- new HashMap() / new TreeMap()- map.set(key, value)- map.get(key)- map.has(key)- map.size()- map.clear()• Set：不重复元素的集合- new HashSet() / new TreeSet()- set.add(value)- set.delete(value)- set.hash(value)
```

### 二叉树遍历

```
1.前序（Pre-order）：根-左-右2.中序（In-order）：左-根-右3.后序（Post-order）：左-右-根
```

#### 二叉搜索树

```
二叉搜索树，也称二叉搜索树、有序二叉树（Ordered Binary Tree）、排序二叉树（Sorted Binary Tree），是指一棵空树或者具有下列性质的二叉树：1. 左子树上所有结点的值均小于它的根结点的值；2. 右子树上所有结点的值均大于它的根结点的值；3. 以此类推：左、右子树也分别为二叉查找树。 （这就是 重复性！）
```

### Heap

```
可以迅速查询查找一堆数中的最大最小值的数据结构
```
