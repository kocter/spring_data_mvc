<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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

        <c:url var="updateButton" value="/updateInfo">
            <c:param name="empId" value="${emp.id}"/>
        </c:url>





       <c:url var="deleteButton" value="/deleteEmployee">
            <c:param name="empId" value="${emp.id}"/>
        </c:url>

         <tr>
            <td>${emp.name}</td>
            <td>${emp.surname}</td>
            <td>${emp.department}</td>
            <td>${emp.salary}</td>
            <td>${emp.works}</td>
            <td>
                <input type="button" value="Update" onclick="window.location.href='${updateButton}'"/>


                <input type="button" value="Delete" onclick="window.location.href='${deleteButton}'"/>

         </tr>
    </c:forEach>
    <br>

</table>
<br>
<br>
All Peoples : ${count}
<br>
<br>
<table>
<td><input type="button" value="searchByName" onclick="window.location.href='enterName'"/></td>
<td><input type="button" value="searchByTime" onclick="window.location.href='enterDate'"/></td>
<td><input type="button" value="searchByExperience" onclick="window.location.href='enterExperience'"/></td>
</table>
<br>
<br>
<input type="button" value="Add" onclick="window.location.href='addNewPeople'"/>

</body>
</html>

