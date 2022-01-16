package Users;

import Location.Location;

public class User
{
	
	private String username;
	private char gender;
	private int age;
	private Location loc;
	private Location dis;
	
	
	public User()
	{
		this.username="";
		this.gender=0;
		this.age=0;
		loc=new Location();
		dis=new Location();

	}
	
	public void add_user(String details)
	{
		String[] splitdata = details.split(",");
		this.username=splitdata[0].trim();
		this.gender=splitdata[1].charAt(0);
        this.age=Integer.parseInt(splitdata[2].trim());
        

	}
	public void setUser(String user)
	{
		username=user;
	}
	public String getUser()
	{
		return username;
	}
    
	public void setAge(int age1)
	{
		age=age1;
	}
	public int getAge()
	{
		return age;
	}
	public void setGender(char gen)
	{
		gender=gen;
	}
	public int getGender()
	{
		return gender;
	}
	public void setDis(Location X)
	{
		dis=X;
	}
	public Location getDis()
	{
		return dis;
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
