package com.deepak.backend.Beans;

import javax.persistence.*;

@Entity
@Table(name = "my_table25")
public class MyTableEnti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "column_name")
    private String columnName;


    public MyTableEnti() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    // Getters and Setters
}