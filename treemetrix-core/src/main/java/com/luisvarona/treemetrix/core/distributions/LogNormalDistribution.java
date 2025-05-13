package com.luisvarona.treemetrix.core.distributions;

import java.util.Random;

public class LogNormalDistribution extends NormalDistribution {
    public LogNormalDistribution(double mean, double std) {
        super(mean, std);
    }

    @Override
    public double sample(Random rng) {
        return Math.exp(super.sample(rng));
    }
}
