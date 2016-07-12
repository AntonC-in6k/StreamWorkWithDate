/**
 * Created by employee on 7/12/16.
 */

import org.junit.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class TestPrintWeekends {

    @Test
    public void onlyWeekendOutput() throws Exception {
        int year = 2016;
        int month = 7;
        LocalDate expectedDay = LocalDate.of(year, month, 3);
        Stream<LocalDate> datesForTest = Stream.of(LocalDate.of(year, month, 3), LocalDate.of(year, month, 4));
        assertThat(StreamWorker.printWeekends(datesForTest).trim(), is(containsString(expectedDay.toString())));
    }

    @Test
    public void firstWeekendsOutput() throws Exception {
        int year = 2016;
        int month = 7;
        String expectedDays = "2016-07-02, 2016-07-03";
        Stream<LocalDate> datesForTest = Stream.of(LocalDate.of(year, month, 2), LocalDate.of(year, month, 3),
                LocalDate.of(year, month, 9), LocalDate.of(year, month, 30), LocalDate.of(year, month, 31));
        assertThat(StreamWorker.printWeekends(datesForTest).trim(), is(containsString(expectedDays)));
    }

    @Test
    public void lastWeekendsOutput() throws Exception {
        int year = 2016;
        int month = 7;
        String expectedDays = "2016-07-30, 2016-07-31";
        Stream<LocalDate> datesForTest = Stream.of(LocalDate.of(year, month, 2), LocalDate.of(year, month, 3),
                LocalDate.of(year, month, 9), LocalDate.of(year, month, 30), LocalDate.of(year, month, 31));
        assertThat(StreamWorker.printWeekends(datesForTest).trim(), is(containsString(expectedDays)));
    }

    @Test
    public void firstAndLastWeekendsOutput() throws Exception {
        int year = 2016;
        int month = 7;
        String expectedDays = "2016-07-02, 2016-07-03, 2016-07-30, 2016-07-31";
        Stream<LocalDate> datesForTest = Stream.of(LocalDate.of(year, month, 2), LocalDate.of(year, month, 3),
                LocalDate.of(year, month, 9), LocalDate.of(year, month, 30), LocalDate.of(year, month, 31));
        assertThat(StreamWorker.printWeekends(datesForTest).trim(), is(containsString(expectedDays)));
    }

    @Test
    public void outputFormat() throws Exception {
        int year = 2016;
        int month = 7;
        String expectedDays = "2016-07-02, 2016-07-03, 2016-07-30, 2016-07-31";
        Stream<LocalDate> datesForTest = Stream.of(LocalDate.of(year, month, 2), LocalDate.of(year, month, 3),
                LocalDate.of(year, month, 9), LocalDate.of(year, month, 10), LocalDate.of(year, month, 16),
                LocalDate.of(year, month, 17), LocalDate.of(year, month, 30), LocalDate.of(year, month, 31));
        assertThat(StreamWorker.printWeekends(datesForTest).trim(), is(containsString(expectedDays)));
    }


}
