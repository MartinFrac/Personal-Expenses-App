package com.infoshareacademy.tailandczycy.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class ExpenseDto {
    private Long id;
    private String name;
    private String comment;
    private BigDecimal amount;
    private String date;
    private List<String> categories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<String> getCategories() { return categories; }

    public void setCategories(List<String> categories) { this.categories = categories; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpenseDto that = (ExpenseDto) o;
        return id.equals(that.id) &&
                name.equals(that.name) &&
                Objects.equals(comment, that.comment) &&
                amount.equals(that.amount) &&
                date.equals(that.date) &&
                categories.equals(that.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, comment, amount, date, categories);
    }
}
