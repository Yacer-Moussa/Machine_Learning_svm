package com.screenrate.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import data.model.Empfehlung;
import data.save.status;

public class EmpfehlungenAdapter extends RecyclerView.Adapter<EmpfehlungenAdapter.EmpfehlungViewHolder> {
    private Context myContext;
    private status myStatus;


    public EmpfehlungenAdapter(Context context, status status) {
        myContext = context;
        myStatus = status;
    }


    @NonNull
    @Override
    public EmpfehlungViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empfehlung, parent, false);
        return new EmpfehlungViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EmpfehlungViewHolder holder, int position) {
        int count = myStatus.getEmpfehlungenCount();
        List<Empfehlung> myEmpfehlungen = myStatus.getEmpfehlungList();
        if(count > position){
            holder.imageView.setImageResource(myStatus.getApplicationContext().getResources().getIdentifier(myEmpfehlungen.get(position).getScreenName(),"drawable", myStatus.getPackageName()));
            holder.nameTextView.setText(myEmpfehlungen.get(position).getEmpfohlenVon());
            holder.kommentarTextView.setText(myEmpfehlungen.get(position).getKommentar());
        }
    }

    @Override
    public int getItemCount() {
        return myStatus.getEmpfehlungenCount();
    }

    public class EmpfehlungViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView nameTextView;
        public TextView kommentarTextView;

        public EmpfehlungViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            kommentarTextView = itemView.findViewById(R.id.kommentarTextView);
        }
    }
}
