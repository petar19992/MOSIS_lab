package myplaces.modis.elfak.edu.myplaces;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.Toast;


public class MyPlacesActivity extends ActionBarActivity implements OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_places);

        /*Button myPlacesButton=(Button)findViewById(R.id.my_places_button);
        myPlacesButton.setOnClickListener((View.OnClickListener) this);
        Button newPlacesButton=(Button)findViewById(R.id.new_places_button);
        myPlacesButton.setOnClickListener((View.OnClickListener) this);
        Button showMapButton=(Button)findViewById(R.id.show_map_button);
        myPlacesButton.setOnClickListener((View.OnClickListener) this);
        Button aboutButton=(Button)findViewById(R.id.about_button);
        myPlacesButton.setOnClickListener((View.OnClickListener) this);
        Button exitButton=(Button)findViewById(R.id.exit_button);
        myPlacesButton.setOnClickListener((View.OnClickListener) this);*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_places, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       /* if (id == R.id.action_settings) {
            return true;
        }*/
        int flag=1;
        if(id==R.id.show_map_item)
            Toast.makeText(this,"Show map",Toast.LENGTH_SHORT).show();
        if(id==R.id.new_place_item) {
            Intent i=new Intent(this, EditMyPlace.class);
            startActivityForResult(i,flag);
            //Toast.makeText(this, "New Place", Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.my_place_list_item)
            Toast.makeText(this,"My Place",Toast.LENGTH_SHORT).show();
        if(id==R.id.about_item)
            Toast.makeText(this,"About",Toast.LENGTH_SHORT).show();

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode== Activity.RESULT_OK)
        {
            Toast.makeText(this,"New place added",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        /*switch (v.getId())
        {
            case R.id.exit_button:
            {
                finish();
                break;
            }
            case R.id.my_places_button:
                break;
            case R.id.new_places_button:
                break;
            case R.id.show_map_button:
                break;
            case R.id.about_button:
            {
                Intent i=new Intent(this,About.class);
                startActivity(i);
                break;
            }

        }*/
    }
   public void aboutClick(View view)
    {
        Intent i=new Intent(this,About.class);
        startActivity(i);
    }/*
    public void exitClick(View view)
    {
        finish();
    }*/
    public void myClick(View view)
    {
        Intent i2=new Intent(this,myplaces.modis.elfak.edu.myplaces.MyPlacesList.class);
        startActivity(i2);
    }

    public void newClick(View view)
    {

    }
    /*
    public void showMapClick(View view)
    {}
*/
}
