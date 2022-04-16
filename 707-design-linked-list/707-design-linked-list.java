
// Doubly linked list implementation using 2 pointers - "prev" and "next"
class Node {
	Node prev;
	int val;
	Node next;
	
	Node (Node prev, int val, Node next) {
		this.prev = prev;
		this.val = val;
		this.next = next;
	}
}

class MyLinkedList {
	Node head;
	Node tail;
	int length;

    public MyLinkedList() {
    	head = null;
    	tail = null;
    	length = 0;
    }
    
    public int get(int index) {
    	if (index >= length) {
    		return -1;
    	}
    	
    	if (index == 0) {
    		return head.val;
    	}
    	
    	if (index == length - 1) {
    		return tail.val;
    	}
    	
    	if (index < length/2) {
    		int i = 1;
    		Node prev = head;
    		while (i != index) {
    			prev = prev.next;
    			i++;
    		}
    		
        	return prev.next.val;
    	} else {
    		int i = length - 2;
    		Node next = tail;
    		while (i != index) {
    			next = next.prev;
    			i--;
    		}
    		
        	return next.prev.val;
    	}
    }
    
    public void addAtHead(int val) {
    	if (head == null) {
    		head = new Node(null, val, null);
    		tail = head;
    		length++;
    		return;
    	}
    	
    	Node newNode = new Node(null, val, head);
    	head.prev = newNode;
    	head = newNode;
    	length++;
    }
    
    public void addAtTail(int val) {
    	if (head == null) {
    		addAtHead(val);
    		return;
    	}
    	
    	Node newNode = new Node(tail, val, null);
    	tail.next = newNode;
    	tail = tail.next;
    	length++;
    }
    
    public void addAtIndex(int index, int val) {
    	if (index > length) {
    		return;
    	}
    	
    	if (index == 0) {
    		addAtHead(val);
    		return;
    	}
    	
    	if (index == length) {
    		addAtTail(val);
    		return;
    	}
    	
    	if (index < length/2) {
    		int i = 1;
    		Node prev = head;
    		while (i != index) {
    			prev = prev.next;
    			i++;
    		}
    		
    		Node newNode = new Node(prev, val, prev.next);
        	prev.next.prev = newNode;
        	prev.next = newNode;
    	} else {
    		int i = length - 1;
    		Node next = tail;
    		while (i != index) {
    			next = next.prev;
    			i--;
    		}
    		
    		Node newNode = new Node(next.prev, val, next);
        	next.prev.next = newNode;
        	next.prev = newNode;
    	}
    	length++;
    }
        
    public void deleteAtIndex(int index) {
    	if (index >= length) {
    		return;
    	}
    	
    	if (index == 0) {
    		head = head.next;
    		length--;
    		return;
    	}
    	
    	if (index == length - 1) {
    		tail.prev.next = null;
    		tail = tail.prev;
    		length--;
    		return;
    	}
    	
    	if (index < length/2) {
    		int i = 1;
    		Node prev = head;
    		while (i != index) {
    			prev = prev.next;
    			i++;
    		}
    		
        	prev.next = prev.next.next;
        	prev.next.prev = prev;
    	} else {
    		int i = length - 2;
    		Node next = tail;
    		while (i != index) {
    			next = next.prev;
    			i--;
    		}
    		
        	next.prev = next.prev.prev;
        	next.prev.next = next;
    	}
    	length--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */