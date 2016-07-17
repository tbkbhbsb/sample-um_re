
    <div id="wrapper">

            <form:form action="" >
                <table>
                <c:forEach items="${SaerchResult.results}" var="result" varStatus="status">
                    <tr>
                        <td><input name = "userId" type="radio" value="${result.userId}" /></td>
                        <td>${f:h(result.userId)}</td>
                        <td>${f:h(result.name)}</td>
                        <td>${f:h(result.dateOfBirth)}</td>
                        <td>${f:h(result.phoneNumber)}</td>
                        <td>${f:h(result.authority)}</td>
                        <td>${f:h(result.status)}</td>
                    </tr>
                    </c:forEach>
                    <tr>
                    <td><button type="submit" name="update" value="" >更新</button></td>
                	<td><button type="submit" name="delete" value="" >削除</button></td>
                	</tr>
                </table>
                
            </form:form>
    </div>