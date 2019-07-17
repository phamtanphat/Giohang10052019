package khoapham.ptp.phamtanphat.appgiohang10052019.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;

import khoapham.ptp.phamtanphat.appgiohang10052019.R;
import khoapham.ptp.phamtanphat.appgiohang10052019.activity.GiohangActivity;
import khoapham.ptp.phamtanphat.appgiohang10052019.model.Dienthoai;
import khoapham.ptp.phamtanphat.appgiohang10052019.model.SingletonGiohang;

public class GiohangAdapter extends RecyclerView.Adapter<GiohangAdapter.Viewholder> {

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.dong_item_giohang,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, final int position) {
        final Dienthoai dienthoai = SingletonGiohang.getInstance().getGiohang().get(position);
        holder.imgdienthoai.setImageResource(dienthoai.getHinhanh());
        holder.txtSoluong.setText(dienthoai.getSoluong() + "");
        holder.txtTen.setText(dienthoai.getTen());
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        holder.txtGia.setText(decimalFormat.format(dienthoai.getGia() * dienthoai.getSoluong()) + " Đ");

        holder.imgCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dienthoai.setSoluong(dienthoai.getSoluong() + 1);
                SingletonGiohang.getInstance().capnhatsanpham(dienthoai);
                notifyDataSetChanged();
            }
        });
        holder.imgTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dienthoai.getSoluong() <=0) return;
                dienthoai.setSoluong(dienthoai.getSoluong() - 1);
                SingletonGiohang.getInstance().capnhatsanpham(dienthoai);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        if (SingletonGiohang.getInstance().getGiohang().size() <= 0){
            return 0;
        }
        return SingletonGiohang.getInstance().getGiohang().size() ;
    }

    class Viewholder extends RecyclerView.ViewHolder{
        ImageView imgCong,imgTru,imgdienthoai;
        TextView txtTen,txtGia,txtSoluong;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            imgCong = itemView.findViewById(R.id.imageviewGiohangPlus);
            imgTru = itemView.findViewById(R.id.imageviewGiohangMinus);
            imgdienthoai = itemView.findViewById(R.id.imageviewGiohang);
            txtTen = itemView.findViewById(R.id.textviewGiohangTendienthoai);
            txtGia = itemView.findViewById(R.id.textviewGiohangGiadienthoai);
            txtSoluong = itemView.findViewById(R.id.textviewGiohangSoluongdienthoai);

        }
    }
}
