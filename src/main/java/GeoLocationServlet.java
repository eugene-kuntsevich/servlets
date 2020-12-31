import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ZIP code to timezone:
 * 100 -> +1
 * 200 -> +2
 */
@WebServlet("/geo-location-servlet")
public class GeoLocationServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String zipCode = req.getParameter("zip_code");
		int zipCodeAsNumber = Integer.parseInt(zipCode);
		String timezone;
		switch (zipCodeAsNumber)
		{
			case 100:
				timezone = "1";
				break;
			case 200:
				timezone = "2";
				break;
			default:
				timezone = "";
		}

		req.setAttribute("timezone", timezone);
		req.setAttribute("zip_code", zipCode);
		req.getRequestDispatcher("/geo-location.jsp").forward(req, resp);
	}
}
