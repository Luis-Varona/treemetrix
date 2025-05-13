package com.luisvarona.treemetrix.core.generators;

import java.util.Random;

import com.luisvarona.treemetrix.core.distributions.WeightDistribution;
import com.luisvarona.treemetrix.core.utils.Tree;

public class TreeFactory {
    // TODO: Implement

    private static Tree generate(int order, TreeTopology topology, WeightDistribution distribution, Random rng) {
        return switch (topology) {
            case RANDOM_DFS -> new RandomDFSGenerator(rng).generate(order, distribution);
            case UNIFORM_RANDOM -> new UniformRandomGenerator(rng).generate(order, distribution);
            case KARY -> new KaryGenerator(rng, topology.k).generate(order, distribution);
            case STAR -> new StarGenerator(rng).generate(order, distribution);
        };
    }

    public static Tree generate(int order, TreeTopology topology, WeightDistribution distribution, int seed) {
        Random rng = new Random(seed);
        return generate(order, topology, distribution, rng);
    }

    public static Tree generate(int order, TreeTopology topology, WeightDistribution distribution) {
        Random rng = new Random();
        return generate(order, topology, distribution, rng);
    }
}
