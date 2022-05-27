package android.project.standardarchitecture.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.project.standardarchitecture.R;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private Button btnLogIn;
    private void getViews(){
        btnLogIn = findViewById(R.id.btn_LogIn);
    }
    private void innitButtonsFunction(){
        btnLogIn.setOnClickListener(v->{
            try {
                Intent logIntent = new Intent(this,AddUserActivity.class);
                startActivity(logIntent);
            }catch (ActivityNotFoundException exception){
                Log.i(TAG,"Exception: "+exception,exception);
                Toast.makeText(this,"Add User Activity not found",Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getViews();
        innitButtonsFunction();
    }
}