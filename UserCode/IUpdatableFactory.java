package UserCode;

import Framework.Interfaces.IUpdatable;

/**
 * IUpdatableFactory interface - all implementations can create instances of IUpdatable.
 * 
 * @author Marc Price 
 * @version 0.1
 */
public interface IUpdatableFactory
{
    /**
     * Create a new IUpdatable instance and return it.
     * 
     * @param rqdClass the implementation type of IUpdatable to be instantiated
     * @return the new IUpdatable instance
     */
    <T extends IUpdatable> IUpdatable create(Class<T> rqdClass) throws Exception;
}
