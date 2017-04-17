package kawal.com.cbm;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kawaldeep on 4/8/2017.
 */

public class CustomersAdapter extends ArrayAdapter<FileBean> {

    Context context;
    int resource;
    ArrayList<FileBean> objects;

    public CustomersAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<FileBean> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = null;
        view = LayoutInflater.from(context).inflate(resource,parent,false);
        ImageView cusImage = (ImageView) view.findViewById(R.id.cusImage);
        TextView cusName = (TextView)view.findViewById(R.id.textCusName);
        TextView cusMobile = (TextView)view.findViewById(R.id.textCusMobile);
        TextView cusEmail = (TextView)view.findViewById(R.id.textCusEmail);
        TextView cusAddress = (TextView)view.findViewById(R.id.textCusAddress);

        FileBean customer = objects.get(position);
        cusImage.setBackgroundResource(customer.getCusImage());
        cusName.setText(customer.getCusName());
        cusMobile.setText(customer.getCusMobile());
        cusEmail.setText(customer.getCusEmail());
        cusAddress.setText(customer.getCusAddress());
        return  view;
    }
}
