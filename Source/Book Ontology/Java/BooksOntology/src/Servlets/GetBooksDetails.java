package Servlets;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import Ontology.BooksOntology;

/**
 * Servlet implementation class GetBooksDetails
 */
@WebServlet("/GetBooksDetails")
public class GetBooksDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBooksDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		StringBuilder buffer = new StringBuilder();
//		BufferedReader reader = request.getReader();
//		String line;
//		while ((line = reader.readLine()) != null) {
//			buffer.append(line);
//		}
//		String data = buffer.toString();
//		System.out.println(data);
//
//		JSONObject params = new JSONObject(data);
//		String authors = (String) params.get("Authors");
//		String year = (String) params.get("Year");
//		String category = (String) params.get("Category");
		
		String authors = request.getParameter("authors");
		String year = request.getParameter("year");
		String category = request.getParameter("category");
		if(authors.equals("none") && year.equals("none") && category.equals("none")){
			JSONObject jsonObject = new JSONObject();
			JSONArray jsonArray = new JSONArray();
			jsonObject.put("results", jsonArray);
			response.getWriter().write(jsonObject.toString());
		}
		else{
			BooksOntology books = new BooksOntology();
			JSONObject jsonObject = books.IntersectionResults(authors, year, category);
			response.getWriter().write(jsonObject.toString());
		}
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		response.setHeader("Access-Control-Max-Age", "86400");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
