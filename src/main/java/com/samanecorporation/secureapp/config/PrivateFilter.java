package com.samanecorporation.secureapp.config;


import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class PrivateFilter
 */
@WebFilter("/*")
public class PrivateFilter implements Filter {

	 /**
     * Default constructor. 
     */
    public PrivateFilter() {
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
   // @Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		// on r´ecup`ere le nom de la session
		String username = (String)session.getAttribute("username");
		// on r´ecup`ere le chemin demand´e par l’utilisateur
		String chemin = req.getServletPath();
		
		// on r´ecup`ere la m´ethode HTTP utilis´ee (GET ou POST)
		String method = req.getMethod();
		if (username != null || chemin.equals("/") || chemin.equals("/login")|| chemin.equals("/sigup") || chemin.equals("/logout") || chemin.equals("/index.jsp") || chemin.equals("/login") && method.equalsIgnoreCase("POST") || chemin.equals("/singup") && method.equalsIgnoreCase("POST") || chemin.startsWith("/public/"))
			chain.doFilter(request, response);
		else
			res.sendRedirect(req.getContextPath());//retourne le chemin racine de l'application
	}


	//@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}


//	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}

