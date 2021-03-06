package com.nhancv.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.nhancv.nexpandable.NExpandableListView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private final String[] array = {"Header 1", "Header 2", "Header 3", "Header 4", "Header 5", "Header 6", "Header 7"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CustomAdapter<String> arrayAdapter = new CustomAdapter<>(this, R.layout.view_row_list);
        arrayAdapter.setListsItems(Arrays.asList(array));
        final NExpandableListView expandableLayoutListView = (NExpandableListView) findViewById(R.id.listview);
        expandableLayoutListView.setAutoCollapse(true);
        expandableLayoutListView.setAdapter(arrayAdapter);

        EditText etFilter = (EditText) findViewById(R.id.etFilter);
        etFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                arrayAdapter.setSearchText(editable.toString());
            }
        });
    }
}
