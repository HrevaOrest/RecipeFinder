package com.project.project.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.project.project.R;

public class SoupActivity extends AppCompatActivity implements View.OnClickListener {

    String[] countries3 = {"soup", "dessert", "lunch", "Cocktails"};

    TextView selection3;
    ListView countriesList3;
    Button btnChecked3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soup);

        btnChecked3 = (Button) findViewById(R.id.btnChecked3);
        btnChecked3.setOnClickListener(this);

        // получаем элемент TextView
        selection3 = (TextView) findViewById(R.id.selection3);
        // получаем элемент ListView
        countriesList3 = (ListView) findViewById(R.id.countriesList3);

        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_multiple_choice, countries3);
        // устанавливаем для списка адаптер
        countriesList3.setAdapter(adapter);
        // добвляем для списка слушатель
        countriesList3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                SparseBooleanArray sp = countriesList3.getCheckedItemPositions();

                String selectedItems = "";
                for (int i = 0; i < countries3.length; i++) {
                    if (sp.get(i))
                        selectedItems += countries3[i] + " ";
                }
                // установка текста элемента TextView
                selection3.setText(selectedItems);
            }
        });
    }

    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("name", selection3.getText().toString());
        startActivity(intent);
    }
}