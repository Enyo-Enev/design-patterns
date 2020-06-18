package main;

public class Chain {

	Gishe chain;
	ObserverPattern observers;
	
	public Chain(ObserverPattern observers)
	{
		this.chain = new AbroadGishe(new CityLocal(new CountryWise(null, observers), observers), observers);
	}
	public void process(Request request)
	{
		if(chain != null)
		{
			chain.process(request);
		}
	}
}
