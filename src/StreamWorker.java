import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
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

    public static Stream<LocalDate> generateDays(Integer year) {
        if (year == null) {
            return Stream.empty();
        }

        Stream<LocalDate> result;
        int numberOfDaysInYear = LocalDate.of(year, 1, 1).lengthOfYear();
        LocalDate currentDay=LocalDate.of(year, 1, 1);
        result = Stream.iterate(currentDay, date-> date.plusDays(1))
                .limit(numberOfDaysInYear);
        return result;
    }


    public static String printWeekends(Stream<LocalDate> dates) {

        String result="";
        List<LocalDate> weekends = new ArrayList();
        weekends=dates.filter(date -> date.getDayOfWeek().getValue()>5).collect(Collectors.toList());
        for (LocalDate date :
                weekends) {
            result+=date.toString();
        }
        return result;
    }
}
