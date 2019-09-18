package utilities;

public class Methods {

	public int getRating(String Str,String type)
	{
		int Rating;
		String s=null;
		if(type=="xGrid")
		{
			s=Str.replace(",", "");
			
		}
		else if(type=="xList")
		{
			s=Str.replace("(", "").replace(")","").replace(",", "");
		}
		Rating=Integer.parseInt(s);
		return Rating;
	}


	public int StartIndex(String Details)
	{
		int start;
		if(Details.indexOf('.')==1)
		{
			start=3;	
		}
		else
		{
			start=1;
		}
		return start;
	}

	public int GetProductHigestRating(int[] Ratings)
	{
		int index=0;
		int Heigest=0;
		for(int i=0;i<Ratings.length;i++)
		{
			if(Ratings[i]>Heigest)
			{
				Heigest=Ratings[i];
				index=i;
			}

		}
		return index;
	}
	public void bestRating(int[] Ratings,String[] ProductDetail,String[] StarRating,int index)
	{
		for(int i=0;i<Ratings.length;i++)
		{
			if(Ratings[i]==Ratings[index])
			{
				System.out.println(Ratings[i]);
				System.out.println(ProductDetail[i]);
				System.out.println(StarRating[i]);
			}
		}
	}


}
