package pl.mieszkomakuch.polishConstitutionParser;

/**
 * Set of String utilities used while parsing the text file.
 */
public class StringUtils {

    /**
     * Checks if article content contains unnecessary new line character before first point of ordered list. If so
     * method deletes it and returns modified article content.
     *
     * @param articleContent which will be checked.
     * @return article content without unnecessary new line character before first point of ordered list.
     */
    public static String checkArticleContentForUnnecessaryNewLine(String articleContent) {
        if (articleContent.startsWith("\n1. ")) {
            return articleContent.replaceAll("\n1. ", "1. ");
        }
        return articleContent;
    }

    /**
     * Deletes any unnecessary elements such as: hyphens "-" by joining broken words at line breaks,
     * duplicated lines "Kancelaria Sejmu" and date. It also retains the structure of the original file e.g. ordered
     * list from article 10 will not be displayed in a single line.
     *
     * @param line which will be checked.
     * @return line without any unnecessary elements with retained structure of original file.
     */
    public static String checkLine(String line) {
        String deletedKancelariaAndData = deleteKancelariaAndData(line);
        //linking words, deleting end of line
        String line2 = deletedKancelariaAndData.replaceAll("-\n", "");
        String line3 = line2.replaceAll("\n", " ");
        return addNewLineBeforePoint(line3);
    }

    /**
     * Deletes unnecessary elements: duplicated lines "Kancelaria Sejmu" and date.
     *
     * @param line which may contain "Kancelaria Sejmu" or date.
     * @return line without "Kancelaria Sejmu" and date.
     */
    public static String deleteKancelariaAndData(String line) {
        String line2 = line.replaceAll("©Kancelaria Sejmu\n", "");
        return line2.replaceAll("[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])", "");
    }

    /**
     * Adds new line character before point of ordered list.
     *
     * @param line which may contain point of ordered list.
     * @return line with new line character if the line contains point of ordered list.
     */
    public static String addNewLineBeforePoint(String line) {
        if (line.matches("([0-9]*[0-9][.]).*")) {
            line = "\n" + line;
        }
        return line;
    }
}
