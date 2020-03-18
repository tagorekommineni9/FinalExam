package com.example.finalexam;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FourthFragment extends Fragment {

    ArrayList<userdetails_> usrarray;
    RecycleAdapter4 adapter4;

    public FourthFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DataServices service = RetrofitClientInstance.getRetrofitInstance().create(DataServices.class);
        Call<userdetails> call = service.getAllusersDetails();

        call.enqueue(new Callback<userdetails>() {
            @Override
            public void onResponse(Call<userdetails> call, Response<userdetails> response) {
                userdetails userdetails = response.body();
                try{
                    usrarray = new ArrayList<>(userdetails.getUserdetails());
                    genView(usrarray,view);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<userdetails> call, Throwable t) {

            }
        });
    }

    private void genView(ArrayList<userdetails_> usrarray, View view) {

        adapter4 = new RecycleAdapter4(usrarray,getActivity().getApplicationContext());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.VERTICAL,false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview4);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter4);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fourth, container, false);
    }




    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }
}
