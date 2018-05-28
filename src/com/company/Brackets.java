package com.company;

/**
 * Created by i.lapshinov on 26.05.2018.
 */
public class Brackets {
    private static void error (char ch, int i)
    {
        System.out.println(String.format("Error: %c at %d", ch, i));
    }
    public static void check (String input)
    {
        int size = input.length();
        Stack st = new Stack(size);

        for (int i = 0; i < size; i++) {
            char ch = input.charAt(i);

            if (ch == '[' || ch == '{' || ch == '<' || ch == '(')
                st.push(ch);
            else if (ch == ']' || ch == '}' || ch == '>' || ch == ')')
            {
                if (st.isEmpty()){
                    error(ch, i);
                    break;
                }

                char c = (char) st.pop();
                if (!((c == '[' && ch == ']') ||
                        (c == '{' && ch == '}') ||
                        (c == '<' && ch == '>') ||
                        (c == '(' && ch == ')'))){
                    error(ch,i);
                    return;
                }
            }
        }
        if (!st.isEmpty()) error((char)st.peek(), size-1);
    }
}
