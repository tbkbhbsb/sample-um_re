<!DOCTYPE html>
<html>
<head>
<title>Search Form</title>
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/app/css/styles.css">
</head>
<body>
    <div id="wrapper">
        <p>Please input search criteria.</p>
    </div>



    <div>
         <!-- (1) -->
        <c:if test="${param.error}">
            <!-- (2) -->
            <t:messagesPanel messagesType="error"
                messagesAttributeName="SPRING_SECURITY_LAST_EXCEPTION" />
        </c:if>

        <!-- (3) -->
        <form:form action="${pageContext.request.contextPath}/searchResult">
            <table>
                <tr>
                    <td><label for="userId">ユーザID:</label></td>
                    <td><input type="text" id="userId" name="userId"></td><!-- (4) -->
                </tr>
                <tr>
                    <td><label for="Name">ユーザ名:</label></td>
                    <td><input type="text" id="Name" name="Name"/></td><!-- (5) -->
                </tr>
                <tr>
                    <td><label for="dateOfBirth">生年月日:</label></td>
                    <td><input type="text" id="dateOfBirth" name="dateOfBirth"/></td><!-- (5) -->
                </tr>
                <tr>
                    <td><label for="address">住所:</label></td>
                    <td><input type="text" id="address" name="address"/></td><!-- (5) -->
                </tr>
                <tr>
                    <td><label for="phoneNumber">電話番号:</label></td>
                    <td><input type="text" id="phoneNumber" name="phoneNumber"/></td><!-- (5) -->
                </tr>
                 <tr>
                    <td><label for="phoneNumber">権限:</label></td>
                    <td>
                        <select id="status" name="status">
                            <option value="1">USER</option>
                            <option value="2">ADMIN</option>
                        </select>
                    </td><!-- (5) -->
                </tr>
                 <tr>
                    <td><label for="status">状態:</label></td>
                    <td>
                        <select id="status" name="status">
                            <option value="1">ACTV</option>
                            <option value="2">INIT</option>
                            <option value="3">RIMV</option><!-- 怪しい -->
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td><input type="submit" name="Search" value="Search" /></td>
                </tr>
            </table>
        </form:form>
    </div>


</body>
</html>