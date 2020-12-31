public class NumberParserUtil
{
	public static Integer parseNumberFromString(String number)
	{
		try
		{
			return Integer.parseInt(number);
		}
		catch (NumberFormatException e)
		{
			return null;
		}
	}
}
