package labaks.fortress;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class Card extends View {

    int top, right, bottom, left;
    Paint mPaint;
    Path topTriangle, rightTriangle, bottomTriangle, leftTriangle;
    int side = 100;

    public Card(Context context, int top, int right, int bottom, int left) {
        super(context);
        this.setLayoutParams(new LayoutParams(side, side));
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.left = left;

        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {

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
        leftTriangle.lineTo(side/2, side/2);
        leftTriangle.lineTo(0, 0);
        leftTriangle.close();
        mPaint.setColor(left);
        canvas.drawPath(leftTriangle, mPaint);

    }
}
