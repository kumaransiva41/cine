package movie.ticket.cinemaparadiso;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static movie.ticket.cinemaparadiso.Basic.recharge;

public class Payment extends AppCompatActivity implements CommunicationInterface{

    Spinner sp;
    ArrayAdapter<String> dataAdapter;
    public static int flag = 0;
    public static double discount = 0;
    public static boolean credit,offer = true,code = false;
    @Override
    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        sp= findViewById(R.id.spinner4);
        List<String> list = new ArrayList<>();
        if(!recharge.equals("T")) {
            list.add("Select Mode");
            list.add("E Wallet");
        }
        list.add("Debit Card");
        if(!recharge.equals("T"))
            list.add("Credit Card");
        dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list) {
            @Override
            public boolean isEnabled(int position) {
                if (position == 0)
                    return false;
                else
                    return true;
            }

            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View spinnerview = super.getDropDownView(position, convertView, parent);
                TextView spinnertextview = (TextView) spinnerview;
                if(position == 0) {
                    spinnertextview.setTextColor(Color.parseColor("#bcbcbb"));
                }
                else {
                    spinnertextview.setTextColor(Color.BLACK);
                }
                return spinnerview;
            }
        };
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(dataAdapter);
        if(!recharge.equals("T")) {
            sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    //Toast.makeText(getApplicationContext()," "+i+" "+l,Toast.LENGTH_SHORT).show();
                    Fragment fr;
                    credit = false;
                    switch (i) {
                        case 0:
                            if (offer) {
                                fr = new offer();
                                offer = false;
                            } else
                                fr = new BlankFragment();
                            break;
                        case 1:
                            fr = new EWallet();
                            break;
                        case 2:
                            fr = new CardList();
                            Bundle bundle = new Bundle();
                            bundle.putInt("Re", 0);
                            flag = 0;
                            fr.setArguments(bundle);
                            break;
                        case 3:
                            fr = new CardList();
                            credit = true;
                            break;
                        default:
                            fr = new BlankFragment();
                    }
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fm.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment2, fr);
                    fragmentTransaction.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                    Toast.makeText(getApplicationContext(), "Nothing", Toast.LENGTH_SHORT).show();
                }
            });
        }
        else{
            sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                    Fragment fr;
                    credit = false;
                    fr = new CardList();
                    Bundle bundle = new Bundle();
                    bundle.putInt("Re", 0);
                    flag = 1;
                    fr.setArguments(bundle);
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fm.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment2, fr);
                    fragmentTransaction.commit();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
            //Action(1);
        }
    }

    @Override
    public void onSuccess() {
        Fragment fr = new Credit();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment2, fr);
        fragmentTransaction.commit();
    }

    @Override
    public void onFailed() {
        Fragment fr = new BlankFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment2, fr);
        fragmentTransaction.commit();
        sp.setAdapter(dataAdapter);
    }

    @Override
    public void Action(int i) {
        Fragment fg = new BlankFragment(),fr;
        fr = fg;
        credit = false;
        switch (i){
            case 1:     // from Ewallet to Recharge
                fr = new CardList();
                flag = 1;
                break;
            case 2:     // from Debit card
                fr = new Debit();
                break;
        }
        if(fr.equals(fg)){
            Toast.makeText(this,"Initialization Error.",Toast.LENGTH_SHORT).show();
        }
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment2, fr);
        fragmentTransaction.commit();

    }

    @Override
    public int StoI(String s) {
        if(!s.equals("")){
            return Integer.parseInt(s);
        }
        else
            return -1;
    }

    @Override
    public String cardNo(String s) {
        String a = "";
        if(s.length()==16) {
            a+=s.substring(0, 4);
            for (int i = 1; i < 4; i++)
                a += " " + s.substring(i * 4, (i+1)*4 );
        }
        return a;
    }
}
