class MyQueue {
    Stack<Integer> st;

    public MyQueue() {
        st = new Stack<>();
    }

    public void push(int x) {
        if (empty()) {
            st.push(x);
            return;
        }
        int item = st.pop();
        push(x);
        st.push(item);
    }

    public int pop() {
        if (empty())
            return -1;
        return st.pop();
    }

    public int peek() {
        if (empty())
            return -1;
        return st.peek();

    }

    public boolean empty() {
        return st.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */