package khoapham.ptp.phamtanphat.appgiohang10052019.model;

import java.util.ArrayList;

public class SingletonGiohang {
    private static SingletonGiohang instance;
    private static ArrayList<Dienthoai> mangdienthoai;

    private SingletonGiohang() {
       mangdienthoai = new ArrayList<>();
    }
    public static SingletonGiohang getInstance(){
        if (instance == null){
            instance = new SingletonGiohang();
        }
        return instance;
    }
    public void setgiohang(int index , Dienthoai dienthoai){
        mangdienthoai.set(index,dienthoai);
    }
    public ArrayList<Dienthoai> getGiohang(){
        return mangdienthoai;
    }
}
