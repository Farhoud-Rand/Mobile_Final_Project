package com.example.final_project.UI.Home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.final_project.OffersActivity;
import com.example.final_project.R;
import com.example.final_project.databinding.FragmentHomeBinding;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;

public class HomeFragment extends Fragment {

    private ImageView home_img;
    private FragmentHomeBinding binding;
    ImageView offers_img;
    private int[] imageArray = {R.drawable.offer1, R.drawable.offer2, R.drawable.offer3};
    private int currentIndex = 0;
    private Handler handler;
    private Runnable runnable;
    private Timer slideshowTimer;
    private boolean isSlideshowRunning = false;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

//        binding = FragmentHomeBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        View root = rootView;

        offers_img = rootView.findViewById(R.id.offers_imageView);



        //--------------------------------------------------------------------------------------
//        // for home image
//        home_img = rootView.findViewById(R.id.hotel_image_main);
//        Glide.with(this)
//                .asGif()
//                .load(R.drawable.hotel_info)
//                .centerInside()// Set the scale type to centerCrop
//                .into(home_img);

        // for offers images show
        startSlideshow();
        // now when i press on offers img it will go to offersActivity()
        offers_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event here
                Intent intent = new Intent(getActivity(), OffersActivity.class);
                startActivity(intent);
            }
        });



        return root;
    }
    //===================================================================================
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void startSlideshow() {
        slideshowTimer = new Timer();
        slideshowTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(HomeFragment.this)
                                .asGif()
                                .load(imageArray[currentIndex])
                                .centerInside()
                                .transition(DrawableTransitionOptions.withCrossFade())
                                .into(offers_img);

                        currentIndex = (currentIndex + 1) % imageArray.length;
                    }
                });
            }
        }, 0, 3000); // Delay of 2 seconds
    }
    private void stopSlideshow() {
        if (slideshowTimer != null) {
            slideshowTimer.cancel();
            slideshowTimer = null;
        }
    }
}