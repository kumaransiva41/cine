package movie.ticket.cinemaparadiso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class upcoming extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming);
    }
    public void u1(View view){
        Intent i = new Intent(upcoming.this,Screen.class);
        i.putExtra("Gully","4");
        startActivity(i);
        // finish();
    }
    public void u2(View view){
        Intent i = new Intent(upcoming.this,Screen.class);
        i.putExtra("Gully","5");
        startActivity(i);
        // finish();
    }
    public void u3(View view){
        Intent i = new Intent(upcoming.this,Screen.class);
        i.putExtra("Gully","6");
        startActivity(i);
        // finish();
    }
    public void u4(View view){
        Intent i = new Intent(upcoming.this,Screen.class);
        i.putExtra("Gully","7");
        startActivity(i);
        // finish();
    }

}
