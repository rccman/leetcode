package com.rencc.leetcode.primary.linklist;

public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

      public String print(){
            String str = this.val + "->";
            if(this.next == null){
                  str+= "null";
            }else{
                  str+=this.next.print();
            }
            return str;
      }
}