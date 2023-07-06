package com.rwdi.programmingchallenge;

import java.util.HashMap;
import java.util.List;

public class Day21ProblemSolver extends AdventCodeProblemSolver {
    Day21ProblemSolver(String input) {
        super(input);
    }

    @Override
    public void solveProblem() {
        try {
            List<String> monkeyCalls = readFromFile(inputFile);
            HashMap<String, Monkey> monkeyMap = new HashMap<>();
            for (String monkeyCall : monkeyCalls) {
                String caller = monkeyCall.split(":")[0];
                String[] commands = monkeyCall.substring(caller.length() + 1).trim().split(" ");
                if (commands.length == 1) {
                    monkeyMap.put(caller, new Monkey(caller, Long.parseLong(commands[0])));
                } else {
                    monkeyMap.put(caller, new Monkey(caller, commands[0].trim(), commands[2].trim(), commands[1].trim()));
                }
            }

            System.out.println(getNumberAnouncedByMonkey("root", monkeyMap));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    /**
     * Compute number monkeyName should anounce
     *
     * @param monkeyName, monkeyMap
     * @return void
     */
    private Long getNumberAnouncedByMonkey(String monkeyName, HashMap<String, Monkey> monkeyMap) throws Exception {
        Monkey monkey = monkeyMap.get(monkeyName);
        if (monkey.getNumber() != null) {
            return monkey.getNumber();
        }

        switch (monkey.getOperation()) {
            case none:
                return monkey.getNumber();
            case add:
                return getNumberAnouncedByMonkey(monkey.getLeftMonkeyName(), monkeyMap) + getNumberAnouncedByMonkey(monkey.getRightMonkeyName(), monkeyMap);
            case minus:
                return getNumberAnouncedByMonkey(monkey.getLeftMonkeyName(), monkeyMap) - getNumberAnouncedByMonkey(monkey.getRightMonkeyName(), monkeyMap);
            case divide:
                return getNumberAnouncedByMonkey(monkey.getLeftMonkeyName(), monkeyMap) / getNumberAnouncedByMonkey(monkey.getRightMonkeyName(), monkeyMap);
            case multiply:
                return getNumberAnouncedByMonkey(monkey.getLeftMonkeyName(), monkeyMap) * getNumberAnouncedByMonkey(monkey.getRightMonkeyName(), monkeyMap);
        }
        throw new Exception("invalid operation");
    }

    public enum Operation {
        add("+"),
        minus("-"),
        divide("/"),
        multiply("*"),
        none("");

        private String symbol;

        Operation(String operatorSymbol) {
            this.symbol = operatorSymbol;
        }

        public static Operation toOperationEnum(String operatorSymbol) {
            if (operatorSymbol.equals(add.symbol)) {
                return add;
            }
            if (operatorSymbol.equals(multiply.symbol)) {
                return multiply;
            }
            if (operatorSymbol.equals(divide.symbol)) {
                return divide;
            }
            if (operatorSymbol.equals(minus.symbol)) {
                return minus;
            }
            return none;
        }
    }

    class Monkey {
        String name;
        Operation operation;
        Long number;
        String leftMonkeyName;
        String rightMonkeyName;

        public Monkey(String name, Long number) {
            this.name = name;
            this.number = number;
            this.operation = Operation.none;
        }

        public String getLeftMonkeyName() {
            return leftMonkeyName;
        }

        public Operation getOperation() {
            return operation;
        }

        public String getRightMonkeyName() {
            return rightMonkeyName;
        }

        public Monkey(String name, String leftNode, String rightNode, String operation) {
            this.name = name;
            this.leftMonkeyName = leftNode;
            this.rightMonkeyName = rightNode;
            this.operation = Operation.toOperationEnum(operation);
        }

        public Long getNumber() {
            return number;
        }
    }
}
