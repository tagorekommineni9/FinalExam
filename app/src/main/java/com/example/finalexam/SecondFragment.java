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

import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SecondFragment extends Fragment {

    //  ImageView repousrimage;

    //  TextView txtRepoId, txtRepoName, txtRepoFullName, txtRepoCreatedAt, txtRepoPushedAt,txtRepoUpdatedAt;

    //  ArrayList<repos_> repoarray;
    RecycleAdapter2 adapter2;

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        //   repousrimage = getView().findViewById(R.id.img_repouser);

        DataServices service = RetrofitClientInstance.getRetrofitInstance().create(DataServices.class);

        Call<List<repos_>> call = service.getAllRepos();

        call.enqueue(new Callback<List<repos_>>() {
            @Override
            public void onResponse(Call<List<repos_>> call, Response<List<repos_>> response) {
                List<repos_> r = response.body();
                try{
                    generateView(new ArrayList<repos_>(r), view);
                }
                catch(NullPointerException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<repos_>> call, Throwable t) {

            }
        });

    }

    private void generateView(ArrayList<repos_> rarry, View view) {

        //  repos_ repos = repoarray.get(0);

        //     Picasso.get().load(repos.getOwner().getAvatarUrl()).into(repousrimage);

        //   repoarray.remove(0);

        adapter2 = new RecycleAdapter2(rarry,getActivity().getApplicationContext());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.VERTICAL,false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter2);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }


}
