package main;

public class Warehouse {
	private int packagesReceived = 0;
	
	public void receiveRequest(Request request)
	{
		packagesReceived++;
	}
}
