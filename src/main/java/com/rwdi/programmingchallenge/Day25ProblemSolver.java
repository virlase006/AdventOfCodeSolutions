package com.rwdi.programmingchallenge;

import java.io.IOException;
import java.util.List;

public class Day25ProblemSolver extends AdventCodeProblemSolver {

    Day25ProblemSolver(String input) {
        super(input);
    }

    @Override
    public void solveProblem() {
        try {
            List<String> numbers = readFromFile(inputFile);
            Long sum = 0l;
            for(String number : numbers) {
                sum += convertSnafuToDecimal(number);
            }
            System.out.println(convertDecimalTOSnafu(sum));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * converts SNAFU into Decimal
     * @param snafuNumber
     * @return Long decimalNumber
     * */
    private static Long convertSnafuToDecimal(String snafuNumber) {
        Long decimalNumber = 0L;
        for (int i = 0; i < snafuNumber.length(); i++) {
            switch (snafuNumber.charAt(i)) {
                case '2':
                    decimalNumber = decimalNumber * 5 + 2;
                    break;
                case '1':
                    decimalNumber = decimalNumber * 5 + 1;
                    break;
                case '0':
                    decimalNumber = decimalNumber * 5;
                    break;
                case '-':
                    decimalNumber = decimalNumber * 5 - 1;
                    break;
                case '=':
                    decimalNumber = decimalNumber * 5 - 2;
                    break;
            }
        }
        return decimalNumber;
    }

    /**
     * converts Decimal into SNAFU
     * @param decimal
     * @return String SNAFU
     * */
    private static String convertDecimalTOSnafu(Long decimal) {
        String result = "";
        while (decimal != 0) {
            int remainder = (int) (decimal % 5);
            decimal = decimal / 5;
            if (remainder > 2) {
                remainder -= 5;
                decimal += 1;
            }
            switch (remainder) {
                case 2:
                    result = "2" + result;
                    break;
                case 1:
                    result = "1" + result;
                    break;
                case 0:
                    result = "0" + result;
                    break;
                case -1:
                    result = "-" + result;
                    break;
                case -2:
                    result = "=" + result;
                    break;
            }
        }
        return result;
    }
}
