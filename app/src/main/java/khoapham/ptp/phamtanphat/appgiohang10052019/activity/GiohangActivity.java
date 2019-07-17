package khoapham.ptp.phamtanphat.appgiohang10052019.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import khoapham.ptp.phamtanphat.appgiohang10052019.R;
import khoapham.ptp.phamtanphat.appgiohang10052019.adapter.GiohangAdapter;
import khoapham.ptp.phamtanphat.appgiohang10052019.model.SingletonGiohang;

public class GiohangActivity extends AppCompatActivity {

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

        giohangAdapter = new GiohangAdapter();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerViewGiohang.setLayoutManager(linearLayoutManager);

        recyclerViewGiohang.setAdapter(giohangAdapter);

        txtTongtien.setText();
    }
}
