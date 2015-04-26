package myplaces.modis.elfak.edu.myplaces;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Petar on 3/30/2015.
 */
public class MyPlacesData {
    ArrayList<MyPlace> myPlaces;
    MyPlacesDBAdapter dbAdapter;
    private MyPlacesData() {
        dbAdapter=new MyPlacesDBAdapter(MyPlacesApplication.getContext());
        try {
            dbAdapter.open();
        }
        catch (Exception e) {

        }
        myPlaces=dbAdapter.getAllEntries();
        dbAdapter.close();
        myPlaces=new ArrayList<MyPlace>();/*
        myPlaces.add(new MyPlace("faks","elfak"));
        myPlaces.add(new MyPlace("Kuca","zl"));
        myPlaces.add(new MyPlace("Stan","Vojvode"));
        myPlaces.add(new MyPlace("klub","roze"));
        myPlaces.add(new MyPlace("Damjan","pravni"));
        myPlaces.add(new MyPlace("sdasd","elfadasdak"));*/
    }
    public static MyPlacesData getInstance()
    {
        return singletonHolder.instance;
    }
    public static class singletonHolder
    {
        public static final MyPlacesData instance=new MyPlacesData();
    }
    public void addNewPlace(MyPlace mPlace)
    {
        myPlaces.add(mPlace);
        try {
            dbAdapter.open();
        }
        catch (Exception e) {
        }
        long ID=dbAdapter.insertEntry(mPlace);
        dbAdapter.close();
        mPlace.setID(ID);
    }
    public MyPlace getPlace(int place)
    {
        return myPlaces.get(place);
    }
    public void deletePlaces(int index)
    {
        MyPlace place=myPlaces.remove(index);
        try {
            dbAdapter.open();
        }
        catch (Exception e) {
        }
        dbAdapter.removeEntry(place.getID());
        dbAdapter.close();
    }
    public void updatePlace(MyPlace place)
    {
        try {
            dbAdapter.open();
        }
        catch (Exception e) {
        }
        dbAdapter.updateEntry(place.getID(),place);
        dbAdapter.close();
    }
}
