package com.luisvarona.treemetrix.core.distributions;

public class BetaDistribution implements WeightDistribution {
    private final GammaDistribution gammaAlpha, gammaBeta;

    public BetaDistribution(double alpha, double beta) {
        this.gammaAlpha = new GammaDistribution(alpha, 1.0);
        this.gammaBeta = new GammaDistribution(beta, 1.0);
    }

    @Override
    public double sample(java.util.Random rng) {
        double x = gammaAlpha.sample(rng);
        double y = gammaBeta.sample(rng);
        return x / (x + y);
    }
}
