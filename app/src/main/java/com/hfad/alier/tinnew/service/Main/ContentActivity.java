package com.hfad.alier.tinnew.service.Main;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.hfad.alier.tinnew.R;
import com.hfad.alier.tinnew.service.models.Content;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ContentActivity extends AppCompatActivity implements ViewPresenter{

    TextView titleView, contentView, dateView;
    String Id;
    SimpleDateFormat simpleDateFormat;
    ContentPresernt presernt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        Id = getIntent().getStringExtra("id");
        simpleDateFormat = new SimpleDateFormat("HH:mm, dd MMM yyyy", Locale.ENGLISH);

        initPresenter();
        initView();
        getNewContent();
    }

    public void initPresenter(){
        presernt = new ContentPresernt(this);
    }

    public void initView(){
        contentView.setMovementMethod(new ScrollingMovementMethod());
    }

    public void getNewContent(){
        presernt.getNews(Id);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showNewsContent(Content payload) {
        if (payload != null){
            titleView.setText(payload.getTitle().getText());

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                contentView.setText(Html.fromHtml(payload.getContent(), Html.FROM_HTML_MODE_COMPACT));
            }
            else {
                contentView.setText(Html.fromHtml(payload.getContent()));
                dateView.setText(simpleDateFormat.format(new Date(payload.getTitle().getMilliseconds())));
            }
        }
    }


}
