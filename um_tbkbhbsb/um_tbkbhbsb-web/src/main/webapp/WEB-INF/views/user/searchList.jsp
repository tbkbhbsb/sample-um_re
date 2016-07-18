
<div id="wrapper">
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/app/css/bootstrap.css"
		type="text/css" media="screen, projection">


<script type="text/javascript">

function NextSubmit(obj){
	if (obj.neme == "update"){
		val = document.getElementsByName("userId");
		var userId = null;
		for(i=0; i<test.length; i++){
			if(test[i].checked){
				userId = test[i].value;
				}
		}
		if(userId = null){
			window.alert("選択されていません");
		}
		parm = "userId"+userId
	    href = "${pageContext.request.contextPath}/user/update?" + parm;
	    
	}else if(obj.name == "delete"){
		var userId = null;
		for(i=0; i<test.length; i++){
			if(test[i].checked){
				userId = test[i].value;
				}
		}
		if(userId = null){
			window.alert("選択されていません");
		}
		parm = "userId"+userId
	    href = "${pageContext.request.contextPath}/user/delete?" + parm;
	}
	    location.href = href;
	    /* return true; */
	  }
</script>


	<%-- (2) --%>
	<form:form name="ListPage" action="">
		<c:choose>
			<c:when test="${page != null && page.totalPages != 0}">

				<table class="maintable">
					<thead>
						<tr>
							<th class="no">選択</th>
							<th class="no">ID</th>
							<th class="no">ユーザ名</th>
							<th class="overview">住所</th>
							<th class="date">生年月日</th>
							<th class="overview">電話番号</th>
							<th class="no">権限</th>
							<th class="no">状態</th>
						</tr>
					</thead>


					<c:forEach items="${page.content}" var="result"
						varStatus="rowStatus">
						<tr>
							<td><input name="userId" type="radio"
								value="${result.userId}" /></td>
							<td>${f:h(result.userId)}</td>
							<td>${f:h(result.name)}</td>
							<td>${f:h(result.address)}</td>
							<td>${f:h(result.birthday)}</td>
							<td>${f:h(result.tel)}</td>
							<td>${f:h(result.role)}</td>
							<td>${f:h(result.state)}</td>
						</tr>
					</c:forEach>
					<tr>
						<td><input type="button" name="update" value="更新"
							onClick="NextSubmit(this)" /></td>
						<td><input type="button" name="delete" value="削除"
							onClick="NextSubmit(this)" /></td>
					</tr>

				</table>

				<div class="paginationPart">

					<t:pagination page="${page}" outerElementClass="pagination"
						criteriaQuery="${f:query(criteria)}" />


				</div>

				<div>
					<fmt:formatNumber value="${(page.number * page.size) + 1}" />
					-
					<fmt:formatNumber
						value="${(page.number * page.size) + page.numberOfElements}" />
				</div>
				<div>
					${f:h(page.number + 1) } /
					<%-- (2) --%>
					${f:h(page.totalPages)} Pages
					<%-- (3) --%>
				</div>
				<div>
					<fmt:formatNumber value="${page.totalElements}" />
					results
				</div>

			</c:when>
		</c:choose>
	</form:form>
</div>