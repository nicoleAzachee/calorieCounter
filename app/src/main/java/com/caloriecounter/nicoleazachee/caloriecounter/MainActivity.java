package com.caloriecounter.nicoleazachee.caloriecounter;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    TextView text_calorie_count_current_total;
    EditText entry_add_calorie, entry_search_calorie;
    ImageView button_add_calorie;
    public int total_calorie_count;
    View view_to_add_to_test_git;
    String tag = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        casting();
        initialize();
        keyPressHandler();
    }

    public void casting(){
        text_calorie_count_current_total = (TextView)findViewById(R.id.text_calorie_count_current_total);
        entry_add_calorie = (EditText)findViewById(R.id.entry_add_calorie);
        entry_search_calorie = (EditText)findViewById(R.id.entry_search_calorie);
        button_add_calorie = (ImageView)findViewById(R.id.button_add_calorie);
    }
    public void initialize(){
        entry_search_calorie.setFocusableInTouchMode(true);
        entry_search_calorie.requestFocus();
    }

    public void keyPressHandler(){
        entry_search_calorie.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    Intent intent = new Intent(MainActivity.this, SearchResultsActivity.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, entry_search_calorie.getText(), Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });
    }
    public void addCalorie(View view){
        try{
            if(!entry_add_calorie.equals("")) {
                Log.i(tag, "total_calorie_count:" + total_calorie_count);
                total_calorie_count = total_calorie_count + Integer.valueOf(entry_add_calorie.getText().toString());
                text_calorie_count_current_total.setText(String.valueOf(total_calorie_count));
                entry_add_calorie.setText("");
            }else{
                Toast.makeText(getApplicationContext(), "Input", Toast.LENGTH_LONG).show();
            }
        }catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }

    }
    public void subtractCalorie(View view){
        try{
            if(!entry_add_calorie.equals("")) {
                Log.i(tag, "total_calorie_count:" + total_calorie_count);
                total_calorie_count = total_calorie_count - Integer.valueOf(entry_add_calorie.getText().toString());
                text_calorie_count_current_total.setText(String.valueOf(total_calorie_count));
                entry_add_calorie.setText("");
            }
        }catch (Exception e){
            System.out.println("Error " + e.getMessage());
        }

    }
}
