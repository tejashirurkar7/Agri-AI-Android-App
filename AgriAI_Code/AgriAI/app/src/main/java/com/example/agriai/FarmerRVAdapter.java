package com.example.agriai;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FarmerRVAdapter extends RecyclerView.Adapter<FarmerRVAdapter.ViewHolder> {

    private ArrayList<FarmerDetails> farmerModalArrayList;
    private Context context;

    // constructor
    public FarmerRVAdapter(ArrayList<FarmerDetails> courseModalArrayList, Context context) {
        this.farmerModalArrayList = courseModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.farmer_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        FarmerDetails modal = farmerModalArrayList.get(position);
        holder.Username.setText(modal.getUsername());
        holder.District.setText(modal.getDistrict());
        holder.Taluka.setText(modal.getTaluka());
        holder.Mobileno.setText(modal.getMobileno());
        holder.Email.setText(modal.getEmail());

    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return farmerModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView Username,Email,District,Taluka,Mobileno;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            Username = itemView.findViewById(R.id.idTVUsername);
            District = itemView.findViewById(R.id.idTVDistrict);
            Taluka = itemView.findViewById(R.id.idTVTaluka);
            Mobileno = itemView.findViewById(R.id.idTVMobileno);
            Email = itemView.findViewById(R.id.idTVEmail);


        }
    }
}
