package demo.security;

public class User 
{
	String name;
	String IP;
	
	public User(String name, String IP)
	{
		this.name = name;
		this.IP = IP;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getIP() 
	{
		return IP;
	}

	public void setIP(String iP) 
	{
		IP = iP;
	}
}