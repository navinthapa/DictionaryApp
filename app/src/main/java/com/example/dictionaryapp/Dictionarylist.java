package com.example.dictionaryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Dictionarylist extends AppCompatActivity {
    private ListView listwords;
    public static final String countries[]={
            "namasate", "Hello",
            "k cha?", "How Are you ?",
            "khana khayeu?", "Did you Had your Lunch?",
            "k gardai ", "Wassup",


    };
    private Map<String,String> dictionary;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         ListView listwords =findViewById(R.id.listwords);

        dictionary= new HashMap<>();
        for (int i=0; i<countries.length;i+=2){
            dictionary.put(countries[i],countries[i=1]);
        }
        ArrayAdapter wordsadapter =new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                new ArrayList<String>(dictionary.keySet())
        );
        listwords.setAdapter(wordsadapter);
listwords.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String key=parent.getItemAtPosition(position).toString();
String meaning=dictionary.get(key);
Intent intent=new Intent(Dictionarylist.this,DictionaryMeaning.class);
intent.putExtra("meaning",meaning);
startActivity(intent);
    }
});
    }
}
