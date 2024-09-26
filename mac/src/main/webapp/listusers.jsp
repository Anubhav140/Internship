<jsp:include page="include/header.jsp"/>
<%@ page import="java.util.List" %>
<%@ page import="pnb.entity.User" %>

<h1>Cases</h1>
<table border="1">
<thead>
    <th>CaseID</th>
    <th>CaseType</th>
    <th>Description</th>
    <th>Number_Of_Files</th>
    <th>Operation(s)</th>
</thead>

<%
List<User> listusers = (List<User>)request.getAttribute("listusers");
for(User _user: listusers){
    out.print("<tr>");
    out.print("<td>" + _user.getCaseID() + "</td>");
    out.print("<td>" + _user.getCaseType() + "</td>");
    out.print("<td>" + _user.getDescription() + "</td>");
    out.print("<td>" + _user.getNumber_Of_Files() + "</td>");
    out.print("<td> <a href='" + request.getContextPath() + "/site?page=UpdateCase&CaseID=" + _user.getCaseID() +
              "&CaseType=" + _user.getCaseType() + "&Description=" + _user.getDescription() +
              "&numfiles=" + _user.getNumber_Of_Files() + "'>Edit Form</a> </td>");
    out.print("</tr>");
}
%>
</table>
<jsp:include page="include/footer.jsp"></jsp:include>
