package com.nerdytech.noteit.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nerdytech.noteit.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    List<String> title;
    List<String> content;

    public Adapter(List<String> titile, List<String> content) {
        this.title = titile;
        this.content = content;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.note_view_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.noteTitle.setText(title.get(position));
        holder.noteContent.setText(content.get(position));

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "The item is Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return title.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {
        TextView noteTitle,noteContent;
        View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            noteTitle=itemView.findViewById(R.id.titles);
            noteContent=itemView.findViewById(R.id.content);
            view=itemView;
        }
    }
}
