import java.util.Stack;

/**
 * @author pkc
 * @description 带有最小值功能的栈
 * @date 2020/5/23 19:20
 */
public class MinStack {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        /*先插入最小栈，再插入 数据栈*/
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
        dataStack.push(x);
    }

    public void pop() {
        if (dataStack.isEmpty()) {
            return;
        }
        Integer peek = dataStack.peek();
        dataStack.pop();
        if (peek <= minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
