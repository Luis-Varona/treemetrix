package com.luisvarona.treemetrix.core.generators;

import java.util.Random;
import java.util.stream.IntStream;

import com.luisvarona.treemetrix.core.distributions.WeightDistribution;
import com.luisvarona.treemetrix.core.utils.Tree;

public class StarGenerator extends TreeGenerator {
    public StarGenerator() {
        super();
    }

    public StarGenerator(Random rng) {
        super(rng);
    }

    @Override
    public Tree generate(int order, WeightDistribution distribution) {
        int root = this.rng.nextInt(order);
        Tree tree = new Tree(root);

        IntStream.range(0, order)
            .filter(node -> node != root)
            .forEach(node -> {
                double weight = distribution.sample(this.rng);
                tree.addBranch(root, node, weight);
            });

        return tree;
    }
}
