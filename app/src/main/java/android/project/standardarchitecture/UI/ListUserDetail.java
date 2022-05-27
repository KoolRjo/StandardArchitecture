package android.project.standardarchitecture.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.project.standardarchitecture.R;
import android.project.standardarchitecture.ROOM.DataViewModel;
import android.project.standardarchitecture.ROOM.UserListAdapter;
import android.util.Log;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListUserDetail extends AppCompatActivity {
    private static final String Tag = ListUserDetail.class.getSimpleName();
    private DataViewModel dataViewModel;
    private FloatingActionButton fabAddUser;
    private void getViews(){
        fabAddUser = findViewById(R.id.fab_add_user);
    }
    private void addUser(){
        fabAddUser.setOnClickListener(view->{
            Intent intent = new Intent(this,AddUserActivity.class);
            try{
                startActivity(intent);
            }catch(ActivityNotFoundException exception){
                exception.printStackTrace();
                Log.i(Tag,"Khong tim thay AddUserActivity");
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user_detail);
        getViews();
        addUser();
        dataViewModel = new ViewModelProvider(this).get(DataViewModel.class);
        RecyclerView rvUsers = findViewById(R.id.rv_list_users);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        final UserListAdapter listAdapter = new UserListAdapter(new UserListAdapter.UserDiff());
        rvUsers.setAdapter(listAdapter);
        rvUsers.setLayoutManager(layoutManager);
        rvUsers.setHasFixedSize(true);
        /*dataViewModel.getGetAllUsers().observe(this , users -> {
            listAdapter.submitList(users);
            Log.i(Tag,"Number of users: "+users.size());
        });

         */
        dataViewModel.getGetAllUsers().observe(this,list->{
            listAdapter.submitList(list);
            Log.i(Tag,"Number of users: "+list.size());
        });

    }
}