package com.example.agriai;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FeedbackRVAdapter extends RecyclerView.Adapter<FeedbackRVAdapter.ViewHolder>{
    private ArrayList<FeedbackDetails> feedbackModalArrayList;
    private Context context;

    public FeedbackRVAdapter(ArrayList<FeedbackDetails> feedbackModalArrayList, Context context) {
        this.feedbackModalArrayList = feedbackModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public FeedbackRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feedback_rv_item, parent, false);
        return new FeedbackRVAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedbackRVAdapter.ViewHolder holder, int position) {
        FeedbackDetails modal = feedbackModalArrayList.get(position);
        holder.UserName.setText(modal.getUsername());
        holder.Email.setText(modal.getEmail());
        holder.Feedback.setText(modal.getFeedback());

    }

    @Override
    public int getItemCount() {
        return feedbackModalArrayList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView UserName, Email, Feedback;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            UserName = itemView.findViewById(R.id.idTVUsername);
            Email = itemView.findViewById(R.id.idTVEmail);
            Feedback = itemView.findViewById(R.id.idTVFeedback);

        }
    }
}
