package com.example.finalexam;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ThirdFragment extends Fragment {

    ArrayList<issues_> isuarray;
    RecycleAdapter3 adapter3;





    public ThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DataServices service = RetrofitClientInstance.getRetrofitInstance().create(DataServices.class);
        Call<issues> call = service.getAllIssues();

        call.enqueue(new Callback<issues>() {
            @Override
            public void onResponse(Call<issues> call, Response<issues> response) {
                issues issues = response.body();

                try {
                    isuarray = new ArrayList<>(issues.getIssues());
                    genView(isuarray,view);
                }
                catch (NullPointerException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<issues> call, Throwable t) {

            }
        });
    }

    private void genView(ArrayList<issues_> iary, View view) {

        adapter3 = new RecycleAdapter3(iary,getActivity().getApplicationContext());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.VERTICAL,false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview3);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter3);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }


}
