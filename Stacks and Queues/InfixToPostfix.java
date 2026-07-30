/*
Pattern: Infix to Postfix — Operator Stack

Time: O(n)
Space: O(n)

Idea:
Append operands directly to the output.
Use a stack for operators and parentheses.

For an operator:
- Pop higher-precedence operators.
- On equal precedence, pop for left-associative operators.
- '^' is right-associative, so equal '^' is not popped.

For ')', pop until '(' and discard the brackets.
Finally, pop all remaining operators.
*/

class Solution {
	public static int precedance(char ch) {
		switch (ch) {
			case '^':
			return 3;
			case '*':
			return 2;
			case '/':
			return 2;
			case '+':
			return 1;
			case '-':
			return 1;
		}
		return -1;
	}
	public static String infixToPostfix(String s) {
		StringBuilder sb = new StringBuilder();
		Stack<Character> st = new Stack<>();
		for (int i = 0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if(Character.isLetterOrDigit(ch)){
			    sb.append(ch);
			    continue;
			}
			else if(ch=='('){
			    st.push(ch);
			    continue;
			}
			else if(ch==')'){
			    while(st.peek()!='('){
			        sb.append(st.pop());
			    }
			    st.pop();
			    continue;
			}
			else if (!st.isEmpty()) {
			    int x = precedance(ch);
				int y = precedance(st.peek());
				while((x<y) || ((x==y && ch!='^'))) {
					sb.append(st.pop());
					if(!st.isEmpty()){
					    y=precedance(st.peek());
					}
					else{
					    break;
					}
				}
			}
			st.push(ch);
		}
		while(!st.isEmpty()){
		    sb.append(st.pop());
		}
		return sb.toString();
	}
}
