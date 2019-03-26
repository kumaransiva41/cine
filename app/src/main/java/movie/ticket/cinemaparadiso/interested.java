package movie.ticket.cinemaparadiso;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class interested extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myInflatedView = inflater.inflate(R.layout.fragment_interested, container,false);
        ImageView i1;
        i1=myInflatedView.findViewById(R.id.imageView7);
        if(Ratings.movie1==0) {i1.setImageResource(R.drawable.wef);}
        else if(Ratings.movie1==1) {i1.setImageResource(R.drawable.weg);}
        else if(Ratings.movie1==2) {i1.setImageResource(R.drawable.weh);}
        else {i1.setImageResource(R.drawable.wei);}


        return myInflatedView;
    }

}
