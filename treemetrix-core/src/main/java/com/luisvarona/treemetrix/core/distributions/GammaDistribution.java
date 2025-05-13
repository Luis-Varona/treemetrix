package com.luisvarona.treemetrix.core.distributions;

public class GammaDistribution implements WeightDistribution {
    private final double alpha, theta;

    public GammaDistribution(double shape, double scale) {
        if (shape <= 0 || scale <= 0) {
            String err_msg;

            if (shape <= 0) {
                err_msg = String.format("`shape` (%f) must be positive.", shape);;
            } else {
                err_msg = String.format("`scale` (%f) must be positive.", scale);
            }

            throw new IllegalArgumentException(err_msg);
        }

        this.alpha = shape;
        this.theta = scale;
    }

    @Override
    public double sample(java.util.Random rng) {
        // TODO: Implement sampling logic
        return 1.0; // Placeholder value
    }
}
