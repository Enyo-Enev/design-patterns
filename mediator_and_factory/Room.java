package mediator_and_factory;
import java.util.ArrayList;
import java.util.Stack;

public class Room {

	private int ID;
	private ArrayList<User> addedUsers;
	//NOTE: the messages are available only to the room, right?
	private Stack<Message> messages;
	private Bot bot;
	
	public Room()
	{
		addedUsers = new ArrayList<User>();
		messages = new Stack<Message>();
		ID = ++Globals.RGUID;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public ArrayList<User> getAllUsers()
	{
		return addedUsers;
	}
	
	public void addUser(User user)
	{
		addedUsers.add(user);
	}
	
	public void deleteUser(int index) 
	{
		addedUsers.remove(index);
	}
	
	private void warnAllUsers(String message)
	{
		for(int i = 0; i < addedUsers.size(); i++)
		{
			User u = addedUsers.get(i);
			u.setWarning(message);
			u.printWarning();
		}
	}
	
	public boolean sendMessage(int userID, String message)
	{
		boolean success = false;
		//NOTE: could also be a hash  instead of a ArrayList, but the size is usually very small
		int resultID = 0;
		int listLoc = Integer.MAX_VALUE;
		for(int i = 0; i < addedUsers.size(); i++)
		{
			User user = addedUsers.get(i);
			if(user.getID() == userID)
			{
				resultID = user.getID();
				listLoc = i;
			}
		}
		
		//NOTE: zero is an invalid id. Starts from 1
		if(resultID != 0)
		{
			if(message != null)
			{
				messages.push(new Message(resultID, message));
				
				if(message.equals("addBot"))
				{
					bot = Bot.getInstance();
				}
				else if(bot != null)
				{
					if(bot.IsMessageProhibited(message))
					{
						deleteUser(listLoc);
						warnAllUsers(message);
					}
				}
			}
		}
		
		return success;
	}
}
