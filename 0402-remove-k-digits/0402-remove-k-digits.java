class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        
        // Monotonous Stack
        int i = 0, n = num.length();
        while (i < n) {
            char c = num.charAt(i++);
            while (k > 0 && !stack.isEmpty() && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        
        // handle coner case when all digits are equal: 33333, that k never decreases
        while (k-- > 0) stack.pop();
        
        // Output:
        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty()) sb.append(stack.pop());
        sb.reverse();
        while(sb.length() > 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
