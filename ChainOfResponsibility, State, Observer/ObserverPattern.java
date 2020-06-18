package main;
import java.util.ArrayList;
import java.util.Iterator;

interface Observer{
	public void update(Gishe gishe);
}

public class ObserverPattern {
	ArrayList<Observer> observers = new ArrayList<Observer>();
	
	public void registerObserver(Observer o)
	{
		observers.add(o);
	}
	public void unregisterObserver(Observer o)
	{
		observers.remove(observers.indexOf(o));
	}
	
	public void notifyObservers(Gishe gishe)
	{
		for(Iterator<Observer> it = observers.iterator(); it.hasNext();)
		{
			Observer o = it.next();
			o.update(gishe);
		}
	}
}
