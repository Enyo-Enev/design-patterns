package main;

enum destination_type
{
	ABROAD,
	CITY_LOCAL,
	COUNTRYWISE,
};

abstract class Gishe {
	Gishe nextGishe;
	protected destination_type Type;
	State state;
	Request request;
	ObserverPattern observers;
	
	public Gishe(Gishe gishe, ObserverPattern observers)
	{
		this.nextGishe = gishe;
		this.observers = observers;
		this.state = new StayState();
	}
	
	public void setState(State state)
	{
		this.state = state;
		this.observers.notifyObservers(this);
	}
	
	public State getState()
	{
		return this.state;
	}
	
	public void process(Request request)
	{
		if(state.getClass() == StayState.class)
		{
			if(request.Type == this.Type)
			{
				this.request = request;
				setState(new PreparationState());
			}
			else
			{
				if(nextGishe != null)
				{
					nextGishe.process(request);
				}
			}
		}
		else
		{
			if(nextGishe != null)
			{
				nextGishe.process(request);
			}
		}
	}
}

class AbroadGishe extends Gishe
{
	public AbroadGishe(Gishe gishe, ObserverPattern observers)
	{
		super(gishe, observers);
		this.Type = destination_type.ABROAD;
	}
	
	public void process(Request request)
	{
		super.process(request);
	}
}

class CityLocal extends Gishe
{
	public CityLocal(Gishe gishe, ObserverPattern observers)
	{
		super(gishe, observers);
		this.Type = destination_type.CITY_LOCAL;
	}
	
	public void process(Request request)
	{
		super.process(request);
	}
}
class CountryWise extends Gishe
{
	public CountryWise(Gishe gishe, ObserverPattern observers)
	{
		super(gishe, observers);
		this.Type = destination_type.COUNTRYWISE;
	}
	
	public void process(Request request)
	{
		super.process(request);
	}
}
