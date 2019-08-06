package com.rencc.leetcode.primary.linklist;

/**
 * @Description:删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 * @Author: renchaochao
 * @Date: 2019/8/3 13:42
 **/
public class LinkList42 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmpListNode = new ListNode(0);
        tmpListNode.next = head;
        ListNode first = head;
        int length = 0;
        while (first!=null){
            length++;
            first = first.next;
        }
        length = length-n;
        first = tmpListNode;
        for (int i = 0; i < length; i++) {
            first = first.next;
        }
        first.next = first.next.next;
        return tmpListNode.next;
    }
}
