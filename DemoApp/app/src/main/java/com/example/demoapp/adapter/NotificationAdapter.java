package com.example.demoapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demoapp.R;
import com.example.demoapp.model.NotiNotification;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {

    private Context context;
    private List<NotiNotification> notiNotificationList;

    public NotificationAdapter(Context context, List<NotiNotification> notiNotificationList) {
        this.context = context;
        this.notiNotificationList = notiNotificationList;
    }

    @NonNull
    @Override
    public NotificationAdapter.NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cardviewnotification_custom, null);
        return new NotificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationAdapter.NotificationViewHolder holder, int position) {
        NotiNotification notiNotification = notiNotificationList.get(position);
        //binding the data with the viewholder views

        holder.title.setText(notiNotification.getTitle());
        holder.content.setText(notiNotification.getContent());
        holder.time.setText(notiNotification.getTime());
        holder.place.setText(notiNotification.getPlace());
        holder.address.setText(notiNotification.getAddress());
        holder.time2.setText(notiNotification.getTime());
    }

    @Override
    public int getItemCount() {
        return notiNotificationList.size();
    }

    public class NotificationViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView content;
        private TextView time;
        private TextView place;
        private TextView address;
        private TextView time2;
        public NotificationViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.textTitle);
            content = (TextView) itemView.findViewById(R.id.textContent);
            time = (TextView) itemView.findViewById(R.id.textTime);
            place = (TextView) itemView.findViewById(R.id.textPlace);
            address = (TextView) itemView.findViewById(R.id.textAddress);
            time2 = (TextView) itemView.findViewById(R.id.textTime2);
        }
    }
}
