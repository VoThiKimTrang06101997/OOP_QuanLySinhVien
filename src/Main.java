import java.util.List;
import java.util.Scanner;

public class Main {
	public Main() {
		
	}
	
	public static void main(String[] args) {
		DanhSachSinhVien dssv = new DanhSachSinhVien();
		chonMenu(dssv);
		
	}
	
	public static void chonMenu(DanhSachSinhVien dssv) {
		Scanner scan = new Scanner(System.in);
		int n, stt = 0;
		int maSV;
		boolean thoat = false;
		do {
			thongBao();
			n = Integer.parseInt(scan.nextLine());
			switch(n) {
			case 1 :
				stt++;
				// Nhập sinh viên
				SinhVien sv = new SinhVien();
				sv.nhapSinhvien(stt);
				// Tính điểm Trung bình
				sv.tinhDiemTB();
				// Xếp loại
				sv.xepLoai();
				dssv.themSinhVien(sv);
				break;
				
			case 2: 
				// Xuất sinh viên
				dssv.xuatTatCaSinhVien();
				break;
				
			case 3 :
				// Tìm sinh viên có điểm Trung bình cao nhất
				dssv.svDiemTBCaoNhat().xuatSinhVien(1);
				break;
				
			case 4:
				// In ra tất cả sinh viên yếu
				dssv.tatCaSinhVienYeu();
				break;
				
			case 5:
				// Tìm sinh viên theo tên
				stt = 0;
				System.out.print("Vui lòng nhập vào tên sinh viên cần tìm: ");
				String ten = scan.nextLine();
				List<SinhVien> dsSinhVienTimDuoc = dssv.timSinhVienTheoTen(ten);
				for(SinhVien svTimDuoc: dsSinhVienTimDuoc) {
					stt++;
					svTimDuoc.xuatSinhVien(stt);
				}
				if(stt == 0) {
					System.out.println("\t\t\t\t\t\t\t KHÔNG TÌM THẤY SINH VIÊN NÀO");
				}
				break;
			
			case 6: 
				// Tìm sinh viên theo mã
				System.out.print("Vui lòng nhập vào mã sinh viên cần tìm: ");
				maSV = Integer.parseInt(scan.nextLine());
				dssv.header();
				if(dssv.timSinhVienTheoMa(maSV) != null) {
					dssv.timSinhVienTheoMa(maSV).xuatSinhVien(1);
				} else {
					System.out.println("\t\t\t\t\t\t\t KHÔNG TÌM THẤY SINH VIÊN NÀO");
				}
				break;
			
			case 7: 
				// Xóa 1 sinh viên theo mã
				System.out.println("Vui lòng nhập vào mã sinh viên muốn xóa: ");
				maSV = Integer.parseInt(scan.nextLine());
				dssv.xoaMotSinhVienTheoMa(maSV);
				break;
					
			case 0: 
				System.out.print("Chương trình kết thúc !! ");
				thoat = true;
				break;
			default:
				break;
			}
		} while (!thoat);
	}
	
	public static void thongBao() {
		System.out.print("\nVui lòng chọn tính năng: \n"
		                + "\t1.Nhập vào sinh viên\n"
		                + "\t2.Xuất sinh viên\n"
		                + "\t3.Sinh viên có điểm trung bình cao nhất\n"
		                + "\t4.In ra tất cà sinh viên yếu\n"
		                + "\t5.Tìm sinh viên theo tên\n"
		                + "\t6.Tìm sinh viên theo mã\n"
		                + "\t7.Xóa một sinh viên\n"
		                + "\t0.Thoát chương trình\n");	
	}
}
