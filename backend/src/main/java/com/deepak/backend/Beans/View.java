package com.deepak.backend.Beans;


import javax.persistence.*;

@Entity
@Table(name = "View")
public class View {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long view_id;

    @Column(name = "country")
    private String country;
    @Column(name = "indicator")
    private String indicator;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    public View() {}

    public View(Long name, String country, String indicator, String startDate, String endDate) {
        this.view_id = name;
        this.country = country;
        this.indicator = indicator;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getView_id() {
        return view_id;
    }

    public void setView_id(Long view_id) {
        this.view_id = view_id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIndicator() {
        return indicator;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
