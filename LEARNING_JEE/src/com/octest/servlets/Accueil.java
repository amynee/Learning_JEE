package com.octest.servlets;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.octest.forms.ConnectionForm;


@WebServlet("/Accueil")
public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Accueil() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String getName = (String) session.getAttribute("nameWithSession");
		session.invalidate(); //remove session data
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				System.out.println(cookie.getName());
				if (cookie.getName().equals("cookieName")) {
					System.out.println(cookie.getValue());
					request.setAttribute("getCookieName", cookie.getValue());
				}
			}
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		request.setAttribute("name", name);
		ConnectionForm form = new ConnectionForm();
		form.verifyUser(request);
		request.setAttribute("form", form);
		HttpSession session = request.getSession();
		session.setAttribute("nameWithSession", name);
		// response.addCookie(new Cookie("name", URLEncoder.encode(name, "UTF-8")));
		Cookie cookie = new Cookie("cookieName", URLEncoder.encode(name, "UTF-8"));
		cookie.setMaxAge(60 * 60 * 24 * 30);
		response.addCookie(cookie);
		this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
	}

}
