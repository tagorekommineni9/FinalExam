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

public class FifthFragment extends Fragment {

    ArrayList<coderepos_> codreparray;
    RecycleAdapter5 adapter;

    public FifthFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DataServices services = RetrofitClientInstance.getRetrofitInstance().create(DataServices.class);
        Call<coderepos> call = services.getAllMatchedCodeDetails();

        call.enqueue(new Callback<coderepos>() {
            @Override
            public void onResponse(Call<coderepos> call, Response<coderepos> response) {
                coderepos coderepos = response.body();
                try{
                    codreparray = new ArrayList<>(coderepos.getCoderepos());
                    genView(codreparray,view);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<coderepos> call, Throwable t) {

            }
        });

    }

    private void genView(ArrayList<coderepos_> codreparray, View view) {

        adapter = new RecycleAdapter5(codreparray, getActivity().getApplicationContext());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.VERTICAL,false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview5);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fifth, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

}
