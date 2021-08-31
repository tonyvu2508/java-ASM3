import java.util.*;
public class Department {
	private String maBoPhan,tenBoPhan;
	private int soLuongNhanVienHienTai = 0;
	public Department(String maBoPhan,String tenBoPhan,int soLuongNhanVienHienTai) {
		this.maBoPhan=maBoPhan;
		this.tenBoPhan=tenBoPhan;
		this.soLuongNhanVienHienTai=soLuongNhanVienHienTai;
	}

	public void themNhanVien() {
		this.soLuongNhanVienHienTai++;
	}
    public String toString() {
		return "Mã bộ phận: "+this.maBoPhan+"\nTên bộ phận: "+this.tenBoPhan+"\nSố lượng nhân viên hiện tại: "+this.soLuongNhanVienHienTai+"\n";
	}

	public String getTenBoPhan(Integer maBoPhan) {
		return this.tenBoPhan;
	}
}
