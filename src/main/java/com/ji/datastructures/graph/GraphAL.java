package com.ji.datastructures.graph;

import java.util.*;

// Graph using AL : Adjacency List approach //
public class GraphAL {
    private int vertex;
    private java.util.LinkedList<Integer>[] array;

    public GraphAL(int vertex) {
        this.vertex = vertex;
        array = new LinkedList[vertex];
        for (int i = 0; i < vertex; i++) {
            array[i] = new LinkedList<>();
        }
    }

    public void addEdge(int vertex1, int vertex2) {
        array[vertex1].add(vertex2);
    }

    // rpa logic: bfs will use queue for traversal //
    public String bfsTraversal(int node) {
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[vertex];
        visited[node] = true;
        queue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                System.out.println("de-queueing : -- " + queue.peek());
                Integer removedFromQueue = queue.poll();
                sb.append(removedFromQueue + ",");
                Iterator<Integer> iterator = array[removedFromQueue].iterator();
                while (iterator.hasNext()) {
                    Integer n = iterator.next();
                    if (!visited[n]) {
                        visited[n] = true;
                        System.out.println("enqueueing : " + n);
                        queue.add(n);
                    }
                }
            }
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public String dfsTraversal(int node) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[this.vertex];
        visited[node] = true;
        stack.push(node);
        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                Integer removeFromStack = stack.pop();
                System.out.println("popping : -- " + removeFromStack);
                sb.append(removeFromStack + ",");
                Iterator<Integer> iterator = array[removeFromStack].iterator();
                while (iterator.hasNext()) {
                    Integer n = iterator.next();
                    if (!visited[n]) {
                        visited[n] = true;
                        System.out.println("pushing : " + n);
                        stack.push(n);
                    }
                }

            }
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    @Override
    public String toString() {
        return "GraphAL{" +
                "vertex=" + vertex +
                ", array=" + Arrays.toString(array) +
                '}';
    }
}
