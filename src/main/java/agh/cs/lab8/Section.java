package agh.cs.lab8;

import java.util.ArrayList;

/**
 * Part of the constitution, section contains its number, title and list of articles included in it.
 */
public class Section {
    private int no;
    private String stringNo = new String();
    private String title = new String();

    private ArrayList<Article> articles = new ArrayList<Article>();

    public Section(int no, String stringNo, String title) {
        this.stringNo = stringNo;
        this.no = no;
        this.title = title;

    }

    /**
     * Adds new article to section.
     *
     * @param newArticle article which will be added to section.
     */
    public void addArticle (Article newArticle){
        articles.add(newArticle);
    }

    @Override
    public String toString() {
        String result = stringNo + "\n" +
                        title + "\n";
        for(Article article : articles) {
            result += article.toString();
        }
        return result + "\n";
    }
}
