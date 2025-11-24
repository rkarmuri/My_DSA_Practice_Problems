import java.util.Stack;
public class MinimumStackEncode {
    private Stack<Integer> st;
    private int mini;
    public MinimumStackEncode() {
        st = new Stack<>();
    }

    public void push(int val) {
      if(st.isEmpty()){
        mini = val;
        st.push(val);
        return;
      }
      if(val > mini){
        st.push(val);
      } else {
        st.push(2*val - mini);
        mini = val;
      }
    }

    public void pop() {
      if(st.isEmpty())  return;

      int x = st.pop();
      if(x < mini){
        mini = 2*mini - x;
      }
    }

    public int top() {
      if(st.isEmpty())  return -1;
      int x = st.peek();

      if(mini < x)  return x;
      return mini;
    }

    public int getMin() {
        return mini;
    }

    public static void main(String[] args) {
        MinimumStackEncode minStack = new MinimumStackEncode();
        minStack.push(3);
        minStack.push(5);
        System.out.println("Current Min: " + minStack.getMin()); // Returns 3
        minStack.push(2);
        minStack.push(1);
        System.out.println("Current Min: " + minStack.getMin()); // Returns 1
        minStack.pop();
        System.out.println("Current Min: " + minStack.getMin()); // Returns 2
        minStack.pop();
        System.out.println("Current Min: " + minStack.getMin()); // Returns 3
    }
}
