package com.rwdi.programmingchallenge;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final String DAY_3_INPUT_FILE = "AdventOfCodeSolutions/src/main/resources/inputDay3";
    private static final String DAY_10_INPUT_FILE = "AdventOfCodeSolutions/src/main/resources/inputDay10";
    private static final String DAY_21_INPUT_FILE = "AdventOfCodeSolutions/src/main/resources/inputDay21";
    private static final String DAY_25_INPUT_FILE = "AdventOfCodeSolutions/src/main/resources/inputDay25";

    public static void main(String[] args) throws IOException {
        printWelcomMessage();
        Scanner inputReader = new Scanner(System.in);
        Integer problemChoice = -1;
        Integer maxAttempts = 5;

        while (problemChoice == -1 && maxAttempts != 0) {
            System.out.println("Please enter valid ");
            String userInput = inputReader.nextLine();
            problemChoice = parseUserInput(userInput);
            maxAttempts--;
        }
        executeProblemSolver(problemChoice);

    }

    private static void executeProblemSolver(Integer problemChoice) {
        AdventProblemFactory adventProblemFactory;
        AdventCodeProblemSolver problemSolver;
        switch (problemChoice) {
            case 1:
                adventProblemFactory = new AdventProblemFactory(DAY_3_INPUT_FILE);
                problemSolver = adventProblemFactory.createDay3ProblemSolver();
                break;
            case 2:
                adventProblemFactory = new AdventProblemFactory(DAY_10_INPUT_FILE);
                problemSolver = adventProblemFactory.createDay10ProblemSolver();
                break;
            case 3:
                adventProblemFactory = new AdventProblemFactory(DAY_21_INPUT_FILE);
                problemSolver = adventProblemFactory.createDay21ProblemSolver();
                break;
            case 4:
                adventProblemFactory = new AdventProblemFactory(DAY_25_INPUT_FILE);
                problemSolver = adventProblemFactory.createDay25ProblemSolver();
                break;
            default:
                System.out.println("Invalid Input exiting...");
                return;
        }
        problemSolver.solveProblem();
    }

    private static void printWelcomMessage() {
        System.out.println("=======Welcome to AdventProblemSolver========");
        System.out.println("Please choose one of the following problem from Advent code to see results");
        System.out.println("Press 1 : Day 3: Rucksack Reorganization");
        System.out.println("Press 2 : Day 10: Cathode-Ray Tube ");
        System.out.println("Press 3 : Day 21: Monkey Math ");
        System.out.println("Press 4 : Day 25: Hot air balloon");
    }

    private static Integer parseUserInput(String input) {
        try {
            Integer userInput = Integer.parseInt(input);
            if (userInput < 1 || userInput > 4) return -1;
            return userInput;
        } catch (NumberFormatException exception) {
            return -1;
        }
    }

}