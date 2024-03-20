package DTO;
import java.sql.Date;
public class LichHenDTO {
    private String maLichHen;
    private Date thoiGianHen;
    private String maBenhNhan;
    private String tenBenhNhan;
    private String maNhaSi;
    private String tenNhaSi;
    private String phongKham;
    private String tinhTrang;

    public LichHenDTO() {
    }

    public LichHenDTO(String maLichHen, Date thoiGianHen, String maBenhNhan, String maNhaSi, String phongKham, String tinhTrang) {
        this.maLichHen = maLichHen;
        this.thoiGianHen = thoiGianHen;
        this.maBenhNhan = maBenhNhan;
        this.maNhaSi = maNhaSi;
        this.phongKham = phongKham;
        this.tinhTrang = tinhTrang;
    }

    public LichHenDTO(String maLichHen, Date thoiGianHen, String maBenhNhan, String tenBenhNhan, String maNhaSi, String tenNhaSi, String phongKham, String tinhTrang) {
        this.maLichHen = maLichHen;
        this.thoiGianHen = thoiGianHen;
        this.maBenhNhan = maBenhNhan;
        this.tenBenhNhan = tenBenhNhan;
        this.maNhaSi = maNhaSi;
        this.tenNhaSi = tenNhaSi;
        this.phongKham = phongKham;
        this.tinhTrang = tinhTrang;
    }

    public LichHenDTO(Date thoiGianHen, String maBenhNhan, String maNhaSi, String phongKham, String tinhTrang) {
        this.thoiGianHen = thoiGianHen;
        this.maBenhNhan = maBenhNhan;
        this.maNhaSi = maNhaSi;
        this.phongKham = phongKham;
        this.tinhTrang = tinhTrang;
    }


    public String getMaBenhNhan() {
        return maBenhNhan;
    }
    public String getMaLichHen() {
        return maLichHen;
    }
    public String getMaNhaSi() {
        return maNhaSi;
    }
 
    public String getPhongKham() {
        return phongKham;
    }
    public Date getThoiGianHen() {
        return thoiGianHen;
    }

    public String getTenBenhNhan() {
        return tenBenhNhan;
    }

    public String getTenNhaSi() {
        return tenNhaSi;
    }
    public String getTinhTrang() {
        return tinhTrang;
    }
    public void setMaBenhNhan(String maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }
    public void setMaLichHen(String maLichHen) {
        this.maLichHen = maLichHen;
    }
    public void setMaNhaSi(String maNhaSi) {
        this.maNhaSi = maNhaSi;
    }

    public void setPhongKham(String phongKham) {
        this.phongKham = phongKham;
    }
    public void setThoiGianHen(Date thoiGianHen) {
        this.thoiGianHen = thoiGianHen;
    }
    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
}
