package pt.amane.dslearnbds.entities;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pt.amane.dslearnbds.entities.pk.EnrollmentPk;

@Entity
@Table(name = "tb_enrollment")
public class Enrollment {

	@EmbeddedId
	private EnrollmentPk id = new EnrollmentPk();

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant enrollMoment;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant refundMoment;
	private boolean available;
	private boolean onlyUpdate;

	@ManyToMany(mappedBy = "enrollmentsDone")
	private Set<Lesson> lessonsDone = new HashSet<>();

	@OneToMany(mappedBy = "enrollment")
	private List<Deliver> delivers = new ArrayList<Deliver>();

	public Enrollment() {
	}

	public Enrollment(User user, Offer offer, Instant enrollment, Instant refundMoment, boolean available,
			boolean onlyUpdate) {
		super();
		id.setUser(user);
		id.setOffer(offer);
		this.enrollMoment = enrollment;
		this.refundMoment = refundMoment;
		this.available = available;
		this.onlyUpdate = onlyUpdate;
	}

	public User getStudent() {
		return id.getUser();
	}

	public void setStudent(User user) {
		id.setUser(user);
	}

	public Offer getOffer() {
		return id.getOffer();
	}

	public void setOffer(Offer offer) {
		id.setOffer(offer);
	}

	public Instant getEnrollMoment() {
		return enrollMoment;
	}

	public void setEnrollMoment(Instant enrollment) {
		this.enrollMoment = enrollment;
	}

	public Instant getRefundMoment() {
		return refundMoment;
	}

	public void setRefundMoment(Instant refundMoment) {
		this.refundMoment = refundMoment;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public boolean isOnlyUpdate() {
		return onlyUpdate;
	}

	public void setOnlyUpdate(boolean onlyUpdate) {
		this.onlyUpdate = onlyUpdate;
	}

	public Set<Lesson> getLessonsDone() {
		return lessonsDone;
	}

	public List<Deliver> getDelivers() {
		return delivers;
	}

}
