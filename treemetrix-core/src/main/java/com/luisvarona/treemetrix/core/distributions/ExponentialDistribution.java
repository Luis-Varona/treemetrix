package com.luisvarona.treemetrix.core.distributions;

import java.util.Random;

public class ExponentialDistribution implements WeightDistribution {
    private final double lambda;

    public ExponentialDistribution(double rate) {
        if (rate <= 0) {
            String err_msg = String.format("`rate` (%f) must be positive.", rate);
            throw new IllegalArgumentException(err_msg);
        }

        this.lambda = rate;
    }

    @Override
    public double sample(Random rng) {
        return -Math.log(1.0 - rng.nextDouble()) / lambda;
    }
}
