package com.example.final_project.UI.room_service;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.final_project.R;

import java.util.ArrayList;

public class RoomServicesGridFragment extends Fragment {

    private RecyclerView roomServicesRecyclerView;
    private RoomServicesGridAdapter roomServicesGridAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_room_services_grid, container, false);
        roomServicesRecyclerView = rootView.findViewById(R.id.roomServicesRecyclerView);

        // Create an ArrayList of RoomServiceItem objects for the grid
        ArrayList<RoomServiceItem> roomServiceItems = new ArrayList<>();
        roomServiceItems.add(new RoomServiceItem(R.drawable.img1, "Food"));
        roomServiceItems.add(new RoomServiceItem(R.drawable.img, "Cleaning"));
        roomServiceItems.add(new RoomServiceItem(R.drawable.img_1, "Laundry"));
        roomServiceItems.add(new RoomServiceItem(R.drawable.img_2, "Taxi"));
        // Add other RoomServiceItem objects for the grid

        // Set up the RecyclerView with the GridLayoutManager and adapter
        int numberOfColumns = 2; // Number of items in each row
        roomServicesRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), numberOfColumns));
        roomServicesRecyclerView.addItemDecoration(new GridSpacingItemDecoration(numberOfColumns, 5, true));
        roomServicesGridAdapter = new RoomServicesGridAdapter(getContext(), roomServiceItems);
        roomServicesRecyclerView.setAdapter(roomServicesGridAdapter);

        return rootView;
    }

    public static class RoomServiceItem {
        private int imageResId;
        private String title;

        public RoomServiceItem(int imageResId, String title) {
            this.imageResId = imageResId;
            this.title = title;
        }

        public int getImageResId() {
            return imageResId;
        }

        public String getTitle() {
            return title;
        }
    }

    public class RoomServicesGridAdapter extends RecyclerView.Adapter<RoomServicesGridAdapter.ViewHolder> {
        private Context context;
        private ArrayList<RoomServiceItem> roomServiceItems;

        public RoomServicesGridAdapter(Context context, ArrayList<RoomServiceItem> roomServiceItems) {
            this.context = context;
            this.roomServiceItems = roomServiceItems;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_room_service_grid, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            RoomServiceItem roomServiceItem = roomServiceItems.get(position);
            holder.roomServiceImageView.setImageResource(roomServiceItem.getImageResId());
            holder.roomServiceTextView.setText(roomServiceItem.getTitle());
        }

        @Override
        public int getItemCount() {
            return roomServiceItems.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView roomServiceImageView;
            TextView roomServiceTextView;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                roomServiceImageView = itemView.findViewById(R.id.roomServiceImageView);
                roomServiceTextView = itemView.findViewById(R.id.roomServiceTextView);

                // Set click listener for each item in the grid
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = getAdapterPosition();
                        RoomServiceItem roomServiceItem = roomServiceItems.get(position);
                        if (position == 0) {
                            // Handle the click for the first item (navigate to the RoomServiceFoodFragment)
                            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_navigator)
                                    .navigate(R.id.room_service_food);
                        } else {
                            // Handle the click for other items in the grid
                            // ...
                        }
                    }
                });
            }
        }
    }
    private static class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
        private final int spanCount;
        private final int spacing;
        private final boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view);
            int column = position % spanCount;

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount;
                outRect.right = (column + 1) * spacing / spanCount;
            } else {
                outRect.left = column * spacing / spanCount;
                outRect.right = spacing - (column + 1) * spacing / spanCount;
            }

            outRect.top = spacing; // Add this line to set top spacing

            outRect.bottom = spacing;
        }
    }
}
