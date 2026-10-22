package com.fsc.supply_chain_common_operations.Models;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_categories")
@Entity
@DiscriminatorValue("PRODUCT_CATEGORY") // Add this line
public class ProductCategory extends Globalrecords {
    @Column(name = "category_code", nullable = false, length = 50)
    private String categoryCode;

    @Column(name = "category_name", nullable = false, length = 150)
    private String categoryName;

    @Column(length = 1000)
    private String description;

    @ManyToOne
    private ProductCategory parentCategory;

    @Column(nullable = false)
    private Boolean active = true;

    private Integer displayOrder;

    private String imageUrl;
}