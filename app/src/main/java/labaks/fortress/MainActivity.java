package labaks.fortress;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends Activity {

    int[] colors = {Color.GREEN, Color.RED, Color.BLUE, Color.BLACK};
    int colRows = 3;
    int colCells = 3;
    Card[][] cards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TableLayout field = (TableLayout) findViewById(R.id.field);

        cards = new Card[colRows][colCells];
        fillCards();

        for (int i = 0; i < colRows; i++) {
            TableRow row = new TableRow(this);
            row.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            Log.d("------------------", "row created");
            for (int j = 0; j < colCells; j++) {

//                TextView textView = new TextView(this);
//                textView.setText("cell " + i + ":" + j);
//                textView.setBackgroundColor(getRandomColor());

//                RelativeLayout cell = new RelativeLayout(this);
//                cell.setLayoutParams(new ViewGroup.LayoutParams(100, 100));

                View view = new View(this);
                view.setLayoutParams(new ViewGroup.LayoutParams(100, 100));
                view.setBackgroundColor(getRandomColor());

//                row.addView(cell);
                row.addView(view);
//                row.addView(cards[i][j], j);

//                Log.d("==========", String.valueOf(cards[i][j].getHeight()));
            }
            field.addView(row, i);
        }

        final Card view = generateCard();

        RelativeLayout preview = (RelativeLayout) findViewById(R.id.preview);
        preview.addView(view);

        Button rotateLeft = (Button) findViewById(R.id.rotateLeft);
        rotateLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotateLeftImpl(view);
            }
        });

        Button rotateRight = (Button) findViewById(R.id.rotateRight);
        rotateRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotateRightImpl(view);
            }
        });

    }

    public int getRandomColor() {
        return colors[(int) (Math.random() * 3)];
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

    public Card generateCard() {
        Card card = new Card(this, getRandomColor(), getRandomColor(), getRandomColor(), getRandomColor());
        return card;
    }

    public void fillCards() {
        for (int i = 0; i < colRows; i++) {
            for (int j = 0; j < colCells; j++) {
                cards[i][j] = generateCard();
//                Log.d("=======", String.valueOf(cards[i][j].bottom));
            }
        }
//        Log.d("--------------------", "fill Cards");
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
