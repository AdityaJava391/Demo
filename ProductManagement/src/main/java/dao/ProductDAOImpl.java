package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbcutils.JDBCUtils;
import model.ProductManagement;

public class ProductDAOImpl implements ProductDAO {
	
	private static final String INSERT_PRODUCT_SQL="INSERT INTO PRODUCTS (product_name,price,quantity_in_stock,vendor,waranty) VALUES (?,?,?,?,?)";
    
	private static final String SELECT_PRODUCT_BY_ID="SELECT id,product_name,price,quantity_in_stock,vendor,waranty FROM PRODUCTS WHERE id=? ";
	
	private static final String SELECT_ALL_PRODUCT="SELECT * FROM PRODUCTS";
	
	private static final String DELETE_PRODUCT_BY_ID="DELETE FROM PRODUCTS WHERE ID=? ";
	
	private static final String UPDATE_PROD="UPDATE PRODUCTS set product_name=? ,price=?,quantity_in_stock=?,vendor=?,waranty=? where id=?";
	
	
	@Override
	public void insertProduct(ProductManagement product) throws SQLException {
		 System.out.println(INSERT_PRODUCT_SQL);
	        // try-with-resource statement will auto close the connection.
		 Connection connection=null;
	        try {
	        		connection = JDBCUtils.getConnection();
	        		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL);
	        		
	            preparedStatement.setString(1,product.getProductName());
	            preparedStatement.setString(2, product.getPrice());
	            preparedStatement.setString(3, product.getQuantityInStock());
	            preparedStatement.setString(4,product.getVendor());
	            preparedStatement.setString(5, product.getWaranty());
	            System.out.println(preparedStatement);
	            preparedStatement.executeUpdate();
	        } catch (SQLException exception) {
	            JDBCUtils.printSQLException(exception);
	        }
	        finally {
	        	connection.close();
	        }
	    }

	@Override
	public ProductManagement selectProduct(String productId) {
		ProductManagement product=null;
		Connection connection=null;
		try {
			connection=JDBCUtils.getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement(SELECT_PRODUCT_BY_ID);
			preparedStatement.setString(1,productId);
			 System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();
	            
	          while(rs.next()) {
	        	  String convertedId=rs.getString("id");
	        	  String productName=rs.getString("product_name");
	        	  String price=rs.getString("price");
	        	  String quantityInStock=rs.getString("quantity_in_stock");
	        	  String vendor=rs.getString("vendor");
	        	  String waranty=rs.getString("waranty");
	        	  product=new ProductManagement(convertedId,productName,price,quantityInStock,vendor,waranty);
	          }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
		return product;
	}

	@Override
	public List<ProductManagement> selectAllProduct() {
		// TODO Auto-generated method stub
		List<ProductManagement> product=new ArrayList<>();
		Connection connection=null;
		try {
			
				connection=JDBCUtils.getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_PRODUCT);
				 System.out.println(preparedStatement);
		            // Step 3: Execute the query or update query
		            ResultSet rs = preparedStatement.executeQuery();
		            
		          while(rs.next()) {
		        	  long id=rs.getLong("id");
		        	  String convertedId=String.valueOf(id);
		        	  String productName=rs.getString("product_name");		        	  		        	 
		        	  String price=rs.getString("price");
		        	  String quantityInStock=rs.getString("quantity_in_stock");
		        	  String vendor=rs.getString("vendor");
		        	  String waranty=rs.getString("waranty");
		        	  product.add(new ProductManagement(convertedId,productName,price,quantityInStock,vendor,waranty));
		          }
		}
		catch(Exception e) {
			
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return product;
	}
	

	@Override
	public boolean deleteProduct(String id) throws SQLException {
		boolean rowDelted=false;
		Connection connection=null;
		try {
			connection = JDBCUtils.getConnection(); 
			PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_BY_ID);
	            statement.setString(1, id);
	            statement.executeUpdate();
	            rowDelted = statement.executeUpdate() > 0;
		}
		catch(Exception e) {
			
		}
		finally {
			connection.close();
		}
		return rowDelted;
	}

	@Override
	public boolean updateProduct(ProductManagement product) throws SQLException {
		Connection connection=null;
		boolean rowUpdated=false;
		try {
			connection = JDBCUtils.getConnection(); 
			PreparedStatement statement = connection.prepareStatement(UPDATE_PROD);
			statement.setString(1,product.getProductName());
			statement.setString(2, product.getPrice());
			statement.setString(3, product.getQuantityInStock());
			statement.setString(4, product.getVendor());
			statement.setString(5, product.getWaranty());
			statement.setString(6, product.getId());
			rowUpdated=statement.executeUpdate()>0;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			connection.close();
		}
		return rowUpdated;
	}

}
