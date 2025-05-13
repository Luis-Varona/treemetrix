package com.luisvarona.treemetrix.core.generators;

import java.util.Random;

import com.luisvarona.treemetrix.core.distributions.WeightDistribution;
import com.luisvarona.treemetrix.core.utils.Tree;

public class UniformRandomGenerator extends TreeGenerator {
    public UniformRandomGenerator() {
        super();
    }

    public UniformRandomGenerator(Random rng) {
        super(rng);
    }

    @Override
    public Tree generate(int order, WeightDistribution distribution) {
        int[] pruferCode = randomPruferCode(order);
        // TODO: Implement
        return null; // Placeholder
    }

    private int[] randomPruferCode(int order) {
        int[] pruferCode = new int[order - 2];

        for (int i = 0; i < order - 2; i++) {
            pruferCode[i] = this.rng.nextInt(order);
        }

        return pruferCode;
    }
}
