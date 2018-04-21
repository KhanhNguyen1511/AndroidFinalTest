package com.example.mrm82.androidfinaltest;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class PersonAdapter extends ArrayAdapter<NameConstructor> {
    Activity context;

    List<NameConstructor> objects;

    public PersonAdapter(@NonNull Activity context, @NonNull List objects) {
        super(context, 0, objects);
        this.context=context;
        this.objects=objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //get data item for this position
        NameConstructor nameConstructor = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_row,null);
        }

        // Lookup view for data population
        TextView txtName = convertView.findViewById(R.id.txtName);
        TextView txtClass = convertView.findViewById(R.id.txtClass);

        // Populate the data into the template view using the data object
        txtName.setText(nameConstructor.Name);
        txtClass.setText(nameConstructor.PersonClass);

        // Return the completed view to render on screen
        return convertView;

    }
}
