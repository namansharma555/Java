package main.java;



public class AddTwoLinkedList {

	public static class ListNode {

		int val;
		ListNode next;

		public ListNode(int data) {
			this.val = data;
			this.next = null;
		}

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode dummy = new ListNode(0);
		ListNode p = l1;
		ListNode q = l2;
		ListNode current = dummy;
		int carry = 0;

		while (p != null || q != null) {
			int x = p != null ? p.val : 0;
			int y = q != null ? q.val : 0;
			int sum = x + y + carry;

			int mod = sum % 10;
			carry = sum / 10;
			current.next = new ListNode(mod);
			current = current.next;
			if (p != null) {
				p = p.next;
			}
			if (q != null) {
				q = q.next;
			}
		}

		if (carry > 0) {
			current.next = new ListNode(carry);
		}

		return dummy.next;

	}
	
	public void printList(ListNode list) {
		ListNode current = list;
		while(current!=null) {
			System.out.println(current.val);
			current = current.next;
		}
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		AddTwoLinkedList adl = new AddTwoLinkedList();
		ListNode res = adl.addTwoNumbers(l1, l2);
		
		adl.printList(res);

	}

}
