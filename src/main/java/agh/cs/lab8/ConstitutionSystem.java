package agh.cs.lab8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * Created by mieszkomakuch on 02.12.2016.
 */
public class ConstitutionSystem {
    public static void main(String[] args) {

        try {
            Constitution constitution = DocumentParser.parseConstitutionFromTxt(ParseArguments.getScanner(args));

            int startNo = ParseArguments.getRange(args)[0];
            int endNo = ParseArguments.getRange(args)[1];

            if(ParseArguments.partOfDocumentToWrite(args).equals(PartsOfDocument.ARTICLE)){
                System.out.println(constitution.writeArticles(startNo,endNo));
            }
            if(ParseArguments.partOfDocumentToWrite(args).equals(PartsOfDocument.SECTION)){
                System.out.println(constitution.writeSections(startNo,endNo));
            }

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }


    }
}
