package mediator_and_factory;

public class Message {
	private String string;
	private int userID;
	
	public Message(int userID, String message)
	{
		this.userID = userID;
		this.string = message;
	}
}
