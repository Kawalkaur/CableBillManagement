package kawal.com.cbm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AdminSignUp extends AppCompatActivity {

    TextView textUserName, textSignUp, textPassword;
    EditText editUserName, editPassword;
    Button btnLogin;
    CheckBox cbShowPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_sign_up);
        initViews();
    }

    void initViews() {
        textUserName = (TextView) findViewById(R.id.textUserName);
        textSignUp = (TextView) findViewById(R.id.textSignUp);
        textPassword = (TextView) findViewById(R.id.textPassword);
        editUserName = (EditText) findViewById(R.id.editUserName);
        editPassword = (EditText) findViewById(R.id.editPasssowrd);
        cbShowPwd = (CheckBox)findViewById(R.id.cbShowPwd);

        btnLogin = (Button) findViewById(R.id.btnLogin);

        cbShowPwd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                 @Override
                                                 public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
    if (!isChecked){
        editPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }else{
        editPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
    }
                                                 }
                                             });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // if (editUserName.getText().toString().length() == 0) {
                 //   Toast.makeText(getApplicationContext(), "Name cannot be Blank", Toast.LENGTH_LONG).show();
                    // Toast.makeText(getApplicationContext(), "Invalid Email", Toast.LENGTH_LONG).show();

                   // editUserName.setError("Name cannot be Blank");
                    //editUserName.setError("Invalid Email");
                   // return;
                //} else {
                    //String pass = editPassword.getText().toString();
                    //if(TextUtils.isEmpty(pass)|| pass.length()<8){
                    //  editPassword.setError("You muust have 8 characters in your password");

                    //return;

                    Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                //}

                startActivity(new Intent(AdminSignUp.this, MainActivity.class));
            }
        });
    }
}
