

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Coffees;
import model.Suppliers;

/**
 * Servlet implementation class SupplierCoffeeServlet
 */
@WebServlet("/SupplierCoffeeServlet")
public class SupplierCoffeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SessionFactory factory;   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierCoffeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch(Exception e) {
			System.out.println("Failed to Create a Session Factory.");
		}
		
		Session session = factory.openSession();
		System.out.println("Session has been Created.");
		Transaction ts = session.beginTransaction();
		TypedQuery<Suppliers> query = session.createQuery("FROM Suppliers a WHERE a.supId= :x", Suppliers.class);
		query.setParameter("x", 49);
		List<Suppliers> sups = query.getResultList();
		Set<Coffees> cofSet = sups.get(0).getCoffeeses();
		List<Coffees> cofs = new ArrayList<>(cofSet);
		ts.commit();
		request.setAttribute("sups", sups);
		request.setAttribute("cofs", cofs);
		request.getRequestDispatcher("viewSuppliers.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
