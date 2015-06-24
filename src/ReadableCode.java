
public class ReadableCode {

	/**
	 * [概要]プログラムのエントリーポイント。
	 * @param args データファイル名を指定する。
	 */
	public static void main(String[] args) {

		PrintInRecipeBase recipePrinter = new PrintInOmeletteRice();

		recipePrinter.PrintIn();

	}

}

abstract class PrintInRecipeBase
{
	abstract protected String CreateRecipe();


	public void PrintIn()
	{
		PrintIn(CreateRecipe());
	}


	private void PrintIn(String output)
	{
		System.out.println(output);
	}
}


class PrintInOmeletteRice extends PrintInRecipeBase
{
	protected String CreateRecipe()
	{
		return "オムライス";
	}

}


class PrintInRecipeText extends PrintInRecipeBase
{

	private String recipePath = "";

	public PrintInRecipeText(String recipeTextPath)
	{
		recipePath = recipeTextPath;

	}

	protected String CreateRecipe()
	{
		return "目下工事中";
	}


}
