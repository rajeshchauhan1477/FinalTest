<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
    <%@ page isELIgnored="false" %>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Operations</title>
</head>
<body>
    <div>
        <h2>New Operation</h2>
        <div>
            <div>
                <form:form action="/add" modelAttribute="operation" method="post">
                    <div>
                        <div>
                            <form:label path="input">Input</form:label>
                            <form:input type="text" id="input" path="input"/>
                            <form:errors path="input" />
                        </div>
                    </div>
                    </div>
                        <div>
                            <input type="submit" value="Evaluate and Add Operation">
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
    </body>
</html>