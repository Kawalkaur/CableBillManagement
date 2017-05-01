package kawal.com.cbm;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomersActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    ArrayList<FileBean> objects;
    CustomersAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        initViews();
    }

    void initViews() {
        listView = (ListView) findViewById(R.id.listView);
        objects = new ArrayList<>();

        /*FileBean cus1 = new FileBean(R.drawable.user, "John", "+91 99999 88888", "john@example.com", "Ludhiana");
        FileBean cus2 = new FileBean(R.drawable.user, "Jennie", "+91 88888 77777", "jennie@example.com", "Ludhiana");
        FileBean cus3 = new FileBean(R.drawable.user, "Joe", "+91 77777 66666", "joe@example.com", "Ludhiana");
        FileBean cus4 = new FileBean(R.drawable.user, "Jim", "+91 66666 55555", "jim@example.com", "Ludhiana");
        FileBean cus5 = new FileBean(R.drawable.user, "Jimmie", "+91 55555 44444", "jimmie@example.com", "Ludhiana");
        FileBean cus6 = new FileBean(R.drawable.user, "jinn", "+91 44444 33333", "jinn@example.com", "Ludhiana");

        objects.add(cus1);
        objects.add(cus2);
        objects.add(cus3);
        objects.add(cus4);
        objects.add(cus5);
        objects.add(cus6);
*/
        adapter = new CustomersAdapter(this, R.layout.list_item, objects);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
        FileBean customer = objects.get(i);
        Toast.makeText(this, "You Clicked:" + customer.getCusName(), Toast.LENGTH_LONG).show();

    }

    public void fab(View view) {
        Intent intent = new Intent(CustomersActivity.this, AddCustomers.class);
        startActivity(intent);
        Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show();
    }
}

