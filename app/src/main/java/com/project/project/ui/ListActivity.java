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

//public class ListActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_list);
//    }
//}


public class ListActivity extends AppCompatActivity implements View.OnClickListener {

    String[] countries = {"onion", "apple", "potato", "buckwheat", "fig", "banana", "cheese", "turkey", "chocken", "mushrooms" , "orange", "macaroni", "pork", "cabbage", "pudding", "eggs", "dough"};
    TextView selection;
    ListView countriesList;
    Button btnChecked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        btnChecked = (Button) findViewById(R.id.btnChecked);
      btnChecked.setOnClickListener(this);

        // получаем элемент TextView
        selection = (TextView) findViewById(R.id.selection);
        // получаем элемент ListView
        countriesList = (ListView) findViewById(R.id.countriesList);

        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_multiple_choice, countries);
        // устанавливаем для списка адаптер
        countriesList.setAdapter(adapter);
        // добвляем для списка слушатель
        countriesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                SparseBooleanArray sp = countriesList.getCheckedItemPositions();

                String selectedItems = "";
                for (int i = 0; i < countries.length; i++) {
                    if (sp.get(i))
                        selectedItems += countries[i] + " ";
                }
                // установка текста элемента TextView
                selection.setText(selectedItems);
            }
        });
    }

    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("name", selection.getText().toString());
        startActivity(intent);
    }
}
//        Intent intent = new Intent();
//        String name = intent.getStringExtra("countries");
//        selection.setText(countries[countriesList.getCheckedItemPosition()]);
//
//        Intent intent1 = new Intent(this, MainActivity.class);
//        intent1.putExtra("name", selection.getText().toString());
//        startActivity(intent1);
//        }

    // final String LOG_TAG = "myLogs";

//    ListView lvMain;
//    String[] names;
//  //  TextView textView;
//    EditText editText;
//    Button btnChecked;
//
//    /**
//     * Called when the activity is first created.
//     */
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_list);
//
//        // editTextCityName = (EditText) findViewById(R.id.cityname);
//        editText = (EditText) findViewById(R.id.editText);
//
//
//        lvMain = (ListView) findViewById(R.id.lvMain);
//        // устанавливаем режим выбора пунктов списка
//        lvMain.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
//        // Создаем адаптер, используя массив из файла ресурсов
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
//                this, R.array.names,
//                android.R.layout.simple_list_item_single_choice);
//        lvMain.setAdapter(adapter);
//
//       // Button
//                btnChecked = (Button) findViewById(R.id.btnChecked);
//        btnChecked.setOnClickListener(this);
//
//        // получаем массив из файла ресурсов
//        names = getResources().getStringArray(R.array.names);
//    }
//
//    public void onClick(View v) {
//        // пишем в лог выделенные элементы
//
//        Intent intent = new Intent();
//        String name = intent.getStringExtra("names");
//        editText.setText(names[lvMain.getCheckedItemPosition()]);
//
//        Intent intent1 = new Intent(this, MainActivity.class);
//        intent1.putExtra("name", editText.getText().toString());
//        startActivity(intent1);
//        }




