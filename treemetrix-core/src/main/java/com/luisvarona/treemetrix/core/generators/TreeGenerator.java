package com.luisvarona.treemetrix.core.generators;

import java.util.Random;

import com.luisvarona.treemetrix.core.distributions.WeightDistribution;
import com.luisvarona.treemetrix.core.utils.Tree;

public abstract class TreeGenerator {
    protected final Random rng;

    protected TreeGenerator() {
        this.rng = new Random();
    }

    protected TreeGenerator(Random rng) {
        this.rng = rng;
    }

    protected abstract Tree generate(int order, WeightDistribution distribution);
}
