package mediator_and_factory;
import java.util.ArrayList;

public class Mediator {
	private ArrayList<Room> rooms;
	private UserFactory userFactory;
	
	public Mediator()
	{
		userFactory = new UserFactory();
		rooms = new ArrayList<Room>();
	}
	
	public Room createRoom()
	{
		Room room = new Room();
		rooms.add(room);
		return room;
	}
	
	public Room getRoom(int roomID)
	{
		Room room = null;
		
		for(int r = 0; r < rooms.size(); r++)
		{
			if(roomID == rooms.get(r).getID())
			{
				room = rooms.get(r);
			}
		}
		
		return room;
	}
	
	public User createUser(user_type type)
	{
		return userFactory.getNewUserForType(type);
	}
	
	public void addUserToRoom(User user, int roomID)
	{
		Room room = getRoom(roomID);
		if(room != null)
		{
			room.addUser(user);
		}
	}
	
	public boolean sendMessage(int roomID, int userID, String message)
	{
		boolean success = false;
		Room room = getRoom(roomID);
		if(room != null)
		{
			success = room.sendMessage(userID, message);
		}
		return success;
	}
}
