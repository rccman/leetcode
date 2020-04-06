package com.rencc.leetcode.primary.linklist;

/**
 * @Description: 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * @Author: renchaochao
 * @Date: 2020/4/6 13:47
 **/
public class LinkList43 {

    public ListNode initListNode (int max,ListNode listNode) {
        if(max <= 0){
            return listNode;
        }
        ListNode newListNode = new ListNode(max);
        newListNode.next = listNode;
        max --;
        return initListNode(max,newListNode);
    }

    public ListNode reverseList(ListNode head) {
        //申请节点，pre和 cur，pre指向null
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;
        while(cur!=null) {
            //记录当前节点的下一个节点
            tmp = cur.next;
            //然后将当前节点指向pre
            cur.next = pre;
            //pre和cur节点都前进一位
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
        LinkList43 linkList43 = new LinkList43();
        ListNode listNode = linkList43.initListNode(5, null);
        System.out.println(listNode.print());
        ListNode reverseListNode = linkList43.reverseList(listNode);
        System.out.println(reverseListNode.print());
    }
}
