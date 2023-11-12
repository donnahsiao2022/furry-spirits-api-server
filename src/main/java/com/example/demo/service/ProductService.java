package com.example.demo.service;

import com.example.demo.config.auditor.CustomAuditorAware;
import com.example.demo.config.exception.CustomizeException;
import com.example.demo.vo.UpdateProductVO;
import com.example.demo.entity.Product;
import com.example.demo.enums.WebError;
import com.example.demo.repository.IProductRepository;
import com.example.demo.vo.CreateProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    CustomAuditorAware customAuditorAware;

    @Autowired
    IProductRepository productRepository;

    public Product findById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> findProductList() {
        return productRepository.findAll();
    }

    public Product findProductByName(String name) {
        return productRepository.findByName(name);
    }

    public Product create(CreateProductVO createProductVO) {

        if (productRepository.findByName(createProductVO.getName()) != null) {
            throw new CustomizeException(WebError.PRODUCT_IS_EXIST);
        }

        Product product = Product.createInstance(
                customAuditorAware.getCurrentAuditor().orElse(""));

        product.setName(createProductVO.getName());
        product.setPrice(createProductVO.getPrice());
        product.setDescription(createProductVO.getDescription());
        product.setFilename(createProductVO.getImageFilename());

        return productRepository.save(product);
    }

    public Product update(UpdateProductVO updateProductVO) {

        Product product = this.findById(updateProductVO.getId());
        if (product == null) {
            throw new CustomizeException(WebError.PRODUCT_NOT_FOUND);
        }

        product.setName(updateProductVO.getName());
        product.setPrice(updateProductVO.getPrice());
        product.setDescription(updateProductVO.getDescription());
        product.setFilename(updateProductVO.getImageFilename());

        return productRepository.save(product);
    }
}
