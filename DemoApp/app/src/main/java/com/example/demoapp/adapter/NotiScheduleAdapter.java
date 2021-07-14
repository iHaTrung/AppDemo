package com.example.demoapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demoapp.R;
import com.example.demoapp.model.NotiSchedule;

import java.util.List;

public class NotiScheduleAdapter extends RecyclerView.Adapter<NotiScheduleAdapter.NotiScheduleViewHolder> {

    private Context context;
    private List<NotiSchedule> notiScheduleList;

    public NotiScheduleAdapter(Context context, List<NotiSchedule> notiScheduleList) {
        this.context = context;
        this.notiScheduleList = notiScheduleList;
    }

    @NonNull
    @Override
    public NotiScheduleAdapter.NotiScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cardviewschedule_custom, null);
        return new NotiScheduleViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull NotiScheduleAdapter.NotiScheduleViewHolder holder, int position) {

        NotiSchedule notiSchedule = notiScheduleList.get(position);
        //binding the data with the viewholder views
        holder.title.setText(notiSchedule.getTitle());
        holder.content.setText(notiSchedule.getContent());
        holder.time.setText(notiSchedule.getTime());
        holder.place.setText(notiSchedule.getPlace());
        holder.address.setText(notiSchedule.getAddress());
    }

    @Override
    public int getItemCount() {
        return notiScheduleList.size();
    }


    public class NotiScheduleViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView content;
        private TextView time;
        private TextView place;
        private TextView address;
        public NotiScheduleViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.textTitle);
            content = (TextView) itemView.findViewById(R.id.textContent);
            time = (TextView) itemView.findViewById(R.id.textTime);
            place = (TextView) itemView.findViewById(R.id.textPlace);
            address = (TextView) itemView.findViewById(R.id.textAddress);
        }
    }
}
