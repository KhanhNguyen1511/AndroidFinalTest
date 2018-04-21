package com.example.mrm82.androidfinaltest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editName,editClass;
    Button buttonUpdate, buttonDelete;
    int Pos;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        editName=findViewById(R.id.editName);
        editClass=findViewById(R.id.editClass);
        buttonDelete=findViewById(R.id.btnDelete);
        buttonUpdate=findViewById(R.id.btnUpdate);

        Intent intent=getIntent();
        Bundle bundle = intent.getBundleExtra("package");
        Pos = bundle.getInt("Pos");
        editName.setText(bundle.getString("Name"));
        editClass.setText(bundle.getString("Class"));

        buttonUpdate.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnUpdate:
                String updateName = editName.getText().toString().trim();
                String updateClass = editClass.getText().toString().trim();

                Intent updatedData = getIntent();
                Bundle bundle2 = new Bundle();
                bundle2.putString("UpdateName",updateName);
                bundle2.putString("UpdateClass",updateClass);
                bundle2.putInt("Position",Pos);
                updatedData.putExtra("updatePackage",bundle2);

                setResult(101,updatedData);
                finish();
                break;
            case R.id.btnDelete:
                Intent clearData = getIntent();
                Bundle bundle1 = new Bundle();
                bundle1.putInt("Position",Pos);
                clearData.putExtra("deletePackage",bundle1);
                setResult(102,clearData);
                finish();
                break;
        }
    }
}
