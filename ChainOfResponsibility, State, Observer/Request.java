package main;

public class Request {
	public Request(int ClientID, destination_type Type)
	{
		this.ClientID = ClientID;
		this.Type = Type;
	}
	int ClientID;
	destination_type Type;
}
