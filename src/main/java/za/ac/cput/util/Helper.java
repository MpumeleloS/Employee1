package za.ac.cput.util;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class Helper {

    /**
     * Generate a unique ID using UUID
     */
    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    /**
     * Calculate age from date of birth
     */
    public static int calculateAge(LocalDate dateOfBirth) {
        if (dateOfBirth == null) {
            return 0;
        }
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    /**
     * Validate email format
     */
    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }

    /**
     * Validate phone number format
     */
    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            return false;
        }
        String phoneRegex = "^\\+?[1-9]\\d{1,14}$";
        return phoneNumber.replaceAll("[\\s()-]", "").matches(phoneRegex);
    }

    /**
     * Capitalize first letter of string
     */
    public static String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    /**
     * Format currency
     */
    public static String formatCurrency(Double amount) {
        if (amount == null) {
            return "R0.00";
        }
        return String.format("R%.2f", amount);
    }

    /**
     * Check if string is null or empty
     */
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    /**
     * Validate salary amount
     */
    public static boolean isValidSalary(Double salary) {
        return salary != null && salary > 0;
    }

    /**
     * Calculate days between two dates
     */
    public static long daysBetween(LocalDate startDate, LocalDate endDate) {
        if (startDate == null || endDate == null) {
            return 0;
        }
        return java.time.temporal.ChronoUnit.DAYS.between(startDate, endDate);
    }

    /**
     * Check if date is in future
     */
    public static boolean isFutureDate(LocalDate date) {
        if (date == null) {
            return false;
        }
        return date.isAfter(LocalDate.now());
    }

    /**
     * Check if date is in past
     */
    public static boolean isPastDate(LocalDate date) {
        if (date == null) {
            return false;
        }
        return date.isBefore(LocalDate.now());
    }
}

