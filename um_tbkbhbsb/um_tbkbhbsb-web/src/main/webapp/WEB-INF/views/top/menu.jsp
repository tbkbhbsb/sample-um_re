<div id="wrapper">
	<!-- (2) -->
	<p>Please select your operation.</p>
</div>

<div id="content">
	<table>
		<tr>
			<td><form:form
					action="${pageContext.request.contextPath}/user/register"
					method="get">
					<button type="submit" name="form" value="">ユーザ登録</button>
				</form:form></td>

			<td><form:form
					action="${pageContext.request.contextPath}/user/search"
					method="get">
					<button type="submit" name="form" value="">ユーザ検索</button>
				</form:form></td>
		</tr>
	</table>
</div>
