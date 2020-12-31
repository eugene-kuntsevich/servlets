import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ZIP code to timezone mapping:
 * 100 -> +1
 * 200 -> +2
 */
@WebServlet("/geo-location-servlet")
public class GeoLocationServlet extends HttpServlet
{
	private static final String ZIP_CODE_VALUE = "zip_code";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String zipCode = req.getParameter(ZIP_CODE_VALUE);
		Integer zipCodeAsNumber = NumberParserUtil.parseNumberFromString(zipCode);
		String timezone;
		if (zipCodeAsNumber != null)
		{
			timezone = getTimezone(zipCodeAsNumber);
		}
		else
		{
			timezone = "-zip code is not number-";
		}

		req.setAttribute("timezone", timezone);
		req.setAttribute(ZIP_CODE_VALUE, zipCode);
		//add handling exceptions
		req.getRequestDispatcher("/geo-location.jsp").forward(req, resp);
	}

	private String getTimezone(int zipCodeAsNumber)
	{
		String timezone;
		switch (zipCodeAsNumber)
		{
			case 100:
				timezone = "+1";
				break;
			case 200:
				timezone = "+2";
				break;
			default:
				timezone = "-not defined-";
		}
		return timezone;
	}
}
