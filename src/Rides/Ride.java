package Rides;
import java.util.*;
import Drivers.Driver;
import Users.User;
import Location.Location;

//Ride class
 public class Ride 
{
	//store into user and drivers array data 
    static User[] users;
    static Driver[] drivers;
    static int nuser;
    static int ndriver;
    
    //default constructor
    public Ride() 
    {
    	
    }
    
    //Parameterized constructor 
	public Ride(int n_user,int n_driver)
	{	
		//assignment users and drivers
		nuser=n_user;
		ndriver=n_driver;
		users=new User[nuser];
		drivers=new Driver[ndriver]; 
		
		//allocate memory users and drivers
		for(int i=0;i<nuser;i++)
			users[i] = new User();
		
		for(int i=0;i<ndriver;i++)
			drivers[i] = new Driver();
		
	}
    //update user information
	public static void update_user(String username, String updated_details)
    { 
		
    	for(int i=0;i<nuser;i++)
    	{
    		
    		if(compare(users[i].getUser(),username))
    		{
    			String[] splitdata = updated_details.split(",");
    			users[i].setUser(splitdata[0].trim());
    			users[i].setGender(splitdata[1].charAt(0));
    			users[i].setAge(Integer.parseInt(splitdata[2].trim()));
    		}
    	}
    }
	//update user location
    public static void update_userLocation(String username, Location updateloc)
    { 
    	for(int i=0;i<nuser;i++)
    	{
    		if(compare(users[i].getUser(),username))
    		{
    			users[i].setLoc(updateloc);

    		}
    	}
    }
	//update driver location
    public static void update_driverLocation(String drivername, Location updateloc)
    { 
    	for(int i=0;i<nuser;i++)
    	{
    		if(compare(drivers[i].getDriverName(),drivername))
    		{
    			drivers[i].setLoc(updateloc);

    		}
    	}
    }
	//user uses find_ride method 

    static Vector<Driver> find_ride(String username,Location source,Location destination )
    {
    	Vector<String> dataDriver=new Vector<String>();
    	Vector<Double> distance=new Vector<Double>();
    	Map<Driver,Double> map=new HashMap<Driver,Double>();          
    	for(int i=0;i<nuser;i++)
    	{ 

    		if(compare(users[i].getUser(),username))
    		{
    			
    			users[i].setDis(destination);
    		}
    		
    	}
    	
    	Vector<Driver> dataDrivers=new Vector<Driver>();
    	for(int i=0;i<ndriver;i++)
    	{  
    		
    		int x1=source.x;
    		int x2=drivers[i].getLoc().x;
    		int y1=source.y;
    		int y2= drivers[i].getLoc().y;
    		double dis=Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
    		if(dis<=5)
    			map.put(drivers[i], dis);
    		
    	}
    	
    	map.entrySet()  
        //Returns a sequential Stream with this collection as its source  
        .stream()  
        //Sorted according to the provided Comparator  
        .sorted(Map.Entry.comparingByValue());
    	 for (Map.Entry<Driver,Double> entry : map.entrySet())
    	 {
    		 dataDrivers.add(entry.getKey());
    		 
    	 }
             
    	
    	return dataDrivers;
    }
    
    //helper function
    private static Boolean compare(String Username1,String Username2)
    {
    	
    		if(Username1.trim().compareTo(Username2.trim())==0)
        		return true;

        	return false;
    }
    //choose ride 
    public static void choose_ride(String Username,String drive_name)
    {
    	int x1 = 0,y1=0;
    	int disX=0;
    	int disY=0;
    	for(int i=0;i<nuser;i++)
    	{
				if(compare(users[i].getUser(),Username))
				{
					
					x1=users[i].getLoc().x;
					y1=users[i].getLoc().y;
					disX=users[i].getDis().x;
					disY=users[i].getDis().y;
				}
			
    		
    	}

    	for(int i=0;i<ndriver;i++)
    	{  
    	 	  
        		if(compare(drivers[i].getDriverName(),drive_name))
        		{
            		int x2=drivers[i].getLoc().x;
            		int y2= drivers[i].getLoc().y;

            		double dis=Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
            		if(dis<=5)
            		{
            		System.out.println("ride Started");

            		}
            		double t=calculateBill(Username);
            		drivers[i].totalEarning.add((int)t);
            		System.out.println("ride Ended bill amount $"+ t);
            		Location newloc=new Location(disX,disY);
            		//Back-end APi
            		update_userLocation(Username,newloc);
            		update_driverLocation(drive_name,newloc);		
            		
        		}
        	
    	}
    }
     static double calculateBill(String username)
    {
    	for(int i=0;i<nuser;i++)
    	{ 

    		if(compare(users[i].getUser(),username))
    		{
    			int x2=users[i].getDis().x;
        		int y2= users[i].getDis().y; 
        		int x1=users[i].getLoc().x;
        		int y1= users[i].getLoc().y; 
        		double dis=Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
//        		int t=0;
//        		System.out.println(Math.ceil(dis)+"  "+x1+y1+" "+x2+y2);
        		return Math.ceil(dis);
        		

    		}
    		
    	}
    	return 0;
    }
    
    
    
    public static void change_driver_status(String drivername,Boolean status)
    {
    	for(int i=0;i<ndriver;i++)
    	{  
    	 	  
        		if(compare(drivers[i].getDriverName(),drivername))
        		{
        			drivers[i].setStatus(status);
            		
        		}
        	
    	}
    }
    public static void find_total_earning()
    {
    	for(int i=0;i<ndriver;i++)
    	{  
    	 	  
        	int sum=0;
        
        	 for(Integer value: drivers[i].totalEarning)
        	 {
             	sum+=value;
        	}
        	
        	System.out.println(drivers[i].getDriverName()+" earn$"+sum);
    	}
    }

    public  void start()
    {
    	  	Location lu1=new Location(0,0);
			Location lu2=new Location(10,0);
			Location lu3=new Location(15,6);
			update_userLocation("Abhishek",lu1);

	    	update_userLocation("Rahul",lu2);
	        update_userLocation("Nandini",lu3);


    	users[0].add_user("Abhishek, M,23");
        
     //  Location lu1=new Location(0,0);
    	update_userLocation("Abhishek",lu1);
    	
        users[1].add_user("Rahul, M, 29");
        
      //  Location lu2=new Location(10,0);
    	update_userLocation("Rahul",lu2);
    	
        users[2].add_user("Nandini, F, 22");
        update_userLocation("Nandini",lu3);


        Location ld1=new Location(10,1);
        Location ld2=new Location(11,10);
        Location ld3=new Location(5,3);

        drivers[0].add_driver("Driver1, M, 22","Swift, KA-01-12345",ld1);
        drivers[1].add_driver("Driver2, M, 29","Swift, KA-01-12345",ld2);
        drivers[2].add_driver("Driver3, M, 24","Swift, KA-01-12345",ld3);
        Location ld=new Location(20,1);

        Vector<Driver> driverdata=find_ride("Abhishek1" ,lu1,ld);
        if(driverdata.size()==0)
        {
        	System.out.println("No ride found [Since all the driver are more than 5 units away from user]");
        }
        Location locdata=new Location(15,3);
     

      Vector<Driver> avadata=find_ride("Rahul" ,ld1,locdata);
        if(avadata.size()>0)
        {
        	 for(Driver value: avadata)
        	 {
             	System.out.println(value.getDriverName()+"[Available]");

        	 }
        }
//        }
        choose_ride("Rahul","Driver1");
        change_driver_status("Driver1",false);
        Location locdata1=new Location(15,6);
        Location locdata2=new Location(20,4);

        Vector<Driver> avadata1=find_ride("Nandini" ,ld1,locdata);
        if(avadata1.size()>0)
        {
        	 for(Driver value: avadata1)
        	 {
        		 if(value.getStatus())
        			 System.out.println(value.getDriverName()+"[Available]"+value.getStatus());
        		 else 
        		 {
        			 System.out.println("No ride found"+" ["+value.getDriverName()+ "one in set to not available]");

        		 }

        	 }
        }
        find_total_earning();
    }
}
