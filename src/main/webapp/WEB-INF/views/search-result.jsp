<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<body>

<h2>All Employees</h2>
<br>

<table>
    <tr>
        <th>Name</th>
        <th>SurName</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Works</th>
        <th>Operations</th>
    </tr>

    <c:forEach var="emp" items="${employee}">

         <tr>
            <td>${emp.name}</td>
            <td>${emp.surname}</td>
            <td>${emp.department}</td>
            <td>${emp.salary}</td>
            <td>${emp.works}</td>
            <td>


         </tr>
    </c:forEach>
    <br>

</table>
<br>
<br>
All Peoples : ${count}
<br>
<br>

<a href="/people">Go To Home</a>

<br>
<br>


</body>
</html>

