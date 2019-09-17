package utilities;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Product extends Methods {

	WebDriver Driver;
	int Rindex,Sindex;
	int[] Ratings=new int[40];
	String[] StarRating=new String[40];
	String[] ProductDetail=new String[40];
	int Index=0,Heigest=0;
	ArrayList<WebElement> xList=new ArrayList<WebElement>();
	public  Product (WebDriver Driver) {
		this.Driver=Driver;
	}

	public void view()
	{
		Driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		if(Driver.findElements(By.xpath("//div[@data-id]")).size()==24)
		{
			listView();
		}
		else
		{
			gridView();

		}

	}



	public void listView()
	{

		xList=(ArrayList<WebElement>)(Driver.findElements(By.xpath("//div[@class='col col-7-12']")));
		for (WebElement Product : xList) {

			String Details=Product.getText();
			//System.out.println(Details);
			String[] PDetails=Details.split("\n");
			// System.out.println(PDetails[0]);
			String Rating;
			if(PDetails[0].contains("ON OFFER"))
			{
				Sindex=2;

			}
			else {
				Sindex=0;
			}
			if(PDetails[Sindex+1].contains("Ratings"))
			{
				int startindex=StartIndex(PDetails[Sindex+1]);
				int end=PDetails[Sindex+1].indexOf(' ');
				StarRating[Index]=PDetails[Sindex+1].substring(0, startindex);
				Rating=PDetails[Sindex+1].substring(startindex, end);
				//System.out.println(Rating);
				Ratings[Index]=getRating(Rating,"xGrid");
			}
			else
			{
				StarRating[Index]="0";
				Ratings[Index]=0;

			}
			ProductDetail[Index]=PDetails[Sindex];
			Index++;

		}
		int index=GetProductHigestRating(Ratings);
		bestRating(Ratings, ProductDetail, StarRating, index);

	}

	public void gridView()
	{
		ArrayList<WebElement> xGridName=new ArrayList<WebElement>();
		ArrayList<WebElement> xGridRating=new ArrayList<WebElement>();
		ArrayList<WebElement> xGridSRating=new ArrayList<WebElement>();
		xGridName=(ArrayList<WebElement>)(Driver.findElements(By.xpath("//div[@data-id]")));
		xGridRating=(ArrayList<WebElement>)(Driver.findElements(By.xpath("//span[contains(text(),'(')]")));
		xGridSRating=(ArrayList<WebElement>)(Driver.findElements(By.xpath("//span[contains(@id,'productRating')]")));

		for(int i=0;i<xGridSRating.size();i++)
		{
			if(xGridRating.get(i).isDisplayed())
			{
				String Rating=xGridRating.get(i).getText();
				Ratings[i]=getRating(Rating,"xList");
				StarRating[i]=xGridSRating.get(i).getText();
			}
			else
			{
				Ratings[i]=0;
				StarRating[i]="0";
			}
			ProductDetail[i]=xGridName.get(i).getText();
		}
		int index=GetProductHigestRating(Ratings);
		bestRating(Ratings, ProductDetail, StarRating, index);



	}




}
