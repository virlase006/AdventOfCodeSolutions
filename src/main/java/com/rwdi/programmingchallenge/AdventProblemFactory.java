package com.rwdi.programmingchallenge;

public class AdventProblemFactory {
    String inputFile ;
    public AdventProblemFactory(String inputFile) {
        this.inputFile = inputFile;
    }

    public AdventCodeProblemSolver createDay3ProblemSolver() {
        return new Day3ProblemSolver(inputFile);
    }

    public AdventCodeProblemSolver createDay10ProblemSolver() {
        return new Day10ProblemSolver(inputFile);
    }

    public AdventCodeProblemSolver createDay21ProblemSolver() {
        return new Day21ProblemSolver(inputFile);
    }

    public AdventCodeProblemSolver createDay25ProblemSolver() {
        return new Day25ProblemSolver(inputFile);
    }
}
