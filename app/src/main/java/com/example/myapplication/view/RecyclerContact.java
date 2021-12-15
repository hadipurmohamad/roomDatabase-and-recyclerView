package com.example.myapplication.view;


import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Contact;

import java.util.List;

public class RecyclerContact  extends RecyclerView.Adapter<RecyclerContact.ViewHolder>  {
private List<Contact> allContact;
private RecycelerGetposition recycelerGetposition;

    public RecyclerContact(List<Contact> allContact, RecycelerGetposition recycelerGetposition) {
        this.allContact = allContact;
        this.recycelerGetposition = recycelerGetposition;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_contact,null);

        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contact contact =allContact.get(position);
        holder.name.setText(contact.getName());
        holder.occupation.setText(contact.getOccupation());

    }

    @Override
    public int getItemCount() {
        return allContact.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name,occupation;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.txt_name);
            occupation=itemView.findViewById(R.id.txt_occupation);
itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
recycelerGetposition.getposition(getAdapterPosition());
        }
    }
    public interface RecycelerGetposition{
        void getposition(int position);
    }
}
