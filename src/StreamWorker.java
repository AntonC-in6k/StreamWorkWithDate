import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by employee on 7/11/16.
 */
public class StreamWorker {

    public static List<LocalDate> generateDays(Integer year) {
        if (year == null) {
            return new ArrayList<>();
        }
        List<LocalDate> result;
        int numberOfDaysInYear = LocalDate.of(year, 1, 1).lengthOfYear();
        LocalDate currentDay=LocalDate.of(year, 1, 1);
        result = Stream.iterate(currentDay, date-> date.plusDays(1))
                .limit(numberOfDaysInYear).collect(Collectors.toList());
        return result;
    }


    public static List<String> filterDatesByFirstAndLastWeekendInMonth() {
        List<String> result = new ArrayList<>();

        return result;
    }
}
