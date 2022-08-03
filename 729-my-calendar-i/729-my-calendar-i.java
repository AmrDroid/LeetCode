class MyCalendar {
    class Node {
        int start;
        int end;
        Node left;
        Node right;
        
        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    Node head;
    
    public MyCalendar() {
        head = null;
    }
    
    public boolean book(int start, int end) {
        if(head == null) {
            head = new Node(start, end);
            return true;
        }
        
        return addNode(start,end,head);
    }
    
    private boolean addNode(int start, int end, Node root) {
        if(start >= root.end) {
            if(root.right == null) {
                root.right = new Node(start,end);
                return true;
            }
            return addNode(start,end,root.right);
        } else if(end <= root.start) {
            if(root.left == null) {
                root.left = new Node(start,end);
                return true;
            }
            return addNode(start,end,root.left);
        }
        
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */