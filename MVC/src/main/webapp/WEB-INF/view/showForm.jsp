<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<body>
<br>
<br>
<h2> Dear Employee, you are welcome! </h2>
<br>
<br>
<br>
Your name: ${employee.name}
<br>
Your surname: ${employee.surname}
<br>
Your age: ${employee.age}
<br>
Your profession: ${employee.profession}
<br>
Your education: ${employee.education}
<br>
language (s)
<ul>
    <c:forEach var="lang" items="${employee.languages}">
        <li> ${lang} </li>
    </c:forEach>
</ul>
Phone number: ${employee.phoneNumber}
<br>
Email: ${employee.email}
</body>
</html>