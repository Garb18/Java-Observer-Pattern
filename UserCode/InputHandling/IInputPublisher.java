package UserCode.InputHandling;

import Framework.Interfaces.IInput;

/**
 * Write a description of interface IInputPublisher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface IInputPublisher
{
    /**
     * An example of a method header - replace this comment with your own
     */
    
    void Initialise(IInput InputCapture);
    
    void subscribe(IInputListener L);
    
    void unsubscribe(IInputListener L);
}
