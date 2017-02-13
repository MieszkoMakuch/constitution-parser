package pl.mieszkomakuch.polishConstitutionParser;

import java.io.FileNotFoundException;

/**
 * Parses the Constitution of Poland from a text file into a objective form and displays the content of article/section
 * with the specified number or content of given range of articles/sections.
 */


public class ConstitutionSystem {

    /**
     * Parses the Constitution of Poland from a text file into a objective form and displays the content of article/section
     * with the specified number or content of given range of articles/sections.
     *
     * @param args [text file path, a or s (article or section), range]. E.g. "constitution.txt a 1 3" - displays the
     *             content of articles 1, 2, 3 from text file constitution.txt
     * @throws IllegalArgumentException if the given number/range of articles/sections is invalid.
     */
    public static void main(String[] args) {

        try {
            ArgumentsParser argumentsParser = new ArgumentsParser(args);
            DocumentParser documentParser = new DocumentParser(argumentsParser.getScanner());
            Constitution constitution = documentParser.parseConstitutionFromTxt();

            int startNo = argumentsParser.getRange()[0];
            int endNo = argumentsParser.getRange()[1];

            if(argumentsParser.partOfDocumentToWrite().equals(PartsOfConstitution.ARTICLE)){
                System.out.println(constitution.writeArticles(startNo,endNo));
            }
            if(argumentsParser.partOfDocumentToWrite().equals(PartsOfConstitution.SECTION)){
                System.out.println(constitution.writeSections(startNo,endNo));
            }

        } catch (IllegalArgumentException | FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }


    }
}
