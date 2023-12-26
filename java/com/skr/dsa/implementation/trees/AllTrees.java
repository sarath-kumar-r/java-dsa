package com.skr.dsa.implementation.trees;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
        val = x;
        }
        }

class BinaryTree {
    TreeNode root;

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private TreeNode addRecursive(TreeNode current, int value) {
        if (current == null) {
            return new TreeNode(value);
        }

        if (value < current.val) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.val) {
            current.right = addRecursive(current.right, value);
        }

        return current;
    }

    public void traverseInOrder(TreeNode node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(node.val + " ");
            traverseInOrder(node.right);
        }
    }
}

class Node {
    int val;
    List<Node> children;

    Node(int val) {
        this.val = val;
        children = new ArrayList<>();
    }

    public void addChild(Node child) {
        children.add(child);
    }
}

class NAryTree {
    Node root;

    public void traverse(Node node) {
        if (node != null) {
            System.out.print(node.val + " ");
            for (Node child : node.children) {
                traverse(child);
            }
        }
    }
}

class TrieNode {
    private TrieNode[] children;
    private boolean isWordEnd;

    public TrieNode() {
        children = new TrieNode[26]; // Assuming only lowercase English letters
        isWordEnd = false;
    }

    public boolean containsKey(char ch) {
        return children[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return children[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        children[ch - 'a'] = node;
    }

    public void setEnd() {
        isWordEnd = true;
    }

    public boolean isEnd() {
        return isWordEnd;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (node.containsKey(curLetter)) {
                node = node.get(curLetter);
            } else {
                return null;
            }
        }
        return node;
    }
}


public class AllTrees {

    public static void main(String[] args) {
        // Example for BinaryTree
        System.out.println("Binary Tress");
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(3);
        binaryTree.add(2);
        binaryTree.add(4);
        binaryTree.traverseInOrder(binaryTree.root);

        System.out.println();
        System.out.println("N Array Tress");

        // Example for NAryTree
        NAryTree nAryTree = new NAryTree();
        nAryTree.root = new Node(1);
        Node child1 = new Node(2);
        Node child2 = new Node(3);
        nAryTree.root.addChild(child1);
        nAryTree.root.addChild(child2);
        nAryTree.traverse(nAryTree.root);

        System.out.println();
        System.out.println("Trie Trees");

        // Example for Trie
        Trie trie = new Trie();
        trie.insert("hello");
        System.out.println(trie.search("hello")); // true
        System.out.println(trie.search("world")); // false
    }
}
