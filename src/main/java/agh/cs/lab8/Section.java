package agh.cs.lab8;

import java.util.ArrayList;

/**
 * Created by mieszkomakuch on 01.12.2016.
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
