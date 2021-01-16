package Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        myStack<Character> st = new myStack<>();
        st.push('1');
        st.push('5');
        st.push('0');
        System.out.println(st.peek());
        System.out.println(st.pop());
        System.out.println(st.peek());
    }
}
