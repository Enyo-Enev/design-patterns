package mediator_and_factory;

enum user_type
{
	INVALID,
	REGISTERED,
	UNREGISTERED,
	COUNT
};

public class UserFactory {
	
	public User getNewUserForType(user_type userType)
	{
		User result = null;
		if(userType.ordinal() != user_type.INVALID.ordinal() && userType.ordinal() < user_type.COUNT.ordinal())
		{
			switch(userType)
			{
				case REGISTERED:
				{
					result = new RegisteredUser();
				}break;
				case UNREGISTERED:
				{
					result = new UnregisteredUser();
				}break;
			}
		}
		
		return result; 
	}
}
