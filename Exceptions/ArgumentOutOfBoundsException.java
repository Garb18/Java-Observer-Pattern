package Exceptions;


/**
 * The ArgumentOutOfBoundsException class:
 * used to flag when a parameter is outside the defined range of values.
 * 
 * @author Marc Price 
 * @version 0.6
 */
public class ArgumentOutOfBoundsException extends Exception
{
    // instance variables - none

    /**
     * Constructor for objects of class ArgumentOutOfBoundsException
     * 
     * @param   message a String for the 'thrower' to provide extra information about the exception
     */
    public ArgumentOutOfBoundsException(String message)
    {
        // PASS message to superclass:
        super(message);
    }

 
}