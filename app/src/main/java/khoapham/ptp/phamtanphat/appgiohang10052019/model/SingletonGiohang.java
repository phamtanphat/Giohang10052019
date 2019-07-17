package khoapham.ptp.phamtanphat.appgiohang10052019.model;

import android.util.Log;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import java.util.ArrayList;

import khoapham.ptp.phamtanphat.appgiohang10052019.Event;
import khoapham.ptp.phamtanphat.appgiohang10052019.activity.MainActivity;

public class SingletonGiohang {

    private static SingletonGiohang instance;
    private static ArrayList<Dienthoai> mangdienthoai;

    private SingletonGiohang() {
        mangdienthoai = new ArrayList<>();
    }

    public static SingletonGiohang getInstance() {
        if (instance == null) {
            instance = new SingletonGiohang();
        }
        return instance;
    }
    public void themsanpham(Dienthoai dienthoai) {
       if (mangdienthoai!= null){
           for (int i = 0 ; i< mangdienthoai.size() ; i++){
               if (mangdienthoai.get(i).getSoluong() <= 0){
                   mangdienthoai.remove(i);
               }
           }
           mangdienthoai.add(dienthoai);

       }
    }
    public void capnhatsanpham(Dienthoai dienthoai) {

        if (mangdienthoai != null) {
            for (int i = 0 ; i< mangdienthoai.size() ; i++){
                if (dienthoai.getId() == mangdienthoai.get(i).getId()){
                    mangdienthoai.set(i,dienthoai);
                }
                if (mangdienthoai.get(i).getSoluong() <= 0){
                    mangdienthoai.remove(i);
                }
            }


        }
    }
    public ArrayList<Dienthoai> getGiohang() {
        return mangdienthoai;
    }
    public boolean timkiem(int idsanpham) {
        for (Dienthoai dienthoai : mangdienthoai) {
            if (dienthoai.getId() == idsanpham) return true;
        }
        return false;
    }
    //mvvm , mvp
    public void tongtienThanhtoan(Event event){
        long ketqua = 0;
        if (mangdienthoai != null){
            if (mangdienthoai.size() == 0){
                ketqua = 0;
            }
            for (int i = 0 ; i<mangdienthoai.size() ; i++ ){
                ketqua += (mangdienthoai.get(i).getSoluong() * mangdienthoai.get(i).getGia());
            }
        }
        event.onUpdate(ketqua);
    }

}
