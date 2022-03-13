function callCurrency(key){
	
	console.log("productID", key.value);
	document.getElementById('productForm').action = '/product/list/getCurrency/'+key.value;
	document.getElementById("productForm").submit();
}

function callCurrencyEdit(key){
	
	console.log("productID", key.value);
	document.getElementById('productForm').action = '/product/list/edit/'+key.value;
	document.getElementById("productForm").submit();
}

function editProduct(id, key){
	
	console.log("productID", id, key);
	document.getElementById('productForm').action = '/product/list/edit/'+id+'/'+key;
	document.getElementById("productForm").submit();
}