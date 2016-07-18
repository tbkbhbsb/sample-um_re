<div id="wrapper">
<h1>削除情報確認</h1>
<form:form modelAttribute="DeleteForm"
    action="${pageContext.request.contextPath}/user/delete">

<table>
			<tr>
				<td><form:label path="userId">ユーザID:</form:label></td>
				<td>${f:h(DeleteForm.userId)}</td>
				<td><form:hidden path="userId" /></td>
			</tr>
			<tr>
				<td><form:label path="name">ユーザ名:</form:label></td>
				<td>${f:h(DeleteForm.name)}</td>
				<td><form:hidden path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="birthday">生年月日:</form:label></td>
				<td>${f:h(DeleteForm.birthday)}</td>
				<td><form:hidden path="birthday" /></td>
			</tr>
			<tr>
				<td><form:label path="address">住所:</form:label></td>
				<td>${f:h(DeleteForm.address)}</td>
				<td><form:hidden path="address" />
				<td>
			</tr>
			<tr>
				<td><form:label path="tel">電話番号:</form:label></td>
				<td>${f:h(DeleteForm.tel)}</td>
				<td><form:hidden path="tel" /></td>
			</tr>
			<tr>
				<td><form:label path="role">権限:</form:label></td>
				<td>${f:h(DeleteForm.role)}</td>
				<td><form:hidden path="role" /></td>
			</tr>
			<tr>
				<td>
				<form action="${pageContext.request.contextPath}/user/search">
				<button type="submit" name="form" value="">キャンセル</button>
				</form>
				</td>
				<td><button type="submit" name="finish" value="">確認</button></td>
			</tr>

		</table>
</form:form>
</div>