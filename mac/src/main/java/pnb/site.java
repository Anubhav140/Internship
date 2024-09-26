package pnb;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pnb.entity.User;
import pnb.model.UsersModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class site
 */
@WebServlet("/site")
public class site extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page").toLowerCase();
        switch (page) {
            case "listusers": 
                listusers(request, response); 
                break;
            case "addcase": 
                addcase(request, response); 
                break;
                
            case "updatecase": 
                updatecase(request, response); 
                break;
                
                
            default:
                request.setAttribute("title", "Error");
                request.getRequestDispatcher("error.jsp").forward(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String form = request.getParameter("form");
        
        String caseID = request.getParameter("CaseID");
        String caseType = request.getParameter("CaseType"); // Retrieve caseType
        String description = request.getParameter("description"); // Ensure this matches the textarea in the form
        int numberOfFiles = Integer.parseInt(request.getParameter("numfiles")); // Use the correct field name "numfiles"
        
        
        
        if (form == null) {
            // Handle the case where the form parameter is missing
            request.setAttribute("title", "Error");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            return;
        }
        
        form = form.toLowerCase();  // Only call toLowerCase if form is not null
        
        switch (form) {
        
            case "addcase":
                // Retrieve all necessary parameters including caseType
               
                // Create a User object with the new constructor
                User user = new User(caseID, caseType, description, numberOfFiles);
                new UsersModel().addCase(user);
                
                // Redirect to the list of users
                listusers(request, response);
                break;
                
            case "updatecase":
                // Retrieve all necessary parameters including caseType
                
                // Create a User object with the new constructor
                User update = new User(caseID, caseType, description, numberOfFiles);
                new UsersModel().updateCase(update);
                
                // Redirect to the list of users
                listusers(request, response);
                break;
                
            default:
                // Handle default case
                request.setAttribute("title", "Error");
                request.getRequestDispatcher("error.jsp").forward(request, response);
                break;
        }
    }

    protected void listusers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = new ArrayList<>();
        users = new UsersModel().listuser();
        request.setAttribute("listusers", users);
        request.setAttribute("title", "List users");
        request.getRequestDispatcher("listusers.jsp").forward(request, response);
    }

    protected void addcase(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Add Case");
        request.getRequestDispatcher("form.jsp").forward(request, response);
    }
    
    protected void updatecase(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Update Case");
        request.getRequestDispatcher("UpdateCase.jsp").forward(request, response);
    }
}
