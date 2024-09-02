package com.softuni.resellerApp.model.entity;


import com.softuni.resellerApp.model.OfferCreateBindingModel;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {

    @NotNull
    @Length(min = 2, max = 50)
    private String description;

    @NotNull
    @Positive
    private BigDecimal price;
    @NotNull
    @ManyToOne
    private Condition condition;

    @ManyToOne
    private User createdBy;
    @ManyToOne
    private User boughtBy;

    public Offer() {
    }



    public Offer(OfferCreateBindingModel offerCreateBindingModel, Condition condition, User createdBy) {
        description = offerCreateBindingModel.getDescription();
        price = offerCreateBindingModel.getPrice();
        this.condition = condition;
        this.createdBy = createdBy;
    }

    public @NotNull @Length(min = 2, max = 50) String getDescription() {
        return description;
    }

    public void setDescription(@NotNull @Length(min = 2, max = 50) String description) {
        this.description = description;
    }

    public @NotNull @Positive BigDecimal getPrice() {
        return price;
    }

    public void setPrice(@NotNull @Positive BigDecimal price) {
        this.price = price;
    }

    public @NotNull Condition getCondition() {
        return condition;
    }

    public void setCondition(@NotNull Condition condition) {
        this.condition = condition;

    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getBoughtBy() {
        return boughtBy;
    }

    public void setBoughtBy(User boughtBy) {
        this.boughtBy = boughtBy;
    }
}
