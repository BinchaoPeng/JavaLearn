package leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * <p>
 * 用两个栈实现一个队列。
 * 队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead操作返回 -1 )
 */
class CQueue {
    /**
     * 思路：
     * 入队：每次入队操作就是，从栈1入栈
     * 出队：每次出队操作就是，清空栈1，并一次入栈2，再pop一个元素
     * 要注意到的是，因为stack2如果还有元素，此时出队操作直接在stack2上执行出栈操作，知道stack2清空了后才可以再把stack1的放进stack2
     * 判断队列为空就是，
     *
     */

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        this.stack1.add(value);
        //不是进一次就pop再add到stack2，而是等到出队的时候一次性pop
        //this.stack1.pop();
        //this.stack2.add(value);
    }

    public int deleteHead() {

        //stack2d没有元素时入栈
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                int pop = stack1.pop();
                stack2.add(pop);
            }
        }

        //如果入栈后还是没元素，那说明队列空了
        if (stack2.isEmpty()){
            return -1;
        }
        return this.stack2.pop();
    }

    public static void main(String[] args) {
        CQueue cq = new CQueue();
        cq.appendTail(3);
        System.out.println(Arrays.toString(cq.stack1.toArray()));
        System.out.println(cq.deleteHead());
        System.out.println(cq.deleteHead());
        System.out.println(cq.deleteHead());
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */