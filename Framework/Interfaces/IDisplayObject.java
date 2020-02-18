package Framework.Interfaces;


/**
 * The IDisplayObject instance contains all the data for displaying something by an IWorld instance.
 * 
 * @author (Marc Price) 
 * @version (19.12.2018)
 */
public interface IDisplayObject
{
    /**
     * METHOD: translate the IDisplayObject along x,y,z axes
     * @param xTranslation double giving the change in position along x axis.
     * @param yTranslation double giving the change in position along y axis.
     * @param zTranslation double giving the change in position along z axis.
     */
    void translate(double xTranslation, double yTranslation, double zTranslation);
    
    /**
     * METHOD: rotate the IDisplayObject about x,y,z axes
     * @param xRotation double giving the change in orientation about x axis.
     * @param yRotation double giving the change in orientation about y axis.
     * @param zRotation double giving the change in orientation about z axis.
     */
    void rotate(double xRotation, double yRotation, double zRotation);

}
