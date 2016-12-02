package agh.cs.lab8;

import java.util.Scanner;

/**
 * Created by mieszkomakuch on 02.12.2016.
 */
public class DocumentParser {

    private static String sectionName = "Rozdział ";
    private static String articleName = "Art. ";

    public static Constitution parseConstitutionFromTxt (Scanner sc) {
        Constitution constitution = new Constitution();

        constitution.setBeforeSections(getBeforeSection(sc));

        int sectionNo = 1;
        int articleNo = 1;
        //Czyta do konca konstytucji
        while (sc.hasNext()) {
            constitution = addNextSection(constitution, sc, sectionNo, articleNo);
            sectionNo++;
        }
        return constitution;
    }

    private static Constitution addNextSection (Constitution constitution, Scanner sc, int sectionNo, int articleNo) {
        Section section = new Section(sectionNo, sectionName + sc.nextLine(), sc.nextLine());

        //znajdz poczatek artykulu (chodzi o "naprawę" pierwszego przypadku
        //w którym artykuł zacznie się od "Art. 1", a nie "1")
        while (!patternAppearsInNextLine(sc,articleName)) {
            sc.nextLine();
        }

        //Czyta do konca rozdziału
        //while (sc.hasNext() && sc.findInLine("Rozdział ") == null) {
        boolean endOfsection = false;
        while (sc.hasNext() && !endOfsection) {

            Article article = getNextArticle(sc,articleNo);
            endOfsection = article.isLastInSection();

            section.addArticle(article);
            constitution.addArticle(article);
            articleNo++;
        }
        constitution.addSection(section);
        return constitution;
    }

    private static Article getNextArticle (Scanner sc, int articleNo) {
        String articleContentBuffer = "";
        boolean lastInSection = false;
        String articleTitle = articleName + sc.nextLine();
        //Czyta do końca artykułu
        while (sc.hasNext() && !patternAppearsInNextLine(sc,articleName)) {

            articleContentBuffer = articleContentBuffer +
                    StringUtils.checkLine(sc.nextLine()+ "\n");
            if (sc.findInLine(sectionName) != null) {
                lastInSection = true;
                break;
            }
        }
        return new Article(articleNo, articleTitle,
                StringUtils.chceckArticleContentForUnnecessaryNewLine(articleContentBuffer), lastInSection);
    }

    private static String getBeforeSection (Scanner sc) {
        String beforeSectionBuffer = "";
        while (sc.hasNext() && !patternAppearsInNextLine(sc,sectionName)) {
            beforeSectionBuffer = beforeSectionBuffer + StringUtils.checkLine(sc.nextLine() + "\n");
        }
        return beforeSectionBuffer;
    }

    private static boolean patternAppearsInNextLine(Scanner sc, String pattern) {
        return sc.findInLine(pattern) != null;
    }
}
