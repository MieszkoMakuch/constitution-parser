package agh.cs.lab8;

/**
 * Created by mieszkomakuch on 02.12.2016.
 */
public class StringUtils {
    public static String chceckArticleContentForUnnecessaryNewLine (String articleContent) {
        if (articleContent.startsWith("\n1. ")){
            return articleContent.replaceAll("\n1. ", "1. ");
        }
        return articleContent;
    }

    public static String checkLine(String line) {
        String deletedKancelariaAndData = deleteKancelariaAndData(line);
        //linking words, deleting end of line
        String line2 = deletedKancelariaAndData.replaceAll("-\n", "");
        String line3 = line2.replaceAll("\n", " ");
        return addNewLineBeforePoint(line3);
    }

    public static String deleteKancelariaAndData (String line) {
        String line2 = line.replaceAll("©Kancelaria Sejmu\n", "");
        return line2.replaceAll("[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])","");
    }

    public static String addNewLineBeforePoint (String line) {
        if (line.matches("([0-9]*[0-9][.]).*")) {
            line = "\n" + line;
        }
        return line;
    }
}
