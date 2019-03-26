package movie.ticket.cinemaparadiso;



import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static movie.ticket.cinemaparadiso.Screen.per;
import static movie.ticket.cinemaparadiso.Screen.per1;
import static movie.ticket.cinemaparadiso.Splash.db;

public class Seat extends AppCompatActivity implements View.OnClickListener {
    ViewGroup layout;
    public static int noseats;
    final int maxSeats = 5;
    public static boolean ins;
    public static String seats = "_UUUUUUAAAAARRRR_/"
            + "_________________/"
            + "UU__AAAARRRRR__RR/"
            + "UU__UUUAAAAAA__AA/"
            + "AA__AAAAAAAAA__AA/"
            + "AA__AARUUUURR__AA/"
            + "UU__UUUA_RRRR__AA/"
            + "AA__AAAA_RRAA__UU/"
            + "AA__AARR_UU__RR__/"
            + "AA__UUAA_UURR__RR/"
            + "_________________/"
            + "UU_AAAAAAAUUUU_RR/"
            + "RR_AAAAAAAAAAA_AA/"
            + "AA_UUAAAAAUUUU_AA/"
            + "AA_AAAAAAUUUUU_AA/"
            + "_________________/";

    List<TextView> seatViewList = new ArrayList<>();
    int seatSize = 100;
    int seatGaping = 10;
    public static List<Integer> seat;
    private static List<Integer> seatb;
    int STATUS_AVAILABLE = 1;
    int STATUS_BOOKED = 2;
    int STATUS_RESERVED = 3;
    String selectedIds = "";
    String sql;

    /*
    private void seat1(){
        String a="",s;
        List<Integer> se = new ArrayList<>();
        Cursor c = db.rawQuery(sql, null);
        while (c.moveToNext()) {
            s = c.getString(0);
            se.add(Integer.parseInt(s));
        }
        Collections.sort(se);se.add(300);se.add(300);se.add(300);
        int i,j,k=1,ki=0;  //j is line number
        for(j=1; j<4; j++){
            for(i=0; i<22; i++){
                if(i>9 &&i<12) {
                    a += "_";
                    continue;
                }
                if(se.get(ki)==k) {
                    a+="R";
                    k++;
                    ki++;
                }
                else {
                    a += "A";k++;
                }
            }
            a+="/";
        }
        a+="______________________/";
        for(j=4; j<9; j++){
            for(i=0; i<22; i++){
                if(i==2||i==3||i==18||i==19){
                    a+="_";
                    continue;
                }
                if(se.get(ki)==k) {
                    a+="R";
                    k++;
                    ki++;
                }
                else {
                    a += "A";k++;
                }
            }
            a+="/";
        }
        a+="______________________/";
        for(j=9; j<13; j++){
            for(i=0; i<22; i++){
                if(i==0||i==21){
                    a+="_";continue;
                }
                if(se.get(ki)==k) {
                    a+="R";
                    k++;
                    ki++;
                }
                else {
                    a += "A";k++;
                }
            }
            a+="/";
        }
        seats=a;
    }
    private void seat2(){
        String a="",s;
        List<Integer> se = new ArrayList<>();
        Cursor c = db.rawQuery(sql, null);
        while (c.moveToNext()) {
            s = c.getString(0);
            se.add(Integer.parseInt(s));
        }
        Collections.sort(se);se.add(300);
        int i,j,k=1,ki=0;  //j is line number
        for(i=0; i<12; i++){
            if(se.get(ki)==k) {
                a+="R";
                k++;
                ki++;
            }
            else {
                a += "A";k++;
            }
        }
        a+="/____________";
        for(j=3; j<8; j++){
            a+="/";
            for(i=0; i<12; i++){
                if(i==3||i==8){
                    a+="_";
                    continue;
                }
                if(se.get(ki)==k) {
                    a+="R";
                    k++;
                    ki++;
                }
                else {
                    a += "A";k++;
                }
            }
        }
        a+="/____________/";
        for(j=8; j<11; j++){
            for(i=0; i<12; i++){
                if(i==3||i==8||i==2||i==9){
                    a+="_";
                    continue;
                }
                if(se.get(ki)==k) {
                    a+="R";
                    k++;
                    ki++;
                }
                else {
                    a += "A";k++;
                }
            }
            a+="/";
        }
        seats=a;
    }
    private void seat() {
        String S;
        List<Integer> se = new ArrayList<>();
        Cursor c = db.rawQuery(sql, null);
        while (c.moveToNext()) {
            S = c.getString(0);
            se.add(Integer.parseInt(S));
        }
        Collections.sort(se);se.add(300);
        String s = "_";
        int i,j,k=1,ki=0;  //j is line number
        for(i=0; i<15; i++){
            if(se.get(ki)==k) {
                s+="R";
                k++;
                ki++;
            }
            else {
                s += "A";k++;
            }
        }
        s+="_/";
        //Second line
        for(i=0; i<17; i++){
            s+="_";
        }
        s+="/";
        //Line 3 - 10
        for(j=3; j<=10; j++) {
            for (i = 0; i < 17; i++) {
                if (j>6 && i==8){
                    s += "_";
                    continue;
                }
                    if (i == 2 || i == 3 || i == 13 || i == 14) {
                        s += "_";
                        continue;
                    }
                if(se.get(ki)==k) {
                    s+="R";
                    k++;
                    ki++;
                }
                else {
                    s += "A";k++;
                }
            }
            s+="/";
        }
        //Eleventh line
        for(i=0; i<17; i++){
            s+="_";
            continue;
        }
        s+="/";
        //Line 12 - 15
        for(j=12; j<=15; j++){
            for(i=0; i<17; i++){
                if (i == 2  || i == 14) {
                    s += "_";
                    continue;
                }
                else{
                    if(se.get(ki)==k) {
                        s+="R";
                        k++;
                        ki++;
                    }
                    else {
                        s += "A";k++;
                    }
                }
            }
            s+="/";
        }
        seats = s;
    }
    */

    private void seatA(){
        int i,k=1;
        for(i=0; i<seats.length(); i++) {
            if (seats.charAt(i) == 'R') {
                seatb.add(k++);
            } else {
                if (seats.charAt(i) == 'A') {
                    k++;
                }
            }
        }
    }

    private void seat1B(){
        String a="",s;
        List<Integer> se = seatb;
        Collections.sort(se);se.add(300);
        int i,j,k=1,ki=0;  //j is line number
        for(j=1; j<4; j++){
            for(i=0; i<22; i++){
                if(i>9 &&i<12) {
                    a += "_";
                    continue;
                }
                if(se.get(ki)==k) {
                    a+="R";
                    k++;
                    ki++;
                }
                else {
                    a += "A";k++;
                }
            }
            a+="/";
        }
        a+="______________________/";
        for(j=4; j<9; j++){
            for(i=0; i<22; i++){
                if(i==2||i==3||i==18||i==19){
                    a+="_";
                    continue;
                }
                if(se.get(ki)==k) {
                    a+="R";
                    k++;
                    ki++;
                }
                else {
                    a += "A";k++;
                }
            }
            a+="/";
        }
        a+="______________________/";
        for(j=9; j<13; j++){
            for(i=0; i<22; i++){
                if(i==0||i==21){
                    a+="_";continue;
                }
                if(se.get(ki)==k) {
                    a+="R";
                    k++;
                    ki++;
                }
                else {
                    a += "A";k++;
                }
            }
            a+="/";
        }
        seats=a;
    }
    private void seat2B(){
        String a="",s;
        List<Integer> se = seatb;
        Collections.sort(se);se.add(300);
        int i,j,k=1,ki=0;  //j is line number
        for(i=0; i<12; i++){
            if(se.get(ki)==k) {
                a+="R";
                k++;
                ki++;
            }
            else {
                a += "A";k++;
            }
        }
        a+="/____________";
        for(j=3; j<8; j++){
            a+="/";
            for(i=0; i<12; i++){
                if(i==3||i==8){
                    a+="_";
                    continue;
                }
                if(se.get(ki)==k) {
                    a+="R";
                    k++;
                    ki++;
                }
                else {
                    a += "A";k++;
                }
            }
        }
        a+="/____________/";
        for(j=8; j<11; j++){
            for(i=0; i<12; i++){
                if(i==3||i==8||i==2||i==9){
                    a+="_";
                    continue;
                }
                if(se.get(ki)==k) {
                    a+="R";
                    k++;
                    ki++;
                }
                else {
                    a += "A";k++;
                }
            }
            a+="/";
        }
        seats=a;
    }
    private void seatB() {
        List<Integer> se = seatb;
        Collections.sort(se);se.add(300);
        String s = "_";
        int i,j,k=1,ki=0;  //j is line number
        for(i=0; i<15; i++){
            if(se.get(ki)==k) {
                s+="R";
                k++;
                ki++;
            }
            else {
                s += "A";k++;
            }
        }
        s+="_/";
        //Second line
        for(i=0; i<17; i++){
            s+="_";
        }
        s+="/";
        //Line 3 - 10
        for(j=3; j<=10; j++) {
            for (i = 0; i < 17; i++) {
                if (j>6 && i==8){
                    s += "_";
                    continue;
                }
                if (i == 2 || i == 3 || i == 13 || i == 14) {
                    s += "_";
                    continue;
                }
                if(se.get(ki)==k) {
                    s+="R";
                    k++;
                    ki++;
                }
                else {
                    s += "A";k++;
                }
            }
            s+="/";
        }
        //Eleventh line
        for(i=0; i<17; i++){
            s+="_";
            continue;
        }
        s+="/";
        //Line 12 - 15
        for(j=12; j<=15; j++){
            for(i=0; i<17; i++){
                if (i == 2  || i == 14) {
                    s += "_";
                    continue;
                }
                else{
                    if(se.get(ki)==k) {
                        s+="R";
                        k++;
                        ki++;
                    }
                    else {
                        s += "A";k++;
                    }
                }
            }
            s+="/";
        }
        seats = s;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat);
        noseats = 0;
        seat = new ArrayList<>();
        seatb = new ArrayList<>();
        layout = findViewById(R.id.layoutSeat);
        Cursor c;
        ins = false;
        seats="";
        if(per.contains("SCREEN 1") ) {
            sql = "SELECT seats FROM seats WHERE date like '"+per+"' and time like '"+per1+"' and screen=1 ;";
            c = db.rawQuery(sql,null);
            while(c.moveToNext()){
                seats = c.getString(0);
            }
            if(seats.equals("")){
                ins = true;
                seats = "AAAAAAAAAA__AAAAAAAAAA/AAAAAAAAAA__AAAAAAAAAA/AAAAAAAAAA__AAAAAAAAAA/______________________/AA__AAAAAAAAAAAAAA__AA/AA__AAAAAAAAAAAAAA__AA/AA__AAAAAAAAAAAAAA__AA/AA__AAAAAAAAAAAAAA__AA/AA__AAAAAAAAAAAAAA__AA/______________________/_AAAAAAAAAAAAAAAAAAAA_/_AAAAAAAAAAAAAAAAAAAA_/_AAAAAAAAAAAAAAAAAAAA_/_AAAAAAAAAAAAAAAAAAAA_/";
            }
        }
        if(per.contains("SCREEN 2") ) {
            sql = "SELECT seats FROM seats WHERE date like '"+per+"' and time like '"+per1+"' and screen=2 ;";
            c = db.rawQuery(sql,null);
            while(c.moveToNext()){
                seats = c.getString(0);
            }
            if(seats.equals("")) {
                ins = true;
                seats = "AAAAAAAAAAAA/____________/AAA_AAAA_AAA/AAA_AAAA_AAA/AAA_AAAA_AAA/AAA_AAAA_AAA/AAA_AAAA_AAA/____________/AA__AAAA__AA/AA__AAAA__AA/AA__AAAA__AA/";
            }
        }
        if(per.contains("SCREEN 3") ) {
            sql = "SELECT seats FROM seats WHERE date like '" + per + "' and time like '" + per1 + "' and screen=3 ;";
            c = db.rawQuery(sql,null);
            while(c.moveToNext()){
                seats = c.getString(0);
            }
            if(seats.equals("")) {
                ins = true;
                seats = "_AAAAAAAAAAAAAAA_/_________________/AA__AAAAAAAAA__AA/AA__AAAAAAAAA__AA/AA__AAAAAAAAA__AA/AA__AAAAAAAAA__AA/AA__AAAA_AAAA__AA/AA__AAAA_AAAA__AA/AA__AAAA_AAAA__AA/AA__AAAA_AAAA__AA/_________________/AA_AAAAAAAAAAA_AA/AA_AAAAAAAAAAA_AA/AA_AAAAAAAAAAA_AA/AA_AAAAAAAAAAA_AA/";
            }
        }
        seats = "/" + seats;
        seatA();
        LinearLayout layoutSeat = new LinearLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutSeat.setOrientation(LinearLayout.VERTICAL);
        layoutSeat.setLayoutParams(params);
        layoutSeat.setPadding(8 * seatGaping, 8 * seatGaping, 8 * seatGaping, 8 * seatGaping);
        layout.addView(layoutSeat);
        LinearLayout layout = null;

        int count = 0;

        for (int index = 0; index < seats.length(); index++) {
            if (seats.charAt(index) == '/') {
                layout = new LinearLayout(this);
                layout.setOrientation(LinearLayout.HORIZONTAL);
                layoutSeat.addView(layout);
            } else if (seats.charAt(index) == 'U') {
                count++;
                TextView view = new TextView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
                layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
                view.setLayoutParams(layoutParams);
                view.setPadding(0, 0, 0, 2 * seatGaping);
                view.setId(count);
                view.setGravity(Gravity.CENTER);
                view.setBackgroundResource(R.drawable.ic_seats_booked);
                view.setTextColor(Color.WHITE);
                view.setTag(STATUS_BOOKED);
                view.setText(count + "");
                view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 9);
                layout.addView(view);
                seatViewList.add(view);
                view.setOnClickListener(this);
            } else if (seats.charAt(index) == 'A') {
                count++;
                TextView view = new TextView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
                layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
                view.setLayoutParams(layoutParams);
                view.setPadding(0, 0, 0, 2 * seatGaping);
                view.setId(count);
                view.setGravity(Gravity.CENTER);
                view.setBackgroundResource(R.drawable.ic_seats_book);
                view.setText(count + "");
                view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 9);
                view.setTextColor(Color.BLACK);
                view.setTag(STATUS_AVAILABLE);
                layout.addView(view);
                seatViewList.add(view);
                view.setOnClickListener(this);
            } else if (seats.charAt(index) == 'R') {
                count++;
                TextView view = new TextView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
                layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
                view.setLayoutParams(layoutParams);
                view.setPadding(0, 0, 0, 2 * seatGaping);
                view.setId(count);
                view.setGravity(Gravity.CENTER);
                view.setBackgroundResource(R.drawable.ic_seats_booked);
                view.setText(count + "");
                view.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 9);
                view.setTextColor(Color.WHITE);
                view.setTag(STATUS_RESERVED);
                layout.addView(view);
                seatViewList.add(view);
                view.setOnClickListener(this);
            } else if (seats.charAt(index) == '_') {
                TextView view = new TextView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
                layoutParams.setMargins(seatGaping, seatGaping, seatGaping, seatGaping);
                view.setLayoutParams(layoutParams);
                view.setBackgroundColor(Color.TRANSPARENT);
                view.setText("");
                layout.addView(view);
            }
        }
    }

    @Override
    public void onClick(View view) {
        if ((int) view.getTag() == STATUS_AVAILABLE) {
                if (selectedIds.contains(view.getId() + ",")) {
                    selectedIds = selectedIds.replace(+view.getId() + ",", "");
                    view.setBackgroundResource(R.drawable.ic_seats_book);
                    noseats--;
                    seat.remove(seat.indexOf(view.getId()));
                } else {
                    if (noseats < maxSeats) {
                        selectedIds = selectedIds + view.getId() + ",";
                        view.setBackgroundResource(R.drawable.ic_seats_selected);
                        noseats++;
                        seat.add(view.getId());
                    } else
                        Toast.makeText(this, "You can book a maximum of "+maxSeats+" seats.", Toast.LENGTH_SHORT).show();
                }
        } else if ((int) view.getTag() == STATUS_BOOKED) {
            Toast.makeText(this, "Seat " + view.getId() + " is Booked", Toast.LENGTH_SHORT).show();
        } else if ((int) view.getTag() == STATUS_RESERVED) {
            Toast.makeText(this, "Seat " + view.getId() + " is Booked", Toast.LENGTH_SHORT).show();
        }
    }
    public void food(View view){
        seatb.addAll(seat);
        if(noseats==0){
            Toast.makeText(getApplicationContext(),"Select a seat first.",Toast.LENGTH_SHORT).show();
        }
        else {
            if(per.contains("SCREEN 1") ) {
                seat1B();
            }
            if(per.contains("SCREEN 2") ) {
                seat2B();
            }
            if(per.contains("SCREEN 3") ) {
                seatB();
            }
            Intent i = new Intent(getApplicationContext(), food_choice.class);
            startActivity(i);
            finish();
        }
    }
}
