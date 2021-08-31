
public class Manager extends Staff implements ICalculator{
	String chucDanh;
	public Manager (String maNhanVien,String tenNhanVien,String boPhanLamViec,float heSoLuong,int soNgayNghiPhep,String sNgayVaoLam,String chucDanh) {
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.boPhanLamViec = boPhanLamViec;
		this.heSoLuong = heSoLuong;
		this.soNgayNghiPhep = soNgayNghiPhep;
		this.sNgayVaoLam = sNgayVaoLam;
		this.chucDanh = chucDanh;
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
		System.out.println("Chức danh: "+this.chucDanh);
	}
	public double calculateSalary() {
		double luongTrachNhiem;
		if(this.chucDanh=="Business Leader") {
			luongTrachNhiem = 8000000;
		}
		else if(this.chucDanh =="Project Leader") {
			luongTrachNhiem = 5000000;
		}
		else if(this.chucDanh == "Technical Leader") {
			luongTrachNhiem = 6000000;
		}
		else {luongTrachNhiem=0;}
		double luongNhanVien = this.heSoLuong*5000000+luongTrachNhiem;
		return luongNhanVien;
	}
}
