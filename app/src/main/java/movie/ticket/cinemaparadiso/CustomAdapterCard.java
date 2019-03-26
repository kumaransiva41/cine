package movie.ticket.cinemaparadiso;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapterCard extends ArrayAdapter<String> {

    ArrayList<String> cards;
    CommunicationInterface callback;
    public static String cno = null;

    public CustomAdapterCard(Activity context,List<String> s){
        super(context,0,s);
        this.cards = (ArrayList<String>) s;
        callback = (CommunicationInterface) context;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.customcard, parent, false);
        TextView tv = convertView.findViewById(R.id.textView42);
        tv.setText(cards.get(position));
        if(!cards.get(0).equals("No cards registered.")) {
            tv.setTextColor(Color.BLACK);
            tv.setBackgroundColor(Color.YELLOW);
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    cno = cards.get(position);
                    callback.Action(2);
                }
            });
        }
        return convertView;
    }

}
