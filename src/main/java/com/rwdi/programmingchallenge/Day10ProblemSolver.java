package com.rwdi.programmingchallenge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day10ProblemSolver extends AdventCodeProblemSolver {

    Day10ProblemSolver(String input) {
        super(input);
    }

    enum CommandType {
        noop,
        addx
    }

    @Override
    public void solveProblem() {
        try {
            List<String> commands = readFromFile(inputFile);
            Map<Integer, Integer> cycleToValueOfX = new HashMap<>();
            // starting point cycle 0 starts with value 1\
            cycleToValueOfX.put(0, 1);
            executeProgram(commands, cycleToValueOfX);
            Long sum = 0L;
            for (int i = 20; i <= cycleToValueOfX.size(); i = i + 40) {
                sum += (cycleToValueOfX.get(i - 1) * i);
            }
            System.out.println(sum);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * execute given commands
     * @param commands, cycleToValueOfX
     * @return void
     * */
    private static void executeProgram(List<String> commands, Map<Integer, Integer> cycleToValueOfX) {
        for (String command : commands) {
            String[] input = command.split(" ");
            if (CommandType.addx.toString().equals(input[0])) {
                executeNoOperationCycle(cycleToValueOfX);
                executeWithOperationCycle(cycleToValueOfX, Integer.parseInt(input[1]));
            } else if (CommandType.noop.toString().equals(input[0])) {
                executeNoOperationCycle(cycleToValueOfX);
            }
        }
    }

    /**
     * execute noOp cycle
     * @param cycleToValueOfX
     * @return void
     * */
    private static void executeNoOperationCycle(Map<Integer, Integer> cycleToValueOfX) {
        cycleToValueOfX.put(cycleToValueOfX.size(), cycleToValueOfX.get(cycleToValueOfX.size() - 1));
    }

    /**
     * execute Op cycle that increses value of  X by digit
     * @param cycleToValueOfX
     * @return void
     * */
    private static void executeWithOperationCycle(Map<Integer, Integer> cycleToValueOfX, Integer digit) {

        cycleToValueOfX.put(cycleToValueOfX.size(), cycleToValueOfX.get(cycleToValueOfX.size() - 1) + digit);
    }
}
