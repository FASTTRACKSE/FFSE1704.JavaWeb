package fasttrackse.jsfproject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import fasttrackse.jsfproject.dao.*;
import fasttrackse.jsfproject.entity.*;

@ManagedBean
@SessionScoped
public class StudentController {
	private int pageNumber = 1;
	private int pageTotal = 1;
	private int perPage = 10;
	private int pageJump = 5;

	private List<Student> students;
	private StudentDAO studentDAO;
	private Logger logger = Logger.getLogger(getClass().getName());

	public StudentController() throws Exception {
		students = new ArrayList<>();

		studentDAO = StudentDAO.getInstance();

		// To get paging information from facescontext through web.xml
		FacesContext ctx = FacesContext.getCurrentInstance();
		perPage = Integer.parseInt(ctx.getExternalContext().getInitParameter("paging_size"));
		pageJump = Integer.parseInt(ctx.getExternalContext().getInitParameter("paging_jump"));
		
		// Get list of students
		loadStudentList();
	}

	public int getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}

	public void countPageTotal() {
		int totalStudents = 0;

		logger.info("Get total students");

		try {

			// get all students from database
			totalStudents = studentDAO.countStudents();

		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error counting students", exc);

			// add error message for JSF page
			addErrorMessage(exc);
		}
		pageTotal = (int) Math.ceil((double) totalStudents / (double) perPage);
		if (pageNumber > pageTotal) {
			pageNumber = pageTotal;
		}
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getFirstPage() {
		this.pageNumber = 1;
		loadStudentList();
		return "list-students";
	}

	public String getLastPage() {
		this.pageNumber = pageTotal;
		loadStudentList();
		return "list-students";
	}

	public String getPrevPage() {
		if (pageNumber > 1) {
			pageNumber--;
			loadStudentList();
		}
		return "list-students";
	}

	public String getNextPage() {
		if (pageNumber < pageTotal) {
			pageNumber++;
			loadStudentList();
		}
		return "list-students";
	}

	public String getFastPrevPage() {
		if (pageNumber > pageJump) {
			pageNumber -= pageJump;
		} else {
			pageNumber = 1;
		}
		loadStudentList();

		return "list-students";
	}

	public String getFastNextPage() {
		if (pageNumber < pageTotal - pageJump) {
			pageNumber += pageJump;
		} else {
			pageNumber = pageTotal;
		}
		loadStudentList();

		return "list-students";
	}

	public List<Student> getStudents() {
		return students;
	}

	public void loadStudentList() {

		logger.info("Loading students");

		students.clear();

		countPageTotal();

		try {

			// get all students from database
			students = studentDAO.getStudents(pageNumber, perPage);

		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error loading students", exc);

			// add error message for JSF page
			addErrorMessage(exc);
		}
	}

	public String addStudent(Student theStudent) {

		logger.info("Adding student: " + theStudent);

		try {

			// add student to the database
			studentDAO.addStudent(theStudent);

		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error adding students", exc);

			// add error message for JSF page
			addErrorMessage(exc);

			return null;
		}

		return "list-students?faces-redirect=true";
	}

	public String loadStudent(int studentId) {

		logger.info("loading student: " + studentId);

		try {
			// get student from database
			Student theStudent = studentDAO.getStudent(studentId);

			// put in the request attribute ... so we can use it on the form page
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

			Map<String, Object> requestMap = externalContext.getRequestMap();
			requestMap.put("student", theStudent);

		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error loading student id:" + studentId, exc);

			// add error message for JSF page
			addErrorMessage(exc);

			return null;
		}

		return "update-student-form.xhtml";
	}

	public String updateStudent(Student theStudent) {

		logger.info("updating student: " + theStudent);

		try {

			// update student in the database
			studentDAO.updateStudent(theStudent);

		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error updating student: " + theStudent, exc);

			// add error message for JSF page
			addErrorMessage(exc);

			return null;
		}

		return "list-students?faces-redirect=true";
	}

	public String deleteStudent(int studentId) {

		logger.info("Deleting student id: " + studentId);

		try {

			// delete the student from the database
			studentDAO.deleteStudent(studentId);

		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error deleting student id: " + studentId, exc);

			// add error message for JSF page
			addErrorMessage(exc);

			return null;
		}
		loadStudentList();
		return "list-students";
	}

	private void addErrorMessage(Exception exc) {
		FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
