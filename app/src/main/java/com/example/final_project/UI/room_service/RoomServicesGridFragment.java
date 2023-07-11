package com.example.final_project.UI.room_service;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
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
        roomServiceItems.add(new RoomServiceItem(R.drawable.falafel, "Your Room Service Title"));
        // Add other RoomServiceItem objects for the grid

        // Set up the RecyclerView with the GridLayoutManager and adapter
        int numberOfColumns = 2; // Number of items in each row
        roomServicesRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), numberOfColumns));
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
                            // Get the NavController
                            NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_navigator);
                            // Navigate to the RoomServiceFragment
                            navController.navigate(R.id.room_service_food);
                            /*// Handle the click for the first item (redirect to the RoomServiceFragment)
                            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                            fragmentManager.popBackStackImmediate(); // Remove the current fragment from the back stack

                            // Create an instance of the RoomServiceFragment
                            RoomServiceFragment roomServiceFragment = new RoomServiceFragment();

                            // Replace the current fragment with the RoomServiceFragment
                            fragmentManager.beginTransaction()
                                    .replace(R.id.nav_host_fragment_content_navigator, roomServiceFragment)
                                    .addToBackStack(null) // Add the transaction to the back stack
                                    .commit();*/
                        } else {
                            // Handle the click for other items in the grid
                            // ...
                        }
                    }
                });

            }
        }
    }
}
