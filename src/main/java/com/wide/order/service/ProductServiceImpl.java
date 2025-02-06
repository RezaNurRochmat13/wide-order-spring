package com.wide.order.service;

import com.wide.order.configuration.ModelMapperConfig;
import com.wide.order.entity.Category;
import com.wide.order.entity.Product;
import com.wide.order.entity.dto.category.SingleCategoryDto;
import com.wide.order.entity.dto.product.CreateProductDto;
import com.wide.order.entity.dto.product.ListProductDto;
import com.wide.order.entity.dto.product.SingleProductDto;
import com.wide.order.entity.dto.product.UpdateProductDto;
import com.wide.order.exception.ResourceNotFound;
import com.wide.order.repository.CategoryRepository;
import com.wide.order.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapperConfig modelMapper;

    @Override
    public Page<ListProductDto> findAllActiveProducts(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> products = productRepository.findActiveProducts(pageable);
        Page<ListProductDto> listProductDtos = mapperListProductEntityToDto(products, pageable);

        return listProductDtos;
    }

    @Override
    public SingleProductDto findProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Product not found for this id :" + id));
        SingleProductDto singleProductDto = mapperSingleProductEntityToDto(product);
        return singleProductDto;
    }

    @Override
    public Product createProduct(CreateProductDto payload) {
        Product product = new Product();
        Category category = categoryRepository.findById(payload.getCategoryId())
                .orElseThrow(() -> new ResourceNotFound("Category not found for this id :" + payload.getCategoryId()));
        product.setName(payload.getName());
        product.setDescription(payload.getDescription());
        product.setStock(payload.getStock());
        product.setPrice(payload.getPrice());
        product.setCategory(category);

        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, UpdateProductDto payload) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Product not found for this id :" + id));

        product.setName(payload.getName());
        product.setDescription(payload.getDescription());
        product.setStock(payload.getStock());
        product.setPrice(payload.getPrice());

        return productRepository.save(product);
    }

    @Override
    public void destroyProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Product not found for this id :" + id));

        product.setDeletedAt(LocalDateTime.now());

        productRepository.save(product);
    }

    private Page<ListProductDto> mapperListProductEntityToDto(Page<Product> products, Pageable pageable) {
        List<ListProductDto> listProductDtos = new ArrayList<>();

        for (Product product : products.getContent()) {
            Category category = categoryRepository
                    .findById(product.getCategory().getId())
                    .orElseThrow(() -> new ResourceNotFound("Category not found for this id :" + product.getCategory().getId()));
            ListProductDto listProductDto = modelMapper
                    .modelMapper()
                    .map(product, ListProductDto.class);
            SingleCategoryDto categoryDto = modelMapper
                    .modelMapper()
                    .map(category, SingleCategoryDto.class);

            listProductDto.setCategory(categoryDto);
            listProductDtos.add(listProductDto);
        }

        return new PageImpl<>(listProductDtos, pageable, listProductDtos.size());
    }

    private SingleProductDto mapperSingleProductEntityToDto(Product product) {
        SingleProductDto singleProductDto = modelMapper
                .modelMapper()
                .map(product, SingleProductDto.class);
        Category category = categoryRepository
                .findById(product.getCategory().getId())
                .orElseThrow(() -> new ResourceNotFound("Category not found for this id :" + product.getCategory().getId()));
        SingleCategoryDto categoryDto = modelMapper
                .modelMapper()
                .map(category, SingleCategoryDto.class);

        singleProductDto.setCategory(categoryDto);
        return singleProductDto;
    }
}
