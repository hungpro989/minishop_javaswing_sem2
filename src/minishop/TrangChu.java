/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minishop;

import ChucVu.ChucVu;
import ChucVu.ChucVuDAO;
import DoiTac.Doitac;
import DoiTac.DoitacDAO;
import HangHoa.HangHoa;
import HangHoa.HangHoaDAO;
import HangHoa.HangSanXuat;
import KhachHang.KhachHang;
import KhachHang.KhachHangCRUD;
import KhachHang.LoaiKhachHangCRUD;
import KhachHang.LoaiKhachHang;
import HangHoa.LoaiSanPham;
import HangHoa.LoaiSanPhamDAO;
import HangHoa.HangSanXuatDAO;
import HoaDon.hoadonCRUD;
import HoaDon.hoadons;
import NhanVien.NhanVien;
import NhanVien.NhanVienDAO;
import PhieuNhapHang.PhieuNhap;
import PhieuNhapHang.PhieuNhapChiTiet;
import PhieuNhapHang.PhieuNhapChiTietDAO;
import PhieuNhapHang.PhieuNhapDAO;
import TongQuan.ThoiGian;
import TongQuan.ThoiGianCRUD;
import TongQuan.TongQuan;
import TongQuan.TongQuanCRUD;
import entities.ChiTietHoaDon;
import entities.HoaDon;
import java.awt.event.KeyEvent;
import static java.awt.image.ImageObserver.WIDTH;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Hung Dep Trai
 */
public class TrangChu extends javax.swing.JFrame {

    private ArrayList<HangHoa> lstHangHoa = new ArrayList<>();
    private ArrayList<HangHoa> lstHangHoaA = new ArrayList<>();
    private ArrayList<HangHoa> lstHangHoaB = new ArrayList<>();
    private ArrayList<LoaiSanPham> lstLoaiSanPham = new ArrayList<>();
    private ArrayList<HangSanXuat> lstHangSanXuat = new ArrayList<>();
    private ArrayList<KhachHang> khachmhang = new ArrayList<>();
    private ArrayList<LoaiKhachHang> loadmKh = new ArrayList<>();
    private ArrayList<Doitac> lstDoiTac = new ArrayList<>();
    private ArrayList<PhieuNhap> lstPhieuNhap = new ArrayList<>();
    private ArrayList<NhanVien> lstNhanVien = new ArrayList<>();
    private ArrayList<ChucVu> lstChucVu = new ArrayList<>();
    private ArrayList<ThoiGian> lstThoiGian = new ArrayList<>();
    private ArrayList<TongQuan> lstTongQuan = new ArrayList<>();
    private ArrayList<TongQuan> lstTongQuanx = new ArrayList<>();
    private ArrayList<PhieuNhapChiTiet> lstPhieuNhapChiTiet = new ArrayList<>();
    private ArrayList<PhieuNhapChiTiet> lstPhieuNhapTien = new ArrayList<>();
    private ArrayList<hoadons> hoamdon;
    private ArrayList<ChiTietHoaDon> CThoadonm = new ArrayList<>();
    private ArrayList<ChiTietHoaDon> CThoadonmA = new ArrayList<>();
//    private ArrayList<taikhoan> taikhoanm;
//    private ArrayList<quyenTK> quyenTKm;
    
    private int MaNhaPhanPhoi;
    private int MaPhieuNhap;
    private int MaNhanVien;
    private int MaChucVu;
    private int MaHangHoa;
    private int MaDanhMuc;
    private int mIDCurrent;
    private int MaThoiGian;
    private int MaHoaDon;
    private float tinhtoan = 0;
    private int MaPhieuNhapChiTiet;

    private int iss;
    private int ass;
    private int maHD;
    private int tien;
    private int so;
    int matk;
    Locale locale = new Locale("vi", "VN");
    NumberFormat fm = NumberFormat.getCurrencyInstance(locale);
    DecimalFormat df = new DecimalFormat("0.##");
    SimpleDateFormat ns = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Creates new form NewJFrame
     */
    public TrangChu() {
        initComponents();
        loadKH();
        loadLoaiKH();
        loadHangHoa();
        loadLoaiSanPham();
        loadHangSanXuat();
        loadDanhMuc();
        loadDanhMucSanPham(MaDanhMuc);
        loadChucVu();
        loadChucVuCombo();
        loadNhanVien();
        loadNhanVienCombo();
        loadDoiTac();
        loadCBBThoiGian();
        loadTongQuan();
        loadspbanchay();

        //
        //loadBieuDoDoanhThu();
        loadPhieuNhap();
        loadNhaCungCapCombo();
        loadPhieuNhapChiTiet(MaPhieuNhap);
        loadTien(MaPhieuNhap);
        loadChiTietPhieuNhapCombo();
        loadNgay();
        loadHoaDon();
//        loadCTHoaDon(iss);
//        tinhtien(iss);
//        loadLoaiQ();
//         loadTK();
//        loadSPCBB();         
    }
    private void loadHoaDon() {
        hoadonCRUD hdcr = new hoadonCRUD();
        hoamdon = hdcr.selectHD();

        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã hóa đơn");
        dtm.addColumn("Mã Khách Hàng");
        dtm.addColumn("Mã Nhân Viên");
        dtm.addColumn("Ngày Lập Hóa Đơn");
        dtm.addColumn("Tổng Tiền");
        dtm.addColumn("Ghi Chú");

        for (int i = 0; i < hoamdon.size(); i++) {
            hoadons get = hoamdon.get(i);
            Vector row = new Vector<>();
            row.add(get.getMaHoaDon());
            row.add(get.getMaKhachHang());
            row.add(get.getMaNhanVien());
            row.add(get.getNgayLapHoaDon());
            row.add((fm.format(get.getTongTien())));
            row.add(get.getGhiChu());
            dtm.addRow(row);

        }
        jTableHoaDon.setModel(dtm);
    }
    public void loadNgay() {
        LocalDate today = LocalDate.now();
        txtNgayNhapPhieuNhap.setText(String.valueOf(today));
        txtTongTienPhieuNhap.setText("0");
    }
    
    public void loadChiTietPhieuNhapCombo() {
        HangHoaDAO dao = new HangHoaDAO();
        lstHangHoa = dao.read();
        DefaultComboBoxModel<HangHoa> combo = new DefaultComboBoxModel();
        for (int i = 0; i < lstHangHoa.size(); i++) {
            HangHoa hh = lstHangHoa.get(i);
            combo.addElement(hh);
        }
        jComboBoxSanPhamx.setModel(combo);
//        for (int i = 0; i < lstHangHoa.size(); i++) {
//            tinhtoan = lstHangHoa.get(i).getGiaBan();
//
//        }

    }
    public void loadTien(int MaPhieuNhap) {
        PhieuNhapChiTietDAO dao = new PhieuNhapChiTietDAO();
        lstPhieuNhapTien = dao.readTien(MaPhieuNhap);
        for (int i = 0; i < lstPhieuNhapTien.size(); i++) {
            txtTongTienPhieuNhap.setText(String.valueOf(lstPhieuNhapTien.get(i).getTongTien()));
        }
    }

    private void loadPhieuNhap() {
        PhieuNhapDAO dao = new PhieuNhapDAO();
        lstPhieuNhap = dao.read();
        DefaultTableModel tbPhieunhap = new DefaultTableModel();
        tbPhieunhap.addColumn("MaPhieuNhap");
        tbPhieunhap.addColumn("MaNhanVien");
        tbPhieunhap.addColumn("MaNhaPhanPhoi");
        tbPhieunhap.addColumn("TongTien");
        tbPhieunhap.addColumn("NgayNhap");
        tbPhieunhap.addColumn("ChuThich");

        for (int i = 0; i < lstPhieuNhap.size(); i++) {
            PhieuNhap ph = lstPhieuNhap.get(i);
            Vector row = new Vector<>();
            row.add(ph.getMaPhieuNhap());
            row.add(ph.getMaNhanVien());
            row.add(ph.getMaNhaPhanPhoi());
            row.add(ph.getTongTien());
            row.add(ph.getNgayNhap());
            row.add(ph.getChuThich());
            tbPhieunhap.addRow(row);
        }
        jTablePhieuNhap.setModel(tbPhieunhap);
    }

    public void loadPhieuNhapChiTiet(int MaPhieuNhap) {
        PhieuNhapChiTietDAO dao = new PhieuNhapChiTietDAO();
        lstPhieuNhapChiTiet = dao.read(MaPhieuNhap);
        DefaultTableModel dtm = new DefaultTableModel();

        dtm.addColumn("MaCTPN");
        dtm.addColumn("MaPhieuNhap");
        dtm.addColumn("MaSanPham");
        dtm.addColumn("SoLuong");
        dtm.addColumn("TongTien");
        dtm.addColumn("ChuThich");

        for (int i = 0; i < lstPhieuNhapChiTiet.size(); i++) {
            PhieuNhapChiTiet phct = lstPhieuNhapChiTiet.get(i);

            Vector row = new Vector<>();
            row.add(phct.getMaCTPN());
            row.add(phct.getMaPhieuNhap());
            row.add(phct.getMaSanPham());
            row.add(phct.getSoLuong());
            row.add(phct.getTongTien());
            row.add(phct.getChuThich());

            dtm.addRow(row);
        }
        jTableChiTietPhieuNhap.setModel(dtm);
    }

    private void loadKH() {
        //hiển thị bảng khách hàng và load giá tri từ csdl
        KhachHangCRUD crud = new KhachHangCRUD();
        khachmhang = crud.selectKH();
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("ID");
        dtm.addColumn("Tên Khách Hàng");
        dtm.addColumn("Ngày Sinh");
        dtm.addColumn("Giới Tính");
        dtm.addColumn("Địa Chỉ");
        dtm.addColumn("Số Điện Thoại");
        dtm.addColumn("Loại Khách Hàng");
        dtm.addColumn("Ghi Chú");
        for (int i = 0; i < khachmhang.size(); i++) {
            KhachHang get = khachmhang.get(i);
            Vector row = new Vector<>();
            row.add(get.getId());
            row.add(get.getHoten());
            row.add(get.getNgaysinh());
            boolean kt;
            if (get.getGioitinh() == 1) {
                row.add(get.gioitinhnam());
                kt = true;
            } else {
                row.add(get.gioitinhnu());
                kt = false;
            }
            row.add(get.getDiachi());
            row.add(get.getDienthoai());
            row.add(get.getTenloaiKH());
            row.add(get.getGhichu());
            dtm.addRow(row);
        }
        jTableKhachHang1.setModel(dtm);
    }

//hiển thị loại khách hàng trên combobox khách hàng
    private void loadLoaiKH() {
        LoaiKhachHangCRUD crud = new LoaiKhachHangCRUD();
        loadmKh = crud.select_LoaiKH();
        DefaultComboBoxModel<LoaiKhachHang> dcbm = new DefaultComboBoxModel();
        for (int i = 0; i < loadmKh.size(); i++) {
            LoaiKhachHang st = loadmKh.get(i);
            dcbm.addElement(st);
        }
        jComboBoxLoaiKH.setModel(dcbm);
    }

    //load combobox 
    public void loadChucVuCombo() {
        ChucVuDAO dao = new ChucVuDAO();
        lstChucVu = dao.read();
        DefaultComboBoxModel<ChucVu> combo = new DefaultComboBoxModel();
        for (int i = 0; i < lstChucVu.size(); i++) {
            ChucVu cv = lstChucVu.get(i);
            combo.addElement(cv);
        }
        jComboBoxChucVu.setModel(combo);

    }

    //load combobox Nhân Viên - Phiếu nhập
    public void loadNhanVienCombo() {
        NhanVienDAO dao = new NhanVienDAO();
        lstNhanVien = dao.read();
        DefaultComboBoxModel<NhanVien> combo = new DefaultComboBoxModel();
        for (int i = 0; i < lstNhanVien.size(); i++) {
            NhanVien nv = lstNhanVien.get(i);
            combo.addElement(nv);
        }
        jComboBoxNhanVien.setModel(combo);

    }

    //loadNhanVien
    public void loadNhanVien() {
        NhanVienDAO dao = new NhanVienDAO();
        lstNhanVien = dao.read();
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("MaNhanVien");
        dtm.addColumn("TenNhanVien");
        dtm.addColumn("NgaySinh");
        dtm.addColumn("GioiTinh");
        dtm.addColumn("NgayVaoLam");
        dtm.addColumn("ChucVu");
        dtm.addColumn("DiaChi");
        dtm.addColumn("SDT");
        dtm.addColumn("GhiChu");
        for (int i = 0; i < lstNhanVien.size(); i++) {
            NhanVien nv = lstNhanVien.get(i);
            Vector row = new Vector<>();
            row.add(nv.getMaNhanVien());
            row.add(nv.getTenNhanVien());
            row.add(nv.getNgaySinh());
            // row.add(nv.isGioiTinh());
            boolean kt;
            if (nv.isGioiTinh() == true) {
                row.add(nv.gioitinhnam());
                kt = true;
            } else {
                row.add(nv.gioitinhnu());
                kt = false;
            }
            row.add(nv.getNgayVaoLam());
            row.add(nv.getTenChucVu());
            row.add(nv.getDiaChi());
            row.add(nv.getSDT());
            row.add(nv.getGhiChu());
            dtm.addRow(row);
        }
        jTableDanhSachNhanVien.setModel(dtm);
    }

    //load chức vụ
    public void loadChucVu() {
        ChucVuDAO dao = new ChucVuDAO();
        lstChucVu = dao.read();
        DefaultTableModel dtmDanhMuc = new DefaultTableModel();
        dtmDanhMuc.addColumn("Mã Chức Vụ");
        dtmDanhMuc.addColumn("Tên Chức Vụ");
        dtmDanhMuc.addColumn("Ghi Chú");

        for (int i = 0; i < lstChucVu.size(); i++) {
            ChucVu cv = lstChucVu.get(i);
            Vector row = new Vector<>();
            row.add(cv.getMaChucVu());
            row.add(cv.getTenChucVu());
            row.add(cv.getGhiChu());
            dtmDanhMuc.addRow(row);
        }
        //jTablePhanQuyen.setModel(dtmDanhMuc);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupGioiTinh = new javax.swing.ButtonGroup();
        buttonGroupSanPham = new javax.swing.ButtonGroup();
        buttonGroupGioiTinhNV = new javax.swing.ButtonGroup();
        jTabbedPaneMinishop = new javax.swing.JTabbedPane();
        jPanelDoanhThu = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jTextFieldTTongDoanhSo = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        jTextFieldTTongDon = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        jTextFieldTTongSP = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jComboBoxSapXepThoiGian = new javax.swing.JComboBox();
        jButtonCheckTongQuan = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane24 = new javax.swing.JScrollPane();
        jTableSPBanChay = new javax.swing.JTable();
        jPanel30 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jPanelHangHoa = new javax.swing.JPanel();
        jPaneHangHoa = new javax.swing.JTabbedPane();
        jPanelSanPham = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldMaSP = new javax.swing.JTextField();
        jTextFieldTenSP = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxLoaiSP = new javax.swing.JComboBox();
        jTextFieldGiaNhap = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldGiaBan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxHangSanXuat = new javax.swing.JComboBox();
        jTextFieldTonKho = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPaneChuThich = new javax.swing.JTextPane();
        jPanel6 = new javax.swing.JPanel();
        jButtonXoaSP = new javax.swing.JButton();
        jButtonRefeshSanPham = new javax.swing.JButton();
        jButtonSuaSanPham = new javax.swing.JButton();
        jButtonThemSP = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jRadioButtonHienSP = new javax.swing.JRadioButton();
        jRadioButtonAnSP = new javax.swing.JRadioButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtableHangHoa = new javax.swing.JTable();
        jLabel79 = new javax.swing.JLabel();
        jTextFieldTimSP = new javax.swing.JTextField();
        jButtonTimKiem = new javax.swing.JButton();
        jPanelDanhMuc = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDanhMuc = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableDanhMuc_SanPham = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldTimKiemDanhMuc = new javax.swing.JTextField();
        jButtonTimKiemDanhMuc = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jTextFieldMaDanhMuc = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldTenDanhMuc = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jButtonXoaDanhMuc = new javax.swing.JButton();
        jButtonRefeshDanhMuc = new javax.swing.JButton();
        jButtonSuaDanhMuc = new javax.swing.JButton();
        jButtonThemDanhMuc = new javax.swing.JButton();
        CTPN = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTablePhieuNhap = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTableChiTietPhieuNhap = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jComboBoxSanPhamx = new javax.swing.JComboBox();
        jLabel34 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel17 = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        txtNgayNhapPhieuNhap = new javax.swing.JTextField();
        jTextField43 = new javax.swing.JTextField();
        txtTongTienPhieuNhap = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jPanel15 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jComboBoxNhanVien = new javax.swing.JComboBox();
        jButton14 = new javax.swing.JButton();
        jTextField45 = new javax.swing.JTextField();
        jPanelNhanVien = new javax.swing.JPanel();
        jTabbedPaneNhanVien = new javax.swing.JTabbedPane();
        JPanelNhanVien = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTableDanhSachNhanVien = new javax.swing.JTable();
        jPanel22 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jTextFieldMaNV = new javax.swing.JTextField();
        jTextFieldTenNV = new javax.swing.JTextField();
        jRadioButtonNamNV = new javax.swing.JRadioButton();
        jRadioButtonNuNV = new javax.swing.JRadioButton();
        jTextFieldDiaChiNV = new javax.swing.JTextField();
        jTextFieldSDTNV = new javax.swing.JTextField();
        jScrollPane16 = new javax.swing.JScrollPane();
        jTextAreaGhiChuNV = new javax.swing.JTextArea();
        jComboBoxChucVu = new javax.swing.JComboBox();
        jPanel13 = new javax.swing.JPanel();
        jButtonXoaNV = new javax.swing.JButton();
        jButtonRefeshNV = new javax.swing.JButton();
        jButtonSuaNV = new javax.swing.JButton();
        jButtonThemNV = new javax.swing.JButton();
        jLabel81 = new javax.swing.JLabel();
        jButtonTimKiemNV = new javax.swing.JButton();
        jTextFieldTimKiemNV = new javax.swing.JTextField();
        jPanelTaiKhoan = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jTextField34 = new javax.swing.JTextField();
        jTextField35 = new javax.swing.JTextField();
        jTextField36 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jComboBox10 = new javax.swing.JComboBox<>();
        jScrollPane18 = new javax.swing.JScrollPane();
        jTextArea7 = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jButton36 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jTextField33 = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        jPanelPhanQuyen = new javax.swing.JPanel();
        jScrollPane19 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel65 = new javax.swing.JLabel();
        jTextField37 = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jTextField38 = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        jTextArea8 = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jButton40 = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jScrollPane21 = new javax.swing.JScrollPane();
        jTable10 = new javax.swing.JTable();
        jButton44 = new javax.swing.JButton();
        jTextField39 = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jButton45 = new javax.swing.JButton();
        jComboBox11 = new javax.swing.JComboBox<>();
        jButton46 = new javax.swing.JButton();
        jButton47 = new javax.swing.JButton();
        jPanelDoiTac = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTableDoiTac = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabelTenDT = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextFieldMaDT = new javax.swing.JTextField();
        jTextFieldTenDT = new javax.swing.JTextField();
        jTextFieldDiaChiDT = new javax.swing.JTextField();
        jTextFieldSDTDT = new javax.swing.JTextField();
        jTextFieldEmailDT = new javax.swing.JTextField();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTextAreaGhiChuDoiTac = new javax.swing.JTextArea();
        jPanel19 = new javax.swing.JPanel();
        jButtonXoaDoiTac = new javax.swing.JButton();
        jButtonResetDoiTac = new javax.swing.JButton();
        jButtonSuaDoiTac = new javax.swing.JButton();
        jButtonThemDoiTac = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jButton48 = new javax.swing.JButton();
        jTextField40 = new javax.swing.JTextField();
        jPanelHoaDon = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTableHoaDon = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jTextField21 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jPanel20 = new javax.swing.JPanel();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jTextField26 = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jComboBox8 = new javax.swing.JComboBox<>();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jButton49 = new javax.swing.JButton();
        jTextField41 = new javax.swing.JTextField();
        jPanelKhachHang = new javax.swing.JPanel();
        jScrollPane22 = new javax.swing.JScrollPane();
        jTableKhachHang1 = new javax.swing.JTable();
        jPanel25 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jTextFieldMaKH = new javax.swing.JTextField();
        jTextFieldTenKH = new javax.swing.JTextField();
        jRadioButtonNam = new javax.swing.JRadioButton();
        jRadioButtonNu = new javax.swing.JRadioButton();
        jTextFieldDiaChi = new javax.swing.JTextField();
        jTextFieldSDT = new javax.swing.JTextField();
        jComboBoxLoaiKH = new javax.swing.JComboBox();
        jScrollPane23 = new javax.swing.JScrollPane();
        jTextAreaGhiChu = new javax.swing.JTextArea();
        jPanel26 = new javax.swing.JPanel();
        jButtonXoa = new javax.swing.JButton();
        jButtonReset = new javax.swing.JButton();
        jButtonSua = new javax.swing.JButton();
        jButtonThem = new javax.swing.JButton();
        jLabel83 = new javax.swing.JLabel();
        jButtonTimKiemKH = new javax.swing.JButton();
        jTextFieldTimKiemKH = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trang Chủ");

        jTabbedPaneMinishop.setBackground(new java.awt.Color(131, 194, 97));

        jPanel11.setBackground(new java.awt.Color(182, 199, 189));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel29.setBackground(new java.awt.Color(60, 99, 62));

        jTextFieldTTongDoanhSo.setEditable(false);
        jTextFieldTTongDoanhSo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N

        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon24px/coin-us-dollar-icon.png"))); // NOI18N
        jLabel84.setText("Doanh Số");

        jTextFieldTTongDon.setEditable(false);
        jTextFieldTTongDon.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N

        jLabel78.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon24px/Sales-report-icon (1).png"))); // NOI18N
        jLabel78.setText("Đơn");

        jTextFieldTTongSP.setEditable(false);
        jTextFieldTTongSP.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N

        jLabel89.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon24px/shipping-box-icon (2).png"))); // NOI18N
        jLabel89.setText("Sản Phẩm");

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldTTongDon, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                            .addComponent(jTextFieldTTongDoanhSo))
                        .addGap(5, 5, 5))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(jTextFieldTTongSP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel84)
                        .addComponent(jLabel78))
                    .addComponent(jLabel89, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTTongDoanhSo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel84))
                .addGap(54, 54, 54)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTTongDon, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel78))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTTongSP, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        jPanel10.setBackground(new java.awt.Color(115, 164, 20));

        jComboBoxSapXepThoiGian.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "To Day", "Yesterday", "This Month", "Last Month", "1 Year" }));

        jButtonCheckTongQuan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon 16px/check-icon.png"))); // NOI18N
        jButtonCheckTongQuan.setText("Check");
        jButtonCheckTongQuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCheckTongQuanActionPerformed(evt);
            }
        });

        jLabel30.setText("Đến");

        jLabel29.setText("Từ");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(704, Short.MAX_VALUE)
                .addComponent(jLabel29)
                .addGap(158, 158, 158)
                .addComponent(jLabel30)
                .addGap(158, 158, 158)
                .addComponent(jComboBoxSapXepThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCheckTongQuan)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonCheckTongQuan)
                        .addComponent(jComboBoxSapXepThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel30)
                    .addComponent(jLabel29))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel28.setText("Chi Tiết Doanh Thu");
        jPanel12.add(jLabel28);

        jTableSPBanChay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane24.setViewportView(jTableSPBanChay);

        jPanel30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setText("Thông Báo:");
        jPanel27.add(jLabel17);

        jLabel91.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel91.setText("KHÁCH HÀNG LÀ THƯỢNG ĐẾ - TÔN CHỈ CỦA CỬA HÀNG");

        jLabel92.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel92.setText("SẠCH SẼ - SĂN SÓC - SẴN SÀNG -SÀNG LỌC");

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel92)
                    .addComponent(jLabel91))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel91)
                .addGap(27, 27, 27)
                .addComponent(jLabel92)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel90.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel90.setText("Sản Phẩm Bán Chạy");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane24)
                            .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel90)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel90)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane24, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelDoanhThuLayout = new javax.swing.GroupLayout(jPanelDoanhThu);
        jPanelDoanhThu.setLayout(jPanelDoanhThuLayout);
        jPanelDoanhThuLayout.setHorizontalGroup(
            jPanelDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDoanhThuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelDoanhThuLayout.setVerticalGroup(
            jPanelDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDoanhThuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneMinishop.addTab("Doanh Thu", new javax.swing.ImageIcon(getClass().getResource("/icon 64px/wallet-icon.png")), jPanelDoanhThu); // NOI18N

        jPanelHangHoa.setBackground(new java.awt.Color(68, 150, 53));
        jPanelHangHoa.setForeground(new java.awt.Color(255, 255, 255));

        jPaneHangHoa.setBackground(new java.awt.Color(149, 212, 138));

        jPanelSanPham.setBackground(new java.awt.Color(182, 199, 189));

        jPanel23.setBackground(new java.awt.Color(60, 99, 62));
        jPanel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51), 2));
        jPanel23.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mã SP:");

        jTextFieldMaSP.setEditable(false);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tên SP:");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Danh Mục:");

        jComboBoxLoaiSP.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Giá Nhập:");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Giá Bán:");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Hãng SX:");

        jComboBoxHangSanXuat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tồn Kho:");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Ghi Chú:");

        jScrollPane2.setViewportView(jTextPaneChuThich);

        jPanel6.setBackground(new java.awt.Color(60, 99, 62));

        jButtonXoaSP.setText("Xoá");
        jButtonXoaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXoaSPActionPerformed(evt);
            }
        });
        jPanel6.add(jButtonXoaSP);

        jButtonRefeshSanPham.setText("Reset");
        jButtonRefeshSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefeshSanPhamActionPerformed(evt);
            }
        });
        jPanel6.add(jButtonRefeshSanPham);

        jButtonSuaSanPham.setText("Sửa");
        jButtonSuaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuaSanPhamActionPerformed(evt);
            }
        });
        jPanel6.add(jButtonSuaSanPham);

        jButtonThemSP.setText("Thêm");
        jButtonThemSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThemSPActionPerformed(evt);
            }
        });
        jPanel6.add(jButtonThemSP);

        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Trạng Thái:");

        jRadioButtonHienSP.setBackground(new java.awt.Color(60, 99, 62));
        buttonGroupSanPham.add(jRadioButtonHienSP);
        jRadioButtonHienSP.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonHienSP.setText("Hiện");

        jRadioButtonAnSP.setBackground(new java.awt.Color(60, 99, 62));
        buttonGroupSanPham.add(jRadioButtonAnSP);
        jRadioButtonAnSP.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonAnSP.setText("Ẩn");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldTenSP)
                                    .addComponent(jComboBoxLoaiSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldGiaNhap)
                                    .addComponent(jTextFieldGiaBan)
                                    .addComponent(jTextFieldMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBoxHangSanXuat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldTonKho)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jRadioButtonHienSP)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButtonAnSP)))
                        .addGap(0, 27, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1))
                    .addComponent(jTextFieldMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2))
                    .addComponent(jTextFieldTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3))
                    .addComponent(jComboBoxLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4))
                    .addComponent(jTextFieldGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5))
                    .addComponent(jTextFieldGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6))
                    .addComponent(jComboBoxHangSanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7))
                    .addComponent(jTextFieldTonKho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jRadioButtonHienSP)
                    .addComponent(jRadioButtonAnSP))
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtableHangHoa.setAutoCreateRowSorter(true);
        jtableHangHoa.setBackground(new java.awt.Color(153, 182, 134));
        jtableHangHoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtableHangHoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableHangHoaMouseClicked(evt);
            }
        });
        jtableHangHoa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtableHangHoaKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(jtableHangHoa);

        jLabel79.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel79.setText("Danh Sách Sản Phẩm");

        jButtonTimKiem.setText("Tìm Kiếm");
        jButtonTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelSanPhamLayout = new javax.swing.GroupLayout(jPanelSanPham);
        jPanelSanPham.setLayout(jPanelSanPhamLayout);
        jPanelSanPhamLayout.setHorizontalGroup(
            jPanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSanPhamLayout.createSequentialGroup()
                        .addComponent(jLabel79)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldTimSP, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonTimKiem))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 953, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelSanPhamLayout.setVerticalGroup(
            jPanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelSanPhamLayout.createSequentialGroup()
                        .addGroup(jPanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel79)
                            .addGroup(jPanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButtonTimKiem)
                                .addComponent(jTextFieldTimSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
                        .addGap(1, 1, 1)))
                .addContainerGap())
        );

        jPaneHangHoa.addTab("Sản Phẩm", new javax.swing.ImageIcon(getClass().getResource("/icon24px/Containers-icon.png")), jPanelSanPham); // NOI18N

        jPanelDanhMuc.setBackground(new java.awt.Color(182, 199, 189));

        jTableDanhMuc.setBackground(new java.awt.Color(153, 182, 134));
        jTableDanhMuc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableDanhMuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDanhMucMouseClicked(evt);
            }
        });
        jTableDanhMuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableDanhMucKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableDanhMuc);

        jTableDanhMuc_SanPham.setAutoCreateRowSorter(true);
        jTableDanhMuc_SanPham.setBackground(new java.awt.Color(153, 182, 134));
        jTableDanhMuc_SanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTableDanhMuc_SanPham);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Danh Mục");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Sản Phẩm Danh Mục");

        jButtonTimKiemDanhMuc.setText("Tìm Kiếm");
        jButtonTimKiemDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTimKiemDanhMucActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(60, 99, 62));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51), 2));

        jTextFieldMaDanhMuc.setEditable(false);

        jLabel9.setBackground(new java.awt.Color(0, 102, 102));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Mã Danh Mục:");

        jLabel10.setBackground(new java.awt.Color(0, 102, 102));
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Tên Danh Mục:");

        jPanel16.setBackground(new java.awt.Color(60, 99, 62));

        jButtonXoaDanhMuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon24px/Actions-trash-empty-icon.png"))); // NOI18N
        jButtonXoaDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXoaDanhMucActionPerformed(evt);
            }
        });
        jPanel16.add(jButtonXoaDanhMuc);

        jButtonRefeshDanhMuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon24px/Refresh-icon (1).png"))); // NOI18N
        jButtonRefeshDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefeshDanhMucActionPerformed(evt);
            }
        });
        jPanel16.add(jButtonRefeshDanhMuc);

        jButtonSuaDanhMuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon24px/edit-icon.png"))); // NOI18N
        jButtonSuaDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuaDanhMucActionPerformed(evt);
            }
        });
        jPanel16.add(jButtonSuaDanhMuc);

        jButtonThemDanhMuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon24px/user-add-icon.png"))); // NOI18N
        jButtonThemDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThemDanhMucActionPerformed(evt);
            }
        });
        jPanel16.add(jButtonThemDanhMuc);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldTenDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldMaDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldMaDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldTenDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelDanhMucLayout = new javax.swing.GroupLayout(jPanelDanhMuc);
        jPanelDanhMuc.setLayout(jPanelDanhMucLayout);
        jPanelDanhMucLayout.setHorizontalGroup(
            jPanelDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDanhMucLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelDanhMucLayout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldTimKiemDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonTimKiemDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelDanhMucLayout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 957, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelDanhMucLayout.setVerticalGroup(
            jPanelDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDanhMucLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDanhMucLayout.createSequentialGroup()
                        .addGroup(jPanelDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelDanhMucLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButtonTimKiemDanhMuc)
                                .addComponent(jTextFieldTimKiemDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPaneHangHoa.addTab("Danh Mục", new javax.swing.ImageIcon(getClass().getResource("/icon24px/drawer-archive-icon (1).png")), jPanelDanhMuc); // NOI18N

        CTPN.setBackground(new java.awt.Color(182, 199, 189));

        jTablePhieuNhap.setBackground(new java.awt.Color(153, 182, 134));
        jTablePhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane8.setViewportView(jTablePhieuNhap);

        jTableChiTietPhieuNhap.setBackground(new java.awt.Color(153, 182, 134));
        jTableChiTietPhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane9.setViewportView(jTableChiTietPhieuNhap);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setText("Phiếu Nhập");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setText("Chi Tiết Phiếu Nhập");

        jPanel18.setBackground(new java.awt.Color(60, 99, 62));
        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51), 2));

        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Mã CTPN:");

        jTextField15.setEditable(false);
        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField15ActionPerformed(evt);
            }
        });

        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Mã Phiếu Nhập:");

        jTextField16.setEditable(false);

        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Sản Phẩm:");

        jComboBoxSanPhamx.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Số Lượng:");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Tổng Tiền:");

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Ghi Chú:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane5.setViewportView(jTextArea1);

        jPanel17.setBackground(new java.awt.Color(60, 99, 62));
        jPanel17.setForeground(new java.awt.Color(0, 102, 51));

        jButton12.setText("Xoá");
        jPanel17.add(jButton12);

        jButton13.setText("Reset");
        jPanel17.add(jButton13);

        jButton11.setText("Sửa");
        jPanel17.add(jButton11);

        jButton10.setText("Thêm");
        jPanel17.add(jButton10);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField19, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField17, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxSanPhamx, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField16, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField15, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jComboBoxSanPhamx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(60, 99, 62));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51), 2));

        jLabel85.setForeground(new java.awt.Color(255, 255, 255));
        jLabel85.setText("Mã Phiếu Nhập:");

        jLabel86.setForeground(new java.awt.Color(255, 255, 255));
        jLabel86.setText("Nhân Viên:");

        jLabel87.setForeground(new java.awt.Color(255, 255, 255));
        jLabel87.setText("Ngày Nhập:");

        jLabel88.setForeground(new java.awt.Color(255, 255, 255));
        jLabel88.setText("Nhà Cung Cấp:");

        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Tổng Tiền:");

        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Ghi Chú:");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane6.setViewportView(jTextArea2);

        jPanel15.setBackground(new java.awt.Color(60, 99, 62));

        jButton6.setText("Xoá");
        jPanel15.add(jButton6);

        jButton7.setText("Refesh");
        jPanel15.add(jButton7);

        jButton8.setText("Sửa");
        jPanel15.add(jButton8);

        jButton9.setText("Thêm");
        jPanel15.add(jButton9);

        jComboBoxNhanVien.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel85, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel86, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel87, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel88, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNgayNhapPhieuNhap)
                    .addComponent(jTextField43)
                    .addComponent(txtTongTienPhieuNhap, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jTextField12)
                    .addComponent(jComboBoxNhanVien, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel85)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel86)
                    .addComponent(jComboBoxNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel87)
                    .addComponent(txtNgayNhapPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel88)
                    .addComponent(jTextField43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtTongTienPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton14.setText("Tìm Kiếm");

        javax.swing.GroupLayout CTPNLayout = new javax.swing.GroupLayout(CTPN);
        CTPN.setLayout(CTPNLayout);
        CTPNLayout.setHorizontalGroup(
            CTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CTPNLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CTPNLayout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane9)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 957, Short.MAX_VALUE)
                    .addGroup(CTPNLayout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField45, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton14)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        CTPNLayout.setVerticalGroup(
            CTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CTPNLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CTPNLayout.createSequentialGroup()
                        .addGroup(CTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addGroup(CTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton14)
                                .addComponent(jTextField45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CTPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(11, 11, 11))
        );

        jPaneHangHoa.addTab("Phiếu Nhập Hàng", new javax.swing.ImageIcon(getClass().getResource("/icon24px/checklist-icon.png")), CTPN); // NOI18N

        javax.swing.GroupLayout jPanelHangHoaLayout = new javax.swing.GroupLayout(jPanelHangHoa);
        jPanelHangHoa.setLayout(jPanelHangHoaLayout);
        jPanelHangHoaLayout.setHorizontalGroup(
            jPanelHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPaneHangHoa)
        );
        jPanelHangHoaLayout.setVerticalGroup(
            jPanelHangHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPaneHangHoa)
        );

        jTabbedPaneMinishop.addTab("Hàng Hoá", new javax.swing.ImageIcon(getClass().getResource("/icon 64px/shopping-basket-icon.png")), jPanelHangHoa); // NOI18N

        jPanelNhanVien.setBackground(new java.awt.Color(149, 212, 138));
        jPanelNhanVien.setForeground(new java.awt.Color(255, 255, 255));

        jTabbedPaneNhanVien.setBackground(new java.awt.Color(149, 212, 138));

        JPanelNhanVien.setBackground(new java.awt.Color(182, 199, 189));

        jTableDanhSachNhanVien.setAutoCreateRowSorter(true);
        jTableDanhSachNhanVien.setBackground(new java.awt.Color(153, 182, 134));
        jTableDanhSachNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableDanhSachNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDanhSachNhanVienMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTableDanhSachNhanVien);

        jPanel22.setBackground(new java.awt.Color(60, 99, 62));
        jPanel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51), 2));

        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Mã Nhân Viên:");

        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Tên Nhân Viên:");

        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Ngày Sinh:");

        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Giới Tính:");

        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Địa Chỉ:");

        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("SDT:");

        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("Ngày Vào Làm:");

        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("Chức Vụ:");

        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("Ghi Chú:");

        jTextFieldMaNV.setEditable(false);

        jTextFieldTenNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTenNVActionPerformed(evt);
            }
        });

        jRadioButtonNamNV.setBackground(new java.awt.Color(60, 99, 62));
        buttonGroupGioiTinhNV.add(jRadioButtonNamNV);
        jRadioButtonNamNV.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonNamNV.setText("Nam");

        jRadioButtonNuNV.setBackground(new java.awt.Color(60, 99, 62));
        buttonGroupGioiTinhNV.add(jRadioButtonNuNV);
        jRadioButtonNuNV.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonNuNV.setText("Nữ");

        jTextAreaGhiChuNV.setColumns(20);
        jTextAreaGhiChuNV.setRows(5);
        jScrollPane16.setViewportView(jTextAreaGhiChuNV);

        jComboBoxChucVu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPanel13.setBackground(new java.awt.Color(60, 99, 62));

        jButtonXoaNV.setText("Xoá");
        jButtonXoaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXoaNVActionPerformed(evt);
            }
        });
        jPanel13.add(jButtonXoaNV);

        jButtonRefeshNV.setText("Reset");
        jPanel13.add(jButtonRefeshNV);

        jButtonSuaNV.setText("Sửa");
        jButtonSuaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuaNVActionPerformed(evt);
            }
        });
        jPanel13.add(jButtonSuaNV);

        jButtonThemNV.setText("Thêm");
        jButtonThemNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThemNVActionPerformed(evt);
            }
        });
        jPanel13.add(jButtonThemNV);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel58, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel57, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel56, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel55, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel54, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel53, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel52, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel51, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel50, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBoxChucVu, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldSDTNV, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldDiaChiNV, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldTenNV, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldMaNV, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jRadioButtonNamNV)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonNuNV))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(jTextFieldMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(jTextFieldTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jLabel52)
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(jRadioButtonNamNV)
                    .addComponent(jRadioButtonNuNV))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(jTextFieldDiaChiNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(jTextFieldSDTNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel56)
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(jComboBoxChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel58)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(212, Short.MAX_VALUE))
        );

        jLabel81.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel81.setText("Danh Sách Nhân Viên");

        jButtonTimKiemNV.setText("Tìm Kiếm");

        javax.swing.GroupLayout JPanelNhanVienLayout = new javax.swing.GroupLayout(JPanelNhanVien);
        JPanelNhanVien.setLayout(JPanelNhanVienLayout);
        JPanelNhanVienLayout.setHorizontalGroup(
            JPanelNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPanelNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelNhanVienLayout.createSequentialGroup()
                        .addComponent(jLabel81)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldTimKiemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonTimKiemNV))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 957, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        JPanelNhanVienLayout.setVerticalGroup(
            JPanelNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPanelNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(JPanelNhanVienLayout.createSequentialGroup()
                        .addGroup(JPanelNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel81)
                            .addGroup(JPanelNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButtonTimKiemNV)
                                .addComponent(jTextFieldTimKiemNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane7))
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPaneNhanVien.addTab("Nhân Viên", new javax.swing.ImageIcon(getClass().getResource("/icon24px/Arab-Boss-icon.png")), JPanelNhanVien); // NOI18N

        jPanelTaiKhoan.setBackground(new java.awt.Color(182, 199, 189));

        jTable8.setBackground(new java.awt.Color(153, 182, 134));
        jTable8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane17.setViewportView(jTable8);

        jPanel2.setBackground(new java.awt.Color(60, 99, 62));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51), 2));

        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("ID");

        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("Tên Nhân Viên:");

        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("Username:");

        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setText("Password:");

        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setText("Quyền:");

        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setText("Chú Thích:");

        jTextField34.setEditable(false);

        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextArea7.setColumns(20);
        jTextArea7.setRows(5);
        jScrollPane18.setViewportView(jTextArea7);

        jPanel3.setBackground(new java.awt.Color(60, 99, 62));

        jButton36.setText("Thêm");
        jPanel3.add(jButton36);

        jButton37.setText("Sửa");
        jPanel3.add(jButton37);

        jButton38.setText("Reset");
        jPanel3.add(jButton38);

        jButton39.setText("Xoá");
        jPanel3.add(jButton39);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel59)
                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61)
                    .addComponent(jLabel62)
                    .addComponent(jLabel63)
                    .addComponent(jLabel64))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jComboBox10, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField36, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField35, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField34, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addContainerGap(13, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel64)
                    .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton35.setText("Tìm Kiếm");

        jLabel82.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel82.setText("Danh Sách Tài Khoản");

        javax.swing.GroupLayout jPanelTaiKhoanLayout = new javax.swing.GroupLayout(jPanelTaiKhoan);
        jPanelTaiKhoan.setLayout(jPanelTaiKhoanLayout);
        jPanelTaiKhoanLayout.setHorizontalGroup(
            jPanelTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTaiKhoanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTaiKhoanLayout.createSequentialGroup()
                        .addComponent(jLabel82)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton35))
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 957, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelTaiKhoanLayout.setVerticalGroup(
            jPanelTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTaiKhoanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTaiKhoanLayout.createSequentialGroup()
                        .addGroup(jPanelTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel82)
                            .addGroup(jPanelTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton35)
                                .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPaneNhanVien.addTab("Tài Khoản", new javax.swing.ImageIcon(getClass().getResource("/icon24px/Users-icon.png")), jPanelTaiKhoan); // NOI18N

        jPanelPhanQuyen.setBackground(new java.awt.Color(182, 199, 189));

        jTable9.setBackground(new java.awt.Color(153, 182, 134));
        jTable9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane19.setViewportView(jTable9);

        jPanel4.setBackground(new java.awt.Color(60, 99, 62));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51), 2));

        jLabel65.setBackground(new java.awt.Color(0, 51, 51));
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setText("Mã Chức Vụ:");

        jTextField37.setEditable(false);

        jLabel66.setBackground(new java.awt.Color(0, 51, 51));
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setText("Tên Chức Vụ:");

        jLabel67.setBackground(new java.awt.Color(0, 51, 51));
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setText("Ghi Chú:");

        jTextArea8.setColumns(20);
        jTextArea8.setRows(5);
        jScrollPane20.setViewportView(jTextArea8);

        jPanel5.setBackground(new java.awt.Color(60, 99, 62));

        jButton40.setText("Thêm");
        jPanel5.add(jButton40);

        jButton41.setText("Sửa");
        jPanel5.add(jButton41);

        jButton42.setText("Reset");
        jPanel5.add(jButton42);

        jButton43.setText("Xoá");
        jPanel5.add(jButton43);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel65)
                            .addComponent(jLabel66)
                            .addComponent(jLabel67))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField37, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField38, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane20, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                        .addGap(65, 65, 65))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65)
                    .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66)
                    .addComponent(jTextField38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel67)
                    .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );

        jTable10.setBackground(new java.awt.Color(153, 182, 134));
        jTable10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane21.setViewportView(jTable10);

        jButton44.setText("Tìm Nhân Viên");

        jLabel68.setBackground(new java.awt.Color(0, 51, 51));
        jLabel68.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel68.setText("Chức Vụ");

        jLabel69.setBackground(new java.awt.Color(0, 51, 51));
        jLabel69.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel69.setText("Nhân Viên");

        jPanel24.setBackground(new java.awt.Color(60, 99, 62));
        jPanel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51), 2));

        jButton45.setText("Đổi Mã Chức Vụ");

        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton46.setText("Xoá Nếu Rỗng");

        jButton47.setText("Ẩn ĐI");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox11, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton47, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton45)
                    .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton46)
                    .addComponent(jButton47))
                .addContainerGap(122, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelPhanQuyenLayout = new javax.swing.GroupLayout(jPanelPhanQuyen);
        jPanelPhanQuyen.setLayout(jPanelPhanQuyenLayout);
        jPanelPhanQuyenLayout.setHorizontalGroup(
            jPanelPhanQuyenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPhanQuyenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPhanQuyenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPhanQuyenLayout.createSequentialGroup()
                        .addComponent(jLabel69)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField39, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton44))
                    .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 957, Short.MAX_VALUE)
                    .addGroup(jPanelPhanQuyenLayout.createSequentialGroup()
                        .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 875, Short.MAX_VALUE))
                    .addComponent(jScrollPane19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPhanQuyenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelPhanQuyenLayout.setVerticalGroup(
            jPanelPhanQuyenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPhanQuyenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel68)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPhanQuyenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addGroup(jPanelPhanQuyenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelPhanQuyenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton44)))
                .addGap(13, 13, 13)
                .addGroup(jPanelPhanQuyenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPaneNhanVien.addTab("Phân Quyền", new javax.swing.ImageIcon(getClass().getResource("/icon24px/Keys-icon.png")), jPanelPhanQuyen); // NOI18N

        javax.swing.GroupLayout jPanelNhanVienLayout = new javax.swing.GroupLayout(jPanelNhanVien);
        jPanelNhanVien.setLayout(jPanelNhanVienLayout);
        jPanelNhanVienLayout.setHorizontalGroup(
            jPanelNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneNhanVien)
        );
        jPanelNhanVienLayout.setVerticalGroup(
            jPanelNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneNhanVien, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jTabbedPaneMinishop.addTab("Nhân Viên", new javax.swing.ImageIcon(getClass().getResource("/icon 64px/Groups-Meeting-Light-icon.png")), jPanelNhanVien); // NOI18N

        jPanelDoiTac.setBackground(new java.awt.Color(182, 199, 189));
        jPanelDoiTac.setForeground(new java.awt.Color(255, 255, 255));

        jTableDoiTac.setAutoCreateRowSorter(true);
        jTableDoiTac.setBackground(new java.awt.Color(153, 182, 134));
        jTableDoiTac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableDoiTac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableDoiTacMouseClicked(evt);
            }
        });
        jTableDoiTac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableDoiTacKeyReleased(evt);
            }
        });
        jScrollPane10.setViewportView(jTableDoiTac);

        jPanel1.setBackground(new java.awt.Color(60, 99, 62));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51), 2));

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Mã Đối Tác:");

        jLabelTenDT.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTenDT.setText("Tên Đối Tác:");

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Địa chỉ:");

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("SDT:");

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Email:");

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Ghi chú:");

        jTextFieldTenDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTenDTActionPerformed(evt);
            }
        });

        jTextFieldSDTDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSDTDTActionPerformed(evt);
            }
        });

        jTextFieldEmailDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEmailDTActionPerformed(evt);
            }
        });

        jTextAreaGhiChuDoiTac.setColumns(20);
        jTextAreaGhiChuDoiTac.setRows(5);
        jScrollPane11.setViewportView(jTextAreaGhiChuDoiTac);

        jPanel19.setBackground(new java.awt.Color(60, 99, 62));

        jButtonXoaDoiTac.setText("Xoá");
        jButtonXoaDoiTac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXoaDoiTacActionPerformed(evt);
            }
        });
        jPanel19.add(jButtonXoaDoiTac);

        jButtonResetDoiTac.setText("Reset");
        jPanel19.add(jButtonResetDoiTac);

        jButtonSuaDoiTac.setText("Sửa");
        jButtonSuaDoiTac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuaDoiTacActionPerformed(evt);
            }
        });
        jPanel19.add(jButtonSuaDoiTac);

        jButtonThemDoiTac.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonThemDoiTac.setText("THÊM");
        jButtonThemDoiTac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThemDoiTacActionPerformed(evt);
            }
        });
        jPanel19.add(jButtonThemDoiTac);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTenDT)
                    .addComponent(jLabel16)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldMaDT)
                    .addComponent(jTextFieldTenDT)
                    .addComponent(jTextFieldDiaChiDT)
                    .addComponent(jTextFieldSDTDT)
                    .addComponent(jTextFieldEmailDT)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextFieldMaDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTenDT)
                    .addComponent(jTextFieldTenDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jTextFieldDiaChiDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jTextFieldSDTDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jTextFieldEmailDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(246, 232, 177));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel15.setForeground(new java.awt.Color(204, 0, 0));
        jLabel15.setText("Ghi chú: Nếu muốn xoá nhà cung cấp thì phải chú ý đến các sản phẩm đã thêm...");
        jPanel9.add(jLabel15);

        jLabel80.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 255, 255));
        jLabel80.setText("Danh Sách Đối Tác");

        jButton48.setText("Tìm Kiếm");

        javax.swing.GroupLayout jPanelDoiTacLayout = new javax.swing.GroupLayout(jPanelDoiTac);
        jPanelDoiTac.setLayout(jPanelDoiTacLayout);
        jPanelDoiTacLayout.setHorizontalGroup(
            jPanelDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDoiTacLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDoiTacLayout.createSequentialGroup()
                        .addComponent(jLabel80)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField40, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton48))
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 995, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelDoiTacLayout.setVerticalGroup(
            jPanelDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDoiTacLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDoiTacLayout.createSequentialGroup()
                        .addGroup(jPanelDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel80)
                            .addGroup(jPanelDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton48)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPaneMinishop.addTab("Đối Tác", new javax.swing.ImageIcon(getClass().getResource("/icon 64px/Container-Ship-Left-Red-icon.png")), jPanelDoiTac); // NOI18N

        jPanelHoaDon.setBackground(new java.awt.Color(182, 199, 189));
        jPanelHoaDon.setForeground(new java.awt.Color(255, 255, 255));

        jTableHoaDon.setBackground(new java.awt.Color(153, 182, 134));
        jTableHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane12.setViewportView(jTableHoaDon);

        jPanel14.setBackground(new java.awt.Color(60, 99, 62));
        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51), 2));

        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Mã Hoá Đơn:");

        jTextField20.setEditable(false);

        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Nhân Viên:");

        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Khách Hàng:");

        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Ngày Lập:");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Ghi Chú:");

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jScrollPane14.setViewportView(jTextArea4);

        jPanel20.setBackground(new java.awt.Color(60, 99, 62));

        jButton22.setText("Xoá");
        jPanel20.add(jButton22);

        jButton23.setText("Reset");
        jPanel20.add(jButton23);

        jButton24.setText("Sửa");
        jPanel20.add(jButton24);

        jButton25.setText("THÊM");
        jPanel20.add(jButton25);

        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Mã CTHD:");

        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Mã Hoá Đơn:");

        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Sản Phẩm:");

        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Tổng Tiền:");

        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Số Lượng:");

        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Thành Tiền:");

        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Ghi Chú:");

        jTextField23.setEditable(false);

        jTextField24.setEditable(false);

        jPanel21.setBackground(new java.awt.Color(60, 99, 62));

        jButton26.setText("Xoá");
        jPanel21.add(jButton26);

        jButton27.setText("Reset");
        jPanel21.add(jButton27);

        jButton28.setText("Sửa");
        jPanel21.add(jButton28);

        jButton29.setText("Thêm");
        jPanel21.add(jButton29);

        jTextArea5.setColumns(20);
        jTextArea5.setRows(5);
        jScrollPane15.setViewportView(jTextArea5);

        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Thêm Hoá Đơn");

        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Thêm SP Vào Hoá Đơn");

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel42, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel49)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(jTextField27, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextField26, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jComboBox8, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField24, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextField23, javax.swing.GroupLayout.Alignment.TRAILING))))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel48)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField22)
                                .addComponent(jTextField21, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jComboBox4, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField20, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel47)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTable6.setAutoCreateRowSorter(true);
        jTable6.setBackground(new java.awt.Color(153, 182, 134));
        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane13.setViewportView(jTable6);

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setText("Chi Tiết Hoá Đơn");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel35.setText("Hoá Đơn");

        jButton49.setText("Tìm Kiếm");

        javax.swing.GroupLayout jPanelHoaDonLayout = new javax.swing.GroupLayout(jPanelHoaDon);
        jPanelHoaDon.setLayout(jPanelHoaDonLayout);
        jPanelHoaDonLayout.setHorizontalGroup(
            jPanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelHoaDonLayout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField41, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89))
                    .addGroup(jPanelHoaDonLayout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 831, Short.MAX_VALUE))
                    .addGroup(jPanelHoaDonLayout.createSequentialGroup()
                        .addGroup(jPanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE)
                            .addComponent(jScrollPane13)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHoaDonLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton49, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelHoaDonLayout.setVerticalGroup(
            jPanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelHoaDonLayout.createSequentialGroup()
                        .addGroup(jPanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addGroup(jPanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton49)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPaneMinishop.addTab("Hoá Đơn", new javax.swing.ImageIcon(getClass().getResource("/icon 64px/Sales-report-icon.png")), jPanelHoaDon); // NOI18N

        jPanelKhachHang.setBackground(new java.awt.Color(182, 199, 189));
        jPanelKhachHang.setForeground(new java.awt.Color(255, 255, 255));

        jTableKhachHang1.setBackground(new java.awt.Color(153, 182, 134));
        jTableKhachHang1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableKhachHang1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableKhachHang1MouseClicked(evt);
            }
        });
        jTableKhachHang1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableKhachHang1KeyReleased(evt);
            }
        });
        jScrollPane22.setViewportView(jTableKhachHang1);

        jPanel25.setBackground(new java.awt.Color(60, 99, 62));
        jPanel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51), 2));

        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setText("Mã KH:");

        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setText("Tên KH:");

        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setText("Ngày Sinh:");

        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setText("GIới Tính:");

        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setText("Địa chỉ:");

        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setText("SDT:");

        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setText("Loại KH:");

        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setText("Ghi Chú:");

        jTextFieldMaKH.setEditable(false);

        jRadioButtonNam.setBackground(new java.awt.Color(60, 99, 62));
        buttonGroupGioiTinh.add(jRadioButtonNam);
        jRadioButtonNam.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonNam.setText("Nam");

        jRadioButtonNu.setBackground(new java.awt.Color(60, 99, 62));
        buttonGroupGioiTinh.add(jRadioButtonNu);
        jRadioButtonNu.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonNu.setText("Nữ");

        jComboBoxLoaiKH.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextAreaGhiChu.setColumns(20);
        jTextAreaGhiChu.setRows(5);
        jScrollPane23.setViewportView(jTextAreaGhiChu);

        jPanel26.setBackground(new java.awt.Color(60, 99, 62));
        jPanel26.setForeground(new java.awt.Color(0, 102, 0));

        jButtonXoa.setBackground(new java.awt.Color(255, 255, 255));
        jButtonXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon24px/Actions-trash-empty-icon.png"))); // NOI18N
        jButtonXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXoaActionPerformed(evt);
            }
        });
        jPanel26.add(jButtonXoa);

        jButtonReset.setBackground(new java.awt.Color(255, 255, 255));
        jButtonReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon24px/Refresh-icon (1).png"))); // NOI18N
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });
        jPanel26.add(jButtonReset);

        jButtonSua.setBackground(new java.awt.Color(255, 255, 255));
        jButtonSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon24px/edit-icon.png"))); // NOI18N
        jButtonSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSuaActionPerformed(evt);
            }
        });
        jPanel26.add(jButtonSua);

        jButtonThem.setBackground(new java.awt.Color(255, 255, 255));
        jButtonThem.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon24px/add-contact-icon.png"))); // NOI18N
        jButtonThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThemActionPerformed(evt);
            }
        });
        jPanel26.add(jButtonThem);

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel77, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel70, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel71, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel72, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel73, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel74, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel75, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel76, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextFieldSDT, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldDiaChi, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldTenKH, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel25Layout.createSequentialGroup()
                        .addComponent(jRadioButtonNam, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonNu))
                    .addComponent(jTextFieldMaKH, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane23)
                    .addComponent(jComboBoxLoaiKH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
            .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(jTextFieldMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel71)
                    .addComponent(jTextFieldTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel72)
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel73)
                    .addComponent(jRadioButtonNam)
                    .addComponent(jRadioButtonNu))
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel74)
                    .addComponent(jTextFieldDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel75)
                    .addComponent(jTextFieldSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel76)
                    .addComponent(jComboBoxLoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel77)
                    .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(255, Short.MAX_VALUE))
        );

        jLabel83.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel83.setText("Danh Sách Khách Hàng");

        jButtonTimKiemKH.setText("Tìm Kiếm");
        jButtonTimKiemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTimKiemKHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelKhachHangLayout = new javax.swing.GroupLayout(jPanelKhachHang);
        jPanelKhachHang.setLayout(jPanelKhachHangLayout);
        jPanelKhachHangLayout.setHorizontalGroup(
            jPanelKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelKhachHangLayout.createSequentialGroup()
                        .addComponent(jLabel83)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldTimKiemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonTimKiemKH))
                    .addComponent(jScrollPane22, javax.swing.GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelKhachHangLayout.setVerticalGroup(
            jPanelKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelKhachHangLayout.createSequentialGroup()
                        .addGroup(jPanelKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel83)
                            .addGroup(jPanelKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButtonTimKiemKH)
                                .addComponent(jTextFieldTimKiemKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane22, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPaneMinishop.addTab("Khách Hàng", new javax.swing.ImageIcon(getClass().getResource("/icon 64px/Users-icon.png")), jPanelKhachHang); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneMinishop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPaneMinishop, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jTextField15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15ActionPerformed

    private void jTextFieldTenDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTenDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTenDTActionPerformed

    private void jTextFieldSDTDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSDTDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSDTDTActionPerformed

    private void jTextFieldEmailDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEmailDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEmailDTActionPerformed

    private void jTextFieldTenNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTenNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTenNVActionPerformed

    private void jButtonSuaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuaSanPhamActionPerformed
        // sửa sản phẩm
        if (JOptionPane.showConfirmDialog(null, "Sửa nhé ??", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            LoaiSanPham lsp = (LoaiSanPham) jComboBoxLoaiSP.getSelectedItem();
            HangSanXuat lsx = (HangSanXuat) jComboBoxHangSanXuat.getSelectedItem();
            String TenSanPham = jTextFieldTenSP.getText();
            float GiaNhap = Float.parseFloat(jTextFieldGiaNhap.getText());
            float GiaBan = Float.parseFloat(jTextFieldGiaBan.getText());
            int TonKho = Integer.parseInt(jTextFieldTonKho.getText());
            String ChuThich = jTextPaneChuThich.getText();
            boolean kt;
            if (jRadioButtonHienSP.isSelected() == true) {
                kt = true;
            } else if (jRadioButtonAnSP.isSelected() == false) {
                kt = false;
            } else {
                kt = false;
            }
            HangHoa hh = new HangHoa(MaHangHoa, TenSanPham, lsp.getMaLoaiSanPham(), lsx.getMaHangSanXuat(), GiaNhap, GiaBan, TonKho, kt, ChuThich);
            HangHoaDAO dao = new HangHoaDAO();
            if (dao.update(hh) == false) {
                JOptionPane.showMessageDialog(rootPane, "Sửa thành công !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                loadHangHoa();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Sửa thất bại", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            loadHangHoa();
            System.out.println("Huỷ");
        }
    }//GEN-LAST:event_jButtonSuaSanPhamActionPerformed

    private void jTableKhachHang1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableKhachHang1MouseClicked
        //Click vào từng row và đổ ra các giá trị đó
        int row = jTableKhachHang1.getSelectedRow();
        fillrowkhachhang(row);
    }//GEN-LAST:event_jTableKhachHang1MouseClicked

    private void jTableKhachHang1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableKhachHang1KeyReleased
        // dùng phím bấm lên xuống để chọn dòng.
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
            int row = jTableKhachHang1.getSelectedRow();
            fillrowkhachhang(row);
        }
    }//GEN-LAST:event_jTableKhachHang1KeyReleased

    private void jButtonThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThemActionPerformed
        //Thêm khách hàng 
        String hoten = jTextFieldTenKH.getText();

        String ngaysinh = ns.format(jDateChooserNgaySinh.getDate());
        String gioitinh;
        if (jRadioButtonNam.isSelected() == true) {
            gioitinh = "1";
        } else {
            gioitinh = "0";
        }
        String diachi = jTextFieldDiaChi.getText();
        String dienthoai = jTextFieldSDT.getText();
        String ghichu = jTextAreaGhiChu.getText();
        byte kh_gioitinh = Byte.parseByte(gioitinh);
        LoaiKhachHang lkh = (LoaiKhachHang) jComboBoxLoaiKH.getSelectedItem();
        KhachHang kh = new KhachHang(hoten, ngaysinh, kh_gioitinh, diachi, dienthoai, lkh.getId(), ghichu);
        KhachHangCRUD crud = new KhachHangCRUD();
        if (crud.insert_KhachHang(kh) == true) {
            JOptionPane.showMessageDialog(rootPane, "Thêm thành công !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            loadKH();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Thêm TTKH thất bại", "thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonThemActionPerformed

    private void jButtonXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaActionPerformed
        // Xoá Khách Hàng
        if (JOptionPane.showConfirmDialog(null, "Xoá nhé ??", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            int id = Integer.valueOf(jTextFieldMaKH.getText());
            KhachHang kh = new KhachHang(id);
            KhachHangCRUD crud = new KhachHangCRUD();
            if (crud.del_KhachHang(kh) == true) {
                JOptionPane.showMessageDialog(rootPane, "Xoá thành công !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                loadKH();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Xoá thất bại", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            loadKH();
            System.out.println("Huỷ hành động xoá");
        }
    }//GEN-LAST:event_jButtonXoaActionPerformed

    private void jButtonSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuaActionPerformed
        // Sửa Khach Hàng
        if (JOptionPane.showConfirmDialog(null, "Sửa nhé ??", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            int id = Integer.valueOf(jTextFieldMaKH.getText());
            String hoten = jTextFieldTenKH.getText();
            SimpleDateFormat ns = new SimpleDateFormat("yyyy-MM-dd");
            String ngaysinh = ns.format(jDateChooserNgaySinh.getDate());
            String gioitinh;
            if (jRadioButtonNam.isSelected() == true) {
                gioitinh = "1";
            } else {
                gioitinh = "0";
            }
            String diachi = jTextFieldDiaChi.getText();
            String dienthoai = jTextFieldSDT.getText();
            String ghichu = jTextAreaGhiChu.getText();
            byte kh_gioitinh = Byte.parseByte(gioitinh);
            LoaiKhachHang lkh = (LoaiKhachHang) jComboBoxLoaiKH.getSelectedItem();

            KhachHang kh = new KhachHang(id, hoten, ngaysinh, kh_gioitinh, diachi, dienthoai, lkh.getId(), ghichu);
            KhachHangCRUD crud = new KhachHangCRUD();
            if (crud.update_KhachHang(kh) == true) {
                JOptionPane.showMessageDialog(rootPane, "Sửa thành công !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                loadKH();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Sửa thất bại", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            System.out.println("Huỷ hành động sửa");
            loadKH();
        }
    }//GEN-LAST:event_jButtonSuaActionPerformed
    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        // Refesh dòng textfields
        jTextFieldMaKH.setText("");
        jTextFieldTenKH.setText("");
        jTextFieldDiaChi.setText("");
        jTextFieldSDT.setText("");
        jTextAreaGhiChu.setText("");
        jDateChooserNgaySinh.setCalendar(null);
        jComboBoxLoaiKH.setSelectedItem(null);
        jRadioButtonNam.setSelected(true);
    }//GEN-LAST:event_jButtonResetActionPerformed

    private void jButtonThemSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThemSPActionPerformed
        // nút thêm sản phẩm
        LoaiSanPham lsp = (LoaiSanPham) jComboBoxLoaiSP.getSelectedItem();
        HangSanXuat lsx = (HangSanXuat) jComboBoxHangSanXuat.getSelectedItem();

        String TenSanPham = jTextFieldTenSP.getText();

        float GiaNhap = Float.parseFloat(jTextFieldGiaNhap.getText());
        float GiaBan = Float.parseFloat(jTextFieldGiaBan.getText());
        int TonKho = Integer.parseInt(jTextFieldTonKho.getText());
        String ChuThich = jTextFieldTonKho.getText();
        boolean kt;
        if (jRadioButtonHienSP.isSelected() == true) {
            kt = true;
        } else if (jRadioButtonAnSP.isSelected() == false) {
            kt = false;
        } else {
            kt = false;
        }
        HangHoa hh = new HangHoa(TenSanPham, lsp.getMaLoaiSanPham(), lsx.getMaHangSanXuat(), GiaNhap, GiaBan, TonKho, kt, ChuThich);
        HangHoaDAO dao = new HangHoaDAO();
        if (dao.create(hh) == false) {
            JOptionPane.showMessageDialog(rootPane, "Thêm thành công !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            loadHangHoa();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Thêm thất bại !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Huỷ Sửa");
        }
    }//GEN-LAST:event_jButtonThemSPActionPerformed

    private void jtableHangHoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableHangHoaMouseClicked
        // click vào từng dòng trên bảng SP để để ra textfield
        int row = jtableHangHoa.getSelectedRow();
        fillrowHangHoa(row);
    }//GEN-LAST:event_jtableHangHoaMouseClicked

    private void jtableHangHoaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtableHangHoaKeyReleased
        // dung nút lên xuống để lấy ra từng row của bảng SP
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
            int row = jtableHangHoa.getSelectedRow();
            fillrowHangHoa(row);
        }
    }//GEN-LAST:event_jtableHangHoaKeyReleased

    private void jButtonXoaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaSPActionPerformed
        // Xoá Sản phẩm
        if (JOptionPane.showConfirmDialog(null, "Xoá nhé ??", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            HangHoaDAO dao = new HangHoaDAO();
            if (dao.delete(MaHangHoa) == true) {
                JOptionPane.showMessageDialog(rootPane, "Xoá thành công !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                loadHangHoa();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Xoá thất bại !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

            }
        } else {
            System.out.println("Huỷ xoá sản phẩm");
            loadHangHoa();
        }
    }//GEN-LAST:event_jButtonXoaSPActionPerformed

    private void jButtonTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTimKiemActionPerformed
        // Tìm kiếm sản phẩm:
        TableRowSorter tt = new TableRowSorter(jtableHangHoa.getModel());
        jtableHangHoa.setRowSorter(tt);
        tt.setRowFilter(RowFilter.regexFilter(jTextFieldTimSP.getText()));
    }//GEN-LAST:event_jButtonTimKiemActionPerformed

    private void jButtonTimKiemKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTimKiemKHActionPerformed
        // Tim kiếm khách hàng:
        TableRowSorter tt = new TableRowSorter(jTableKhachHang1.getModel());
        jTableKhachHang1.setRowSorter(tt);
        tt.setRowFilter(RowFilter.regexFilter(jTextFieldTimKiemKH.getText()));
    }//GEN-LAST:event_jButtonTimKiemKHActionPerformed

    private void jTableDanhMucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDanhMucMouseClicked
        // click vào bảng jtabledanhmuc fill row danh mục ra textfield
        int row = jTableDanhMuc.getSelectedRow();
        fillrowDanhMuc(row);
    }//GEN-LAST:event_jTableDanhMucMouseClicked

    private void jTableDanhMucKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableDanhMucKeyReleased
        // up-down vào bảng jtabledanhmuc fill row danh mục ra textfield
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
            int row = jTableDanhMuc.getSelectedRow();
            fillrowDanhMuc(row);
        }
    }//GEN-LAST:event_jTableDanhMucKeyReleased

    private void jButtonTimKiemDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTimKiemDanhMucActionPerformed
        // TODO add your handling code here:
        TableRowSorter tt = new TableRowSorter(jTableDanhMuc.getModel());
        jTableDanhMuc.setRowSorter(tt);
        tt.setRowFilter(RowFilter.regexFilter(jTextFieldTimKiemDanhMuc.getText()));
    }//GEN-LAST:event_jButtonTimKiemDanhMucActionPerformed

    private void jButtonRefeshSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefeshSanPhamActionPerformed
        // refesh textfield hàng hoá 
        jTextFieldMaSP.setText("");
        jTextFieldTenSP.setText("");
        jTextFieldGiaNhap.setText("");
        jTextFieldGiaBan.setText("");
        jTextAreaGhiChu.setText("");
        jTextFieldTonKho.setText("");
        jComboBoxLoaiSP.setSelectedItem(null);
        jComboBoxHangSanXuat.setSelectedItem(null);
        jRadioButtonHienSP.setSelected(true);
    }//GEN-LAST:event_jButtonRefeshSanPhamActionPerformed

    private void jButtonThemDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThemDanhMucActionPerformed
        // Thêm danh_mục/LoaiSP
        String TenDanhMuc = jTextFieldTenDanhMuc.getText();
        LoaiSanPham lsp = new LoaiSanPham(TenDanhMuc);
        LoaiSanPhamDAO dao = new LoaiSanPhamDAO();
        if (dao.create(lsp) == true) {
            JOptionPane.showMessageDialog(rootPane, "Thêm thành công !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            loadDanhMuc();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Thêm thất bại !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_jButtonThemDanhMucActionPerformed

    private void jButtonSuaDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuaDanhMucActionPerformed
        // sửa danh mục
        if (JOptionPane.showConfirmDialog(null, "Sửa nhé ??", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            String TenDanhMuc = jTextFieldTenDanhMuc.getText();
            LoaiSanPham lsp = new LoaiSanPham(MaDanhMuc, TenDanhMuc);
            LoaiSanPhamDAO dao = new LoaiSanPhamDAO();
            if (dao.update(lsp) == true) {
                JOptionPane.showMessageDialog(rootPane, "Sửa thành công !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                loadDanhMuc();
                System.out.println("Sửa thành công");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Sửa thất bại !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Sửa Thất Bại");
            }
        } else {
            System.out.println("Huỷ sửa danh mục");
        }
    }//GEN-LAST:event_jButtonSuaDanhMucActionPerformed

    private void jButtonXoaDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaDanhMucActionPerformed
        // Xoá Danh Mục
        if (JOptionPane.showConfirmDialog(null, "Sửa nhé ??", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            LoaiSanPhamDAO dao = new LoaiSanPhamDAO();
            if (dao.delete(MaDanhMuc) == true) {
                JOptionPane.showMessageDialog(rootPane, "Xoá thành công !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                loadDanhMuc();
                System.out.println("Xoá danh mục thành công");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Xoá thất bại !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Xoá thất bại");
            }

        } else {
            System.out.println("Xoá sửa danh mục");
        }
    }//GEN-LAST:event_jButtonXoaDanhMucActionPerformed

    private void jButtonRefeshDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefeshDanhMucActionPerformed
        // refesh danh mục sản phẩm
        jTextFieldMaDanhMuc.setText("");
        jTextFieldTenDanhMuc.setText("");
        System.out.println("Refesh danh mục thành công");
    }//GEN-LAST:event_jButtonRefeshDanhMucActionPerformed

    private void jTableDanhSachNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDanhSachNhanVienMouseClicked
        //click mouse bảng nhân viên
        int row = jTableDanhSachNhanVien.getSelectedRow();
        fillrowNhanVien(row);
    }//GEN-LAST:event_jTableDanhSachNhanVienMouseClicked

    private void jButtonThemNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThemNVActionPerformed
        // Thêm nhân viên
        String TenNhanVien = jTextFieldTenNV.getText();
        SimpleDateFormat ns = new SimpleDateFormat("yyyy-MM-dd");
        String NgaySinh = ns.format(jDateChooserNgaySinhNV.getDate());
        String NgayVaoLam = ns.format(jDateChooserNgayVaoLamNV.getDate());
        String DiaChi = jTextFieldDiaChiNV.getText();
        String SDT = jTextFieldSDTNV.getText();
        String GhiChu = jTextAreaGhiChuNV.getText();
        ChucVu cv = (ChucVu) jComboBoxChucVu.getSelectedItem();
        boolean kt;
        if (jRadioButtonNamNV.isSelected() == true) {
            kt = true;
        } else if (jRadioButtonNuNV.isSelected() == false) {
            kt = false;
        } else {
            kt = false;
        }
        NhanVien nv = new NhanVien(TenNhanVien, NgaySinh, kt, NgayVaoLam, cv.getMaChucVu(), DiaChi, SDT, GhiChu);
        NhanVienDAO dao = new NhanVienDAO();
        if (dao.create(nv) == true) {
            JOptionPane.showMessageDialog(rootPane, "Thêm thành công !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            loadNhanVien();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Thêm thất bại !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Lỗi khi ở câu lệnh CRUD");
        }
    }//GEN-LAST:event_jButtonThemNVActionPerformed

    private void jButtonSuaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuaNVActionPerformed
        // sửa nhân viên
        if (JOptionPane.showConfirmDialog(null, "Sửa nhé ??", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            String TenNhanVien = jTextFieldTenNV.getText();
            SimpleDateFormat ns = new SimpleDateFormat("yyyy-MM-dd");

            String NgaySinh = ns.format(jDateChooserNgaySinhNV.getDate());
            String NgayVaoLam = ns.format(jDateChooserNgayVaoLamNV.getDate());

            String DiaChi = jTextFieldDiaChiNV.getText();

            String SDT = jTextFieldSDTNV.getText();
            String GhiChu = jTextAreaGhiChuNV.getText();
            ChucVu cv = (ChucVu) jComboBoxChucVu.getSelectedItem();
            boolean kt;
            if (jRadioButtonNamNV.isSelected() == true) {
                kt = true;
            } else if (jRadioButtonNuNV.isSelected() == false) {
                kt = false;
            } else {
                kt = false;
            }
            NhanVien nv = new NhanVien(MaNhanVien, TenNhanVien, NgaySinh, kt, NgayVaoLam, WIDTH, DiaChi, SDT, GhiChu);
            NhanVienDAO dao = new NhanVienDAO();
            if (dao.update(nv) == true) {
                JOptionPane.showMessageDialog(rootPane, "Sửa thành công !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Sửa thành công");
                loadNhanVien();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Sửa thất bại !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Sửa thất bại");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Đã huỷ sửa !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Huỷ sửa");
        }
    }//GEN-LAST:event_jButtonSuaNVActionPerformed

    private void jButtonXoaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaNVActionPerformed
        // Xoá Nhân Viên
        if (JOptionPane.showConfirmDialog(null, "Xoá nhé ??", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            NhanVienDAO dao = new NhanVienDAO();
            if (dao.delete(MaNhanVien) == true) {
                loadNhanVien();
                JOptionPane.showMessageDialog(rootPane, "Xoá thành công !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Xoá thất bại !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Đã huỷ xoá !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Huỷ xoá");
        }
    }//GEN-LAST:event_jButtonXoaNVActionPerformed

    private void jButtonThemDoiTacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThemDoiTacActionPerformed
        // Thêm đối tác
        String TenNhaPhanPhoi = jTextFieldTenDT.getText();
        String DiaChi = jTextFieldDiaChiDT.getText();
        String SDT = jTextFieldSDTDT.getText();
        String Email = jTextFieldEmailDT.getText();
        String ChuThich = jTextAreaGhiChuDoiTac.getText();
        Doitac dt = new Doitac(TenNhaPhanPhoi, DiaChi, SDT, Email, ChuThich);
        DoitacDAO dao = new DoitacDAO();
        if (dao.create(dt) == true) {
            loadDoiTac();
            JOptionPane.showMessageDialog(rootPane, "Thêm thành công !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Thêm thất bại !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonThemDoiTacActionPerformed

    private void jTableDoiTacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDoiTacMouseClicked
        // click bảng đối tác
        int row = jTableDoiTac.getSelectedRow();
        fillrowDoiTac(row);
    }//GEN-LAST:event_jTableDoiTacMouseClicked

    private void jTableDoiTacKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableDoiTacKeyReleased
        // up-down bảng đối tác
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
            int row = jTableDoiTac.getSelectedRow();
            fillrowDoiTac(row);
        }
    }//GEN-LAST:event_jTableDoiTacKeyReleased

    private void jButtonSuaDoiTacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSuaDoiTacActionPerformed
        // sửa đối tác
        if (JOptionPane.showConfirmDialog(null, "Sửa nhé ??", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            String TenNhaPhanPhoi = jTextFieldTenDT.getText();
            String DiaChi = jTextFieldDiaChiDT.getText();
            String SDT = jTextFieldSDTDT.getText();
            String Email = jTextFieldEmailDT.getText();
            String ChuThich = jTextAreaGhiChuDoiTac.getText();
            Doitac dt = new Doitac(MaNhaPhanPhoi, TenNhaPhanPhoi, DiaChi, SDT, Email, ChuThich);
            DoitacDAO dao = new DoitacDAO();
            if (dao.update(dt) == true) {
                loadDoiTac();
                JOptionPane.showMessageDialog(rootPane, "Sửa thành công !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Sửa thất bại !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Đã huỷ sửa !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Huỷ sửa");
        }
    }//GEN-LAST:event_jButtonSuaDoiTacActionPerformed

    private void jButtonXoaDoiTacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXoaDoiTacActionPerformed
        // Xoa doi tac
        if (JOptionPane.showConfirmDialog(null, "Xoá nhé ??", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            DoitacDAO dao = new DoitacDAO();
            if (dao.delete(MaNhaPhanPhoi) == true) {
                loadDoiTac();
                JOptionPane.showMessageDialog(rootPane, "Xoá thành công !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Xoá thất bại !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Đã huỷ xoá !!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Đã huỷ xoá");
        }
    }//GEN-LAST:event_jButtonXoaDoiTacActionPerformed
    public void loadCBBThoiGian() {
        ThoiGianCRUD dao = new ThoiGianCRUD();
        lstThoiGian = dao.selectThoiGian();
        DefaultComboBoxModel<ThoiGian> comx = new DefaultComboBoxModel();
        for (int i = 0; i < lstThoiGian.size(); i++) {
            ThoiGian tg = lstThoiGian.get(i);
            comx.addElement(tg);
        }
        jComboBoxSapXepThoiGian.setModel(comx);
    }

//    public void aloadspbanchay() {
//        //load sản phẩm bán chạy
//        HangHoaDAO crud = new HangHoaDAO();
//        List<HangHoa> lstHH = new ArrayList<>();
//        List<ChiTietHoaDon> lstcthd = new ArrayList<>();
//        List<HoaDon> lsthd = crud.GetHoaDonBanChay();
//        for (HoaDon hoaDon : lsthd) {
//            List<ChiTietHoaDon> cthd = crud.CTHoaDonBanChay(hoaDon.getMaHoaDon());
//            lstcthd.addAll(cthd);
//        }
//        for (ChiTietHoaDon chitiethoadon : lstcthd) {
//            List<HangHoa> hh = crud.spBanChay(chitiethoadon.getSanPham());
//            lstHH.addAll(hh);
//        }
//        for (HangHoa hh : lstHH) {
//
//        }
//    }
    private void jButtonCheckTongQuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCheckTongQuanActionPerformed
        // Tổng quan doanh thu
        Date datestart = jDateChooserCheckStart.getDate();
        Date dateend = jDateChooserCheckEnd.getDate();
        if (dateend != null || datestart != null) {
            //tinh doanh theo phạm vi ngày
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            TongQuanCRUD crud = new TongQuanCRUD();
            List<ChiTietHoaDon> listcthds = new ArrayList<>();
            List<HoaDon> listhd = crud.GetHoaDonRange(f.format(datestart), f.format(dateend));
            float tongtien = 0;
            float tonghoadon = listhd.size();
            float tongsanpham = 0;
            for (HoaDon hoaDon : listhd) {
                List<ChiTietHoaDon> listcthd = crud.GetCTHoaDonRange(hoaDon.getMaHoaDon());
                listcthds.addAll(listcthd);
            }
            for (HoaDon hd : listhd) {
                tongtien += hd.getTongTien();
                jTextFieldTTongDoanhSo.setText(fm.format((tongtien)));
                jTextFieldTTongDon.setText(String.valueOf(tonghoadon));
            }
            for (ChiTietHoaDon cthd : listcthds) {
                tongsanpham += cthd.getSoLuong();
                jTextFieldTTongSP.setText(String.valueOf(tongsanpham));
            }
        } else {
            if (jComboBoxSapXepThoiGian.getSelectedIndex() == 0) {
                //today
                TongQuanCRUD crud = new TongQuanCRUD();
                lstTongQuan = crud.select_TongQuan_HomNay();
                for (int i = 0; i < lstTongQuan.size(); i++) {
                    TongQuan tq = lstTongQuan.get(i);
                    jTextFieldTTongDoanhSo.setText(fm.format((tq.getTongtienx())));
                    jTextFieldTTongDon.setText(String.valueOf(tq.getTongdonhang()));
                    jTextFieldTTongSP.setText(String.valueOf(tq.getSoluongsp()));
                }
            } else if (jComboBoxSapXepThoiGian.getSelectedIndex() == 1) {
                //yesterday
                TongQuanCRUD crud = new TongQuanCRUD();
                lstTongQuan = crud.select_TongQuan_HomQua_THD_TTien();
                lstTongQuanx = crud.select_SoLuong_HomQua();
                //doanh thu, số đơn
                for (int i = 0; i < lstTongQuan.size(); i++) {
                    TongQuan tq = lstTongQuan.get(i);
                    jTextFieldTTongDoanhSo.setText(fm.format((tq.getTongtienx())));
                    jTextFieldTTongDon.setText(String.valueOf(tq.getTongdonhang()));
                }
                //số lượng
                for (int i = 0; i < lstTongQuanx.size(); i++) {
                    TongQuan tq = lstTongQuanx.get(i);
                    jTextFieldTTongSP.setText(String.valueOf(tq.getSoluongsp()));
                }
            } else if (jComboBoxSapXepThoiGian.getSelectedIndex() == 2) {
                //this month
                TongQuanCRUD crud = new TongQuanCRUD();
                lstTongQuan = crud.select_DoanhThu_ThisMonth();
                lstTongQuanx = crud.select_SoLuong_ThisMonth();
                //doanh thu, số đơn
                for (int i = 0; i < lstTongQuan.size(); i++) {
                    TongQuan tq = lstTongQuan.get(i);
                    jTextFieldTTongDoanhSo.setText(fm.format((tq.getTongtienx())));
                    jTextFieldTTongDon.setText(String.valueOf(tq.getTongdonhang()));
                }
                //số lượng
                for (int i = 0; i < lstTongQuanx.size(); i++) {
                    TongQuan tq = lstTongQuanx.get(i);
                    jTextFieldTTongSP.setText(String.valueOf(tq.getSoluongsp()));
                }
            } else if (jComboBoxSapXepThoiGian.getSelectedIndex() == 3) {
                //last month
                TongQuanCRUD crud = new TongQuanCRUD();
                lstTongQuan = crud.select_DoanhThu_LastMonth();
                lstTongQuanx = crud.select_SoLuong_LastMonth();
                //doanh thu, số đơn
                for (int i = 0; i < lstTongQuan.size(); i++) {
                    TongQuan tq = lstTongQuan.get(i);
                    jTextFieldTTongDoanhSo.setText(fm.format((tq.getTongtienx())));
                    jTextFieldTTongDon.setText(String.valueOf(tq.getTongdonhang()));
                }
                //số lượng
                for (int i = 0; i < lstTongQuanx.size(); i++) {
                    TongQuan tq = lstTongQuanx.get(i);
                    jTextFieldTTongSP.setText(String.valueOf(tq.getSoluongsp()));
                }
            } else if (jComboBoxSapXepThoiGian.getSelectedIndex() == 4) {
                //current year
                TongQuanCRUD crud = new TongQuanCRUD();
                lstTongQuan = crud.select_DoanhThu_ThisYear();
                lstTongQuanx = crud.select_SoLuong_ThisYear();
                //doanh thu, số đơn
                for (int i = 0; i < lstTongQuan.size(); i++) {
                    TongQuan tq = lstTongQuan.get(i);
                    jTextFieldTTongDoanhSo.setText(fm.format((tq.getTongtienx())));
                    jTextFieldTTongDon.setText(String.valueOf(tq.getTongdonhang()));
                }
                //số lượng
                for (int i = 0; i < lstTongQuanx.size(); i++) {
                    TongQuan tq = lstTongQuanx.get(i);
                    jTextFieldTTongSP.setText(String.valueOf(tq.getSoluongsp()));
                }
            } else if (jComboBoxSapXepThoiGian.getSelectedIndex() == 5) {
                //last year
                TongQuanCRUD crud = new TongQuanCRUD();
                lstTongQuan = crud.select_DoanhThu_LastYear();
                lstTongQuanx = crud.select_SoLuong_LastYear();
                //doanh thu, số đơn
                for (int i = 0; i < lstTongQuan.size(); i++) {
                    TongQuan tq = lstTongQuan.get(i);
                    jTextFieldTTongDoanhSo.setText(fm.format((tq.getTongtienx())));
                    jTextFieldTTongDon.setText(String.valueOf(tq.getTongdonhang()));
                }
                //số lượng
                for (int i = 0; i < lstTongQuanx.size(); i++) {
                    TongQuan tq = lstTongQuanx.get(i);
                    jTextFieldTTongSP.setText(String.valueOf(tq.getSoluongsp()));
                }
            }
        }
    }//GEN-LAST:event_jButtonCheckTongQuanActionPerformed

    private void loadTongQuan() {
        //load text field doanh thu today
        TongQuanCRUD crud = new TongQuanCRUD();
        lstTongQuan = crud.select_TongQuan_HomNay();
        for (int i = 0; i < lstTongQuan.size(); i++) {
            TongQuan tq = lstTongQuan.get(i);
            jTextFieldTTongDoanhSo.setText(fm.format((tq.getTongtienx())));
            jTextFieldTTongDon.setText(String.valueOf(tq.getTongdonhang()));
            jTextFieldTTongSP.setText(String.valueOf(tq.getSoluongsp()));

            System.out.println("Tổng tiền: " + tq.getTongtienx());
            System.out.println("Tổng đơn hàng: " + tq.getTongdonhang());
            System.out.println("Tổng sản phẩm: " + tq.getSoluongsp());
        }

    }

    private void fillrowkhachhang(int row) {
        //đổ giá trị từ bảng vào textfield
        mIDCurrent = khachmhang.get(row).getId();
        jTextFieldMaKH.setText(String.valueOf(mIDCurrent));
        jTextFieldTenKH.setText(khachmhang.get(row).getHoten());
        try {
            java.util.Date bd = new SimpleDateFormat("yyyy-MM-dd").parse(khachmhang.get(row).getNgaysinh());
            jDateChooserNgaySinh.setDate(bd);
        } catch (ParseException ex) {
            System.err.println("Lỗi set ngày sinh");
        }
        boolean kt;
        if (khachmhang.get(row).getGioitinh() == 1) {
            jRadioButtonNam.setSelected(true);
            kt = true;
        } else {
            jRadioButtonNu.setSelected(true);
            kt = false;
        }
        jTextFieldDiaChi.setText(khachmhang.get(row).getDiachi());
        jTextFieldSDT.setText(khachmhang.get(row).getDienthoai());
        int pos = 0;
        int idLoai = khachmhang.get(row).getLoaikhachhang();
        for (int i = 0; i < loadmKh.size(); i++) {
            if (loadmKh.get(i).getId() == idLoai) {
                pos = i;
                break;
            }
        }
        jComboBoxLoaiKH.setSelectedIndex(pos);
        jTextAreaGhiChu.setText(khachmhang.get(row).getGhichu());
    }

    public void fillrowDanhMuc(int row) {
        MaDanhMuc = lstLoaiSanPham.get(row).getMaLoaiSanPham();
        jTextFieldMaDanhMuc.setText(String.valueOf(MaDanhMuc));
        jTextFieldTenDanhMuc.setText(lstLoaiSanPham.get(row).getTenLoaiSanPham());
        loadDanhMucSanPham(MaDanhMuc);
    }

    public void fillrowDoiTac(int row) {
        MaNhaPhanPhoi = lstDoiTac.get(row).getMaNhaPhanPhoi();
        jTextFieldTenDT.setText(lstDoiTac.get(row).getTenNhaPhanPhoi());
        jTextFieldDiaChiDT.setText(lstDoiTac.get(row).getDiaChi());
        jTextFieldSDTDT.setText(lstDoiTac.get(row).getSDT());
        jTextFieldEmailDT.setText(lstDoiTac.get(row).getEmail());
        jTextAreaGhiChuDoiTac.setText(lstDoiTac.get(row).getChuThich());
        jTextFieldMaDT.setText(String.valueOf(MaNhaPhanPhoi));
    }

    public void fillrowNhanVien(int row) {
        try {
            java.util.Date bd1 = new SimpleDateFormat("yyyy-MM-dd").parse(lstNhanVien.get(row).getNgaySinh());
            java.util.Date bd2 = new SimpleDateFormat("yyyy-MM-dd").parse(lstNhanVien.get(row).getNgayVaoLam());
            jDateChooserNgaySinhNV.setDate(bd1);
            jDateChooserNgayVaoLamNV.setDate(bd2);
            MaNhanVien = lstNhanVien.get(row).getMaNhanVien();
            jTextFieldTenNV.setText(lstNhanVien.get(row).getTenNhanVien());
            jTextFieldMaNV.setText(String.valueOf(MaNhanVien));
            jTextFieldDiaChiNV.setText(lstNhanVien.get(row).getDiaChi());
            jTextFieldSDTNV.setText(lstNhanVien.get(row).getSDT());
            jTextAreaGhiChuNV.setText(lstNhanVien.get(row).getGhiChu());
            int IDChucvu = lstNhanVien.get(row).getChucVu();
            int chucvu = 0;
            for (int i = 0; i < lstChucVu.size(); i++) {
                if (IDChucvu == lstChucVu.get(i).getMaChucVu()) {
                    chucvu = i;
                    break;
                }
            }
            jComboBoxChucVu.setSelectedIndex(chucvu);
            boolean kt;
            if (lstNhanVien.get(row).isGioiTinh() == true) {
                jRadioButtonNamNV.setSelected(true);
                kt = true;
            } else {
                jRadioButtonNuNV.setSelected(true);
                kt = false;
            }
        } catch (ParseException ex) {
            Logger.getLogger(TrangChu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void fillrowHangHoa(int row) {
        //show chi tiết hàng hoá
        MaHangHoa = lstHangHoa.get(row).getMaSanPham();
        jTextFieldMaSP.setText(String.valueOf(MaHangHoa));
        jTextFieldTenSP.setText(lstHangHoa.get(row).getTenSanPham());
        jTextFieldGiaBan.setText(String.valueOf(df.format(lstHangHoa.get(row).getGiaBan())));
        jTextFieldGiaNhap.setText(String.valueOf(df.format(lstHangHoa.get(row).getGiaNhap())));
        jTextFieldTonKho.setText(String.valueOf(lstHangHoa.get(row).getTonKho()));
        jTextPaneChuThich.setText(lstHangHoa.get(row).getChuThich());
        int Loaisp = lstHangHoa.get(row).getLoaiSanPham();
        int lsp = 0;
        for (int i = 0; i < lstLoaiSanPham.size(); i++) {
            if (Loaisp == lstLoaiSanPham.get(i).getMaLoaiSanPham()) {
                lsp = i;
                break;
            }
        }
        jComboBoxLoaiSP.setSelectedIndex(lsp);
        int Loaihsx = lstHangHoa.get(row).getHangSanXuat();
        int hsx = 0;
        for (int i = 0; i < lstHangSanXuat.size(); i++) {
            if (Loaihsx == lstHangSanXuat.get(i).getMaHangSanXuat()) {
                hsx = i;
                break;
            }
        }
        jComboBoxHangSanXuat.setSelectedIndex(hsx);
        boolean kt;
        if (lstHangHoa.get(row).isTrangThai() == true) {
            jRadioButtonHienSP.setSelected(true);
            kt = true;
        } else {
            jRadioButtonAnSP.setSelected(true);
            kt = false;
        }
    }

//    public void loadspbanchay() {
//        HangHoaDAO dao = new HangHoaDAO();
//        lstHangHoa = dao.read();
//        DefaultTableModel dtm = new DefaultTableModel();
//        dtm.addColumn("STT");
//
//        dtm.addColumn("Tên Sản Phẩm");
//        dtm.addColumn("Số Lượng");
//
//        int count = 1;
//
//        //load sản phẩm bán chạy
//        HangHoaDAO crud = new HangHoaDAO();
//        List<HangHoa> lstHH = new ArrayList<>();
//        List<ChiTietHoaDon> cthd = crud.CTHoaDonBanChay();
//
////        for (ChiTietHoaDon chitiethoadon : cthd) {
////            List<HangHoa> hhx = crud.readSPtheoid(chitiethoadon.getSanPham());
////            lstHH.addAll(hhx);
////        }
//        for (int i = 0; i < cthd.size(); i++) {
//            int id = cthd.get(i).getSanPham();
//            lstHangHoaB = crud.readSPtheoid(id);
//        }
//        System.out.println(lstHangHoaB);
//        for (int i = 0; i < lstHangHoaB.size(); i++) {
//            HangHoa ha = lstHangHoaB.get(i);
//            Vector row = new Vector<>();
//            row.add(count++);
//            row.add(ha.getTenSanPham());
//            row.add(ha.getSoluong());
//            dtm.addRow(row);
//        }
//        jTableSPBanChay.setModel(dtm);
//    }
    public void loadspbanchay() {
        HangHoaDAO dao = new HangHoaDAO();
        lstHangHoa = dao.read();
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("STT");
        dtm.addColumn("Mã Sản Phẩm");
        dtm.addColumn("Tên Sản Phẩm");
        dtm.addColumn("Loại Sản Phẩm");
        dtm.addColumn("Hãng Sản Xuất");
        dtm.addColumn("Giá Nhập");
        dtm.addColumn("Giá Bán");
        dtm.addColumn("Tồn Kho");
        dtm.addColumn("Trạng Thái");
        dtm.addColumn("Chú Thích");
        int count = 1;

        //load sản phẩm bán chạy
        HangHoaDAO crud = new HangHoaDAO();
        List<HangHoa> lstHH = new ArrayList<>();
        List<ChiTietHoaDon> cthd = crud.CTHoaDonBanChay();

        for (ChiTietHoaDon chitiethoadon : cthd) {
            List<HangHoa> hhx = crud.readSPtheoid(chitiethoadon.getSanPham());
            lstHH.addAll(hhx);
        }
        for (HangHoa hh : lstHH) {
            Vector row = new Vector<>();
            row.add(count++);
            row.add(hh.getMaSanPham());
            row.add(hh.getTenSanPham());
            row.add(hh.getLoaiSanPham());
            row.add(hh.getHangSanXuat());
            row.add(fm.format(hh.getGiaNhap()));
            row.add(fm.format(hh.getGiaBan()));
            row.add(hh.getTonKho());
            boolean kt;
            if (hh.isTrangThai() == true) {
                row.add(hh.statusEnable());
                kt = true;
            } else {
                row.add(hh.statusDisable());
                kt = false;
            }
            row.add(hh.getChuThich());
            dtm.addRow(row);
        }
        jTableSPBanChay.setModel(dtm);
    }

    public void loadDoiTac() {
        //load bảng đối tác
        DoitacDAO dao = new DoitacDAO();
        lstDoiTac = dao.read();
        DefaultTableModel tbdoitac = new DefaultTableModel();
        tbdoitac.addColumn("Mã Đối Tác");
        tbdoitac.addColumn("Tên Nhà Phân Phối");
        tbdoitac.addColumn("Địa Chỉ");
        tbdoitac.addColumn("SDT");
        tbdoitac.addColumn("Email");
        tbdoitac.addColumn("Chú Thích");
        for (int i = 0; i < lstDoiTac.size(); i++) {
            Doitac dt = lstDoiTac.get(i);
            Vector row = new Vector<>();
            row.add(dt.getMaNhaPhanPhoi());
            row.add(dt.getTenNhaPhanPhoi());
            row.add(dt.getDiaChi());
            row.add(dt.getSDT());
            row.add(dt.getEmail());
            row.add(dt.getChuThich());
            tbdoitac.addRow(row);
        }
        jTableDoiTac.setModel(tbdoitac);
    }

    public void loadHangHoa() {
        //tải bảng hàng hoá
        HangHoaDAO dao = new HangHoaDAO();
        lstHangHoa = dao.read();
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("STT");
        dtm.addColumn("Mã Sản Phẩm");
        dtm.addColumn("Tên Sản Phẩm");
        dtm.addColumn("Loại Sản Phẩm");
        dtm.addColumn("Hãng Sản Xuất");
        dtm.addColumn("Giá Nhập");
        dtm.addColumn("Giá Bán");
        dtm.addColumn("Tồn Kho");
        dtm.addColumn("Trạng Thái");
        dtm.addColumn("Chú Thích");
//        dtm.addColumn("Image");
        int count = 1;
        for (int i = 0; i < lstHangHoa.size(); i++) {
            HangHoa hh = lstHangHoa.get(i);
            Vector row = new Vector<>();
            row.add(count++);
            row.add(hh.getMaSanPham());
            row.add(hh.getTenSanPham());
            row.add(hh.getTenLoaiSanPham());
            row.add(hh.getTenHangSanXuat());
            row.add(fm.format(hh.getGiaNhap()));
            row.add(fm.format(hh.getGiaBan()));
            row.add(hh.getTonKho());
            //row.add(hh.isTrangThai());
            boolean kt;
            if (hh.isTrangThai() == true) {
                row.add(hh.statusEnable());
                kt = true;
            } else {
                row.add(hh.statusDisable());
                kt = false;
            }
//            row.add(hh.getImage());
            row.add(hh.getChuThich());
            dtm.addRow(row);
        }
        jtableHangHoa.setModel(dtm);
    }

    public void loadDanhMuc() {
        LoaiSanPhamDAO dao = new LoaiSanPhamDAO();
        lstLoaiSanPham = dao.read();
        DefaultTableModel dtmDanhMuc = new DefaultTableModel();
        dtmDanhMuc.addColumn("Mã Danh Mục");
        dtmDanhMuc.addColumn("Tên Danh Mục");
        for (int i = 0; i < lstLoaiSanPham.size(); i++) {
            LoaiSanPham lsp = lstLoaiSanPham.get(i);
            Vector row = new Vector<>();
            row.add(lsp.getMaLoaiSanPham());
            row.add(lsp.getTenLoaiSanPham());
            dtmDanhMuc.addRow(row);
        }
        jTableDanhMuc.setModel(dtmDanhMuc);
    }

    public void loadLoaiSanPham() {
        LoaiSanPhamDAO dao = new LoaiSanPhamDAO();
        lstLoaiSanPham = dao.read();
        DefaultComboBoxModel<LoaiSanPham> comx = new DefaultComboBoxModel();
        for (int i = 0; i < lstLoaiSanPham.size(); i++) {
            LoaiSanPham lo = lstLoaiSanPham.get(i);
            comx.addElement(lo);
        }
        jComboBoxLoaiSP.setModel(comx);
    }

    public void loadHangSanXuat() {
        HangSanXuatDAO dao = new HangSanXuatDAO();
        lstHangSanXuat = dao.read();
        DefaultComboBoxModel<HangSanXuat> com = new DefaultComboBoxModel();
        for (int i = 0; i < lstHangSanXuat.size(); i++) {
            HangSanXuat ha = lstHangSanXuat.get(i);
            com.addElement(ha);
        }
        jComboBoxHangSanXuat.setModel(com);
    }

    public void loadDanhMucSanPham(int MaDanhMuc) {
        HangHoaDAO dao = new HangHoaDAO();
        lstHangHoaA = dao.readSP(MaDanhMuc);
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Mã Sản Phẩm");
        dtm.addColumn("Tên Sản Phẩm");
        dtm.addColumn("Loại Sản Phẩm");
        dtm.addColumn("Hãng Sản Xuất");
        dtm.addColumn("Giá Nhập");
        dtm.addColumn("Giá Bán");
        dtm.addColumn("Tồn Kho");
        dtm.addColumn("Trạng Thái");
//        dtm.addColumn("Image");
        dtm.addColumn("Chú Thích");
        for (int i = 0; i < lstHangHoaA.size(); i++) {
            HangHoa hh = lstHangHoaA.get(i);
            Vector row = new Vector<>();
            row.add(hh.getMaSanPham());
            row.add(hh.getTenSanPham());
            row.add(hh.getLoaiSanPham());
            row.add(hh.getHangSanXuat());
            row.add(fm.format(hh.getGiaNhap()));
            row.add(fm.format(hh.getGiaBan()));
            row.add(hh.getTonKho());
            row.add(hh.isTrangThai());
//            row.add(hh.getImage());
            row.add(hh.getChuThich());
            dtm.addRow(row);
        }
        jTableDanhMuc_SanPham.setModel(dtm);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrangChu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CTPN;
    private javax.swing.JPanel JPanelNhanVien;
    private javax.swing.ButtonGroup buttonGroupGioiTinh;
    private javax.swing.ButtonGroup buttonGroupGioiTinhNV;
    private javax.swing.ButtonGroup buttonGroupSanPham;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButton47;
    private javax.swing.JButton jButton48;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButtonCheckTongQuan;
    private javax.swing.JButton jButtonRefeshDanhMuc;
    private javax.swing.JButton jButtonRefeshNV;
    private javax.swing.JButton jButtonRefeshSanPham;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonResetDoiTac;
    private javax.swing.JButton jButtonSua;
    private javax.swing.JButton jButtonSuaDanhMuc;
    private javax.swing.JButton jButtonSuaDoiTac;
    private javax.swing.JButton jButtonSuaNV;
    private javax.swing.JButton jButtonSuaSanPham;
    private javax.swing.JButton jButtonThem;
    private javax.swing.JButton jButtonThemDanhMuc;
    private javax.swing.JButton jButtonThemDoiTac;
    private javax.swing.JButton jButtonThemNV;
    private javax.swing.JButton jButtonThemSP;
    private javax.swing.JButton jButtonTimKiem;
    private javax.swing.JButton jButtonTimKiemDanhMuc;
    private javax.swing.JButton jButtonTimKiemKH;
    private javax.swing.JButton jButtonTimKiemNV;
    private javax.swing.JButton jButtonXoa;
    private javax.swing.JButton jButtonXoaDanhMuc;
    private javax.swing.JButton jButtonXoaDoiTac;
    private javax.swing.JButton jButtonXoaNV;
    private javax.swing.JButton jButtonXoaSP;
    private javax.swing.JComboBox<String> jComboBox10;
    private javax.swing.JComboBox<String> jComboBox11;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JComboBox jComboBoxChucVu;
    private javax.swing.JComboBox jComboBoxHangSanXuat;
    private javax.swing.JComboBox jComboBoxLoaiKH;
    private javax.swing.JComboBox jComboBoxLoaiSP;
    private javax.swing.JComboBox jComboBoxNhanVien;
    private javax.swing.JComboBox jComboBoxSanPhamx;
    private javax.swing.JComboBox jComboBoxSapXepThoiGian;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabelTenDT;
    private javax.swing.JTabbedPane jPaneHangHoa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelDanhMuc;
    private javax.swing.JPanel jPanelDoanhThu;
    private javax.swing.JPanel jPanelDoiTac;
    private javax.swing.JPanel jPanelHangHoa;
    private javax.swing.JPanel jPanelHoaDon;
    private javax.swing.JPanel jPanelKhachHang;
    private javax.swing.JPanel jPanelNhanVien;
    private javax.swing.JPanel jPanelPhanQuyen;
    private javax.swing.JPanel jPanelSanPham;
    private javax.swing.JPanel jPanelTaiKhoan;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JRadioButton jRadioButtonAnSP;
    private javax.swing.JRadioButton jRadioButtonHienSP;
    private javax.swing.JRadioButton jRadioButtonNam;
    private javax.swing.JRadioButton jRadioButtonNamNV;
    private javax.swing.JRadioButton jRadioButtonNu;
    private javax.swing.JRadioButton jRadioButtonNuNV;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPaneMinishop;
    private javax.swing.JTabbedPane jTabbedPaneNhanVien;
    private javax.swing.JTable jTable10;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable8;
    private javax.swing.JTable jTable9;
    private javax.swing.JTable jTableChiTietPhieuNhap;
    private javax.swing.JTable jTableDanhMuc;
    private javax.swing.JTable jTableDanhMuc_SanPham;
    private javax.swing.JTable jTableDanhSachNhanVien;
    private javax.swing.JTable jTableDoiTac;
    private javax.swing.JTable jTableHoaDon;
    private javax.swing.JTable jTableKhachHang1;
    private javax.swing.JTable jTablePhieuNhap;
    private javax.swing.JTable jTableSPBanChay;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea7;
    private javax.swing.JTextArea jTextArea8;
    private javax.swing.JTextArea jTextAreaGhiChu;
    private javax.swing.JTextArea jTextAreaGhiChuDoiTac;
    private javax.swing.JTextArea jTextAreaGhiChuNV;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField43;
    private javax.swing.JTextField jTextField45;
    private javax.swing.JTextField jTextFieldDiaChi;
    private javax.swing.JTextField jTextFieldDiaChiDT;
    private javax.swing.JTextField jTextFieldDiaChiNV;
    private javax.swing.JTextField jTextFieldEmailDT;
    private javax.swing.JTextField jTextFieldGiaBan;
    private javax.swing.JTextField jTextFieldGiaNhap;
    private javax.swing.JTextField jTextFieldMaDT;
    private javax.swing.JTextField jTextFieldMaDanhMuc;
    private javax.swing.JTextField jTextFieldMaKH;
    private javax.swing.JTextField jTextFieldMaNV;
    private javax.swing.JTextField jTextFieldMaSP;
    private javax.swing.JTextField jTextFieldSDT;
    private javax.swing.JTextField jTextFieldSDTDT;
    private javax.swing.JTextField jTextFieldSDTNV;
    private javax.swing.JTextField jTextFieldTTongDoanhSo;
    private javax.swing.JTextField jTextFieldTTongDon;
    private javax.swing.JTextField jTextFieldTTongSP;
    private javax.swing.JTextField jTextFieldTenDT;
    private javax.swing.JTextField jTextFieldTenDanhMuc;
    private javax.swing.JTextField jTextFieldTenKH;
    private javax.swing.JTextField jTextFieldTenNV;
    private javax.swing.JTextField jTextFieldTenSP;
    private javax.swing.JTextField jTextFieldTimKiemDanhMuc;
    private javax.swing.JTextField jTextFieldTimKiemKH;
    private javax.swing.JTextField jTextFieldTimKiemNV;
    private javax.swing.JTextField jTextFieldTimSP;
    private javax.swing.JTextField jTextFieldTonKho;
    private javax.swing.JTextPane jTextPaneChuThich;
    private javax.swing.JTable jtableHangHoa;
    private javax.swing.JTextField txtNgayNhapPhieuNhap;
    private javax.swing.JTextField txtTongTienPhieuNhap;
    // End of variables declaration//GEN-END:variables
}
