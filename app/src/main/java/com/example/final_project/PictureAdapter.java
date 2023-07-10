package com.example.final_project;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.final_project.Models.PictureItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.ViewHolder> {

    private List<PictureItem> pictureList;
    private List<PictureItem> favoriteList;
    private Context context;


    public PictureAdapter(Context context, List<PictureItem> pictureList) {
        this.context = context;
        this.pictureList = pictureList;
        this.favoriteList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_picture, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PictureItem pictureItem = pictureList.get(position);
        holder.textView.setText(pictureItem.getText());

        // Set the heart icon
        Drawable heartDrawable;
        if (favoriteList.contains(pictureItem)) {
            heartDrawable = context.getResources().getDrawable(R.drawable.ic_baseline_favorite_24);
        } else {
            heartDrawable = context.getResources().getDrawable(R.drawable.ic_baseline_favorite_border_24);
        }
        heartDrawable.setBounds(0, 0, heartDrawable.getIntrinsicWidth(), heartDrawable.getIntrinsicHeight());
        ImageSpan imageSpan = new ImageSpan(heartDrawable, ImageSpan.ALIGN_BASELINE);

        // Build the SpannableStringBuilder with the text and heart icon
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(pictureItem.getText());
        spannableStringBuilder.setSpan(imageSpan, spannableStringBuilder.length() - 1, spannableStringBuilder.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);

        holder.textView.setText(spannableStringBuilder);

        // Toggle heart icon and add/remove from favorite list on click
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            boolean isFavorite = favoriteList.contains(pictureItem);

            @Override
            public void onClick(View view) {
                isFavorite = !isFavorite;

                if (isFavorite) {
                    favoriteList.add(pictureItem); // Add to favorite list
                } else {
                    favoriteList.remove(pictureItem); // Remove from favorite list
                }

                // Update the heart icon in the text
                Drawable newHeartDrawable;
                if (isFavorite) {
                    newHeartDrawable = context.getResources().getDrawable(R.drawable.ic_baseline_favorite_24);
                } else {
                    newHeartDrawable = context.getResources().getDrawable(R.drawable.ic_baseline_favorite_border_24);
                }
                newHeartDrawable.setBounds(0, 0, newHeartDrawable.getIntrinsicWidth(), newHeartDrawable.getIntrinsicHeight());
                ImageSpan newImageSpan = new ImageSpan(newHeartDrawable, ImageSpan.ALIGN_BASELINE);
                spannableStringBuilder.setSpan(newImageSpan, spannableStringBuilder.length() - 1, spannableStringBuilder.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);

                holder.textView.setText(spannableStringBuilder);
            }
        });

        holder.reserveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Display the small screen for reservation options
                // You can implement your own logic here to show the screen or launch a dialog fragment
                // For example, you can create an Intent to start a new activity with the reservation options
                Intent intent = new Intent(context, ReservationActivity.class);
                context.startActivity(intent);
            }
        });

        Picasso.get().load(pictureItem.getImageUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return pictureList.size();
    }

    public List<PictureItem> getFavoriteList() {
        return favoriteList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        Button reserveButton;
        SpannableStringBuilder spannableStringBuilder;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.pictureImageView);
            textView = itemView.findViewById(R.id.pictureTextView);
            reserveButton = itemView.findViewById(R.id.reserveButton);
        }
    }
}