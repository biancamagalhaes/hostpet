package hostpet.singin;

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

/**
 * Servlet Filter implementation class Autenticacao
 */
@WebFilter("/*")
public class Autorizacao implements Filter {

    /**
     * Default constructor. 
     */
    public Autorizacao() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest r = (HttpServletRequest)request;
		System.out.println(r.getRequestURI());
		String uri = r.getRequestURI();
		if(uri.endsWith("/index.jsp") || uri.endsWith("/ValidarLogin") || uri.endsWith(".css") || uri.endsWith(".png") || uri.endsWith("/.jpg") || uri.endsWith("/.mp4")){
			chain.doFilter(request, response);
		}else{
			Object o = r.getSession().getAttribute("objeto");
			if(o != null){
				chain.doFilter(request, response);
			}else{
				((HttpServletResponse) response).sendRedirect("index.jsp");
			}
		}
		

		// pass the request along the filter chain

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
