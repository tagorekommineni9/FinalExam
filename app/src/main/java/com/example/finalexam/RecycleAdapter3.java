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

public class RecycleAdapter3 extends RecyclerView.Adapter<RecycleAdapter3.ViewHolder> {

    private ArrayList<issues_> arryissues;
    private Context context;

    public RecycleAdapter3(ArrayList<issues_> arryissues,Context context){
        this.arryissues = arryissues;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleitem3,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter3.ViewHolder holder, int position) {

        Picasso.get().load(arryissues.get(position).getUser().getAvatarUrl()).into(holder.issuloginuserimg);
        holder.issuloginname.setText("LOGIN:     "+arryissues.get(position).getUser().getLogin());
        holder.issutitle.setText("TITLE:     "+arryissues.get(position).getTitle());
        holder.issucomments.setText("NUM OF COMMENTS:     "+arryissues.get(position).getComments().toString());
        holder.issucreatedat.setText("CREATED AT:     "+arryissues.get(position).getCreatedAt());
        holder.issuupdatedat.setText("UPDATED AT:     "+arryissues.get(position).getUpdatedAt());
    }

    @Override
    public int getItemCount() {
        return arryissues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView issuloginuserimg;
        TextView issuloginname, issutitle, issucomments, issucreatedat, issuupdatedat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            issuloginuserimg = itemView.findViewById(R.id.issues_avatar);
            issuloginname = itemView.findViewById(R.id.issues_userloginname);
            issutitle = itemView.findViewById(R.id.issues_title);
            issucomments = itemView.findViewById(R.id.issues_comments);
            issucreatedat = itemView.findViewById(R.id.issues_created_at);
            issuupdatedat = itemView.findViewById(R.id.issues_updated_at);


            itemView.setTag(this);
        }
    }
}
