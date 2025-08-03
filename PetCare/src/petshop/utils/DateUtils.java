package petshop.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtils {
    public static LocalDateTime parseDateTime(String dateTimeString) throws DateTimeParseException {
        String input = dateTimeString.trim();

        boolean hasTimeComponent = input.contains(" ");

        if (hasTimeComponent) {
            String[] parts = input.split(" ", 2);
            String dateStr = parts[0];
            String timeStr = parts[1];

            LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            LocalTime time = LocalTime.parse(timeStr, DateTimeFormatter.ofPattern("HH:mm"));

            return LocalDateTime.of(date, time);
        } else {
            LocalDate date = LocalDate.parse(input, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return LocalDateTime.of(date, LocalTime.MIDNIGHT);
        }
    }
}
