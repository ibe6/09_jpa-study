package com.ibe6;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class CategoryDto {

    private Integer categoryCode;
    private String categoryName;
    private Integer menuCount;

}
