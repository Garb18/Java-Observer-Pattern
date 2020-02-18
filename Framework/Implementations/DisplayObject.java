package Framework.Implementations;

import Framework.Interfaces.*;


/**
 * The DisplayObject contains all the data for displaying something by a Core instance.
 * 
 * @author (Marc Price) 
 * @version 0.6
 */
public class DisplayObject implements IDisplayObject
{
    // Env3d-defined object-specific fields:
    // Reference to the 3D model, called 'model':
    protected String model;
    
    // Reference to texture-map, called 'texture':
    protected String texture;
    
    // Scale factor applied to model:
    private double scale=1.0;
    
    // Position in 3D world (x,y,z coordinates):
    private double x=0, y=0, z=0;
    
    // Orientation (about x,y,z):
    private double rotateX=0, rotateY=0, rotateZ=0;
    
    // Set transparency to true:
    private boolean transparent=true;

    /**
     * Constructor for objects of class DisplayObject
     */
    public DisplayObject(String model, String tex, double scale)
    {
        // initialise instance variables
        this.scale = scale;
        this.model = model;
        this.texture = tex;
    }
    
    
    // ------------------ IMPLEMENTATION OF IDisplayObject --------------------//
    /**
     * METHOD: translate the IDisplayObject along x,y,z axes
     * @param xTranslation double giving the change in position along x axis.
     * @param yTranslation double giving the change in position along y axis.
     * @param zTranslation double giving the change in position along z axis.
     */
    public void translate(double xTranslation, double yTranslation, double zTranslation)
    {
        this.x += xTranslation;
        this.y += yTranslation;
        this.z += zTranslation;
    }
    
    /**
     * METHOD: rotate the IDisplayObject about x,y,z axes
     * @param xRotation double giving the change in orientation about x axis.
     * @param yRotation double giving the change in orientation about y axis.
     * @param zRotation double giving the change in orientation about z axis.
     */
    public void rotate(double xRotation, double yRotation, double zRotation)
    {
        this.rotateX += xRotation;
        this.rotateY += yRotation;
        this.rotateZ += zRotation;
    }
    
}
