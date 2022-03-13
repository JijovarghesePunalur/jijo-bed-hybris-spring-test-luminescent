<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<script src="<c:url value="/script.js" />"></script>
<body>
	<h1>Candidate demo home</h1>
	<form method="post" action="/product/list/edit/submit" id="productForm">
	<table>
	<tr>
	<td>Product Name</td>
	<td>Price</td>
	</tr>
		<c:forEach var="products" items="${products}">
			<tr>
				<td>
					<input type="text" name="productname" value="${products.name}"/>
				</td>
				<td>
				<c:set var="test" value="currency${products.id}"
				    scope="session" />
				<input type="text" name="price" value="${sessionScope[test]}"/>
				</td>
				<td>
				<td 
			 	<button type="submit" value="Submit" />
			 </td>
			</tr>
		</c:forEach>
		<tr>
			<td>
			<select name="currency" onChange="callCurrencyEdit(this)">
			<c:forEach var="products" items="${products}" end="0">
			
			<c:forEach items="${products.prices}" var="prices" varStatus="loop" >
					    <option value="${prices.key}" ${prices.key == currency ? 'selected="selected"' : ''}>
					        ${prices.key}
					    </option>
					</c:forEach>
				</c:forEach>
			</select>
			</td>
		 </tr>
		 <tr>
			<td><input type = "submit" value = "Submit" /></td>
		</tr>
	</table>
	</form>
</body>
</html>