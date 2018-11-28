package fasttrackse.ffse1704.fbms.entity.thongtinlogwork.quanlythoigian;



	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table(name = "qltg_trang_thai")
	public class TrangThaiThongTinLogwork {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id_trang_thai", unique = true, length = 11)
		private int idTrangThai;
		
		public TrangThaiThongTinLogwork(int idTrangThai, String tenTrangThai) {
			super();
			this.idTrangThai = idTrangThai;
			this.tenTrangThai = tenTrangThai;
		}

		@Column(name = "ten_trang_thai", nullable = true, length = 11)
		private String tenTrangThai;

		public int getIdTrangThai() {
			return idTrangThai;
		}

		public void setIdTrangThai(int idTrangThai) {
			this.idTrangThai = idTrangThai;
		}

		public String getTenTrangThai() {
			return tenTrangThai;
		}

		public void setTenTrangThai(String tenTrangThai) {
			this.tenTrangThai = tenTrangThai;
		}
		
	}
