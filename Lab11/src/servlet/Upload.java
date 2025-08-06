package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/Upload")
public class Upload extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public Upload()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	java.text.SimpleDateFormat formatter;
    	
    	formatter = new SimpleDateFormat("M/d/yyyy h:mmaa");
    	
    	String date;
    
    	String fileDir = getServletContext().getRealPath( "/WEB-INF" );
    	
        File  uploadFolder = new File(fileDir, "files");
        
        File[] files = uploadFolder.listFiles();

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title>Upload</title></head><body>");
		out.println("<form action='Upload' method='post' enctype='multipart/form-data'>");
		out.println("<input type='file' name='file1'> <input type='submit' name='upload' value='Upload'></form><br>");
		out.println("<table border='1'>");
		out.println("<tr><th>Name</th><th>Date Uploaded</th><th>Size (Bytes)</th></tr>");
		
		for(File file : files) {
			
			Date  time = new Date(file.lastModified());
			
			date = formatter.format(time);
			
			String fileName = file.getName();
			
			out.println("<tr><td><a href='Download?name=" + fileName + "'>" + fileName + "</a></td><td>" + date + "</td><td>" 
			+ file.length() + "</td></tr>");
		}
		
		out.println("</table>");
		out.println("</body></html>");
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Configure a repository (to ensure a secure temp location is used)
        ServletContext servletContext = this.getServletConfig().getServletContext();
        File repository = (File) servletContext.getAttribute( "javax.servlet.context.tempdir" );
        factory.setRepository( repository );

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload( factory );

        // The directory we want to save the uploaded files to.
        String fileDir = getServletContext().getRealPath( "/WEB-INF/files" );

        // Parse the request
        try
        {
            List<FileItem> items = upload.parseRequest( request );
            for( FileItem item : items )
            {
                // If the item is not a form field - meaning it's an uploaded
                // file, we save it to the target dir
                if( !item.isFormField() )
                {
                    // item.getName() will return the full path of the uploaded
                    // file, e.g. "C:/My Documents/files/test.txt", but we only
                    // want the file name part, which is why we first create a
                    // File object, then use File.getName() to get the file
                    // name.
                    String fileName = (new File( item.getName() )).getName();
                    File file = new File( fileDir, fileName );
                    item.write( file );
                }
            }

        }
        catch( Exception e )
        {
            throw new IOException( e );
        }
        
        response.sendRedirect( "Upload" );
    }

}
