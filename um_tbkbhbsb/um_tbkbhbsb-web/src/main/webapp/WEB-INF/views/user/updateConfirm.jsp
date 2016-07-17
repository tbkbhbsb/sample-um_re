<div id="wrapper">
	<h1>更新情報確認</h1>
	<form:form modelAttribute="UpdateForm"
		action="${pageContext.request.contextPath}/user/update">

		<table>
			<tr>
				<td><form:label path="userId">ユーザID:</form:label></td>
				<td>${f:h(UpdateForm.userId)}</td>
				<td><form:hidden path="userId" /></td>
			</tr>
			<tr>
				<td><form:label path="name">ユーザ名:</form:label></td>
				<td>${f:h(UpdateForm.name)}</td>
				<td><form:hidden path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="birthday">生年月日:</form:label></td>
				<td>${f:h(UpdateForm.birthday)}</td>
				<td><form:hidden path="birthday" /></td>
			</tr>
			<tr>
				<td><form:label path="address">住所:</form:label></td>
				<td>${f:h(UpdateForm.address)}</td>
				<td><form:hidden path="address" />
				<td>
			</tr>
			<tr>
				<td><form:label path="tel">電話番号:</form:label></td>
				<td>${f:h(UpdateForm.tel)}</td>
				<td><form:hidden path="tel" /></td>
			</tr>
			<tr>
				<td><form:label path="role">権限:</form:label></td>
				<td>${f:h(UpdateForm.role)}</td>
				<td><form:hidden path="role" /></td>
			</tr>
			<tr>
				<td><button type="submit" name="form" value="">キャンセル</button></td>
				<td><button type="submit" name="finish" value="">確認</button></td>
			</tr>

		</table>
		<form:hidden path="state" value="${f:h(UpdateForm.state)}" />
		<form:hidden path="password" value="${f:h(UpdateForm.password)}" />
	</form:form>
</div>