import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjuster;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created with IntelliJ IDEA.
 * User: bobbyjam99
 * Date: 2013/11/16
 * Time: 16:46
 * To change this template use File | Settings | File Templates.
 */
public class LocalDateTest {

    @Test
    public void localTime() {

        System.out.println(LocalDate.now());
        assertThat(LocalDate.of(2000, Month.NOVEMBER, 20).toString(), is("2000-11-20"));

        String excepted = "2000-11-22";
        LocalDate date = LocalDate.of(2000, Month.NOVEMBER, 20);
        LocalDate nextWed = date.with(TemporalAdjuster.next(DayOfWeek.WEDNESDAY));
        assertThat(nextWed.toString(), is(excepted));
    }
}
