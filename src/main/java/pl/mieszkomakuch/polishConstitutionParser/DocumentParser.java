package pl.mieszkomakuch.polishConstitutionParser;

import java.util.Scanner;

/**
 * Class responsible for creating Constitution object from text file scanner.
 */
public class DocumentParser {
    private static String sectionName = "Rozdział ";
    private static String articleName = "Art. ";

    private Scanner documentScanner;

    public DocumentParser(Scanner documentScanner) {
        this.documentScanner = documentScanner;
    }

    /**
     * Creates a Constitution object form text file scanner with all sections and articles.
     *
     * @return a created Constitution object
     */
    public Constitution parseConstitutionFromTxt () {
        Constitution constitution = new Constitution();

        constitution.setPreamble(getPreamble());

        int sectionNo = 1;
        int articleNo = 1;
        while (this.documentScanner.hasNext()) {
            constitution = addNextSection(constitution, sectionNo, articleNo);
            sectionNo++;
        }
        return constitution;
    }

    /**
     * Adds next section with all its articles to the constitution. Returns modified constitution.
     *
     * @param constitution constitution to which next section will be added
     * @param sectionNo number of section which will be added
     * @param articleNo number of the first article (from the section) which will be added
     * @return constitution with added section and all its articles
     */
    private Constitution addNextSection (Constitution constitution, int sectionNo, int articleNo) {
        Section section = new Section(sectionNo, sectionName + this.documentScanner.nextLine(),
                this.documentScanner.nextLine());
        while (!patternAppearsInNextLine(articleName)) {
            this.documentScanner.nextLine();
        }
        boolean endOfsection = false;
        while (this.documentScanner.hasNext() && !endOfsection) {

            Article article = getNextArticle(articleNo);
            endOfsection = article.isLastInSection();

            section.addArticle(article);
            constitution.addArticle(article);
            articleNo++;
        }
        constitution.addSection(section);
        return constitution;
    }

    /**
     * Creates an Article object with given article number from text file scanner. It is assumed that next line of
     * the scanner contains article number followed by article content.
     *
     * @param articleNo
     * @return article created from text file scanner.
     */
    private Article getNextArticle (int articleNo) {
        String articleContentBuffer = "";
        boolean lastInSection = false;
        String articleTitle = articleName + this.documentScanner.nextLine();

        while (this.documentScanner.hasNext() && !patternAppearsInNextLine(articleName)) {

            articleContentBuffer = articleContentBuffer +
                    StringUtils.checkLine(this.documentScanner.nextLine()+ "\n");
            if (this.documentScanner.findInLine(sectionName) != null) {
                lastInSection = true;
                break;
            }
        }
        return new Article(articleNo, articleTitle,
                StringUtils.checkArticleContentForUnnecessaryNewLine(articleContentBuffer), lastInSection);
    }

    /**
     * Returns the Preamble to the Constitution (everything what is located before first section)
     *
     * @return preamble to the constitution (everything what is located before first section)
     */
    private String getPreamble () {
        String preambleBuffer = "";
        while (this.documentScanner.hasNext() && !patternAppearsInNextLine(sectionName)) {
            preambleBuffer = preambleBuffer + StringUtils.checkLine(this.documentScanner.nextLine() + "\n");
        }
        return preambleBuffer;
    }

    /**
     * Returns true if given pattern appears in the next line of scanner.
     *
     * @param pattern pattern which will be checked
     * @return true if given pattern appears in the next line of scanner.
     */
    private boolean patternAppearsInNextLine(String pattern) {
        return this.documentScanner.findInLine(pattern) != null;
    }
}
