package com.rasheek.iconnect_admin;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.rasheek.iconnect_admin.Model.Tickets;

import java.util.List;



public class TicketAdapter extends ArrayAdapter<Tickets> {
    public TicketAdapter(Context context, List<Tickets> object){
        super(context,0, object);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            convertView =  ((Activity)getContext()).getLayoutInflater().inflate(R.layout.item_task,parent,false);
        }

        TextView titleTextView = (TextView) convertView.findViewById(R.id.mission_title);
        TextView ticketTypeTextView = (TextView) convertView.findViewById(R.id.mission_type);
        TextView descriptionTextView = (TextView) convertView.findViewById(R.id.mission_description);

        Tickets mission = getItem(position);

        titleTextView.setText(mission.getTitle());
        ticketTypeTextView.setText(mission.getType());
        descriptionTextView.setText(mission.getBody());


        return convertView;
    }

}