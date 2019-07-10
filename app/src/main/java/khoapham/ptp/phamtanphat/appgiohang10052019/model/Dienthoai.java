package khoapham.ptp.phamtanphat.appgiohang10052019.model;

public class Dienthoai {
    private int Id;
    private String ten;
    private Integer hinhanh;
    private Integer gia;
    private Integer soluong;

    public Dienthoai(int id, String ten, Integer hinhanh, Integer gia, Integer soluong) {
        Id = id;
        this.ten = ten;
        this.hinhanh = hinhanh;
        this.gia = gia;
        this.soluong = soluong;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Integer getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(Integer hinhanh) {
        this.hinhanh = hinhanh;
    }

    public Integer getGia() {
        return gia;
    }

    public void setGia(Integer gia) {
        this.gia = gia;
    }

    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }
}
