package codingbo.fishdaily;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WelcomeActivity extends AppCompatActivity {
    private static final String TAG = "WelcomeActivity";
    private final int DURATION_TIME = 100;//3000

    @BindView(R.id.tv_step_1)
    TextView mTvStep1;
    @BindView(R.id.tv_step_2)
    TextView mTvStep2;
    @BindView(R.id.tv_step_3)
    TextView mTvStep3;
    @BindView(R.id.tv_step_4)
    TextView mTvStep4;
    @BindView(R.id.tv_step_5)
    TextView mTvStep5;

//    @Override
//    protected int getLayoutId() {
//        return R.layout.activity_welcome;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
//        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
//        Transition explode = TransitionInflater.from(this).inflateTransition(R.transition.explode);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        startAnimator();

    }

    @Override
    protected void onResume() {
        super.onResume();
//        startAnimator();
        Log.d(TAG, "onResume: ");
    }

    private void startAnimator() {
        ObjectAnimator a = ObjectAnimator.ofFloat(mTvStep1, "alpha", 0f, 1f, 0f);
        ObjectAnimator x = ObjectAnimator.ofFloat(mTvStep1, "scaleX", 0.5f, 1.5f);
        ObjectAnimator y = ObjectAnimator.ofFloat(mTvStep1, "scaleY", 0.5f, 1.5f);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(DURATION_TIME);
        set.playTogether(a, x, y);
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                mTvStep1.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                mTvStep1.setVisibility(View.GONE);
                step2();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        set.start();
    }

    private void step2() {
        ObjectAnimator a = ObjectAnimator.ofFloat(mTvStep2, "alpha", 0f, 1f, 0f);
        ObjectAnimator x = ObjectAnimator.ofFloat(mTvStep2, "scaleX", 0.5f, 1.5f);
        ObjectAnimator y = ObjectAnimator.ofFloat(mTvStep2, "scaleY", 0.5f, 1.5f);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(DURATION_TIME);
        set.playTogether(a, x, y);
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                mTvStep2.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                mTvStep2.setVisibility(View.GONE);
                step3();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        set.start();
    }

    private void step3() {
        ObjectAnimator a = ObjectAnimator.ofFloat(mTvStep3, "alpha", 0f, 1f, 0f);
        ObjectAnimator x = ObjectAnimator.ofFloat(mTvStep3, "scaleX", 0.5f, 1.5f);
        ObjectAnimator y = ObjectAnimator.ofFloat(mTvStep3, "scaleY", 0.5f, 1.5f);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(DURATION_TIME);
        set.playTogether(a, x, y);
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                mTvStep3.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                mTvStep3.setVisibility(View.GONE);
                step4();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        set.start();
    }

    private void step4() {
        ObjectAnimator a = ObjectAnimator.ofFloat(mTvStep4, "alpha", 0f, 1f, 0f);
        ObjectAnimator x = ObjectAnimator.ofFloat(mTvStep4, "scaleX", 0.5f, 1.5f);
        ObjectAnimator y = ObjectAnimator.ofFloat(mTvStep4, "scaleY", 0.5f, 1.5f);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(DURATION_TIME);
        set.playTogether(a, x, y);
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                mTvStep4.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                mTvStep4.setVisibility(View.GONE);
                step5();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        set.start();
    }

    private void step5() {
        ObjectAnimator a = ObjectAnimator.ofFloat(mTvStep5, "alpha", 0f, 1f);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(DURATION_TIME);
        set.playTogether(a);
        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                mTvStep5.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                showMainActivity();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        set.start();
    }

    private void showMainActivity() {

//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());


        Intent intent = new Intent(this, MainActivity.class);
        Pair demo = new Pair<>(mTvStep5, ViewCompat.getTransitionName(mTvStep5));

        ActivityOptionsCompat transitionActivityOptions =
                ActivityOptionsCompat.makeSceneTransitionAnimation(this, demo);

        ActivityCompat.startActivity(this,
                intent, transitionActivityOptions.toBundle());
        finish();
    }

    @OnClick(R.id.tv_step_5)
    public void onViewClicked() {
        showMainActivity();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
