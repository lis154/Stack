package com.company;

public class Stack {

    private int maxSize;
    private int[] stack;
    private int head;


    public Stack(int size) {
        this.maxSize = size;
        this.stack = new int[size];
        this.head = -1;

    }

    public boolean isEmpty(){
        return head == -1;
    }

    public boolean isFull(){
        return head == maxSize-1;
    }

    public boolean push(int value)
    {
        if (isFull()) return false;
        stack[++head] = value;
        return true;
    }

    public int pop()
    {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return stack[head--];
    }

    public int peek()
    {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return stack[head];
    }

    public String reverse() // обратная строка
    {
        String new_str="";
        for (int i = 0; i < stack.length; i++) {
            new_str = new_str + (char)pop();
        }
        return new_str;
    }

    public static void main(String[] args) {
	String s = "123456789";
        Stack stack = new Stack(s.length());
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        System.out.println(s);
        String str = stack.reverse();
        System.out.println(str); // обратная строка
        //Brackets.check(s);
    }
}
