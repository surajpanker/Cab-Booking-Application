package Demo;
import Rides.Ride;

public class Demo 
{
	//demo class
    public static void main (String[] args)
    {
    	//data users and drivers
    	int numusers=3;
    	int numdrivers=3;
    	//start ride
    	Ride startRide=new Ride(numusers, numdrivers);
    	startRide.start();
    	
    }
}
