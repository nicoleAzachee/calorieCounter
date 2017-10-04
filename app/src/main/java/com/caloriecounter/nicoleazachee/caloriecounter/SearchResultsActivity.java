package com.caloriecounter.nicoleazachee.caloriecounter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by c_naazachee on 8/23/2017.
 */
public class SearchResultsActivity extends AppCompatActivity {
    ListView list_search_results;
    String tag = this.getClass().getSimpleName();

    ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_calorie_results);

        casting();
        initialize();
        listSelectionHandler();
    }

    public void casting(){
        list_search_results = (ListView)findViewById(R.id.list_search_results);
    }

    public void initialize(){
        list = new ArrayList<String>();
        populateList();
        ArrayAdapter<String> listAdapter =
                new ArrayAdapter<String>
                        (this,android.R.layout.simple_list_item_1, list);
        list_search_results.setAdapter(listAdapter);

    }

    void populateList()
    {
        list.add("Blah");
        list.add("Boop");
        list.add("Bimbo");
        list.add("Bimbi");
    }

    public void listSelectionHandler(){
        // register onClickListener to handle click events on each item
        list_search_results.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            // argument position gives the index of item which is clicked
            public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3)
            {
                String selectedItem = list.get(position);
                Toast.makeText(getApplicationContext(), "Item Selected : "+selectedItem, Toast.LENGTH_LONG).show();
            }
        });
    }
}
