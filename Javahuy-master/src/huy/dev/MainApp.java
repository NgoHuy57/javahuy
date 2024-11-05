package huy.dev;

import java.util.List;
import java.util.Locale;
import com.github.javafaker.Faker;

import huy.dev.data.dao.CategoryDao;
import huy.dev.data.dao.Database;
import huy.dev.data.dao.DatabaseDao;
import huy.dev.data.dao.OrderDao;
import huy.dev.data.dao.OrderItemDao;
import huy.dev.data.dao.ProductDao;
import huy.dev.data.dao.UserDao;
import huy.dev.data.impl.CategoryImpl;
import huy.dev.data.impl.UserImpl;
import huy.dev.data.model.Category;
import huy.dev.data.model.Order;
import huy.dev.data.model.OrderItem;
import huy.dev.data.model.Product;
import huy.dev.data.model.User;
import huy.dev.data.seeder.CategorySeeder;
import huy.dev.data.seeder.ProductSeeder;
import huy.dev.data.seeder.UserSeeder;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
			DatabaseDao.init(new Database());
			Faker faker = new Faker();
			
			// Lấy đối tượng UserDao thông qua DatabaseDao
	        UserDao userDao = DatabaseDao.getInstance().getUserDao();

	        // Khởi tạo UserSign với UserDao đã lấy được
	        UserSeeder userSign = new UserSeeder(userDao);

	        // Gọi phương thức seedUsers để tạo dữ liệu giả cho bảng user
	        userSign.seedUsers(0);

	        
	        
	        // Category Seeder
	        CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
	        CategorySeeder categorySeeder = new CategorySeeder(categoryDao);
	        categorySeeder.seedCategories(0);

	        // Product Seeder
	        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
	        ProductSeeder productSeeder = new ProductSeeder(productDao, categoryDao);
	        productSeeder.seedProducts(2);
	        
	        System.out.println("Seeded fake users successfully!");
			
	}
	
}
