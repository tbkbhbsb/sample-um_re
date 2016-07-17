
    <div id="wrapper">

            <form:form modelAttribute="SearchResult" action="" >
                <table>
                <c:forEach items="${SearchResult}" var="result">
                    <tr>
                        <td><input name="userId" type="radio" value="${result.userId}" /></td>
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
                    <td><button type="submit" name="update" value="" >更新</button></td>
                	<td><button type="submit" name="delete" value="" >削除</button></td>
                	</tr>
                </table>
                
            </form:form>
    </div>