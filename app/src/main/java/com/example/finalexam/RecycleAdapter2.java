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

public class RecycleAdapter2 extends RecyclerView.Adapter<RecycleAdapter2.ViewHolder> {

    private ArrayList<repos_> arryrepo;
    private Context context;

    public RecycleAdapter2(ArrayList<repos_> arryrepo, Context context){
        this.arryrepo = arryrepo;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleitem2,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //   Picasso.get().load(arryrepo.get(position).getOwner().getAvatarUrl()).into(holder.imgRepoUser);
        holder.txtRepoId.setText(arryrepo.get(position).getId().toString());
        holder.txtRepoName.setText(arryrepo.get(position).getName());
        holder.txtRepoFullName.setText(arryrepo.get(position).getFullName());
        holder.txtRepoCreatedAt.setText(arryrepo.get(position).getCreatedAt());
        holder.txtRepoUpdatedAt.setText(arryrepo.get(position).getUpdatedAt());
        holder.txtRepoPushedAt.setText(arryrepo.get(position).getPushedAt());
    }

    @Override
    public int getItemCount() {
        return arryrepo.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtRepoId, txtRepoName, txtRepoFullName, txtRepoCreatedAt, txtRepoPushedAt,txtRepoUpdatedAt;
        ImageView imgRepoUser;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //  imgRepoUser = itemView.findViewById(R.id.img_repouser);
            txtRepoId = itemView.findViewById(R.id.repo_id);
            txtRepoName = itemView.findViewById(R.id.repo_name);
            txtRepoFullName = itemView.findViewById(R.id.repo_full_name);
            txtRepoCreatedAt = itemView.findViewById(R.id.repo_created_at);
            txtRepoUpdatedAt = itemView.findViewById(R.id.repo_updated_at);
            txtRepoPushedAt = itemView.findViewById(R.id.repo_pushed_at);

            itemView.setTag(this);
        }
    }
}
