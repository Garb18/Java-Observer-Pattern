package UserCode;

///////////////////////////////////////////////////////////////////////////////////////////////////
// Notes:
// * Add code to this as necessary to produce your simulation.
// * Use comments to clearly highlight your code that has been added.
// * Acknowledge/cite appropriately any added code that is not your own.
///////////////////////////////////////////////////////////////////////////////////////////////////
import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import env3d.Env;
import Framework.Interfaces.*;
import Framework.Implementations.*;
import Exceptions.*;
import UserCode.Animals.*;
import UserCode.InputHandling.*;

/**
 * Simulation is the top-level class for the Aquarium simulation.
 * 
 * @author (your name here!) and Marc Price
 * @version 0.6
 */
public class Simulation implements IInputListener
{
    // instance variables:
    // DECLARE a reference to the IWorld, call it '_world':
    private IWorld _world;
    
    // DECLARE a reference to the IInput, call it '_input':
    private IInput _input;

	// DECLARE a reference to the IInputPublisher, call it '_inputPublisher':
	private IInputPublisher _inputPublisher;
    
    // DECLARE a list for updatables, call it '_updatables':
    private List<IUpdatable> _updatables;
       
    // DECLARE a reference to an IUpdatableFactory, call it '_factory':
    private IUpdatableFactory _factory;
	
	//DECLARE a boolean that signals when a lion should be placed:
	private boolean _newLion = false;

	//DECLARE an array of ints that stores the position of the mouse:
	private int[] _mouseVal = {-1,-1};

    // DECLARE a boolean that signals when the simulation loop should be exited:
    private boolean endSim = false;

    
    /**
     * METHOD: Static Main method used for creating standalone apps
     *
     */
    public static void main(String[] args) throws Exception
    {
        Simulation sim = new Simulation();
        sim.run();
    }
    
    
    /**
     * Constructor for objects of class Simulation
     */
    public Simulation()
    {
        // INITIALISE instance variables:
        // _factory:
        _factory = new UpdatableFactory();
        
        // _updatables:
        _updatables = new ArrayList<IUpdatable>();
        
        // _world:
        try
        {
            _world = ((IWorld) _factory.create(Core.class));

        	// _input:
        	_input = (IInput) _world;

			_inputPublisher = ((IInputPublisher) _factory.create(MouseHandler.class));

			_inputPublisher.Initialise(_input);
        }
        catch(Exception e)
        {
            // do nothing
        }        
        
        // ADD _world implementation to _updatables:
        _updatables.add((IUpdatable) _world);

		// ADD _inputPublisher implementation to _updatables:
		_updatables.add((IUpdatable) _inputPublisher);
		
		//SUBSCRIBE this simulation to observer
		_inputPublisher.subscribe(this);

    }

	public void onInput(int ...data)
	{
		_newLion = true;

		_mouseVal = data;
	}

    /**
     * METHOD: Run the simulation loop.  User presses escape to exit.
     *
     */
    public void run()
    {
        // Create the 3D world:
        _world.create();
        
        // User try - catch to ensure 3D world was successfully created:
        try
        {
        
            // Start simulation loop:
            while (!endSim)
            {
                // UPDATE STAGE:
                // IF: user has requested simulation loop exit (ie escape pressed):
                if (_input.getKey() == 1)
                {
                    // SET: render loop exit condition
                    endSim = true;
                }
                
                // ADD lions when requested via mouse input...                
                // Check if new lion requested:
                if (_newLion)
                {                    
                    // COMPUTE the position/orientation for the lion from mouseVal:
                    Double[] posn = {_mouseVal[0]*0.0077, _mouseVal[1]*0.0077, 1.0};
                    Double[] angle = {0.0,90.0,0.0};
                    
                    try
                    {
                        // INSTANTIATE the new lion as an IUpdatable, call it 'lion':
                        IUpdatable lion = _factory.create(Lion.class);
                        
                        // ADD lion to _updatables:
                        _updatables.add(lion);
                        
                        // SPAWN lion in 3D world:
                        ((ISpawnable) lion).spawn(_world, posn[0], posn[1], posn[2], angle[0], angle[1], angle[2]);
                    }
                    catch (Exception e)
                    {
                        // do nothing
                    }        
                }
            
                // UPDATE 3D objects and world...
                // (Iterate through _updatables in reverse)
                // CREATE an Iterator for _updatables, pointing at end of list, call it _updateIterator:
                ListIterator<IUpdatable> _updateIterator = _updatables.listIterator(_updatables.size());
                
                // UPDATE _updatables in reverse order (so that 3D world is updated last):
                while (_updateIterator.hasPrevious())
                {
                    _updateIterator.previous().update();
                }
            }
        
            // EXIT: cleanly by closing-down the environment:
            _world.destroy();
        }
        catch (WorldDoesNotExistException e)
        {
            System.out.println(e.getMessage());
        }

    }

}
