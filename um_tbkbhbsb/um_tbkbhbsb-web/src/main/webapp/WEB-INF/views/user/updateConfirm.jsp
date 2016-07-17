<h1>登録情報確認</h1>
<form:form modelAttribute="updateForm"
    action="${pageContext.request.contextPath}/user/updateConfirm">

<form:label path="userId">ユーザID:</form:label>
        ${f:h(updateForm.userId)}
        <form:hidden path="userId" />

    <br>
        <form:label path="Name">ユーザ名:</form:label>
        ${f:h(updateForm.Name}
        <form:hidden path="Name" />
    <br>
        <form:label path="dateOfBirth">生年月日:</form:label>
        ${f:h(updateForm.dateOfBirth)}
        <form:hidden path="dateOfBirth" />
    <br>
        <form:label path="address">住所:</form:label>
        ${f:h(updateForm.address)}
        <form:hidden path="address" />
    <br>
        <form:label path="phoneNumber">電話番号:</form:label>
        ${f:h(updateForm.phoneNumber)}
        <form:hidden path="phoneNumber" />
    <br>
        <form:label path="authority">権限:</form:label>
        ${f:h(updateForm.authority)}
        <form:hidden path="authority" />
    <br>

    <input type="submit" name="redo" value="Back" /> <!-- (2) -->
    <input type="submit" value="update" /> <!-- (3) -->
</form:form>