import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;



public class Crawler {
	private Set<String> pagesVisited = new HashSet<String>();
	private List<String> pagesToVisitList = new LinkedList<String>();

	public void addPageToVisit(String link){
		this.pagesToVisitList.add(link);
	}


	protected String nextUrl()
	{
		String nextUrl;
		do
		{
			nextUrl = this.pagesToVisitList.remove(0);
		} while(this.pagesVisited.contains(nextUrl));
		this.pagesVisited.add(nextUrl);
		return nextUrl;
	}

	protected void crawl(String URL){

	}

	public List<String> getPagesToVisitList()
	{
		return pagesToVisitList;
	}
}

