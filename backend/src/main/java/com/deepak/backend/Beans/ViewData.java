package com.deepak.backend.Beans;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "ViewData")
public class ViewData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long data_id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "view_id")
    private View view;


    @Column(name = "date")
    private String date;


    @Column(name = "value")
    private Double value;


    public ViewData() {}
    public ViewData(Long data_id, View view, String date, Double value) {
        this.data_id = data_id;
        this.view = view;
        this.date = date;
        this.value = value;
    }

    public Long getData_id() {
        return data_id;
    }

    public void setData_id(Long data_id) {
        this.data_id = data_id;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
