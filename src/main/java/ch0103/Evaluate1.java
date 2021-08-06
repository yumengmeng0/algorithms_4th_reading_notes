package ch0103;

import ch01.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author: ymm
 * @date: 2021/6/28
 * @version: 1.0.0
 * @description: Duijkstra的双栈算数求职算法
 */
public class Evaluate1 {

    // ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )
    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>(); // 运算符栈
        Stack<Double> vals = new Stack<Double>(); // 数字栈

        String s1 = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        char[] chars = s1.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            String s = String.valueOf(chars[i]);
            if (s.equals(" ")) continue;

            if (s.equals("(")) ;
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals("sqrt")) ops.push(s);
            else if (s.equals(")")) {
                // 如果字符为")"，弹出运算符和操作数，计算结果并压入栈
                String op = ops.pop();
                Double v = vals.pop();
                if (op.equals("+")) v = vals.pop() + v;
                else if (op.equals("+")) v = vals.pop() + v;
                else if (op.equals("-")) v = vals.pop() - v;
                else if (op.equals("*")) v = vals.pop() * v;
                else if (op.equals("/")) v = vals.pop() / v;
                else if (op.equals("sqrt")) v = Math.sqrt(v);
                vals.push(v);
            }// 如果字符既非运算符也不是括号，将它作为double值压入栈
            else {
                vals.push(Double.parseDouble(s));
            }
        }

        StdOut.println(vals.pop());
    }

}
