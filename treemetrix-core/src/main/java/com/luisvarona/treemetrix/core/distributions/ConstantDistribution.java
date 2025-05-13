package com.luisvarona.treemetrix.core.distributions;

import java.util.Random;

public class ConstantDistribution implements WeightDistribution {
    private final double value;

    public ConstantDistribution(double value) {
        if (value == 0) {
            String err_msg = String.format(
                "`value` (%f) must be non-zero. Consider using a UniformDistribution instead.",
                value
            );
            throw new IllegalArgumentException(err_msg);
        }

        this.value = value;
    }

    @Override
    public double sample(Random rng) {
        return value;
    }
}
