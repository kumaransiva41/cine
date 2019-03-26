package movie.ticket.cinemaparadiso;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static movie.ticket.cinemaparadiso.Payment.code;
import static movie.ticket.cinemaparadiso.Payment.discount;

public class offer extends Fragment {

    CommunicationInterface callback;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        callback = (CommunicationInterface) getActivity();
        final View myInflatedView = inflater.inflate(R.layout.fragment_offer, container,false);
        Button bt = myInflatedView.findViewById(R.id.button16),bt1 = myInflatedView.findViewById(R.id.button17);
        final EditText et = myInflatedView.findViewById(R.id.editText14);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onFailed();
            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et.getText().toString().equals(Basic.offe)){
                    Toast.makeText(offer.super.getContext(),"Offer Accepted.",Toast.LENGTH_SHORT).show();
                    code = true;
                }
                else
                    Toast.makeText(offer.super.getContext(),"Offer not valid.",Toast.LENGTH_SHORT).show();
                callback.onFailed();
            }
        });

        return myInflatedView;
    }
}
