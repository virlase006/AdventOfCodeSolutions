package com.rwdi.programmingchallenge;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day3ProblemSolver extends AdventCodeProblemSolver {

    Day3ProblemSolver(String input) {
        super(input);
    }

    @Override
    public void solveProblem() {
        try {
            Long sumOfPriorities = 0L;
            List<String> rackSacks = readFromFile(inputFile);
            for(String rackSack : rackSacks) {
                sumOfPriorities += getPriorityOfMisplacedItem(rackSack);
            }
            System.out.println(sumOfPriorities);
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * converts Characters into Integer values
     * @param character
     * @return Integer
     * */
    static Integer convertCharToInteg(Character character) {
        int lowerCaseDifferentiator = 38;
        int upperCaseDifferentiator = 96;
        if (character >= 65 && character <= 96) {
            return character - lowerCaseDifferentiator;
        } else if (character >= 97 && character <= 123) {
            return character - upperCaseDifferentiator;
        } else throw new RuntimeException("Invalid item");
    }

    /**
     * calculate priority of misplacedItem in racksack
     * @param items
     * @return Integer
     * */
    private static Integer getPriorityOfMisplacedItem(String items) {
        Set<Integer> itemsSet = new HashSet<>();
        Integer priority = 0;
        for (int i = 0; i < items.length()/2 ; i++) {
            itemsSet.add((int) items.charAt(i));
        }
        for (int j = items.length() / 2; j < items.length(); j++) {
            if (itemsSet.contains((int) items.charAt(j))) {
                priority = convertCharToInteg(items.charAt(j));
            }
        }
        return priority;
    }

}
