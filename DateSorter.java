package org.example;

import java.time.LocalDate;
import java.util.*;

/**
 /**
 * The implementation of this method should sort dates.
 * The output should be in the following order:
 * Dates with an 'r' in the month,
 * sorted ascending (first to last),
 * then dates without an 'r' in the month,
 * sorted descending (last to first).
 * For example, October dates would come before May dates,
 * because October has an 'r' in it.
 * thus: (2004-07-01, 2005-01-02, 2007-01-01, 2032-05-03)
 * would sort to
 * (2005-01-02, 2007-01-01, 2032-05-03, 2004-07-01)
 *
 /** @param unsortedDates - an unsorted list of dates
 * @return the collection of dates now sorted as per the spec
 */

public class DateSorter {
    public List<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        List<LocalDate> withR = new ArrayList<>();
        List<LocalDate> withoutR = new ArrayList<>();

        // Dividing dates into two categories
        for (LocalDate date : unsortedDates) {
            if (date.getMonth().name().contains("R")) {
                withR.add(date);
            } else {
                withoutR.add(date);
            }
        }

        // Sort dates with 'r' in month by ascending
        Collections.sort(withR);

        // Sort dates without 'r' in month in descending order
        Collections.sort(withoutR, Collections.reverseOrder());

        // Merge lists in the correct order
        List<LocalDate> sortedDates = new ArrayList<>(withR);
        sortedDates.addAll(withoutR);

        return sortedDates;
    }

    public static void main(String[] args) {
        DateSorter sorter = new DateSorter();
        List<LocalDate> dates = Arrays.asList(
                LocalDate.of(2004, 7, 1),   // July (without 'r')
                LocalDate.of(2005, 1, 2),   // January ('r')
                LocalDate.of(2007, 1, 1),   // January ('r')
                LocalDate.of(2032, 5, 3)    // May (without 'r')
        );
        List<LocalDate> sortedDates = sorter.sortDates(dates);
        System.out.println(sortedDates);
    }
}
