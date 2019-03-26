package movie.ticket.cinemaparadiso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

public class Movies extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
    }

    public void Screen(View v){
        Intent i = new Intent(Movies.this,Screen.class);
        i.putExtra("Gully","1");
        this.startActivity(i);
    }
    public void Screen2(View v){
        Intent i = new Intent(Movies.this,Screen.class);
        i.putExtra("Gully","2");
        this.startActivity(i);
    }public void Screen3(View v){
        Intent i = new Intent(Movies.this,Screen.class);
        i.putExtra("Gully","3");
        this.startActivity(i);
    }
    public void toLogin(View v){
        Intent i = new Intent(this,Login.class);
        startActivity(i);
    }

}
