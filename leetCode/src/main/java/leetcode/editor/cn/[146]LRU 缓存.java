package leetcode.editor.cn;
//请你设计并实现一个满足 LRU (最近最少使用) 缓存 约束的数据结构。 
//
// 实现 LRUCache 类： 
//
// 
// 
// 
// LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 ke
//y-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。 
// 
//
// 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。 
// 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 10000 
// 0 <= value <= 105 
// 最多调用 2 * 105 次 get 和 put 
// 
// Related Topics 设计 哈希表 链表 双向链表 
// 👍 1935 👎 0

import java.util.HashMap;


//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {
    private int capacity;
    private Node first, end;
    public HashMap<Integer, Node> map;

    class Node {
        public int val;
        public Node prv;
        public Node nex;
    }

    public LRUCache(int capacity) {
        map = new HashMap<Integer, Node>(capacity);
        first = new Node();
        end = new Node();
        first.nex = end;
        first.prv = end;
        end.prv = first;
        end.nex = first;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int value = map.get(key).val;
        // 将node放在前面
        put(key, value);
    }

    // 这个可不写
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            addFirst(key);
        } else {
            // 小于容量的放在最前面
            Node node = new Node();
            node.val = value;
            if (map.size() < capacity) {
                map.put(key, node);
                addFirst(key);
            } else {
                delEnd(end.prv);
                map.put(key, node);
                addFirst(key);
            }

        }

    }

    public void delEnd(Node node) {
        node.prv.nex = node.nex;
        node.nex.pre = node.prv;
    }

    private void addFirst(int key) {
        Node n = map.get(key);
        Node next = first.nex;
        first.nex = n;
        n.prev = first;
        n.next = next;
        next.prev = n;
    }


}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

//2022-02-23 13:40:05