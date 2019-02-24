package com.project.project.ui.choose_products;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.project.project.R;
import com.project.project.ui.MainActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChooseProductsActivity extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<GroupItem> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    ChooseProductsPresenter chooseProductsPresenter;

    TextView tvInfo;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooseproducts);

        tvInfo = (TextView) findViewById(R.id.product_selection);
        (findViewById(R.id.basket_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseProductsActivity.this, MainActivity.class);
                intent.putExtra("name", tvInfo.getText().toString());
                startActivity(intent);
                finish();
            }
        });

        chooseProductsPresenter = new ChooseProductsPresenter();


        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.product_expandable_list);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                tvInfo.setText(tvInfo.getText() + " "+listDataChild.get(
                                listDataHeader.get(groupPosition).name).get(
                                childPosition));
                return false;
            }
        });

    }

    private void prepareListData() {
        listDataHeader = new ArrayList<GroupItem>();
        listDataChild = new HashMap<String, List<String>>();
        listDataHeader = chooseProductsPresenter.getGroups();


        //у  listDataChild потрібно додавати нові list продуктів

        listDataChild.put(listDataHeader.get(0).name, chooseProductsPresenter.getList1());
        listDataChild.put(listDataHeader.get(1).name, chooseProductsPresenter.getList2());
    }
}
