import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class main {
	public static void main(String[] args) {
		String basePageUrl;
		int numberOfWorkers;
		int totalPagesToScan;


		Scanner in = new Scanner(System.in);
		System.out.println("Enter A Base Page Url");
		basePageUrl = in.nextLine();

		System.out.println("Enter Number Of Workers");
		numberOfWorkers = in.nextInt();

		System.out.println("Enter A Number Of Total Pages To Scan");
		totalPagesToScan = in.nextInt();

		ExecutorService executor = Executors.newFixedThreadPool(numberOfWorkers);

//		List<String> linksToVisit = new LinkedList<String>();
//		linksToVisit.add(basePageUrl);
		Crawler crawler = new Crawler();
		crawler.addPageToVisit(basePageUrl);

		while (!crawler.getPagesToVisitList().isEmpty() && totalPagesToScan > 0) {
			Runnable worker = new WorkerThread("");
			executor.execute(worker);
		}

		executor.shutdown();
		while (!executor.isTerminated()) {   }

		System.out.println("Finished all threads");
	}
}
