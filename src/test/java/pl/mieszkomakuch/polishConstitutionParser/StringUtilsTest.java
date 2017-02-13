package pl.mieszkomakuch.polishConstitutionParser;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for string utils class.
 */
public class StringUtilsTest {
    @Test
    public void chceckArticleContentForUnnecessaryNewLine() throws Exception {
        String chceckArticleTest = "\n" +
                "1. Władza zwierzchnia w Rzeczypospolitej Polskiej należy do Narodu. \n" +
                "2. Naród sprawuje władzę przez swoich przedstawicieli lub bezpośrednio. \n";
        String chceckArticleExpectedResult =
                "1. Władza zwierzchnia w Rzeczypospolitej Polskiej należy do Narodu. \n" +
                        "2. Naród sprawuje władzę przez swoich przedstawicieli lub bezpośrednio. \n";
        assertEquals(chceckArticleExpectedResult, StringUtils.checkArticleContentForUnnecessaryNewLine(chceckArticleTest));
    }

    @Test
    public void checkLine() throws Exception {
        String linkingWordsTest =   "Rzeczpospolita Polska zapewnia wolność tworzenia i działania partii politycz-\n" +
                "nych. Partie polityczne zrzeszają na zasadach dobrowolności i równości obywa-\n" +
                "teli polskich w celu wpływania metodami demokratycznymi na kształtowanie\n" +
                "polityki państwa.\n";
        String linkingWordsExpectedResult = "Rzeczpospolita Polska zapewnia wolność tworzenia i działania partii " +
                "politycznych. Partie polityczne zrzeszają na zasadach dobrowolności i równości obywateli polskich " +
                "w celu wpływania metodami demokratycznymi na kształtowanie polityki państwa. ";

        assertEquals(linkingWordsExpectedResult, StringUtils.checkLine(linkingWordsTest));


        String deleteKancelariaTest =   "konywania zadań publicznych określa ustawa.\n" +
                "©Kancelaria Sejmu\n" +
                "2009-11-16";
        String deleteKancelariaExpectedResult =     "konywania zadań publicznych określa ustawa. ";
        assertEquals(deleteKancelariaExpectedResult, StringUtils.checkLine(deleteKancelariaTest));

        String pointStartsFromNewLineText = "1. Rzeczpospolita Polska zapewnia wolność tworzenia i działania partii politycz-\n" +
                "nych. Partie polityczne zrzeszają na zasadach dobrowolności i równości obywa-\n" +
                "teli polskich w celu wpływania metodami demokratycznymi na kształtowanie\n";

        String pointStartsFromNewLineExpectedResult = "\n1. Rzeczpospolita Polska zapewnia wolność tworzenia " +
                "i działania partii politycznych. Partie polityczne zrzeszają na zasadach dobrowolności " +
                "i równości obywateli polskich w celu wpływania metodami demokratycznymi na kształtowanie ";
        assertEquals(pointStartsFromNewLineExpectedResult, StringUtils.checkLine(pointStartsFromNewLineText));
    }

}