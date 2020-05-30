package mediator_and_factory;

public class Main {
	public static void main(String[] args) {
		Mediator mediator = new Mediator();
		Room room = mediator.createRoom();
		
		//NOTE internally gives each user an ID
		User user1 = mediator.createUser(user_type.UNREGISTERED);
		User user2 = mediator.createUser(user_type.REGISTERED);
		User user3 = mediator.createUser(user_type.REGISTERED);
		
		mediator.addUserToRoom(user1, room.getID());
		mediator.addUserToRoom(user2, room.getID());
		mediator.addUserToRoom(user3, room.getID());
		
		mediator.sendMessage(room.getID(), user1.getID(), "My message!");
		mediator.sendMessage(room.getID(), user2.getID(), "My second message!");
		mediator.sendMessage(room.getID(), user3.getID(), "cat");
		mediator.sendMessage(room.getID(), user1.getID(), "My message adsads");
		mediator.sendMessage(room.getID(), user2.getID(), "addBot");
		mediator.sendMessage(room.getID(), user3.getID(), "cat");
		mediator.sendMessage(room.getID(), user1.getID(), "My message!");
		mediator.sendMessage(room.getID(), user2.getID(), "My message!");
	}
}
