package movie.ticket.cinemaparadiso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class food_category extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_category);
    }
    public void snack(View view){
        Intent i = new Intent(food_category.this,TestACtivity.class);
        startActivity(i);
        // finish();
    }
}
