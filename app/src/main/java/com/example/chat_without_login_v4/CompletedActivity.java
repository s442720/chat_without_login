package com.example.chat_without_login_v4;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chat_without_login_v4.adapter.UserAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import model.User;

public class CompletedActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private Context context;
    private DatabaseReference reference;
    private List<User> friendsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed);
        context = this;

        reference = FirebaseDatabase.getInstance().getReference("Users");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                List<String> friends = new ArrayList<>();
                auth = FirebaseAuth.getInstance();
                FirebaseUser firebaseUser = auth.getCurrentUser();
                String userid = firebaseUser.getUid();
                for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
                    User user = snapshot.getValue(User.class);
                    if (userid.equals(user.getId())) {
                        for (String id: user.getFriends()) {
                            friends.add(id);
                        }
                    }
                }
                for (String friendId: friends) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        User user = snapshot.getValue(User.class);
                        if (friendId.equals(user.getId())) {
                            friendsList.add(user);
                        }
                    }
                }
                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                recyclerView.setAdapter(new UserAdapter(context, friendsList));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

//        friendsList.add(new User("jdifjdifj", "A", "happy"));
//        friendsList.add(new User("jdifjdifj", "B", "happy"));
//        friendsList.add(new User("jdifjdifj", "C", "sad"));
//        friendsList.add(new User("jdifjdifj", "D", "happy"));
//        friendsList.add(new User("jdifjdifj", "E", "sad"));

    }

}
