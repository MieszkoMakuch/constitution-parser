package pl.mieszkomakuch.polishConstitutionParser;

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

    /**
     * Adds new section to the constitution.
     *
     * @param newSection which will be added
     */
    public void addSection(Section newSection) {
        sections.add(newSection);
    }

    /**
     * Adds new article to the constitution.
     *
     * @param newArticle which will be added.
     */
    public void addArticle(Article newArticle) {
        articles.add(newArticle);
    }

    /**
     * Returns section with the specified number.
     *
     * @param sectionNo number of the section.
     * @return section with the specified number.
     * @throws IllegalArgumentException if section with the specified number is not included in the constitution.
     */
    private Section getSection(int sectionNo) throws IllegalArgumentException{
        if (sectionNo > sections.size() || sectionNo < 1) {
            throw new IllegalArgumentException("Nie ma " + sectionNo + ". rozdziału w konstytucji");
        }
        return this.sections.get(sectionNo - 1);
    }

    /**
     * Returns article with the specified number.
     *
     * @param articleNo number of the article.
     * @return article with the specified number.
     * @throws IllegalArgumentException if article with the specified number is not included in the constitution.
     */
    private Article getArticle(int articleNo) throws IllegalArgumentException{
        if (articleNo > articles.size() || articleNo < 1) {
            throw new IllegalArgumentException("Nie ma " + articleNo + ". artykułu w konstytucji");
        }
        return this.articles.get(articleNo - 1);
    }

    /**
     * Returns string containing all sections (with their number, title and content) from the given range.
     *
     * @param sectionStartNo first section in the range.
     * @param sectionEndNo last section in the range.
     * @return string containing all sections (with their number, title and content) from the given range.
     */
    public String writeSections(int sectionStartNo, int sectionEndNo){

        String result = "";
        for (int i = sectionStartNo ; i <= sectionEndNo; i++) {
            result = result + this.getSection(i).toString();
        }
        return result;
    }

    /**
     * Returns string containing all articles (with their number and content) from the given range.
     *
     * @param articleStartNo first article in the range.
     * @param articleEndNo last article in the range
     * @return string containing all articles (with their number and content) from the given range.
     */
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
