package myplaces.modis.elfak.edu.myplaces;

import android.app.Application;
import android.content.Context;

/**
 * Created by Petar on 4/5/2015.
 */
public class MyPlacesApplication extends Application {

    private static MyPlacesApplication instance;
    public MyPlacesApplication(){
        instance=this;
    }
    public static Context getContext(){
        return instance;
    }
}
