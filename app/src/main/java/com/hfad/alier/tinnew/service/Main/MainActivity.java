package com.hfad.alier.tinnew.service.Main;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.hfad.alier.tinnew.R;
import com.hfad.alier.tinnew.service.Adapter.Adapter;
import com.hfad.alier.tinnew.service.models.Payload;
import com.hfad.alier.tinnew.service.models.Title;

import java.util.List;

public class MainActivity extends AppCompatActivity implements TitleInterface {
    RecyclerView recyclerView = findViewById(R.id.recyclerList);
    SwipeRefreshLayout refreshLayout = findViewById(R.id.refreshLayout);

    RecyclerView.Adapter adapter;
    TitlePresenter titlePresenter;
    List<Title> titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitlePresenter();
        titleView();
        getList();
    }

    private void setTitlePresenter(){
        titlePresenter = new TitlePresenter(this);
    }

    private void titleView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        refreshLayout.setOnRefreshListener(() -> {
            refreshLayout.setRefreshing(true);
            refreshLayout.postDelayed(() -> {
                refreshLayout.setRefreshing(false);
                getList();
            }, 2000);
        });
    }

    private void getList(){
        titlePresenter.getNews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_refresh){
            getList();
        }
        return super.onOptionsItemSelected(item);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void showNews(Payload payload) {
        if (payload == null){
            titles = payload.getPayload();
            payload.getPayload().sort( ((o1, o2) ->
                    Long.compare(
                            o2.getMilliseconds(),
                            o1.getMilliseconds()
                    )));
            adapter = new Adapter(this, payload.getPayload(), title -> {
                            Intent intent = new Intent(this, ContentActivity.class);
                            intent.putExtra("id", title.getId());
                            startActivity(intent);
                        });

            recyclerView.setAdapter(adapter);
        }
    }
}
