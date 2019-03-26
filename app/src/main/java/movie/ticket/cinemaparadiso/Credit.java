package movie.ticket.cinemaparadiso;

import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static movie.ticket.cinemaparadiso.Payment.credit;
import static movie.ticket.cinemaparadiso.Splash.db;

public class Credit extends Fragment {

    CommunicationInterface callback;
    String ex;


    @Override
    public void onActivityCreated(@Nullable Bundle outState) {
        super.onActivityCreated(outState);
        callback= (CommunicationInterface) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myInflatedView = inflater.inflate(R.layout.fragment_credit, container,false);
        final EditText cardNumber = myInflatedView.findViewById(R.id.editText8),name,expiry,cvv;
        expiry = myInflatedView.findViewById(R.id.editText9);
        name = myInflatedView.findViewById(R.id.editText10);
        cvv = myInflatedView.findViewById(R.id.editText11);
        Button bt = myInflatedView.findViewById(R.id.button15),bt1 = myInflatedView.findViewById(R.id.button7);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = cardNumber.getText().toString();
                s = callback.cardNo(s);
                int cd,to = 0;
                cd = credit ? 1 : 0;
                if(!s.equals("")) {
                    int cvvI = callback.StoI(cvv.getText().toString());
                    if(!name.getText().toString().equals("") && !expiry.getText().toString().equals("")) {
                        ex = expiry.getText().toString();
                        if(ex.length()==4){
                            int mon = callback.StoI(ex.substring(0,2)),yr= callback.StoI(ex.substring(2,4));
                            if(mon>-1 && mon<13){
                                if(cvvI<100)
                                    to=4;
                                else{
                                    if(yr>19 && yr<24) {
                                        try {
                                            db.execSQL("insert into card values('" + Login.name + "', '" + s + "','" + name.getText().toString() + "','" + mon + "/" + yr + "'," + cvvI + "," + cd + ");");
                                            callback.onFailed();
                                        } catch (Exception e) {
                                            if (e.toString().contains("UNIQUE")) {
                                                Toast.makeText(getContext(), "Card already exists.", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    }
                                    else{
                                        if(yr<19)
                                            Toast.makeText(getContext(), "Card has expired.", Toast.LENGTH_SHORT).show();
                                        if(yr>24)
                                            Toast.makeText(getContext(), "Card Invalid.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                            else
                                to=2;
                        }
                        else
                            to=5;
                    }
                    else
                        to=1;
                }
                else
                    to=3;
                switch (to){
                    case 1:
                        Toast.makeText(getContext(),"Enter valid Details.",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getContext(),"Month not valid.",Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(getContext(),"Invalid Card Number.",Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(getContext(),"CVV number invalid.",Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(getContext(),"Expiry date format should be mmyy",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.Action(1);
            }
        });
        return myInflatedView;
    }

}
