package myplaces.modis.elfak.edu.myplaces;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Petar on 4/5/2015.
 */
public class MyPlacesDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_CREATE="create table "+MyPlacesDBAdapter.DATABASE_TABLE+" ("
            + MyPlacesDBAdapter.PLACE_ID+" integer primary key autoincrement, "
            + MyPlacesDBAdapter.PLACE_NAME+" text unique not null, "
            + MyPlacesDBAdapter.PLACE_DESCRIPTION+" text, "
            + MyPlacesDBAdapter.PLACE_LONG+" text, "
            + MyPlacesDBAdapter.PLACE_LAT+" text, "
            + MyPlacesDBAdapter.PLACE_FILENAME+" text);";


    public MyPlacesDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.v("TaskDBAdapter", "Updating from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXIST "+MyPlacesDBAdapter.DATABASE_TABLE);
        onCreate(db);
    }
}
