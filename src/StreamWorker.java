import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by employee on 7/11/16.
 */
public class StreamWorker {

    public static final Integer MAX_DAY_FOR_FIRST_OF_WEEKEND = 6;
    public static final Integer MIN_DAY_FOR_LAST_OF_WEEKEND = 6;

    public static Stream<LocalDate> generateDays(Integer year) {
        if (year == null) {
            return Stream.empty();
        }

        Stream<LocalDate> result;
        int numberOfDaysInYear = LocalDate.of(year, 1, 1).lengthOfYear();
        LocalDate currentDay = LocalDate.of(year, 1, 1);
        result = Stream.iterate(currentDay, date -> date.plusDays(1))
                .limit(numberOfDaysInYear);
        return result;
    }


    public static String printWeekends(Stream<LocalDate> dates) {

        Map<Month, List<LocalDate>> weekends = dates
                .filter(date -> date.getDayOfWeek().getValue() > 5)
                .filter(date -> date.getDayOfMonth() >=
                        Month.of(date.getMonth().getValue()).maxLength() - MIN_DAY_FOR_LAST_OF_WEEKEND
                        || date.getDayOfMonth() <= MAX_DAY_FOR_FIRST_OF_WEEKEND)
                .collect(Collectors.groupingBy(LocalDate::getMonth));

        String result = Stream.of(weekends.values())
                .map(Objects::toString)
                .collect(Collectors.joining(";"));

        return result;
    }
}
