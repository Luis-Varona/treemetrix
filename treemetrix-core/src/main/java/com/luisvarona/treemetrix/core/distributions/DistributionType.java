package com.luisvarona.treemetrix.core.distributions;

public enum DistributionType {
    CONSTANT,
    UNIFORM,
    NORMAL,
    LOG_NORMAL,
    EXPONENTIAL,
    GAMMA,
    BETA,
    WEIBULL;

    public static DistributionType from(String type) {
        return switch (type.trim().toLowerCase()) {
            case "constant" -> CONSTANT;
            case "uniform" -> UNIFORM;
            case "normal" -> NORMAL;
            case "lognormal" -> LOG_NORMAL;
            case "exponential" -> EXPONENTIAL;
            case "gamma" -> GAMMA;
            case "beta" -> BETA;
            case "weibull" -> WEIBULL;
            default -> throw new IllegalArgumentException(
                String.format("Unknown distribution type: %s", type)
            );
        };
    }
}
