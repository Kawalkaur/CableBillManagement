package kawal.com.cbm;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.iid.FirebaseInstanceId;

import java.util.HashMap;
import java.util.Map;

public class AddCustomers extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    TextView textName, textPhn, textEmail, textAddress;
    EditText editName, editPhn, editEmail, editAddress;
    RadioButton male, female;
    Button buttonSubmit;
    Spinner city;

    boolean updateMode;

    ArrayAdapter<String> adapter;
    RequestQueue requestQueue;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    FileBean bean, rcvBean;

    ContentResolver resolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_customers);

        bean = new FileBean();
        preferences = getSharedPreferences(Util.PREFS_NAME, MODE_PRIVATE);
        editor = preferences.edit();

            textName = (TextView)findViewById(R.id.textName);
            textPhn = (TextView)findViewById(R.id.textPhn);
            textEmail = (TextView)findViewById(R.id.textEmail);
            textAddress =(TextView)findViewById(R.id.textAddress);
            editName = (EditText)findViewById(R.id.editName);
            editPhn = (EditText)findViewById(R.id.editPhn);
            editEmail= (EditText)findViewById(R.id.editEmail);
            city = (Spinner)findViewById(R.id.spinnercity);
            editAddress = (EditText)findViewById(R.id.editAddress);
            buttonSubmit =(Button)findViewById(R.id.buttonSubmit);
            buttonSubmit.setOnClickListener(this);
            male = (RadioButton)findViewById(R.id.rbMale);
            female = (RadioButton)findViewById(R.id.rbFemale);
            male.setOnCheckedChangeListener(this);
            female.setOnCheckedChangeListener(this);



        adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item);

        adapter.add("--Select City--");
        adapter.add("Ludhiana");
        adapter.add("Chandigarh");
        adapter.add("Delhi");
        adapter.add("Bengaluru");
        adapter.add("California");

        city.setAdapter(adapter);
        city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i!= 0) {
                    bean.setCusCity(adapter.getItem(i));
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        resolver = getContentResolver();
        requestQueue = Volley.newRequestQueue(this);


        Intent rcv = getIntent();
         updateMode= rcv.hasExtra("Key");

        if (updateMode) {
            rcvBean = (FileBean) rcv.getSerializableExtra("Key");
            editName.setText(rcvBean.getCusName());
            editEmail.setText(rcvBean.getCusEmail());

            if (rcvBean.getGender().equals("Male")) {
                male.setChecked(true);

            } else {
                female.setChecked(true);

            }

            int p = 0;
            for (int i=0;i < adapter.getCount(); i++) {
                if (adapter.getItem(i).equals(rcvBean.getCusCity())) {
                    p = i;
                    break;
                }
            }

            city.setSelection(p);

        }
    }





    @Override
    public void onClick(View v) {

       /* if(editName.getText().toString().length()==0){
            editName.setError("Name cannot be Blank");
            return;
        }else if(editPhn.getText().toString().length()==0){
            editPhn.setError("Phone number cannot be Blank");
            return;
        }else if (!Patterns.EMAIL_ADDRESS.matcher(editEmail.toString()).matches()){
            editEmail.setError("Invalid Email");
            return;
        }else{
            Toast.makeText(getApplicationContext(), editName.getText()+" added Successfully", Toast.LENGTH_SHORT).show();
        }*/

            String name = editName.getText().toString().trim();
            String phn = editPhn.getText().toString().trim();
            String email = editEmail.getText().toString().trim();
            String address = editAddress.getText().toString().trim();
            /*Toast.makeText(this,editName.getText()+" is registered",Toast.LENGTH_LONG).show();
            Intent  intent = new Intent(AddCustomers.this,MainActivity.class);

            //intent.putExtra("keyName", name);
            //Bundle bundle = new Bundle();
            //bundle.putString("keyName", name);
            //intent.putExtra("keyBun", bundle);
            startActivity(intent);*/
            insertIntoCloud();
        }

    void insertIntoCloud(){

        final String token = FirebaseInstanceId.getInstance().getToken();
        StringRequest request = new StringRequest(Request.Method.POST, Util.INSERT_STUDENT_PHP, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(AddCustomers.this,"Response",Toast.LENGTH_LONG).show();
                editor.putString(Util.KEY_NAME, bean.getCusName());
                editor.commit();
                Intent intent = new Intent(AddCustomers.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(AddCustomers.this,"Some Error"+error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> map = new HashMap<>();
                map.put("name",bean.getCusName());
                map.put("mobile",bean.getCusMobile());
                map.put("email",bean.getCusEmail());
                map.put("gender",bean.getGender());
                map.put("city",bean.getCusCity());
                map.put("address",bean.getCusAddress());
                map.put("token",token);
                return map;


            }
        };


        requestQueue.add(request);

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

        int id = compoundButton.getId();

        if(isChecked)
        {
            if(id==R.id.rbMale)
            {
                bean.setGender("Male");

            }
            else {
                bean.setGender("Female");
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(0,101,0,"All Customers");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id = item.getItemId();
        if(id == 101)
        {
            Intent i = new Intent(AddCustomers.this,CustomersActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }


    public void Login(View view) {

        Intent intent = new Intent(AddCustomers.this,AdminSignUp.class);
        startActivity(intent);

    }


}



