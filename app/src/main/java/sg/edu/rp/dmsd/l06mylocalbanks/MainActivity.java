package sg.edu.rp.dmsd.l06mylocalbanks;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1;
    Button b2;
    Button b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);

        registerForContextMenu(b1);
        registerForContextMenu(b2);
        registerForContextMenu(b3);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v.getId()== R.id.button) {
            menu.add(0,0,0,"Website");
            menu.add(0,1,1,"Contact the bank");
        }
        else if (v.getId()== R.id.button2) {
            menu.add(0,2,0,"Website");
            menu.add(0,3,1,"Contact the bank");
        }

        else {
            menu.add(0,4,0,"Website");
            menu.add(0,5,1,"Contact the bank");
        }


    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId()==0) { //check whether the selected menu item ID is 0
            //code for action
            Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
            startActivity(intent);

            return true; //menu item successfully handled
        }
        else if(item.getItemId()==1) { //check if the selected menu item ID is 1
            //code for action
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 180011 + 11111));
            startActivity(intentCall);
            return true;  //menu item successfully handled
        }
        else if(item.getItemId()==2) { //check whether the selected menu item ID is 0
            //code for action
            Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
            startActivity(intent);

            return true; //menu item successfully handled
        }
        else if(item.getItemId()==3) { //check if the selected menu item ID is 1
            //code for action
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 180036 + 33333));
            startActivity(intentCall);
            return true;  //menu item successfully handled
        }
        else if(item.getItemId()==4) { //check whether the selected menu item ID is 0
            //code for action
            Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
            startActivity(intent);

            return true; //menu item successfully handled
        }
        else if(item.getItemId()==5) { //check if the selected menu item ID is 1
            //code for action
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 180022 + 22121));
            startActivity(intentCall);
            return true;  //menu item successfully handled
        }

        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            b1.setText("DBS");
            b2.setText("OCBC");
            b3.setText("UOB");
            return true;
        }else if (id == R.id.ChineseSelection) {
            b1.setText("星展银行");
            b2.setText("华侨银行");
            b3.setText("大华银行");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
