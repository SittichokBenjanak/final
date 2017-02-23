package drucc.sittichok.heyheybread;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by mosza_000 on 3/1/2559.
 */
public class MenuAdapter extends BaseAdapter{
    //Explicit
    private Context objContext;
    private String[] iconStrings,breadStrings,priceStrings,amount2Strings;
    public MenuAdapter(Context objContext,
                       String[] priceStrings,
                       String[] amount2Strings,
                       String[] breadStrings,
                       String[] iconStrings) {
        this.objContext = objContext;
        this.priceStrings = priceStrings;
        this.amount2Strings = amount2Strings;
        this.breadStrings = breadStrings;
        this.iconStrings = iconStrings;
    }   // Constructor

    @Override
    public int getCount() {
        return iconStrings.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater objLayoutInflater = (LayoutInflater) objContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View objView1 = objLayoutInflater.inflate(R.layout.my_menu_listview, viewGroup, false);

        //For Image
        ImageView iconImageView = (ImageView) objView1.findViewById(R.id.imageView7);
        Picasso.with(objContext)
                .load("http://192.168.1.113/sittichok/news_image/" + iconStrings[i])
                .resize(120, 120)
                .into(iconImageView);

        //For TextView
        TextView breadTextView = (TextView) objView1.findViewById(R.id.textView12);
        breadTextView.setText(breadStrings[i]);

        TextView priceTextView = (TextView) objView1.findViewById(R.id.textView15);
        priceTextView.setText(priceStrings[i]+".00");

        TextView amount2TextView = (TextView) objView1.findViewById(R.id.textView70);
        amount2TextView.setText(amount2Strings[i]);

//        TextView stockTextView = (TextView) objView1.findViewById(R.id.textView16);
//        stockTextView.setText(stockStrings[i]);


        return objView1;
    }
}   //Main Class
