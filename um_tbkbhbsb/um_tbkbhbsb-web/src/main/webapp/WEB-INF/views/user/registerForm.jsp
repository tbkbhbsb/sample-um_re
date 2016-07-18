<div id="wrapper">
	<h1>ユーザ登録</h1>
	<form:form modelAttribute="RegisterForm"
		action="${pageContext.request.contextPath}/user/register"
		method="post">

		<table>
			<tr>
				<td><form:label path="userId">ユーザID:</form:label></td>
				<td><form:input path="userId" /></td>
				<td><form:errors path="userId" /></td>
			</tr>
			<tr>
				<td><form:label path="name">ユーザ名:</form:label></td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="birthday">生年月日:</form:label></td>
				<td><form:input path="birthday" /></td>
				<td><form:errors path="birthday" /></td>
			</tr>
			<tr>
				<td><form:label path="address">住所:</form:label></td>
				<td><form:input path="address" /></td>
				<td><form:errors path="address" /></td>
			</tr>
			<tr>
				<td><form:label path="tel">電話番号:</form:label></td>
				<td><form:input path="tel" /></td>
				<td><form:errors path="tel" /></td>
			</tr>
			<tr>
				<td><form:label path="role">権限:</form:label></td>
				<td><form:select path="role">
					<option value="">----</option>
					<option value="USER">USER</option>
                    <option value="ADMIN">ADMIN</option>
				</form:select></td>
				<td><form:errors path="role" /></td>
			</tr>
			<tr>
				<td><form:label path="password">パスワード:</form:label></td>
				<td><form:input path="password" /></td>
				<td><form:errors path="password" /></td>
			</tr>
			<tr>
				<td><form:label path="passwordConfirm">パスワード確認:</form:label></td>
				<td><form:input path="passwordConfirm" /></td>
				<td><form:errors path="passwordConfirm" /></td>
			</tr>
		<%-- 	<tr>
				<td><form:label path="state">状態:</form:label></td>
				<td><form:select path="state">
					<option value="">----</option>
					<option value="INIT">INIT</option>
                    <option value="ACTV">ACTV</option>
                    <option value="ACTV">RMVD</option>
				</form:select></td>
				<td><form:errors path="role" /></td>
			</tr> --%>
			<tr>
				<td><button type="submit" name="finish" value="">検索</button></td>
			</tr>
		</table>
	</form:form>
</div>