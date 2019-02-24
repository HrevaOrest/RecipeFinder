package com.project.project.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.project.project.R;
import com.project.project.data.model.Recipe;

/**
 * Created by Bender on 22.05.2018.
 */

public class SingleItemActivity extends AppCompatActivity {

    private Recipe recipe;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_singleitem);

        recipe =  getIntent().getParcelableExtra("recipe");


        TextView textView = findViewById(R.id.textView4);
        textView.setText(recipe.getRecipeName());
    }
}
