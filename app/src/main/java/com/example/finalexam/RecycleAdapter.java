package com.example.finalexam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {

    private ArrayList<github_> arrygusr;
    private Context context;

    public RecycleAdapter(ArrayList<github_> arrygusr, Context context){
        this.arrygusr = arrygusr;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleitem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter.ViewHolder holder, int position) {
        Picasso.get().load(arrygusr.get(position).getAvatarUrl()).into(holder.guserimg);
        holder.gname.setText(arrygusr.get(position).getLogin());
    }

    @Override
    public int getItemCount() {
        return arrygusr.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView guserimg;
        TextView gname;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            guserimg = itemView.findViewById(R.id.img_gituser);
            gname = itemView.findViewById(R.id.txt_gitusername);

            itemView.setTag(this);

        }
    }
}

