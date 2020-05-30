package mediator_and_factory;

public class User {
	private int ID;
	private String warning;
	
	public User()
	{
		ID = ++Globals.GUID;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public void setWarning(String s)
	{
		warning = s;
	}
	
	public void printWarning()
	{
		if(warning != null)
		{
			System.out.println("Warn user with ID: " + ID + "that the message text send: " + warning + " is prohibited for the room!");
		}
	}
}
