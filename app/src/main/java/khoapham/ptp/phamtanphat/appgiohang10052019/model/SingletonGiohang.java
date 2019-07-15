package khoapham.ptp.phamtanphat.appgiohang10052019.model;

import android.util.Log;

import java.util.ArrayList;

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
        if (mangdienthoai.size() >0){
            for (int i = 0 ; i< mangdienthoai.size() ; i++){
                if (mangdienthoai.get(i).getSoluong() <= 0){
                    mangdienthoai.remove(i);
                }
            }
        }
        if (dienthoai.getSoluong() > 0){
            mangdienthoai.add(dienthoai);
        }
    }
    public void capnhatsanpham(Dienthoai dienthoai) {
        if (mangdienthoai.contains(dienthoai)) {
           for (int i = 0 ; i< mangdienthoai.size() ; i++){
               if (mangdienthoai.get(i).getSoluong() <= 0){
                   mangdienthoai.remove(i);
               }
           }
            mangdienthoai.remove(dienthoai);
            if (dienthoai.getSoluong() > 0){
                mangdienthoai.add(dienthoai);
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
}
