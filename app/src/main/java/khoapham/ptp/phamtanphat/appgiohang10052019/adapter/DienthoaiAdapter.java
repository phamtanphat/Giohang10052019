package khoapham.ptp.phamtanphat.appgiohang10052019.adapter;

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
import khoapham.ptp.phamtanphat.appgiohang10052019.model.Dienthoai;

public class DienthoaiAdapter extends RecyclerView.Adapter<DienthoaiAdapter.Viewholder> {

    private ArrayList<Dienthoai> mangdienthoai;

    public DienthoaiAdapter(ArrayList<Dienthoai> mangdienthoai) {
        this.mangdienthoai = mangdienthoai;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.dong_item_dienthoai,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        final Dienthoai dienthoai = mangdienthoai.get(position);
        holder.imgdienthoai.setImageResource(dienthoai.getHinhanh());
        holder.txtSoluong.setText(dienthoai.getSoluong() + "");
        holder.txtTen.setText(dienthoai.getTen());
        DecimalFormat decimalFormat = new DecimalFormat("###.###");
        holder.txtGia.setText(decimalFormat.format(dienthoai.getGia()) + " Đ");

        holder.imgCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dienthoai.setSoluong(dienthoai.getSoluong() + 1);
                mangdienthoai.set(dienthoai.getId(),dienthoai);
                notifyDataSetChanged();
            }
        });
        holder.imgTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dienthoai.getSoluong() <=0) return;
                dienthoai.setSoluong(dienthoai.getSoluong() - 1);
                mangdienthoai.set(dienthoai.getId(),dienthoai);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mangdienthoai != null ? mangdienthoai.size() : 0;
    }

    class Viewholder extends RecyclerView.ViewHolder{
        ImageView imgCong,imgTru,imgdienthoai;
        TextView txtTen,txtGia,txtSoluong,txtDatmua;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            imgCong = itemView.findViewById(R.id.imageviewPlus);
            imgTru = itemView.findViewById(R.id.imageviewMinus);
            imgdienthoai = itemView.findViewById(R.id.imageviewDienthoai);
            txtTen = itemView.findViewById(R.id.textviewTendienthoai);
            txtGia = itemView.findViewById(R.id.textviewGiadienthoai);
            txtSoluong = itemView.findViewById(R.id.textviewSoluongdienthoai);
            txtDatmua = itemView.findViewById(R.id.textviewDathang);
        }
    }
}
