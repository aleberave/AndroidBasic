package com.example.lesson5hw.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.lesson5hw.R;
import com.example.lesson5hw.fragments.StartSecondActivity;
import com.example.lesson5hw.recycle.DataSourceBuilder;
import com.example.lesson5hw.recycle.Soc;
import com.example.lesson5hw.recycle.SocnetAdapter;

import java.util.ArrayList;
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

//        Parsel parsel = getIntent().getExtras().getParcelable(StartSecondActivity.TEXT);
//        // Добавим элемент в 0-ю позицию
//        dataSource.add(0, new Soc(parsel.text,
//                R.drawable.icon1_weather, true));
//        // Дадим инструкцию адаптеру, что данные изменились
//        adapter.notifyDataSetChanged();

        ArrayList<String> arrayList = getIntent().getStringArrayListExtra(StartSecondActivity.THIRD);
        if (arrayList.size() > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                dataSource.add(0, new Soc(arrayList.get(i),
                        R.drawable.icon1_weather, true));
                adapter.notifyDataSetChanged();
            }
        }

//        String[] array = getIntent().getStringArrayExtra(StartSecondActivity.THIRD);
//        if(array.length > 0){
//            for (int i = 0; i < array.length; i++) {
//                dataSource.add(0, new Soc(array[i],
//                        R.drawable.icon1_weather, true));
//                adapter.notifyDataSetChanged();
//            }
//        }

        // установить слушателя
        adapter.SetOnItemClickListener(new SocnetAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(ThirdActivity.this, getString(R.string.position, position),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}
