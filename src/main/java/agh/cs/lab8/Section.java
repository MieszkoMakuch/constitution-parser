package agh.cs.lab8;

import java.util.ArrayList;

/**
 * Created by mieszkomakuch on 01.12.2016.
 */
public class Section {
    private int no;
    private String stringNo = new String();
    private String title = new String();
    String content = new String();

    private ArrayList<Article> articles = new ArrayList<Article>();


    public Section(int no, String stringNo, String title) {
        this.stringNo = stringNo;
        this.no = no;
        this.title = title;

    }

    public void setStringNo(String stringNo) {
        this.stringNo = stringNo;
    }

    public void addArticle (Article newArticle){
        articles.add(newArticle);
    }

    @Override
    public String toString() {
        return "Section{" +
                "no=" + no +
                ", stringNo='" + stringNo + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", articles=" + articles +
                '}';
    }
}
