package movie.ticket.cinemaparadiso;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static movie.ticket.cinemaparadiso.Payment.code;
import static movie.ticket.cinemaparadiso.Payment.discount;
import static movie.ticket.cinemaparadiso.Seat.noseats;
import static movie.ticket.cinemaparadiso.CustomAdapter.cost;

public class EWallet extends Fragment {
    private SQLiteDatabase db = Splash.db;
    TextView tv,tv1;
    int bal,total;
    static int rem;
    Button btn,bt5;

    public EWallet() {
    }

    CommunicationInterface callback;

    @Override
    public void onActivityCreated(@Nullable Bundle outState) {
        super.onActivityCreated(outState);
        callback= (CommunicationInterface) getActivity();
    }


    @Override
    public void onResume() {
        super.onResume();
        try{
            Cursor c = db.rawQuery("SELECT balance FROM ewallet WHERE uid like '"+Login.name+"';", null);
            String s = "-1";
            while (c.moveToNext()) {
                s = c.getString(0);
            }
            bal = s.equals("-1")? 0 : Integer.parseInt(s);
            tv.setText("Balance : Rs."+bal);
            total = noseats*150+cost;
            if(code) {
                total = (int) (total * (1 - discount));
                code=false;
            }
            tv1.setText("Amount : Rs."+total);
        }catch (Exception e){
            Toast.makeText(super.getContext(),e.toString(),Toast.LENGTH_SHORT).show();
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(bal<total) {
                        Toast.makeText(EWallet.super.getContext(),"Insufficient Balance",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        rem = bal-total;
                        db.execSQL("UPDATE ewallet SET balance = " + (rem) + " WHERE uid like '"+Login.name+"'");
                        Intent i = new Intent(getActivity(), Transaction.class);
                        EWallet.super.startActivity(i);
                        getActivity().finish();
                    }
                }catch (Exception e){
                    Toast.makeText(EWallet.super.getContext(),e.toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Paying through Debit Card.",Toast.LENGTH_SHORT).show();
                callback.Action(1);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myInflatedView = inflater.inflate(R.layout.fragment_ewallet, container,false);
        tv = myInflatedView.findViewById(R.id.textView27);
        tv1 = myInflatedView.findViewById(R.id.textView28);
        btn = myInflatedView.findViewById(R.id.button5);
        bt5 = myInflatedView.findViewById(R.id.button12);
        return myInflatedView;
    }

}
