package com.example.room.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.room.data.MainData;
import com.example.room.R;
import com.example.room.data.RoomDB;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<MainData> dataList;
    private Activity context;
    private RoomDB database;

    public MainAdapter(Activity context,List<MainData> dataList) {
        this.context = context;
       // this.database = database;
        this.dataList = dataList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Initialize view

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        //initializ main data
        MainData data=dataList.get(position);
        //initializ database
        database=RoomDB.getInstance(context);
        //set text on text view
        holder.textView.setText(data.getText());

        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainData d=dataList.get(holder.getAdapterPosition());
                //get id
                final int sID=d.getID();
                //getText
                String sText=d.getText();

                //create dilaog
                final Dialog dialog=new Dialog(context);
                //set Context View
                dialog.setContentView(R.layout.dialog_update);
                //initializ width
                int width= WindowManager.LayoutParams.MATCH_PARENT;
                //initializ hight
                int hight= WindowManager.LayoutParams.WRAP_CONTENT;
                //set Layout
                dialog.getWindow().setLayout(width,hight);
                //show dilaog
                dialog.show();

                //initializ and assign variable
                final EditText editText=dialog.findViewById(R.id.edit_text);
                Button btnUpadte=dialog.findViewById(R.id.bt_Update);

                //set text on the edit text
                editText.setText(sText);

                btnUpadte.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                      //  dismiss dialog
                        dialog.dismiss();
                        //get update text from edit text
                        String uText=editText.getText().toString().trim();
                        //update text in database
                        database.mainDoa().update(sID,uText);
                        //notify when data is update
                        dataList.clear();
                        dataList.addAll(database.mainDoa().getAll());
                        notifyDataSetChanged();
                    }
                });
            }
        });

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //init main data
                MainData d =dataList.get(holder.getAdapterPosition());
                //delete form dartabase
                int position=holder.getAdapterPosition();
                dataList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,dataList.size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //inisializ variable

        TextView textView;
        ImageView btnEdit,btnDelete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView=itemView.findViewById(R.id.text_view);
            btnEdit=itemView.findViewById(R.id.btn_edit);
            btnDelete=itemView.findViewById(R.id.btn_delete);
        }
    }
}
