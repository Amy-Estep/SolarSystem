
public class Planet {
    
    
    private final String name;
    private final double mass; 
    private final double radius; 
    private final double distance;  
    private final double period;
    private final double gravity;
    private static final double DECIMAL_CONVERT = 1000.0; /* used to convert values to 3dp must be defined
    as 1000.0 is a magic number */
    private static final double CUBED_FOR_DISTANCE = 3; /* used in calculation of period must be defined as
    3 is a magic number */

    public Planet(String name, double mass, double radius, double distance) { //class constructor
        this.name = name;
        this.mass = Math.round(mass*DECIMAL_CONVERT)/DECIMAL_CONVERT;
        this.radius = radius;
        this.distance = Math.round(distance*DECIMAL_CONVERT)/DECIMAL_CONVERT;
        period = Math.round(Math.sqrt(Math.pow(distance, CUBED_FOR_DISTANCE))*DECIMAL_CONVERT)/DECIMAL_CONVERT;
        gravity = Math.round(mass/Math.pow(radius, 2)*DECIMAL_CONVERT)/DECIMAL_CONVERT;
        
    }

    public double getMass() {
        return mass;
    }

    public double getDistance() {
        return distance;
    }
    
    
    
    @Override
    public String toString(){

        String output = name+" has a mass of "+mass+" Earths with a surface gravity"
                + " of "+gravity+"g, is "+distance+"AU from its star, and orbits in "+period+" years: could"
                + " be habitable? ";
        return output;
    }
}
