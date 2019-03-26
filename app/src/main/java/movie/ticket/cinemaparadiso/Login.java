package movie.ticket.cinemaparadiso;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private SQLiteDatabase db = Splash.db;
    EditText u,p;
    String s = "";
    static public String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Intent intent=new Intent(this,TestACtivity.class);
        //startActivity(intent);
    }

    public void toMovies(View view) {
        try {
            u = findViewById(R.id.editText);
            p = findViewById(R.id.editText3);

            Cursor c = db.rawQuery("SELECT password FROM user WHERE uid like '" + u.getText() + "';", null);
            while (c.moveToNext()) {
                s = c.getString(0);
            }
        }catch (Exception e){
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
        name = u.getText().toString();
        if(s.equals(p.getText().toString()) && !s.equals("")) {
            Intent i = new Intent(Login.this,Basic.class);
            this.startActivity(i);
        }
        else{
            Toast.makeText(this, "Username or Password incorrect", Toast.LENGTH_SHORT).show();
        }
    }
    public void toSign(View view) {
        Intent i = new Intent(Login.this,Signup.class);
        this.startActivity(i);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK ) {
            Intent homeIntent = new Intent(Intent.ACTION_MAIN);
            homeIntent.addCategory( Intent.CATEGORY_HOME );
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(homeIntent);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
