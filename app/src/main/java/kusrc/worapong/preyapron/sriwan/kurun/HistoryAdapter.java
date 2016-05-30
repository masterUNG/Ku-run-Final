package kusrc.worapong.preyapron.sriwan.kurun;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by masterUNG on 5/30/16 AD.
 */
public class HistoryAdapter extends BaseAdapter{

    private Context context;
    private int[] ints;
    private String[] dateStrings, nameStrings;

    public HistoryAdapter(Context context, int[] ints, String[] dateStrings, String[] nameStrings) {
        this.context = context;
        this.ints = ints;
        this.dateStrings = dateStrings;
        this.nameStrings = nameStrings;
    }

    @Override
    public int getCount() {
        return ints.length;
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
        View view1 = layoutInflater.inflate(R.layout.history_listview, viewGroup, false);

        ImageView imageView = (ImageView) view1.findViewById(R.id.imageView9);
        imageView.setImageResource(ints[i]);

        TextView dateTextView = (TextView) view1.findViewById(R.id.textView15);
        dateTextView.setText(dateStrings[i]);

        TextView nameTextView = (TextView) view1.findViewById(R.id.textView16);
        nameTextView.setText(nameStrings[i]);

        return view1;
    }
}   // Main Class
