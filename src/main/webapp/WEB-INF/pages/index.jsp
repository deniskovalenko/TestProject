<%--
  Created by IntelliJ IDEA.
  User: Денис
  Date: 9/17/2014
  Time: 1:29 AM
  To change this template use File | Settings | File Templates.
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head><title>Form handling</title>
<body>
<div id="content">

    <fieldset>
        <legend>Add User</legend>
        <form name="user" action="/add" method="post">
            Firstname: <input type="text" name="firstname" /> <br/>
            Lastname: <input type="text" name="lastname" />   <br/>
            <input type="submit" value="   Save   " />
        </form>  <a href="/clearList">Clear List</a>
    </fieldset>
    <br/>
       <table class="datatable">
        <tr>
            <th>Firstname</th>  <th>Lastname</th>
        </tr>

                   <c:forEach var="listValue" items="${userList}">
                      <tr>
                        <td>${listValue.firstname}</td>
                        <td>${listValue.lastname}</td>
                      </tr>
                   </c:forEach>

    </table>

</div>
</body>
</html>