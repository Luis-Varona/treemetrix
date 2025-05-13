package com.luisvarona.treemetrix.core.generators;

public enum TreeTopology {
    RANDOM_DFS,
    UNIFORM_RANDOM,
    STAR,
    KARY(int k);

    // TODO: Modify so k-ary is variable
    public static TreeTopology from(String topology) {
        return switch (topology.trim().toLowerCase()) {
            case "random_dfs" -> RANDOM_DFS;
            case "uniform_random" -> UNIFORM_RANDOM;
            case "k-ary" -> KARY;
            case "star" -> STAR;
            default -> throw new IllegalArgumentException(
                String.format("Unknown topology type: %s", topology)
            );
        };
    }
}
