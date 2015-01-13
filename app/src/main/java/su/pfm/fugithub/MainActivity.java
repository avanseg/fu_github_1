package su.pfm.fugithub;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.*;


public class MainActivity extends ActionBarActivity {

    TextView textView1;
    CheckBox checkBox1;

    final int MENU_COLOR_RED = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        textView1 = (TextView) findViewById(R.id.textView1);
        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);

        registerForContextMenu(textView1);
        //registerForContextMenu(checkBox1);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // обновление меню
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        // пункты меню с ID группы = 1 видны, если в CheckBox стоит галка
        menu.setGroupVisible(R.id.group1, checkBox1.isChecked());
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        StringBuilder sb = new StringBuilder();

        // Выведем в TextView информацию о нажатом пункте меню
        sb.append("Item Menu");
        sb.append("\r\n groupId: " + "Vitek like a boss supa dupa");
        sb.append("\r\n itemId: " + String.valueOf(item.getItemId()));
        sb.append("\r\n order: " + String.valueOf(item.getOrder()));
        sb.append("\r\n title: " + item.getTitle());
        textView1.setText(sb.toString());
        return super.onOptionsItemSelected(item);
    }

    public void onCreateContextMenu(ContextMenu menu, View v,
    ContextMenu.ContextMenuInfo menuInfo) {
       // menu.add(0,1,0,"red");
       // menu.add(0,2,0,"blue");
       // menu.add(0,3,0,"green");
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    public boolean onContextItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menu_red: textView1.setTextColor(Color.RED);
                textView1.setText("Text color = red");
                break;
            case R.id.menu_blue: textView1.setTextColor(Color.BLUE);
                textView1.setText("Text color = blue");
                break;
            case R.id.menu_green: textView1.setTextColor(Color.GREEN);
                textView1.setText("Text color = green");
                break;
        }
        textView1.setText(String.valueOf(item.getItemId()));
        return super.onContextItemSelected(item);
    }
}
