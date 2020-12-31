import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/weather-servlet")
public class WeatherServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		String cityCode = req.getParameter("city_code");
		Integer cityCodeAsNumber = NumberParserUtil.parseNumberFromString(cityCode);
		String result;

		if (cityCodeAsNumber != null)
		{
			result = getTimezone(cityCodeAsNumber);
		}
		else
		{
			result = "-city code is not number-";
		}

		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		printWriter.print("<html>");
		printWriter.print("<body>");
		printWriter.print("<h1>" + result + "</h1>");
		printWriter.print("</body>");
		printWriter.print("</html>");
		printWriter.close();
	}

	private String getTimezone(Integer cityCodeAsNumber)
	{
		String result;
		switch (cityCodeAsNumber)
		{
			case 64:
				result = "rainy";
				break;
			case 375:
				result = "sunny";
				break;
			default:
				result = "-unknown country code-";
				break;
		}
		return result;
	}
}
