package Drivers;
import java.util.Vector;
import Location.Location;
public class Driver
{
	
	private String drivername;
	private char gender;
	private int age;
	private String carname;
	private String carnumber;
	private Location loc;
	private Boolean available;
    public Vector<Integer> totalEarning = new Vector<Integer>();

	public Driver()
	{
		drivername="";
		gender=0;
		age=0;
		carname="";
		carnumber="";
		available=true;
	}
	
	public void add_driver(String driverDetails,String carDetails,Location loc1)
	{
		String[] splitdata = driverDetails.split(",");
		this.drivername=splitdata[0].trim();;
		this.gender=splitdata[1].charAt(0);;
        this.age=Integer.parseInt(splitdata[2].trim());
		String[] cardata = carDetails.split(",");
		this.carname=cardata[0].trim();
		this.carnumber=cardata[1].trim();
		this.loc=loc1;
	}
	  public void setDriverName(String X)
	 	{
	    	 drivername=X;
	 	}
	 	public String getDriverName()
	 	{
	 		return drivername;
	 	}
	    public void setStatus(Boolean X)
	  	{
	    	available=X;
	  	}
	  	public Boolean getStatus()
	  	{
	  		return available;
	  	}
	public void setLoc(Location X)
	{
	  loc=X;
	}
	public Location getLoc()
	{
		return loc;
	}
}