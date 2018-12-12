package com.yjx.leetcode;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AddTwoNumbers {
    public static void main(String[] args) {
        System.out.println(14 % 10);
        Solution solution = new Solution();
        ListNode first = new ListNode(2);
        first.next = new ListNode(4);
        first.next.next = new ListNode(3);
        ListNode second = new ListNode(5);
        second.next = new ListNode(6);
        second.next.next = new ListNode(4);
        ListNode result = solution.addTwoNumbers(first, second);
//        log.info("{} {} {}", result.val, result.next.val, result.next.next.val);
        log.info("{}", JSON.toJSONString(result));
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);//最终结果,起始占位节点
        //初始化当前节点
        ListNode cl1 = l1;
        ListNode cl2 = l2;
        ListNode cresult = result;
        int carry = 0;//进位
        while (cl1 != null || cl2 != null) {
            int cl1val = 0;
            if (cl1 != null) {
                cl1val = cl1.val;
            }
            int cl2val = 0;
            if (cl2 != null) {
                cl2val = cl2.val;
            }
            int sum = carry + cl1val + cl2val;
            carry = sum / 10;//带入下一位的值
//            cresult.next = new ListNode(sum % 10);//当前位的值
//            cresult = cresult.next;
            cresult.val = sum % 10;
            if ((cl1 != null && cl1.next != null) || (cl2 != null && cl2.next != null)) {
                cresult.next = new ListNode(cresult.val);
                cresult = cresult.next;
            }
            if (cl1 != null) {
                cl1 = cl1.next;
            }

            if (cl2 != null) {
                cl2 = cl2.next;
            }
        }
        if (carry > 0) {
            cresult.next = new ListNode(carry);
        }
        return result;
    }
}

@Data
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
