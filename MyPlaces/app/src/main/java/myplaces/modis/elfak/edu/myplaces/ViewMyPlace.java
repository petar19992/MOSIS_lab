package myplaces.modis.elfak.edu.myplaces;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class ViewMyPlace extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_my_place);
        try{
            Intent i=getIntent();
            Bundle itemBundle=i.getExtras();
            String name=itemBundle.getString("name");
            String description=itemBundle.getString("description");
            TextView nameEdit=(TextView) findViewById(R.id.nameText);
            nameEdit.setText(name.toString());
            TextView descriptionEdit=(TextView) findViewById(R.id.descriptionText);
            descriptionEdit.setText((description.toString()));
        }
        catch (Exception e)
        {}
    }
    public void okClick(View view)
    {
        finish();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
