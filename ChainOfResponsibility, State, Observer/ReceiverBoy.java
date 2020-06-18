package main;

class ReceiverBoy implements Observer
{
	Warehouse wareHouse = new Warehouse();
	
	public void update(Gishe gishe)
	{
		if(gishe != null)
		{
			State state = gishe.getState();
			if(state != null)
			{
				if(state.getClass() == PreparationState.class)
				{
					takeRequest(gishe);
				}
			}
		}
	}
	
	public void takeRequest(Gishe gishe)
	{
		if(gishe.request != null)
		{
			sendToWareHouse(gishe.request);
		}
		gishe.setState(new StayState());
	}
	
	public void sendToWareHouse(Request request)
	{
		wareHouse.receiveRequest(request);
	}
}
