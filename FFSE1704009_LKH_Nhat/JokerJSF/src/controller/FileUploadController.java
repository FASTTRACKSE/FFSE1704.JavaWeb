package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;

import model.service.Constants;
import model.service.Utils;
@ManagedBean
@ViewScoped
public class FileUploadController implements Serializable {
    private static final long serialVersionUID = 1L;
    private Part file;
    private String message;
    private String fileName;
    public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Part getFile() {
        return file;
    }
    public void setFile(Part file) {
        this.file = file;
    }
    
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String uploadFile() throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        FacesContext context = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) context
                .getExternalContext().getContext();
        String path = servletContext.getRealPath("");
        boolean file1Success = false;
        if (file.getSize() > 0) {
        	fileName = Utils.getFileNameFromPart(file);
            /**
            *vị trí file lưu
            */
            File outputFile = new File(path + File.separator + "images"
                    + File.separator + fileName);
            inputStream = file.getInputStream();
            outputStream = new FileOutputStream(outputFile);
            byte[] buffer = new byte[Constants.BUFFER_SIZE];
            int bytesRead = 0;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            if (outputStream != null) {
                outputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            file1Success = true;
        }
        
        if (file1Success) {
            System.out.println("File đã up tại: " + path);
            
            setMessage("File đã được tải lên " + path);
        } else {
           
            setMessage("Lỗi !");
        }
        
        return null;
    }
}
