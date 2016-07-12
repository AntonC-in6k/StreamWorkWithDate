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

        if (dates.collect(Collectors.toList()).size()==0){
            return "";
        }
        String result="fds";
        return result;
    }
}
