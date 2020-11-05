/**
 * This is an interface which specifies what the planet class must include as methods.
 * This provides total abstraction.
 */
public interface PlanetInterface
{
    void setAngle(double n);

    double getDistance();
    double getAngle();
    double getDiameter();
    String getColour();
}