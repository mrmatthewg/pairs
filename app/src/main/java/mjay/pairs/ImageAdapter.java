package mjay.pairs;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;

    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);

        return imageView;
    }


    // references to my images.
    public static Integer[] mThumbIds = {
            R.drawable.cardback, R.drawable.cardback,
            R.drawable.cardback, R.drawable.cardback,
            R.drawable.cardback, R.drawable.cardback,


    };


    public static Integer[] resetThumbIds = {
            R.drawable.cardback, R.drawable.cardback,
            R.drawable.cardback, R.drawable.cardback,
            R.drawable.cardback, R.drawable.cardback,


    };


    public static Integer[] resetThumbIds1 = {
            R.drawable.cardback, R.drawable.cardback,
            R.drawable.cardback, R.drawable.cardback,
            R.drawable.cardback, R.drawable.cardback,
            R.drawable.cardback, R.drawable.cardback,
            R.drawable.cardback, R.drawable.cardback,
            R.drawable.cardback, R.drawable.cardback,

    };


    public static Integer[] resetThumbIds2 = {
            R.drawable.cardback, R.drawable.cardback,
            R.drawable.cardback, R.drawable.cardback,
            R.drawable.cardback, R.drawable.cardback,
            R.drawable.cardback, R.drawable.cardback,
            R.drawable.cardback, R.drawable.cardback,
            R.drawable.cardback, R.drawable.cardback,
            R.drawable.cardback, R.drawable.cardback,
            R.drawable.cardback, R.drawable.cardback,
            R.drawable.cardback, R.drawable.cardback

    };


}





