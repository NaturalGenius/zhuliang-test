package com.example.demo.calculate;


public class DoublePointerDay05 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode listNode = new ListNode(2);
        head.next = listNode;
        ListNode removeNthFromEnd = removeNthFromEnd(head, 1);
        while (removeNthFromEnd != null) {
            System.out.println(removeNthFromEnd.val);
            removeNthFromEnd = removeNthFromEnd.next;
        }
        for (int i = 3; i <= 5; i++) {
            ListNode next = new ListNode(i);
            listNode.next = next;
            listNode = next;
        }
        System.out.println(middleNode(head).val);
       
        System.out.println();
        listNode.next = new ListNode(6);
        System.out.println(middleNode(head).val);
    }

    /**
     * 876. 链表的中间结点 
     * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
     * 
     * 如果有两个中间结点，则返回第二个中间结点。
     * 
     * 
     * 
     * 示例 1：
     * 
     * 输入：[1,2,3,4,5] 输出：此列表中的结点 3 (序列化形式：[3,4,5]) 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。 注意，我们返回了一个 ListNode 类型的对象
     * ans，这样： ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL. 示例 2：
     * 
     * 输入：[1,2,3,4,5,6] 输出：此列表中的结点 4 (序列化形式：[4,5,6]) 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
     */

    public static ListNode middleNode(ListNode head) {
        ListNode slowHead = head;
        while (true) {
           ListNode next = head.next;
           if (next == null) {
             return slowHead;
           }
           head = next.next;
           if (head == null) {
               return slowHead.next;
           }
           slowHead = slowHead.next;
        }
    }

    /**
     * 19. 删除链表的倒数第 N 个结点
给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

进阶：你能尝试使用一趟扫描实现吗？

 

示例 1：


输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]
示例 2：

输入：head = [1], n = 1
输出：[]
示例 3：

输入：head = [1,2], n = 1
输出：[1]
 
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
      /**
       * 使用两个指针 快指针先走n
       * 然后两个指针同步走 等快指针走到结尾的时候 慢指针刚好是删除的那个节点
       */
        ListNode faster = head;
        ListNode slow = head;
        ListNode slowPre = head;
        for (int i = 0; i < n; i++) {
            faster = faster.next;
        }
        while (true) {
            if (faster == null) {
                slowPre.next = slow.next;
                if (head == slow) {
                    return head.next;
                }
                return head;
            }
            faster = faster.next;
            slowPre = slow;
            slow = slow.next;
        }
    }
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
