package UserCode;

import Framework.Interfaces.IUpdatable;

/**
 * Write a description of class UpdatableFactory here.
 * 
 * @author Marc Price 
 * @version 0.1
 */
public class UpdatableFactory implements IUpdatableFactory
{
    // instance variables - none

    /**
     * Constructor for objects of class UpdatableFactory
     */
    public UpdatableFactory()
    {
    }

    /**
     * Create a new IUpdatable instance and return it.
     * 
     * @param rqdClass the implementation type of IUpdatable to be instantiated
     * @return the new IUpdatable instance
     */
    public <T extends IUpdatable> IUpdatable create(Class<T> rqdClass) throws Exception
    {
        // INSTANTIATE new IUpdatable, call it 'newObject':
        IUpdatable newObject = rqdClass.newInstance();
        
        // RETURN new IUpdatable:
        return newObject;
    }
}
