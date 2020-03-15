<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <%@ page isELIgnored="false" %>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Operation</title>
</head>
<body>
    <div>
        <div>
            <h2>Airthmetic Operation</h2>
            <hr/>
            <a href="/new-operation">
                <button type="submit">Add new operation</button>
            </a>
            <br/><br/>
            <div>
                <div>
                    <div>History of operations</div>
                </div>
                <div>
                    <table>
                        <tr>
                            <th>Id</th>
                            <th>Operations</th>
                        </tr>
                        <c:forEach var="operation" items="${operations}">
                            <tr>
                                <td>${operation.id}</td>
                                <td>${operation.input}</td>
                                <td>
                                    <form action="/${operation.id}/delete" method="post">
                                        <input type="submit" value="Delete" />
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>