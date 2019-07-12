package khoapham.ptp.phamtanphat.appgiohang10052019.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import khoapham.ptp.phamtanphat.appgiohang10052019.R;

public class MainActivity extends AppCompatActivity {

    ImageSwitcher imageSwitcher;
    Integer[] mangbaner = {R.drawable.baner1,R.drawable.baner2,R.drawable.baner3};
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initview();
        initbaner();
    }

    private void initview() {
        imageSwitcher = findViewById(R.id.imageswitcher);
    }

    private void initbaner() {
        Animation out= AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
        Animation in= AnimationUtils.loadAnimation(this, android.R.anim.fade_in);

        imageSwitcher.setInAnimation(in);
        imageSwitcher.setOutAnimation(out);

        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView myView = new ImageView(MainActivity.this);
                myView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                ImageSwitcher.LayoutParams params= new ImageSwitcher.LayoutParams(
                        ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT);
                myView.setLayoutParams(params);
                return myView;
            }
        });
        CountDownTimer countDownTimer = new CountDownTimer(1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (i >= mangbaner.length){
                    i = 0;
                }
                imageSwitcher.setImageResource(mangbaner[i]);
                i++;
            }

            @Override
            public void onFinish() {
                this.start();
            }
        };
        countDownTimer.start();
    }
}
