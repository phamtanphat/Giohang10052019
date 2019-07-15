package khoapham.ptp.phamtanphat.appgiohang10052019.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import khoapham.ptp.phamtanphat.appgiohang10052019.R;

public class GiohangActivity extends AppCompatActivity {

    RecyclerView recyclerViewGiohang;
    TextView txtTongtien;
    Button btnThanhtoan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giohang);

        recyclerViewGiohang = findViewById(R.id.recyclerviewGiohang);
        txtTongtien = findViewById(R.id.textviewTongtien);
        btnThanhtoan = findViewById(R.id.buttonThanhtoan);
    }
}
