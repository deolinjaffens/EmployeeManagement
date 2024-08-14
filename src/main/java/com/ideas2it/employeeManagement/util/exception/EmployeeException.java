package com.ideas2it.employeeManagement.util.exception;

/**
 * <p>
 * Handles all the exception that are related to the application
 * </p>
 *
 * @author Deolin Jaffens
 */

public class EmployeeException extends RuntimeException {

    /**
     * <p>
     * Only the error message is thrown
     * </p>
     * @param errorMessage - message that has to be thrown when an exception occurs
     */

    public EmployeeException(String errorMessage) {
        super(errorMessage);
    }

    /**
     * <p>
     * Returns the error message along with the cause of the exception
     * </p>
     *
     * @param errorMessage - message that has to be thrown when an exception occurs
     * @param cause        - cause of the specific exception
     */

    public EmployeeException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
