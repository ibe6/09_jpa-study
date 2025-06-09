package com.ibe6.section04.subquery;


import com.ibe6.section03.join.Menu;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

@Entity(name="category4")
@Table(name="tbl_category")
public class Category {
    @Id
    @Column(name="category_code")
    private Integer categoryCode;
    @Column(name="category_name")
    private String categoryName;
    @Column(name="ref_category_code")
    private Integer refCategoryCode;
}

