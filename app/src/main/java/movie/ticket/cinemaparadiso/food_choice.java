package movie.ticket.cinemaparadiso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class food_choice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_choice);
    }
    public void food_cate(View view){
        Intent i = new Intent(food_choice.this,TestACtivity.class);
        startActivity(i);
        // finish();
    }
    public void food_cate1(View view){
        Intent i = new Intent(food_choice.this,Payment.class);
        startActivity(i);
        // finish();
    }
}
