package Algorithm.Nowcoder.JZ;

public class JZ25 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

//        @Override
//        public String toString() {
//            StringBuilder builder = new StringBuilder();
//            builder.append("{").append(val);
//            while (next != null) {
//                ListNode next1 = next;
//                builder.append(",").append(next1.val);
//            }
//            builder.append("}");
//            return builder.toString();
//        }
    }

    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode node1 = list1;
        ListNode node2 = list2;
        ListNode result;
        if (node1.val < node2.val) {
            result = new ListNode(node1.val);
            node1 = node1.next;
        } else {
            result = new ListNode(node2.val);
            node2 = node2.next;
        }
        ListNode t = result;
        while (node1 != null && node2 != null) {
            ListNode newNode;
            if (node1.val < node2.val) {
                newNode = new ListNode(node1.val);
                node1 = node1.next;
            } else {
                newNode = new ListNode(node2.val);
                node2 = node2.next;
            }
            t.next = newNode;
            t = t.next;
        }
        while (node1 != null) {
            t.next = new ListNode(node1.val);
            t = t.next;
            node1 = node1.next;
        }

        while (node2 != null) {
            t.next = new ListNode(node2.val);
            t = t.next;
            node2 = node2.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode3;
        listNode3.next = listNode5;

        ListNode listNode2 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode6 = new ListNode(6);
        listNode2.next = listNode4;
        listNode4.next = listNode6;

        ListNode merge = Merge(listNode1, listNode2);
        System.out.println(merge.toString());
    }

}
