package movie.ticket.cinemaparadiso;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class TestACtivity extends AppCompatActivity {
    private SQLiteDatabase db = Splash.db;
    public int[] fd4;
    public int[] dr4;
    public int[] bs4;
    public int[] tr4;
   public String[] fd;
    public String[] dr;
    public String[] bs;
    public String[] tr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_activity);
        ListView lv=findViewById(R.id.lv);
        ListView lv1=findViewById(R.id.lv1);
        ListView lv2=findViewById(R.id.lv2);
        ListView lv3=findViewById(R.id.lv3);
        fd =new String[] {
                "Chicken puff",
                "Choco Donuts",
                "Chicken Sandwich",
                "Paneer Sandwich",
                "Chilli Chicken Pizza",
                "Paneer Tikka Pizza"
        };
        String fd1[]={
                "40","80","100","90","140","130"
        };
        String fd2[]={
                "NV","V","NV","V","NV","V"
        };
        int fd3[]={
                0x7f08009a,0x7f080069,0x7f080060,0x7f080093,0x7f08005f,0x7f080092
        };
        fd4=new int[]{0,0,0,0,0,0};

        CustomAdapter customAdapter=new CustomAdapter(this,fd,fd1,fd2,fd3,fd4);
        lv.setScrollingCacheEnabled(false);
        lv.setAdapter(customAdapter);
        dr= new String[]{"Smart Water",
                "Cappucino ",
                "Filter Coffee",
                "Coke Regular",
                "Red Bull",
                "Mountain Dew"};
        String dr1[]={"50","100","80","70","140","50"};
        String dr2[]={"750 ml","500 ml","500 ml","500 ml","350 ml","500 ml"};
        int dr3[]={0x7f0800a6,0x7f0800a7,0x7f0800a8,0x7f0800a9,0x7f0800aa,0x7f0800ab};
        dr4=new int[]{0,0,0,0,0,0};
        CustomAdapter customAdapter1=new CustomAdapter(this,dr,dr1,dr2,dr3,dr4);
        lv1.setScrollingCacheEnabled(false);
        lv1.setAdapter(customAdapter1);
        bs=new String[]{"Couple Combo",
                "Dosth Combo",
                "Lone Warrior",
                };
        String bs1[]={"150","160","120"};
        String bs2[]={"Big Coke+Pop","2 Coke+Big Pop","Coke+Pop"};
        int bs3[]={0x7f0800ac,0x7f0800ad,0x7f0800ae};
        bs4=new int[]{0,0,0};
        CustomAdapter customAdapter2=new CustomAdapter(this,bs,bs1,bs2,bs3,bs4);
        lv2.setScrollingCacheEnabled(false);
        lv2.setAdapter(customAdapter2);
        tr=new String[]{"Kamarkat",
                "Neer Moru",
                "Panangalkandu Paal",
                "Raagi Paniyaram",
                "Nannari Sarbath",
                "Ulundhu Kanji"};
        String tr1[]={"50","40","35","50","35","30"};
        String tr2[]={"Veg","500 ml","500 ml","Veg","500 ml","500 ml"};
        int tr3[]={0x7f0800af,0x7f0800b0,0x7f0800b1,0x7f0800b2,0x7f0800b3,0x7f0800b4};
        tr4=new int[]{0,0,0,0,0,0};
        CustomAdapter customAdapter3=new CustomAdapter(this,tr,tr1,tr2,tr3,tr4);
        lv3.setScrollingCacheEnabled(false);
        lv3.setAdapter(customAdapter3);
    }
    public void toSign(View view) {
        for(int j=0;j<6;j++)
        {
            if(fd4[j]!=0)
            {
                db.execSQL("insert into food_orders values('"+fd[j]+"','"+fd4[j]+"');");
            }

            if(dr4[j]!=0) {
                db.execSQL("insert into food_orders values('"+dr[j]+"','"+dr4[j]+"');");
            }



            if(tr4[j]!=0)
            {
                db.execSQL("insert into food_orders values('"+tr[j]+"','"+tr4[j]+"');");
            }


        }

        for(int j=0;j<3;j++)
        {
            if(bs4[j]!=0)
            {
                db.execSQL("insert into food_orders values('"+bs[j]+"','"+bs4[j]+"');");
            }
        }




        Intent i = new Intent(TestACtivity.this,Payment.class);

        this.startActivity(i);
    }
}
