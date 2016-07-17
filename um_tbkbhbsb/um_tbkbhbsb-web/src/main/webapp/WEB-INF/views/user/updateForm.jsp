<h1>Abc Create Form</h1>
<form:form modelAttribute="updateForm"
    action="${pageContext.request.contextPath}/user/registerConfirm">
        <form:label path="userId">ユーザID:</form:label>
        ${f:h(updateForm.userId)}
        <form:hidden path="userId" />
    <br>
        <form:label path="Name">ユーザ名:</form:label>
        <form:input path="Name" />
        <form:errors path="Name" />
    <br>
        <form:label path="dateOfBirth">生年月日:</form:label>
        <form:input path="dateOfBirth" />
        <form:errors path="dateOfBirth" />
    <br>
        <form:label path="address">住所:</form:label>
        <form:input path="address" />
        <form:errors path="address" />
    <br>
        <form:label path="phoneNumber">電話番号:</form:label>
        <form:input path="phoneNumber" />
        <form:errors path="phoneNumber" />
    <br>
        <form:label path="authority">権限:</form:label>
        <input type="checkbox" value="ADMIN">ADMIN</input>
        <input type="checkbox" value="USER">USER</input>
        <form:errors path="authority" />
    <br>
        <form:label path="password">パスワード:</form:label>
        <form:input path="password" />
        <form:errors path="password" />
    <br>
        <form:label path="passwordConfirm">パスワード確認:</form:label>
        <form:input path="passwordConfirm" />
        <form:errors path="passwordConfirm" />
    <br>

    <input type="submit" name="update" value="update" /> <!-- (1) -->
</form:form>