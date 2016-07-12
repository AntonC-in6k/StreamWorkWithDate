/**
 * Created by employee on 7/11/16.
 */

import org.junit.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;


public class TestDateGenerator {

    public List<LocalDate> setupBasicTest(Integer year) throws Exception {
        List<LocalDate> result = StreamWorker.generateDays(year).collect(Collectors.toList());
        return result;
    }

    @Test
    public void zeroInput() throws Exception {
        assertThat(setupBasicTest(null), is(Collections.emptyList()) );
    }

    @Test
    public void checkNumberOfDays() throws Exception {
        assertThat(setupBasicTest(2016).size(), is(366));
    }

    @Test
    public void checkDayFirstOfFebruary() throws Exception {
        int year=2016;
        int month=2;
        int day=1;
        LocalDate testDay = LocalDate.of(year,month,day);
        assertThat(setupBasicTest(year).get(31), is(testDay));
    }

}
