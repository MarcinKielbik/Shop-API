package com.marcinkielbik.Shop.API.models;


import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message= "Title is required")
    @Size(max=100, message="Title cannot exceed 100 characters")
    private String title;

    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    private Double price;

    @NotBlank(message = "Image URL is required")
    @Pattern(
            regexp = "^(https?|ftp)://.*$",
            message = "Image must be a valid URL"
    )
    private String image;
}
