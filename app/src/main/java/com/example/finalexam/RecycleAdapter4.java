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

public class RecycleAdapter4 extends RecyclerView.Adapter<RecycleAdapter4.ViewHolder> {

    private ArrayList<userdetails_> arryusrdetails;
    private Context context;

    public RecycleAdapter4(ArrayList<userdetails_> arryusrdetails,Context context){
        this.arryusrdetails = arryusrdetails;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleitem4,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter4.ViewHolder holder, int position) {
        Picasso.get().load(arryusrdetails.get(position).getAvatarUrl()).into(holder.usrdetailImage);
        holder.usrdetailLoginName.setText(arryusrdetails.get(position).getLogin());
        holder.usrdetailID.setText(arryusrdetails.get(position).getId().toString());
        holder.usrdetailGITurl.setText(arryusrdetails.get(position).getHtmlUrl());
        holder.usrReposurl.setText(arryusrdetails.get(position).getReposUrl());
        holder.usrUserType.setText(arryusrdetails.get(position).getType());
    }

    @Override
    public int getItemCount() {
        return arryusrdetails.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView usrdetailImage;
        TextView usrdetailLoginName, usrdetailID, usrdetailGITurl, usrReposurl, usrUserType;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            usrdetailImage = itemView.findViewById(R.id.usersrepos_userimage);
            usrdetailLoginName = itemView.findViewById(R.id.userrepos_userlogin);
            usrdetailID = itemView.findViewById(R.id.userrepos_userId);
            usrdetailGITurl = itemView.findViewById(R.id.userrepos_gitURL);
            usrReposurl = itemView.findViewById(R.id.userrepos_reposurl);
            usrUserType = itemView.findViewById(R.id.userrepos_usertype);
        }
    }
}
