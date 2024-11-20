 package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Addition extends HttpServlet
{
   public void service(HttpServletRequest req,HttpServletResponse res) throws IOException // only use service method bcoz it belongs to servlet lifecycle
   {
	   int i= Integer.parseInt(req.getParameter("num1"));// converting our string to int so using parse int
	   int j= Integer.parseInt(req.getParameter("num2"));
	   int k = 0;
       String op = req.getParameter("op");

       res.setContentType("text/html");
       PrintWriter out = res.getWriter();

       switch (op)
       {
           case "add":
               k = i + j;
               out.println("Added result is: " + k);
               break;
           case "sub":
               k = i - j;
               out.println("Subtracted result is: " + k);
               break;
           case "mul":
               k = i * j;
               out.println("Multiplied result is: " + k);
               break;
           case "div":
               if (j != 0) {
                   k = i / j;
                   out.println("Divided result is: " + k);
               } else {
                   out.println("Division by zero is not allowed.");
               }
               break;
           default:
               out.println("Invalid operation.");
               break;
       }
	   
   }
}
