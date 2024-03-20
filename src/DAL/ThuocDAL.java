package DAL;


import DTO.ThuocDTO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThuocDAL {
    public static List<ThuocDTO> layDanhSachThuoc() {
        List<ThuocDTO> danhSachThuoc = new ArrayList<>();

        try (Connection connection = Database.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT MaThuoc, TenThuoc, DonViTinh, SoLuong, DonGia FROM Thuoc")) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String maThuoc = resultSet.getString("MaThuoc");
                String tenThuoc = resultSet.getString("TenThuoc");
                String donViTinh = resultSet.getString("DonViTinh");
                int soLuong = resultSet.getInt("SoLuong");
                BigDecimal donGia = resultSet.getBigDecimal("DonGia");

                ThuocDTO thuoc = new ThuocDTO(maThuoc, tenThuoc, donViTinh, soLuong, donGia);
                danhSachThuoc.add(thuoc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return danhSachThuoc;
    }

    public static boolean themThuoc(ThuocDTO thuoc) {
        try (Connection connection = Database.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO Thuoc (MaThuoc, TenThuoc, DonViTinh,SoLuong, DonGia) VALUES (?, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, thuoc.getMaThuoc());
            preparedStatement.setString(2, thuoc.getTenThuoc());
            preparedStatement.setString(3, thuoc.getDonViTinh());
             preparedStatement.setInt(4, thuoc.getSoLuong());
            preparedStatement.setBigDecimal(5, thuoc.getDonGia());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean suaThuoc(ThuocDTO thuoc) {
        try (Connection connection = Database.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE Thuoc SET TenThuoc = ?, DonViTinh = ?, SoLuong = ?, DonGia = ? WHERE MaThuoc = ?")) {
            preparedStatement.setString(1, thuoc.getTenThuoc());
            preparedStatement.setString(2, thuoc.getDonViTinh());
             preparedStatement.setInt(3, thuoc.getSoLuong());
            preparedStatement.setBigDecimal(4, thuoc.getDonGia());
            preparedStatement.setString(5, thuoc.getMaThuoc());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean xoaThuoc(String maThuoc) {
        try (Connection connection = Database.getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM Thuoc WHERE MaThuoc = ?")) {
            preparedStatement.setString(1, maThuoc);

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
