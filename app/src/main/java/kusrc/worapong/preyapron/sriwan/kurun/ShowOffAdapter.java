package kusrc.worapong.preyapron.sriwan.kurun;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by masterUNG on 5/31/16 AD.
 */
public class ShowOffAdapter extends BaseAdapter{

    private Context context;
    private int[] avataInts, goldInts;
    private String[] nameString;

    public ShowOffAdapter(Context context,
                          int[] avataInts,
                          int[] goldInts,
                          String[] nameString) {
        this.context = context;
        this.avataInts = avataInts;
        this.goldInts = goldInts;
        this.nameString = nameString;
    }

    @Override
    public int getCount() {
        return avataInts.length;
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

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.showoff_listvew, viewGroup, false);

        ImageView avataImageView = (ImageView) view1.findViewById(R.id.imageView10);
        avataImageView.setImageResource(avataInts[i]);

        TextView nameTextView = (TextView) view1.findViewById(R.id.textView17);
        nameTextView.setText(nameString[i]);

        ImageView goldImageView = (ImageView) view1.findViewById(R.id.imageView11);
        goldImageView.setImageResource(goldInts[i]);

        return view1;
    }
}   // Main Class
