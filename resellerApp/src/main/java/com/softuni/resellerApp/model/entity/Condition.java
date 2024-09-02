package com.softuni.resellerApp.model.entity;


import com.softuni.resellerApp.model.enums.ConditionName;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "conditions")
public class Condition  extends BaseEntity {
    @Enumerated(EnumType.STRING)
    @NotNull
    private ConditionName name;
    @NotNull
    private String description;

    public @NotNull ConditionName getName() {
        return name;
    }

    public void setName(@NotNull ConditionName name) {
        this.name = name;
        this.setDescription(name);
    }

    public @NotNull String getDescription() {
        return description;
    }

    public void setDescription(@NotNull String description) {
        this.description = description;
    }
    private void setDescription(ConditionName name){
        String description = "";
        switch (name){
            case EXCELLENT -> description= "In perfect condition";
            case GOOD -> description = "Some signs of wear and tear or minor defects";
            case ACCEPTABLE ->  description = "The item is fairly worn but continues to function properly";
        }
        this.description = description;
    }
}
