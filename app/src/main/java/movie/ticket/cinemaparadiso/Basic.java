package movie.ticket.cinemaparadiso;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

import static movie.ticket.cinemaparadiso.Payment.discount;
import static movie.ticket.cinemaparadiso.Payment.offer;

public class Basic extends AppCompatActivity {

    public static String offe = "CIPA",recharge="F";
    Random r;
    String m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);
        Offer();
        offer = true;
    }
    private NotificationManager notifManager;
    public void Offer(){
        r = new Random();
        double rn = r.nextDouble();
        offe = "CIPA"+R()+R()+R()+R();
        discount = (r.nextInt(2)+1.0)/10;
        if(r.nextDouble()>0.5)
            discount+=0.05;
        m = "Get "+(int)(100*discount)+"% discount with offer code "+offe;
        if(rn>0.5)
            createNotification("Today's Offer",getApplicationContext());
    }
    private int R(){
        return r.nextInt(9)+1;
    }
    public void createNotification(String aMessage, Context context) {
        final int NOTIFY_ID = 0; // ID of notification
        String id = context.getString(R.string.default_notification_channel_id); // default_channel_id
        String title = context.getString(R.string.default_notification_channel_title); // Default Channel
        NotificationCompat.Builder builder;
        if (notifManager == null) {
            notifManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        }

        int s = R.drawable.logo;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = null;//notifManager.getNotificationChannel(id);
            if (mChannel == null) {
                mChannel = new NotificationChannel(id, title, importance);
                mChannel.enableVibration(false);
                //mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
                notifManager.createNotificationChannel(mChannel);
            }
            builder = new NotificationCompat.Builder(context, id);
            builder.setContentTitle(aMessage)                            // required
                    .setSmallIcon(s)   // required
                    .setContentText(m) // required
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setAutoCancel(true)
                    .setTicker(aMessage)
                    .setTimeoutAfter(1000)
                    //.setVibrate(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400})
            ;
        }
        else {
            builder = new NotificationCompat.Builder(context, id);
            builder.setContentTitle(aMessage)                            // required
                    .setSmallIcon(s)   // required
                    .setContentText(m) // required
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setAutoCancel(true)
                    .setLargeIcon(BitmapFactory.decodeResource(context.getResources(),R.drawable.logo))
                    .setTicker(aMessage)
                    .setTimeoutAfter(1000)
                    .setVibrate(new long[]{0})
                    .setPriority(Notification.PRIORITY_HIGH);
        }
        Notification notification = builder.build();
        notifManager.notify(NOTIFY_ID, notification);
    }
    public void move(View view){
        offer=true;
        Intent i = new Intent(Basic.this,Movies.class);
        startActivity(i);
        recharge="f";
        // finish();
    }
    public void rate(View view){
        Intent i = new Intent(Basic.this,Ratings.class);
        startActivity(i);
        // finish();
    }
    public void hist(View view){
        Intent i = new Intent(Basic.this,History.class);
        startActivity(i);
        // finish();
    }
    public void up(View view){
        Intent i = new Intent(Basic.this,upcoming.class);
        startActivity(i);
        // finish();
    }
    public void Recharge(View view){
        recharge="T";
        offer=false;
        Toast.makeText(this,"Paying through Debit Card.",Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this,Payment.class);
        startActivity(i);
        //recharge="f";
    }
}
