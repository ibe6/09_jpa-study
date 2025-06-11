package com.ibe6.springjpa.menu.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class CategoryDto {
    private Integer categoryCode;
    private String categoryName;
    private String refCategoryCode;
}
