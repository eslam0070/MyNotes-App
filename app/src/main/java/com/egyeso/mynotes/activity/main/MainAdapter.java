package com.egyeso.mynotes.activity.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.egyeso.mynotes.R;
import com.egyeso.mynotes.models.Note;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private Context context;
    private List<Note> noteList;
    private ItemClickListener itemClickListener;

    MainAdapter(Context context, List<Note> noteList, ItemClickListener itemClickListener) {
        this.context = context;
        this.noteList = noteList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_note,viewGroup,false);
        return new ViewHolder(view,itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Note note = noteList.get(i);
        viewHolder.tv_title.setText(note.getTitle());
        viewHolder.tv_note.setText(note.getNote());
        viewHolder.tv_date.setText(note.getDate());
        viewHolder.card_item.setCardBackgroundColor(note.getColor());

    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv_title , tv_note , tv_date;
        CardView card_item;
        ItemClickListener itemClickListener;
        ViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
            super(itemView);
            this.itemClickListener = itemClickListener;

            tv_title = itemView.findViewById(R.id.i_title);
            tv_note = itemView.findViewById(R.id.i_note);
            tv_date = itemView.findViewById(R.id.i_date);
            card_item = itemView.findViewById(R.id.card_item);
            card_item.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            itemClickListener.onItemClick(view,getAdapterPosition());
        }
    }

    public interface ItemClickListener{
        void onItemClick(View view , int position);
    }
}
