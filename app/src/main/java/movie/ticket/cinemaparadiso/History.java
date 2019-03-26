package movie.ticket.cinemaparadiso;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static movie.ticket.cinemaparadiso.Screen.s;
import static movie.ticket.cinemaparadiso.Splash.db;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ListView l = findViewById(R.id.List2);
        ArrayList<String> s = new ArrayList<>();
        Cursor c,d,ash;
        c = db.rawQuery("SELECT count(*) FROM booking WHERE uid like '"+Login.name+"' ORDER BY bookingid DESC;", null);
        int n = 0,i=0;
        while (c.moveToNext())
            n = c.getInt(0);
        ArrayList[] list1 = new ArrayList[n];
        c = db.rawQuery("SELECT * FROM booking WHERE uid like '"+Login.name+"' ORDER BY bookingid DESC;", null);
        String sid = "";
        while (c.moveToNext()){
            s = new ArrayList<>();
            s.add(""+c.getInt(0));  //booking
            sid = c.getString(2);
            d = db.rawQuery("SELECT * FROM show WHERE showid like '"+sid+"';", null);
            while (d.moveToNext()){
                s.add(d.getString(1));  //screenid
                ash=db.rawQuery("SELECT title FROM movie WHERE movieid like '"+d.getString(2)+"';", null);
                String mvi="";
                while(ash.moveToNext()){
                    mvi=ash.getString(0);
                }
                s.add(mvi);  //movieid
                s.add(d.getString(3));  //showtime
                s.add(d.getString(4));  //date
            }
            s.add(c.getString(4));      //seats
            if(s.size()>4)
                list1[i++] = s;
            else
                Toast.makeText(this,"Show Table "+sid,Toast.LENGTH_SHORT).show();
        }
        CustomHist adapter = new CustomHist(this,0,list1);
        l.setAdapter(adapter);
    }
}
