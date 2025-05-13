package com.luisvarona.treemetrix.core.distributions;

import java.util.Map;
import java.util.Random;

public interface WeightDistribution {
    double sample(Random rng);

    public static WeightDistribution from(DistributionType type, Map<String, Double> params) {
        return switch (type) {
            case CONSTANT -> new ConstantDistribution(params.get("value"));
            case UNIFORM -> new UniformDistribution(params.get("min"), params.get("max"));
            case NORMAL -> new NormalDistribution(params.get("mean"), params.get("std"));
            case LOG_NORMAL -> new LogNormalDistribution(params.get("mean"), params.get("std"));
            case EXPONENTIAL -> new ExponentialDistribution(params.get("lambda"));
            case GAMMA -> new GammaDistribution(params.get("alpha"), params.get("theta"));
            case BETA -> new BetaDistribution(params.get("alpha"), params.get("beta"));
            case WEIBULL -> new WeibullDistribution(params.get("lambda"), params.get("k"));
        };
    }
}
