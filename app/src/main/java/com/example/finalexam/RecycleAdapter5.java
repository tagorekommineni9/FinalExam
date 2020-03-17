package com.example.finalexam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleAdapter5 extends RecyclerView.Adapter<RecycleAdapter5.ViewHolder> {

    private ArrayList<coderepos_> arrycodrep;
    private Context context;

    public RecycleAdapter5(ArrayList<coderepos_> arrycodrep, Context context){
        this.arrycodrep = arrycodrep;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleitem5,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter5.ViewHolder holder, int position) {

        holder.cdr_filename.setText(arrycodrep.get(position).getName());
        holder.cdr_filepath.setText(arrycodrep.get(position).getPath());
        holder.cdr_repname.setText(arrycodrep.get(position).getRepository().getName());
        holder.cdr_reptype.setText(arrycodrep.get(position).getRepository().getOwner().getType());
        holder.cdr_description.setText(arrycodrep.get(position).getRepository().getDescription());
        holder.cdr_htmlurl.setText(arrycodrep.get(position).getHtmlUrl());
    }

    @Override
    public int getItemCount() {
        return arrycodrep.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView cdr_filename, cdr_filepath, cdr_repname, cdr_reptype, cdr_description, cdr_htmlurl;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cdr_filename = itemView.findViewById(R.id.coderepo_filename);
            cdr_filepath = itemView.findViewById(R.id.coderepo_filepath);
            cdr_repname = itemView.findViewById(R.id.coderepo_reponame);
            cdr_reptype = itemView.findViewById(R.id.coderepo_repotype);
            cdr_description = itemView.findViewById(R.id.coderepo_description);
            cdr_htmlurl = itemView.findViewById(R.id.coderepo_htmlurl);

            itemView.setTag(this);

        }
    }
}
