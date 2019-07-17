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
}
