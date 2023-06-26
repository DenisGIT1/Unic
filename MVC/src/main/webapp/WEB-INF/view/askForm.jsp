<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<body>
<br>
<br>
<h2> Dear Employee, please enter information about you. </h2>
<br>
<br>
<br>

<form:form action="showForm" modelAttribute="employee">
    Name <form:input path="name"/>
    <form:errors path="name"/>
    <br><br>
    Surname <form:input path="surname"/>
    <form:errors path="surname"/>
    <br><br>
    Age <form:input path="age"/>
    <form:errors path="age"/>
    <br><br>
    Profession <form:select path="profession">
    <form:options items="${employee.professions}"/>
</form:select>
    <br><br>
    Choose your education
    College <form:radiobutton path="education" value="Vocational education"/>
    University <form:radiobutton path="education" value="Higher education"/>
    Academy <form:radiobutton path="education" value="Postgraduate education"/>
    <br><br>
    Foreign language (s)
    EN <form:checkbox path="languages" value="English"/>
    RU <form:checkbox path="languages" value="Russian"/>
    DE <form:checkbox path="languages" value="Deutch"/>
    <br><br>
    Phone number <form:input path="phoneNumber"/>
    <form:errors path="phoneNumber"/>
    <br><br>
    Email <form:input path="email"/>
    <form:errors path="email"/>
    <br><br>
    <input type="submit" value="OK">
</form:form>

</body>
</html>