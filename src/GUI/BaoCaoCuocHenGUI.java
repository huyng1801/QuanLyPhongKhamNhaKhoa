/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.BenhNhanBUS;
import BUS.LichHenBUS;
import BUS.NhaSiBUS;
import BUS.NhanVienBUS;
import BUS.ThuocBUS;
import DTO.BenhNhanDTO;
import DTO.LichHenDTO;
import DTO.NhaSiDTO;

import DTO.NhanVienDTO;
import DTO.ThuocDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.PatternSyntaxException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class BaoCaoCuocHenGUI extends javax.swing.JPanel {

    /**
     * Creates new form NhanVienGUI
     */
    public BaoCaoCuocHenGUI() {
        initComponents();
        loadDataToTable();
        loadNhaSi();

    }

    private void loadNhaSi() {
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        cboNhaSi.setModel(comboBoxModel); // Set the model for the JComboBox

        // Load danh sách thuốc into the JComboBox
        List<NhaSiDTO> nhaSiDTO = NhaSiBUS.layDanhSachNhaSi();
        for (NhaSiDTO nhasi : nhaSiDTO) {
            comboBoxModel.addElement(nhasi.getMaNhaSi()); // Add each drug's name to the JComboBox
        }
    }

    private void loadDataToTable() {
         model = (DefaultTableModel) tableLichHen.getModel();
        model.setRowCount(0); // Clear existing data from the table
        model.setColumnCount(0);
        model.addColumn("Mã lịch hẹn");
        model.addColumn("ThoiGianHen");
        model.addColumn("Mã bệnh nhân");
        model.addColumn("MaNhaSi");
        model.addColumn("Phòng khám");
        model.addColumn("Tình trạng");
        List<LichHenDTO> lichHenDTO = LichHenBUS.layDanhSachLichHen();

        for (LichHenDTO nhaSi : lichHenDTO) {
            Object[] rowData = {nhaSi.getMaLichHen(), nhaSi.getThoiGianHen(), nhaSi.getMaBenhNhan(), nhaSi.getMaNhaSi(), nhaSi.getPhongKham(), nhaSi.getTinhTrang()};
            model.addRow(rowData);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableLichHen = new javax.swing.JTable();
        btnBaoCao = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cboNhaSi = new javax.swing.JComboBox<>();
        dateChooserNgayBatDau = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        dateChooserNgayKetThuc = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1366, 760));

        tableLichHen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã lịch hẹn", "Thời gian hẹn", "Mã bệnh nhân", "Phòng khám", "Tình trạng"
            }
        ));
        tableLichHen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableLichHenMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableLichHen);

        btnBaoCao.setText("Báo cáo");
        btnBaoCao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBaoCaoActionPerformed(evt);
            }
        });

        jLabel2.setText("Ngày bắt đầu:");

        jLabel4.setText("Nha sĩ:");

        cboNhaSi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));
        cboNhaSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNhaSiActionPerformed(evt);
            }
        });

        jLabel8.setText("Ngày kết thúc:");

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateChooserNgayBatDau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateChooserNgayKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(cboNhaSi, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(btnBaoCao)
                        .addGap(63, 63, 63)
                        .addComponent(btnReset))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(757, 757, 757)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(cboNhaSi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBaoCao)
                        .addComponent(btnReset))
                    .addComponent(jLabel2)
                    .addComponent(dateChooserNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(dateChooserNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addComponent(jLabel7)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBaoCaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBaoCaoActionPerformed
        // Lấy ngày bắt đầu và ngày kết thúc từ dateChooser
    Date startDate = dateChooserNgayBatDau.getDate();
    Date endDate = dateChooserNgayKetThuc.getDate();

    // Lấy mã nhà sĩ từ comboBox
    String maNhaSi = cboNhaSi.getSelectedItem().toString();

    // Kiểm tra xem ngày bắt đầu và ngày kết thúc đã được chọn hay chưa
    if (startDate == null || endDate == null) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày bắt đầu và ngày kết thúc!");
        return;
    }

    // Kiểm tra xem ngày kết thúc có lớn hơn hoặc bằng ngày bắt đầu hay không
    if (endDate.before(startDate)) {
        JOptionPane.showMessageDialog(this, "Ngày kết thúc không thể nhỏ hơn ngày bắt đầu!");
        return;
    }

    // Tạo bộ lọc dữ liệu
    RowFilter<DefaultTableModel, Integer> filter = new RowFilter<DefaultTableModel, Integer>() {
        @Override
        public boolean include(RowFilter.Entry<? extends DefaultTableModel, ? extends Integer> entry) {
            DefaultTableModel model = entry.getModel();
            int rowIndex = entry.getIdentifier();

            // Lấy giá trị của cột "Mã nha sĩ" trong dòng hiện tại
            String maNhaSiInRow = model.getValueAt(rowIndex, 3).toString();

            // Lấy giá trị của cột "Thời gian hẹn" trong dòng hiện tại
            Date thoiGianHenInRow = (Date) model.getValueAt(rowIndex, 1);

            // Kiểm tra mã nhà sĩ và khoảng thời gian
            boolean maNhaSiMatch = maNhaSiInRow.equals(maNhaSi);
            boolean thoiGianHenMatch = (thoiGianHenInRow.after(startDate) || thoiGianHenInRow.equals(startDate))
                    && (thoiGianHenInRow.before(endDate) || thoiGianHenInRow.equals(endDate));

            // Kết hợp hai điều kiện trên để trả về kết quả cuối cùng của bộ lọc
            return maNhaSiMatch && thoiGianHenMatch;
        }
    };

    // Lấy mô hình của bảng (the DefaultTableModel you have created and populated)
    DefaultTableModel model = (DefaultTableModel) tableLichHen.getModel();

    // Áp dụng bộ lọc vào bảng
    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
    tableLichHen.setRowSorter(sorter);
    sorter.setRowFilter(filter);
    }//GEN-LAST:event_btnBaoCaoActionPerformed

    private void tableLichHenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableLichHenMouseClicked

    }//GEN-LAST:event_tableLichHenMouseClicked

    private void cboNhaSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNhaSiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboNhaSiActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        loadDataToTable();
    }//GEN-LAST:event_btnResetActionPerformed

private DefaultTableModel model;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBaoCao;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox<String> cboNhaSi;
    private com.toedter.calendar.JDateChooser dateChooserNgayBatDau;
    private com.toedter.calendar.JDateChooser dateChooserNgayKetThuc;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableLichHen;
    // End of variables declaration//GEN-END:variables
}
