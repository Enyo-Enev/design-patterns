package mediator_and_factory;

public class Bot {

	private static Bot single_instance = null;
	
	public boolean IsMessageProhibited(String message)
	{
		boolean result = false;
		
		if(message.equals("cat"))
		{
			result = true;
		}
		
		return result;
	}
	
	public static Bot getInstance()
	{
		if(single_instance == null)
			single_instance = new Bot();
		
		return single_instance;
	}
}
