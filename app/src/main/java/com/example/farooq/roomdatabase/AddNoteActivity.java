package com.example.farooq.roomdatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE= "com.example.farooq.roomdatabase.AddNoteActivity.EXTRA_TITLE";
    public static final String EXTRA_DESC= "com.example.farooq.roomdatabase.AddNoteActivity.EXTRA_DESC";
    public static final String EXTRA_PRIORITY= "com.example.farooq.roomdatabase.AddNoteActivity.EXTRA_PRIORITY";

    private EditText aTitle;
    private EditText aDescription;
    private NumberPicker aNumberPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

        aTitle = (EditText) findViewById(R.id.add_title);
        aDescription = (EditText) findViewById(R.id.add_description);
        aNumberPicker = (NumberPicker) findViewById(R.id.add_number_picker_priority);

        aNumberPicker.setMinValue(1);
        aNumberPicker.setMaxValue(10);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_save_button:
                saveNote();
                return  true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    private void saveNote() {
        String title = aTitle.getText().toString();
        String description = aDescription.getText().toString();
        int number = aNumberPicker.getValue();

        if (title.trim().isEmpty() || description.trim().isEmpty()){
            Toast.makeText(this, "Please Insert the Title or Description", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE,title);
        data.putExtra(EXTRA_DESC,description);
        data.putExtra(EXTRA_PRIORITY,number);

        setResult(RESULT_OK,data);
        finish();
    }
}
