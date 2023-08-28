package BUS;


import DAL.BenhNhanDAL;
import DTO.BenhNhanDTO;
import DTO.ChiTietBenhNhanDTO;
import DTO.ChongChiDinhDTO;
import DTO.KeHoachDieuTriDTO;

import java.util.List;

public class BenhNhanBUS {
    public static List<BenhNhanDTO> layDanhSachBenhNhan() {
        return BenhNhanDAL.layDanhSachBenhNhan();
    }

    public static boolean themBenhNhan(BenhNhanDTO benhNhan) {
        return BenhNhanDAL.themBenhNhan(benhNhan);
    }

    public static boolean suaBenhNhan(BenhNhanDTO benhNhan) {
        return BenhNhanDAL.suaBenhNhan(benhNhan);
    }

    public static boolean xoaBenhNhan(String maBenhNhan) {
        return BenhNhanDAL.xoaBenhNhan(maBenhNhan);
    }
    public static ChiTietBenhNhanDTO layThongTinChiTietBenhNhan(String maBenhNhan){
        return BenhNhanDAL.layThongTinChiTietBenhNhan(maBenhNhan);
    }
    public static List<ChongChiDinhDTO> layChongChiDinhTheoMaBenhNhan(String maBenhNhan){
    return BenhNhanDAL.layChongChiDinhTheoMaBenhNhan(maBenhNhan);
    }
    public static List<KeHoachDieuTriDTO> layKeHoachDieuTriTheoMaBenhNhan(String maBenhNhan) {
        
         return BenhNhanDAL.layKeHoachDieuTriTheoMaBenhNhan(maBenhNhan);
        }
    public static String generateMaBenhNhan() {
    return BenhNhanDAL.generateMaBenhNhan();
    }
}
