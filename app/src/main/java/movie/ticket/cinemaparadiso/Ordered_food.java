package movie.ticket.cinemaparadiso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Ordered_food extends AppCompatActivity {
    TextView t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordered_food);
        t2=findViewById(R.id.textView52);
    }
}
