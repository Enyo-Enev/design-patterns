package main;

public class main {

	public static void main(String[] args)
	{
		ObserverPattern observers = new ObserverPattern();
		ReceiverBoy receiver = new ReceiverBoy();
		observers.registerObserver(receiver);
		
		Client client = new Client();
		Request request0 = new Request(client.ClientID, destination_type.CITY_LOCAL);
		Request request1 = new Request(client.ClientID, destination_type.COUNTRYWISE);
		Request request2 = new Request(client.ClientID, destination_type.ABROAD);
		
		Chain chain = new Chain(observers);
		chain.process(request0);
		chain.process(request1);
		chain.process(request2);
	}
}
