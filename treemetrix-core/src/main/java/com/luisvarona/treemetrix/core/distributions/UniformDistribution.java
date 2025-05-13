package com.luisvarona.treemetrix.core.distributions;

import java.util.Random;

public class UniformDistribution implements WeightDistribution {
    private final double min, range;

    public UniformDistribution(double min, double max) {
        if (min >= max) {
            String err_hint;

            if (min == max) {
                err_hint = "Consider using a ConstantDistribution instead.";
            } else {
                err_hint = "Consider swapping the values.";
            }

            String err_msg = String.format(
                "Invalid range: min (%f) must be less than max (%f). %s",
                min, max, err_hint
            );
            throw new IllegalArgumentException(err_msg);
        }

        this.min = min;
        this.range = max - min;
    }

    @Override
    public double sample(Random rng) {
        return this.min + (this.range * rng.nextDouble());
    }
}
