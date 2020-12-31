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
		int cityCodeAsNumber = Integer.parseInt(cityCode);
		String weatherInfo;

		switch (cityCodeAsNumber)
		{
			case 64:
				weatherInfo = "rainy";
				break;
			case 375:
				weatherInfo = "sunny";
				break;
			default:
				weatherInfo = "-unknown country code-";
				break;
		}

		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		printWriter.print("<html>");
		printWriter.print("<body>");
		printWriter.print("<h1>" + weatherInfo + "</h1>");
		printWriter.print("</body>");
		printWriter.print("</html>");
		printWriter.close();
	}
}
