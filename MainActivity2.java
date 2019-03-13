package com.example.hp.appnotes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.HashSet;

public class notesactivity extends AppCompatActivity {
    int noteid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notesactivity);

        EditText editText =(EditText)findViewById(R.id.editText);

        Intent intent= getIntent();

        noteid= intent.getIntExtra("noteid",-1);

        if(noteid!=-1){

            editText.setText(MainActivity.note.get(noteid));
        }
        else{

            MainActivity.note.add("");
            noteid=MainActivity.note.size()-1;
            MainActivity.arrayAdapter.notifyDataSetChanged();
        }

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

