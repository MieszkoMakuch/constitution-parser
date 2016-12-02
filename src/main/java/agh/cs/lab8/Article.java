package agh.cs.lab8;

import java.util.ArrayList;

/**
 * Created by mieszkomakuch on 01.12.2016.
 */
public class Article {
    private int no;
    private String stringNo = new String();
    private String content = new String();
    private boolean lastInSection = false;

    public Article(int no, String stringNo, String content, boolean lastInSection) {
        this.stringNo = stringNo;
        this.no = no;
        this.content = content;
        this.lastInSection = lastInSection;
    }

    public boolean isLastInSection() {
        return lastInSection;
    }

    public void setContent (String content){
        this.content = content;
    }

    @Override
    public String toString() {
        return  stringNo + "\n" +
                content + "\n";
    }
}
