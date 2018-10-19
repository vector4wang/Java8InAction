package lambdasinaction.chap11.standard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

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

	public List<Resume> oldFun(List<Resume> resumes) {
		List<Resume> result = new ArrayList<>();
		for (Resume resume : resumes) {
			String company = this.stadardCompany(resume.getCompany());
			String school= this.standardSchool(resume.getSchool());
			String skill = this.standardSkill(resume.getSkill());
			String title = this.standardTitle(resume.getTitle());
			result.add(new Resume(company, school, skill, title));
		}
		System.out.println(result);
		return result;
	}

//	public List<Resume> futureFun(List<Resume> resumes) {
//		List<Future>
//	}

	public List<Resume> newFun(List<Resume> resumes) {
		List<CompletableFuture<Resume>> completableFutures = resumes.stream()
				.map(resume -> CompletableFuture.supplyAsync(resume::stadardCompany, executor))
				.map(task -> task
						.thenCompose(resume -> CompletableFuture.supplyAsync(resume::standardSchool, executor)))
				.map(task -> task
						.thenCompose(resume -> CompletableFuture.supplyAsync(resume::standardSkill, executor)))
				.map(task -> task
						.thenCompose(resume -> CompletableFuture.supplyAsync(resume::standardTitle, executor)))
				.collect(Collectors.toList());

		List<Resume> collect = completableFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
		System.out.println(collect);
		return collect;
	}

	public static void execute(String msg, Supplier<List<Resume>> supplier) {
		long s = System.nanoTime();
		supplier.get();
		long e = System.nanoTime();
		System.out.println(msg + " done in " + (e - s) / 1_000_000 + " mesc");
	}

	public static void main(String[] args) {
		List<Resume> resumes = new ArrayList<Resume>(){{
			add(new Resume("A1", "B1", "C1", "D1"));
			add(new Resume("A2", "B2", "C2", "D2"));
			add(new Resume("A3", "B3", "C3", "D3"));
			add(new Resume("A4", "B4", "C4", "D4"));
			add(new Resume("A5", "B5", "C5", "D5"));
			add(new Resume("A6", "B6", "C6", "D6"));
			add(new Resume("A7", "B7", "C7", "D7"));
			add(new Resume("A8", "B8", "C8", "D8"));
			add(new Resume("A9", "B9", "C9", "D9"));
			add(new Resume("A0", "B0", "C0", "D0"));
		}};

		List<Resume> resumes2 = new ArrayList<>();

		for (int i = 0; i < 1000; i++) {
			resumes2.add(new Resume("A"+i, "B0", "C0", "D0"));
		}

		StandardService standardService = new StandardService();
//		execute("oldFun",()->standardService.oldFun(resumes) );
		execute("newFun",()->standardService.newFun(resumes) );
	}

}
