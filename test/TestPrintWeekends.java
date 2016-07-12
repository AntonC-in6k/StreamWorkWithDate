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
        int year=2016;

        LocalDate expectedDay= LocalDate.of(year,7,3);
        Stream<LocalDate> datesForTest = Stream.of(LocalDate.of(year,7,3), LocalDate.of(year,7,4));
        assertThat(StreamWorker.printWeekends(datesForTest), is(expectedDay.toString()));

    }
}
