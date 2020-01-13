package com.example.armd.Adapters;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.armd.Models.Comments;
import com.example.armd.R;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewholder>{

    private List<Comments> commentsList;
    private Context context;

    public CommentAdapter() {
    }

    public CommentAdapter(List<Comments> commentsList, Context context) {
        this.commentsList = commentsList;
        this.context = context;
    }

    @NonNull
    @Override
    public CommentViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.row_comment, parent, false);
        return new CommentViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewholder holder, int position) {

        Glide.with(context).load(commentsList.get(position).getuImg()).into(holder.userimg);
        holder.commentContent.setText(commentsList.get(position).getContent());
        holder.userName.setText(commentsList.get(position).getuName());
        holder.time.setText(timestampToString((Long)commentsList.get(position).getTimeStamp()));
    }

    @Override
    public int getItemCount() {
        return commentsList.size();
    }

    public class CommentViewholder extends RecyclerView.ViewHolder {

        ImageView userimg;
        TextView commentContent;
        TextView time;
        TextView userName;

        public CommentViewholder(@NonNull View itemView) {
            super(itemView);

            userimg = itemView.findViewById(R.id.comment_user_img);
            commentContent = itemView.findViewById(R.id.comment_content);
            time = itemView.findViewById(R.id.comment_date);
            userName = itemView.findViewById(R.id.comment_username);
        }
    }

    private String timestampToString(long time) {

        Calendar calendar = Calendar.getInstance(Locale.ENGLISH);
        calendar.setTimeInMillis(time);
        String date = DateFormat.format("hh:mm",calendar).toString();
        return date;


    }
}
