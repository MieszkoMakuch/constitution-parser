package agh.cs.lab8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by mieszkomakuch on 02.12.2016.
 */
public class ParseArguments {

    public ParseArguments(String[] args) {
    }

    private static void checkAmountOfArguments (String args[]) throws IllegalArgumentException {
        if (!(args.length == 3 || args.length == 4)) {
            throw new IllegalArgumentException("Zła ilość argumentów, podaj 3 lub 4 argumenty");
        }
    }

    public static PartsOfDocument partOfDocumentToWrite (String[] args) throws IllegalArgumentException {
        ParseArguments.checkAmountOfArguments(args);
        if (args[1].equalsIgnoreCase("r") || args[1].equalsIgnoreCase("rozdział") ||
                args[1].equalsIgnoreCase("s") || args[1].equalsIgnoreCase("section")) {
            return PartsOfDocument.SECTION;
        } else if (args[1].equalsIgnoreCase("a") || args[1].equalsIgnoreCase("artykuł")) {
            return PartsOfDocument.ARTICLE;
        } else throw new IllegalArgumentException("Podano nieprawidłową część dokumentu");
    }

    public static int[] getRange (String[] args) {
        ParseArguments.checkAmountOfArguments(args);
        int sectionStartNo;
        int sectionEndNo = sectionStartNo = Integer.parseInt(args[2]);

        if (args.length > 3){
            sectionEndNo = Integer.parseInt(args[3]);
        }
        if (sectionStartNo > sectionEndNo) {
            throw new IllegalArgumentException(
                    "Zakres: [" + sectionStartNo + "," + sectionEndNo +
                            "] nie jest prawidłowym zakresem rozdziałów.");
        }
        return new int[] {sectionStartNo, sectionEndNo};
    }

    public static Scanner getScanner (String[] args) throws FileNotFoundException {
        ParseArguments.checkAmountOfArguments(args);
        return new Scanner(new File(args[0]));
    }


}
