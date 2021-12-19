package com.octest.servlets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/UploadFile")
public class UploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final int TAMPON = 10240;
	public static final String file_route = "c:/java-server/final/";
       
    public UploadFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/uploadFile.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String description = request.getParameter("description");
		request.setAttribute("description", description);
		
		Part part = request.getPart("file");
		
		String fileName = getFileName(part);
		
		if (fileName != null && !fileName.isEmpty()) {
			
            String champName = part.getName();
            // Internet Explorer bug
            fileName = fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1);

            writeFile(part, fileName,  file_route);

            request.setAttribute(champName, fileName);
        }
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/uploadFile.jsp").forward(request, response);
	}
	
	 private void writeFile( Part part, String fileName, String route ) throws IOException {
		 	System.out.println(part);
		 	System.out.println(fileName);
		 	System.out.println(route);
	        BufferedInputStream entree = null;
	        BufferedOutputStream sortie = null;
	        try {
	        	
	            entree = new BufferedInputStream(part.getInputStream(), TAMPON);
	            sortie = new BufferedOutputStream(new FileOutputStream(new File(route + fileName)), TAMPON);
	           
	            byte[] tampon = new byte[TAMPON];
	            int longueur;
	            while ((longueur = entree.read(tampon)) > 0) {
	                sortie.write(tampon, 0, longueur);
	            }
	        } finally {
	            try {
	                sortie.close();
	            } catch (IOException ignore) {
	            	System.out.println(ignore);
	            }
	            try {
	                entree.close();
	            } catch (IOException ignore) {
	            }
	        }
	    }
	
	private static String getFileName(Part part) {
		for( String contentDisposition : part.getHeader("content-disposition").split(";")) {
			if (contentDisposition.trim().startsWith("filename")) {
				return contentDisposition.substring(contentDisposition.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

}
