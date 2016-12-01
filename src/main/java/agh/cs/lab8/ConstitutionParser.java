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
        File constitutionTxt = new File("/Users/mieszkomakuch/Documents/Informatyka IET/SEMESTR II/Programowanie obiektowe/Laboratoria/Lab8-konstytucja/konstytucja.txt");

        Constitution constitution = parseConstitutionFromTxt(new Scanner(constitutionTxt));

        try {
            //System.out.println(constitution.writeArticle(1));
            //System.out.println(constitution.writeArticle(5));
            //System.out.println(constitution.writeArticles(1,3));
            //System.out.println(constitution.writeSection(3));
            //System.out.println(constitution.writeSections(1,3));
        } catch(IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }



    }



    public static Constitution parseConstitutionFromTxt (Scanner sc) {
        Constitution constitution = new Constitution();

        String beforeSectionBuffer = new String();

        while (sc.hasNext() && sc.findInLine("Rozdział ") == null) {
            beforeSectionBuffer = beforeSectionBuffer + sc.nextLine() + "\n";
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
                    articleContentBuffer = articleContentBuffer + sc.nextLine() + "\n";
                    if (sc.findInLine("Rozdział ") != null) {
                        endOfsection = true;
                        break;
                    }
                }
                article.setContent(articleContentBuffer);
                section.addArticle(article);
                constitution.addArticle(article);
                articleNo++;
            }
            constitution.addSection(section);
            sectionNo++;
        }
        return constitution;
    }

}
