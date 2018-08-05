package kim.gaeun.bookworm.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class ProgressRing extends View {
    private static final int BACKGROUND_COLOR = Color.parseColor("#a2dfc7");
    private static final int FOREGROUND_COLOR = Color.parseColor("#48b799");
    private float sweepAngle = 0.0f;

    Paint bgPaint;
    Paint fgPaint;
    RectF rectf = new RectF();

    public ProgressRing(Context context) {
        super(context);
        init();
    }

    public ProgressRing(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ProgressRing(Context context, AttributeSet attrs, int i) {
        super(context, attrs, i);
    }

    private void init() {
        bgPaint = new Paint();
        bgPaint.setStrokeWidth(2);
        bgPaint.setAntiAlias(true);
        bgPaint.setStyle(Paint.Style.STROKE);
        bgPaint.setColor(BACKGROUND_COLOR);
        bgPaint.setStrokeCap(Paint.Cap.ROUND);

        fgPaint = new Paint();
        fgPaint.setStrokeWidth(8);
        fgPaint.setAntiAlias(true);
        fgPaint.setStyle(Paint.Style.STROKE);
        fgPaint.setColor(FOREGROUND_COLOR);
        fgPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(100, 100, 50, bgPaint);
        canvas.drawArc(rectf, -90, sweepAngle, false, fgPaint);
    }

    /**
     * Get progress in range between [0, 1]
     */
    public void setProgress(float progress) {
        progress = Math.max(Math.min(progress, 1.0f), 0.0f);
        sweepAngle = 360 * progress;
        invalidate();
    }
}
