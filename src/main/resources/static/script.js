function callCurrency(key){
	
	console.log("productID", key.value);
	document.getElementById('productForm').action = '/product/list/getCurrency/'+key.value;
	document.getElementById("productForm").submit();
}