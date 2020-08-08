package com.jiho.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jiho.recyclerview.model.MainModel;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {

    private ArrayList<MainModel> mainModelArrayList;

    public MainAdapter(ArrayList<MainModel> list){ // 객체 생성 시 arrayList를 매개변수로 전달받음
        this.mainModelArrayList = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // 아이템 목록 하나하나의 레이아웃을 설정
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);

        MyViewHolder viewHolder = new MyViewHolder(view); // 커스텀 뷰 홀더 클래스 객체

        return viewHolder; // 한 개의 아이템을 리턴
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) { // 커스텀 뷰 홀더 클래스에서 전달받은 컴포넌트 객체들을 순번에 맞게 구분
        holder.txtStatus.setText(mainModelArrayList.get(position).getStatusMessage());
        holder.txtId.setText(mainModelArrayList.get(position).getId());
    }

    @Override
    public int getItemCount() {
        return (null != mainModelArrayList ? mainModelArrayList.size() : 0);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{ // Viewholder의 역할은 item 하나하나의 레이아웃을 화면에 띄워주는 역할

        TextView txtId, txtStatus;

        public MyViewHolder(@NonNull View itemView) { // 여기 들어가있는 컴포넌트들은 위의 onBindViewHolder 메서드로 전달
            super(itemView);
            txtId = (TextView) itemView.findViewById(R.id.txtId);
            txtStatus = (TextView) itemView.findViewById(R.id.txtStatus);

        }
    }
}
