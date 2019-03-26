package movie.ticket.cinemaparadiso;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Ratings extends AppCompatActivity {
    private Spinner sp;
    private Spinner sp1;
    public static int movie;
    public static int movie1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratings);
        sp= findViewById(R.id.spinner5);
        sp1=findViewById(R.id.upco);
        List<String> list = new ArrayList<String>();
        List<String> list1 = new ArrayList<String>();
        list.add("How to train your Dragon");
        list.add("Badla");
        list.add("Thadam");
        list1.add("Avengers:Endgame");
        list1.add("Kalank");
        list1.add("Lucifer");
        list1.add("Super Deluxe");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(dataAdapter);
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list1);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(dataAdapter1);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                movie=i;
                Fragment fr1 = new rating();
                FragmentManager fm1 = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm1.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, fr1);
                fragmentTransaction.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView1, View view1, int i, long l) {
                movie1=i;
                Fragment fr = new interested();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.fragment3, fr);
                fragmentTransaction.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView1) {

            }
        });
    }

}
