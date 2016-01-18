package labaks.fortress;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private Context c;
    public ArrayList<Card> cards;

    public CustomAdapter(Context context) {
        this.c = context;
        cards = new ArrayList<>();
    }

    @Override
    public int getCount() {
//        return layouts.size();
        return 60;
    }

    @Override
    public Object getItem(int position) {
        return cards.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LinearLayout layout = new LinearLayout(c);
        layout.setLayoutParams(new GridView.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.setOrientation(LinearLayout.HORIZONTAL);

        LinearLayout cell = new LinearLayout(c);
        cell.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        cell.setOrientation(LinearLayout.HORIZONTAL);
        cell.setBackgroundColor(Color.GREEN);
//        cell.setPadding(25, 25, 25, 25);
//        GradientDrawable gd = new GradientDrawable();
//        gd.setColor(0xFFFF0000); // Changes this drawbale to use a single color instead of a gradient
//        gd.setCornerRadius(15);
//        gd.setStroke(2, 0xFF000000);
//        cell.setBackgroundDrawable(gd);

//        GradientDrawable gd1 = new GradientDrawable();
//        gd1.setColor(0xFF00FF00); // Changes this drawbale to use a single color instead of a gradient
//        gd1.setCornerRadius(15);
//        gd1.setStroke(2, 0xFF000000);

        Card cellCard = new Card(c);
        cards.add(cellCard);
        cell.addView(cellCard);
//        layout.setBackgroundDrawable(gd1);
//        layout.setPadding(2,2,2,2);
        layout.addView(cell);

        return layout;
    }
}
