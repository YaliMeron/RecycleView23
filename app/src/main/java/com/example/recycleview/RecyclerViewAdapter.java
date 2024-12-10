package com.example.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context context;
    ArrayList<Model> Models;

    public RecyclerViewAdapter(Context context, ArrayList<Model> Models){
        this.context = context;
        this.Models = Models;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycle_view_row,parent,false);
        return new RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
    holder.tvName1.setText(Models.get(position).getText1());
    holder.tvName2.setText(Models.get(position).getText2());
    holder.imageView.setImageResource(Models.get(position).getImage());
    }

    @Override
    public int getItemCount() {

        return Models.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
    ImageView imageView;
    TextView tvName1;
    TextView tvName2;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView3);
            tvName1 = itemView.findViewById(R.id.textView);
            tvName2 = itemView.findViewById(R.id.textView2);
        }
    }
}
