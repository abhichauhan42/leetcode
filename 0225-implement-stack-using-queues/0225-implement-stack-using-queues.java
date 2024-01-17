import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    public void push(int x) {
        if (!q1.isEmpty()) {
            q1.add(x);
        } else {
            q2.add(x);
        }
    }

    public int pop() {
        if (empty()) {
            return -1;
        }
        int top = 0; // Initialize top to a default value
        if (!q1.isEmpty()) {
            while (q1.size() > 1) {
                top = q1.remove();
                q2.add(top);
            }
            top = q1.remove();
        } else {
            while (q2.size() > 1) {
                top = q2.remove();
                q1.add(top);
            }
            top = q2.remove();
        }
        return top;
    }

    public int top() {
        if (empty()) {
            return -1;
        }
        int top = 0; // Initialize top to a default value
        if (!q1.isEmpty()) {
            while (!q1.isEmpty()) {
                top = q1.remove();
                q2.add(top);
            }
        } else {
            while (!q2.isEmpty()) {
                top = q2.remove();
                q1.add(top);
            }
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