package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import dao.ProductDAO;
import dao.ProductDAOImpl;
import model.ProductManagement;

@WebServlet("/")
public class ProductController extends HttpServlet{

	private static final long serialVersionUID=1L;
	
	private ProductDAO product;
	
	public void init() {
		this.product=new ProductDAOImpl();
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		doGet(request,response);
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String action=request.getServletPath();
		
		switch(action) {
		case "/new":
			showNewForm(request,response);
			break;
		case "/insert":
			insertProduct(request,response);
			break;
		case "/delete":
			deleteProduct(request,response);
		    break;
		case "/update":
			updateProduct(request,response);
			break;
		case "/edit":
			try {
				editProduct(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/list":
             listProduct(request,response);
             break;
		 default:
             RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
             dispatcher.forward(request, response);
             break;
			
		}
	}
	private void showNewForm(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		RequestDispatcher dispatcher=request.getRequestDispatcher("product-form.jsp");
		dispatcher.forward(request,response);
		

	}
	
	private void insertProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String productName=request.getParameter("productName");
		String price=request.getParameter("price");
		String quantityInStock=request.getParameter("quantityInStock");
		String vendor=request.getParameter("vendor");
		String waranty=request.getParameter("waranty");
		
		ProductManagement productManage=new ProductManagement(productName,price,quantityInStock,vendor,waranty);
		try {
			product.insertProduct(productManage);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("list");
	}
	
	private void updateProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		 
		    String id = request.getParameter("id");
		    String productName=request.getParameter("productName");
			String price=request.getParameter("price");
			String quantityInStock=request.getParameter("quantityInStock");
			String vendor=request.getParameter("vendor");
			String waranty=request.getParameter("waranty");
			
			ProductManagement productManage=new ProductManagement(id,productName,price,quantityInStock,vendor,waranty);
			try {
				product.updateProduct(productManage);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("list");
	}
	
	private void deleteProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String id = request.getParameter("id");
		try {
			product.deleteProduct(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("list");
	}
	private void listProduct(HttpServletRequest request,HttpServletResponse response) {
		List<ProductManagement> products=product.selectAllProduct();
		request.setAttribute("listProduct", products);
		RequestDispatcher dispatcher=request.getRequestDispatcher("product-list.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	  private void editProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
			        String id = request.getParameter("id");
			        ProductManagement products = product.selectProduct(id);
			        RequestDispatcher dispatcher = request.getRequestDispatcher("product-form.jsp");
			        request.setAttribute("listProduct", products);
			        dispatcher.forward(request, response);

			    }
	
}
