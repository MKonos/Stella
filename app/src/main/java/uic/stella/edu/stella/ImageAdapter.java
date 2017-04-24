package uic.stella.edu.stella;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by mihal on 4/23/2017.
 */


public class ImageAdapter extends BaseAdapter {
    private Context context;
    private final String[] mobileValues;

    public ImageAdapter(Context context, String[] mobileValues) {
        this.context = context;
        this.mobileValues = mobileValues;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(context);

            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.activity_moon_display, null);

            // set value into textview
            //TextView textView = (TextView) gridView
                    //.findViewById(R.id.listview_item_title);
            //textView.setText(mobileValues[position]);

            // set image based on selected text
            ImageView imageView = (ImageView) gridView
                    .findViewById(R.id.listview_image);



            String mobile = mobileValues[position];

            if (mobile.equals("Earth")) {
                imageView.setImageResource(R.drawable.earth);
            } else if (mobile.equals("Mars")) {
                imageView.setImageResource(R.drawable.mars);
            } else if (mobile.equals("Jupiter")) {
                imageView.setImageResource(R.drawable.jupiter);
            } else {
                imageView.setImageResource(R.drawable.mercury);
            }

        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }

    @Override
    public int getCount() {
        return mobileValues.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}