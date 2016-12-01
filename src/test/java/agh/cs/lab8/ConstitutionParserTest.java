package agh.cs.lab8;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mieszkomakuch on 01.12.2016.
 */
public class ConstitutionParserTest {
    @Test
    public void main() throws Exception {

    }

    @Test
    public void parseConstitutionFromTxt() throws Exception {

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

        assertEquals(linkingWordsExpectedResult, ConstitutionParser.checkLine(linkingWordsTest));


        String deleteKancelariaTest =   "konywania zadań publicznych określa ustawa.\n" +
                                        "©Kancelaria Sejmu\n" +
                                        "2009-11-16";
        String deleteKancelariaExpectedResult =     "konywania zadań publicznych określa ustawa. ";
        assertEquals(deleteKancelariaExpectedResult, ConstitutionParser.checkLine(deleteKancelariaTest));

        String pointStartsFromNewLineText = "1. Rzeczpospolita Polska zapewnia wolność tworzenia i działania partii politycz-\n" +
                "nych. Partie polityczne zrzeszają na zasadach dobrowolności i równości obywa-\n" +
                "teli polskich w celu wpływania metodami demokratycznymi na kształtowanie\n";

        String pointStartsFromNewLineExpectedResult = "\n1. Rzeczpospolita Polska zapewnia wolność tworzenia " +
                "i działania partii politycznych. Partie polityczne zrzeszają na zasadach dobrowolności " +
                "i równości obywateli polskich w celu wpływania metodami demokratycznymi na kształtowanie ";
        assertEquals(pointStartsFromNewLineExpectedResult, ConstitutionParser.checkLine(pointStartsFromNewLineText));
    }

}