package com.rasheek.iconnect_admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.rasheek.iconnect_admin.Model.Tickets;

import java.util.ArrayList;
import java.util.List;

public class tickets extends AppCompatActivity {
    private ListView ticketListView;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    private TicketAdapter ticketAdapter;
    private ArrayList<Tickets> ticketsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tickets);

        ticketListView = (ListView) findViewById(R.id.missionList);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ticketsList = new ArrayList<Tickets>();
        //set the Adapter
        ticketAdapter = new TicketAdapter(this, ticketsList);

        ticketListView.setAdapter(ticketAdapter);

        db.collection("tickets")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        List<Tickets> mMissionsList = new ArrayList<>();
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Tickets miss = document.toObject(Tickets.class);
                                mMissionsList.add(miss);
                                Log.d("TAG", document.getId() + " => " + document.getData());
                            }
                            ListView mMissionsListView = (ListView) findViewById(R.id.missionList);
                            TicketAdapter mMissionAdapter = new TicketAdapter(tickets.this, mMissionsList);
                            mMissionsListView.setAdapter(mMissionAdapter);
                        } else {
                            Log.w("TAG", "Error getting documents.", task.getException());
                        }
                    }
                });

    }
}