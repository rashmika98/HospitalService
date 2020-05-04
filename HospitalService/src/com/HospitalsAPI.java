package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HospitalsAPI
 */
@WebServlet("/HospitalsAPI")
public class HospitalsAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	// Hospital Class Object
		Hospital HospitalObj = new Hospital();
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HospitalsAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String output = HospitalObj.insertHospital(request.getParameter("HRegID"), request.getParameter("HName"),
				request.getParameter("HAddress"), request.getParameter("HCity"),
				request.getParameter("HDestrict"), request.getParameter("HProvince"), request.getParameter("HEmail"),
				request.getParameter("HContactNum"), request.getParameter("HUsername"),
				request.getParameter("HPassword"));
		response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map paras = getParasMap(request);
		String output = HospitalObj.updateHospital(paras.get("hidItemIDSave").toString(), paras.get("HName").toString(),
				paras.get("HAddress").toString(), paras.get("HCity").toString(),
				paras.get("HDestrict").toString(), paras.get("HProvince").toString(), paras.get("HEmail").toString(),
				paras.get("HContactNum").toString(), paras.get("HUsername").toString(),
				paras.get("HPassword").toString());
		response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map paras = getParasMap(request);
		String output = HospitalObj.deleteHospital(paras.get("HRegID").toString());
		response.getWriter().write(output);
		System.out.println(paras.get("HRegID").toString());
	}
	
	
	
	// Convert request parameters to a Map
		private static Map getParasMap(HttpServletRequest request) {
			Map<String, String> map = new HashMap<String, String>();
			try {
				Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
				String queryString = scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
				scanner.close();
				String[] params = queryString.split("&");
				for (String param : params) {

					String[] p = param.split("=");
					map.put(p[0], p[1]);
				}
			} catch (Exception e) {
			}
			return map;
		}

}
