package com.example.hp.appnotes;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity {

   static ArrayList<String>note= new ArrayList<>();
    static  ArrayAdapter<String>arrayAdapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater= getMenuInflater();

        menuInflater.inflate(R.menu.menu1,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         super.onOptionsItemSelected(item);


        if(item.getItemId()==R.id.add){

            Intent intent=new Intent(getApplicationContext(),notesactivity.class);
            startActivity(intent);

        }

      return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        note= new ArrayList<String>();



        ListView listView=  (ListView)findViewById(R.id.notes1);
        SharedPreferences sharedPreferences=getApplicationContext().getSharedPreferences("com.example.hp.appnotes",Context.MODE_PRIVATE);
        HashSet<String>Set=(HashSet<String>)sharedPreferences.getStringSet("notes",null);
        if(Set==null) {

            note.add("example note");
        }
        else{
            note=new ArrayList(Set);
        }


        arrayAdapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,note);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getApplicationContext(),notesactivity.class);

                intent.putExtra("noteid",i);


                startActivity(intent);


            }
        });

       
