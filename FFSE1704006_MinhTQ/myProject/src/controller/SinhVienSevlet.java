package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import model.Dao.SinhVienDAO;
import model.entity.SinhVien;

/**
 * Servlet implementation class SinhVienSevlet
 */
public class SinhVienSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SinhVienDAO sinhvienDao = new SinhVienDAO();
	
	 
    // location to store file uploaded
    private static final String UPLOAD_DIRECTORY = "upload";
 
    // upload settings
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SinhVienSevlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		String page = request.getParameter("page");
		int i = Integer.parseInt(page);
		request.setAttribute("page", i);

		List<SinhVien> listSinhVien = sinhvienDao.getAllSinhVien();
		int allItem = listSinhVien.size();

		int reCordInPage = 1;
		String t = String.valueOf(reCordInPage);

		double totalPage = allItem / reCordInPage + ((allItem % reCordInPage) == 0 ? 0 : 1);
		int total = (int) totalPage;
		request.setAttribute("toatalPage", total);

		double indexStart = (i - 1) * reCordInPage;
		int s = (int) indexStart;

		sinhvienDao.PTtrang(s, t);
		List<SinhVien> pageSinhVien = sinhvienDao.PTtrang(s, t);
		request.setAttribute("SinhVien", pageSinhVien);
		request.getRequestDispatcher("ViewSinhVien.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// checks if the request actually contains upload file
//        if (!ServletFileUpload.isMultipartContent(request)) {
//            // if not, we stop here
//            PrintWriter writer = response.getWriter();
//            writer.println("Error: Form phải có enctype=multipart/form-data. OK!");
//            writer.flush();
//            return;
//        }
// 
//        // configures upload settings
//        DiskFileItemFactory factory = new DiskFileItemFactory();
//        // sets memory threshold - beyond which files are stored in disk
//        factory.setSizeThreshold(MEMORY_THRESHOLD);
//        // sets temporary location to store files
//        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
// 
//        ServletFileUpload upload = new ServletFileUpload(factory);
// 
//        // sets maximum size of upload file
//        upload.setFileSizeMax(MAX_FILE_SIZE);
// 
//        // sets maximum size of request (include file + form data)
//        upload.setSizeMax(MAX_REQUEST_SIZE);
// 
//        // constructs the directory path to store upload file
//        // this path is relative to application's directory
//        String uploadPath = getServletContext().getRealPath("")
//                + File.separator + UPLOAD_DIRECTORY;
// 
//        // creates the directory if it does not exist
//        File uploadDir = new File(uploadPath);
//        if (!uploadDir.exists()) {
//            uploadDir.mkdir();
//        }
// 
//        try {
//            // parses the request's content to extract file data
//            @SuppressWarnings("unchecked")
//            List<FileItem> formItems = upload.parseRequest(request);
// 
//            if (formItems != null && formItems.size() > 0) {
//                // iterates over form's fields
//                for (FileItem item : formItems) {
//                    // processes only fields that are not form fields
//                    if (!item.isFormField()) {
//                        String fileName = new File(item.getName()).getName();
//                        String filePath = uploadPath + File.separator + fileName;
//                        File storeFile = new File(filePath);
// 
//                        // saves the file on disk
//                        item.write(storeFile);
//                        request.setAttribute("message",
//                                "Upload thành  công  >>" + UPLOAD_DIRECTORY + "/" + fileName);
//                    }
//                }
//            }
//        } catch (Exception ex) {
//            request.setAttribute("message",
//                    "không được rồi : " + ex.getMessage());
//        }
//        // redirects client to message page
//        getServletContext().getRequestDispatcher("/ViewSinhVien.jsp").forward(
//                request, response);
	}
}
