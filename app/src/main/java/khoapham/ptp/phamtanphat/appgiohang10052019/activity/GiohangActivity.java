package khoapham.ptp.phamtanphat.appgiohang10052019.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

import khoapham.ptp.phamtanphat.appgiohang10052019.Event;
import khoapham.ptp.phamtanphat.appgiohang10052019.R;
import khoapham.ptp.phamtanphat.appgiohang10052019.Updateview;
import khoapham.ptp.phamtanphat.appgiohang10052019.adapter.GiohangAdapter;
import khoapham.ptp.phamtanphat.appgiohang10052019.model.SingletonGiohang;

public class GiohangActivity extends AppCompatActivity implements Updateview {

    RecyclerView recyclerViewGiohang;
    GiohangAdapter giohangAdapter;
    TextView txtTongtien;
    Button btnThanhtoan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giohang);

        recyclerViewGiohang = findViewById(R.id.recyclerviewGiohang);
        txtTongtien = findViewById(R.id.textviewTongtien);
        btnThanhtoan = findViewById(R.id.buttonThanhtoan);

        giohangAdapter = new GiohangAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerViewGiohang.setLayoutManager(linearLayoutManager);

        recyclerViewGiohang.setAdapter(giohangAdapter);

        SingletonGiohang.getInstance().tongtienThanhtoan(new Event() {
            @Override
            public void onUpdate(Long tongtien) {
                DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
                txtTongtien.setText("Thanh toan : " + decimalFormat.format(tongtien));
            }
        });
    }

    @Override
    public void onUpdatetogntien(Long tien) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txtTongtien.setText("Thanh toan : " + decimalFormat.format(tien));
    }
}
