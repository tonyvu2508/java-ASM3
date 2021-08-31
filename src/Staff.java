import java.util.*;

public abstract class Staff {
	protected String maNhanVien,tenNhanVien,boPhanLamViec,sNgayVaoLam;
	protected float heSoLuong;
	protected int soNgayNghiPhep;
	protected Date ngayVaoLam = new Date();
	
	public abstract void displayInformation();

}
