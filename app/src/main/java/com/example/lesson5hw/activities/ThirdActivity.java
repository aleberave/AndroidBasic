package com.example.lesson5hw.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.lesson5hw.R;
import com.example.lesson5hw.recycle.DataSourceBuilder;
import com.example.lesson5hw.recycle.Soc;
import com.example.lesson5hw.recycle.SocnetAdapter;

import java.util.List;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        // установим аниматор по умолчанию
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // эта установка служит для повышения производительности системы.
        recyclerView.setHasFixedSize(true);

        // будем работать со встроенным менеджером
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // создаем источник данных
        DataSourceBuilder builder = new DataSourceBuilder(getResources());
        final List<Soc> dataSource = builder.build();

        // установим адаптер
        final SocnetAdapter adapter = new SocnetAdapter(dataSource);
        recyclerView.setAdapter(adapter);

        // установить слушателя
        adapter.SetOnItemClickListener(new SocnetAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(ThirdActivity.this, getString(R.string.position, position),
                        Toast.LENGTH_SHORT).show();
            }
        });

        Button buttonNewSearch = findViewById(R.id.buttonNewSearch);
        buttonNewSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
