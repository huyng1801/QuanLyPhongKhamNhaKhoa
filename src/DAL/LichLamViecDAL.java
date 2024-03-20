package DAL;


import DTO.LichLamViecDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
public class LichLamViecDAL {

    public static List<LichLamViecDTO> layDanhSachLichLamViec() {
        List<LichLamViecDTO> danhSachLichLamViec = new ArrayList<>();

        try (Connection connection = Database.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT MaLichLamViec, LichLamViec.MaNhaSi as MaNhaSi, TenNhaSi, NgayLamViec, SanSang FROM LichLamViec JOIN NhaSi ON NhaSi.MaNhaSi = LichLamViec.MaNhaSi")) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int maLichLamViec = resultSet.getInt("MaLichLamViec");
                String maNhaSi = resultSet.getString("MaNhaSi");
                String tenNhaSi = resultSet.getString("TenNhaSi");
                Date ngayLamViec = resultSet.getDate("NgayLamViec");
                String sanSang = resultSet.getString("SanSang");
                LichLamViecDTO lichLamViec = new LichLamViecDTO(maLichLamViec, maNhaSi, tenNhaSi,ngayLamViec, sanSang);
                danhSachLichLamViec.add(lichLamViec);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return danhSachLichLamViec;
    }
public static boolean hasScheduleConflict(String nhaSi, Date date) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = Database.getConnect();

            // Truy vấn kiểm tra xem có xung đột lịch làm việc hay không
            String query = "SELECT COUNT(*) FROM LichLamViec WHERE MaNhaSi = ? AND NgayLamViec = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nhaSi);
            preparedStatement.setDate(2, new java.sql.Date(date.getTime()));
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0; // Nếu count > 0, tức là có xung đột
            }

            return false; // Không có xung đột

        } catch (SQLException e) {
            // Xử lý exception nếu cần
            e.printStackTrace();
            return true; // Tạm thời coq lỗi trong trường hợp xảy ra lỗi SQL
        } finally {
            // Đảm bảo đóng resultSet, preparedStatement và connection ở đây
            // ...
        }
    }
    public static boolean themLichLamViec(LichLamViecDTO lichLamViec) {
        try (Connection connection = Database.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO LichLamViec (MaNhaSi, NgayLamViec, SanSang) VALUES (?, ?, ?)")) {
            preparedStatement.setString(1, lichLamViec.getMaNhaSi());
            preparedStatement.setDate(2, lichLamViec.getNgayLamViec());
            preparedStatement.setString(3, lichLamViec.getSanSang());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean suaLichLamViec(LichLamViecDTO lichLamViec) {
        try (Connection connection = Database.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE LichLamViec SET MaNhaSi = ?, NgayLamViec = ?, SanSang = ? WHERE MaLichLamViec = ?")) {
            preparedStatement.setString(1, lichLamViec.getMaNhaSi());
            preparedStatement.setDate(2, lichLamViec.getNgayLamViec());
            preparedStatement.setString(3, lichLamViec.getSanSang());
            preparedStatement.setInt(4, lichLamViec.getMaLichLamViec());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean xoaLichLamViec(int maLichLamViec) {
        try (Connection connection = Database.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM LichLamViec WHERE MaLichLamViec = ?")) {
            preparedStatement.setInt(1, maLichLamViec);

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
