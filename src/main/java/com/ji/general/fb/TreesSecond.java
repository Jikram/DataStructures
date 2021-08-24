package com.ji.general.fb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreesSecond {
    public static void main(String[] args) {
        // First Node
        String s1 = "aba";
        Node node1 = new Node(1);
        node1.children.add(new Node(2));
        node1.children.add(new Node(3));
        ArrayList<Query> queries1 = new ArrayList<>();
        queries1.add(new Query(1, 'a'));
        System.out.println("Nodes in subtree :" + Arrays.toString(countOfNodes(node1, queries1, s1)));
        // Second node
        String s2 = "abaacab";
        Node node2 = new Node(1);
        node2.children.add(new Node(2));
        node2.children.add(new Node(3));
        node2.children.add(new Node(7));
        node2.children.get(0).children.add(new Node(4));
        node2.children.get(0).children.add(new Node(5));
        node2.children.get(1).children.add(new Node(6));
        ArrayList<Query> queries2 = new ArrayList<>();
        queries2.add(new Query(1, 'a'));
        queries2.add(new Query(2, 'b'));
        queries2.add(new Query(3, 'a'));
        System.out.println("Nodes in subtree :" + Arrays.toString(countOfNodes(node2, queries2, s2)));
    }

    public static int[] countOfNodes(Node root, ArrayList<Query> queries, String s) {
        int[] result = new int[queries.size()];
        int i = 0;
        for (Query q : queries) {
            Node node = findNode(root, q.u);
            result[i++] = getCount(node, q, s);
        }
        return result;
    }

    private static int getCount(Node node, Query q, String s) {
        if (node == null) {
            return 0;
        }
        int count = 0;
        if (s.charAt(node.val - 1) == q.c) {
            count++;
        }
        for (Node child : node.children)
            count += getCount(child, q, s);
        return count;
    }

    private static Node findNode(Node root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        for (Node child : root.children) {
            Node found = findNode(child, val);
            if (found != null) {
                return found;
            }
        }
        return null;
    }

    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
            val = 0;
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static class Query {
        int u;
        char c;

        Query(int u, char c) {
            this.u = u;
            this.c = c;
        }
    }
}
