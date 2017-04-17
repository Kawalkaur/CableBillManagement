package kawal.com.cbm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddCustomers extends AppCompatActivity implements View.OnClickListener {

    TextView textName, textPhn, textEmail, textPassword, textAddress;
    EditText editName, editPhn, editEmail, editPassowrd, editAddress;
    Button buttonSubmit;

    void initViews(){
        textName = (TextView)findViewById(R.id.textName);
        textPhn = (TextView)findViewById(R.id.textPhn);
        textEmail = (TextView)findViewById(R.id.textEmail);
        textPassword = (TextView)findViewById(R.id.textPassword);
        textAddress =(TextView)findViewById(R.id.textAddress);
        editName = (EditText)findViewById(R.id.editName);
        editPhn = (EditText)findViewById(R.id.editPhn);
        editEmail= (EditText)findViewById(R.id.editEmail);
        editPassowrd= (EditText)findViewById(R.id.editPasssowrd);
        editAddress = (EditText)findViewById(R.id.editAddress);
        buttonSubmit =(Button)findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(this);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_customers);
        initViews();
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

     int id = v.getId();
        if(id==R.id.buttonSubmit){
            String name = editName.getText().toString().trim();
            Toast.makeText(this,editName.getText()+" is registered",Toast.LENGTH_LONG).show();
            Intent  intent = new Intent(AddCustomers.this,MainActivity.class);

            //intent.putExtra("keyName", name);
            //Bundle bundle = new Bundle();
            //bundle.putString("keyName", name);
            //intent.putExtra("keyBun", bundle);
            startActivity(intent);
        }
    }
}
