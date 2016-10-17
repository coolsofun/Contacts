package fgfgfg.contacts;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import fgfgfg.contacts.data.Person;
import fgfgfg.contacts.data.PersonDAO;
import fgfgfg.contacts.data.PersonDAOFileImpel;

import static android.os.Build.ID;

public class DataActivity extends AppCompatActivity {
    EditText edName, edTel, edAddr, email;
    int ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        Intent it = getIntent();
        ID = it.getIntExtra("ID", 0);
        PersonDAO impl = new PersonDAOFileImpel(DataActivity.this);
        Person p = impl.getPerson(ID);
        edName = (EditText) findViewById(R.id.editText5);
        edTel = (EditText) findViewById(R.id.editText6);
        edAddr = (EditText) findViewById(R.id.editText7);
        email = (EditText) findViewById(R.id.editText8);

        edName.setText(p.Name);
        edTel.setText(p.Tel);
        edAddr.setText(p.Addr);
        email.setText(p.Mail);
    }

    public void oc(View v) {
        Person p = new Person(ID, edName.getText().toString(), edTel.getText().toString(), edAddr.getText().toString(), email.getText().toString());
        PersonDAO impl = new PersonDAOFileImpel(DataActivity.this);
        impl.update(p);
        finish();
    }

    public void oc3(View v) {
        Person p = new Person(ID, edName.getText().toString(), edTel.getText().toString(), edAddr.getText().toString(), email.getText().toString());
        PersonDAO impl = new PersonDAOFileImpel(DataActivity.this);
        impl.delete(p);
        finish();

    }
}
