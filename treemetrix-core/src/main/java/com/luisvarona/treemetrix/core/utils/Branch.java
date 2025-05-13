package com.luisvarona.treemetrix.core.utils;

public record Branch(int target, double weight) {
    public Branch {
        if (target < 0) {
            throw new IllegalArgumentException(
                String.format("`target` (%d) must be non-negative.", target)
            );
        }

        if (weight <= 0) {
            throw new IllegalArgumentException(
                String.format("`weight` (%f) must be positive.", weight)
            );
        }
    }
}