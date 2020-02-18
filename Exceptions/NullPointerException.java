package Exceptions;


/**
 * The NullPointerException class:
 * an instance is thrown when an attempt to use reference to a null pointer is made.
 * 
 * @author Marc Price 
 * @version 0.6
 */
public class NullPointerException extends Exception
{
    // instance variables - none

    /**
     * Constructor for objects of class NullPointerException
     * 
     * @param message a String for the 'thrower' to provide extra information about the exception
     */
    public NullPointerException(String message)
    {
        // PASS message to superclass:
        super(message);
    }

}
