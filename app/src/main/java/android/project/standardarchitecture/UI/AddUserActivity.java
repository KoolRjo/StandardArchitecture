package android.project.standardarchitecture.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.project.standardarchitecture.R;
import android.project.standardarchitecture.ROOM.DataViewModel;
import android.project.standardarchitecture.ROOM.ENTITY.User;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddUserActivity extends AppCompatActivity {
    private DataViewModel viewModel;
    private EditText edtID;
    private EditText edtName;
    private EditText edtAccount;
    private EditText edtPass;
    private Button btnSave;
    //Gets views on Activity
    private void getViews(){
        edtID = findViewById(R.id.edt_id);
        edtName = findViewById(R.id.edt_name);
        edtAccount = findViewById(R.id.edt_account);
        edtPass = findViewById(R.id.edt_pass);
        btnSave = findViewById(R.id.btn_save);
    }
    //Save User's data into Local database
    private void saveUserData(){
        btnSave.setOnClickListener(view->{
            if(TextUtils.isEmpty(edtID.getText()) || TextUtils.isEmpty(edtName.getText()) ||
               TextUtils.isEmpty(edtAccount.getText()) || TextUtils.isEmpty(edtPass.getText())){
                Toast.makeText(this,"You need fill up full information!",Toast.LENGTH_SHORT).show();
            }else{
                int id = Integer.parseInt(edtID.getText().toString().trim());
                String name = edtName.getText().toString().trim();
                String account = edtAccount.getText().toString().trim();
                String pass = edtPass.getText().toString().trim();
                User user = new User(id,name,account,pass);
                viewModel.insertUser(user);
                Intent intent = new Intent(this,ListUserDetail.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        viewModel = new ViewModelProvider(this).get(DataViewModel.class);
        getViews();
        saveUserData();
    }

}