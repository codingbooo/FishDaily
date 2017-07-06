package codingbo.fishdaily;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by bob
 * on 17.7.5.
 */

public class MainActivity extends AppCompatActivity {
    public static final int DURATION = 1000;
    @BindView(R.id.tv_content)
    TextView mTvContent;
    @BindView(R.id.v_demo)
    View mVDemo;
    @BindView(R.id.v_demo2)
    View mVDemo2;

//    @Override
//    protected int getLayoutId() {
//        return R.layout.activity_main;
//    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Fade fade = new Fade();
        fade.setDuration(DURATION);
        getWindow().setEnterTransition(fade);
    }

    @OnClick(R.id.tv_content)
    public void onViewClicked() {
        Intent intent = new Intent(this, DemoActivity.class);
        startActivity(intent,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAfterTransition();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() != MotionEvent.ACTION_DOWN) return true;

        Intent intent = new Intent(this, DemoActivity.class);
        Pair demo = new Pair<>(mVDemo, ViewCompat.getTransitionName(mVDemo));

        ActivityOptionsCompat transitionActivityOptions =
                ActivityOptionsCompat.makeSceneTransitionAnimation(this, demo);

        ActivityCompat.startActivity(this,
                intent, transitionActivityOptions.toBundle());
        return super.onTouchEvent(event);
    }

    @OnClick(R.id.v_demo2)
    public void onViewDemo2() {

        Intent intent = new Intent(this, DemoActivity.class);
        Pair demo = new Pair<>(mVDemo2, ViewCompat.getTransitionName(mVDemo2));

        ActivityOptionsCompat transitionActivityOptions =
                ActivityOptionsCompat.makeSceneTransitionAnimation(this, demo);

        ActivityCompat.startActivity(this,
                intent, transitionActivityOptions.toBundle());
    }
}
