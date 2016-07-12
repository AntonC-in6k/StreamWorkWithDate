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
    public void emptyStream() throws Exception {
        assertThat(StreamWorker.printWeekends(Stream.empty()), is(""));
    }


}
