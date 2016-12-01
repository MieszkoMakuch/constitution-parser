package agh.cs.lab8;

import java.util.ArrayList;

/**
 * Created by mieszkomakuch on 01.12.2016.
 */
public class Article {
    private int no;
    private String stringNo = new String();
    private String content = new String();

    public Article(int no, String stringNo) {
        this.stringNo = stringNo;
        this.no = no;
    }

    public void setStringNo(String stringNo) {
        this.stringNo = stringNo;
    }

    public void setContent (String content){
        this.content = content;
    }

    @Override
    public String toString() {
        return "Article{" +
                "no=" + no +
                ", stringNo='" + stringNo + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
