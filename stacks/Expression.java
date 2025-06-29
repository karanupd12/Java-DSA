package stacks;

import java.util.Stack;

/* program to solve basic arithmetic expression using dijkstra two stack algorithm - will only work for two operands separated by an operators completely wrapped around by parenthesis */
public class Expression {
    public static double solve(String str){
        Stack<Character> operators = new Stack<>();
        Stack<Double> operands = new Stack<>();
        for (char c : str.toCharArray()){
            if(c == '(');
            else if(c == '+' || c == '-' || c == '*' || c == '/') 
                operators.push(c);
            else if(c == ')'){
                double val = operands.pop();
                char op = operators.pop();
                if(op == '+') val = operands.pop() + val;
                else if(op == '-') val = operands.pop() - val;
                else if(op == '*') val = operands.pop() * val;
                else if(op == '/') val = operands.pop() / val;
                operands.push(val);
            }
            else operands.push(Double.parseDouble(Character.toString(c)));
        }
        return operands.pop();
    }
    public static void main(String[] args) {
        String str = "(1+((2/3)*(4*5)))";   
        double ans = solve(str);
        System.out.println(ans);
    }
    
}