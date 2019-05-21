package com.hfad.alier.tinnew.service.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hfad.alier.tinnew.R;
import com.hfad.alier.tinnew.service.Main.MainActivity;
import com.hfad.alier.tinnew.service.models.Title;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class Adapter extends RecyclerView.Adapter<Adapter.NewsHolder>{
    Context context;
    List<Title> titles;
    private final SelectedListener selectedListener;
    SimpleDateFormat dateFormat;

    public Adapter(List<Title> newsTitleList, Context context, SelectedListener selectedListener){
        this.titles = titles;
        this.context = context;
        this.dateFormat = new SimpleDateFormat("HH:mm, dd MMM yyyy", Locale.ENGLISH);
        this.selectedListener = selectedListener;
    }


    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_item, viewGroup, false);
        NewsHolder newsHolder =  new NewsHolder(view);
        return newsHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder newsHolder, final int i) {
        newsHolder.nameText.setText(titles.get(i).getText());
        newsHolder.dateText.setText(dateFormat.format(new Date(titles.get(i).getMilliseconds())));
        newsHolder.itemView.setOnClickListener(item -> selectedListener.onSelected(titles.get(i)));
    }

    public interface SelectedListener{
        void onSelected(Title title);
    }


    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class NewsHolder extends RecyclerView.ViewHolder{
        TextView nameText, dateText;

        public NewsHolder(@NonNull View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.name_text);
            dateText = itemView.findViewById(R.id.date_text);
        }
    }
}
