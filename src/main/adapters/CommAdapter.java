package hexa.congressApp.com.congress.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import hexa.congressApp.com.congress.R;
import hexa.congressApp.com.congress.model.CommModel;

public class CommAdapter extends ArrayAdapter {
    ArrayList<CommModel> name=new ArrayList<>();
    Context con;


    public CommAdapter(FragmentActivity activity, ArrayList<CommModel> byStatesModels) {
        super(activity, R.layout.bills_adpater_layout);
        name=byStatesModels;
        con=activity;

        Collections.sort(name,CommModel.CommNameComparator);

    }

    @Override
    public int getCount() {
        return name.size();
    }
    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return name.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }


    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       Holder holder;

        convertView=LayoutInflater.from(parent.getContext()).inflate(R.layout.bills_adpater_layout, parent, false);

        holder=new Holder();
        holder.tv = (TextView) convertView.findViewById(R.id.billType);
        holder.tv1 = (TextView) convertView.findViewById(R.id.title);
        holder.tv2 = (TextView) convertView.findViewById(R.id.date);

        holder.tv.setText(name.get(position).getCommId());
        holder.tv1.setText(name.get(position).getCommName());
        holder.tv2.setText(name.get(position).getCommChamber().substring(0,1).toUpperCase() + name.get(position).getCommChamber().substring(1));
        return convertView;
    }
    private static class Holder {
        TextView tv;
        TextView tv1;
        TextView tv2;

    }
}
