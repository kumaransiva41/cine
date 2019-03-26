package movie.ticket.cinemaparadiso;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CustomHist extends ArrayAdapter<List<String>> {

    private Activity cont;
    private List<String>[] tic;

    public CustomHist(Activity context, int resource, @NonNull List<String>[] objects) {
        super(context, resource, objects);
        cont = context;
        tic = objects;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = cont.getLayoutInflater();
        View view = inflater.inflate(R.layout.customhist, parent, false);
        TextView t0 = view.findViewById(R.id.textView53);
        TextView t1 = view.findViewById(R.id.textView54);
        TextView t2 = view.findViewById(R.id.textView55);
        TextView t3 = view.findViewById(R.id.textView56);
        TextView t4 = view.findViewById(R.id.textView57);
        TextView t5 = view.findViewById(R.id.textView58);
        /*TextView t6 = view.findViewById(R.id.textView59);
        TextView t7 = view.findViewById(R.id.textView60);
        TextView t8 = view.findViewById(R.id.textView61);
        TextView t9 = view.findViewById(R.id.textView62);*/
        int i = 0;
        //024315
        String a0 = t0.getText().toString(),
                a1 = t1.getText().toString(),
                a2 = t2.getText().toString(),
                a3 = t3.getText().toString(),
                a4 = t4.getText().toString(),
                a5 = t5.getText().toString();
        Log.d("TAGF",""+tic[position].size());
        t0.setText(a0+tic[position].get(i));
        t1.setText(a1+tic[position].get(i + 2));
        t2.setText(a2+tic[position].get(i + 4));
        t3.setText(a3+tic[position].get(i + 3));
        t4.setText(a4+tic[position].get(i + 1));
        t5.setText(a5+tic[position].get(i + 5));

        return view;
    }

}
