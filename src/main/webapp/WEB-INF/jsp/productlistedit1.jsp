<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<script src="<c:url value="/script.js" />"></script>
<body>
	<h1>Candidate demo Edit</h1>
	<form:form action="/product/list/edit/submit" modelAttribute="productBean" method="post">
	<table>
      <tr>
        <td>
          <form:input path="productname"/>
          <form:input type="hidden" path="id"/>
          <form:errors path="productname" />
        </td>
        <td>
          <form:input path="price"/>
          <form:errors path="price" />
        </td>
		<td>
			<select name="currency">
			<c:forEach items="${products.prices}" var="prices" varStatus="loop" >
					    <option value="${prices.key}" ${prices.key == currency ? 'selected="selected"' : ''}>
					        ${prices.key}
					    </option>
					</c:forEach>
			</select>
			</td>
			<td>
			<input type="submit" value="Update"/>
			</td>
        </tr>
        </table>
	</form:form>
</body>
</html>