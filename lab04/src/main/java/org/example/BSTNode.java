package org.example;

public class BSTNode {
    private Node root;
    private class Node {
        private int key;
        private String val;
        private Node left,right;
        private int size;

        public Node(int key, String val, int initSize) {
            this.key = key;
            this.val = val;
            size = initSize;
        }
    }

    public int getSize() {
        return getSize(root);
    }
    private int getSize(Node node) {
        if(node == null)
            return 0;
        else
            return node.size;
    }

    public void insertValue(int key, String val) {
        root = insertValue(root, key, val);
    }
    private Node insertValue(Node node, int key, String val) {
        if (node == null) {
            return new Node(key,val,1);
        }

        if (key > node.key) {
            node.right = insertValue(node.right,key,val);
        } else if (key < node.key) {
            node.left = insertValue(node.left,key,val);
        } else {
            node.val = val;
        }

        node.size = getSize(node.left) + getSize(node.right) + 1;

        return node;
    }

    public void deleteValue(int key) {
        root = deleteValue(root, key);
    }
    private Node deleteValue(Node node, int key) {
        if (node == null) return null;

        if (key > node.key) node.right = deleteValue(node.right, key);
        else if (key < node.key) node.left = deleteValue(node.left, key);
        else {
            if (node.right == null) return node.left;
            else if (node.left == null) return node.right;

            root.key = minValue(root.right);

            root.right = deleteValue(root.right, root.key);
        }

        node.size = getSize(node.left) + getSize(node.right) + 1;

        return node;
    }

    private int minValue(Node node) {
        int minValue = node.key;
        while (node.left != null) {
            minValue = node.left.key;
            node = node.left;
        }

        return minValue;
    }

    public String searchValue(int key){
        return searchValue(root, key);
    }
    private String searchValue (Node root, int key)
    {
        if (root == null) {
            return null;
        }

        if (key == root.key){
            return root.val;
        }

        if (key > root.key)
            return searchValue(root.right, key);

        return searchValue(root.left, key);
    }

    public void depthOrderTraversal() {
        depthTraversal(root);
    }

    private void depthTraversal(Node node) {
        if (node != null) {
            System.out.print("Key: " + node.key + " Value: " + node.val + "\n");
            depthTraversal(node.left);
            depthTraversal(node.right);
        }
    }


}

