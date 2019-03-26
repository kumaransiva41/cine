package movie.ticket.cinemaparadiso;

import android.app.Activity;
import android.content.Context;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomAdapter extends ArrayAdapter<String> {
    Activity context;
    String[] fill1,fill2,fill3;
    int[] fill4,fill5;
    TextView tprice;
    public static int cost = 0;

    public CustomAdapter( Activity context,String[] fill1,String[] fill2,String[] fill3,int[] fill4,int[] fill5) {
        super(context,0,fill1);
       // Toast.makeText(getContext(),fill1[0].toString(),Toast.LENGTH_LONG).show();
        this.context = context;
        this.fill1 = fill1;
        this.fill2 = fill2;
        this.fill3 = fill3;
        this.fill4=fill4;
        this.fill5=fill5;


    }



    @NonNull
    @Override
    public View getView(final int position, View convertView, @NonNull ViewGroup parent) {
       // Toast.makeText(getContext(), fill1[0],Toast.LENGTH_LONG).show();
        LayoutInflater inflater=context.getLayoutInflater();

        View view=inflater.inflate(R.layout.custom,parent,false);
        final TextView tvquant=view.findViewById(R.id.tvquant);
        final TextView tvcost=view.findViewById(R.id.tvcost);
        TextView tvveg=view.findViewById(R.id.tvveg);
        TextView tvfoodname=view.findViewById(R.id.tvfoodname);
      tvquant.setText(Integer.toString(fill5[position]));

       tvfoodname.setText(fill1[position]);
       tvcost.setText(fill2[position]);
       tvveg.setText(fill3[position]);
        ImageView imgcust=view.findViewById(R.id.imgcust);
        imgcust.setImageDrawable(context.getDrawable(fill4[position]));

         tprice=context.findViewById(R.id.tvprice);



        Button btplus=view.findViewById(R.id.btplus);
        Button btmin=view.findViewById(R.id.btmin);

        //Toast.makeText(getContext(), fill1[0],Toast.LENGTH_LONG).show();


        btmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x=Integer.parseInt(tvquant.getText().toString());
                int x1=Integer.parseInt(tvcost.getText().toString());
                int x2=Integer.parseInt(tprice.getText().toString());
                if(x>0){
                x--;
                    fill5[position]-=1;
                    x2 = x2 - x1;}

                tvquant.setText(Integer.toString(x));

                tprice.setText(Integer.toString(x2));
                cost = x2;
            }
        });
        btplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x=Integer.parseInt(tvquant.getText().toString());
                int x1=Integer.parseInt(tvcost.getText().toString());
                int x2=Integer.parseInt(tprice.getText().toString());
                if(x<5) {
                    x++;
                    fill5[position] += 1;
                    x2 = x2 + x1;
                }
                else{
                    Toast.makeText(getContext(),"Maximum 5 items can be selected.",Toast.LENGTH_SHORT).show();
                }

                tvquant.setText(Integer.toString(x));

                tprice.setText(Integer.toString(x2));
                cost = x2;

            }
        });
           return view;
    }
}
