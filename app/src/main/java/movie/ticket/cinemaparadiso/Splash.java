package movie.ticket.cinemaparadiso;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Splash extends Activity {

    public static SQLiteDatabase db;
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 100;   //3000

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        db=openOrCreateDatabase("DBMS", Context.MODE_PRIVATE,null);

        //Instead of calling this function,
        database();
        //Should download online database and copy it to db variable HERE.


        new Handler().postDelayed(new Runnable() {
            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */
            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(Splash.this, Login.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }


    private void database() {
        try {

            /*db.execSQL("drop table user");
            db.execSQL("drop table show");
            db.execSQL("drop table screen");
            db.execSQL("drop table movie");
            db.execSQL("drop table booking");
            db.execSQL("drop table food_orders");
            db.execSQL("drop table seats");

            db.execSQL("drop table crew");

            db.execSQL("drop table food");

            //Payment tables. DO NOT ALTER
            db.execSQL("drop table ewallet");
            db.execSQL("drop table card");
            db.execSQL("drop table seats");*/

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
        }
        try {
            db.execSQL("CREATE TABLE IF NOT EXISTS user(uid varchar2(6) unique primary key not null,name varchar2(20),password varchar2(20),phone number(10),gender varchar2(20),age number(2));");
            db.execSQL("CREATE TABLE IF NOT EXISTS food(itemid varchar2(20),itemname varchar2(40) primary key not null,price number(4),category varchar2(20),info varchar2(20),quantity number(1));");
            db.execSQL("CREATE TABLE IF NOT EXISTS screen(screenid varchar2(6) primary key not null, capacity number(10), sound varchar2(20));");
            db.execSQL("CREATE TABLE IF NOT EXISTS movie(movieid varchar2(6) primary key not null, title varchar2(30), genre varchar2(20),language varchar2(10),runtime number(10),censor varchar2(5));");
            db.execSQL("CREATE TABLE IF NOT EXISTS show(showid varchar2(6) primary key not null, screenid varchar2(6) ,movieid varchar2(6), showtime varchar2(20),date DATE,CONSTRAINT fk FOREIGN KEY (screenid) REFERENCES screen(screenid),CONSTRAINT fk FOREIGN KEY (movieid) REFERENCES movie(movieid));");
            db.execSQL("CREATE TABLE IF NOT EXISTS booking(bookingid number(6),uid varchar2(6) ,showid varchar2(6),nooftickets number(1), seats varchar2(22),CONSTRAINT fk FOREIGN KEY (uid) REFERENCES user(uid),CONSTRAINT fk FOREIGN KEY (showid) REFERENCES show(showid));");
            db.execSQL("CREATE TABLE IF NOT EXISTS ewallet(uid varchar2(6), balance number(10),CONSTRAINT fk FOREIGN KEY (uid) REFERENCES user(uid));");
            db.execSQL("CREATE TABLE IF NOT EXISTS seats(date DATE, time varchar2(10), screen number(1), seats varchar2(300));");
            db.execSQL("CREATE TABLE IF NOT EXISTS food_orders(itemname vachar2(40),qty varchar2(20),CONSTRAINT fk FOREIGN KEY(itemname) REFERENCES food(itemname)); ");
            db.execSQL("CREATE TABLE IF NOT EXISTS card(uid varchar2(6), cardno varchar2(20) primary key,name varchar2(20),expiry varchar2(5),cvv number(3),type number(1),CONSTRAINT fk FOREIGN KEY (uid) REFERENCES user(uid));");

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
        }
        try{
            db.execSQL("insert into user values('Kiruba','Sagar','qwerty','s@g.c','Other',52)");
            db.execSQL("insert into ewallet values('Kiruba',2570)");

            db.execSQL("insert into food values('1','Chicken Puff',40,'Snacks','NV',0)");
            db.execSQL("insert into food values('2','Choco Donuts',80,'Snacks','V',0)");
            db.execSQL("insert into food values('3','Chicken Sandwich',100,'Snacks','NV',0)");
            db.execSQL("insert into food values('4','Spicy Paneer Sandwich',90,'Snacks','V',0)");
            db.execSQL("insert into food values('5','Chilli Chicken Pizza',140,'Snacks','NV',0)");
            db.execSQL("insert into food values('6','Paneer Tikka Pizza',130,'Snacks','V',0)");

            db.execSQL("insert into food values('7','Smart Water',50,'Drinks','750ml',0)");
            db.execSQL("insert into food values('8','Cappucino Premium',100,'Drinks','500ml',0)");
            db.execSQL("insert into food values('9','Filter Coffee',80,'Drinks','500ml',0)");
            db.execSQL("insert into food values('10','Coke Regular',70,'Drinks','500ml',0)");
            db.execSQL("insert into food values('11','Red Bull',130,'Drinks','500ml',0)");
            db.execSQL("insert into food values('12','Mountain Dew',50,'Drinks','500ml',0)");

            db.execSQL("insert into food values('13','Couple Combo',150,'Best Sellers','Big Coke+Pop',0)");
            db.execSQL("insert into food values('14','Dosth Combo',160,'Best Sellers','2 Coke+Pop',0)");
            db.execSQL("insert into food values('15','Lone Warrior',120,'Best Sellers','Coke+Pop',0)");

            db.execSQL("insert into food values('16','Kamarkat',50,'Traditional','Veg',0)");
            db.execSQL("insert into food values('17','Neer Moru',40,'Traditional','500ml',0)");
            db.execSQL("insert into food values('18','Panangalkandu Paal',35,'Traditional','500ml',0)");
            db.execSQL("insert into food values('19','Raagi Paniyaram',50,'Traditional','Veg',0)");
            db.execSQL("insert into food values('20','Nannari Sarbath',35,'Traditional','500ml',0)");
            db.execSQL("insert into food values('21','Ulundhu Kanji',30,'Traditional','500ml',0)");







            db.execSQL("insert into screen values('SCREEN 1',200,'RDX')");
            db.execSQL("insert into screen values('SCREEN 2',250,'DOLBY')");
            db.execSQL("insert into screen values('SCREEN 3',200,'4K Atmos')");

            db.execSQL("insert into movie values('mv01','How To Train Your Dragon 3','Drama','English',104,'U')");
            db.execSQL("insert into movie values('mv02','Badla','Adult Comedy','Hindi',121,'U/A')");
            db.execSQL("insert into movie values('mv03','Thadam','Super Hero','Tamil',140,'U/A')");
            db.execSQL("insert into user values('w','Sagar','a','s@g.c','Other',52)");
            db.execSQL("insert into user values('e','Sagar','a','s@g.c','Other',52)");
            db.execSQL("insert into ewallet values('w',20000)");
            db.execSQL("insert into card values('w', '4323 5129 6837 9452','Sagar','07/22',375,0);");
            db.execSQL("insert into card values('e', '9452 4323 5129 6837','Sagar','07/22',735,1);");

            db.execSQL("insert into show values('sh1','SCREEN 1','mv01','10:30 AM','03/27/2019')");
            db.execSQL("insert into show values('sh2','SCREEN 3','mv02','10:30 AM','03/27/2019')");
            db.execSQL("insert into show values('sh3','SCREEN 2','mv03','10:30 AM','03/27/2019')");
            db.execSQL("insert into show values('sh4','SCREEN 2','mv01','2:30 PM','03/27/2019')");
            db.execSQL("insert into show values('sh5','SCREEN 1','mv02','2:30 PM','03/27/2019')");
            db.execSQL("insert into show values('sh6','SCREEN 3','mv03','2:30 PM','03/27/2019')");
            db.execSQL("insert into show values('sh7','SCREEN 3','mv01','6:30 PM','03/27/2019')");
            db.execSQL("insert into show values('sh8','SCREEN 2','mv02','6:30 PM','03/27/2019')");
            db.execSQL("insert into show values('sh9','SCREEN 1','mv03','6:30 PM','03/27/2019')");

            db.execSQL("insert into show values('sh10','SCREEN 1','mv01','10:30 AM','03/28/2019')");
            db.execSQL("insert into show values('sh11','SCREEN 3','mv02','10:30 AM','03/28/2019')");
            db.execSQL("insert into show values('sh12','SCREEN 2','mv03','10:30 AM','03/28/2019')");
            db.execSQL("insert into show values('sh13','SCREEN 2','mv01','2:30 PM','03/28/2019')");
            db.execSQL("insert into show values('sh14','SCREEN 1','mv02','2:30 PM','03/28/2019')");
            db.execSQL("insert into show values('sh15','SCREEN 3','mv03','2:30 PM','03/28/2019')");
            db.execSQL("insert into show values('sh16','SCREEN 3','mv01','6:30 PM','03/28/2019')");
            db.execSQL("insert into show values('sh17','SCREEN 2','mv02','6:30 PM','03/28/2019')");
            db.execSQL("insert into show values('sh18','SCREEN 1','mv03','6:30 PM','03/28/2019')");

            db.execSQL("insert into show values('sh19','SCREEN 1','mv01','10:30 AM','03/29/2019')");
            db.execSQL("insert into show values('sh20','SCREEN 3','mv02','10:30 AM','03/29/2019')");
            db.execSQL("insert into show values('sh21','SCREEN 2','mv03','10:30 AM','03/29/2019')");
            db.execSQL("insert into show values('sh22','SCREEN 2','mv01','2:30 PM','03/29/2019')");
            db.execSQL("insert into show values('sh23','SCREEN 1','mv02','2:30 PM','03/29/2019')");
            db.execSQL("insert into show values('sh24','SCREEN 3','mv03','2:30 PM','03/29/2019')");
            db.execSQL("insert into show values('sh25','SCREEN 3','mv01','6:30 PM','03/29/2019')");
            db.execSQL("insert into show values('sh26','SCREEN 2','mv02','6:30 PM','03/29/2019')");
            db.execSQL("insert into show values('sh27','SCREEN 1','mv03','6:30 PM','03/29/2019')");

            db.execSQL("insert into show values('sh28','SCREEN 1','mv01','10:30 AM','03/30/2019')");
            db.execSQL("insert into show values('sh29','SCREEN 3','mv02','10:30 AM','03/30/2019')");
            db.execSQL("insert into show values('sh30','SCREEN 2','mv03','10:30 AM','03/30/2019')");
            db.execSQL("insert into show values('sh31','SCREEN 2','mv01','2:30 PM','03/30/2019')");
            db.execSQL("insert into show values('sh32','SCREEN 1','mv02','2:30 PM','03/30/2019')");
            db.execSQL("insert into show values('sh33','SCREEN 3','mv03','2:30 PM','03/30/2019')");
            db.execSQL("insert into show values('sh34','SCREEN 3','mv01','6:30 PM','03/30/2019')");
            db.execSQL("insert into show values('sh35','SCREEN 2','mv02','6:30 PM','03/30/2019')");
            db.execSQL("insert into show values('sh36','SCREEN 1','mv03','6:30 PM','03/30/2019')");

        }catch (Exception e){
            //Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
        }
    }
}
