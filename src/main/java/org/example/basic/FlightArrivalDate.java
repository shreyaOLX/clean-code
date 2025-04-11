package org.example.basic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FlightArrivalDate {
    public static String ArrivalTime(List<LocalDate> localDates)
    {
        StringBuilder result = new StringBuilder();
        for (LocalDate localdate : localDates) {
            if (localdate.isAfter(LocalDate.now())) {
                result.append(localdate).append("\n");
            }
        else {
            result.append("Delayed").append("\n");
        }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        List<LocalDate> localDates = new ArrayList<>();
        localDates.add(LocalDate.now());
        localDates.add(LocalDate.now().plusDays(1));
        localDates.add(LocalDate.now().plusDays(2));
        localDates.add(LocalDate.now().plusDays(3));
        System.out.println(ArrivalTime(localDates));
    }
}
