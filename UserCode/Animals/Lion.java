package UserCode.Animals;

import Framework.Interfaces.IWorld;
import Framework.Interfaces.IUpdatable;
import Framework.Interfaces.IDisplayObject;
import Framework.Implementations.DisplayObject;
import Exceptions.*;

/**
 * Lion class - represents a lion.
 * 
 * @author Marc Price 
 * @version 0.1
 */
public class Lion implements IUpdatable, ISpawnable
{
    // constants:
    // SET the path to _displayObject's model as a String, call it _model:
    private static final String _model = "models/billboard/billboard.obj";
    
    // SET the path to _displayObject's texture as a String, call it _texture:
    private static final String _texture = "textures/lion128.png";
    
    // instance variables:
    // DECLARE an IDisplayObject to represent this Lion, call it _displayObject:
    private IDisplayObject _displayObject;
    

    /**
     * Constructor for objects of class Lion
     */
    public Lion()
    {
        // INSTANTIATE _displayObject:
        _displayObject = new DisplayObject(_model, _texture, 0.5);
    }
    
    // ---------------------- IMPLEMENTATION OF ISpawnable --------------------------- //
    /**
     * METHOD: spawn the Lion at the given position/orientation
     * @param world IWorld representing the 3D world.
     * @param Positionn double giving the position coordinates (x,y,z).
     * @param yPosn double giving the position along y axis.
     * @param zPosn double giving position along z axis.
     * @param xOrientation double giving the orientation about x axis.
     * @param yOrientation double giving the orientation about y axis.
     * @param zOrientation double giving orientation about z axis.
     */
    public void spawn(IWorld world, double xPosn, double yPosn, double zPosn, double xOrientation, double yOrientation, double zOrientation)
        throws WorldDoesNotExistException
    {
        // SET position of Lion by translating _displayObject:
        _displayObject.translate(xPosn, yPosn, zPosn);
        
        // SET orientation of Lion by rotating _displayObject:
        _displayObject.rotate(xOrientation, yOrientation, zOrientation);
        
        // ADD to 3D world:
        world.addDisplayObject(_displayObject);
    }
    
    // ------------------------- IMPLEMENTATION OF IUpdatable ---------------------------- //
    /**
     * METHOD: change to Lion for next frame
     */
    public void update()
    {
        // Do nothing at the moment
    }
}
