package com.company;

import com.company.queue.PriorityQ;

/**
 * Created by i.lapshinov on 27.05.2018.
 */
public class PriorityQueue {
    private int maxSize;
    private PriorityQ[] queue;
    private int head; // указатель на голову
    private int tail; // указатель на хвост
    private int items; // текущая наполнение

    public PriorityQueue(int size) {
        this.maxSize = size;
        queue = new PriorityQ[size];
        head = 0;
        tail = -1;
        items = 0;
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

    public void insert(PriorityQ elem)
    {
        if (!(isFull()))
        {
            if (head < tail) // копируем элементы с большим приоритетом вправо
            {
                for (int i = head; i <= tail; i++)
                {
                    if(elem.getPriority() > queue[i].getPriority())
                    {
                        if (tail != maxSize -1) { // если tail последний элемент в массиве
                            System.arraycopy(queue, i, queue, i + 1, tail - i);
                            queue[i] = elem;
                            items++;
                            break;
                        }
                        else
                        {
                            queue[0] = queue[maxSize-1];
                            System.arraycopy(queue, i, queue,i+1, tail-i);
                            queue[i] = elem;
                            break;
                        }
                    }
                }
            }
            else // если tail < head
            {
                boolean st = false;
                for (int i = head; i < maxSize; i++) // поиск от head до maxSize
                {
                    if (elem.getPriority() > queue[i].getPriority())
                    {
                        System.arraycopy(queue, head, queue, head-1, head-i);
                        queue[i] = elem;
                        items++;
                        st = true;
                        break;
                    }
                }
                if (st == false)
                {
                    for (int i = 0; i < tail; i++) // поиск от 0 до tail
                    {
                        if (elem.getPriority() > queue[i].getPriority())
                        {
                            System.arraycopy(queue, i, queue, i+1, tail-i);
                            queue[i] = elem;
                            items++;
                            break;
                        }
                    }
                }

            }
        }
        else
        {
            PriorityQ[] temp = new PriorityQ[maxSize*2];
            if (head < tail)
            {
                for (int i = head; i <= tail; i++)
                {
                    if(elem.getPriority() < queue[i].getPriority())
                    {
                        System.arraycopy(queue, 0, temp, 0 ,i-1); //  копируем новый массив и добавляем элемент
                        temp[i] = elem;
                        System.arraycopy(queue, i, temp, i+1, tail-i);
                        queue = temp;
                        break;
                    }
                }
            }
            else
            {
                boolean st = false;
                for (int i = head; i< maxSize; i++) { // если приоритет от head до maxSize
                    if (elem.getPriority() < queue[i].getPriority()) {
                        System.arraycopy(queue, 0, temp, 0, i - 1);
                        temp[i] = elem;
                        System.arraycopy(queue, i, temp, i + 1, maxSize - i);
                        items++;
                        st = true;
                        queue = temp;
                        break;
                    }
                }
                if (st = false) {
                    for (int i = 0; i < tail; i++) { // если приоритет от 0 До tail
                        if (elem.getPriority() < queue[i].getPriority()) {
                            System.arraycopy(queue, 0, temp, 0, i - 1);
                            temp[i] = elem;
                            System.arraycopy(queue, i, temp, i + 1, maxSize - i);
                            items++;
                            queue = temp;
                            break;
                        }
                    }
                }

            }
        }

    }

    public PriorityQ remove(){
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        PriorityQ temp = queue[head++];

        if (head == maxSize)
            head = 0;
        items--;
        return temp;
    }

    public PriorityQ peek(){
        return queue[head];
    }

    public boolean sravn(PriorityQ one_el, PriorityQ two_el) // сравниваем приоритеты
    {
        if (one_el.getPriority() > two_el.getPriority())
            return true;
        else
            return false;
    }

}
