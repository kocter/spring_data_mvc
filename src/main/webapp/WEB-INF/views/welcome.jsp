<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<body>
<h2>Hello info</h2>
<br>



<security:authorize access="hasRole('ADMIN')">
<td><input type="button" value="classified-information" onclick="window.location.href='classified-information'"/></td>
</security:authorize>
<td><input type="button" value="people info" onclick="window.location.href='people'"/></td>
</body>

</html>