package Queue.LeetCodeProblems;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        int param_2 = obj.pop();
        int param_3 = obj.top();
        boolean param_4 = obj.empty();
        System.out.println("Popped Element: " + param_2);
        System.out.println("Top Element: " + param_3);
        System.out.println("Is the stack empty? " + param_4);
    }
}

// isme push acha hai par pop, top bekar hai
class MyStack {
    Queue<Integer> q = new LinkedList<>();

    public MyStack() {
    }

    public void push(int x) {  //O(1)
        q.add(x);
    }

    public int pop() {   //O(n)
        int size = q.size();
        for (int i = 0; i < size - 1; i++) {
            q.add(q.remove());
        }
        return q.remove();
    }

    public int top() {   // O(n)
        int size = q.size();
        for (int i = 0; i < size - 1; i++) {
            q.add(q.remove());
        }
        int top = q.peek();
        q.add(q.remove());
        return top;
    }

    public boolean empty() {
        return q.isEmpty();
    }
}

// isme push bekar hai aur pop, top acha hai...to ye best hai
class MyStack2 {
    Queue<Integer> q = new LinkedList<>();

    public MyStack2() {

    }

    public void push(int x) {  //O(n)
        if(q.size()==0) q.add(x);
        else {
            q.add(x);
            for(int i = 0; i<q.size()-1; i++){
                q.add(q.remove());
            }
        }
    }

    public int pop() {  //O(1)
        return q.remove();
    }

    public int top() {  //O(1)
        return q.peek();
    }

    public boolean empty() {
        if(q.size()==0) return true;
        else return false;
    }
}