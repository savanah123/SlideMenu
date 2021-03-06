package highwin.zgs.slidemenu;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

import java.util.concurrent.TimeUnit;

/**
 * User: zgsHighwin
 * Email: 799174081@qq.com or 799174081@gmail.com
 * Description: A Thought Of SlideMenu
 * Create-Time: 2016/8/22 11:30
 */
public class ScrollAnimation extends Animation {

    private View v;
    private float targetX;
    private float totalValue;
    private float startX;


    public ScrollAnimation(View v, float targetX, long time, TimeUnit unit) {
        this.v = v;
        this.targetX = targetX;
        startX = v.getScrollX();        //get current position of view
        totalValue = targetX - startX;  //total distance has to move
        setDuration(unit.toMillis(time));  //set time

    }

    /**
     * @param interpolatedTime 在动画执行过程中的百分比||The value of the normalized time (0.0 to 1.0)
     *                         after it has been run through the interpolation function.
     * @param t
     */
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        int currentScrollX = (int) (startX + totalValue * interpolatedTime);
        v.scrollTo(currentScrollX, 0);
    }
}