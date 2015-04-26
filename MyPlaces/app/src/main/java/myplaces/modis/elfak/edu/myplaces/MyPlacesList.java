package myplaces.modis.elfak.edu.myplaces;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.internal.widget.AdapterViewCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import static android.widget.AdapterView.*;

/**
 * Created by Petar on 3/22/2015.
 */
public class MyPlacesList extends ActionBarActivity {

    //String[] places={"Elfak", "Zlatokop","Nis", "Vojvode Misica","Vranje"};
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_places_list);
        ListView myPlacesList=(ListView) findViewById(R.id.my_places_list);
        myPlacesList.setAdapter(new ArrayAdapter<MyPlace>(this, android.R.layout.simple_list_item_activated_1, MyPlacesData.getInstance().myPlaces));
        myPlacesList.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MyPlace place = (MyPlace) parent.getAdapter().getItem((position));
                Bundle itemBundle=new Bundle();
                itemBundle.putInt("position", position);
                Intent i=new Intent(MyPlacesList.this, EditMyPlace.class);
                i.putExtras(itemBundle);
                startActivityForResult(i,3);
            }
        });
        myPlacesList.setOnCreateContextMenuListener(new OnCreateContextMenuListener()
        {

            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo) menuInfo;
                MyPlace place=MyPlacesData.getInstance().getPlace(info.position);
                menu.setHeaderTitle(place.getName().toString());
                menu.add(0, 1, 1, "View place");
                menu.add(0,2,2,"Edit place");
                menu.add(0,3,3,"Delete place");
            }
        });
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        Bundle itemBundle=new Bundle();
        itemBundle.putInt("position", info.position);
        Intent i=null;
        if(item.getItemId()==1)
        {
            i=new Intent(MyPlacesList.this,ViewMyPlace.class);
            i.putExtra("name",MyPlacesData.getInstance().getPlace(info.position).getName());
            i.putExtra("description",MyPlacesData.getInstance().getPlace(info.position).getDescription());
            startActivity(i);
        }
        else
        if(item.getItemId()==2)
        {
            i=new Intent(MyPlacesList.this,EditMyPlace.class);
            i.putExtras(itemBundle);
            startActivity(i);
        }
        else
        if(item.getItemId()==3)
        {
            MyPlacesData.getInstance().deletePlaces(info.position);
            ListView myPlacesList=(ListView) findViewById(R.id.my_places_list);
            myPlacesList.setAdapter(new ArrayAdapter<MyPlace>(this, android.R.layout.simple_list_item_activated_1, MyPlacesData.getInstance().myPlaces));
        }
        return super.onContextItemSelected(item);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_places, menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode== Activity.RESULT_OK)
        {
            ListView myPlacesList=(ListView) findViewById(R.id.my_places_list);
            myPlacesList.setAdapter(new ArrayAdapter<MyPlace>(this, android.R.layout.simple_list_item_activated_1, MyPlacesData.getInstance().myPlaces));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       /* if (id == R.id.action_settings) {
            return true;
        }*/
        int flag=1;
        if(id==R.id.show_map_item)
            Toast.makeText(this, "Show map", Toast.LENGTH_SHORT).show();
        if(id==R.id.new_place_item) {
            Intent i=new Intent(this, EditMyPlace.class);
            startActivityForResult(i,flag);
            //Toast.makeText(this, "New Place", Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.my_place_list_item)
        {
            Intent i=new Intent(this,EditMyPlace.class);
            startActivityForResult(i,2);
        }
        return super.onOptionsItemSelected(item);

    }
}
