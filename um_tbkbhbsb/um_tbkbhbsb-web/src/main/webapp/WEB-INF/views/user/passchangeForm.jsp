<div id="wrapper">
    <h1>パスワード変更</h1>
    <form:form modelAttribute="PasswordUpdateForm"
        action="${pageContext.request.contextPath}/user/passChange" method="post">

        <table>
            <tr>
                <td><form:label path="userId">ユーザID:</form:label></td>
                <td>${f:h(PasswordUpdateForm.userId)}</td>
                <td><form:errors path="userId" /></td>
                <form:hidden path="userId"/>
            </tr>
            <tr>
                <td><form:label path="password">パスワード:</form:label></td>
                <td><form:password path="password"/></td>
                <td><form:errors path="password" /></td>
            </tr>
            <tr>
                <td><form:label path="passwordConfirm">パスワード確認:</form:label></td>
                <td><form:password path="passwordConfirm" /></td>
                <td><form:errors path="passwordConfirm" /></td>
            </tr>
            <tr>
                <td><button type="submit" name="finish" value="">パスワード変更</button></td>
            </tr>
        </table>
    </form:form>
</div>