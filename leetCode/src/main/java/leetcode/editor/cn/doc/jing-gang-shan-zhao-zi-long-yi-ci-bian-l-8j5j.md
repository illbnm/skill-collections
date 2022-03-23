![【井冈山赵子龙】.png](https://pic.leetcode-cn.com/1645188861-Vihkiy-%E3%80%90%E4%BA%95%E5%86%88%E5%B1%B1%E8%B5%B5%E5%AD%90%E9%BE%99%E3%80%91.png)

### 解题思路
![image.png](https://pic.leetcode-cn.com/1645189031-XVLIaM-image.png)

### 一句话讲明白:
 两个指针沿着链表移动, second指向first
### 代码

```java
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;

        ListNode first = null;
        ListNode second = head;
        while (second != null)  {
            ListNode nex = second.next;//保存second的下一节点, 防止丢失
            second.next = first; 
            first = second;
            second = nex;
        }
        return first; // 循环完毕first指向尾节点, second指向null
    }
}
```
时间复杂度: O(N)
空间复杂度: O(1)