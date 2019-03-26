package movie.ticket.cinemaparadiso;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import java.util.Random;

import static movie.ticket.cinemaparadiso.Screen.s;
import static movie.ticket.cinemaparadiso.Seat.seat;
import static movie.ticket.cinemaparadiso.Transaction.summa;

public class TicketBooked extends AppCompatActivity {

    private int bal = EWallet.rem;
    private SQLiteDatabase db = Splash.db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_booked);
        TextView tv[] = new TextView[7];
        tv[0] = findViewById(R.id.textView7);
        tv[1] = findViewById(R.id.textView8);
        tv[2] = findViewById(R.id.textView9);
        tv[3] = findViewById(R.id.textView10);
        tv[4] = findViewById(R.id.textView11);
        tv[5] = findViewById(R.id.textView12);
        tv[6] = findViewById(R.id.textView23);
        Random r = new Random();
        String id = "",st="";
        for(int i=0; i<4; i++)
            id+=(1+r.nextInt(9));
        for(int i=0; i<seat.size(); i++){
            st+=seat.get(i)+" ";
        }
        String sid="";
        Cursor c;
        c=db.rawQuery("SELECT * FROM booking WHERE bookingid="+summa+";", null);
        while(c.moveToNext()){
            sid = c.getString(2);
        }
        String date="",time="",screen="";
        Cursor pk=db.rawQuery("SELECT showtime,date,screenid FROM show WHERE showid like '"+sid+"';", null);
        while(pk.moveToNext()){
            time=pk.getString(0);
            date=pk.getString(1);
            screen=pk.getString(2);
        }

        Cursor ash=db.rawQuery("SELECT title FROM movie WHERE movieid like '"+s+"';", null);
        String mvi="";
        while(ash.moveToNext()){
            mvi=ash.getString(0);
        }

        tv[0].setText("Booking ID : "+summa);
        tv[1].setText("Title : "+mvi);
        tv[2].setText("Date : "+date);
        tv[3].setText("Time : "+time);
        tv[4].setText("Screen : "+screen);
        tv[5].setText("Seats : "+st);
        tv[6].setText("Balance in EWallet : \nRs."+bal);
    }

    public void toMovies(View v){
        Intent i = new Intent(this,Basic.class);
        startActivity(i);
    }
    public void ofood(View v){
        Intent i = new Intent(this,Ordered_food.class);
        startActivity(i);
    }
}
