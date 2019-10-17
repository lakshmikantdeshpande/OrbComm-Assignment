package com.ldeshpande.service;

import com.ldeshpande.exception.InvalidInputException;

import java.util.Objects;

public class CheeseService {

    public int getMaxConsecutiveCheese(int[] cheeseBlocks) {
        validateArray(cheeseBlocks);
        if (cheeseBlocks.length == 0) {
            return 0;
        } else if (cheeseBlocks.length == 1) {
            return cheeseBlocks[0];
        }

        return calculateMaximumCheese(cheeseBlocks);
    }

    private int calculateMaximumCheese(int[] cheeseBlocks) {
        int penultimateBlockWeight = cheeseBlocks[0];
        int previousBlockWeight = Math.max(penultimateBlockWeight, cheeseBlocks[1]);
        int maxWeight = 0;

        for (int i = 2; i < cheeseBlocks.length; i++) {
            int weight = cheeseBlocks[i];
            maxWeight = Math.max(previousBlockWeight, (weight + penultimateBlockWeight));
            penultimateBlockWeight = previousBlockWeight;
            previousBlockWeight = maxWeight;
        }
        return maxWeight;
    }

    private void validateArray(int[] array) {
        if (Objects.isNull(array)) {
            throw new InvalidInputException("Invalid input has been provided");
        }
    }
}
