import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DanhSachSinhVien {
	private static final Object SinhVien = null;
	private List<SinhVien> danhSachSinhVien;
	
	public DanhSachSinhVien() {
		this.danhSachSinhVien = new ArrayList<SinhVien>();
	}
	
	public void themSinhVien(SinhVien sv) {
		this.danhSachSinhVien.add(sv);
	}
	
	public SinhVien svDiemTBCaoNhat() {
		SinhVien ketQua = this.danhSachSinhVien.get(0);
		header();
		for(SinhVien sv: this.danhSachSinhVien) {
			if(sv.getDiemTB() > ketQua.getDiemTB()) {
				ketQua = sv;
			}
		}
		return ketQua;
	}
	
	public void tatCaSinhVienYeu() {
		int stt = 0;
		header();
		for(SinhVien sv: this.danhSachSinhVien) {
			if(sv.getDiemTB() < 5) {
				stt++;
				sv.xuatSinhVien(stt);
			}
		}
		if(stt == 0) {
			System.out.println("\t\t\t\t\t\t\t KHÔNG CÓ SINH VIÊN LOẠI YẾU");
		}
	}
	
	public List<SinhVien> timSinhVienTheoTen(String ten) {
		List<SinhVien> result = new ArrayList<SinhVien>();
		header();
		for(SinhVien sv: this.danhSachSinhVien) {
			if(sv.getTenSV().toLowerCase().equals(ten.toLowerCase())) {
				result.add(sv);
			}
		}
		return result;
	}
	
	public SinhVien timSinhVienTheoMa(int maSV) {
		SinhVien kq = null;
		for(SinhVien sv: this.danhSachSinhVien) {
			if(sv.getMaSV() == maSV) {
				kq = sv;
				break;
			}
		}
		return kq;
	}
	
	public void xoaMotSinhVienTheoMa(int maSV) {
		Scanner scan = new Scanner(System.in);
		
		char chon;
		int stt = 0;
		
		// Cách 1: Dùng Iterator.
		Iterator<SinhVien> sv = danhSachSinhVien.iterator();
		while(sv.hasNext()) {
			SinhVien danhSachSinhVien = sv.next();
			if(danhSachSinhVien.getMaSV() == maSV) {
				stt++;
				System.out.println("Bạn có chắc chắn xóa hay không ?? Chọn 'Y' hoặc 'N'");
				chon = scan.nextLine().charAt(0);
				switch (chon) {
				case 'Y': {
//					this.danhSachSinhVien.remove(sv);
					sv.remove();
					System.out.print("Bạn đã xóa sinh viên có mã: " + maSV);
					break;
				}
				case 'N': {
					break;
				}
				default:
					break;
				}		
			}
		}
		
		// Cách 2: Dùng For each.
//		for(SinhVien sv: this.danhSachSinhVien) {
//			if(sv.getMaSV() == maSV) {
//				stt++;
//				System.out.println("Bạn có chắc chắn xóa hay không ?? Chọn 'Y' hoặc 'N'");
//				chon = scan.nextLine().charAt(0);
//				switch (chon) {
//				case 'Y': {
//					this.danhSachSinhVien.remove(sv);
//					System.out.print("Bạn đã xóa sinh viên có mã: " + maSV);
//					break;
//				}
//				case 'N': {
//					break;
//				}
//				default:
//					break;
//				}		
//			}
//		}
		if(stt == 0) {
			header();
			System.out.println("\t\t\t\t\t\t\t KHÔNG TÌM THẤY SINH VIÊN NÀO ĐỂ XÓA");
		}
	}
	
	private SinhVien danhSachSinhVien() {
		// TODO Auto-generated method stub
		return null;
	}

	public void xuatTatCaSinhVien() {
		int stt = 0;
		header();
		for(SinhVien sv: this.danhSachSinhVien) {
			stt++;
			sv.xuatSinhVien(stt);
		}
	}
	
	public void header() {
		System.out.println("\n-------------------------------------------------------------THÔNG TIN SINH VIÊN-------------------------------------------------------------------");
		System.out.print("STT \t|");
		System.out.print("Mã sinh viên \t|");
		System.out.print("Tên sinh viên \t\t|");
		System.out.print("Điểm toán\t|");
		System.out.print("Điểm lý \t|");
		System.out.print("Điểm hóa \t|");
		System.out.print("Điểm Trung bình \t|");
		System.out.print("Xếp loại \n");
		gach();
	} 
	
	public void gach() {
		System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------------");
	}
}
