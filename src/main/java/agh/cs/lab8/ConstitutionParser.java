package agh.cs.lab8;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by mieszkomakuch on 01.12.2016.
 */
public class ConstitutionParser {

    public static void main(String[] args) throws FileNotFoundException{
        //File constitutionTxt = new File("/Users/mieszkomakuch/Documents/Informatyka IET/SEMESTR II/Programowanie obiektowe/Laboratoria/Lab8-konstytucja/konstytucja.txt");

        File constitutionTxt = new File(args[0]);

        Constitution constitution = parseConstitutionFromTxt(new Scanner(constitutionTxt));

        Integer startNo, endNo;
        startNo = endNo = Integer.parseInt(args[2]);
        if (args.length > 3) {
            endNo = Integer.parseInt(args[3]);
        }

        try {
            if (args[1].equalsIgnoreCase("r") || args[1].equalsIgnoreCase("s")){
                System.out.println(constitution.writeSections(startNo,endNo));
            } else if (args[1].equalsIgnoreCase("a")){
                System.out.println(constitution.writeArticles(startNo,endNo));
            } else throw new IllegalArgumentException(  "Podano nieprawidłowe parametry, podaj je wg. schematu:" + "\n" +
                    "ścieżkaDoPliku r numerRozdzialu lub" + "\n" +
                    "ścieżkaDoPliku r poczatekZakresu koniecZakresu lub" + "\n" +
                    "ścieżkaDoPliku a numerArtykułu lub" + "\n" +
            "ścieżkaDoPliku a poczatekZakresu koniecZakresu ");
        } catch(IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(constitution.toString());

    }

    public static Constitution parseConstitutionFromTxt (Scanner sc) {
        Constitution constitution = new Constitution();

        String beforeSectionBuffer = new String();

        while (sc.hasNext() && sc.findInLine("Rozdział ") == null) {
            beforeSectionBuffer = beforeSectionBuffer + checkLine(sc.nextLine()+ "\n");
        }
        constitution.setBeforeSections(beforeSectionBuffer);

        int sectionNo = 1;
        int articleNo = 1;
        //Czyta do konca konstytucji
        while (sc.hasNext()) {

            Section section = new Section(sectionNo, "Rozdział " + sc.nextLine(), sc.nextLine());

            //znajdz poczatek artykulu (chodzi o "naprawę" pierwszego przypadku
            //w którym artykuł zacznie się od "Art. 1", a nie "1")
            while (sc.findInLine("Art. ") == null) {
                sc.nextLine();
            }

            //Czyta do konca rozdziału
            //while (sc.hasNext() && sc.findInLine("Rozdział ") == null) {
            boolean endOfsection = false;
            while (sc.hasNext() && !endOfsection) {


                String articleContentBuffer = new String();
                Article article = new Article(articleNo, "Art. " + sc.nextLine());

                //Czyta do końca artykułu
                while (sc.hasNext() && sc.findInLine("Art. ") == null) {

                    articleContentBuffer = articleContentBuffer +
                            checkLine(sc.nextLine()+ "\n");
                    if (sc.findInLine("Rozdział ") != null) {
                        endOfsection = true;
                        break;
                    }
                }
                article.setContent(chceckArticleContentForUnnecessaryNewLine(articleContentBuffer));
                section.addArticle(article);
                constitution.addArticle(article);
                articleNo++;
            }
            constitution.addSection(section);
            sectionNo++;
        }
        return constitution;
    }

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
