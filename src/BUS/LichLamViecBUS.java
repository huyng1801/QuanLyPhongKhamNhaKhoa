package BUS;


import DAL.LichLamViecDAL;
import DTO.LichLamViecDTO;
import java.sql.Date;
import java.util.List;

public class LichLamViecBUS {

    public static List<LichLamViecDTO> layDanhSachLichLamViec() {
        return LichLamViecDAL.layDanhSachLichLamViec();
    }

    public static boolean themLichLamViec( LichLamViecDTO lichLamViec ) {

        return LichLamViecDAL.themLichLamViec(lichLamViec);
    }

    public static boolean suaLichLamViec( LichLamViecDTO lichLamViec ) {

        return LichLamViecDAL.suaLichLamViec(lichLamViec);
    }

    public static boolean xoaLichLamViec(int maLichLamViec) {
        return LichLamViecDAL.xoaLichLamViec(maLichLamViec);
    }
    public static boolean hasScheduleConflict(String nhaSi, Date date) {
    return LichLamViecDAL.hasScheduleConflict(nhaSi, date);
    }
}
