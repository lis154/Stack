package com.company.queue;

/**
 * Created by i.lapshinov on 27.05.2018.
 */
public class Dek {
    private int maxSize;
    private int[] queue;
    private int head; // указатель на голову
    private int tail; // указатель на хвост
    private int items; // текущая наполнение

    public Dek(int size) {
        this.maxSize = size;
        queue = new int[size];
        head = 0;// указатель на голову
        tail = -1;// указатель на хвост
        items = 0;// текущая наполнение
    }

    public boolean isEmpty(){
        return items == 0;
    }

    public boolean isFull(){
        return items == maxSize;
    }

    public int size(){
        return items;
    }

    public void insert_right(int i)
    {
        if (isFull())
        {
            maxSize *= 2;
            int[] temp = new int[maxSize];
            if (tail >= head){
                System.arraycopy(queue, 0, temp, 0, queue.length); // копируем в новый больший массив
            }
            else{
                System.arraycopy(queue, 0, temp, 0, tail + 1);
                System.arraycopy(queue, head, temp,maxSize-(queue.length-head),queue.length - head); // копируем между головой и хвостом
                head = maxSize - head -1;
            }
            queue = temp;


        }
        if (tail == maxSize - 1) // цикличность если массив не полон
            tail = -1;
        queue[++tail] = i;
        items++;

    }

    public int remove_right(){
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        int temp = queue[head++];

        if (head == maxSize)
            head = 0;
        items--;
        return temp;
    }

    public void insert_left(int i)
    {
        if (!isFull())
        {
            if (head == 0 ) // если не полный и первый элемент в 0
            {
              //  System.arraycopy(queue, 0, queue, 1, tail);
              //  queue[head] = i;
                head = maxSize-1;
                queue[head] = i;
                items++;

            }
            else
                queue[--head] = i;
                items++;
        }
        else
        {
            int[] temp = new int[maxSize*2];
            if (head < tail)
            {

                //System.arraycopy(queue, 0, temp, 1, tail); // копирование массива на 1 вправо
               // temp[head] = i;
                head = maxSize-1;
                queue[head] = i;
                items++;

            }
            if (head > tail)
            {
                System.arraycopy(queue,0,temp,0,tail);
                System.arraycopy(queue, head, temp,maxSize-(queue.length-head),queue.length - head);
                temp[--head] = i;// копируем между головой и хвостом
                items++;
                queue = temp;

            }

        }
    }

    public int remove_left(){
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        int temp = queue[tail--];

        if (tail == 0)
            tail = -1;
        items--;
        return temp;
    }

    public int peek(){
        return queue[head];
    }
}
