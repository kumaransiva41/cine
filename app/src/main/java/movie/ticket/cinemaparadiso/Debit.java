package movie.ticket.cinemaparadiso;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static movie.ticket.cinemaparadiso.CustomAdapterCard.cno;
import static movie.ticket.cinemaparadiso.Payment.flag;
import static movie.ticket.cinemaparadiso.Splash.db;

public class Debit extends Fragment {
    public Debit() {
        // Required empty public constructor
    }

    CommunicationInterface callback;

    @Override
    public void onActivityCreated(@Nullable Bundle outState) {
        super.onActivityCreated(outState);
        callback= (CommunicationInterface) getActivity();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myInflatedView = inflater.inflate(R.layout.fragment_debit, container,false);
        TextView t,t1,t2;
        final EditText e;int cvv = 0;
        t = myInflatedView.findViewById(R.id.textView5);
        t1 = myInflatedView.findViewById(R.id.textView6);
        t2 = myInflatedView.findViewById(R.id.textView22);
        e = myInflatedView.findViewById(R.id.editText12);
        final EditText e1 = myInflatedView.findViewById(R.id.editText13);
        Button bt = myInflatedView.findViewById(R.id.button6);
        Cursor c = db.rawQuery("SELECT * FROM card WHERE cardno like '"+cno+"';", null);
        while (c.moveToNext()) {
            t.setText(c.getString(1));
            t1.setText(c.getString(3));
            t2.setText(c.getString(2));
            cvv = c.getInt(4);
        }
        int i = flag;
        switch (i) {
            case 0:
                bt.setText("Pay");
                e1.setVisibility(View.INVISIBLE);
                final int finalCvv = cvv;
                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int cvvI = callback.StoI(e.getText().toString());
                        if (e.getText().toString()!="" && cvvI== finalCvv) {
                            Intent i = new Intent(getActivity(), Transaction.class);
                            getActivity().startActivity(i);
                            getActivity().finish();
                        }
                        else
                            Toast.makeText(Debit.super.getActivity(),"Payment Failed.",Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case 1:
                bt.setText("Recharge");
                final int fcv = cvv;
                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Cursor c = db.rawQuery("SELECT balance FROM ewallet WHERE uid like '"+Login.name+"';", null);
                        String s = "-1";
                        int E = callback.StoI(e.getText().toString()),E1 = callback.StoI(e1.getText().toString()),S = callback.StoI(s);
                        while (c.moveToNext()) {
                            s = c.getString(0);
                        }
                        S = callback.StoI(s);
                        if (E== fcv) {
                            if(E1>0) {
                                db.execSQL("UPDATE ewallet SET balance = " + (S + E1) + " WHERE uid like '" + Login.name + "'");
                            }
                            else{
                                Toast.makeText(getContext(),"Enter valid amount",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                            Toast.makeText(Debit.super.getActivity(),"Payment Failed.",Toast.LENGTH_SHORT).show();
                        callback.onFailed();
                    }
                });
                break;
        }
        return myInflatedView;
    }

}
