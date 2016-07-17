<div id="wrapper">
	<h1>ユーザ登録</h1>
	<form:form modelAttribute="UpdateForm"
		action="${pageContext.request.contextPath}/user/update" method="post">

		<table>
			<tr>
				<td><form:label path="userId">ユーザID:</form:label></td>
				<td>${f:h(userId)}</td>
				<td><form:errors path="userId" /></td>
			</tr>
			<tr>
				<td><form:label path="name">ユーザ名:</form:label></td>
				<td><form:input path="name" value="${name}" /></td>
				<td><form:errors path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="birthday">生年月日:</form:label></td>
				<td><form:input path="birthday" value="${birthday}" /></td>
				<td><form:errors path="birthday" /></td>
			</tr>
			<tr>
				<td><form:label path="address">住所:</form:label></td>
				<td><form:input path="address" value="${address}" /></td>
				<td><form:errors path="address" /></td>
			</tr>
			<tr>
				<td><form:label path="tel">電話番号:</form:label></td>
				<td><form:input path="tel" value="${tel}" /></td>
				<td><form:errors path="tel" /></td>
			</tr>
			<tr>
				<td><form:label path="role">権限:</form:label></td>
				<td><form:select path="role">
						<c:choose>
							<c:when test="${role = USER}">
								<option value="">----</option>
								<option value="USER" selected>USER</option>
								<option value="ADMIN">ADMIN</option>
							</c:when>
							<c:when test="${role = ADMIN}">
								<option value="">----</option>
								<option value="USER">USER</option>
								<option value="ADMIN" selected>ADMIN</option>
							</c:when>
							<c:otherwise>
								<option value="">----</option>
								<option value="USER">USER</option>
								<option value="ADMIN">ADMIN</option>
							</c:otherwise>
						</c:choose>
					</form:select></td>
				<td><form:errors path="role" /></td>
			</tr>
			<tr>
				<td><form:label path="state">状態:</form:label></td>
				<td><form:select path="state">
						<c:choose>
							<c:when test="${state = INIT}">
								<option value="">----</option>
								<option value="INIT" selected>INIT</option>
								<option value="ACTV">ACTV</option>
								<option value="ACTV">RMVD</option>
							</c:when>
							<c:when test="${state = ACTV}">
								<option value="">----</option>
								<option value="INIT">INIT</option>
								<option value="ACTV" selected>ACTV</option>
								<option value="ACTV">RMVD</option>
							</c:when>
							<c:when test="${state = RMVD}">
								<option value="">----</option>
								<option value="INIT">INIT</option>
								<option value="ACTV">ACTV</option>
								<option value="ACTV" selected>RMVD</option>
							</c:when>
							<c:otherwise>
								<option value="">----</option>
								<option value="INIT">INIT</option>
								<option value="ACTV">ACTV</option>
								<option value="ACTV">RMVD</option>
							</c:otherwise>
						</c:choose>
					</form:select></td>
				<td><form:errors path="role" /></td>
			</tr>
			<tr>
				<td><button type="submit" name="confirm" value="">更新</button></td>
			</tr>
		</table>
	</form:form>
</div>