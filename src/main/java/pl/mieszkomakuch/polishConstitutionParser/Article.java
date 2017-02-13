package pl.mieszkomakuch.polishConstitutionParser;

/**
 * Part of the constitution, article contains its number and content.
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

    /**
     * Returns <tt>true</tt> if article is last in section.
     *
     * @return <tt>true</tt> if article is last in section.
     */
    public boolean isLastInSection() {
        return lastInSection;
    }

    @Override
    public String toString() {
        return  stringNo + "\n" +
                content + "\n";
    }
}
