import java.util.Stack;

public class Evaluator {
	public int getPriority(char c) {
		if (c == '+' || c == '-') {
			return 1;
		}
		else {
			return 2;
		}
	}

	public double InfixToPostFix(String infix) {
		Stack<Character> operator = new Stack<Character>();
		Stack<Double> operand = new Stack<Double>();
 		String postfix = "";
		for (int i=0; i < infix.length(); i++) {
			char c = infix.charAt(i);
			if (Character.isDigit(c)) {
				String value = "";
				while (i < infix.length()) {
					if (Character.isDigit(infix.charAt(i)) || infix.charAt(i) == '.') {
						value += infix.charAt(i++);
					}
					else {
						break;
					}
					
				}
				i--;
				operand.push(Double.parseDouble(value));
			} 
			else if (c == '(') {
				operator.push(c);
			} 
			else if (c == '+' || c == '-' || c == '*' || c == '/') {
				if (operator.isEmpty()) {
					operator.push(c);
				} 
				else if (operator.peek() == '('){
					operator.push(c);
				} 
				else if (getPriority(operator.peek()) >= getPriority(c)) {
					char op = operator.pop();
					double num2 = operand.pop();
					double num1 = operand.pop();
					double value = evaluate(num1, num2, op);
					operand.push(value);
					operator.push(c);
				} 
				else {
					operator.push(c);
				}
					
			}
			else if (c ==')') {
				while (operator.peek() != '(') {
					char op = operator.pop();
					double num2 = operand.pop();
					double num1 = operand.pop();
					double value = evaluate(num1, num2, op);
					operand.push(value);
				}
				operator.pop();
			}
		}
			
		while (!operator.isEmpty()) {
			char op = operator.pop();
			double num2 = operand.pop();
			double num1 = operand.pop();
			double value = evaluate(num1, num2, op);
			operand.push(value);
		}
		
		return operand.pop();
	}
	
	public double evaluate(double num1, double num2, char op) {
		double result = 0;
		switch(op) {
		case '+':
			result =  num1 + num2;
			break;
		case '-':
			result = num1 - num2;
			break;
		case '*':
			result = num1 * num2;
			break;
		case '/':
			if (num2 == 0) {
				return 0;
			}
			else {
			result = num1 / num2;
			}
			break;
		default:
			result = 0;
		}
		return result;
	}
}
