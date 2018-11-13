package model.form;


	import java.io.IOException;
	import java.util.logging.Level;
	import java.util.logging.Logger;
	import javax.faces.bean.ManagedBean;
	import javax.faces.bean.RequestScoped;
	import javax.faces.context.FacesContext;
	import javax.servlet.http.Part;
	/**
	 *
	 * @author Nghĩa Truong
	 */
	@ManagedBean
	@RequestScoped
	public class Upload_File {
	 
	    private Part file;
	    private String fileName;
	    private long fileSize;
	     
	    /**
	     * Creates a new instance of Upload_File
	     */
	    public Upload_File() {
	    }
	 
	    public Part getFile() {
	        return file;
	    }
	 
	    public void setFile(Part file) {
	        this.file = file;
	    }
	 
	    public String getFileName() {
	        return fileName;
	    }
	 
	    public void setFileName(String fileName) {
	        this.fileName = fileName;
	    }
	     
	    public String upload()
	    {
	        try {
	            // get name of selected file
	            fileName = file.getSubmittedFileName();
	            // get file's size
	            fileSize = file.getSize();
	            // get fullpath of opload folder in web root
	            String dirPath= FacesContext.getCurrentInstance().getExternalContext().getRealPath("/images");
	            // write file to upload folder
	            file.write(dirPath + "/" + fileName);
	             
	        } catch (IOException ex) {
	            Logger.getLogger(Upload_File.class.getName()).log(Level.SEVERE, null, ex);
	        }
	         
	        return "index";
	    }
	 
	    public long getFileSize() {
	        return fileSize;
	    }
	 
	    public void setFileSize(long fileSize) {
	        this.fileSize = fileSize;
	    }
	
}
