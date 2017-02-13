package agh.cs.lab8;

import java.util.ArrayList;

/**
 * Class containing preamble, sections and articles, responsible for writing article/section or range of articles/sections.
 */
public class Constitution {

    /**
     * Preamble of the constitution (part of the constitution located before sections).
     */
    private String preamble;
    /**
     * List of all sections included in the constitution.
     */
    private ArrayList<Section> sections = new ArrayList<Section>();
    /**
     * List of all articles included in the constitution.
     */
    private ArrayList<Article> articles = new ArrayList<Article>();

    public Constitution() {
    }

    public void setPreamble(String preamble) {
        this.preamble = preamble;
    }

    public void addSection(Section newSection) {
        sections.add(newSection);
    }

    public void addArticle(Article newArticle) {
        articles.add(newArticle);
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

    public String writeArticles(int articleStartNo, int articleEndNo){
        String result = "";
        for (int i = articleStartNo; i <= articleEndNo; i++) {
            result = result + this.getArticle(i).toString();
        }
        return result;
    }

    @Override
    public String toString() {
        String result = preamble + "\n" + "\n";
        for(Section section : sections) {
            result += section.toString();
        }
        return result + "\n";
    }
}
