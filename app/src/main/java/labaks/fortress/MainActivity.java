package labaks.fortress;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

    int[] colors = {Color.GREEN, Color.RED, Color.BLUE, Color.BLACK};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Card view = new Card(this, getRandomColor(), getRandomColor(), getRandomColor(), getRandomColor());

        RelativeLayout preview = (RelativeLayout) findViewById(R.id.preview);
        preview.addView(view);

        Button rotateLeft = (Button)findViewById(R.id.rotateLeft);
        rotateLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotateLeftImpl(view);
            }
        });

        Button rotateRight = (Button)findViewById(R.id.rotateRight);
        rotateRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotateRightImpl(view);
            }
        });

    }

    public int getRandomColor() {
        return colors[(int)(Math.random()*3)];
    }

    public void rotateLeftImpl(Card card) {
        int temp = card.top;
        card.top = card.right;
        card.right = card.bottom;
        card.bottom = card.left;
        card.left = temp;
        card.invalidate();
    }

    public void rotateRightImpl(Card card) {
        int temp = card.top;
        card.top = card.left;
        card.left = card.bottom;
        card.bottom = card.right;
        card.right = temp;
        card.invalidate();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
