
/**
 * This is the planet class where planets can be created and information about them can be retrieved or altered.
 */
public class Planet implements PlanetInterface
{
    //Variables that don't change once set like colour, diameter and distance are set to final so they don't change.
	private final double distance;
	private double angle;
	private final double diameter;
    private final String col;
    
    /**
     * This is the constructor to create a new planet.
     * @param distance The distance from the planet to the sun.
     * @param angle The angle from the sun to the planet in degrees.
     * @param diameter The diameter of the planet.
     * @param col The colour of the planet.
     */
	public Planet(double distance, double angle, double diameter, String col)
	{
		this.distance = distance;
		this.angle = angle;
		this.diameter = diameter;
		this.col = col;
	}
    /**
     * This gets the value of the distance for the particular planet.
     * It is final to stop it being overridden.
     * @return the distance from the planet to the sun.
     */
    public final double GetDistance()
    {
        return distance;   
    }

    /**
     * This gets the value of the angle for the particular planet.
     * It is final to stop it being overridden.
     * @return the angle from the sun to the planet in degrees.
     */
    public final double GetAngle()
    {
        return angle;   
    }

    /**
     * This gets the value of the diameter for the particular planet.
     * It is final to stop it being overridden.
     * @return the diameter of the planet.
     */
    public final double GetDiameter()
    {
        return diameter;   
    }

    /**
     * This gets the colour of the particular planet.
     * It is final to stop it being overridden.
     * @return the colour of the planet.
     */
    public final String GetColour()
    {
        return col;   
    }

    /**
     * Sets the angle at which the planet is at to the new value given.
     * @param newAngle The new value of the angle between the sun and the planet.
     */
    public final void SetAngle(double newAngle)
    {
        angle = newAngle;   
    }
}