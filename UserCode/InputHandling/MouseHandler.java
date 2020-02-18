package UserCode.InputHandling;

import Framework.Interfaces.IInput;
import Framework.Interfaces.IUpdatable;

import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class InputHandling here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MouseHandler implements IInputPublisher, IUpdatable
{
    // instance variables:
    private List<IInputListener> _listeners;
    
    private IInput _inputCapture;

    /**
     * Constructor for objects of class InputHandling
     */
    public MouseHandler()
    {
        _listeners = new ArrayList<IInputListener>();
    }
    
    public void Initialise(IInput InputCapture)
    {
        _inputCapture = InputCapture;
    }
    
    public void subscribe (IInputListener L)
    {
        _listeners.add(L);
    }    
    
    public void unsubscribe (IInputListener L)
    {
        _listeners.remove(L);
    }
    
    public void update()
    {
        int[] mouseVal;
        
        try
        {
            if(0 == _inputCapture.getMouseClicked())
            {
                mouseVal = _inputCapture.getMousePointer();
                
                for(IInputListener L: _listeners)
                {
                    L.onInput(mouseVal);
                }
            }
        }
        catch(Exception e)
        {
            //Do nothing
        }
    }
}
