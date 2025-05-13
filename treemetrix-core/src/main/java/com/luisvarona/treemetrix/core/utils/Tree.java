package com.luisvarona.treemetrix.core.utils;

import java.util.ArrayList;
import java.util.HashMap;

public class Tree {
    private final int root;
    private final HashMap<Integer, ArrayList<Branch>> adjacencyList;

    public Tree(int root) {
        this.root = root;
        this.adjacencyList = new HashMap<>() {{
            put(root, new ArrayList<>());
        }};
    }

    public int getRoot() {
        return root;
    }

    public HashMap<Integer, ArrayList<Branch>> getAdjacencyList() {
        return adjacencyList;
    }

    public ArrayList<Branch> getBranches(int node) {
        return adjacencyList.get(node);
    }

    public void addBranch(int source, int target, double weight) {
        Branch edge = new Branch(target, weight);
        adjacencyList.get(source).add(edge);
        adjacencyList.put(target, new ArrayList<>());
    }
}
