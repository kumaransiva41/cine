package movie.ticket.cinemaparadiso;

import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import static movie.ticket.cinemaparadiso.Screen.per1;
import static movie.ticket.cinemaparadiso.Seat.ins;
import static movie.ticket.cinemaparadiso.Seat.seat;
import static movie.ticket.cinemaparadiso.Screen.per;
import static movie.ticket.cinemaparadiso.Seat.seats;
import static movie.ticket.cinemaparadiso.Splash.db;

public class Transaction extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 1000;
    public static int summa =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        final Button bt8 = findViewById(R.id.button8);
        bt8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                trans();
            }
        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                bt8.performClick();
            }
        }, SPLASH_TIME_OUT);
    }

    private class AsynTask extends AsyncTask<Object, Integer, Integer>{
        @Override
        protected Integer doInBackground(Object... integers) {
            /*for(int i=0; i<seat.size(); i++){
                db.execSQL("insert into seats values("+seat.get(i)+");");

            }*/
            String time="";
            if(per.contains("10:30 AM"))
            {
                time="10:30 AM";
            }
            else if(per.contains("2:30 PM"))
            {
                time="2:30 PM";
            }
            else if(per.contains("6:30 PM"))
            {
                time="6:30 PM";
            }

            String screen="";

            if(per.contains("SCREEN 1") ) {
                screen="SCREEN 1";
                if(ins)
                    db.execSQL("insert into seats values('"+per+"','"+per1+"',1,'"+seats+"');");
                else
                db.execSQL("UPDATE seats SET seats = '"+seats+"' WHERE date like '" + per + "' and time like '" + per1 + "' and screen=1 ;");
            }
            if(per.contains("SCREEN 2") ) {
                screen="SCREEN 2";
                if(ins)
                    db.execSQL("insert into seats values('"+per+"','"+per1+"',2,'"+seats+"');");
                else
                db.execSQL("UPDATE seats SET seats = '"+seats+"' WHERE date like '" + per + "' and time like '" + per1 + "' and screen=2 ;");
            }
            if(per.contains("SCREEN 3") ) {
                screen="SCREEN 3";
                if(ins)
                    db.execSQL("insert into seats values('"+per+"','"+per1+"',3,'"+seats+"');");
                else
                db.execSQL("UPDATE seats SET seats = '"+seats+"' WHERE date like '" + per + "' and time like '" + per1 + "' and screen=3 ;");
            }

            Cursor c = db.rawQuery("SELECT showid FROM show WHERE screenid like '"+screen+"' AND showtime like '"+time+"' ;", null);
            String show="";
            while(c.moveToNext())
            {show=c.getString(0);}
            String sea = "";
            for(int i=0; i<seat.size(); i++){
                sea += seat.get(i)+" ";
            }

           Cursor d=db.rawQuery("SELECT count(*)FROM booking  ;", null);
            while(d.moveToNext())
            {
               summa=d.getInt(0)+1278;
            }
            db.execSQL("insert into booking values("+summa+",'"+Login.name+"','"+show+"','"+per.length()+"' , '"+sea+"');");

            //Cursor d= db.rawQuery("SELECT * FROM booking", null );

            //book seats
            //upload current db to internet
            return 512;
        }
    }

    private void trans() {
        try {
            AsyncTask at = new AsynTask();
            at.execute(1,2,3);
            try {
                int a = (int) at.get();
            } catch (Exception e){
            }

        } catch(Exception e){
            Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_SHORT).show();
        }
        Intent i = new Intent(this,TicketBooked.class);
        startActivity(i);
        finish();
    }
}
