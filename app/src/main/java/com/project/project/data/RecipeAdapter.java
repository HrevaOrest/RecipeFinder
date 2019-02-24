package com.project.project.data;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.project.project.R;
import com.project.project.data.model.Recipe;
import com.project.project.ui.SingleItemActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder>{

    private ArrayList <Recipe> recipeList;

    private Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_item, parent, false);

        context = parent.getContext();
        return new ViewHolder(view);
    }

    public RecipeAdapter(ArrayList<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Integer recipe_rating = recipeList.get(position).getRating();
        holder.recipe_rating_tv.setText(recipe_rating+"/5");


        holder.recipe_photo_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Recipe recipe = recipeList.get(position);

                Intent intent = new Intent(context, SingleItemActivity.class);

//                Bundle bundle = new Bundle();
//                bundle.putSerializable("recipe", recipe);

                intent.putExtra("recipe", recipe);

                context.startActivity(intent);
            }
        });


        RequestOptions placaholderOptions  = new RequestOptions();
        placaholderOptions.placeholder(R.color.colorPrimaryDark);


        //TODO if recipe without image change image to ic_launcher
        if(recipeList.get(position).getImageUrlsBySize()==null) {

            Glide.with(context)
                    .applyDefaultRequestOptions(placaholderOptions)
                    .load(R.mipmap.ic_launcher)
                    .into(holder.recipe_photo_iv);

            Log.i("hreva", "uri = null");

        }else{

            Map.Entry<Integer,String> entry = recipeList.get(position).getImageUrlsBySize().entrySet().iterator().next();
            String uri = entry.getValue();

            Glide.with(context)
                    .applyDefaultRequestOptions(placaholderOptions)
                    .load(uri)
                    .into(holder.recipe_photo_iv);
        }


        String recipe_title = recipeList.get(position).getRecipeName();
        holder.recipe_title_tv.setText(recipe_title);


        //типу інградієнти
        String recip_ingrad = String.valueOf(recipeList.get(position).getIngredients());
        holder.text_ingredient.setText(recip_ingrad);

        //getIngredients
        //text_ingredient
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private View view;

        private TextView text_ingredient;

        private TextView recipe_rating_tv;
        private ImageView recipe_photo_iv;
        private TextView recipe_title_tv;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            //типу інградієнти
            text_ingredient = view.findViewById(R.id.text_ingredient);

            recipe_rating_tv = view.findViewById(R.id.recipe_rating_tv);
            recipe_photo_iv = view.findViewById(R.id.recipe_photo_iv);
            recipe_title_tv = view.findViewById(R.id.recipe_title_tv);
        }
    }
}
