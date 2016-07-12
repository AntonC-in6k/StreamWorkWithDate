/**
 * Created by employee on 7/11/16.
 */

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class TestStreamWorker {

    @Test
    public void zeroInput() throws Exception {
        assertTrue(StreamWorker.generateDays(null).isEmpty());
    }

    @Test
    public void checkNumberOfDays() throws Exception {
        assertThat(StreamWorker.generateDays(2016).size(), is(366));
    }

    @Test
    public void checkDayFirstOfFebruary() throws Exception {
        int year=2016;
        int month=2;
        int day=1;
        LocalDate testDay = LocalDate.of(year,month,day);

        assertThat(StreamWorker.generateDays(year).get(31), is(testDay));
    }
//    @Test
//    public void firstWeekendInJuly() throws Exception {
//        int firstSaturdayInJuly=2;
//        int firstSundayInJuly=3;
//        assertThat(StreamWorker.filterDatesByFirstAndLastWeekendInMonth(), both(
//                containsString("2")).and(containsString("3")));
//
//    }
}
