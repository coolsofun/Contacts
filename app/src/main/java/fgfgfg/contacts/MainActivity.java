package fgfgfg.contacts;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import fgfgfg.contacts.data.Person;
import fgfgfg.contacts.data.PersonDAO;
import fgfgfg.contacts.data.PersonDAOFileImpel;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.listView);

    }

    @Override
    protected void onResume() {
        super.onResume();
    PersonDAO impl=new PersonDAOFileImpel(MainActivity.this);
    final ArrayList<Person> mylist=(ArrayList) impl.getList();
    String[] names=new String[mylist.size()];
        for(int i=0;i<mylist.size();i++){
           names[i]=mylist.get(i).Name;

        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                names);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(MainActivity.this, DataActivity.class);
                it.putExtra("ID", mylist.get(i).ID);
                startActivity(it);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("增加");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent it=new Intent(MainActivity.this,AddActivity.class);
        startActivity(it);
        return super.onOptionsItemSelected(item);
    }
}
