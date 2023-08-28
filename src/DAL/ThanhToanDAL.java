package DAL;


import DTO.ThanhToanDTO;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ThanhToanDAL {
    public static List<ThanhToanDTO> layDanhSachThanhToan() {
        List<ThanhToanDTO> danhSachThanhToan = new ArrayList<>();

        try (Connection connection = Database.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT MaThanhToan, MaKeHoach, TongTien, NgayThanhToan, MaNhanVien, TienDaTra, TienThoi, LoaiThanhToan FROM ThanhToan")) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String maThanhToan = resultSet.getString("MaThanhToan");
                String maKeHoach = resultSet.getString("MaKeHoach");
                BigDecimal tongTien = resultSet.getBigDecimal("TongTien");
                Date ngayThanhToan = resultSet.getDate("NgayThanhToan");
                String maNhanVien = resultSet.getString("MaNhanVien");
                BigDecimal tienDaTra = resultSet.getBigDecimal("TienDaTra");
                BigDecimal tienThoi = resultSet.getBigDecimal("TienThoi");
                String loaiThanhToan = resultSet.getString("LoaiThanhToan");

                ThanhToanDTO thanhToan = new ThanhToanDTO(maThanhToan, maKeHoach, tongTien, ngayThanhToan, maNhanVien, tienDaTra, tienThoi, loaiThanhToan);
                danhSachThanhToan.add(thanhToan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return danhSachThanhToan;
    }

    public static boolean themThanhToan(ThanhToanDTO thanhToan) {
        try (Connection connection = Database.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO ThanhToan (MaThanhToan, MaKeHoach, TongTien, NgayThanhToan, MaNhanVien, TienDaTra, TienThoi, LoaiThanhToan) VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, thanhToan.getMaThanhToan());
            preparedStatement.setString(2, thanhToan.getMaKeHoach());
            preparedStatement.setBigDecimal(3, thanhToan.getTongTien());
            preparedStatement.setDate(4, thanhToan.getNgayThanhToan());
            preparedStatement.setString(5, thanhToan.getMaNhanVien());
            preparedStatement.setBigDecimal(6, thanhToan.getTienDaTra());
            preparedStatement.setBigDecimal(7, thanhToan.getTienThoi());
            preparedStatement.setString(8, thanhToan.getLoaiThanhToan());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean suaThanhToan(ThanhToanDTO thanhToan) {
        try (Connection connection = Database.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE ThanhToan SET MaKeHoach = ?, TongTien = ?, NgayThanhToan = ?, MaNhanVien = ?, TienDaTra = ?, TienThoi = ?, LoaiThanhToan = ? WHERE MaThanhToan = ?")) {
            preparedStatement.setString(1, thanhToan.getMaKeHoach());
            preparedStatement.setBigDecimal(2, thanhToan.getTongTien());
            preparedStatement.setDate(3, thanhToan.getNgayThanhToan());
            preparedStatement.setString(4, thanhToan.getMaNhanVien());
            preparedStatement.setBigDecimal(5, thanhToan.getTienDaTra());
            preparedStatement.setBigDecimal(6, thanhToan.getTienThoi());
            preparedStatement.setString(7, thanhToan.getLoaiThanhToan());
            preparedStatement.setString(8, thanhToan.getMaThanhToan());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean xoaThanhToan(String maThanhToan) {
        try (Connection connection = Database.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM ThanhToan WHERE MaThanhToan = ?")) {
            preparedStatement.setString(1, maThanhToan);

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
