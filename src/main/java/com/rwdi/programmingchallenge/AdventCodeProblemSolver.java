package com.rwdi.programmingchallenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class AdventCodeProblemSolver {

    protected String inputFile;
    AdventCodeProblemSolver(String input) {
        this.inputFile = input;
    }


    /**
     * read lines from file
     * @param fileName
     * @return List<String> lines from file
     * */
    public List<String> readFromFile(String fileName) throws IOException {
        List<String> lines = new ArrayList<>();
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }
        return lines;
    }

    public abstract  void solveProblem();
}
