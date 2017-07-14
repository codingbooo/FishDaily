package codingbo.fishdaily.welcome;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Window;

import codingbo.fishdaily.R;

/**
 * Created by bob
 * on 17.7.5.
 */

public class DemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_demo);

//        Transition slide = TransitionInflater.from(this).inflateTransition(R.transition.slide);
//        getWindow().setExitTransition(slide);
//        getWindow().setEnterTransition(slide);
//        getWindow().setReenterTransition(slide);

        Fade fade = new Fade();
        fade.setDuration(400);
        getWindow().setEnterTransition(fade);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAfterTransition();
    }
}
