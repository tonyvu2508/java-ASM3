import java.util.*;
import java.util.Map;  
import java.math.BigDecimal;
public class HumanResoucres{
	static ArrayList<Object> nhanVienCongTy = new ArrayList<>();
	static Scanner input = new Scanner(System.in);
	static Department banGiamDoc = new Department("1","Ban giám đốc",0);
	static Department phongBanHang = new Department("2","Phòng bán hàng",0);
	static Department phongIT = new Department("3","Phòng IT",0);
	static Department phongKeToan = new Department("4","Phòng kế toán",0);
	static Department phongMarketing = new Department("5","Phòng Marketing",0);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Staff> nhanVienCongTy1 = new ArrayList<>();
		Staff aaa=new Employee("","","",2,2,"",1);
		Staff bbb=new Manager("","","",2,2,"","");
		nhanVienCongTy1.add(aaa);
		nhanVienCongTy1.add(bbb);
		System.out.println(getSalary(nhanVienCongTy1.get(0)));
		boolean y=true;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("Chương trình quản lý nhân sự - 1.0");
			System.out.println("Mời chọn chức năng:");
			System.out.println("1. Hiển thị nhân viên hiện có trong công ty");
			System.out.println("2. Hiển thị các bộ phận trong công ty");
			System.out.println("3. Hiển thị các nhân viên theo từng bộ phận");
			System.out.println("4. Thêm nhân viên mới vào công ty");
			System.out.println("5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên");
			System.out.println("6. Hiển thị bảng lương của nhân viên toàn công ty");
			System.out.println("7. Hiển thị bảng lương của nhân viên theo thứ tự (tăng/giảm dần)");
			System.out.println("8. Thoát chương trình");
			int input = sc.nextInt();
			switch(input) {
			case 1:
				hienThiTatCaNhanVien();
				pressAnyKeyToContinue();
				clearScreen();
				break;
			case 2:
				hienThiCacBoPhanTrongCongTy();
				pressAnyKeyToContinue();
				clearScreen();
				break;
			case 3:
				hienThiNhanVienTheoBoPhan("Ban giám đốc");
				hienThiNhanVienTheoBoPhan("Phòng bán hàng");
				hienThiNhanVienTheoBoPhan("Phòng IT");
				hienThiNhanVienTheoBoPhan("Phòng kế toán");
				hienThiNhanVienTheoBoPhan("Phòng Marketing");
				pressAnyKeyToContinue();
				clearScreen();
				break;
			case 4:
				themNhanVienMoi();
				clearScreen();
				break;
			case 5:
				timKiemThongTinNhanVien();
				clearScreen();
				break;
			case 6:
				hienThiBangLuong();
				pressAnyKeyToContinue();
				clearScreen();
				break;
			case 7:
				hienThiBangLuongSapXep();
				pressAnyKeyToContinue();
				clearScreen();
				break;
			case 8:
				System.out.println("Exit program, thank you");
				clearScreen();
				y = false;
				break;
			}
			
		}
		while(y==true);
		sc.close();
	}
	public static double luong(Staff staff) {
		double salary = 0;
		switch(staff.getClass().getName()) {
		case "Employee":
			salary = ((Employee)staff).calculateSalary();
			break;
		case "Manager":
			salary = ((Manager)staff).calculateSalary();
			break;
		}
		
		return salary;
			
	}
	public static void hienThiTatCaNhanVien() {
		System.out.println("Danh sách nhân viên:");
		int i = 1;
		for(Object nhanVien : nhanVienCongTy) {
			if (nhanVien.getClass() == Manager.class) {
				Manager manager = (Manager) nhanVien;
				System.out.println(i+". "+manager.maNhanVien);  
				System.out.println("-- Tên nhân viên: "+manager.tenNhanVien);
				System.out.println("-- Chức danh: "+manager.chucDanh);
				System.out.println("-- Bộ phận: "+manager.boPhanLamViec);
				System.out.println("-- Hệ số lương: "+manager.heSoLuong);
				System.out.println("-- Số ngày nghỉ phép: "+manager.soNgayNghiPhep);
				System.out.println("-- Ngày vào làm: "+manager.sNgayVaoLam);
			}
			if (nhanVien.getClass() == Employee.class) {
				Employee nhanVienBt = (Employee) nhanVien;
				System.out.println(i+". "+nhanVienBt.maNhanVien);  
				System.out.println("-- Tên nhân viên: "+nhanVienBt.tenNhanVien);
				System.out.println("-- Bộ phận: "+nhanVienBt.boPhanLamViec);
				System.out.println("-- Hệ số lương: "+nhanVienBt.heSoLuong);
				System.out.println("-- Số ngày nghỉ phép: "+nhanVienBt.soNgayNghiPhep);
				System.out.println("-- Ngày vào làm: "+nhanVienBt.sNgayVaoLam);
				System.out.println("-- Số giờ làm thêm: "+nhanVienBt.soGioLamThem);
			}
			i++;
		}
	}
	public static void hienThiCacBoPhanTrongCongTy() {
		System.out.println(banGiamDoc.toString());
		System.out.println(phongBanHang.toString());
		System.out.println(phongIT.toString());
		System.out.println(phongKeToan.toString());
		System.out.println(phongMarketing.toString());
	}
	public static void hienThiNhanVienTheoBoPhan(String tenBoPhan) {
		System.out.println("------------------------------");
		System.out.println(tenBoPhan+": ");
		for(Object nhanVien : nhanVienCongTy) {
			if (nhanVien.getClass() == Manager.class) {
				Manager manager = (Manager) nhanVien;
				if(manager.boPhanLamViec==tenBoPhan) {
					manager.displayInformation();
				}
			}
			if (nhanVien.getClass() == Employee.class) {
				Employee nhanVienBt = (Employee) nhanVien;
				if(nhanVienBt.boPhanLamViec==tenBoPhan) {
					nhanVienBt.displayInformation();
				}
			}
		}
	}
	public static void themNhanVienMoi() {
		boolean y = true;
		do {
			System.out.println("---Thêm nhân viên mới---");
			System.out.println("Chọn chức danh: ");
			System.out.println("1. Nhân viên bình thường");  
			System.out.println("2. Quản lý");  
			int option = input.nextInt();
			if(option == 1) {
				System.out.println("Nhập thông tin Employee:");  
				System.out.print("Mã nhân viên: ");  
				String maNhanVien = input.next();
				System.out.print("Tên nhân viên: ");  
				String tenNhanVien = input.next();
				System.out.println("Chọn bộ phận làm việc: "); 
				System.out.println("1. Ban Giám Đốc");  
				System.out.println("2. Phòng Kế Toán");  
				System.out.println("3. Phòng Bán Hàng");  
				System.out.println("4. Phòng IT");
				System.out.println("5. Phòng Marketing");
				int maBoPhan = input.nextInt();
				String boPhanLamViec="";
				switch(maBoPhan) {
				case 1:
					boPhanLamViec = "Ban giám đốc";
					banGiamDoc.themNhanVien();
					break;
				case 2:
					boPhanLamViec = "Phòng kế toán";
					phongKeToan.themNhanVien();
					break;
				case 3:
					boPhanLamViec = "Phòng bán hàng";
					phongBanHang.themNhanVien();
					break;
				case 4:
					boPhanLamViec = "Phòng IT";
					phongIT.themNhanVien();
					break;
				case 5:
					boPhanLamViec = "Phòng Marketing";
					phongMarketing.themNhanVien();
					break;
				default:break;
				}
				System.out.print("Hệ số lương: ");  
				float heSoLuong = input.nextFloat();
				System.out.print("Số ngày nghỉ phép: ");  
				int soNgayNghiPhep = input.nextInt();
				System.out.print("Ngày vào làm: ");  
				String ngayVaoLam = input.next();
				System.out.print("Số giờ làm thêm: "); 
				int soGioLamThem = input.nextInt();
				Employee nhanVien = new Employee(maNhanVien,tenNhanVien,boPhanLamViec,heSoLuong,soNgayNghiPhep,ngayVaoLam,soGioLamThem);
				nhanVienCongTy.add(nhanVien);
			}
			else if(option == 2) {
				System.out.println("Nhập thông tin quản lý:");  
				System.out.print("Mã nhân viên: ");  
				String maNhanVien = input.next();
				System.out.print("Tên nhân viên: ");  
				String tenNhanVien = input.next();
				System.out.println("Chọn bộ phận làm việc: "); 
				System.out.println("1. Ban Giám Đốc");  
				System.out.println("2. Phòng Kế Toán");  
				System.out.println("3. Phòng Bán Hàng");  
				System.out.println("4. Phòng IT");
				System.out.println("5. Phòng Marketing");
				int maBoPhan = input.nextInt();
				String boPhanLamViec="";
				switch(maBoPhan) {
				case 1:
					boPhanLamViec = "Ban giám đốc";
					banGiamDoc.themNhanVien();
					break;
				case 2:
					boPhanLamViec = "Phòng kế toán";
					phongKeToan.themNhanVien();
					break;
				case 3:
					boPhanLamViec = "Phòng bán hàng";
					phongBanHang.themNhanVien();
					break;
				case 4:
					boPhanLamViec = "Phòng IT";
					phongIT.themNhanVien();
					break;
				case 5:
					boPhanLamViec = "Phòng Marketing";
					phongMarketing.themNhanVien();
					break;
				default:break;
				}
				System.out.print("Hệ số lương: ");  
				float heSoLuong = input.nextFloat();
				System.out.print("Số ngày nghỉ phép: ");  
				int soNgayNghiPhep = input.nextInt();
				System.out.print("Ngày vào làm: ");  
				String ngayVaoLam = input.next();
				System.out.println("Chọn chức danh: "); 
				System.out.println("1. Business Leader");
				System.out.println("2. Project Leader");
				System.out.print("3. Technical Leader");
				int option1 = input.nextInt();
				String chucDanh="";
				if(option1==1) {
					chucDanh = "Business Leader";
				}
				else if(option1==2) {
					chucDanh = "Project Leader";
				}
				else if(option1==2) {
					chucDanh = "Technical Leader";
				}
				Manager quanLy = new Manager(maNhanVien,tenNhanVien,boPhanLamViec,heSoLuong,soNgayNghiPhep,ngayVaoLam,chucDanh);
				nhanVienCongTy.add(quanLy);
			}
			
			System.out.print("Bạn có muốn tiếp tục thêm nhân viên mới?(Y/N)");
			String option1 = input.next();
			if(option1.toLowerCase().equals("y")||option1.toLowerCase().equals("yes")) {
				y=true;
			}
			else {
				y=false;
			}
		}
		while(y==true);
	}
	public static void timKiemThongTinNhanVien() {
		boolean y = true;

		do {
			System.out.println("---Tìm kiếm thông tin nhân viên---");
			System.out.println("---Chọn cách thức tìm");
			System.out.println("1. Theo mã số");
			System.out.println("2. Theo tên");
			int option = input.nextInt();
			if(option==1) {
				System.out.print("Nhập mã nhân viên: ");
				String maNhanVien = input.next();
				for(Object nhanVien : nhanVienCongTy) {
					if (nhanVien.getClass() == Manager.class) {
						Manager manager = (Manager) nhanVien;
						if(manager.maNhanVien.equals(maNhanVien)) {
							manager.displayInformation();
						}
					}
					if (nhanVien.getClass() == Employee.class) {
						Employee nhanVienBt = (Employee) nhanVien;
						if(nhanVienBt.maNhanVien.equals(maNhanVien)) {
							nhanVienBt.displayInformation();
						}
					}
				}
			}
			else {
				System.out.print("Nhập tên nhân viên: ");
				String tenNhanVien = input.next();
				for(Object nhanVien : nhanVienCongTy) {
					if (nhanVien.getClass() == Manager.class) {
						Manager manager = (Manager) nhanVien;
						if(manager.tenNhanVien.equals(tenNhanVien)) {
							manager.displayInformation();
						}
					}
					if (nhanVien.getClass() == Employee.class) {
						Employee nhanVienBt = (Employee) nhanVien;
						if(nhanVienBt.tenNhanVien.equals(tenNhanVien)) {
							nhanVienBt.displayInformation();
						}
					}
				}
			}
			System.out.print("Bạn có muốn tiếp tục tìm kiếm nhân viên?(Y/N)");
			String option1 = input.next();
			if(option1.toLowerCase().equals("y")||option1.toLowerCase().equals("yes")) {
				y=true;
			}
			else {
				y=false;
			}
		}
		while(y==true);
	}
	public static void hienThiBangLuong() {
		System.out.println("Danh sách nhân viên:");
		int i = 1;
		for(Object nhanVien : nhanVienCongTy) {
			if (nhanVien.getClass() == Manager.class) {
				Manager manager = (Manager) nhanVien;
				System.out.println(i+". "+manager.maNhanVien);  
				System.out.println("-- Tên nhân viên: "+manager.tenNhanVien);
				System.out.println("-- Chức danh: "+manager.chucDanh);
				System.out.println("-- Bộ phận: "+manager.boPhanLamViec);
				System.out.println("-- Hệ số lương: "+manager.heSoLuong);
				System.out.println("-- Số ngày nghỉ phép: "+manager.soNgayNghiPhep);
				System.out.println("-- Ngày vào làm: "+manager.sNgayVaoLam);
//				BigDecimal myNumber = new BigDecimal(manager.calculateSalary());
				System.out.println("-- Lương nhân viên: "+(int)manager.calculateSalary());
			}
			if (nhanVien.getClass() == Employee.class) {
				Employee nhanVienBt = (Employee) nhanVien;
				System.out.println(i+". "+nhanVienBt.maNhanVien);  
				System.out.println("-- Tên nhân viên: "+nhanVienBt.tenNhanVien);
				System.out.println("-- Bộ phận: "+nhanVienBt.boPhanLamViec);
				System.out.println("-- Hệ số lương: "+nhanVienBt.heSoLuong);
				System.out.println("-- Số ngày nghỉ phép: "+nhanVienBt.soNgayNghiPhep);
				System.out.println("-- Ngày vào làm: "+nhanVienBt.sNgayVaoLam);
				System.out.println("-- Số giờ làm thêm: "+nhanVienBt.soGioLamThem);
//				BigDecimal myNumber = new BigDecimal(nhanVienBt.calculateSalary());
				System.out.println("-- Lương nhân viên: "+(int)nhanVienBt.calculateSalary());
			}
			i++;
		}
	}
	public static void hienThiBangLuongSapXep() {
		TreeMap<Double, Object> luongNhanVien = new TreeMap<Double, Object>(); 
		TreeMap<Double, Object> reverseLuongNhanVien = new TreeMap<Double, Object>(Collections.reverseOrder());

		for(Object nhanVien : nhanVienCongTy) {
			if (nhanVien.getClass() == Manager.class) {
				Manager manager = (Manager) nhanVien;
				double salary = manager.calculateSalary();
				luongNhanVien.put(salary,manager);
				reverseLuongNhanVien.put(salary,manager);
			}
			if (nhanVien.getClass() == Employee.class) {
				Employee nhanVienBt = (Employee) nhanVien;
				double salary = nhanVienBt.calculateSalary();
				luongNhanVien.put(salary,nhanVienBt);
				reverseLuongNhanVien.put(salary,nhanVienBt);
			}
		}
		Set<Map.Entry<Double, Object>> mappings = luongNhanVien.entrySet();
		System.out.println("Chọn chế độ hiển thị bảng lương: ");
		System.out.println("1. Hiển thị lương tăng dần");
		System.out.println("2. Hiển thị lương giảm dần");
		int order = input.nextInt();
		if(order==1) {
			int i=1;
			System.out.println("---Danh sách nhân viên theo thứ tự lương(thấp đến cao)---");
			for (Map.Entry<Double, Object> mapping : mappings) {
				Object nhanVien1 = mapping.getValue();
				Double luongNhanVien1 = mapping.getKey();
				if (nhanVien1.getClass() == Manager.class) {
					Manager manager = (Manager) nhanVien1;
					System.out.println(i+". "+manager.maNhanVien);  
					System.out.println("-- Tên nhân viên: "+manager.tenNhanVien);
					System.out.println("-- Chức danh: "+manager.chucDanh);
					System.out.println("-- Bộ phận: "+manager.boPhanLamViec);
					System.out.println("-- Hệ số lương: "+manager.heSoLuong);
					System.out.println("-- Số ngày nghỉ phép: "+manager.soNgayNghiPhep);
					System.out.println("-- Ngày vào làm: "+manager.sNgayVaoLam);
					BigDecimal myNumber = new BigDecimal(luongNhanVien1);
					System.out.println("-- Lương nhân viên: "+myNumber);
				}
				if (nhanVien1.getClass() == Employee.class) {
					Employee nhanVienBt = (Employee) nhanVien1;
					System.out.println(i+". "+nhanVienBt.maNhanVien);  
					System.out.println("-- Tên nhân viên: "+nhanVienBt.tenNhanVien);
					System.out.println("-- Bộ phận: "+nhanVienBt.boPhanLamViec);
					System.out.println("-- Hệ số lương: "+nhanVienBt.heSoLuong);
					System.out.println("-- Số ngày nghỉ phép: "+nhanVienBt.soNgayNghiPhep);
					System.out.println("-- Ngày vào làm: "+nhanVienBt.sNgayVaoLam);
					System.out.println("-- Số giờ làm thêm: "+nhanVienBt.soGioLamThem);
					BigDecimal myNumber = new BigDecimal(luongNhanVien1);
					System.out.println("-- Lương nhân viên: "+myNumber);
				}
				i++;
			}
		}
		else {
			int i=1;
			System.out.println("---Danh sách nhân viên theo thứ tự lương(cao đến thấp)---");
			for (Map.Entry<Double, Object> mapping : reverseLuongNhanVien.entrySet()) {
				Object nhanVien1 = mapping.getValue();
				Double luongNhanVien1 = mapping.getKey();
				if (nhanVien1.getClass() == Manager.class) {
					Manager manager = (Manager) nhanVien1;
					System.out.println(i+". "+manager.maNhanVien);  
					System.out.println("-- Tên nhân viên: "+manager.tenNhanVien);
					System.out.println("-- Chức danh: "+manager.chucDanh);
					System.out.println("-- Bộ phận: "+manager.boPhanLamViec);
					System.out.println("-- Hệ số lương: "+manager.heSoLuong);
					System.out.println("-- Số ngày nghỉ phép: "+manager.soNgayNghiPhep);
					System.out.println("-- Ngày vào làm: "+manager.sNgayVaoLam);
					BigDecimal myNumber = new BigDecimal(luongNhanVien1);
					System.out.println("-- Lương nhân viên: "+myNumber);
				}
				if (nhanVien1.getClass() == Employee.class) {
					Employee nhanVienBt = (Employee) nhanVien1;
					System.out.println(i+". "+nhanVienBt.maNhanVien);  
					System.out.println("-- Tên nhân viên: "+nhanVienBt.tenNhanVien);
					System.out.println("-- Bộ phận: "+nhanVienBt.boPhanLamViec);
					System.out.println("-- Hệ số lương: "+nhanVienBt.heSoLuong);
					System.out.println("-- Số ngày nghỉ phép: "+nhanVienBt.soNgayNghiPhep);
					System.out.println("-- Ngày vào làm: "+nhanVienBt.sNgayVaoLam);
					System.out.println("-- Số giờ làm thêm: "+nhanVienBt.soGioLamThem);
					BigDecimal myNumber = new BigDecimal(luongNhanVien1);
					System.out.println("-- Lương nhân viên: "+myNumber);
				}
				i++;
			}
		}
	}
	public static void pressAnyKeyToContinue() {
		System.out.println("Nhấn phím bất kỳ để quay lại menu chính");
		try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}  
	}
	public static void clearScreen() {
		for (int i = 0; i < 100; ++i) System.out.println();
	}
	public static double getSalary(Staff staff) {
		return ((ICalculator)staff).calculateSalary();		
	}
}
