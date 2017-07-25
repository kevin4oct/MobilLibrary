package com.hebth.mobilelibrary.ui.bookdetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.hebth.mobilelibrary.R;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class BookDetailActivity extends AppCompatActivity {

    public static final int ISBNSEARCH = 0x100;
    public static final int BOOKIDSEARCH = 0x200;

    @ViewInject(R.id.tv_bookdetail)
    private TextView tv_isbn;

    private int searchType;
    private String searchValue;

    public static Intent getBookDetailIntent(Context context, int searchType, String searchValue) {
        Intent intent = new Intent(context, BookDetailActivity.class);
        intent.putExtra("searchType", searchType);
        intent.putExtra("searchValue", searchValue);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookdetail);
        x.view().inject(this);
        Bundle extras = getIntent().getExtras();
        searchType = extras.getInt("searchType", 0);
        searchValue = extras.getString("searchValue","");
        initView();
    }

    private void initView() {
        switch (searchType) {
            case ISBNSEARCH:
                tv_isbn.setText(searchValue);
                break;
            case BOOKIDSEARCH:

                break;
        }

    }

}
