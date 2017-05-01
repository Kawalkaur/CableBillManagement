package kawal.com.cbm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AdminSignUp extends AppCompatActivity implements View.OnClickListener {

    TextView textEmail, textSignUp, textPassword;
    EditText editEmail, editPassword;
    Button btnLogin;
    CheckBox cbShowPwd;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    FileBean bean;
    RequestQueue requestQueue;
    String email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_sign_up);
        initViews();
    }

    void initViews() {
        textEmail = (TextView) findViewById(R.id.textEmail);
        textSignUp = (TextView) findViewById(R.id.textSignUp);
        textPassword = (TextView) findViewById(R.id.textPassword);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editPassword = (EditText) findViewById(R.id.editPasssowrd);
        cbShowPwd = (CheckBox) findViewById(R.id.cbShowPwd);
        preferences = getSharedPreferences(Util.PREFS_NAME, MODE_PRIVATE);
        editor = preferences.edit();
        bean = new FileBean();
        requestQueue = Volley.newRequestQueue(this);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);

        cbShowPwd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    editPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    editPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });
    }
 /*       btnLogin.setOnClickListener(new View.OnClickListener() {
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
*/

    void Signinjson()
    {


        StringRequest stringRequest = new StringRequest(Request.Method.POST, Util.LOGIN_STUDENT_PHP, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try
                {
                    JSONObject jsonObject = new JSONObject(response);
                    int success = jsonObject.getInt("success");
                    String message = jsonObject.getString("message");
                    if (success==1)
                    {
                        editor.putString(Util.KEY_NAME,bean.getCusName());
                        editor.commit();
                        Intent intent = new Intent(AdminSignUp.this,MainActivity.class);
                        startActivity(intent);
                        finish();

                    }
                    else {
                        Log.e("user",message+success);
                        Toast.makeText(AdminSignUp.this,"Login fail"+message,Toast.LENGTH_SHORT).show();
                    }


                }
                catch (Exception e)
                {

                    Toast.makeText(AdminSignUp.this,"Some exception",Toast.LENGTH_SHORT).show();

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(AdminSignUp.this,"Volley error",Toast.LENGTH_SHORT).show();

            }
        })

        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> map = new HashMap<>();
                map.put("e_mail",email);
                map.put("password",password);
                return map;
            }
        };
        requestQueue.add(stringRequest);

    }


    @Override
    public void onClick(View v) {
        email= editEmail.getText().toString().trim();
        password=editPassword.getText().toString().trim();
        Log.i("email",email);
        Log.i("password",password);

        Signinjson();

    }
}
