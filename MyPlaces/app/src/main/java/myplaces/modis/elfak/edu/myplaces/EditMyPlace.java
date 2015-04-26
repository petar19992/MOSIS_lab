package myplaces.modis.elfak.edu.myplaces;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import javax.sql.RowSetReader;


public class EditMyPlace extends ActionBarActivity implements View.OnClickListener {

    MyPlace myPlace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_my_place);
        try{
            Intent i=getIntent();
            Bundle itemBundle=i.getExtras();
            int position=itemBundle.getInt("position");
            myPlace=MyPlacesData.getInstance().getPlace(position);
            TextView nameEdit=(TextView) findViewById(R.id.editText);
            nameEdit.setText(myPlace.getName().toString());
            TextView descriptionEdit=(TextView) findViewById(R.id.editText2);
            descriptionEdit.setText((myPlace.getDescription().toString()));
        }
        catch (Exception e)
        {}
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_my_place, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if(R.id.show_map_item==id)
        {

        }else
        if(R.id.my_place_list_item==id)
        {
            Intent i=new Intent(this, MyPlacesList.class);
            startActivity(i);
        }else
        if(R.id.about_item==id)
        {
            Intent i=new Intent(this, About.class);
            startActivity(i);
        }


        return super.onOptionsItemSelected(item);
    }
    public void okClick(View view)
    {
        if(myPlace==null) {
            TextView nameText = (TextView) findViewById(R.id.editText);
            TextView descriptionText = (TextView) findViewById(R.id.editText2);
            myPlace = new MyPlace(nameText.getText().toString(), descriptionText.getText().toString());
            MyPlacesData.getInstance().addNewPlace(myPlace);
        }
        else
        {
            TextView nameText = (TextView) findViewById(R.id.editText);
            TextView descriptionText = (TextView) findViewById(R.id.editText2);
            myPlace.setName(nameText.getText().toString());
            myPlace.setDescription(descriptionText.getText().toString());
            MyPlacesData.getInstance().updatePlace(myPlace);
        }
        setResult(Activity.RESULT_OK);
        finish();
    }
    public void quitClick(View view)
    {
        setResult(Activity.RESULT_CANCELED);
        finish();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public void onClick(View v) {

    }
}
