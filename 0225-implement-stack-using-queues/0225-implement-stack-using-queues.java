import java.util.Stack;

class MyStack {

    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public MyStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public void push(int x) {
        if (!s1.isEmpty()) {
            s1.push(x);
        } else {
            s2.push(x);
        }
    }

    public int pop() {
        if (empty()) {
            return -1;
        }
        int top;
        if (!s1.isEmpty()) {
            top = s1.pop();
            if (s1.isEmpty()) {
                while (!s2.isEmpty()) {
                    s1.push(s2.pop());
                }
            }
        } else {
            top = s2.pop();
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
        }
        return top;
    }

    public int top() {
        if (empty()) {
            return -1;
        }
        int top;
        if (!s1.isEmpty()) {
            top = s1.peek();
        } else {
            top = s2.peek();
        }
        return top;
    }
}


/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */