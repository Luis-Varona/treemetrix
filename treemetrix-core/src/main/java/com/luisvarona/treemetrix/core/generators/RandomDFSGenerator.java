package com.luisvarona.treemetrix.core.generators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import java.util.stream.IntStream;

import com.luisvarona.treemetrix.core.distributions.WeightDistribution;
import com.luisvarona.treemetrix.core.utils.Tree;

public class RandomDFSGenerator extends TreeGenerator {
    public RandomDFSGenerator() {
        super();
    }

    public RandomDFSGenerator(Random rng) {
        super(rng);
    }

    @Override
    public Tree generate(int order, WeightDistribution distribution) {
        int root = this.rng.nextInt(order);
        Tree tree = new Tree(root);

        int numVisited = 1;
        ArrayList<Integer> visited = new ArrayList<>();
        LinkedList<Integer> unvisited = IntStream.range(0, order)
            .filter(node -> node != root)
            .collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
        Collections.shuffle(unvisited, this.rng);

        while (!unvisited.isEmpty()) {
            int target = unvisited.removeFirst();
            int source = visited.get(this.rng.nextInt(numVisited++));
            double weight = distribution.sample(rng);
            tree.addBranch(source, target, weight);
            visited.add(target);
        }

        return tree;
    }
}
