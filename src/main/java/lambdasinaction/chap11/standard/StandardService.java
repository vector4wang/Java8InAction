package lambdasinaction.chap11.standard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class StandardService {

	private final Executor executor = Executors.newFixedThreadPool(5, new ThreadFactory() {
		@Override
		public Thread newThread(Runnable r) {
			Thread t = new Thread(r);
			t.setDaemon(true);
			return t;
		}
	});


	public String stadardCompany(String company) {
		delay(100);
		return "standard " + company;
	}

	public String standardSchool(String schoole) {
		delay(50);
		return "standard " + schoole;
	}

	public String standardSkill(String skill) {
		delay(200);
		return "standard " + skill;
	}

	public String standardTitle(String title) {
		delay(1000);
		return "standard " + title;
	}

	private void delay(int target) {
		int delayMils = new Random().nextInt(target);
		try {
			Thread.sleep(delayMils);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String buildTag(String com, String school, String skill, String title) {
		return com + school + skill + title + "tag";
	}

	public void oldFun(List<Resume> resumes) {
		for (Resume resume : resumes) {
			long start = System.nanoTime();
			String company = this.stadardCompany(resume.getCompany());
			String school= this.standardSchool(resume.getSchool());
			String skill = this.standardSkill(resume.getSkill());
			String title = this.standardTitle(resume.getTitle());
			System.out.println(this.buildTag(company, school, skill, title));
			long retrivalTime = ((System.nanoTime() - start) / 1_000_000);
			System.out.println(retrivalTime);
		}
	}

	public void newFun(List<Resume> resumes) {
//		resumes.stream()
//				.map(resume -> CompletableFuture.supplyAsync(() -> stadardCompany(resume.getCompany()), executor))
//				.map(task -> task
//						.thenCompose(resume -> CompletableFuture.supplyAsync(()->standardSchool(resume.), executor)))
//				.map(task -> task
//						.thenCompose(resume -> CompletableFuture.supplyAsync(()->standardSchool(resume.gets), executor)));

	}

	public static void main(String[] args) {
		Resume resume = new Resume();
		resume.setCompany("A");
		resume.setSchool("B");
		resume.setSkill("C");
		resume.setTitle("D");
		StandardService standardService = new StandardService();
//		standardService.oldFun(new ArrayList<Resume>(){{add(resume)}});
	}
}
