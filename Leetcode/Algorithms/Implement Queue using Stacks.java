/* Problem: Implement Queue using Stacks
 * use only standard operations of a stack:
 * push to top, peek/pop from top, size, and isEmpty operations.
 * assume that all operations are valid 
 * (for example, no pop or peek operations will be called on an empty queue).
 */



import java.util.Stack;

class MyQueue {
	Stack<Integer> sk = new Stack<Integer>();

	// Push element x to the back of queue.

	public void push(int x) {
		if (sk.isEmpty())
			sk.push(x);
		else {
			Stack<Integer> tmp = new Stack<Integer>();
			for (int i = 0; i <= sk.size(); i++) {
				int temp = sk.pop();
				System.out.println(temp);
				tmp.push(temp);
			}
			sk.push(x);
			for (int i = 0; i <= tmp.size(); i++) {
				sk.push(tmp.pop());
			}
		}
	}

	// Removes the element from in front of queue.
	public void pop() {
		sk.pop();
	}

	// Get the front element.
	public int peek() {
		return sk.peek();
	}

	// Return whether the queue is empty.
	public boolean empty() {
		return sk.isEmpty();
	}

}