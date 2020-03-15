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

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FirstFragment extends Fragment {
    ArrayList<github_> garray;
    RecycleAdapter adapter;


    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DataServices service = RetrofitClientInstance.getRetrofitInstance().create(DataServices.class);
        Call<github> call = service.getAllUsers();

        call.enqueue(new Callback<github>() {
            @Override
            public void onResponse(Call<github> call, Response<github> response) {
                github github = response.body();
                try{
                    garray = new ArrayList<>(github.getGithub());
                    generateView(garray,view);
                }
                catch(NullPointerException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<github> call, Throwable t) {

            }
        });
    }

    private void generateView(ArrayList<github_> gary, View view) {

        adapter = new RecycleAdapter(gary,getActivity().getApplicationContext());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.VERTICAL,false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

}
