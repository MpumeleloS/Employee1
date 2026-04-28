package za.ac.cput.domain;

import java.io.Serializable;
import java.time.LocalDate;

public class EmployeePerformance implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String performanceId;
    private String employeeId;
    private Double rating;
    private String feedback;
    private LocalDate reviewDate;
    private String reviewerName;

    public EmployeePerformance(String performanceId, String employeeId, Double rating, String feedback, LocalDate reviewDate, String reviewerName) {
        this.performanceId = performanceId;
        this.employeeId = employeeId;
        this.rating = rating;
        this.feedback = feedback;
        this.reviewDate = reviewDate;
        this.reviewerName = reviewerName;
    }

    public EmployeePerformance() {}

    public String getPerformanceId() { return performanceId; }
    public void setPerformanceId(String performanceId) { this.performanceId = performanceId; }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    public Double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }

    public String getFeedback() { return feedback; }
    public void setFeedback(String feedback) { this.feedback = feedback; }

    public LocalDate getReviewDate() { return reviewDate; }
    public void setReviewDate(LocalDate reviewDate) { this.reviewDate = reviewDate; }

    public String getReviewerName() { return reviewerName; }
    public void setReviewerName(String reviewerName) { this.reviewerName = reviewerName; }

    public String getPerformanceLevel() {
        if (rating == null) return "UNKNOWN";
        if (rating >= 4.5) return "EXCELLENT";
        if (rating >= 3.5) return "GOOD";
        if (rating >= 2.5) return "SATISFACTORY";
        return "NEEDS IMPROVEMENT";
    }

    @Override
    public String toString() {
        return "EmployeePerformance{" +
                "performanceId='" + performanceId + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", rating=" + rating +
                ", level='" + getPerformanceLevel() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeePerformance that = (EmployeePerformance) o;
        return performanceId != null && performanceId.equals(that.performanceId);
    }

    @Override
    public int hashCode() {
        return performanceId != null ? performanceId.hashCode() : 0;
    }
}

