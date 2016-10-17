package fgfgfg.contacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import fgfgfg.contacts.data.Person;
import fgfgfg.contacts.data.PersonDAO;
import fgfgfg.contacts.data.PersonDAOFileImpel;

public class AddActivity extends AppCompatActivity {
    EditText ed1, ed2, ed3,ed4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }
    public void oc2(View v){
        ed1 = (EditText) findViewById(R.id.editText);
        ed2 = (EditText) findViewById(R.id.editText2);
        ed3 = (EditText) findViewById(R.id.editText3);
        ed4 = (EditText) findViewById(R.id.editText4);

        PersonDAO impl = new PersonDAOFileImpel(AddActivity.this);
        impl.add(new Person(ed1.getText().toString(), ed2.getText().toString(), ed3.getText().toString(),ed4.getText().toString()));
        finish();
    }
}
