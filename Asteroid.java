
/**
 * This is a class to create asteroids in the Solar system.
 * It extends planet as it can then inherit the variables and methods from the class.
 * It also implements a new interface which ensures it uses a couple of methods.
 */
public class Asteroid extends Planet implements SolarObjectAboutInterface
{
    //Variables that don't change once set like colour, diameter and distance are set to final so they don't change.
	private double centreOfRotationDistance;
	private double centreOfRotationAngle;
    
	/**
	 * This creates a new instance of asteroid. 
	 * It also calls super meaning its superclass is Planet and it calls the constructor for planet in asteroid.
	 * @param distance The distance from the asteroid to the sun.
	 * @param angle The angle of the asteroid from the sun.
	 * @param diameter The diameter of the asteroid.
	 * @param col The colour of the asteroid.
	 * @param centreOfRotationDistance The distance from the asteroid to the thing it is oribiting.
	 * @param centreOfRotationAngle The angle from the thing the asteroid is oribiting to the asteroid.
	 */
	public Asteroid(double distance, double angle, double diameter, String col, double centreOfRotationDistance, double centreOfRotationAngle)
	{
		super(distance, angle, diameter, col);
		this.centreOfRotationDistance = centreOfRotationDistance;
		this.centreOfRotationAngle = centreOfRotationAngle;
	}
		
	/**
	 * This allows the user to get the centreOfRotationDistance to use it for calculations in SolarSystem.
	 * @return the value of centreOfRotationDistance.
	 */
	public final double GetCentreOfRotationDistance()
    {
        return centreOfRotationDistance;   
    }

	/**
	* This allows the user to get the centreOfRotationAngle to use it for calculations in SolarSystem.
	* @return the value of centreOfRotationAngle.
	*/
    public final double GetCentreOfRotationAngle()
    {
        return centreOfRotationAngle;   
    }

	/**
    * Sets the distance at which the asteroid is from the thing that it is rotating about to the new value given.
    * @param newDistance The new value of the distance between the asteroid and the thing it is orbiting.
    */
	public final void SetCentreOfRotationDistance(double newDistance)
    {
        centreOfRotationDistance = newDistance;   
    }

	/**
    * Sets the angle at which the asteroid is at to the thing it is orbiting to the new value given.
    * @param newAngle The new value of the angle between the asteroid and the thing it is orbiting.
    */
    public final void SetCentreOfRotationAngle(double newAngle)
    {
        centreOfRotationAngle = newAngle;   
    }
}