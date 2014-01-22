import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjuster;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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
    public void 次の水曜日を表示() {

        String excepted = "2000-11-22";
        LocalDate date = LocalDate.of(2000, Month.NOVEMBER, 20);
        LocalDate nextWed = date.with(TemporalAdjuster.next(DayOfWeek.WEDNESDAY));
        assertThat(nextWed.toString(), is(excepted));
    }
}
