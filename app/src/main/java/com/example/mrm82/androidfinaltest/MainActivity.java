package com.example.mrm82.androidfinaltest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtName,edtClass;
    ArrayList<NameConstructor> arrayList;
    ListView listItem;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName=findViewById(R.id.edtName);
        edtClass=findViewById(R.id.edtClass);
        listItem=findViewById(R.id.listItem);
        final PersonAdapter adapter = new PersonAdapter(this,arrayList);
        arrayList = new ArrayList<>();

        btnAdd=findViewById(R.id.btnAdd);
         btnAdd.setOnClickListener(this);

         listItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {

                 Intent i = new Intent(MainActivity.this,SecondActivity.class);
                 NameConstructor nameConstructor=arrayList.get(pos);
                 Bundle personBundle = new Bundle();
                 personBundle.putString("Name",nameConstructor.getName());
                 personBundle.putString("Class",nameConstructor.getPersonClass());
                 personBundle.putInt("Pos",pos);
                 i.putExtra("package",personBundle);
                 startActivityForResult(i,100);
                 Toast.makeText(MainActivity.this, String.valueOf(pos), Toast.LENGTH_SHORT).show();

             }
         });
    }

    private void addItem() {

        PersonAdapter adapter = new PersonAdapter(this,arrayList);
        String name = edtName.getText().toString();
        String personClass = edtClass.getText().toString();
        NameConstructor constructor = new NameConstructor();
        constructor.setName(name);
        constructor.setPersonClass(personClass);
        arrayList.add(constructor);
        listItem.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        PersonAdapter adapter = new PersonAdapter(this, arrayList);
        if (resultCode == 101 && requestCode == 100) {

            Bundle bundle = data.getBundleExtra("updatePackage");
            NameConstructor constructor = new NameConstructor();
            constructor.setName(bundle.getString("UpdateName"));
            constructor.setPersonClass(bundle.getString("UpdateClass"));
            int pos = bundle.getInt("Position");
            arrayList.set(pos,constructor);
            listItem.setAdapter(adapter);

        }
        if (resultCode == 102 && requestCode == 100){
            Bundle bundle1 = data.getBundleExtra("deletePackage");
            arrayList.remove(bundle1.getInt("Position"));
            listItem.setAdapter(adapter);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAdd:
                addItem();

                break;
        }
    }
}
