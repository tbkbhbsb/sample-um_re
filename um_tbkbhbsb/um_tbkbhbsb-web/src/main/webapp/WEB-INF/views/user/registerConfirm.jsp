<div id="wrapper">
	<h1>登録情報確認</h1>
	<form:form modelAttribute="RegisterForm"
		action="${pageContext.request.contextPath}/user/register" method="post">

		<table>
			<tr>
				<td><form:label path="userId">ユーザID:</form:label></td>
				<td>${f:h(RegisterForm.userId)}</td>
				<td><form:hidden path="userId" /></td>
			</tr>
			<tr>
				<td><form:label path="name">ユーザ名:</form:label></td>
				<td>${f:h(RegisterForm.name)}</td>
				<td><form:hidden path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="birthday">生年月日:</form:label></td>
				<td>${f:h(RegisterForm.birthday)}</td>
				<td><form:hidden path="birthday" /></td>
			</tr>
			<tr>
				<td><form:label path="address">住所:</form:label></td>
				<td>${f:h(RegisterForm.address)}</td>
				<td><form:hidden path="address" />
				<td>
			</tr>
			<tr>
				<td><form:label path="tel">電話番号:</form:label></td>
				<td>${f:h(RegisterForm.tel)}</td>
				<td><form:hidden path="tel" /></td>
			</tr>
			<tr>
				<td><form:label path="role">権限:</form:label></td>
				<td>${f:h(RegisterForm.role)}</td>
				<td><form:hidden path="role" /></td>
			</tr>
			<tr>
				<td><button type="submit" name="form" value="">キャンセル</button></td>
				<td><button type="submit" name="finish" value="">確認</button></td>
			</tr>

		</table>
	<form:hidden path="state" value="${f:h(RegisterForm.state)}"/>
	<form:hidden path="password" value="${f:h(RegisterForm.password)}"/>
	<form:hidden path="passwordConfirm" value="${f:h(RegisterForm.passwordConfirm)}"/>
	</form:form>
</div>