package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Download")
public class Download extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public Download()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	
    	String fileName = request.getParameter("name");
    	
        // Get the path to the file and create a java.io.File object
        String path = getServletContext().getRealPath( "/WEB-INF/files/" + fileName);
        
        File file = new File( path );
        
        String mimeType = URLConnection.guessContentTypeFromName(file.getName());
        // Set the response headers. File.length() returns the size of the file
        // as a long, which we need to convert to a String.

        response.setContentType(mimeType);
        response.setHeader( "Content-Length", "" + file.length() );
        response.setHeader( "Content-Disposition", "inline; filename=" + fileName);
        //response.setHeader( "Content-Disposition", "attachment; filename=cs3220.png" );
        
        // Binary files need to read/written in bytes.
        FileInputStream in = new FileInputStream( file );
        OutputStream out = response.getOutputStream();
        byte buffer[] = new byte[2048];
        int bytesRead;
        while( (bytesRead = in.read( buffer )) > 0 )
            out.write( buffer, 0, bytesRead );
        in.close();
    }

}
