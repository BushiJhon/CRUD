package action;

import dao.ProductDAO;
import pojo.Product;

import java.util.List;
//import java.util.ArrayList;

public class ProductAction {
	private ProductDAO productDAO = new ProductDAO();
	private Product product;
	private List<Product> productList;
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Product getProduct() {
		return this.product;
	}
	
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
	public List<Product> getProductList() {
		return this.productList;
	}
	
	public String add() {
		productDAO.add(this.product);
		return "add";
	}
	
	public String delete() {
		productDAO.delete(this.product.getId());
		return "delete";
	}
	
	public String list() {
		productList = productDAO.list();
		return "list";
	}
	
	public String edit() {
		product = productDAO.get(product.getId());
		return "edit";
	}
	
	public String update() {
		productDAO.update(product);
		productList = productDAO.list();
		return "update";
	}
	
}
