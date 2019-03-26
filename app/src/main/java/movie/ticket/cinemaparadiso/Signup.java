package movie.ticket.cinemaparadiso;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.SQLClientInfoException;
import java.util.ArrayList;
import java.util.List;

import static movie.ticket.cinemaparadiso.Splash.db;

public class Signup extends AppCompatActivity {

    private Spinner sp;
    String values[] = new String[6];
    int no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        sp= findViewById(R.id.spinner);
        List<String> list = new ArrayList<String>();
        list.add("Female");
        list.add("Male");
        list.add("Other");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(dataAdapter);
    }

    public void Up(View view) {
        int f=0;

        EditText et = findViewById(R.id.editText2);
        values[1] = et.getText().toString();
        et = findViewById(R.id.editText4);
        values[0] = et.getText().toString();
        et = findViewById(R.id.editText5);
        values[2] = et.getText().toString();
        et = findViewById(R.id.editText6);
        Editable et6 = et.getText();
        if(et6.toString().length()>0) {
            no = Integer.parseInt(et.getText().toString());
        }
        else
            f++;
        values[4] = String.valueOf(sp.getSelectedItem());
        et = findViewById(R.id.editText7);
        values[3] = et.getText().toString();
        for(int i=0; i<5; i++){
            if(values[i].equals(""))
                f++;
        }
        if(f==0) {
            try{
                db.execSQL("insert into user values('"+values[0]+"','"+values[1]+"','"+values[2]+"',"+Long.parseLong(values[3])+",'"+values[4]+"',"+no+");");
                db.execSQL("insert into ewallet values('"+values[0]+"',300)");
                finish();
            }catch (Exception e){
                if(e.toString().contains("UNIQUE"))
                    Toast.makeText(this, "Username already exists.", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
                f++;
            }
        }
        else{
            Toast.makeText(this, "Enter valid details.", Toast.LENGTH_LONG).show();
        }
    }
}
