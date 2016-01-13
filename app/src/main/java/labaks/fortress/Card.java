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
    Path mPath;
    int side = 100;

    public Card(Context context, int top, int right, int bottom, int left) {
        super(context);
        this.setLayoutParams(new LayoutParams(side, side));
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.left = left;

        mPaint = new Paint();
        mPath = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        mPaint.setStrokeWidth(1);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        // top
        mPath.moveTo(0, 0);
        mPath.lineTo(side / 2, side / 2);
        mPath.lineTo(side, 0);
        mPath.close();
        mPaint.setColor(top);
        canvas.drawPath(mPath, mPaint);
        // right
        mPath.moveTo(side, 0);
        mPath.lineTo(side / 2, side / 2);
        mPath.lineTo(side, side);
        mPath.close();
        mPaint.setColor(right);
        canvas.drawPath(mPath, mPaint);
        // bottom
        mPath.moveTo(side, side);
        mPath.lineTo(side / 2, side / 2);
        mPath.lineTo(0, side);
        mPath.close();
        mPaint.setColor(bottom);
        canvas.drawPath(mPath, mPaint);

    }
}
