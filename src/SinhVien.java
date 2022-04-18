import java.util.Iterator;
import java.util.Scanner;

public class SinhVien {
	private int maSV;
	private String tenSV;
	private float diemToan;
	private float diemLy;
	private float diemHoa;
	private float diemTB = 0;
	private String xepLoai = "Chưa xếp loại";
	
	public int getMaSV() {
		return maSV;
	}

	public void setMaSV(int maSV) {
		this.maSV = maSV;
	}
	
	
	public String getTenSV() {
		return tenSV;
	}

	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}
	
	public float getDiemToan() {
		return diemToan;
	}

	public void setDiemToan(float diemToan) {
		this.diemToan = diemToan;
	}
	
	public float getDiemLy() {
		return diemLy;
	}

	public void setDiemLy(float diemLy) {
		this.diemLy = diemLy;
	}
	
	public float getDiemHoa() {
		return diemHoa;
	}

	public void setDiemHoa(float diemHoa) {
		this.diemHoa = diemHoa;
	}
	
	public float getDiemTB() {
		return diemTB;
	}

	public void setDiemTB(float diemTB) {
		this.diemTB = diemTB;
	}
	
	public String getXepLoai() {
		return xepLoai;
	}

	public void setXepLoai(String xepLoai) {
		this.xepLoai = xepLoai;
	}
	
	public SinhVien(int maSV, String tenSV, float diemToan, float diemLy, float diemHoa) {
		this.maSV = maSV;
		this.tenSV = tenSV;
		this.diemToan = diemToan;
		this.diemLy = diemLy;
		this.diemHoa = diemHoa;
	}

	public SinhVien() {
		// TODO Auto-generated constructor stub
	}
	
	public void tinhDiemTB() {
		this.diemTB = (this.diemToan + this.diemLy + this.diemHoa) / 3;
	}
	
	public void xepLoai() {
		if(this.diemTB <= 10 && this.diemTB >= 9) {
			this.xepLoai = "Xuất sắc";
		} else if(this.diemTB < 9 && this.diemTB >= 8) {
			this.xepLoai = "Giỏi";
		} else if(this.diemTB < 8 && this.diemTB >= 7) {
			this.xepLoai = "Khá";
		} else if(this.diemTB < 7 && this.diemTB >= 6) {
			this.xepLoai = "Trung bình - Khá";
		} else if(this.diemTB < 6 && this.diemTB >= 5) {
			this.xepLoai = "Trung bình";
		} else {
			this.xepLoai = "Yếu";
		}
	}

	public void nhapSinhvien(int stt) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhập vào sinh viên là thứ: " + stt);
		System.out.print("\tNhập vào mã sinh viên: ");
		this.maSV = Integer.parseInt(scan.nextLine());
		
		System.out.print("\tNhập vào tên sinh viên: ");
		this.tenSV = scan.nextLine();
		
		this.diemToan = kiemTraDiemHopLe("toán");
		
		this.diemLy = kiemTraDiemHopLe("lý");

		this.diemHoa = kiemTraDiemHopLe("hóa");
	}
	
	public float kiemTraDiemHopLe(String monHoc) {
		Scanner scan = new Scanner(System.in);
		float diem;
		do {
			System.out.print("\tNhập diểm" + " "+ monHoc + " " + "từ 0 - 10: ");
			diem = Integer.parseInt(scan.nextLine());
		} while (diem > 10 || diem < 0);
		return diem;
	}
	
	public void xuatSinhVien(int stt) {
		DanhSachSinhVien dssv = new DanhSachSinhVien();
		
		System.out.print(stt+ "\t|");
		System.out.print(this.maSV + "\t\t|");
		System.out.print(this.tenSV + "\t\t\t|");
		System.out.print(this.diemToan + "\t\t" + "|");
		System.out.print(this.diemLy + "\t\t" + "|");
		System.out.print(this.diemHoa  + "\t\t|");
		System.out.print(this.diemTB  + "\t\t\t|");
		System.out.print(this.xepLoai  + "\t" + "\n");
		dssv.gach();
	}

	public void remove(Iterator<SinhVien> sv) {
		// TODO Auto-generated method stub
		
	}
}
