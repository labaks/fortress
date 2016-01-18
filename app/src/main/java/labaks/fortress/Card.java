package labaks.fortress;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class Card extends View {

    int top, right, bottom, left;
    Paint mPaint;
    Path topTriangle, rightTriangle, bottomTriangle, leftTriangle;
    int side = 100;
    BitmapDrawable drawable;
    Bitmap bitmap;

    private static int[] COLORS = {Color.GREEN, Color.RED, Color.BLUE, Color.BLACK};

    public Card(Context context, int top, int right, int bottom, int left) {
        super(context);
        this.setLayoutParams(new LayoutParams(side, side));
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.left = left;

        mPaint = new Paint();
        bitmap = Bitmap.createBitmap(side, side, Bitmap.Config.ARGB_8888);

        GradientDrawable gd = new GradientDrawable();
        gd.setCornerRadius(15);
        gd.setStroke(2, 0xFF000000);
        drawable = new BitmapDrawable(getResources(), bitmap);

        this.setBackgroundDrawable(drawable);
    }

    public Card(Context context) {
        this(context, getRandomColor(), getRandomColor(), getRandomColor(), getRandomColor());
    }

    private static int getRandomColor() {
        return COLORS[(int) (Math.random() * 4)];
    }

    //    @Override
    protected void onDraw(Canvas canvas) {
        canvas = new Canvas(bitmap);

        mPaint.setStrokeWidth(1);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        // top
        topTriangle = new Path();
        topTriangle.moveTo(0, 0);
        topTriangle.lineTo(side / 2, side / 2);
        topTriangle.lineTo(side, 0);
        topTriangle.close();
        mPaint.setColor(top);
        canvas.drawPath(topTriangle, mPaint);
        // right
        rightTriangle = new Path();
        rightTriangle.moveTo(side, 0);
        rightTriangle.lineTo(side / 2, side / 2);
        rightTriangle.lineTo(side, side);
        rightTriangle.close();
        mPaint.setColor(right);
        canvas.drawPath(rightTriangle, mPaint);
        // bottom
        bottomTriangle = new Path();
        bottomTriangle.moveTo(side, side);
        bottomTriangle.lineTo(side / 2, side / 2);
        bottomTriangle.lineTo(0, side);
        bottomTriangle.close();
        mPaint.setColor(bottom);
        canvas.drawPath(bottomTriangle, mPaint);
        // left
        leftTriangle = new Path();
        leftTriangle.moveTo(0, side);
        leftTriangle.lineTo(side / 2, side / 2);
        leftTriangle.lineTo(0, 0);
        leftTriangle.close();
        mPaint.setColor(left);
        canvas.drawPath(leftTriangle, mPaint);
    }
}
