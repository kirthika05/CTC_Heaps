package com.kirthika;

import java.util.*;

public class Main {
    public static void main(String[] args) {
	// write your code here
        Heap h= new Heap();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
            h.add(a[a_i]);
            System.out.println(h.median());
        }
    }
}

class Heap{

    private Queue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());
    private Queue<Integer> maxHeap = new PriorityQueue<>();

    public void add(int value) {
        Queue<Integer> idealQueue = minHeap.size() <= maxHeap.size() ? minHeap : maxHeap;
        idealQueue.add(value);
        balanceHeap();
    }

    private void balanceHeap() {
        while(!minHeap.isEmpty() && !maxHeap.isEmpty() && minHeap.peek() > maxHeap.peek()) {
            Integer minRoot= minHeap.poll();
            Integer maxRoot = maxHeap.poll();
            minHeap.add(maxRoot);
            maxHeap.add(minRoot);
        }
    }

    public double median() {
        if(minHeap.isEmpty() && maxHeap.isEmpty()) {
            throw new IllegalStateException("There are no nodes in the heap.");
        } else {
            return minHeap.size() == maxHeap.size() ? (minHeap.peek() + maxHeap.peek()) / 2.0 : minHeap.peek();
        }
    }

}

