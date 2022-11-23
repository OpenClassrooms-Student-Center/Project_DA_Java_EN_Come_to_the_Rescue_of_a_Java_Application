package obj;

public class Symptom implements Comparable<Symptom>{

	public String wording;
	public int occurences;

	public Symptom() {
		this.occurences = 0;
	}

	public Symptom(String wording, int occurences) {
		this.wording = wording;
		this.occurences = occurences;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((wording == null) ? 0 : wording.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Symptom other = (Symptom) obj;
		if (wording == null) {
			if (other.wording != null)
				return false;
		} else if (!wording.equals(other.wording))
			return false;
		return true;
	}

	@Override
	public int compareTo(Symptom o) {
		if (this.wording.equals(o.wording)) {
			return 0;
		} else if (this.wording.compareTo(o.wording) > 0) {
			return 1;
		} else {
			return -1;
		}
	}
	
	

}
