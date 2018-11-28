package fasttrackse.ffse1704.fbms.entity.quanlynhansu;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="thong_tin_bang_cap")
public class BangCap implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "ma_nhan_vien", nullable = false)
	private NhanSu nhanSu;
	
	@Column(name = "id_trinh_do", nullable = false)
	private Integer idTrinhDo;
	
	@Column(name = "ten_nganh", nullable = false)
	private String tenNganh;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "thoi_gian", nullable = false)
	@NotNull
	private Date thoiGian;
	
	@Column(name = "xep_loai", nullable = false)
	private String xepLoai;
	
	@Column(name = "noi_cap", nullable = false)
	private String noiCap;
}
