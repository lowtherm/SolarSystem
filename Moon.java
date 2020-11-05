
public class Moon extends Planet implements SolarObjectAboutInterface
{
    //Variables that don't change once set like colour, diameter and distance are set to final so they don't change.
	private double centreOfRotationDistance;
	private double centreOfRotationAngle;
    
	/**
	* This creates a new instance of moon.
	* @param distance The distance from the moon to the sun.
	* @param angle The angle of the moon from the sun.
	* @param diameter The diameter of the moon.
	* @param col The colour of the moon.
	* @param centreOfRotationDistance The distance from the moon to the thing it is oribiting.
	* @param centreOfRotationAngle The angle from the thing the moon is oribiting to the moon.
	*/
	public Moon(double distance, double angle, double diameter, String col, double centreOfRotationDistance, double centreOfRotationAngle)
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
    * Sets the distance at which the moon is from the thing that it is rotating about to the new value given.
    * @param newDistance The new value of the distance between the moon and the thing it is orbiting.
    */
	public final void SetCentreOfRotationDistance(double newDistance)
    {
        centreOfRotationDistance = newDistance;   
    }

	/**
    * Sets the angle at which the moon is at to the thing it is orbiting to the new value given.
    * @param newAngle The new value of the angle between the moon and the thing it is orbiting.
    */
    public final void SetCentreOfRotationAngle(double newAngle)
    {
        centreOfRotationAngle = newAngle;   
    }
}