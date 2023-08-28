/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Utils.DangNhapUtils;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

/**
 *
 * @author huyng
 */
public class GiaoDienChinhGUI extends javax.swing.JFrame {

    private NhaSiGUI panelNhaSi;
    private NhanVienGUI panelNhanVien;
    private ThuocGUI panelThuoc;
    private BenhNhanGUI panelBenhNhan;

    public GiaoDienChinhGUI() {
        initComponents();
        CanGiua();
    }

    public void CanGiua() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int frameWidth = getWidth();
        int frameHeight = getHeight();
        int x = (screenWidth - frameWidth) / 2;
        int y = (screenHeight - frameHeight) / 2;
        setLocation(x, y);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPanel2 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuTuyChon = new javax.swing.JMenu();
        menuItemTrangChu = new javax.swing.JMenuItem();
        menuItemDangXuat = new javax.swing.JMenuItem();
        menuItemThoat = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuItemNhaSi = new javax.swing.JMenuItem();
        menuItemNhanVien = new javax.swing.JMenuItem();
        menuItemThuoc = new javax.swing.JMenuItem();
        menuBenhNhan = new javax.swing.JMenu();
        menuItemHoSoBenhNhan = new javax.swing.JMenuItem();
        menuLichLamViec = new javax.swing.JMenu();
        menuItemLichLamViec = new javax.swing.JMenuItem();
        menuCuocHen = new javax.swing.JMenu();
        menuItemXemLichHen = new javax.swing.JMenuItem();
        menuItemDatLichKham = new javax.swing.JMenuItem();
        menuBaoCao = new javax.swing.JMenu();
        menuItemBaoCaoDieuTriTrongNgay = new javax.swing.JMenuItem();
        menuItemBaoCaoCuocHenTrongNgay = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1356, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 733, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2);

        menuTuyChon.setText("Tùy chọn");

        menuItemTrangChu.setText("Trang chủ");
        menuTuyChon.add(menuItemTrangChu);

        menuItemDangXuat.setText("Đăng xuất");
        menuItemDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemDangXuatActionPerformed(evt);
            }
        });
        menuTuyChon.add(menuItemDangXuat);

        menuItemThoat.setText("Thoát");
        menuItemThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemThoatActionPerformed(evt);
            }
        });
        menuTuyChon.add(menuItemThoat);

        jMenuBar1.add(menuTuyChon);

        jMenu2.setText("Hệ thống");

        menuItemNhaSi.setText("Nha sĩ");
        menuItemNhaSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNhaSiActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemNhaSi);

        menuItemNhanVien.setText("Nhân viên");
        menuItemNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNhanVienActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemNhanVien);

        menuItemThuoc.setText("Thuốc");
        menuItemThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemThuocActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemThuoc);

        jMenuBar1.add(jMenu2);

        menuBenhNhan.setText("Bệnh nhân");

        menuItemHoSoBenhNhan.setText("Hồ sơ bệnh nhân");
        menuItemHoSoBenhNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemHoSoBenhNhanActionPerformed(evt);
            }
        });
        menuBenhNhan.add(menuItemHoSoBenhNhan);

        jMenuBar1.add(menuBenhNhan);

        menuLichLamViec.setText("Lịch làm việc");

        menuItemLichLamViec.setText("Lịch làm việc");
        menuItemLichLamViec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemLichLamViecActionPerformed(evt);
            }
        });
        menuLichLamViec.add(menuItemLichLamViec);

        jMenuBar1.add(menuLichLamViec);

        menuCuocHen.setText("Lịch hẹn");

        menuItemXemLichHen.setText("Xem lịch hẹn");
        menuItemXemLichHen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemXemLichHenActionPerformed(evt);
            }
        });
        menuCuocHen.add(menuItemXemLichHen);

        menuItemDatLichKham.setText("Đặt lịch khám");
        menuItemDatLichKham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemDatLichKhamActionPerformed(evt);
            }
        });
        menuCuocHen.add(menuItemDatLichKham);

        jMenuBar1.add(menuCuocHen);

        menuBaoCao.setText("Báo cáo");

        menuItemBaoCaoDieuTriTrongNgay.setText("Báo cáo các điều trị trong ngày, theo từng bác sĩ");
        menuItemBaoCaoDieuTriTrongNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemBaoCaoDieuTriTrongNgayActionPerformed(evt);
            }
        });
        menuBaoCao.add(menuItemBaoCaoDieuTriTrongNgay);

        menuItemBaoCaoCuocHenTrongNgay.setText("Báo cáo các cuộc hẹn trong ngày theo từng bác sĩ");
        menuItemBaoCaoCuocHenTrongNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemBaoCaoCuocHenTrongNgayActionPerformed(evt);
            }
        });
        menuBaoCao.add(menuItemBaoCaoCuocHenTrongNgay);

        jMenuBar1.add(menuBaoCao);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemDangXuatActionPerformed
        // TODO add your handling code here:
        DangNhapUtils.loaiTaiKhoan = "";
        this.dispose();
        new DangNhapGUI().setVisible(true);
    }//GEN-LAST:event_menuItemDangXuatActionPerformed

    private void menuItemThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemThoatActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_menuItemThoatActionPerformed

    private void menuItemNhaSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemNhaSiActionPerformed
        // TODO add your handling code here:
        panelNhaSi = new NhaSiGUI();
        this.panelNhaSi.setVisible(true);
        this.jPanel2.setLayout(new FlowLayout());
        this.jPanel2.removeAll();
        this.jPanel2.add(panelNhaSi, BorderLayout.CENTER);
        this.jPanel2.updateUI();

        // Cập nhật lại giao diện
        jPanel2.revalidate();
        jPanel2.repaint();
    }//GEN-LAST:event_menuItemNhaSiActionPerformed

    private void menuItemNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemNhanVienActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        panelNhanVien = new NhanVienGUI();
        this.panelNhanVien.setVisible(true);
        this.jPanel2.setLayout(new FlowLayout());
        this.jPanel2.removeAll();
        this.jPanel2.add(panelNhanVien, BorderLayout.CENTER);
        this.jPanel2.updateUI();

        // Cập nhật lại giao diện
        jPanel2.revalidate();
        jPanel2.repaint();
    }//GEN-LAST:event_menuItemNhanVienActionPerformed

    private void menuItemThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemThuocActionPerformed
        // TODO add your handling code here:
        panelThuoc = new ThuocGUI();
        this.panelThuoc.setVisible(true);
        this.jPanel2.setLayout(new FlowLayout());
        this.jPanel2.removeAll();
        this.jPanel2.add(panelThuoc, BorderLayout.CENTER);
        this.jPanel2.updateUI();

        // Cập nhật lại giao diện
        jPanel2.revalidate();
        jPanel2.repaint();
    }//GEN-LAST:event_menuItemThuocActionPerformed

    private void menuItemHoSoBenhNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemHoSoBenhNhanActionPerformed
        // TODO add your handling code here:
        panelBenhNhan = new BenhNhanGUI();
        this.panelBenhNhan.setVisible(true);
        this.jPanel2.setLayout(new FlowLayout());
        this.jPanel2.removeAll();
        this.jPanel2.add(panelBenhNhan, BorderLayout.CENTER);
        this.jPanel2.updateUI();

        // Cập nhật lại giao diện
        jPanel2.revalidate();
        jPanel2.repaint();
    }//GEN-LAST:event_menuItemHoSoBenhNhanActionPerformed
    private LichHenGUI panelLichHen;
    private void menuItemXemLichHenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemXemLichHenActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        panelLichHen = new LichHenGUI();
        this.panelLichHen.setVisible(true);
        this.jPanel2.setLayout(new FlowLayout());
        this.jPanel2.removeAll();
        this.jPanel2.add(panelLichHen, BorderLayout.CENTER);
        this.jPanel2.updateUI();

        // Cập nhật lại giao diện
        jPanel2.revalidate();
        jPanel2.repaint();
    }//GEN-LAST:event_menuItemXemLichHenActionPerformed
    private BaoCaoDieuTriGUI panelBaoCaoDieuTri;
    private void menuItemBaoCaoDieuTriTrongNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemBaoCaoDieuTriTrongNgayActionPerformed
        // TODO add your handling code here:
        panelBaoCaoDieuTri = new BaoCaoDieuTriGUI();
        this.panelBaoCaoDieuTri.setVisible(true);
        this.jPanel2.setLayout(new FlowLayout());
        this.jPanel2.removeAll();
        this.jPanel2.add(panelBaoCaoDieuTri, BorderLayout.CENTER);
        this.jPanel2.updateUI();

        // Cập nhật lại giao diện
        jPanel2.revalidate();
        jPanel2.repaint();
    }//GEN-LAST:event_menuItemBaoCaoDieuTriTrongNgayActionPerformed
    private BaoCaoCuocHenGUI panelBaoCaoCuocHen;
    private void menuItemBaoCaoCuocHenTrongNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemBaoCaoCuocHenTrongNgayActionPerformed
        panelBaoCaoCuocHen = new BaoCaoCuocHenGUI();
        this.panelBaoCaoCuocHen.setVisible(true);
        this.jPanel2.setLayout(new FlowLayout());
        this.jPanel2.removeAll();
        this.jPanel2.add(panelBaoCaoCuocHen, BorderLayout.CENTER);
        this.jPanel2.updateUI();

        // Cập nhật lại giao diện
        jPanel2.revalidate();
        jPanel2.repaint();
    }//GEN-LAST:event_menuItemBaoCaoCuocHenTrongNgayActionPerformed
    private LichLamViecGUI panelLichLamViec;
    private void menuItemLichLamViecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemLichLamViecActionPerformed
        // TODO add your handling code here:
        panelLichLamViec = new LichLamViecGUI();
        this.panelLichLamViec.setVisible(true);
        this.jPanel2.setLayout(new FlowLayout());
        this.jPanel2.removeAll();
        this.jPanel2.add(panelLichLamViec, BorderLayout.CENTER);
        this.jPanel2.updateUI();

        // Cập nhật lại giao diện
        jPanel2.revalidate();
        jPanel2.repaint();
    }//GEN-LAST:event_menuItemLichLamViecActionPerformed
    private DatLichKhamGUI panelDatLichKham;
    private void menuItemDatLichKhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemDatLichKhamActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        panelDatLichKham = new DatLichKhamGUI();
        this.panelDatLichKham.setVisible(true);
        this.jPanel2.setLayout(new FlowLayout());
        this.jPanel2.removeAll();
        this.jPanel2.add(panelDatLichKham, BorderLayout.CENTER);
        this.jPanel2.updateUI();

        // Cập nhật lại giao diện
        jPanel2.revalidate();
        jPanel2.repaint();
    }//GEN-LAST:event_menuItemDatLichKhamActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GiaoDienChinhGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GiaoDienChinhGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GiaoDienChinhGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GiaoDienChinhGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GiaoDienChinhGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenu menuBaoCao;
    private javax.swing.JMenu menuBenhNhan;
    private javax.swing.JMenu menuCuocHen;
    private javax.swing.JMenuItem menuItemBaoCaoCuocHenTrongNgay;
    private javax.swing.JMenuItem menuItemBaoCaoDieuTriTrongNgay;
    private javax.swing.JMenuItem menuItemDangXuat;
    private javax.swing.JMenuItem menuItemDatLichKham;
    private javax.swing.JMenuItem menuItemHoSoBenhNhan;
    private javax.swing.JMenuItem menuItemLichLamViec;
    private javax.swing.JMenuItem menuItemNhaSi;
    private javax.swing.JMenuItem menuItemNhanVien;
    private javax.swing.JMenuItem menuItemThoat;
    private javax.swing.JMenuItem menuItemThuoc;
    private javax.swing.JMenuItem menuItemTrangChu;
    private javax.swing.JMenuItem menuItemXemLichHen;
    private javax.swing.JMenu menuLichLamViec;
    private javax.swing.JMenu menuTuyChon;
    // End of variables declaration//GEN-END:variables
}
