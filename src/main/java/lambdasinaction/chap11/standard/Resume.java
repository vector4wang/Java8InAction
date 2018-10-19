package lambdasinaction.chap11.standard;

public class Resume {

    private StandardService standardService = new StandardService();

	private String company;

	private String school;

	private String skill;

	private String title;

	public Resume(String company, String school, String skill, String title) {
		this.company = company;
		this.school = school;
		this.skill = skill;
		this.title = title;
	}

	public Resume() {

	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

    public Resume stadardCompany() {
        this.company = standardService.stadardCompany(this.company);
        return this;
    }

    public Resume standardSchool() {
        this.school = standardService.standardSchool(this.school);
        return this;
    }

	public Resume standardSkill() {
		this.skill = standardService.standardSkill(this.skill);
		return this;
	}

    public Resume standardTitle() {
        this.title = standardService.standardTitle(this.title);
        return this;
    }

	@Override
	public String toString() {
		return "Resume{" +
				"company='" + company + '\'' +
				", school='" + school + '\'' +
				", skill='" + skill + '\'' +
				", title='" + title + '\'' +
				'}';
	}
}
