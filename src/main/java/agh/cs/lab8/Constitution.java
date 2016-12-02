package agh.cs.lab8;

import java.util.ArrayList;

/**
 * Created by mieszkomakuch on 01.12.2016.
 */
public class Constitution {
    private String beforeSections;
    private ArrayList<Section> sections = new ArrayList<Section>();
    private ArrayList<Article> articles = new ArrayList<Article>();

    public Constitution() {
    }

    public void setBeforeSections(String beforeSections) {
        this.beforeSections = beforeSections;
    }

    public void addSection(Section newSection) {
        sections.add(newSection);
    }

    public void addArticle(Article newArticle) {
        articles.add(newArticle);
    }

    public String getBeforeSections() {
        return beforeSections;
    }

    private Section getSection(int sectionNo) throws IllegalArgumentException{
        if (sectionNo > sections.size() || sectionNo < 1) {
            throw new IllegalArgumentException("Nie ma " + sectionNo + ". rozdziału w konstytucji");
        }
        return this.sections.get(sectionNo - 1);
    }

    private Article getArticle(int articleNo) throws IllegalArgumentException{
        if (articleNo > articles.size() || articleNo < 1) {
            throw new IllegalArgumentException("Nie ma " + articleNo + ". artykułu w konstytucji");
        }
        return this.articles.get(articleNo - 1);
    }

    public String writeSections(int sectionStartNo, int sectionEndNo){

        String result = "";
        for (int i = sectionStartNo ; i <= sectionEndNo; i++) {
            result = result + this.getSection(i).toString();
        }
        return result;
    }

    public String writeArticles(int articleStartNo, int articleEndNo) throws IllegalArgumentException{
        if (articleStartNo > articleEndNo) {
            throw new IllegalArgumentException(
                    "Zakres: [" + articleStartNo + "," + articleEndNo +
                            "] nie jest prawidłowym zakresem artykółów.");
        }
        String result = new String();
        for (int i = articleStartNo; i <= articleEndNo; i++) {
            result = result + this.getArticle(i).toString();
        }
        return result;
    }

    @Override
    public String toString() {
        String result = beforeSections + "\n" + "\n";
        for(Section section : sections) {
            result += section.toString();
        }
        return result + "\n";
    }
}
