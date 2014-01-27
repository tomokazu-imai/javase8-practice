import org.junit.Test;

import java.time.DateTimeException;
import java.time.chrono.JapaneseDate;
import java.time.chrono.JapaneseEra;
import java.time.temporal.ChronoField;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * java.time.chrono.JapaneseDateのテスト
 */
public class JapaneseDateTest {

    @Test
    public void 西暦からインスタンス作成() throws Exception {

        JapaneseDate japaneseDate = JapaneseDate.of(2014, 1, 23);
        assertThat(japaneseDate.toString(), is("Japanese Heisei 26-01-23"));
        assertThat(japaneseDate.getEra().toString(), is("Heisei"));
    }

    @Test
    public void 年号からインスタンス作成() throws Exception {

        JapaneseDate japaneseDate = JapaneseDate.of(JapaneseEra.HEISEI, 26, 1, 23);
        assertThat(japaneseDate.toString(), is("Japanese Heisei 26-01-23"));
        assertThat(japaneseDate.getEra().toString(), is("Heisei"));
        assertThat(japaneseDate.get(ChronoField.YEAR_OF_ERA), is(26));
    }

    @Test
    public void 明治より前だとDateTimeExceptionが発生() throws Exception {

        try {
            JapaneseDate.of(1601, 1, 1);
        } catch (DateTimeException e) {
            assertThat(e.getMessage(), is("JapaneseDate before Meiji 6 is not supported"));
        }
    }

    @Test
    public void ChronoFieldを利用して値取得() throws Exception {

        JapaneseDate japaneseDate = JapaneseDate.of(JapaneseEra.HEISEI, 26, 1, 23);
        assertThat(japaneseDate.get(ChronoField.DAY_OF_WEEK), is(4));
        assertThat(japaneseDate.get(ChronoField.DAY_OF_MONTH), is(23));
        assertThat(japaneseDate.get(ChronoField.DAY_OF_YEAR), is(23));
        assertThat(japaneseDate.get(ChronoField.ERA), is(2));
        assertThat(japaneseDate.get(ChronoField.YEAR_OF_ERA), is(26));
        assertThat(japaneseDate.get(ChronoField.YEAR), is(2014));

    }
}
