import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datamodel.Kcustom;
import util.Info;
import util.UtilDB;

@WebServlet("/SimpleSearchHB")
public class SimpleSearchHB extends HttpServlet implements Info {
   private static final long serialVersionUID = 1L;

   public SimpleSearchHB() {
      super();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String keyword = request.getParameter("keyword").trim();

      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Waiting List";
      String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n"; //
      out.println(docType + //
            "<html>\n" + //
            "<head><title>" + title + "</title></head>\n" + //
            "<body bgcolor=\"#f0f0f0\">\n" + //
            "<h1 align=\"center\">" + title + "</h1>\n");
      out.println("<ul>");

      List<Kcustom> listEmployees = null;
      if (keyword != null && !keyword.isEmpty()) {
         listEmployees = UtilDB.listEmployees(keyword);
      } else {
         listEmployees = UtilDB.listEmployees();
      }
      display(listEmployees, out);
      out.println("</ul>");
      out.println("<a href=/" + projectName + "/" + searchWebName + ">Search Data</a> <br>");
      out.println("</body></html>");
   }

   void display(List<Kcustom> listEmployees, PrintWriter out) {
      for (Kcustom employee : listEmployees) {
         System.out.println(employee.getId() + ", " //
        		 + employee.getItem() + ", " //
                 + employee.getFirstName() + ", " //
                 + employee.getLastName() + ", " //
                 + employee.getPhone() + ", " //
                 + employee.getAddress() + ", " //
                 + employee.getPrice());

         out.println("<li>" + employee.getId() + ", " //
        		 + employee.getItem() + ", " //
                 + employee.getFirstName() + ", " //
                 + employee.getLastName() + ", " //
                 + employee.getPhone() + ", " //
                 + employee.getAddress() + ", " //
               + employee.getPrice() + "</li>");
      }
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }
}
