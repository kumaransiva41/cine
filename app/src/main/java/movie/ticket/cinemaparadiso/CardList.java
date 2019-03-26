package movie.ticket.cinemaparadiso;

import android.database.Cursor;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static movie.ticket.cinemaparadiso.Basic.recharge;
import static movie.ticket.cinemaparadiso.Payment.credit;
import static movie.ticket.cinemaparadiso.Splash.db;

public class CardList extends Fragment {

    CommunicationInterface callback;
    public CardList() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        callback= (CommunicationInterface) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myInflatedView = inflater.inflate(R.layout.fragment_card_list, container,false);
        ListView lv = myInflatedView.findViewById(R.id.List1);
        TextView t=myInflatedView.findViewById(R.id.CardSelect);
        ArrayList<String> cardDetails = new ArrayList();
        int cd;
        cd = credit ? 1 : 0;
        Cursor c = db.rawQuery("SELECT cardno FROM card WHERE uid like '"+Login.name+"' and type=="+cd+";", null);
        while (c.moveToNext()) {
            cardDetails.add(c.getString(0));
        }
        if(cardDetails.size()<1){
            cardDetails.add("No cards registered.");
        }
        else
            t.setText("Select a card :");
        CustomAdapterCard adapter = new CustomAdapterCard(super.getActivity(), cardDetails);
        lv.setAdapter(adapter);
        Button bt1 = myInflatedView.findViewById(R.id.button20);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onSuccess();
            }
        });

        if(recharge.equals("T")) {
            String amo = "";
            c = db.rawQuery("SELECT balance FROM ewallet WHERE uid like '" + Login.name + "';", null);
            String s = "-1";
            while (c.moveToNext()) {
                s = c.getString(0);
            }
            amo = s.equals("-1") ? "0" : s;
            TextView bal = myInflatedView.findViewById(R.id.Balance);
            bal.setText("Balance : Rs." + amo);
        }
        return myInflatedView;
    }

}
