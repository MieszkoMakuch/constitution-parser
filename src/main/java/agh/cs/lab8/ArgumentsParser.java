package agh.cs.lab8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class responsible for parsing arguments.
 */
public class ArgumentsParser {

    private String[] args;

    /**
     * ArgumentsParser will be created provided that amount of arguments is valid.
     *
     * @param args arguments provided by a user.
     */
    public ArgumentsParser(String[] args) {
        checkAmountOfArguments(args);
        this.args = args;
    }

    /**
     * Checks if amount of arguments in string array is valid. Throws exception if it is not.
     *
     * @param args arguments provided by a user.
     * @throws IllegalArgumentException if amount of arguments is invalid.
     */
    private void checkAmountOfArguments (String[] args) throws IllegalArgumentException {
        if (!(args.length == 3 || args.length == 4)) {
            throw new IllegalArgumentException("Zła ilość argumentów, podaj 3 lub 4 argumenty");
        }
    }

    /**
     * Parses arguments and returns part of the document from PartsOfConstitution enum chosen by a user.
     *
     * @return part of the document from PartsOfConstitution enum chosen by a user.
     * @throws IllegalArgumentException if chosen part is invalid.
     */
    public PartsOfConstitution partOfDocumentToWrite () throws IllegalArgumentException {
        if (this.args[1].equalsIgnoreCase("r") || args[1].equalsIgnoreCase("rozdział") ||
                args[1].equalsIgnoreCase("s") || args[1].equalsIgnoreCase("section")) {
            return PartsOfConstitution.SECTION;
        } else if (args[1].equalsIgnoreCase("a") || args[1].equalsIgnoreCase("artykuł")) {
            return PartsOfConstitution.ARTICLE;
        } else throw new IllegalArgumentException("Podano nieprawidłową część dokumentu");
    }

    /**
     * Parses arguments and returns range given by a user.
     *
     * @return array containing start and end of the range.
     * @throws IllegalArgumentException if chosen range is invalid.
     */
    public int[] getRange () {
        int rangeStart;
        int rangeEnd = rangeStart = Integer.parseInt(args[2]);

        if (args.length > 3){
            rangeEnd = Integer.parseInt(args[3]);
        }
        if (rangeStart > rangeEnd) {
            throw new IllegalArgumentException(
                    "Zakres: [" + rangeStart + "," + rangeEnd +
                            "] nie jest prawidłowym zakresem rozdziałów.");
        }
        return new int[] {rangeStart, rangeEnd};
    }

    /**
     * Parses arguments and returns Scanner from text file from given file path.
     *
     * @return Scanner from text file from given file path.
     * @throws FileNotFoundException if file from given file path does not exitst.
     */
    public Scanner getScanner () throws FileNotFoundException {
        return new Scanner(new File(args[0]));
    }


}
