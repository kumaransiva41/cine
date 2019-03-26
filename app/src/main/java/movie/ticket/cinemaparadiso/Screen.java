package movie.ticket.cinemaparadiso;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static movie.ticket.cinemaparadiso.Payment.offer;

public class Screen extends AppCompatActivity {
    private Spinner sp;
    private Spinner sp1;
    public static String per = "";
    public static String per1 = "";
    public static String s="";
    private SQLiteDatabase db = Splash.db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);
        sp= findViewById(R.id.spinner2);
        sp1=findViewById(R.id.spinner3);
        final List<String> list = new ArrayList<>();
        final List<String> list1 = Arrays.asList(new String[]{"03/27/2019","03/28/2019","03/29/2019","03/30/2019"});
        String m1=this.getIntent().getStringExtra("Gully");

        Cursor curs;
        if(m1.equals("1")) {

            curs = db.rawQuery("SELECT movieid FROM movie WHERE title like 'How To Train Your Dragon%';", null);
            while(curs.moveToNext())
            {
                s = curs.getString(0);

            }
            s = "mv01";
        }
        if(m1.equals("2")) {
            TextView s1 = findViewById(R.id.textView20);
            s1.setText("Now chief and ruler of Berk alongside Astrid, Hiccup has created a gloriously chaotic dragon utopia. Hiccup and Toothless must leave the only home they’ve known and journey to a hidden world thought only to exist in myth.");
            TextView s2 = findViewById(R.id.textView15);
            s2.setText("How to Train Your Dragon : The Hidden World");
            TextView s3 = findViewById(R.id.textView17);
            s3.setText("English");
            TextView s4 = findViewById(R.id.textView18);
            s4.setText("104 Minutes");
            TextView s5 = findViewById(R.id.textView19);
            s5.setText("3D");
            TextView s6 = findViewById(R.id.textView21);
            s6.setText("CAST: Jay Baruchel, America Ferrera");
            TextView s7 = findViewById(R.id.textView24);
            s7.setText("DIRECTORS: Dean DeBlois");
            String uri = "@drawable/wek";  // where myresource (without the extension) is the file

            int imageResource = getResources().getIdentifier(uri, null, getPackageName());

            ImageView i2= findViewById(R.id.imageView2);
            Drawable res = getResources().getDrawable(imageResource);
            i2.setImageDrawable(res);

            /*curs = db.rawQuery("SELECT movieid FROM movie WHERE title like 'Badla';", null);
            while(curs.moveToNext())
                s = curs.getString(0);
            curs = db.rawQuery("SELECT movieid FROM movie ;",null);//WHERE title like 'Thadam';", null);
            while(curs.moveToNext())
                s = curs.getString(0);
            Toast.makeText(this,s,Toast.LENGTH_SHORT).show();*/
            s = "mv03";
        }
        else if(m1.equals("3")){
            TextView s1 = findViewById(R.id.textView20);
            s1.setText("A young married entrepreneur finds herself in a locked hotel room next to the body of her dead lover. Hoping to find answers, she hires a prestigious lawyer to help her solve the mystery of what really happened.");
            TextView s2 = findViewById(R.id.textView15);
            s2.setText("BADLA");
            TextView s3 = findViewById(R.id.textView17);
            s3.setText("HINDI");
            TextView s4 = findViewById(R.id.textView18);
            s4.setText("121 MINUTES");
            TextView s5 = findViewById(R.id.textView16);
            s5.setText("U/A");
            TextView s6 = findViewById(R.id.textView21);
            s6.setText("CAST: Amitabh Bachchan, Taapsee Pannu");
            TextView s7 = findViewById(R.id.textView24);
            s7.setText("DIRECTOR: Sujoy Ghosh");
            String uri = "@drawable/wel";  // where myresource (without the extension) is the file

            int imageResource = getResources().getIdentifier(uri, null, getPackageName());

            ImageView i2= findViewById(R.id.imageView2);
            Drawable res = getResources().getDrawable(imageResource);
            i2.setImageDrawable(res);

            curs = db.rawQuery("SELECT movieid FROM movie WHERE title like 'Badla';", null);
            while(curs.moveToNext())
            {
                s = curs.getString(0);

            }
            s = "mv02";
        }
        else if(m1.equals("4")) {
            TextView s1 = findViewById(R.id.textView20);
            s1.setText("Kalank, a period film, set in pre-independent India is a story about an elite family and many of its hidden truths that begin to unfold as communal tensions rise and partition nears.");
            TextView s2 = findViewById(R.id.textView15);
            s2.setText("KALANK");
            TextView s3 = findViewById(R.id.textView17);
            s3.setText("2D");
            TextView s4 = findViewById(R.id.textView18);
            s4.setText("HINDI");
            TextView s5 = findViewById(R.id.textView16);
            s5.setAlpha(0.0f);
            TextView s8 = findViewById(R.id.textView19);
            s8.setAlpha(0.0f);
            TextView s6 = findViewById(R.id.textView21);
            s6.setText("CAST: Varun Dhawan, Alia Bhatt");
            TextView s7 = findViewById(R.id.textView24);
            s7.setText("DIRECTOR: Abhishek Verman");
            Button b =  findViewById(R.id.button10);
            b.setVisibility(View.INVISIBLE);
            Spinner b2=findViewById(R.id.spinner3);
            b2.setVisibility(View.INVISIBLE);
            Spinner b3=findViewById(R.id.spinner2);
            b3.setVisibility(View.INVISIBLE);
            TextView s9 = findViewById(R.id.textView44);
            s9.setAlpha(0.0f);
            TextView s0 = findViewById(R.id.textView45);
            s0.setAlpha(0.0f);
            String uri = "@drawable/weg";  // where myresource (without the extension) is the file

            int imageResource = getResources().getIdentifier(uri, null, getPackageName());

            ImageView i2 = findViewById(R.id.imageView2);
            Drawable res = getResources().getDrawable(imageResource);
            i2.setImageDrawable(res);

        }
        else if(m1.equals("5")) {
            TextView s1 = findViewById(R.id.textView20);
            s1.setText("Lucifer delves deep into that unexplored abyss of what appears to be normal to those eyes that refuse to see beyond the seen.");
            TextView s2 = findViewById(R.id.textView15);
            s2.setText("LUCIFER");
            TextView s3 = findViewById(R.id.textView17);
            s3.setText("2D");
            TextView s4 = findViewById(R.id.textView18);
            s4.setText("MALAYALAM");
            TextView s5 = findViewById(R.id.textView16);
            s5.setAlpha(0.0f);
            TextView s8 = findViewById(R.id.textView19);
            s8.setAlpha(0.0f);
            TextView s6 = findViewById(R.id.textView21);
            s6.setText("CAST: Mohanlal, Vivek Oberai");
            TextView s7 = findViewById(R.id.textView24);
            s7.setText("DIRECTOR: Prithviraj Sukumaran");
            Button b =  findViewById(R.id.button10);
            b.setVisibility(View.INVISIBLE);
            Spinner b2=findViewById(R.id.spinner3);
            b2.setVisibility(View.INVISIBLE);
            Spinner b3=findViewById(R.id.spinner2);
            b3.setVisibility(View.INVISIBLE);
            TextView s9 = findViewById(R.id.textView44);
            s9.setAlpha(0.0f);
            TextView s0 = findViewById(R.id.textView45);
            s0.setAlpha(0.0f);
            String uri = "@drawable/weh";  // where myresource (without the extension) is the file

            int imageResource = getResources().getIdentifier(uri, null, getPackageName());

            ImageView i2 = findViewById(R.id.imageView2);
            Drawable res = getResources().getDrawable(imageResource);
            i2.setImageDrawable(res);

        }
        else if(m1.equals("6")) {
            TextView s1 = findViewById(R.id.textView20);
            s1.setText("An unfaithful wife, an estranged father and an angry boy must all face their demons on one fateful day.");
            TextView s2 = findViewById(R.id.textView15);
            s2.setText("SUPER DELUXE");
            TextView s3 = findViewById(R.id.textView17);
            s3.setText("2D");
            TextView s4 = findViewById(R.id.textView18);
            s4.setText("TAMIL");
            TextView s5 = findViewById(R.id.textView16);
            s5.setAlpha(0.0f);
            TextView s8 = findViewById(R.id.textView19);
            s8.setAlpha(0.0f);
            TextView s6 = findViewById(R.id.textView21);
            s6.setText("CAST: Vijay Sethupathi, Samantha, Fahad");
            TextView s7 = findViewById(R.id.textView24);
            s7.setText("DIRECTOR: Thiagarajan Kumararaja");
            Button b =  findViewById(R.id.button10);
            b.setVisibility(View.INVISIBLE);
            Spinner b2=findViewById(R.id.spinner3);
            b2.setVisibility(View.INVISIBLE);
            Spinner b3=findViewById(R.id.spinner2);
            b3.setVisibility(View.INVISIBLE);
            TextView s9 = findViewById(R.id.textView44);
            s9.setAlpha(0.0f);
            TextView s0 = findViewById(R.id.textView45);
            s0.setAlpha(0.0f);
            String uri = "@drawable/wei";  // where myresource (without the extension) is the file

            int imageResource = getResources().getIdentifier(uri, null, getPackageName());

            ImageView i2 = findViewById(R.id.imageView2);
            Drawable res = getResources().getDrawable(imageResource);
            i2.setImageDrawable(res);

        }
        else if(m1.equals("7")) {
            TextView s1 = findViewById(R.id.textView20);
            s1.setText("The Avengers must figure out a way to bring back their vanquished allies for an epic showdown with Thanos, the evil demigod who decimated the planet and the universe.");
            TextView s2 = findViewById(R.id.textView15);
            s2.setText("AVENGERS ENDGAME");
            TextView s3 = findViewById(R.id.textView17);
            s3.setText("3D");
            TextView s4 = findViewById(R.id.textView18);
            s4.setText("ENGLISH");
            TextView s5 = findViewById(R.id.textView16);
            s5.setAlpha(0.0f);
            TextView s8 = findViewById(R.id.textView19);
            s8.setAlpha(0.0f);
            TextView s6 = findViewById(R.id.textView21);
            s6.setText("CAST: Scarlett Johansson, Robert Downey Jr, Chris Evans");
            TextView s7 = findViewById(R.id.textView24);
            s7.setText("DIRECTOR: Anthony Russo, Joe Russo");
            Button b =  findViewById(R.id.button10);
            b.setVisibility(View.INVISIBLE);
            Spinner b2=findViewById(R.id.spinner3);
            b2.setVisibility(View.INVISIBLE);
            Spinner b3=findViewById(R.id.spinner2);
            b3.setVisibility(View.INVISIBLE);
            TextView s9 = findViewById(R.id.textView44);
            s9.setAlpha(0.0f);
            TextView s0 = findViewById(R.id.textView45);
            s0.setAlpha(0.0f);
            String uri = "@drawable/wef";  // where myresource (without the extension) is the file

            int imageResource = getResources().getIdentifier(uri, null, getPackageName());

            ImageView i2 = findViewById(R.id.imageView2);
            Drawable res = getResources().getDrawable(imageResource);
            i2.setImageDrawable(res);

        }
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list1);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(dataAdapter1);
        final String s1=s;
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            List<String> list;
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Cursor c;
                list = new ArrayList<>();
                c = db.rawQuery("SELECT screenid,showtime FROM show WHERE date like '"+list1.get(i)+"' and movieid like '"+s1+"' ;", null);
                while (c.moveToNext()) {
                    list.add(c.getString(1)+" ("+c.getString(0)+")");
                }
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item, list);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                sp.setAdapter(dataAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

    }
    public void seat(View view){
        per = sp.getSelectedItem().toString();
        per1 = sp1.getSelectedItem().toString();
        Intent i = new Intent(Screen.this,Seat.class);
        startActivity(i);
       // finish();
    }
}
