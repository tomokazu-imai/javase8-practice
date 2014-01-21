import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * User: bobbyjam99
 * Date: 2013/11/16
 * Time: 15:55
 */
public class DayOfWeekTest {

    @Test
    public void dayOfWeekはEnum型() {

        assertThat(DayOfWeek.MONDAY.plus(3).toString(), is("THURSDAY"));
    }

    @Test
    public void textStyle() {

        DayOfWeek dow = DayOfWeek.MONDAY;
        Locale locale = Locale.getDefault();

        assertThat(dow.getDisplayName(TextStyle.FULL, locale), is("月曜日"));
        assertThat(dow.getDisplayName(TextStyle.NARROW, locale), is("月"));
        assertThat(dow.getDisplayName(TextStyle.SHORT, locale), is("月"));
    }
}
