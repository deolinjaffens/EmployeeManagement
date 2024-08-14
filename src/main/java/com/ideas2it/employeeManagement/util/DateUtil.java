package com.ideas2it.employeeManagement.util;

import java.time.LocalDate;
import java.time.Period;

/**
 * <p>
 * All the date operations are performed
 * </p>
 *
 * @author Department
 */

public class DateUtil {

    /**
     * <p>
     * Calculates the age for a specific person
     * </p>
     *
     * @param dob - date from which age has to be calculated
     * @return Age of a person in years and months
     */

    public static String calculateAge(LocalDate dob) {
        return Period.between(dob, LocalDate.now()).getYears() + " Years " + Period.between(dob, LocalDate.now()).getMonths() + " Months ";
    }
}
