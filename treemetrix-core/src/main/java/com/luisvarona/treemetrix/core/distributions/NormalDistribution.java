package com.luisvarona.treemetrix.core.distributions;

import java.util.Random;

public class NormalDistribution implements WeightDistribution {
    private final double mean, std;

    public NormalDistribution(double mean, double std) {
        if (std <= 0) {
            String err_hint;

            if (std == 0) {
                err_hint = "Consider using a ConstantDistribution instead.";
            } else {
                err_hint = "Consider negating the provided parameter first.";
            }

            String err_msg = String.format(
                "`std` (%f) must be positive. %s",
                std, err_hint
            );
            throw new IllegalArgumentException(err_msg);
        }

        this.mean = mean;
        this.std = std;
    }

    @Override
    public double sample(Random rng) {
        return this.mean + (this.std * rng.nextGaussian());
    }
}
