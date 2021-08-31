import java.util.*;

public class Employee extends Staff implements ICalculator{
	int soGioLamThem;
	static String chucDanh = "Staff";
	public Employee (String maNhanVien,String tenNhanVien,String boPhanLamViec,float heSoLuong,int soNgayNghiPhep,String sNgayVaoLam,int soGioLamThem) {
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.boPhanLamViec = boPhanLamViec;
		this.heSoLuong = heSoLuong;
		this.soNgayNghiPhep = soNgayNghiPhep;
		this.sNgayVaoLam = sNgayVaoLam;
		this.soGioLamThem = soGioLamThem;
	}
	public Date getNgayVaoLam() {
		return this.ngayVaoLam;
	}
	@Override
	public void displayInformation() {
		System.out.println("-------------------------------");
		System.out.println("Mã nhân viên: "+this.maNhanVien);
		System.out.println("Tên nhân viên: "+this.tenNhanVien);
		System.out.println("Bộ phận làm việc: "+this.boPhanLamViec);
		System.out.println("Hệ số lương: "+this.heSoLuong);
		System.out.println("Số ngày nghỉ phép: "+this.soNgayNghiPhep);
		System.out.println("Ngày vào làm: "+this.sNgayVaoLam);
		System.out.println("Số giờ làm thêm: "+this.soGioLamThem);
	}
	public double calculateSalary() {
		double luongNhanVien = this.heSoLuong*3000000 + this.soGioLamThem*200000;
		return luongNhanVien;
	}
}
