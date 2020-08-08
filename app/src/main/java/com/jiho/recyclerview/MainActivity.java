package com.jiho.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jiho.recyclerview.model.MainModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<MainModel> mainModelArrayList; // 하나하나의 아이템 저장해둘 배열
    private MainAdapter myAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager; // 리니어 레이아웃 안에 item들을 배치해주는 역할

    int i;



    Button btnInsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInsert = (Button) findViewById(R.id.btnInsert);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_main_list);

        mainModelArrayList = new ArrayList<>();
        MainModel data = new MainModel();
        data.setId("아이디1");
        data.setStatusMessage("상태메시지1");
        mainModelArrayList.add(data);

        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        myAdapter = new MainAdapter(mainModelArrayList);
        recyclerView.setAdapter(myAdapter);


        i = 2;
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainModel data = new MainModel();
                data.setId("아이디" + i);
                data.setStatusMessage("상태메시지" + i);
                mainModelArrayList.add(data);
                i++;

                myAdapter.notifyDataSetChanged(); // 버튼 클릭 시 리사이클러뷰에 아이템 추가
            }
        });
    }
}