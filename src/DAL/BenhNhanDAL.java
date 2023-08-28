package DAL;


import DTO.BenhNhanDTO;
import DTO.ChiTietBenhNhanDTO;
import DTO.ChongChiDinhDTO;
import DTO.KeHoachDieuTriDTO;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.lang.model.util.Types;
import java.sql.CallableStatement;
public class BenhNhanDAL {
    public static List<BenhNhanDTO> layDanhSachBenhNhan() {
        List<BenhNhanDTO> danhSachBenhNhan = new ArrayList<>();

        try (Connection connection = Database.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT MaBenhNhan, TenBenhNhan, Tuoi, GioiTinh, SucKhoeRangMieng FROM BenhNhan")) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String maBenhNhan = resultSet.getString("MaBenhNhan");
                String tenBenhNhan = resultSet.getString("TenBenhNhan");
                int tuoi = resultSet.getInt("Tuoi");
                String gioiTinh = resultSet.getString("GioiTinh");
                String sucKhoeRangMieng = resultSet.getString("SucKhoeRangMieng");

                BenhNhanDTO benhNhan = new BenhNhanDTO(maBenhNhan, tenBenhNhan, tuoi, gioiTinh, sucKhoeRangMieng);
                danhSachBenhNhan.add(benhNhan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return danhSachBenhNhan;
    }
public static String generateMaBenhNhan() {
    String generatedMaBenhNhan = "";

    try {
        Connection connection = Database.getConnect();

        CallableStatement callableStatement = connection.prepareCall("{? = call dbo.GenerateMaBenhNhan()}");
        callableStatement.registerOutParameter(1, java.sql.Types.CHAR);
        callableStatement.execute();

        generatedMaBenhNhan = callableStatement.getString(1);

        callableStatement.close();
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
        // Handle the SQL exception as needed
    }

    return generatedMaBenhNhan;
}
    public static boolean themBenhNhan(BenhNhanDTO benhNhan) {
        try (Connection connection = Database.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO BenhNhan (MaBenhNhan, TenBenhNhan, Tuoi, GioiTinh, SucKhoeRangMieng) VALUES (?, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, benhNhan.getMaBenhNhan());
            preparedStatement.setString(2, benhNhan.getTenBenhNhan());
            preparedStatement.setInt(3, benhNhan.getTuoi());
            preparedStatement.setString(4, benhNhan.getGioiTinh());
            preparedStatement.setString(5, benhNhan.getSucKhoeRangMieng());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean suaBenhNhan(BenhNhanDTO benhNhan) {
        try (Connection connection = Database.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE BenhNhan SET TenBenhNhan = ?, Tuoi = ?, GioiTinh = ?, SucKhoeRangMieng = ? WHERE MaBenhNhan = ?")) {
            preparedStatement.setString(1, benhNhan.getTenBenhNhan());
            preparedStatement.setInt(2, benhNhan.getTuoi());
            preparedStatement.setString(3, benhNhan.getGioiTinh());
            preparedStatement.setString(4, benhNhan.getSucKhoeRangMieng());
            preparedStatement.setString(5, benhNhan.getMaBenhNhan());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean xoaBenhNhan(String maBenhNhan) {
        try (Connection connection = Database.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM BenhNhan WHERE MaBenhNhan = ?")) {
            preparedStatement.setString(1, maBenhNhan);

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
public static ChiTietBenhNhanDTO layThongTinChiTietBenhNhan(String maBenhNhan) {
ChiTietBenhNhanDTO benhNhan = null;
    try (Connection connection = Database.getConnect();
         PreparedStatement preparedStatement = connection.prepareStatement(
                 "SELECT BN.TenBenhNhan, BN.Tuoi, BN.GioiTinh, " +
                 "COALESCE(SUM(TT.TongTien), 0.00) AS TongTienDieuTri, " +
                 "COALESCE(SUM(TT.TienDaTra), 0.00) AS TongTienDaThanhToan, " +
                 "BN.SucKhoeRangMieng " +
                 "FROM BenhNhan BN " +
                 "LEFT JOIN KeHoachDieuTri KHT ON BN.MaBenhNhan = KHT.MaBenhNhan " +
                 "LEFT JOIN ThanhToan TT ON KHT.MaKeHoach = TT.MaKeHoach " +
                 "WHERE BN.MaBenhNhan = ? " +
                 "GROUP BY BN.MaBenhNhan, BN.TenBenhNhan, BN.Tuoi, BN.GioiTinh, BN.SucKhoeRangMieng")) {

        preparedStatement.setString(1, maBenhNhan);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String tenBenhNhan = resultSet.getString("TenBenhNhan");
            int tuoi = resultSet.getInt("Tuoi");
            String gioiTinh = resultSet.getString("GioiTinh");
            BigDecimal tongTienDieuTri = resultSet.getBigDecimal("TongTienDieuTri");
            BigDecimal tongTienDaThanhToan = resultSet.getBigDecimal("TongTienDaThanhToan");
            String sucKhoeRangMieng = resultSet.getString("SucKhoeRangMieng");

             benhNhan = new ChiTietBenhNhanDTO(tenBenhNhan, tuoi, gioiTinh,
                tongTienDieuTri, tongTienDaThanhToan,sucKhoeRangMieng);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return benhNhan;
}
public static List<ChongChiDinhDTO> layChongChiDinhTheoMaBenhNhan(String maBenhNhan) {
    List<ChongChiDinhDTO> danhSachChongChiDinh = new ArrayList<>();

    try (Connection connection = Database.getConnect();
         PreparedStatement preparedStatement = connection.prepareStatement(
                 "SELECT CCD.MaChongChiDinh, CCD.MaThuoc, T.TenThuoc, CCD.GhiChu " +
                 "FROM ChongChiDinh CCD " +
                 "JOIN Thuoc T ON CCD.MaThuoc = T.MaThuoc " +
                 "WHERE CCD.MaBenhNhan = ?")) {

        preparedStatement.setString(1, maBenhNhan);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int maChongChiDinh = resultSet.getInt("MaChongChiDinh");
            String maThuoc = resultSet.getString("MaThuoc");
            String tenThuoc = resultSet.getString("TenThuoc");
            String ghiChu = resultSet.getString("GhiChu");

            ChongChiDinhDTO chongChiDinh = new ChongChiDinhDTO();
            chongChiDinh.setMaChongChiDinh(maChongChiDinh);
            chongChiDinh.setMaThuoc(maThuoc);
            chongChiDinh.setTenThuoc(tenThuoc);
            chongChiDinh.setGhiChu(ghiChu);

            danhSachChongChiDinh.add(chongChiDinh);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return danhSachChongChiDinh;
}
public static List<KeHoachDieuTriDTO> layKeHoachDieuTriTheoMaBenhNhan(String maBenhNhan) {
    List<KeHoachDieuTriDTO> danhSachKeHoachDieuTri = new ArrayList<>();

    try (Connection connection = Database.getConnect();
         PreparedStatement preparedStatement = connection.prepareStatement(
                 "SELECT KHT.MaKeHoach, KHT.MaNhaSi, NS.TenNhaSi, KHT.NgayDieuTri, KHT.MoTa, " +
                 "KHT.GhiChu, KHT.TrangThaiDieuTri " +
                 "FROM KeHoachDieuTri KHT " +
                 "JOIN NhaSi NS ON KHT.MaNhaSi = NS.MaNhaSi " +
                 "WHERE KHT.MaBenhNhan = ?")) {

        preparedStatement.setString(1, maBenhNhan);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            String maKeHoach = resultSet.getString("MaKeHoach");
            String maNhaSi = resultSet.getString("MaNhaSi");
            String tenNhaSi = resultSet.getString("TenNhaSi");
            Date ngayDieuTri = resultSet.getDate("NgayDieuTri");
            String moTa = resultSet.getString("MoTa");
            String ghiChu = resultSet.getString("GhiChu");
            String trangThaiDieuTri = resultSet.getString("TrangThaiDieuTri");

            KeHoachDieuTriDTO keHoachDieuTri = new KeHoachDieuTriDTO();
            keHoachDieuTri.setMaKeHoach(maKeHoach);
            keHoachDieuTri.setMaNhaSi(maNhaSi);
            keHoachDieuTri.setTenNhaSi(tenNhaSi);
            keHoachDieuTri.setNgayDieuTri(ngayDieuTri);
            keHoachDieuTri.setMoTa(moTa);
            keHoachDieuTri.setGhiChu(ghiChu);
            keHoachDieuTri.setTrangThaiDieuTri(trangThaiDieuTri);

            danhSachKeHoachDieuTri.add(keHoachDieuTri);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return danhSachKeHoachDieuTri;
}

}
