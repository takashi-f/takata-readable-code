import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ReadableCode {

	/**
	 * [概要]プログラムのエントリーポイント。
	 * @param args データファイル名を指定する。
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		String recipePath = "src/recipe-data.txt";
		
		PrintInRecipeBase recipePrinter = new PrintInRecipeText(recipePath);

		recipePrinter.PrintIn();

	}

}

abstract class PrintInRecipeBase
{
	abstract protected String createRecipe() throws FileNotFoundException, IOException;

	public void PrintIn() throws IOException
	{
		PrintIn(createRecipe());
	}

	protected void PrintIn(String output)
	{
		System.out.println(output);
	}
}

class PrintInRecipeText extends PrintInRecipeBase
{
	private String recipePath = "";

	public PrintInRecipeText(String recipeTextPath)
	{
		recipePath = recipeTextPath;
	}

	protected String createRecipe() throws IOException
	{
		ReadFile readFile = new ReadFile();
		File recipeFile = readFile.readRecipe(recipePath);
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(recipeFile));

		String row;
		String allText = "";
		while((row = bufferedReader.readLine()) != null) {
			allText = allText + row;
		}
		bufferedReader.close();
		return allText;
	}
}

class ReadFile {
	public File readRecipe(String readRecipeFilePath) {
		return new File(readRecipeFilePath);
	}
}
