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

public class FirthActivity extends AppCompatActivity implements View.OnClickListener {

    String[] countries2 = {"Ukrainian", "England", "French", "Asian","Italy", "Spain", "Germany"};
//    Ukraine, England, France, Italy, Spain, Germany
    TextView selection2;
    ListView countriesList2;
    Button btnChecked2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firth);

        btnChecked2 = (Button) findViewById(R.id.btnChecked2);
        btnChecked2.setOnClickListener(this);

        // получаем элемент TextView
        selection2 = (TextView) findViewById(R.id.selection2);
        // получаем элемент ListView
        countriesList2 = (ListView) findViewById(R.id.countriesList2);

        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_multiple_choice, countries2);
        // устанавливаем для списка адаптер
        countriesList2.setAdapter(adapter);
        // добвляем для списка слушатель
        countriesList2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                SparseBooleanArray sp = countriesList2.getCheckedItemPositions();

                String selectedItems = "";
                for (int i = 0; i < countries2.length; i++) {
                    if (sp.get(i))
                        selectedItems += countries2[i] + " ";
                }
                // установка текста элемента TextView
                selection2.setText(selectedItems);
            }
        });
    }

    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("name", selection2.getText().toString());
        startActivity(intent);
    }
}