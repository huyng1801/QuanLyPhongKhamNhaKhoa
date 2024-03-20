package DTO;
import java.sql.Date;
public class LichLamViecDTO
{
    public int MaLichLamViec;
    public String MaNhaSi;
    public String teNhaSi;
    public Date NgayLamViec;
    public String SanSang;

    public LichLamViecDTO() {
    }

    public LichLamViecDTO(String MaNhaSi, Date NgayLamViec, String SanSang) {
        this.MaNhaSi = MaNhaSi;
        this.NgayLamViec = NgayLamViec;
        this.SanSang = SanSang;
    }

    public LichLamViecDTO(int MaLichLamViec, String MaNhaSi, String teNhaSi, Date NgayLamViec, String SanSang) {
        this.MaLichLamViec = MaLichLamViec;
        this.MaNhaSi = MaNhaSi;
        this.teNhaSi = teNhaSi;
        this.NgayLamViec = NgayLamViec;
        this.SanSang = SanSang;
    }

    public LichLamViecDTO(int MaLichLamViec, String MaNhaSi, Date NgayLamViec, String SanSang) {
        this.MaLichLamViec = MaLichLamViec;
        this.MaNhaSi = MaNhaSi;
        this.NgayLamViec = NgayLamViec;
        this.SanSang = SanSang;
    }

    public int getMaLichLamViec() {
        return MaLichLamViec;
    }

    public void setMaLichLamViec(int MaLichLamViec) {
        this.MaLichLamViec = MaLichLamViec;
    }

    public String getMaNhaSi() {
        return MaNhaSi;
    }

    public String getTeNhaSi() {
        return teNhaSi;
    }

    public void setMaNhaSi(String MaNhaSi) {
        this.MaNhaSi = MaNhaSi;
    }

    public Date getNgayLamViec() {
        return NgayLamViec;
    }

    public void setNgayLamViec(Date NgayLamViec) {
        this.NgayLamViec = NgayLamViec;
    }

    public String getSanSang() {
        return SanSang;
    }

    public void setSanSang(String SanSang) {
        this.SanSang = SanSang;
    }
}
