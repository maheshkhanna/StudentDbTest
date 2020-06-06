//$Id$
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	public static Map<String,String> studentDetails = new HashMap<String,String>();
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		System.out.println(studentDetails);
		String id = request.getParameter("id");
		if(studentDetails.containsKey(id))
		{
			PrintWriter out = response.getWriter();
			out.print(studentDetails.get(id).toString());
			out.close();
		}
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	{
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		studentDetails.put(id, name);
		System.out.println(studentDetails);
	}
	
}
