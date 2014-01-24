import org.junit.Test;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * java.time.LocalDateの動作確認用クラス
 */
public class LocalDateTest {

    @Test
    public void 現在日付取得() {

        LocalDate.now(); // ex) 2014-01-22
    }

    @Test
    public void 日付を指定して作成() {

        String excepted = "2000-11-20";
        assertThat(LocalDate.of(2000, Month.NOVEMBER, 20).toString(), is(excepted));
    }

    @Test
    public void 存在しない日付で作成するとDateTimeException() throws Exception {

        try {
            LocalDate.of(2014, Month.FEBRUARY, 30);
        } catch (DateTimeException e) {
            assertTrue(true);
        }
    }

    @Test
    public void 次の水曜日を表示() {

        String excepted = "2000-11-22"; // 2000/11/22(Wed)

        LocalDate date = LocalDate.of(2000, Month.NOVEMBER, 20); // 2000/11/20(Mon)
        LocalDate nextWed = date.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
        assertThat(nextWed.toString(), is(excepted));
    }

    @Test
    public void 月初を表示() {

        String excepted = "2000-11-01";

        LocalDate date = LocalDate.of(2000, Month.NOVEMBER, 20);
        LocalDate firstDayOfMonth = date.with(TemporalAdjusters.firstDayOfMonth());
        assertThat(firstDayOfMonth.toString(), is(excepted));
    }

    @Test
    public void 月初めの月曜日を表示() {

        String excepted = "2014-01-06"; // 2014/01/06(Mon)

        LocalDate date = LocalDate.of(2014, Month.JANUARY, 23); // 2014/01/23(Thr)
        LocalDate firstInMonth = date.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        assertThat(firstInMonth.toString(), is(excepted));
    }

    @Test
    public void 月末を表示() {

        String excepted = "2014-01-31"; // 2014/01/31(Fri)

        LocalDate date = LocalDate.of(2014, Month.JANUARY, 23); // 2014/01/23(Thr)
        LocalDate lastDayOfMonth = date.with(TemporalAdjusters.lastDayOfMonth());
        assertThat(lastDayOfMonth.toString(), is(excepted));
    }

    @Test
    public void parseメソッドを使って文字列からLocalDateを作成() throws Exception {

        assertThat(LocalDate.parse("2013/07/07", DateTimeFormatter.ofPattern("yyyy/MM/dd")).toString(), is("2013-07-07"));
    }
}
