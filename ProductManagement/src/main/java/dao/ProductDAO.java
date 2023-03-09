package dao;

import java.sql.SQLException;
import java.util.List;

import model.ProductManagement;

public interface ProductDAO {

	void insertProduct(ProductManagement product ) throws SQLException;
	
	ProductManagement selectProduct(String id);
	
	List<ProductManagement> selectAllProduct();
	
	 boolean deleteProduct(String id) throws SQLException;

	 boolean updateProduct(ProductManagement product) throws SQLException;
}
