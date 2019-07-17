package khoapham.ptp.phamtanphat.appgiohang10052019.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;

import khoapham.ptp.phamtanphat.appgiohang10052019.R;
import khoapham.ptp.phamtanphat.appgiohang10052019.adapter.DienthoaiAdapter;
import khoapham.ptp.phamtanphat.appgiohang10052019.model.Dienthoai;

public class MainActivity extends AppCompatActivity {

    ImageSwitcher imageSwitcher;
    Integer[] mangbaner = {R.drawable.baner1,R.drawable.baner2,R.drawable.baner3};
    int i = 0;
    RecyclerView recyclerView;
    DienthoaiAdapter dienthoaiAdapter;
    ArrayList<Dienthoai> dienthoaiArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initview();
        initbaner();
    }

    private void initview() {
        imageSwitcher = findViewById(R.id.imageswitcher);
        recyclerView = findViewById(R.id.recyclerviewDienthoai);
        dienthoaiArrayList = new ArrayList<>();

        dienthoaiArrayList.add(new Dienthoai(0,"Dien thoai 1",R.drawable.hinh1,200000,0));
        dienthoaiArrayList.add(new Dienthoai(1,"Dien thoai 2",R.drawable.hinh2,210000,0));
        dienthoaiArrayList.add(new Dienthoai(2,"Dien thoai 3",R.drawable.hinh3,220000,0));
        dienthoaiArrayList.add(new Dienthoai(3,"Dien thoai 4",R.drawable.hinh4,230000,0));
        dienthoaiArrayList.add(new Dienthoai(4,"Dien thoai 5",R.drawable.hinh5,240000,0));

        dienthoaiAdapter = new DienthoaiAdapter(dienthoaiArrayList , this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(dienthoaiAdapter);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_gio_hang,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_menu_giong_hang :
                Intent intent = new Intent(this,GiohangActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
