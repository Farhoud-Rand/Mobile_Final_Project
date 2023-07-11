package com.example.final_project.UI.Cart;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.final_project.Models.Service;
import com.example.final_project.Models.ServiceAdapter;
import com.example.final_project.R;

import java.util.ArrayList;
import java.util.List;

public class cart extends Fragment {

    private static List<Service> serviceList;
    private static ServiceAdapter serviceAdapter;
    private static double totalCost;

    private static TextView totalCostTextView;

    public cart() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_cart, container, false);

        totalCostTextView = rootView.findViewById(R.id.totalCostTextView);

        serviceList = new ArrayList<>();
        serviceAdapter = new ServiceAdapter(serviceList);

        RecyclerView recyclerView = rootView.findViewById(R.id.serviceRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(serviceAdapter);
        createNewService(new Service("",0));

        return rootView;
    }

    // Method to add a new Service object to the RecyclerView
    public static void createNewService(Service service) {
        if (serviceList != null) {  // Ensure that serviceList is not null
            serviceList.add(service);
            serviceAdapter.notifyDataSetChanged();

            // Update the total cost
            totalCost += service.getCost();
            totalCostTextView.setText(String.valueOf(totalCost));
        }
    }
}
