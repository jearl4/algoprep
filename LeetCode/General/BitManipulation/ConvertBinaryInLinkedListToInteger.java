package LeetCode.General.BitManipulation;

import Educative.FastAndSlowPointers.DTO.ListNodeDTO;

class ConvertBinaryInLinkedListToInteger{
    public int getDecimalValue(ListNodeDTO head) {
        int num = head.value;
        
        while(head.next != null){
            num = (num << 1) | head.next.value;
            head = head.next;
        }
        
        return num;
    }
}