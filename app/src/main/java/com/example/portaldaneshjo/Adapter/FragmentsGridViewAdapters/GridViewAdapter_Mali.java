package com.example.portaldaneshjo.Adapter.FragmentsGridViewAdapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.portaldaneshjo.Activity.Omor_mali_activities.Formol_shahrie;
import com.example.portaldaneshjo.Activity.Omor_mali_activities.Pardakht_electronic;
import com.example.portaldaneshjo.Activity.Omor_mali_activities.Pardakht_namovafagh;
import com.example.portaldaneshjo.Activity.Omor_mali_activities.Vaziate_mali;
import com.example.portaldaneshjo.R;

public class GridViewAdapter_Mali extends BaseAdapter {
    private Context context;
    private String[] nameItem;
    private Integer[] pictureItemNumber;

    public GridViewAdapter_Mali(Context context, String[] nameItem, Integer[] PictureItemNumber) {
        this.context = context;
        this.nameItem = nameItem;
        this.pictureItemNumber = PictureItemNumber;
    }

    @Override
    public int getCount() {
        return nameItem.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class Holder{
        ImageView imageView;
        TextView textView;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        Holder holder = new Holder();
        View view;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.items_gridview_simple,null);
        holder.imageView = (ImageView) view.findViewById(R.id.img_items_id);
        holder.textView = (TextView) view.findViewById(R.id.txt_items_id);
        holder.imageView.setImageResource(pictureItemNumber[position]);
        holder.textView.setText(nameItem[position]);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (nameItem[position]){
                    case "پرداخت الکترونیک":{
                        v.getContext().startActivity(new Intent(context, Pardakht_electronic.class));break;
                    }
                    case "وضعیت مالی":{
                        v.getContext().startActivity(new Intent(context, Vaziate_mali.class));break;
                    }
                    case "محاسبه شهریه":{

                        v.getContext().startActivity(new Intent(context , Formol_shahrie.class));
                       break;


                    }
                    case "پرداخت ناموفق":{
                        v.getContext().startActivity(new Intent(context , Pardakht_namovafagh.class));

                        break;
                    }
                }
            }
        });
        return view;
    }
}
